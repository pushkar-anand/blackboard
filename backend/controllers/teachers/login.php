<?php

require_once __DIR__ . "/../../vendor/autoload.php";

use PhpUseful\EasyHeaders;
use PhpUseful\Functions;

if( isset($_POST['email']) && isset($_POST['password'])) {

    $email = Functions::escapeInput($_POST['email']);
    $pwd = $_POST['password'];

    $teachers = new Teachers($email);
    $studentDetails = $teachers->getTeachers();

    if($studentDetails !== false && $studentDetails !== null) {

        if(password_verify($pwd, $studentDetails['password'])) {

            $random = Functions::randomString(25);
            $time = time();

            $teachers->updateToken($random, $time);
            $teachers = new Teachers($email);
            $studentDetails = $teachers->getTeachers();
            unset($studentDetails['password']);

            EasyHeaders::json_header();
            echo json_encode($studentDetails);
        }

    } else {
        EasyHeaders::not_found();
    }


} else {
    EasyHeaders::bad_request();
}