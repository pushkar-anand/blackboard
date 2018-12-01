<?php

require_once __DIR__ . "/../vendor/autoload.php";

class Student
{

    private $conn;
    private $table;
    private $DB;
    private $email;
    private $emailField;
    private $tokenField;
    private $tokenGenField;


    public function __construct(string $email)
    {
        $this->DB = new DB();
        $this->conn = $this->DB->getConn();
        $this->table = "students";

        $this->email = $email;
        $this->emailField = "email";
        $this->tokenField = "token";
        $this->tokenGenField = "tokenGen";
    }

    public function getStudent()
    {
        $count = $this->DB->getResultCount($this->table, $this->emailField, $this->email);
        if ($count > 0) {
            return $this->DB->fetchRow($this->table, $this->emailField, $this->email);
        } else {
            return false;
        }
    }

    public function updateToken(string $token, int $token_gen_time)
    {
        $this->DB->updateSingle($this->table, $this->tokenField, $token, $this->emailField, $this->email);
        $this->DB->updateSingle($this->table, $this->tokenGenField, $token_gen_time, $this->emailField, $this->email);
    }

    public function verifyToken(int $student_id, string $token)
    {
        $count = $this->DB->getResultCount($this->table, $this->emailField, $this->email);
    }


}