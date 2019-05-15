<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet" type="text/css" href="/css/vistaInicio.css">
	<!-- <link rel="stylesheet" type="text/css" href="/css/vistaPrincipal.css"> -->
<link rel="shortcut icon" href="imagenes/icono.ico" />


<meta charset="UTF-8">

<title>Iceblock / Inicio</title>


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


<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
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
				 <a	href="/Calendario.jsp">Calendar</a> <a href="/vistaInicio.jsp">Home</a>
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


      
      
       <main class="main">
       
           
        
        <div class="search-box">
                <form action="EventKeywordTicketMasterController"  method="post">
				
				
					<input type="text" placeholder=" " id="keyword" name="key_word" /><span></span>
				
				</form>
        </div>
          
    </main>  	
       
	<div id="exit">
		<a href="/Index.jsp"><b> <span data-text="E">E</span> <span
				data-text="X">X</span> <span data-text="I">I</span> <span
				data-text="T">T</span>
		</b></a>
	</div>




</body>
</html>