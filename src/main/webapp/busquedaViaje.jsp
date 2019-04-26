<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busqueda de Viajes</title>
</head>
<body>
	<form action="LoginController" method="post">
		Enter departure place : <input type="text" name="departurePlace"> <BR>
		Enter arrival place : <input type="text" name="arrivalPlace"> <BR>
		Enter date of departure : <input type="date" name = "departureDate"><BR>
		<input type="submit" />
	</form>

</body>
</html>