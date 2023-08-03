<%@include file="/parts/header.jsp"%>
<title>Login</title>
</head>
<body>
	<%@include file="/parts/nav.jsp"%>
	<div class="main">

		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="<%=request.getContextPath()%>/register.jsp" class="signup-image-link">Create an
							account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Login</h2>
						<html:form method="POST" action="/login-data">
							<div class="form-group">
								<label for="user_name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="user_name" id="user_name"
									placeholder="Your User Name" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" />
							</div>

							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
							<input id="hidden" type="hidden"/>
						</html:form>
					</div>
				</div>
			</div>
		</section>

	</div>
<script src="js/login.js"></script>

	<%@include file="/parts/footer.jsp"%>