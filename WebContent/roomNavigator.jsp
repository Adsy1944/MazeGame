<%@ page import="controls.UserControls" %>
<%@ page import="objects.RoomObject" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">

<%
String user = (String)session.getAttribute("user");
if (user == null) {
	user = "";
}

String startPos = (String)request.getParameter("startPos");
RoomObject room = UserControls.getInstance().getRoom(startPos);

int north = room.getNorthPassage().getPassageId();
int east = room.getEastPassage().getPassageId();
int south = room.getSouthPassage().getPassageId();;
int west = room.getWestPassage().getPassageId();
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
			<div class="card-body">
				<div class="row">
					<div class="col-sm-6">
						<div class="card">
							<h3 class="card-title text-center">Navigation</h3>
						</div>
						<div class="card-body">
							<table>
								<tr>
									<td>
										
									</td>
									<td>
										<form action="passage.jsp">
											<input type="text" id="passage" name="passage" value="<%=north %>" hidden="true">
											<Button name="north" id="north" class="btn btn-lg btn-dark" type="submit">North</Button>
										</form>
									</td>
									<td>
										
									</td>
								</tr>
								<tr>
									<td>
										<form action="passage.jsp">
											<input type="text" id="passage" name="passage" value="<%=west %>" hidden="true">
											<Button name="west" id="west" class="btn btn-lg btn-dark" type="submit">West</Button>
										</form>
									</td>
									<td>
										<%=room.getRoomName() %>
									</td>
									<td>
										<form action="passage.jsp">
											<input type="text" id="passage" name="passage" value="<%=east %>" hidden="true">
											<Button name="east" id="east" class="btn btn-lg btn-dark" type="submit">East</Button>
										</form>
									</td>
								</tr>
								<tr>
									<td>
									
									</td>
									<td>
										<form action="passage.jsp">
											<input type="text" id="passage" name="passage" value="<%=south %>" hidden="true">
											<Button name="south" id="south" class="btn btn-lg btn-dark" type="submit">South</Button>
										</form>
									</td>
									<td>
									
									</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="card">
							<h3 class="card-title text-center">Actions</h3>
						</div>
						<div class="card-body">
							Action Grid Here
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var north = <%=north%>;
		console.log('North: ' + north);
		var east = <%=east%>;
		console.log('East: ' + east);
		var south = <%=south%>
		console.log('South: ' + south);
		var west = <%=west%>;
		console.log('West: ' + west);
		
		if (north == 0) {
			$('#north').attr("disabled", true);
		}
		if (east == 0) {
			$('#east').attr("disabled", true);
		}
		if (south == 0) {
			$('#south').attr("disabled", true);
		}
		if (west == 0) {
			$('#west').attr("disabled", true);
		}
	</script>
</body>
</html>