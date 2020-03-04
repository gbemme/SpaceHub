<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login Form</title>
  <!-- using google font -->
  <link href="https://fonts.googleapis.com/css?family=Quicksand:300,400" rel="stylesheet">
  <!-- using font awesome for icons -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
  <!-- reset and custom css -->
  
 <!-- <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/login_main.css"> -->
  
</head>

<body>
  <div class="container">
    <!-- form holder -->
    <div class="formholder">
      <!-- title holder -->
      <div class="titleHolder">
        <i class="far fa-user-circle"></i>
        <h1>Sign in</h1>
        <p>Login using your Username and Password.</p>
      </div>
      <!-- login form -->
      <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" class="loginForm">
       
        <!-- Check for login error -->
        <c:if test="${param.error != null }">
        	<div class="alert alert-danger col-xs-offset-1 col-xs-10">
        		Sorry you entered invalid username/password
        	</div>
        </c:if>
        
        
         <!-- Check for logout -->
        <c:if test="${param.logout != null }">
        	<div class="alert alert-danger col-xs-offset-1 col-xs-10">
        		You have been logged out
        	</div>
        	
        </c:if>
       
        <div class="row">
        <p>
          Email: <input type="text" name="username" placeholder="Username" required />
          <i class="fas fa-user"></i>
          </p>
        </div> 
        
        <div class="row">
        <p>
          Password: <input type="password" name="password" placeholder="Password" required />
          <i class="fas fa-key"></i>
          </p>
        </div>
        <div class="row">
          <input type="checkbox" id="rememberMe">
          <label for="rememberMe">Remember me</label>
        </div>
        <div class="row">
          <button type="submit" class="btn">Login</button>
        </div>
        <div class="row">
          <a href="forgot-password.html">Forgot Password?</a>
          <br>
          <a href="register.html">Not registered? Click to register</a>
        </div>
        
        
        
      </form:form>
    </div>
  </div>
</body>

</html>