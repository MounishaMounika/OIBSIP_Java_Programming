<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="index.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</head>
<body>
    <div class="container">
    <% if (request.getAttribute("errorMessage") != null) { %>
  <p style="color:red"><%= request.getAttribute("errorMessage") %></p>
<% } %>
<% if (request.getAttribute("RegisterMessage") != null) { %>
  <p style="color:green"><%= request.getAttribute("RegisterMessage") %></p>
<% } %>
      <div class="wrapper">
        <div class="title"><span>ATM Login</span></div>
        <form action="Login" method="post">
          <div class="row">
            <i class="fas fa-credit-card"></i>
            <input type="text" name="accountNumber" placeholder="Account Number" required>
          </div>
          <div class="row">
            <i class="fas fa-lock"></i>
            <input type="password" name="pin" placeholder="Pin" required>
          </div>
          <div class="row button">
            <input type="submit" value="Login">
          </div>
          <div class="signup-link">Not a member? <a href="register.jsp">Signup now</a></div>
        </form>
      </div>
    </div>
</body>
</html>
