<?php
$servername = "localhost";
$username = "sa";
$password = "!password123";
$dbname = "rd";

	$conn = new mysqli($servername, $username, $password, $dbname);
	if ($conn->connect_error) {
    	die("Connection failed: " . $conn->connect_error);
	} 
	//echo 'Connected successfully';

	$query = sprintf("SELECT Target FROM Address 
    	WHERE RA='%s'",
    	$_GET['id']);
	//echo $query;

	$result = $conn->query($query);	

	//echo $result->num_rows;

	if ($result->num_rows > 0) {
    	while($row = $result->fetch_assoc()) {
    		header('Location: ' . $row["Target"]);
    		//header('Refresh: 3; url='.$row["Target"]);
    	}

	} else {
    	echo "Can't find website";
	}
	exit;
$conn->close();
?>