<?php include "../inc/dbinfo.inc"; ?>
<?php
$connection = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD);

  if (mysqli_connect_errno()) echo "Failed to connect to MySQL: " . mysqli_connect_error();

  $database = mysqli_select_db($connection, DB_DATABASE);


if($_SERVER["REQUEST_METHOD"]=="POST"){

  $title=$_POST["title"];
  $news=$_POST["news"];
  $time=$_POST["time"];

  $sql="INSERT INTO `akm_server` (title,news,time) VALUES ('$title','$news','$time');";
  if(!mysqli_query($connection, $sql)) echo("<p>Error inserting table .</p>");

  mysqli_close($connection);

}

?>
