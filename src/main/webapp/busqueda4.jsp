<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test='${empty sessionScope["GoogleCalendar-token"]}'>
    <c:redirect url = "/AuthController/GoogleCalendar"/>
</c:if>

<h1>Spotify playlist creation</h1>
<div class="container">

    <p class="message"></p>

    <form action="/CalendarDeleteController" method="post">

        <label for="name">Name:</label>
		<input type="text" Name="id"
		/>
        <div class="bottom_links">
            <button type="submit" class="button">Create playlist in Spotify</button>
            <button type="button" class="button">Cancel</button>
        </div>
    </form>
    <form action="/CalendarGetListController" method="get">

        <div class="bottom_links">
            <button type="submit" class="button">Create playlist in Spotify</button>
            <button type="button" class="button">Cancel</button>
        </div>
    </form>
</div>

