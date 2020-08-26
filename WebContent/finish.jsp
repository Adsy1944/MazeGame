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
String user = request.getParameter("user");
if (user == null) {
	user = "";
}
%>
</head>
<body style="background: grey;">
	<nav class="bg-dark">
		<div class="row">
			<div class="col-sm-9">
				<button class="btn btn-dark">Adsys Maze Game</button>
			</div>
			<div class="col-sm-1">
				<button class="btn btn-dark"><%=user %></button>
			</div>
		</div>
	</nav>
	<br/>
	<div class="container">
		<div class="card">
			<h1 class="card-title text-center">You Escaped!</h1>
			<div class="card-body">
				<form action="endGame.jsp">
					<button class="btn btn-lg btn-dark" type="submit">End Game</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>