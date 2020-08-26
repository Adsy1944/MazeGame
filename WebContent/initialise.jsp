<%@ page import="controls.UserControls" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
boolean initialise = UserControls.getInstance().initialiseMaze(1);
if (initialise == true) {
	response.sendRedirect("startMenu.jsp?message=Maze built successfully&initialise=true");
}
else {
	response.sendRedirect("startMenu.jsp?message=Maze failed to build!&initialise=false");
}
%>
</head>
<body>

</body>
</html>