<?php

require_once __DIR__ . "/../../vendor/autoload.php";

if (isset($_GET['email']) && isset($_GET['token'])) {

    $email = \PhpUseful\Functions::escapeInput($_GET['email']);
    $token = \PhpUseful\Functions::escapeInput($_GET['token']);

    $student = new Student($email);
    if ($student->verifyToken($token)) {
        $studentDetails = $student->getStudent();
        $sem_id = $studentDetails['semesterID'];

        $semester = new Semester($sem_id);
        $semesterDetails = $semester->getSemesterDetails();

        if ($semesterDetails !== false && $semesterDetails !== null) {
            $subJSON = $semesterDetails['subjects'];
            $subArray = json_decode($subJSON);
            $x = array();

            for ($i = 0; $i < count($subArray); $i++) {

                $subject = new Subjects($subArray[$i]);
                array_push($x, $subject->getSubjectsDetails());
            }

            \PhpUseful\EasyHeaders::json_header();
            echo json_encode($x);

        } else {
            \PhpUseful\EasyHeaders::not_found();
        }

    } else {
        \PhpUseful\EasyHeaders::unauthorized();
    }

} else {

    \PhpUseful\EasyHeaders::bad_request();
}