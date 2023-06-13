package com.ATM_Interface.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ATM_Interface.Beans.TransferBean;
import com.ATM_Interface.Model.AmountDb;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
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
		long transferAccount=Integer.parseInt(request.getParameter("transferAccount"));
		double transferAmount=Double.parseDouble(request.getParameter("transferAmount"));
		
		TransferBean tb=new TransferBean();
		
		//tb.setAcccountNumber(accountNumber);
		tb.setTranferAccount(transferAccount);
		tb.setTransferAmount(transferAmount);
		
		AmountDb ad=new AmountDb();
		String message=ad.transfer(tb);
	
		request.setAttribute("TransferMessage", message);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
        return;
		
	}

}
