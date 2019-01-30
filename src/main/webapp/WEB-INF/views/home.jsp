<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<style type="text/css">
    <%@include file="/resources/css/login.css" %>
</style>
<script type="text/javascript">
	<%@include file="/resources/js/login.js" %>
</script>
<title>Home</title>
</head>
<body>
	<h1>Welcome to MOJACO Site!</h1>
	<div align="center">

		<P>The time on the server is ${serverTime}.</P>
		<a href="${pageContext.request.contextPath}/user/login"><b>login</b></a><br>
		<a href="${pageContext.request.contextPath}/user/register"><b>register</b></a><br>
		<a href="${pageContext.request.contextPath}/admin/login"><b>admin</b></a><br>
	</div>
</body>
</html>
