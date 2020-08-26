<%@ page import="controls.UserControls" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
String user = request.getParameter("userName");
if (user == null) {
	user = "";
}
session.setAttribute("user", user);
boolean connected = false;
connected = UserControls.getInstance().startConnection();
System.out.println("Connected: " + connected);

if (connected == true) {
	response.sendRedirect("startMenu.jsp");
}
else if (connected == false) {
	response.sendRedirect("index.jsp?message=Couldn't connect to database");
}
%>
</head>
<body>

</body>
</html>