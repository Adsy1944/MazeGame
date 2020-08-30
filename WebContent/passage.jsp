<%@ page import="controls.UserControls" %>
<%@ page import="objects.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adsy's Maze Game</title>
<%
String passageId = (String)request.getParameter("passage");
PassageObject passage = UserControls.getInstance().getPassage(passageId);
if (passage.isExit()) {
	response.sendRedirect("finish.jsp");
}
else {
response.sendRedirect("roomNavigator.jsp?startPos=" + passage.getLeadsToInt());
}
%>
</head>
<body>

</body>
</html>