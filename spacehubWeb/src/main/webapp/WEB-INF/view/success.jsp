<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>File Upload Success</title>
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/app.css"/>
	<!-- <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link> -->
</head>
<body>
	<div class="success">
		File  <strong>${fileName}</strong> uploaded successfully.
		<br/><br/>
		
		<a href="${pageContext.request.contextPath}/admin/product-list">Back to List</a>
		<!-- <a href="<c:url value='/welcome' />">Home</a>	 -->
	</div>
</body>
</html>