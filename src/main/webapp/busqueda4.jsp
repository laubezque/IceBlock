<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <link href="https://apis.google.com/js/platform.js" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/vistaCalendario.css">   
	<link rel="stylesheet" type="text/js" href="/JavaScript/Scripts.js">
	<link rel="shortcut icon" href="imagenes/icono.ico" />
	
    
    
    
<meta charset="ISO-8859-1">
<title>Iceblock / Calendario</title>

<script src="https://apis.google.com/js/api.js"></script>

<script>
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
    return gapi.client.calendar.events.insert(${melendi})
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





</head>
<body>

    <header>
            <h1 class="tituloInicio" id="titulo">Calendario Ice block</h1>
            <img class="logo" src="imagenes/Logo_transpa.png" alt="Logo Ice block"> 
    </header>
    
    <main class="main">
    
    <button onclick="authenticate().then(loadClient)">authorize and load</button>
	<button onclick="execute()">execute</button>
	<p>${melendi}</p>
   
</main>

</body>
</html>