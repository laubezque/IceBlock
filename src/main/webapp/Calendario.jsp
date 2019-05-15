<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <link href="https://apis.google.com/js/platform.js" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/vistaCalendario.css">   
	<link rel="stylesheet" type="text/js" href="/JavaScript/Scripts.js">
	<link rel="shortcut icon" href="imagenes/icono.ico" />
	
    
    
    
<meta charset="UTF-8">
<title>Iceblock / Calendario</title>


</head>
<body>

    <header>
            <h1 class="tituloInicio" id="titulo">Calendario Ice block</h1>
            <img class="logo" src="imagenes/Logo_transpa.png" alt="Logo Ice block"> 
    </header>
    
    <main class="main">
	<div class="container">
		<a class="btn" href="/vistaInicio.jsp"> <svg width="277" height="62">
                    <defs>
                        <linearGradient id="grad1">
                            <stop stop-color="white" />
                            <stop stop-color="white" />
                        </linearGradient>
                    </defs>
                    <rect x="5" y="5" rx="25" fill="none"
					stroke="url(#grad1)" width="266" height="50"></rect>
                </svg> <span>Volver al inicio</span>
		</a>
	</div>
	<div class="calendario">
            <iframe src="https://calendar.google.com/calendar/b/1/embed?showTitle=0&amp;showPrint=0&amp;showCalendars=0&amp;showTz=0&amp;height=600&amp;wkst=2&amp;bgcolor=%23c0c0c0&amp;src=iceblockproyectoaiss%40gmail.com&amp;color=%231B887A&amp;ctz=Europe%2FMadrid" style="border:solid 1px #777" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>  
        </div>
        <div class="quickAdd">
            <div>
            <p>Añadir un evento simple</p>
            </div>
            <div>
                <form action="/CalendarQuickAddController" method="post">
                    <input type="text" Name="string" placeholder="evento hh:mm d/mm/YYYY "/>
                        <div class="bottom_links">
                            <button type="submit" class="butn">Crear evento</button>
                        </div>
                </form>
            </div>       
        </div>
        <div class="delete">
            <div>
                <p>Eliminar un evento</p>
            </div>
            <div>
                <form action="/CalendarDeleteController" method="post">
                    <input type="text" Name="id" placeholder="ID del evento"/>
                        <div class="bottom_links">
                            <button type="submit" class="butn">Eliminar evento</button>
                        </div>
                </form>
            </div>
        </div>
    </main>

</body>
</html>