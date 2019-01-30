<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
    <%@include file="/resources/css/login.css" %>
</style>
<script type="text/javascript">
	<%@include file="/resources/js/login.js" %>
</script>
<title>Register</title>
</head>
<body>

	<header>
	<h1>Register</h1>
	</header>
		<div id="form">

			<div class="fish" id="fish"></div>
			<div class="fish" id="fish2"></div>

			<s:form commandName="userData"
				action="${pageContext.request.contextPath}/user/register"
				method="post" enctype="multipart/form-data">

				<div class="formgroup" id="name-form">
					<label for="name">Username*</label>
					<s:input type="text" id="name" path="u_name" name="name" />
				</div>

				<div class="formgroup" id="email-form">
					<label for="mobile">User Mobile*</label>
					<s:input type="text" path="u_mobile" id="email" name="email" />
				</div>
					
				<div class="formgroup" id="email-form">
					<label for="email">User Gender*</label>
					<s:radiobutton path="u_gender" value="Male" name="male" />Male
					<s:radiobutton path="u_gender" value="Female" name="female" />Female
				</div>
				
				<div class="formgroup" id="email-form">
					<label for="email">Email*</label>
					<s:input type="text" path="u_email" id="email" name="email" />
				</div>

				<div class="formgroup" id="email-form">
					<label for="email">Password*</label>
					<s:input type="password" path="u_password" id="email" name="email" />
				</div>
				<div>
					<label for="image">Image to upload:</label>
					<input type="file" name="fileUpload">
				</div>
				<input type="submit" value="Sign in!" />
			</s:form>
		</div>


	</div>

</body>
</html>