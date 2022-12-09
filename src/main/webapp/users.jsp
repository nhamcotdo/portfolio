<%@page import="java.util.List"%>
<%@page import="java.time.Year"%>
<%@page import="model.bean.Skill"%>
<%@page import="org.apache.catalina.ant.JKStatusUpdateTask"%>
<%@page import="java.net.http.HttpClient.Redirect"%>
<%@page import="model.bean.User"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<User> users = (List<User>) request.getAttribute("users");
%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/users.css" rel="stylesheet">

<title>List User</title>
</head>
<body>


	<div class="content">

		<div class="container">
			<h2 class="mb-5 text-center">List User</h2>
			<div class="table-responsive custom-table-responsive">

				<table class="table custom-table">
					<thead>
						<tr>
							<th scope="col">UserName</th>
							<th scope="col">Name</th>
							<th scope="col">Role</th>
							<th scope="col">Edit</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (User user : users) {
						%>
						<tr scope="row">
							<td><a href="User?username=<%=user.getUserName()%>"><%=user.getUserName()%></a></td>
							<td><%=user.getInformation().getName()%></td>
							<td><%=user.getRole() == null ? "" :user.getRole().getName()%></td>
							<td></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>