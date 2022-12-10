<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="model.bean.Information"%>
<%@page import="java.time.Year"%>
<%@page import="model.bean.Skill"%>
<%@page import="org.apache.catalina.ant.JKStatusUpdateTask"%>
<%@page import="java.net.http.HttpClient.Redirect"%>
<%@page import="model.bean.User"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Update password</title>
<link rel="icon" type="image/png" href="assets/img/update-password2.png" />
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
</head>

<body>
	<%
	if (session.getAttribute("userId") == null) {
		response.sendRedirect(request.getContextPath() + "/Login");
	}
	%>
	<div class="limiter">
		<div class="container-login100 row"
			style="background-image: url('assets/img/bg-01.jpg');">
			<div class="wrap-login100 col-12 col-md-9">
				<form name="register_form" class="login100-form validate-form row"
					action="UpdatePassword" method="post">
					<span class="login100-form-title p-b-34 p-t-27 col-12">Update password</span>

					<div class="wrap-input100 validate-input"
						data-validate="Enter username">
						<input class="input100" type="password" name="password"
							placeholder="Password"> <span class="focus-input100"
							data-placeholder="&#xf191;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter password">
						<input class="input100" type="password" name="newpassword"
							placeholder="New password"> <span class="focus-input100"
							data-placeholder="&#xf191;"></span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Enter password">
						<input class="input100" type="password" name="confirmnewpassword"
							placeholder="Confirm new password"> <span class="focus-input100"
							data-placeholder="&#xf191;"></span>
					</div>

					<div class="container-login100-form-btn">
						<button id="update" class="btn">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

	<script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="assets/vendor/animsition/js/animsition.min.js"></script>
	<script src="assets/vendor/bootstrap/js/popper.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/select2/select2.min.js"></script>
	<script src="assets/vendor/daterangepicker/moment.min.js"></script>
	<script src="assets/vendor/daterangepicker/daterangepicker.js"></script>
	<script src="assets/vendor/countdowntime/countdowntime.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/jquery.min.js"></script>
</body>

</html>