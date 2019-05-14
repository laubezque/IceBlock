<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>page</title>
<link rel="stylesheet" type="text/css" href="2.page.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet" type="text/css" href="/css/vistaInicio.css">
<link rel="stylesheet" type="text/css" href="/css/opcionesEvento.css">

<script type="text/javascript">
	function openSlideMenu() {
		document.getElementById("menu").style.width = "250px";
		document.getElementById("content").style.marginLeft = "250px";
	}
	function closeSlideMenu() {
		document.getElementById("menu").style.width = "0px";
		document.getElementById("content").style.marginLeft = "0px";
	}
</script>


	
<%String eventID = request.getParameter("event_ID");%>
<%String url = request.getParameter("event_firstURLImage");%>	



<title>menu</title>



</head>
<body>

	<div id="content">

		<span class="slide"> <a href="#" onclick="openSlideMenu()">
				<i class="fas fa-bars"></i>
		</a>
		</span>
		<div class="nav" id="menu">
			<a href="#" class="close" onclick="closeSlideMenu()"> <i
				class="fas fa-times"></i></a> 
			<a href="/Discover.jsp">Discover</a>
            <a href="/Calendario.jsp">Calendar</a>
            <a href="/vistaInicio.jsp">Home</a>
		</div>
	</div>
	<div>
		<ul>
		<form action="EventKeywordTicketMasterController">
			<input type="hidden" name="Sports">
			<li><a href="#"><input type="submit" name="Concerts"></a></li>
		</form>
			<li><a href="#">CONCERTS</a></li>
			<li><a href="#">OTHERS</a></li>
		</ul>
	</div>

			<div >
			<a href="/Index.jsp"><b >
				<span data-text="E">E</span>
				<span data-text="X">X</span>
				<span data-text="I">I</span>
				<span data-text="T">T</span>
			</b></a>
	</div>
	<div id="foto">
		<img src= <%=url %> height="140px" width="200px">
	</div>

	<div id="body">

		<div id="botonticket">
			<a href="#" STYLE height="50px" width="50px" class="myButton">tickets</a>
		</div>

		<div id="botonaddtocalendar">
			<a href="#" class="myButton">add to calendar</a>
		</div>


		<div id="botontrips">
			<form id="blablacarSearch" action="BlablacarSearchController"
				method="get">
				Enter departure place : <input type="text" name="departurePlace">
				<input type="hidden" name="eventID" value=" <%= eventID %>"/> 
				Enter date of departure : <input type="date" name="departureDate"> <input
					type="submit" name="blablacarSearchBtn" title="search"
					value="search" />
			</form>
		</div>


	</div>




</body>
</html>