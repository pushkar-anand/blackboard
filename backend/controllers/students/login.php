<?php

require_once __DIR__ . "/../../vendor/autoload.php";

use PhpUseful\EasyHeaders;
use PhpUseful\Functions;

if( isset($_POST['email']) && isset($_POST['password'])) {

    $email = Functions::escapeInput($_POST['email']);
    $pwd = $_POST['password'];

    $student = new Student($email);
    $studentDetails = $student->getStudent();

    if($studentDetails !== false && $studentDetails !== null) {

        if(password_verify($pwd, $studentDetails['password'])) {

            $random = Functions::randomString(25);
            $time = time();

            $student->updateToken($random, $time);
            $student = new Student($email);
            $studentDetails = $student->getStudent();
            unset($studentDetails['password']);

            $sem_id = $studentDetails['semesterID'];

            $semester = new Semester($sem_id);
            $semesterDetails = $semester->getSemesterDetails();

            if ($semesterDetails !== false && $semesterDetails !== null) {
                $studentDetails["semesterInfo"] = $semesterDetails;
            }

            EasyHeaders::json_header();
            echo json_encode($studentDetails);
        } else {
            EasyHeaders::unauthorized();
        }

    } else {
        EasyHeaders::not_found();
    }


} else {
    EasyHeaders::bad_request();
}