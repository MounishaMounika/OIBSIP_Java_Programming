package com.ATM_Interface.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ATM_Interface.Beans.DepositWithdrawBean;
import com.ATM_Interface.Model.AmountDb;

/**
 * Servlet implementation class Withdraw
 */
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
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
		double withdrawAmount=Double.parseDouble(request.getParameter("withdrawAmount"));
		
		DepositWithdrawBean withdraw=new DepositWithdrawBean();
		
		withdraw.setAccountNumber(accountNumber);
		withdraw.setAmount(withdrawAmount);
		
		AmountDb amount=new AmountDb();
		String message=amount.withdrawAmount(withdraw);
		
		request.setAttribute("WithdrawMessage", message);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
        return;
	}

}
