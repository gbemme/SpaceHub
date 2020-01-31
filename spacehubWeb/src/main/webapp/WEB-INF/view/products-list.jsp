<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
<title>List Of Product</title>

<!-- reference css style sheet -->
<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css"/>



</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>SpaceHub Product Table</h2>
	
		</div>
	
		</div>
		<div id="container">
	
	<!-- new button: Add Product -->
		<input type="button" value="Add Product"
				   onclick="window.location.href='addProductForm'; return false;"
				   class="add-button"
			/>
			<div id="content">
	<!--  add our html table here -->
	
	
	<table>
		<tr>
			<th> Product Name</th>
			<th> Product Plan</th>
			<th> Product Price</th>
			<th> Product Image Path</th>
			
			<th> Action</th>
		</tr>
	
		<!--  loop over and print our products -->
	
			<c:forEach var="tempProduct" items="${products}">
			
			<!-- construct an "update" link with product id -->
				<c:url var="updateLink" value="/admin/showFormForUpdate">
					<c:param name="productId" value="${tempProduct.id}" />
				
				</c:url>
				
				<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/admin/delete-product">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					
					<c:url var="uploadLink" value="/singleUpload">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
				<tr>
					<td> ${tempProduct.productName} </td>
					<td> ${tempProduct.productPlan} </td>
					<td> ${tempProduct.productPrice} </td>
					<td> ${tempProduct.productImg} </td>
					
					
					<td> <a href= "${updateLink}"> Update</a>
					
						  ||
						  
						 <a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this product?')))
								    return false">Delete</a>
					
						  ||
						  
						  <a href= "${uploadLink}"> Upload  Image</a>
					
					</td>
				
				 </tr>
			
			</c:forEach>
	</table>
	
	</div>
	
</div>
</body>
</html>