<%@ page import="controls.UserControls" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adsy's Maze Game</title>
<%
String actionId = (String)request.getParameter("action");
String room = (String)request.getParameter("room");

UserControls.getInstance().doAction(actionId);
response.sendRedirect("roomNavigator.jsp?startPos=" + room);
%>
</head>
<body>
</body>
</html>