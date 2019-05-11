<%@page import="aiss.controller.EventKeywordTicketMasterController"%>
<%@page import="aiss.model.resource.TicketmasterResource"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html ; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>

<link href="https://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet">
<link href="https://apis.google.com/js/platform.js" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet" type="text/css" href="/css/vistaEvento.css">


<title>Eventos IceBlock</title>

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
</head>
<body>
<div class="parte1">
	<div id="content">
		<span class="slide"> <a href="#" onclick="openSlideMenu()">
				<i class="fas fa-bars"></i>
		</a>
		</span>
		<div class="nav" id="menu">
			<a href="#" class="close" onclick="closeSlideMenu()"> 
			<i class="fas fa-times"></i></a> 
			<a href="#">Discover</a> 
			<a href="/Calendario.jsp">Calendar</a> 
			<a href="/vistaInicio.jsp">Home</a>
		</div>
	</div>
	

	<div class="logout">
		<b href="#"> <span data-text="L">L</span> <span data-text="O">O</span>
			<span data-text="G">G</span> <span data-text="O">O</span> <span
			data-text="U">U</span> <span data-text="T">T</span>
		</b>
  </div>
</div>
<table class="indice">
<tr >					
					<th class="indice1">Fecha</th>
					<th class="indice2">Hora</th>
					<th class="indice3">Nombre</th>
          <th class="indice4">Localización</th>
          <th class="indice5"></th>
        </tr>
        </table>
  <table class="parte2">
				
          <c:forEach items="${tablaEventos}" var="event">
					<tr class="eventos" >
						<td class="eventos1">${event.dates2Date}</td>
						<td class="eventos2">${event.dates2Hour}</td>
						<td class="eventos3">${event.name}</td>
						<td class="eventos4">${event.embedded.firstVenues.city.name}</td>
						<td class="eventos5">
							<form action="CalendarInsertController" method="post">
							<input type="hidden" name="event_ID" value="${event.id}" />							
							<button type="submit" >Go</button>
						</form></td>
          			</tr>       
        </c:forEach>

	</table>
</body>
</html>