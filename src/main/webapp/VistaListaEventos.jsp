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
<link rel="stylesheet" type="text/css" href="/css/vistaListaEvento.css">



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
			<a href="/Discover.jsp">Discover</a>
            <a href="/Calendario.jsp">Calendar</a>
            <a href="/vistaInicio.jsp">Home</a>
		</div>
	</div>
	

		<div >
			<a href="/Index.jsp"><b >
				<span data-text="E">E</span>
				<span data-text="X">X</span>
				<span data-text="I">I</span>
				<span data-text="T">T</span>
			</b></a>
	</div>
</div>
<div id="tabla" class="datagrid">
		<table>

			<thead>
				<tr>

					<th>Fecha</th>
					<th>Hora</th>
					<th>Nombre</th>
					<th>Localización</th>
					<th>More Info</th>
					
				</tr>
			</thead>

  
				
          <c:forEach items="${tablaEventos}" var="event">
          		<tbody>
					<tr>
						<td>${event.dates2Date}</td>
						<td>${event.dates2Hour}</td>
						<td>${event.name}</td>
						<td>${event.embedded.firstVenues.city.name}</td>
						<td>
							<form action="/CalendarInsertController" method="post">
							<input type="hidden" name="event_ID" value="${event.id}" />	
							<input type="hidden" name="event_firstURLImage" value="${event.firstURLImage}" />							
							<button type="submit" >More info</button>
						</form></td>
          			</tr>  
          		</tbody>     
        </c:forEach>

	</table>
</div>
</body>
</html>