<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet" type="text/css" href="/css/vistaViajes.css">
<link rel="stylesheet" type="text/css" href="/css/vistaInicio.css">

<meta charset="UTF-8">


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
			<li><a href="#">SPORTS</a></li>
			<li><a href="#">CONCERTS</a></li>
			<li><a href="#">OTHERS</a></li>
		</ul>
	</div>

			<b href="/Index.jsp">
				<span data-text="E">E</span>
				<span data-text="X">X</span>
				<span data-text="I">I</span>
				<span data-text="T">T</span>
			</b>

	<div id="tabla" class="datagrid">
		<table>

			<thead>
				<tr>

					<th>Departure</th>
					<th>Arrival</th>
					<th>Date</th>
					<th>Price</th>
					<th>Seats Left</th>
					<th>Añadir</th>
					<th>Link</th>
					
				</tr>
			</thead>

						<c:forEach items="${selectedTrips}" var="trip">
			
			<tbody>
				<tr>

					<td>${trip.departurePlace.cityName}</td>
					<td>${trip.arrivalPlace.cityName}</td>
					<td>${trip.departureDate}</td>
					<td>${trip.price.value} ${trip.price.currency}</td>
					<td>${trip.seatsLeft}</td>
					<td>
							<form action="/CalendarInsertControllerBlablacar" method="post">
							<input type="hidden" name="location1" value="${trip.departurePlace.cityName}" />	
							<input type="hidden" name="location2" value="${trip.arrivalPlace.cityName}" />
							<input type="hidden" name="fechaInicio" value="${trip.departureDate}" />
							<button type="submit" >Añadir</button>
					</form></td>
					<td><a href="${trip.links.front}">buy</a></td>
					
				</tr>
			</tbody>
			</c:forEach>
			
		</table>
	</div>


</body>


</html>
