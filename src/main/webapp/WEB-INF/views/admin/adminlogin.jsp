<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
<%@include file="/resources/css/post.css"%>
</style>
<title>Login</title>
</head>
<body>

	<header>
	<h1>Sign In</h1>
	</header>

	<div id="form">

		<s:form commandName="adminData" 
					action="${pageContext.request.contextPath}/admin/login"
					method="post">

			<div class="formgroup" id="name-form">
				<label for="name">Login*</label> <s:input type="text" id="name" path="a_email"
					name="name" />
			</div>

			<div class="formgroup" id="email-form">
				<label for="email">Password*</label> <s:input type="password" path="a_password"
					id="email" name="email" />
			</div>

			<input type="submit" value="Sign in!" />
		</s:form>
	</div>

</body>
</html>