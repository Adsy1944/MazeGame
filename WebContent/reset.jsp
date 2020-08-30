<%@ page import="controls.UserControls" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adsy's Maze Game</title>
<%
UserControls.getInstance().resetGame();
String room = (String)session.getAttribute("start");
response.sendRedirect("roomNavigator.jsp?startPos=" + room);
%>
</head>
<body>

</body>
</html>