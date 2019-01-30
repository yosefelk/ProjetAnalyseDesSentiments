<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
<%@include file="/resources/css/post.css"%>
</style>

<title>POST</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="middleContainer" align="center">
		<section class="item1 item1_1 main">
		<div id="pubTable">
			<table>
				<s:form commandName="postData"
					action="${pageContext.request.contextPath}/post/poster"
					enctype="multipart/form-data" method="post">
					<tr>
						<td>
							<img alt="img" src="data:image/jpeg;base64,${sessionScope.user.getBase64image()}" class="userImg" width="60" height="60" align="left"/>
							<a class="user" href="${pageContext.request.contextPath}/post/profil?userId=${sessionScope.user.getU_id()}">
								@<c:out value="${sessionScope.user.getU_name()}" />
							</a>
						</td>
					</tr>
					<tr>
						<td class="text"><s:textarea path="p_text" placeholder="What's in Mind..."/></td>
						<td class="text"><s:errors path="p_text" cssStyle="color:red;" /></td>
					</tr>


					<tr>
						<td class="positionLabel">Your position?</td>
						<td class="positionInput"><s:input path="p_place" /></td>
						<td class="positionErr"><s:errors path="p_place" cssStyle="color:red;" /></td>
					</tr>

					<tr>
						<td class="imageLabel">Image to upload:</td>
						<td class="imageInput"><input type="file" name="fileUpload"></td>
					</tr>

					<tr>
						<td></td>
						<td><input class="publier" type="submit" value="Post" /></td>

					</tr>


				</s:form>
			</table>
			<br> <br>
			<c:forEach var="post" items="${posts}" varStatus="i">
		</div>
		<div id="postTable">
			<table>

				<tr>
					<td><img alt="img"
						src="data:image/jpeg;base64,${users[i.index].getBase64image()}"
						class="userImg" width="60" height="60" align="left" />
						 <a
						class="user"
						href="${pageContext.request.contextPath}/post/profil?userId=${users[i.index].getU_id()}">
							@<c:out value="${users[i.index].getU_name()}" />
					</a></td>
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
		<input type="submit" value="See More!" /> </section>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>