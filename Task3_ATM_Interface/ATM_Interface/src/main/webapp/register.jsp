<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="register.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</head>
<body>
<div class="container">
<% if (request.getAttribute("errorMessage") != null) { %>
  <p style="color:red"><%= request.getAttribute("errorMessage") %></p>
<% } %>
<% if (request.getAttribute("error") != null) { %>
  <p style="color:red"><%= request.getAttribute("error") %></p>
<% } %>
      <div class="wrapper">
        <div class="title"><span>ATM Registration</span></div>
        <form action="Register" method="post">
          <div class="row">
            <i class="fas fas fa-credit-card"></i>
            <input type="text" name="accountNumber" placeholder="Account Number" required>
          </div>
          <div class="row">
            <i class="fas fa-lock"></i>
            <input type="password" name="pin" placeholder="Pin" required>
          </div>
          <div class="row">
            <i class="fas fa-lock"></i>
            <input type="password" name="confirmPin" placeholder="Confirm Pin" required>
          </div>
          <div class="row">
            <i class="fas fa-user"></i>
            <input type="text" name="name" placeholder="Name" required>
          </div>
           <div class="row">
            <i class="fas fa-phone"></i>
            <input type="text" name="phone" placeholder="Phone" required>
          </div>
          <div class="row">
            <i class="fas fa-graduation-cap"></i>
            <input type="text" name="education" placeholder="Education" required>
          </div>
          <div class="row">
            <i class="fas fa-briefcase"></i>
            <input type="text" name="occupation" placeholder="Occupation" required>
          </div>
          <div class="row button">
            <input type="submit" value="Register" >
          </div>
          <div class="signin-link">Already a member? <a href="http://localhost:8080/ATM_Interface/index.jsp">Login now</a></div>
        </form>
      </div>
    </div>
</body>
</html>