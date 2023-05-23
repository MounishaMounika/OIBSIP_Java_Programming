<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Number Guessing Game</title>
<link href="css/myStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
<div class="box">
<h2 >Guess the number!</h2>
<h3>Enter a number between 1 to 100</h3>
<form action="Game" method="POST">
<pre>
<input type="text" name="number">
<br>
<input type="submit" value="Check Your Luck!">
</pre>
</form>
</div>
</div>
</body>
</html>
