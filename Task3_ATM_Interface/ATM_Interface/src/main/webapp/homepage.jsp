<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ATM INTERFACE</title>
    <link rel="stylesheet" type="text/css" href="homepage.css"/>
  </head>
  <body>
    <header>
      <h1>ATM INTERFACE</h1>
    </header>
    <nav>
      <a href="#deposit">Deposit</a>
      <a href="#withdraw">Withdraw</a>
      <a href="#balance">Balance</a>
      <a href="#transfer">Transfer</a>
      <form action="TransactionHistory" method="post">
      <a href="transactionHistory.jsp">Transaction History</a>
      </form>
      <form id="logoutForm" action="Logout" method="post">
      <a href="index.jsp" class="logout">Logout</a>
      </form>
    </nav>
    <div>
     <% if (request.getAttribute("DepositMessage") != null) { %>
  <p style="color:black"><%= request.getAttribute("DepositMessage") %></p>
<% } %>

 <% if (request.getAttribute("WithdrawMessage") != null) { %>
  <p style="color:black"><%= request.getAttribute("WithdrawMessage") %></p>
<% } %>
 
     <% if (request.getAttribute("BalanceMessage") != null) { %>
  <p style="color:black"><%= request.getAttribute("BalanceMessage") %></p>
<% } %>

  <% if (request.getAttribute("TransferMessage") != null) { %>
  <p style="color:black"><%= request.getAttribute("TransferMessage") %></p>
<% } %>
    </div>
    <div class="container">
    <div class="wrapper">
    <div class="sections">
   
    <section id="deposit">
      <h2>Deposit</h2>
      <form action="Deposit" method="post">
      <!-- <div class="inputs">
      <input type="text" name="accountNumber" placeholder="Enter account number" required>
      </div>  -->
     
      <div class="inputs"> 
      <input type="text" name="depositAmount" placeholder="Enter amount" required>
       </div>
      <input type="submit" value="Deposit" class="submitButton" >
      </form>
    </section>
    </div>
    <div class="sections">
     
    <section id="withdraw">
      <h2>Withdraw</h2>
      <form action="Withdraw" method="post">
      <!--<div class="inputs">
      <input type="text" name="accountNumber" placeholder="Enter account number" required>
      </div>  -->
      
       <div class="inputs">
      <input type="text" name="withdrawAmount" placeholder="Enter amount" required>
      </div> 
      <input type="submit" value="withdraw" class="submitButton" >
      </form>
    </section>
     </div>
   <div class="sections">
    <section id="balance">
      <h2>Balance</h2>
      <form action="Balance" method="post">
      <!-- <div class="inputs">
      <input type="text" name="accountNumber" placeholder="Enter account number" required>
      </div> -->
       <div class="inputs">
      <input type="password" name="balancepin" placeholder="Enter pin" required>
      </div> 
      <input type="submit" value="Check Balance" class="submitButton" >
      </form>
    </section>
     </div>
    <div class="sections">
    <section id="transfer">
      <h2>Transfer</h2>
       <form action="Transfer" method="post">
       <!--<div class="inputs">
      <input type="text" name="accountNumber" placeholder="Enter your account number" required>
      </div> -->
      <div class="inputs">
      <input type="text" name="transferAccount" placeholder="Enter account number to Transfer" required>
      </div>
       <div class="inputs">
      <input type="text" name="transferAmount" placeholder="Enter amount to Transfer" required>
      </div> 
      <input type="submit" value="Transfer" class="submitButton" >
      </form>
    </section>
     </div>
     </div>
     </div>
  </body>
</html>
