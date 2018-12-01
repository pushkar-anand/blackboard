<?php
require_once __DIR__ . "/../vendor/autoload.php";

class DB
{

    private $conn;

    public function __construct()
    {
        $this->conn = new mysqli(DB_SERVER, DB_USER, DB_PASSWORD, DB_NAME);
        if ($this->conn->error) {
            error_log("Error: " . $this->conn->error);
            \PhpUseful\EasyHeaders::service_unavailable();
            die(1);
        }
    }

    /**
     * @return mysqli
     */
    public function getConn(): mysqli
    {
        return $this->conn;
    }


    public function insert(string $table, array $fields, string $params, string ...$vals)
    {
        $fieldsSTR = implode(",", $fields);
        $c = str_repeat("?, ", count($fields));
        $placeholders = rtrim($c, ", ");
        $query = "INSERT INTO $table($fieldsSTR) VALUES($placeholders)";
        $stmt = $this->conn->prepare($query);
        $stmt->bind_param($params, $vals);
        $stmt->execute();
    }

    public function updateSingle(string $table, string $field, string $newValue, string $where_field, string $match): bool
    {

        $query = "UPDATE $table SET $field = ? WHERE $where_field = ?";
        $stmt = $this->conn->prepare($query);
        $stmt->bind_param('ss', $newValue, $match);
        return $stmt->execute();

    }

    public function getResultCount(string $table, string $where_field, string $match)
    {
        $query = "SELECT * FROM $table WHERE $where_field = ? ";
        error_log("executing query: $query");
        $stmt = $this->conn->prepare($query);
        $stmt->bind_param('s', $match);
        $stmt->execute();
        $stmt->store_result();
        $num_of_rows = $stmt->num_rows;
        $stmt->free_result();
        $stmt->close();
        return $num_of_rows;
    }

    public function fetchSingleField(string $table, string $select_field, string $where_field, string $match): string
    {
        $query = "SELECT $select_field FROM $table WHERE $where_field = ? ";
        error_log("executing query: $query");
        $stmt = $this->conn->prepare($query);
        $stmt->bind_param('s', $match);
        $stmt->execute();
        $stmt->store_result();
        $stmt->bind_result($result);
        $stmt->fetch();
        $return = $result;
        $stmt->free_result();
        $stmt->close();
        return $return;
    }

    public function fetchRow(string $table, string $where_field, string $match)
    {
        $query = "SELECT * FROM $table WHERE $where_field = ?";
        $stmt = $this->conn->prepare($query);
        $stmt->bind_param("s", $match);
        $stmt->execute();
        $res = $stmt->get_result();
        return $res->fetch_assoc();
    }


}