<?php
require_once __DIR__ . "/vendor/autoload.php";

$route = new \EasyRoute\Route();

try {
    $route->addMatch('POST', '/teacher/login', __DIR__ . '/controllers/teachers/login.php');

    $route->addMatch('POST', '/student/login', __DIR__ . '/controllers/students/login.php');
    $route->addMatch('GET', '/student/details/semester', __DIR__ . '/controllers/students/details.semester.php');
    $route->addMatch('GET', '/student/details/subject', __DIR__ . '/controllers/students/details.subject.php');

    $route->execute();

} catch (Exception $e) {
}

