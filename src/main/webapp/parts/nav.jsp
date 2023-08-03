
<nav
	class="navbar navbar-expand-lg navbar-light bg-light justify-content-between">
	<a class="navbar-brand" href="<%=request.getContextPath()%>/">Home</a>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">

			<%
			String userName = (String) session.getAttribute("uname");
			String id = (String) session.getAttribute("id");
			if (userName == null) {
			%>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/login.do">Login</a></li>

			<%
			} else {
			%>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/logout.do">Logout</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/welcome.do">Dashboard</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/all-user.do">All Users</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/edit-user/<%=id%>.do">Update Profile</a></li>
			<%
			}
			%>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/register.jsp">Create an
					account</a></li>

		</ul>
	</div>
</nav>