<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

		</div>
		<div id="postTable">
			<table>
			
				<c:forEach var="user" items="${listeUser}" varStatus="i">
				<tr>
					<td><img alt=""
						src="data:image/jpeg;base64,${user.getBase64image()}" width="80" /></td>
					<td class="text"><c:out value="${user.getU_name()}" /></td>
					<td><a class="comment"
						href="${pageContext.request.contextPath}/admin/deleteuser?userId=${user.getU_id()}">
							<img src="<c:url value='/resources/img/comment.png'/>" width="33"
							height="33" />
					</a></td>
				
					
				</tr>
				
				
			</c:forEach>
			</table>
			
			<br>

</body>
</html>