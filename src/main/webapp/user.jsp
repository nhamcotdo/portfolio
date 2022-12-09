<%@page import="java.time.Year"%>
<%@page import="model.bean.Skill"%>
<%@page import="org.apache.catalina.ant.JKStatusUpdateTask"%>
<%@page import="java.net.http.HttpClient.Redirect"%>
<%@page import="model.bean.User"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title><%=user.getInformation().getName()%></title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

</head>

<body>

	<!-- ======= Mobile nav toggle button ======= -->
	<i class="bi bi-list mobile-nav-toggle d-xl-none"></i>

	<!-- ======= Header ======= -->
	<header id="header">
		<div class="d-flex flex-column">

			<div class="profile">
				<img src="assets/img/profile-img.jpg" alt=""
					class="img-fluid rounded-circle">
				<h1 class="text-light">
					<a href="Index"><%=user.getInformation().getName()%></a>
				</h1>
				<div class="social-links mt-3 text-center">
					<a href="<%=user.getInformation().getFacebook()%>" class="facebook"><i
						class="bx bxl-facebook"></i></a> <a
						href="<%=user.getInformation().getInstagram()%>" class="instagram"><i
						class="bx bxl-instagram"></i></a> <a
						href="<%=user.getInformation().getSkype()%>" class="google-plus"><i
						class="bx bxl-skype"></i></a> <a
						href="<%=user.getInformation().getLinkedIn()%>" class="linkedin"><i
						class="bx bxl-linkedin"></i></a>
				</div>
			</div>

			<nav id="navbar" class="nav-menu navbar">
				<ul>
					<li><a href="#hero" class="nav-link scrollto active"><i
							class="bx bx-home"></i> <span>Home</span></a></li>
					<li><a href="#about" class="nav-link scrollto"><i
							class="bx bx-user"></i> <span>About</span></a></li>
					<!-- 	<li><a href="#resume" class="nav-link scrollto"><i
							class="bx bx-file-blank"></i> <span>Resume</span></a></li> -->
					<li><a href="Update" class="nav-link scrollto"><i
							class='bx bx-edit-alt'></i> <span>Update</span></a></li>
					<li><a href="Users" class="nav-link scrollto"><i
							class='bx bx-list-ul'></i><span>List User</span></a></li>
				</ul>
			</nav>
			<!-- .nav-menu -->
		</div>
	</header>
	<!-- End Header -->

	<!-- ======= Hero Section ======= -->
	<section id="hero"
		class="d-flex flex-column justify-content-center align-items-center">
		<div class="hero-container" data-aos="fade-in">
			<h1><%=user.getInformation().getName()%></h1>
			<p>
				I'm <span class="typed"
					data-typed-items="<%=user.getInformation().getTitle()%>"></span>
			</p>
		</div>
	</section>
	<!-- End Hero -->

	<main id="main">

		<!-- ======= About Section ======= -->
		<section id="about" class="about">
			<div class="container">

				<div class="section-title">
					<h2>About</h2>
				</div>

				<div class="row">
					<div class="col-lg-4" data-aos="fade-right">
						<img src="assets/img/profile-img.jpg" class="img-fluid" alt="">
					</div>
					<div class="col-lg-8 pt-4 pt-lg-0 content" data-aos="fade-left">
						<h3><%=user.getInformation().getTitle()%></h3>
						<p class="fst-italic"><%=user.getInformation().getBio()%></p>
						<div class="row">
							<div class="col-lg-6">
								<ul>
									<li><i class="bi bi-chevron-right"></i> <strong>Birthday:</strong>
										<span><%=user.getInformation().getBirthday()%></span></li>
									<li><i class="bi bi-chevron-right"></i> <strong>Website:</strong>
										<span><%=user.getInformation().getWebsite()%></span></li>
									<li><i class="bi bi-chevron-right"></i> <strong>Phone:</strong>
										<span><%=user.getInformation().getPhone()%></span></li>
									<li><i class="bi bi-chevron-right"></i> <strong>Address:</strong>
										<span><%=user.getInformation().getAddress()%></span></li>
								</ul>
							</div>
							<div class="col-lg-6">
								<ul>
									<li><i class="bi bi-chevron-right"></i> <strong>Age</strong>
										<span><%=Year.now().getValue() - user.getInformation().getBirthday().getYear() - 1900%></span></li>
									<li><i class="bi bi-chevron-right"></i> <strong>Degree:</strong>
										<span><%=user.getInformation().getDegree()%></span></li>
									<li><i class="bi bi-chevron-right"></i> <strong>Email:</strong>
										<span><%=user.getInformation().getEmail()%></span></li>
									<li><i class="bi bi-chevron-right"></i> <strong>Freelance:</strong>
										<span><%=user.getInformation().getFreelance()%></span></li>
								</ul>
							</div>
						</div>
						<p><%=user.getInformation().getDescription()%></p>
					</div>
				</div>

			</div>
		</section>
		<!-- End About Section -->

		<!-- ======= Skills Section ======= -->
		<section id="skills" class="skills section-bg">
			<div class="container">

				<div class="section-title">
					<h2>Skills</h2>
				</div>

				<div class="row skills-content">
					<div class="col-lg-6" data-aos="fade-up">
						<%
						for (int i = 0; i < user.getInformation().getSkills().size(); i += 2) {
							Skill skill = user.getInformation().getSkills().get(i);
						%>
						<div class="progress">
							<span class="skill"><%=skill.getName()%> <i class="val"><%=skill.getPercent()%>%</i></span>
							<div class="progress-bar-wrap">
								<div class="progress-bar" role="progressbar"
									aria-valuenow="<%=skill.getPercent()%>" aria-valuemin="0"
									aria-valuemax="<%=skill.getPercent()%>"></div>
							</div>
						</div>
						<%
						}
						%>
					</div>
					<div class="col-lg-6" data-aos="fade-up" data-aos-delay="100">
						<%
						for (int i = 1; i < user.getInformation().getSkills().size(); i += 2) {
							Skill skill = user.getInformation().getSkills().get(i);
						%>
						<div class="progress">
							<span class="skill"><%=skill.getName()%> <i class="val"><%=skill.getPercent()%>%</i></span>
							<div class="progress-bar-wrap">
								<div class="progress-bar" role="progressbar"
									aria-valuenow="<%=skill.getPercent()%>" aria-valuemin="0"
									aria-valuemax="<%=skill.getPercent()%>"></div>
							</div>
						</div>
						<%
						}
						%>
					</div>

				</div>

			</div>
		</section>
		<!-- End Skills Section -->

		<!-- ======= Resume Section ======= -->
		<!-- <section id="resume" class="resume">
			<div class="container">

				<div class="section-title">
					<h2>Resume</h2>
					<p>Magnam dolores commodi suscipit. Necessitatibus eius
						consequatur ex aliquid fuga eum quidem. Sit sint consectetur
						velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit
						suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem
						hic quas.</p>
				</div>

				<div class="row">
					<div class="col-lg-6" data-aos="fade-up">
						<h3 class="resume-title">Sumary</h3>
						<div class="resume-item pb-0">
							<h4>Alex Smith</h4>
							<p>
								<em>Innovative and deadline-driven Graphic Designer with 3+
									years of experience designing and developing user-centered
									digital/print marketing material from initial concept to final,
									polished deliverable.</em>
							</p>
							<ul>
								<li>Portland par 127,Orlando, FL</li>
								<li>(123) 456-7891</li>
								<li>alice.barkley@example.com</li>
							</ul>
						</div>

						<h3 class="resume-title">Education</h3>
						<div class="resume-item">
							<h4>Master of Fine Arts &amp; Graphic Design</h4>
							<h5>2015 - 2016</h5>
							<p>
								<em>Rochester Institute of Technology, Rochester, NY</em>
							</p>
							<p>Qui deserunt veniam. Et sed aliquam labore tempore sed
								quisquam iusto autem sit. Ea vero voluptatum qui ut dignissimos
								deleniti nerada porti sand markend</p>
						</div>
						<div class="resume-item">
							<h4>Bachelor of Fine Arts &amp; Graphic Design</h4>
							<h5>2010 - 2014</h5>
							<p>
								<em>Rochester Institute of Technology, Rochester, NY</em>
							</p>
							<p>Quia nobis sequi est occaecati aut. Repudiandae et iusto
								quae reiciendis et quis Eius vel ratione eius unde vitae rerum
								voluptates asperiores voluptatem Earum molestiae consequatur
								neque etlon sader mart dila</p>
						</div>
					</div>
					<div class="col-lg-6" data-aos="fade-up" data-aos-delay="100">
						<h3 class="resume-title">Professional Experience</h3>
						<div class="resume-item">
							<h4>Senior graphic design specialist</h4>
							<h5>2019 - Present</h5>
							<p>
								<em>Experion, New York, NY </em>
							</p>
							<ul>
								<li>Lead in the design, development, and implementation of
									the graphic, layout, and production communication materials</li>
								<li>Delegate tasks to the 7 members of the design team and
									provide counsel on all aspects of the project.</li>
								<li>Supervise the assessment of all graphic materials in
									order to ensure quality and accuracy of the design</li>
								<li>Oversee the efficient use of production project budgets
									ranging from $2,000 - $25,000</li>
							</ul>
						</div>
						<div class="resume-item">
							<h4>Graphic design specialist</h4>
							<h5>2017 - 2018</h5>
							<p>
								<em>Stepping Stone Advertising, New York, NY</em>
							</p>
							<ul>
								<li>Developed numerous marketing programs (logos,
									brochures,infographics, presentations, and advertisements).</li>
								<li>Managed up to 5 projects or tasks at a given time while
									under pressure</li>
								<li>Recommended and consulted with clients on the most
									appropriate graphic design</li>
								<li>Created 4+ design presentations and proposals a month
									for clients and account managers</li>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</section> -->
		<!-- End Resume Section -->
	</main>
	<!-- End #main -->
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
	<script src="assets/vendor/aos/aos.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script src="assets/vendor/typed.js/typed.min.js"></script>
	<script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>

</body>

</html>