<%@ page import="controls.UserControls" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
int startPosition = UserControls.getInstance().getStartPosition();
response.sendRedirect("startMenu.jsp?start=" + startPosition + "&initialise=true");
%>
</head>
<body>
</body>
</html>