<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet" type="text/css" href="2.page.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet" type="text/css" href="/css/vistaViajes.css">
<link rel="stylesheet" type="text/css" href="/css/vistaInicio.css">

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

	<div id="tabla" class="datagrid">
		<table>

			<thead>
				<tr>

					<th>Departure</th>
					<th>Arrival</th>
					<th>Date</th>
					<th>Price</th>
					<th>Seats Left</th>
					<th>Link</th>
					
				</tr>
			</thead>
		<!-- 	<div id="pie">
				<tfoot>
					<tr>
						<td colspan="5">
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
				</tfoot>
			</div>
			 -->
						<c:forEach items="${selectedTrips}" var="trip">
			
			<tbody>
				<tr>

					<td>${trip.departurePlace.cityName}</td>
					<td>${trip.arrivalPlace.cityName}</td>
					<td>${trip.departureDate}</td>
					<td>${trip.price.value} ${trip.price.currency}</td>
					<td>${trip.seatsLeft}</td>
					<td><a href="${trip.links.front}">buy</a></td>
					
				</tr>
				
			<!-- 	<tr class="alt">
					<td>Sevilla</td>
					<td>Madrid</td>
					<td>hoy</td>
					<td>100 eu</td>
					<td>2</td>
					
				</tr>
				<tr>
					<td>data</td>
					<td>data</td>
					<td>data</td>
					<td>data</td>
					<td>data</td>
				</tr>
				<tr class="alt">
					<td>data</td>
					<td>data</td>
					<td>data</td>
					<td>data</td>
					<td>data</td>
				</tr>
				<tr>
					<td>data</td>
					<td>data</td>
					<td>data</td>
					<td>data</td>
					<td>data</td>
				</tr> -->
			
			</tbody>
			</c:forEach>
			
		</table>
	</div>


</body>












</html>
