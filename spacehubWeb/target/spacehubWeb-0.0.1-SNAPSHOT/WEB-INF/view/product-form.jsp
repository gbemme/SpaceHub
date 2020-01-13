<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<title>Save Product</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-product-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>SpaceHub Product Form</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Product</h3>
	
		<form:form action="saveProduct" modelAttribute="product" method="POST">
		
		<!-- need to associate this data with product id -->
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>Product name:</label></td>
						<td><form:input path="productName" /></td>
					</tr>
				
					<tr>
						<td><label>Product plan:</label></td>
						<td><form:input path="productPlan" /></td>
					</tr>

					<tr>
						<td><label>Product price:</label></td>
						<td><form:input path="productPrice" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/admin/product-list">Back to List</a>
		</p>
	
	</div>

</body>

</html>
