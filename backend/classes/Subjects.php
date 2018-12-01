<?php

require_once __DIR__ . "/../vendor/autoload.php";

class Subjects
{
    private $conn;
    private $table;
    private $DB;
    private $semesterID;
    private $semesterIDField;
    private $SubjectID;
    private $SubjectIDField;

    public function __construct($SubjectID)
    {
        $this->DB = new DB();
        $this->conn = $this->DB->getConn();
        $this->subjectID = $SubjectID;

        $this->table = "Subjects";
        $this->semesterIDField = "SubjectID";

    }

    public function getSubjectsDetails()
    {
        $count = $this->DB->getResultCount($this->table, $this->SubjectIDField, $this->SubjectID);

        if ($count > 0) {
            return $this->DB->fetchRow($this->table, $this->SubjectIDField, $this->SubjectID);
        } else {
            return false;
        }
    }
}