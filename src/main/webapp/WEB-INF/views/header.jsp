<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>

<style type="text/css">
    <%@include file="/resources/css/header.css" %>
</style>
</head>
<body>
	<header>
		<div>
		<img alt="img" src="data:image/jpeg;base64,${sessionScope.user.getBase64image()}" class="img-circle" width="70" height="70" />
			<a class="user" href="${pageContext.request.contextPath}/post/profil?userId=${sessionScope.user.getU_id()}">
				@<c:out value="${sessionScope.user.getU_name()}" />
			</a>
		</div> 
		<div class="hHome" align="center">
			<a class="Home" href="${pageContext.request.contextPath}/post/poster">
				<img src="<c:url value='/resources/img/logo.png'/>" width="240" height="70"/>
			</a>
		</div>
		<div class="hButtons">
			<a class="Notif" href="#"><img src="<c:url value='/resources/img/notif.png'/>" width="33" height="33"/></a>
			<a class="Param" href="#"><img src="<c:url value='/resources/img/param.png'/>" width="33" height="33"/></a>
			<a class="Logout" href="${pageContext.request.contextPath}/user/logout"><img src="<c:url value='/resources/img/logout.png'/>" width="33" height="33"/></a>
		</div>
		<c:out value="${notifications.size()}" />
		<ul>
			<c:forEach var="notification" items="${notifications}"
				varStatus="user">
				<li><a
					href="${pageContext.request.contextPath}/post/showalone?postId=${notification.getN_post()}">
						<c:out value="${notification.getN_text()}" />
				</a></li>
			</c:forEach>
		</ul>
	</header>