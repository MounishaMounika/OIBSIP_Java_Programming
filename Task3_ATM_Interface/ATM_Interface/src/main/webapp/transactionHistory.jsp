<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ATM_Interface.Beans.TransactionHistoryBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Transaction History</title>
    <link rel="stylesheet" type="text/css" href="homepage.css" />
    <link rel="stylesheet" type="text/css" href="transactions.css" />
</head>
<body>
    <header>
        <h1>Transaction History</h1>
    </header>
    <div class="container">
        <div class="wrapper">
            <div class="sections">
                <section id="deposit">
                    <form action="TransactionHistory" method="post">
                        <div class="inputs">
                            <input type="text" name="accountNumber" placeholder="Enter account number" required>
                        </div>
                        <input type="submit" value="Submit" class="submitButton">
                        <a href="homepage.jsp" class="back-link">Back</a>
                    </form>
                </section>
            </div>
        </div>
    </div>

    <%
        @SuppressWarnings("unchecked")
        ArrayList<TransactionHistoryBean> historyList = (ArrayList<TransactionHistoryBean>) request.getAttribute("historyList");
        String errorMessage = (String) request.getAttribute("errorMessage");
    %>

    <% if (historyList != null) { %>
        <table class="historyTable">
            <thead>
                <tr>
                    <th>Account Number</th>
                    <th>Other's Account Number</th>
                    <th>Account Holder Name</th>
                    <th>Amount</th>
                    <th>Action Performed</th>
                </tr>
            </thead>
            <tbody>
                <% for (TransactionHistoryBean thb : historyList) { %>
                    <tr>
                        <td><%= thb.getAccountNumber() %></td>
                        <td><%= thb.getOthersAccount() %></td>
                        <td><%= thb.getAccountHolderName() %></td>
                        <td><%= thb.getAmount() %></td>
                        <td><%= thb.getActionPerformed() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else if (errorMessage != null) { %>
        <p style="color:red" class="error-message"><%= errorMessage %></p>
    <% } else { %>
        <p>No transaction history found.</p>
    <% } %>
</body>
</html>
