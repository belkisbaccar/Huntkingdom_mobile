
<?php
$allowedExts = array("gif", "jpeg", "jpg", "png");
$temp = explode(".", $_FILES["file"]["name"]);
$extension = end($temp);
 

if ((($_FILES["file"]["type"] == "image/gif") || ($_FILES["file"]["type"] == "image/jpeg") || ($_FILES["file"]["type"] == "image/jpg") || ($_FILES["file"]["type"] == "image/pjpeg") || ($_FILES["file"]["type"] == "image/x-png") || ($_FILES["file"]["type"] == "image/png")) && ($_FILES["file"]["size"] < 5000000) && in_array($extension, $allowedExts)) {
    if ($_FILES["file"]["error"] > 0) {
        $named_array = array("Response" => array(array("Status" => "error")));
        echo json_encode($named_array);
    } else {
         $image = $_FILES['file']['name'];
$image_temp =$_FILES['file']['tmp_name'];
$target='images/'.substr($image_temp, 16,4).".".$extension;
move_uploaded_file($image_temp, "$target");


        $Path = $_FILES["file"]["name"];
        $named_array = array("Response" => array(array("Status" => "ok")));
        echo json_encode(substr($image_temp, 16,4).".".$extension);
    }
} else {
    $named_array = array("Response" => array(array("Status" => "invalid")));
    echo json_encode($named_array);
}

?>