<%@ page import="controls.UserControls" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adsy's Maze Game</title>
<%
String name = (String)session.getAttribute("user");
UserControls.getInstance().submitScore(name);
response.sendRedirect("endGame.jsp");
%>
</head>
<body>

</body>
</html>