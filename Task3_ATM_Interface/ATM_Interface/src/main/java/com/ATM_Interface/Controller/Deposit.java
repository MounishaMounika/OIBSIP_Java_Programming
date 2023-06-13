package com.ATM_Interface.Controller;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ATM_Interface.Beans.DepositWithdrawBean;
import com.ATM_Interface.Model.AmountDb;

/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
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
		//long accountNumber=Integer.parseInt(request.getParameter("accountNumber"));
		double depositAmount=Double.parseDouble(request.getParameter("depositAmount"));
		

		DepositWithdrawBean deposit=new DepositWithdrawBean();
		//deposit.setAccountNumber(accountNumber);
		deposit.setAmount(depositAmount);
		AmountDb amount=new AmountDb();
		String message=amount.insertAmount(deposit);
			
		request.setAttribute("DepositMessage", message);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
        return;
		}
		
	}



