<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>page</title>
  <link rel="stylesheet" type="text/css" href="2.page.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
  <title>menu</title>
  <link rel="stylesheet" type="text/css" href="menu15.css">
  <link rel="stylesheet" type = "text/css" href = "/css/vistaInicio.css">
  <script type="text/javascript">
        function openSlideMenu(){
            document.getElementById("menu").style.width = "250px";
            document.getElementById("content").style.marginLeft = "250px";
        }
        function closeSlideMenu(){
            document.getElementById("menu").style.width = "0px";
            document.getElementById("content").style.marginLeft = "0px";
        }
    </script>
     

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>

    <div id="content">
        <span class="slide">
            <a href="#" onclick="openSlideMenu()">
                <i class="fas fa-bars"></i>
            </a>
        </span>
        <div class="nav" id="menu">
            <a href="#" class="close" onclick="closeSlideMenu()">
                <i class="fas fa-times"></i></a>
            <a href="#">Discover</a>
            <a href="#">My future events</a>
            <a href="/Calendario.jsp">Calendar</a>
            <a href="#">Home</a>
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
			<b href="#">
				<span data-text="L">L</span>
				<span data-text="O">O</span>
				<span data-text="G">G</span>
				<span data-text="O">O</span>
				<span data-text="U">U</span>
				<span data-text="T">T</span>
			</b>
	</div>




</body>
</html>