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
if (session.getAttribute("userId") == null) {
	response.sendRedirect(request.getContextPath() + "/Login");
	return;
}
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
<link rel="icon" type="image/png" href="assets/img/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/fonts/iconic/css/material-design-iconic-font.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="assets/vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css" href="assets/css/main.css">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<!-- Template Main CSS File -->
<link href="assets/css/users.css" rel="stylesheet">

<title>List User</title>
</head>
<body>


	<div class="content">

		<div class="container">

			<div class="card-header">
				<a class="btn float-left" style="font-size: 1.5em;"
					href="<%=request.getContextPath()%>/Index"><i
					class='bx bx-home-alt'></i></a>
				<h1 class="mb-5 text-center text-primary">List User</h1>
			</div>
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
							<td><%=user.getRole() == null ? "" : user.getRole().getName()%></td>
							<td><input class="btn" id="<%=user.getId()%>" type="button"
								value="edit role" _id="open"></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>

			<div class="modal fade" id="exampleModalToggle" aria-hidden="true"
				aria-labelledby="exampleModalToggleLabel" tabindex="-1">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content" id="div_modal" data-url="UpdateRole"></div>
				</div>
			</div>

		</div>
	</div>

	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/jquery.min.js"></script>
	<script>
		//all script
		$(function() {
			$('[_id=open]').click(
					function() {
						var url = $("#div_modal").data("url");
						$("#div_modal").load(url + "?id=" + $(this).attr("id"),
								function() {
									$("#exampleModalToggle").modal("show");
								});
					})
		});
	</script>
</body>

</html>