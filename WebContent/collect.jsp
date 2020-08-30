<%@ page import="controls.UserControls" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adsy's Maze Game</title>
<%
String treasureId = (String)request.getParameter("value");
System.out.println("Collecting Treasure ID: " + treasureId);
String roomId = (String)request.getParameter("room");

UserControls.getInstance().collectTreasure(roomId, treasureId);

response.sendRedirect("roomNavigator.jsp?startPos=" + roomId);

%>
</head>
<body>

</body>
</html>