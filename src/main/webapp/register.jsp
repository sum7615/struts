<%@include file="/parts/header.jsp"%>
<%@include file="/parts/nav.jsp"%>
<div class="main">
	<section class="signup">
		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h2 class="form-title">Sign up</h2>
					<html:form method="post" action="/register">
						<div class="register-form" >
						
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name"
									placeholder="Your name" />
									  <html:errors property="name"/>
									   
							</div>
							<div class="form-group">
								<label for="user_name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="user_name" id="user_name" placeholder="Your screen Name" />
									 <html:errors property="user_name"/>
									   
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" />
									 <html:errors property="email"/>
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password" placeholder="Password" />
									<html:errors property="password"/>
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" />
							</div>
							<div class="form-group">
								<label for="mobile_no"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="mobile_no" id="mobile_no"
									placeholder="Contact no" />
									<html:errors property="mobile_no"/>
							</div>
							<div class="form-group">
								<label for="dob"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="date" name="dob" id="dob"
									placeholder="Date of Birth" />
									<html:errors property="dob"/>
							</div>
							<input id="hidden" type="hidden"/>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" />
							</div>
						</div>
					</html:form>
				</div>
				<div class="signup-image">
					<figure>
						<img src="images/signup-image.jpg" alt="sing up image">
					</figure>
					<a href="login.jsp" class="signup-image-link">I am already
						member</a>
				</div>
			</div>
		</div>
	</section>
</div>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>
<%@include file="/parts/footer.jsp"%>