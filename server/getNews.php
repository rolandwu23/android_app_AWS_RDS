<?php include "../inc/dbinfo.inc"; ?>
<?php
$connection = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD);

  if (mysqli_connect_errno()) echo "Failed to connect to MySQL: " . mysqli_connect_error();

  $database = mysqli_select_db($connection, DB_DATABASE);


//fetch table rows from mysql db
$sql_2= "SELECT * FROM `akm_server`";
$result = mysqli_query($connection, $sql_2)
or die("Error in Selecting " . mysqli_error($connection));
//create an array
$emparray[] = array();
while($row =mysqli_fetch_assoc($result))
{
    $emparray[] = $row;
}
//print_r($emparray);
echo json_encode($emparray);
//close the db connection
mysqli_close($connection);
?>
