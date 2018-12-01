<?php


if (isset($_GET['email']) && isset($_GET['token'])) {

    $email = \PhpUseful\Functions::escapeInput($_GET['email']);

    $student = new Student($email);


} else {

    \PhpUseful\EasyHeaders::bad_request();
}