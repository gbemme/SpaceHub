<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration form</title>
</head>
<body>


	<form:form action="saveUser" modelAttribute="spacehubuser">
	
	Email: <form:input path="email"/>
	<br><br>
	
	Password: <form:input path="password"/>
	<br><br>
	
	First name: <form:input path="firstName"/>
	<br><br>
	
	Last name: <form:input path="lastName"/>
	<br><br>
	
	Phone number: <form:input path="phoneNumber"/>
	<br><br>
	
	<input type="submit" value="Submit"/>
	
	</form:form>
</body>
</html>