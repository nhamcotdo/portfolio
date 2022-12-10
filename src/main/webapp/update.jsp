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
<title>Update</title>
<link rel="icon" type="image/png" href="assets/img/update2.png" />
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
</head>

<body>
	<%
	if (session.getAttribute("userId") == null) {
		response.sendRedirect(request.getContextPath() + "/Login");
	} else {
		User user = (User) request.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/Update");
		} else {
			Information information = user.getInformation();
			List<Skill> skills = information.getSkills();
	%>
	<div class="limiter">
		<div class="container-login100 row"
			style="background-image: url('assets/img/bg-01.jpg');">
			<div class="wrap-login100 col-12 col-md-9">
				<form name="register_form" class="login100-form validate-form row"
					action="Register" method="get">
					<a class="btn float-left" style="font-size: 1.5em;"
						href="<%=request.getContextPath()%>/Index"><i
						class='bx bx-home-alt'></i></a> <span class="login100-form-title p-b-34 p-t-27 col-12">Update</span>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="name"
							value="<%=information.getName()%>"><span
							class="focus-input100" data-placeholder="Name: "></span>

					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="title"
							value="<%=information.getTitle()%>"><span
							class="focus-input100" data-placeholder="Title: "></span>

					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="bio"
							value="<%=information.getBio()%>"><span
							class="focus-input100" data-placeholder="Bio: "></span>

					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="date" name="birthday"
							value="<%=information.getBirthday()%>"><span
							class="focus-input100" data-placeholder="Birthday: "></span>
					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="website"
							value="<%=information.getWebsite()%>"><span
							class="focus-input100" data-placeholder="Website: "></span>

					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="degree"
							value="<%=information.getDegree()%>"><span
							class="focus-input100" data-placeholder="Degree: "></span>

					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="freelance"
							value="<%=information.getFreelance()%>"><span
							class="focus-input100" data-placeholder="Freelance: "></span>
					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="email" name="email"
							value="<%=information.getEmail()%>"><span
							class="focus-input100" data-placeholder="Email: "></span>

					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="phone"
							value="<%=information.getPhone()%>"><span
							class="focus-input100" data-placeholder="Phone: "></span>

					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="email" name="address"
							value="<%=information.getAddress()%>"><span
							class="focus-input100" data-placeholder="Address: "></span>

					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="facebook"
							value="<%=information.getFacebook()%>"><span
							class="focus-input100" data-placeholder="Facebook: "></span>
					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="skype"
							value="<%=information.getSkype()%>"><span
							class="focus-input100" data-placeholder="Skype: "></span>

					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="instagram"
							value="<%=information.getInstagram()%>"><span
							class="focus-input100" data-placeholder="Instagram: "></span>
					</div>

					<div class="wrap-input100 validate-input col-6">
						<input class="input100" type="text" name="linkedin"
							value="<%=information.getLinkedIn()%>"><span
							class="focus-input100" data-placeholder="Linkedin: "></span>
					</div>
					<div class="wrap-input100 validate-input col-12">
						<textarea class="input100" name="description"information.getDescription()%></textarea>
						<span class="focus-input100" data-placeholder="Description: "></span>

					</div>

					<span class="login100-form-title p-b-34 p-t-27 col-12">SKILL</span>

					<div id="skill" class="col-12 row">
						<%
						for (int i = 0; i < skills.size(); i++) {
							Skill skill = skills.get(i);
						%>
						<div class="wrap-input100 validate-input col-6">
							<input id="skillname_skill<%=i%>" class="input100" type="text"
								name="nameskill" value="<%=skill.getName()%>">
						</div>

						<div class="wrap-input100 validate-input col-5">
							<input id="skillpercent_skill<%=i%>" class="input100"
								type="number" min=0 max=100 name="percent"="<%=skill.getPercent()%>">

						</div>
						<button style="color: whitesmoke; font-size: 30px;"
							class="delSkill" id="skill<%=i%>">
							<i class="fa fa-times-circle " aria-hidden="true"></i>
						</button>
						<%
						}
						%>
					</div>
					<button id="addskill" class="btn">Add skill</button>

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
	<script src="assets/js/register.js"></script>
	<script src="assets/js/jquery.min.js"></script>
	<%
	}
	}
	%>
</body>

</html>