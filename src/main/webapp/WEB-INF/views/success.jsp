<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<div align = "right">
		<a href = "${pageContext.request.contextPath}/user/logout"><b>logout</b></a>
	</div>
	<div align = "left">
		Welcome<b>${user.get.U_name()}</b>
	</div>
	
</div>


</body>
</html>