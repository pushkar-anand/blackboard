<?php

if (isset($_GET['studentID']) && isset($_GET['token'])) {

    $student_id = $_GET['studentID'];

} else {

    \PhpUseful\EasyHeaders::bad_request();
}