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


<!-- <script type="text/javascript" >

	 request.setParameter("event_ID","345");
	 String id = request.getParameter("event_ID");
	

</script> -->

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
				class="fas fa-times"></i></a> <a href="#">Discover</a> <a href="#">My
				future events</a> <a href="#">Calendar</a> <a href="#">Home</a>
		</div>
	</div>
	<div>
		<ul>
			<li><a href="#">SPORTS</a></li>
			<li><a href="#">CONCERTS</a></li>
			<li><a href="#">OTHERS</a></li>
		</ul>
	</div>

	<div>
		<b href="#"> <span data-text="L">L</span> <span data-text="O">O</span>
			<span data-text="G">G</span> <span data-text="O">O</span> <span
			data-text="U">U</span> <span data-text="T">T</span>
		</b>
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
				<!--  <input type="submit" name = "blablacarSearchBtn" title = "search trips" value = "search"
			  href="#" class="myButton" /> -->

			</form>
		</div>


	</div>




</body>
</html>