<%@ page import="sql.SqlConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="controls.MazeBuilder" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
SqlConnection.getInstance().startDatabaseConnection("mazegame", "@2Cellos");
MazeBuilder.getInstance().constructMaze(1);
%>

</head>
<body>

</body>
</html>