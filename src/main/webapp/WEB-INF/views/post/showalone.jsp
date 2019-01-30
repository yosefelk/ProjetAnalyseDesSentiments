<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
    <%@include file="/resources/css/showalone.css" %>
</style>
<title>POST</title>
</head>
<body>

<%@ include file="../header.jsp" %>  
	<div class="middleContainer" align="center">
		<section class="item1 item1_1 main">
		<div id="postTable">
		<table>

				<tr>
					<td><img alt="img"
						src="data:image/jpeg;base64,${publier.getBase64image()}"
						class="userImg" width="60" height="60" align="left" /> <a
						class="user"
						href="${pageContext.request.contextPath}/post/profil?userId=${publier.getU_id()}">
							@<c:out value="${publier.getU_name()}" />
					</a></td>
				</tr>
				<tr>
					<td><img alt=""
						src="data:image/jpeg;base64,${currentPost.getBase64image()}" width="860" /></td>
				</tr>
				<tr>
					<td class="text"><c:out value="${currentPost.getP_text()}" /></td>
				</tr>

				<tr>
					<td class="place"><c:out value="${currentPost.getP_place()}" /></td>
				</tr>
				<tr>
					<td class="date"><c:out value="${currentPost.getP_date()}" /></td>
				</tr>
				<tr>
					<td><a class="comment"
						href="${pageContext.request.contextPath}/post/showalone?postId=${currentPost.getP_id()}">
							<img src="<c:url value='/resources/img/comment.png'/>" width="33"
							height="33" />
					</a></td>
				</tr>
				<tr>
					<td class="colnum"><c:out value="${comments.size()}" />
						Comments</td>
					<td class="pol"><p>
							<c:out value="${currentPost.getP_polarity()}" />%</p>
						
					</td>
				</tr>
			</table>
			</div>
			<div id="commentTable">
		<table>
			<s:form commandName="commentData"
				action="${pageContext.request.contextPath}/post/showalone?postId=${currentPost.getP_id()}"
				method="post">

				<tr>
					<td><s:textarea path="c_text" placeholder="Your Comment.."/></td>
					<td><s:errors path="c_text" cssStyle="color:red;" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Commenter" /></td>
				</tr>

			</s:form>

			<c:forEach var="comment" items="${comments}" varStatus="user">
				<tr>
					<td><img alt="img"
						src="data:image/jpeg;base64,${users[user.index].getBase64image()}"
						class="userImg" width="50" height="50" align="left" /> <a
						class="user"
						href="${pageContext.request.contextPath}/post/profil?userId=${users[user.index].getU_id()}">
							@<c:out value="${users[user.index].getU_name()}" />
					</a></td>
				</tr>
				<tr>
					<td></td>
					<td class="text"><c:out value="${comment.getC_text()}" /></td>
				</tr>

				<tr>
					<td class="date"><c:out value="${comment.getC_date()}" /></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		</section>
	</div>

</body>
</html>