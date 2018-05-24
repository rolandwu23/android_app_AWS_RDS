<?php

  /* Connect to MySQL and select the database. */
  $connection = mysqli_connect("localhost", "root", "","android");

  if (mysqli_connect_errno()) echo "Failed to connect to MySQL: " . mysqli_connect_error();



  $sql = "INSERT INTO `akm_server` (`title`, `news`,`time`) VALUES ('Apple', 'Apple has sth','27 August 2009');";

   if(!mysqli_query($connection, $sql)) echo("<p>Error adding employee data.</p>");


$sql_2= "SELECT * FROM `akm_server`";
$result = mysqli_query($connection, $sql_2)
or die("Error in Selecting " . mysqli_error($connection));
//create an array
// $emparray[] = array();
while($row =mysqli_fetch_assoc($result))
{
    $emparray[] = $row;
}
//print_r($emparray);
echo json_encode($emparray);
//close the db connection
mysqli_close($connection);
?>
