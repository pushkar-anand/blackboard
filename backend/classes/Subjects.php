<?php

require_once __DIR__ . "/../vendor/autoload.php";

class Subjects
{
    private $conn;
    private $table;
    private $DB;
    private $subjectID;
    private $subjectIDField;

    public function __construct($SubjectID)
    {
        $this->DB = new DB();
        $this->conn = $this->DB->getConn();
        $this->subjectID = $SubjectID;

        $this->table = "subjects";
        $this->subjectIDField = "subjectID";
        $this->subjectID = $SubjectID;

    }

    public function getSubjectsDetails()
    {
        $count = $this->DB->getResultCount($this->table, $this->subjectIDField, $this->subjectID);

        if ($count > 0) {
            return $this->DB->fetchRow($this->table, $this->subjectIDField, $this->subjectID);
        } else {
            return false;
        }
    }
}