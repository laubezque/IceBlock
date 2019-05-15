<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link href="https://apis.google.com/js/platform.js" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/vistaInicio.css">
<link rel="stylesheet" type="text/css" href="/css/viajeCalendario.css">
<link rel="shortcut icon" href="imagenes/icono.ico" />




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


<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<title>Iceblock / Añadir viaje</title>


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
				<a href="/EventKeywordTicketMasterController">Discover</a> <a
				href="/Calendario.jsp">Calendar</a> <a href="/vistaInicio.jsp">Home</a>
		</div>
	</div>
	<div class="boton" id="botones">
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
	
	<div id="exit">
		<a href="/Index.jsp"><b> <span data-text="E">E</span> 
		<span data-text="X">X</span> <span data-text="I">I</span>
		<span data-text="T">T</span>
		</b></a>
	</div>


	<div id="botones2">



		<div id="boton1">
			<a onclick="authenticate().then(loadClient)" class="myButton">Login</a>
		</div>

		<div id="boton2">
			<a onclick="execute()" class="myButton">Add to calendar</a>
		</div>

		<div id="boton3">
			<a href="/Calendario.jsp" class="myButton">Ir al calendario</a>
		</div>
	</div>


</body>
</html>