<?php include "../inc/dbinfo.inc"; ?>
<?php
$connection = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD);

  if (mysqli_connect_errno()) echo "Failed to connect to MySQL: " . mysqli_connect_error();

  $database = mysqli_select_db($connection, DB_DATABASE);



   $query = "CREATE TABLE `akm_server` (
       `ID` int(11) NOT NULL AUTO_INCREMENT,
       `title` varchar(45) DEFAULT NULL,
       `news` varchar(90) DEFAULT NULL,
 `time` varchar(90) DEFAULT NULL,
       PRIMARY KEY (`ID`),
       UNIQUE KEY `ID_UNIQUE` (`ID`)
     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";

   if(!mysqli_query($connection, $query)) echo("<p>Error creating table.</p>");
?>
