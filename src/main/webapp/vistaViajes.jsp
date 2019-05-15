<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet" type="text/css" href="/css/vistaViajes.css">
<link rel="stylesheet" type="text/css" href="/css/vistaInicio.css">
	<link rel="shortcut icon" href="imagenes/icono.ico" />


<meta charset="UTF-8">

<title>Iceblock / Viajes</title>

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
			<a href="/EventKeywordTicketMasterController">Discover</a>
            <a href="/Calendario.jsp">Calendar</a>
            <a href="/vistaInicio.jsp">Home</a>
		</div>
	</div>
	<div class="boton" id = "botones">
		<ul>
			<form action="EventKeywordTicketMasterController" method="post">

				<li><a><button type="submit" name="key_word" value="SPORTS"
							class="butn">SPORTS</button></a></li>
			</form>
			<form action="EventKeywordTicketMasterController" method="post">

				<li><a><button type="submit" name="key_word"
							value="CONCERTS" class="butn">CONCERTS</button></a></li>
			</form>
			<form action="EventKeywordTicketMasterController" method="post">

				<li><a><button type="submit" name="key_word" value="OTHERS"
							class="butn">OTHERS</button></a></li>
			</form>
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
			
		<!-- 	<tfoot>
				<tr>
					<td colspan="4">
					<div id="paging">
					<ul>
						<li><a href="#"><span>Previous</span></a></li>
						<li><a href="#" class="active"><span>1</span></a></li>
						<li><a href="#"><span>2</span></a></li>
						<li><a href="#"><span>3</span></a></li>
						<li><a href="#"><span>4</span></a></li>
						<li><a href="#"><span>5</span></a></li>
						<li><a href="#"><span>Next</span></a></li>
					</ul>
					</div>
				</tr>
			</tfoot> -->
		</table>
	</div>


</body>


</html>
