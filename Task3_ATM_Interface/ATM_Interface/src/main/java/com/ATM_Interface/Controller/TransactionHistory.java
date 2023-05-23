package com.ATM_Interface.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ATM_Interface.Beans.TransactionHistoryBean;
import com.ATM_Interface.Model.TransactionHistoryDb;

/**
 * Servlet implementation class TransactionHistory
 */
public class TransactionHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		long accountNumber=Integer.parseInt(request.getParameter("accountNumber"));
		
		TransactionHistoryBean th=new TransactionHistoryBean();
		th.setAccountNumber(accountNumber);
		
		TransactionHistoryDb db=new TransactionHistoryDb();
		
		ArrayList<TransactionHistoryBean> historyList = db.transactionHistory(th);

	   
	    request.setAttribute("historyList", historyList);
	    RequestDispatcher rd = request.getRequestDispatcher("transactionHistory.jsp");
	    rd.forward(request, response);
		
	}

}
