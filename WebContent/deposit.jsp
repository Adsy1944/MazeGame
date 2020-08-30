<%@ page import="controls.UserControls" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adsy's Maze Game</title>
<%
String room = (String)request.getParameter("room");
boolean deposit = Boolean.parseBoolean((String)request.getParameter("deposit"));

UserControls.getInstance().setDeposit(deposit, room);

response.sendRedirect("roomNavigator.jsp?startPos=" + room);
%>

</head>
<body>

</body>
</html>