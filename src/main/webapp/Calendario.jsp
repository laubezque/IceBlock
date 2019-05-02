<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <link href="https://apis.google.com/js/platform.js" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/vistaCalendario.css">
    
<meta charset="ISO-8859-1">
<title>Calendario</title>

</head>
<body>

    <header>
            <h1 class="tituloInicio" id="titulo">Calendario Ice block</h1>
            <img class="logo" src="imagenes/Logo_transpa.png" alt="Logo Ice block"> 
    </header>
    
    <main class="main">
        <div class="calendario">
            <iframe src="https://calendar.google.com/calendar/b/1/embed?showTitle=0&amp;showPrint=0&amp;showCalendars=0&amp;showTz=0&amp;height=600&amp;wkst=2&amp;bgcolor=%23c0c0c0&amp;src=iceblockproyectoaiss%40gmail.com&amp;color=%231B887A&amp;ctz=Europe%2FMadrid" style="border:solid 1px #777" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>  
        </div>
        <div class="quickAdd">
            <div>
            <p>Añadir un evento simple</p>
            </div>
            <div>
                <form action="/CalendarQuickAddController" method="post">
                    <input type="text" Name="string"/>
                        <div class="bottom_links">
                            <button type="submit" class="button">Crear evento</button>
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
                            <button type="submit" class="button">Eliminar evento</button>
                        </div>
                </form>
            </div>
        </div>
    </main>

</body>
</html>