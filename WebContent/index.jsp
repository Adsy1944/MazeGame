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
String message = request.getParameter("message");
if (message == null) {
	message = "";
}
%>
</head>
<body style="background: grey;">
	<nav class="bg-dark">
		<div class="row">
			<div class="col-sm-9">
				<button class="btn btn-dark">Adsy's Maze Game</button>
			</div>
			<div class="col-sm-1">
				<button class="btn btn-dark"><%=user %></button>
			</div>
		</div>
	</nav>
	<br/>
	<div class="container" >
		<div class="card">
			<h1 class="card-title text-center">Welcome to Adsy's Maze Game!</h1>
			<form class="form" action="connectionStarter.jsp">
				<div class="row justify-content-center">
					<div class="col-auto">
						<table class="table table-responsive">
							<tr>
								<td class="justify-content-center text-center">
									<label class="text-center">Please Enter Your Name:</label>
								</td>
							</tr>
							<tr>
								<td>
									<input class="form-control" type="text" id="userName" name="userName">
								</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">
									<button type="submit" class="btn btn-lg btn-dark">Continue</button>
								</td>
							</tr>
							<tr>
								<td>
									<span class="text-danger"><%=message %></span>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>