<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet" type="text/css" href="/css/vistaInicio.css">
<link rel="stylesheet" type="text/css" href="/css/opcionesEvento.css">
<link rel="shortcut icon" href="imagenes/icono.ico" />

<title>Iceblock / Evento</title>

<script src="https://apis.google.com/js/api.js"></script>
<script type="text/javascript">
function authenticate() {
    return gapi.auth2.getAuthInstance()
        .signIn({scope: "https://www.googleapis.com/auth/calendar https://www.googleapis.com/auth/calendar.events"})
        .then(function() { console.log("Sign-in successful"); },
              function(err) { console.error("Error signing in", err); });
  }
  function loadClient() {
    return gapi.client.load("https://content.googleapis.com/discovery/v1/apis/calendar/v3/rest")
        .then(function() { console.log("GAPI client loaded for API"); },
              function(err) { console.error("Error loading GAPI client for API", err); });
  }
  // Make sure the client is loaded and sign-in is complete before calling this method.
  function execute() {
    return gapi.client.calendar.events.insert(${json})
        .then(function(response) {
                // Handle the results here (response.result has the parsed body).
                console.log("Response", response);
              },
              function(err) { console.error("Execute error", err); });
  }
  gapi.load("client:auth2", function() {
    gapi.auth2.init({client_id: "111140053841-fdv5sqcpf9jamk31aiubeldm8gbkv8dg.apps.googleusercontent.com"});
  });

</script>



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

			<div >
			<a href="/Index.jsp"><b >
				<span data-text="E">E</span>
				<span data-text="X">X</span>
				<span data-text="I">I</span>
				<span data-text="T">T</span>
			</b></a>
	</div>
	<div id="foto">
		<img src= ${event_firstURLImage} height="140px" width="200px">
	</div>

	<div id="body">

		<div id="botonticket">
			<a href="${tickets}" STYLE height="50px" width="50px" class="myButton">tickets</a>
		</div>


		<div id="botonLogin">
			<button onclick="authenticate().then(loadClient)" class="myButton">Login</button>
		</div>
		<div id="botonaddtocalendar">
			<button onclick="execute()" class="myButton">add to calendar</button>
		</div>
		


		<div id="botontrips">
			<form id="blablacarSearch" action="BlablacarSearchController"
				method="get">
				Enter departure place : <input type="text" name="departurePlace">
				<input type="hidden" name="eventID" value="${eventID}"/> 
				Enter date of departure : <input type="date" name="departureDate"> <input
					type="submit" name="blablacarSearchBtn" title="search"
					value="search" />
			</form>
		</div>


	</div>




</body>
</html>