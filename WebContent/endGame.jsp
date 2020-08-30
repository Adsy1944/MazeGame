<%@ page import="controls.UserControls" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adsy's Maze Game</title>
<%
session.invalidate();
UserControls.getInstance().conClose();
UserControls.getInstance().nullifyMaze();
response.sendRedirect("index.jsp");
%>
</head>
<body>

</body>
</html>