package com.ATM_Interface.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ATM_Interface.Beans.BalanceBean;
import com.ATM_Interface.Model.AmountDb;

/**
 * Servlet implementation class Balance
 */
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Balance() {
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
		long pin=Integer.parseInt(request.getParameter("balancepin"));
		
		BalanceBean bb=new BalanceBean();
		//bb.setAccountNumber(accountNumber);
		bb.setPin(pin);
		
		AmountDb ad=new AmountDb();
		String message=ad.checkBalance(bb);
		
		request.setAttribute("BalanceMessage", message);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
        return;
	}

}
