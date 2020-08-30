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
	response.sendRedirect("index.jsp?message=Database connection failed");
}

String message = (String)request.getParameter("message");
if (message == null) {
	message = "";
}

String start = (String)request.getParameter("start");
session.setAttribute("start", start);
String position = "";

if (start != null) {
	position = "Start Position Set: " + start;
}

String initialise = (String)request.getParameter("initialise");
%>
</head>
<body style="background: grey;">
	<nav class="bg-dark">
		<div class="row">
			<div class="col-sm-11">
				<button class="btn btn-dark">Adsys Maze Game</button>
			</div>
			<div class="col-sm-1 justify-content-right">
				<button class="btn btn-dark">Player: <%=user %></button>
			</div>
		</div>
	</nav>
	<br/>
	<div class="container">
		<div class="card">
			<h1 class="card-title text-center">What would you like to do?</h1>
			<div class="card-body justify-content-center">
				<div class="row justify-content-center">
					<div class="col-auto">
						<table class="table table-center">
							<tr>
								<td class="text-center">	
									<form action="initialise.jsp">
										<button type="submit" class="btn btn-dark" name="initialise" id="initialise">Initialise Map</button>
									</form>
								</td>
								<td class="text-center">
									<form action="randomPosition.jsp">
										<button type="submit" class="btn btn-dark" name="position" id="position" disabled>Set Position</button>
									</form>
								</td>
								<td class="text-center">
									<form action="startRoom.jsp">
										<input type="text" hidden="true" name="startPos" id="startPos" value="<%=start %>">
										<button type="submit" class="btn btn-dark" name="start" id="start" disabled>Start Game</button>
									</form>
								</td>
							</tr>
							<tr class="justify-content-center">
								<td colspan="3" class="text-center">
									<span class="text-danger text-center"><%=message %></span>
									<span class="text-danger text-center"><%=position %></span>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var initialise = <%=initialise%>;
		if (initialise == true) {
			console.log('Enabling Set Position');
			$('#position').removeAttr("disabled");
		}
		
		var start = <%=start%>;
		if (start != 0 && start != null && start != "") {
			console.log("Enabling Start Game");
			$('#start').removeAttr("disabled");
		}
		
	</script>
</body>
</html>