<%@ page import="controls.UserControls" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adsy's Maze Game</title>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<%
String user = (String)session.getAttribute("user");

if (UserControls.getInstance().conCheck() == false) {
	response.sendRedirect("index.jsp?message=Couldn't connect to database");
}
%>
</head>
<body style="background: grey;">
	<nav class="bg-dark">
		<div class="row">
			<div class="col-sm-11">
				<button class="btn btn-dark">Adsys Maze Game</button>
			</div>
			<div class="col-sm-1 justify-content-right">
				<button class="btn btn-dark"><%=user %></button>
			</div>
		</div>
	</nav>
	<br/>
	<div class="container">
		<div class="card">
			<h1 class="card-title text-center">What would you like to do?</h1>
			<div class="card-body">
				<table>
					<tr>
						<td>	
							<form action="initialise.jsp">
								<button type="submit" class="btn btn-dark">Initialise Map</button>
							</form>
						</td>
						<td>
							<form action="randomPosition.jsp">
								<button type="submit" class="btn btn-dark">Set Position</button>
							</form>
						</td>
					<form action="startGame.jsp">
						<button type="submit" class="btn btn-dark">Start Game</button>
					</form>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>