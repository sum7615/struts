<%@include file="/parts/header.jsp"%>
<title>Edit User</title>
</head>
<body>
	<%@include file="/parts/nav.jsp"%>
	<%
	java.sql.ResultSet user = (java.sql.ResultSet) request.getAttribute("user");
	%>
	<div class="main">
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Edit User</h2>
						<html:form method="post" action="/update-user">
							<input type="hidden" name="id" value="<%=user.getString("id")%>" />
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name"
									value="<%=user.getString("name")%>" />
							</div>
							<div class="form-group">
								<label for="u_name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="user_name" id="user_name"
									value="<%=user.getString("user_name")%>" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email"
									value="<%=user.getString("email")%>" />
							</div>

							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="mobile_no" id="contact"
									value="<%=user.getString("mobile_no")%>" />
							</div>
							<div class="form-group">
								<label for="dob"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="date" name="dob" id="dob"
									value="<%=user.getString("dob")%>" />
							</div>
							<div style="display: flex;">
								<div class="form-group form-button">
									<input type="submit" class="form-submit" />
								</div>
								<div>
									<a href="<%=request.getContextPath()%>/welcome.do"
										class="form-submit"
										style="margin-left: 1rem; text-decoration: none; color: inherit;">Dashboard</a>
								</div>
							</div>
						</html:form>
					</div>

				</div>
			</div>
		</section>
	</div>
	<%@include file="/parts/footer.jsp"%>