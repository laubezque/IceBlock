<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search results</title>
</head>
<body>


<fieldset id="blablacar">
<legend>Blablacar search for <c:out value="${param.departurePlace}"/></legend>
<c:forEach items="${requestScope.trip}" var="trip">
	<span>Trip : <c:out value="${trip.departurePlace}"/></span><br/>
</c:forEach>
</fieldset>

<fieldset id="flickr">
<legend>Flickr search for <c:out value="${param.searchQuery}"/></legend>

</fieldset>

</body>
</html>