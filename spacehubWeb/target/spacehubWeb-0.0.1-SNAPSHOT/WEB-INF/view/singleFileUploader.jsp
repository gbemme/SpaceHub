<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Product Image Upload Page</title>
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/app.css"/>
			
	
<!--  	<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet" type="text/css"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet" type="text/css"></link>-->
</head>
<body> 

	<div class="form-container">
		<h1>Product Image Upload </h1>
		<form:form method="POST" modelAttribute="productImage" enctype="multipart/form-data" class="form-horizontal">
		
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="file">Upload a file</label>
					<div class="col-md-7">
						<form:input type="file" path="file" id="file" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="file" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Upload" class="btn btn-primary btn-sm">
				</div>
			</div>
		</form:form>
		 <a href="${pageContext.request.contextPath}/admin/product-list">Back to List</a>
	</div>
</body>
</html>
