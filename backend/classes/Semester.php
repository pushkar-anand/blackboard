<?php
require_once __DIR__ . "/../vendor/autoload.php";

class Semester
{
    private $conn;
    private $table;
    private $DB;
    private $semesterID;
    private $semesterIDField;

    public function __construct($semesterID)
    {
        $this->DB = new DB();
        $this->conn = $this->DB->getConn();
        $this->semesterID = $semesterID;

        $this->table = "semesters";
        $this->semesterIDField = "semesterID";

    }

    public function getSemesterDetails()
    {
        $count = $this->DB->getResultCount($this->table, $this->semesterIDField, $this->semesterID);

        if ($count > 0) {
            return $this->DB->fetchRow($this->table, $this->semesterIDField, $this->semesterID);
        } else {
            return false;
        }
    }
}