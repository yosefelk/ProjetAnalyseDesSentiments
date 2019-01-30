<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<%@include file="/resources/css/profil.css"%>
</style>
<title>POST</title>
</head>
<body>
<%@ include file="../header.jsp"%>
	<div class="middleContainer" align="center">
		<section class="item1 item1_1 main">
		<div id="profil">
			<table>
				<tr>
					<td>
						<img alt="img" src="data:image/jpeg;base64,${sessionScope.currentProfil.getBase64image()}" class="userImg" width="160" height="160" align="left" /> 
						<p class="user">@<c:out value="${profilUser.getU_name()}" /></p>
					</td>
				</tr>
				<tr>
					<td>@<c:out value="${sessionScope.currentProfil.getU_name()}" /></td>
				</tr>
				<tr>
					<td>Gender: <c:out value="${sessionScope.currentProfil.getU_gender()}" />
					<td>
				</tr>
				<tr>
					<td>Email: <c:out value="${sessionScope.currentProfil.getU_email()}" /></td>
				</tr>
				<tr>
					<td>Mobile: <c:out value="${sessionScope.currentProfil.getU_mobile()}" /></td>
				</tr>
			</table>
		</div>
	
			<c:forEach var="post" items="${postsById}" varStatus="i">
		
		<div id="postTable">
			<table>
				<tr>
					<td>
						<img alt="img"
						src="data:image/jpeg;base64,${sessionScope.currentProfil.getBase64image()}"
						class="userImg" width="60" height="60" align="left" />
						 <a class="user" href="${pageContext.request.contextPath}/post/profil?userId=${sessionScope.currentProfil.getU_id()}">
							@<c:out value="${sessionScope.currentProfil.getU_name()}" />
						</a>
					</td>
					<td> 
						<a class="user" href="${pageContext.request.contextPath}/post/removepost?postId=${post.getP_id()}">
							Supprimer
						</a>
					</td>
				</tr>
				<tr>
					<td><img alt=""
						src="data:image/jpeg;base64,${post.getBase64image()}" width="800" /></td>
				</tr>
				<tr>
					<td class="text"><c:out value="${post.getP_text()}" /></td>
				</tr>

				<tr>
					<td class="place"><c:out value="${post.getP_place()}" /></td>
				</tr>
				<tr>
					<td class="date"><c:out value="${post.getP_date()}" /></td>
				</tr>
				<tr>
					<td><a class="comment"
						href="${pageContext.request.contextPath}/post/showalone?postId=${post.getP_id()}">
							<img src="<c:url value='/resources/img/comment.png'/>" width="33"
							height="33" />
					</a></td>
				</tr>
				<tr>
					<td class="colnum"><c:out value="${commentsNum[i.index]}" />
						Comments</td>
					<td class="pol"><p>
							<c:out value="${post.getP_polarity()}" />%</p>
						
					</td>
				</tr>
			</table>
			
			<br>
			</c:forEach>
		</div>
		<input type="submit" value="See More!" /> 
	</section>
	</div>


</body>
</html>