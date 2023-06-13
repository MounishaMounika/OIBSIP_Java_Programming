package com.ATM_Interface.Controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ATM_Interface.Beans.RegisterBean;
import com.ATM_Interface.Model.UserDb;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		long pin=Integer.parseInt(request.getParameter("pin"));
		long confirmPin=Integer.parseInt(request.getParameter("confirmPin"));
		String name=request.getParameter("name");
		String education=request.getParameter("education");
		String occupation=request.getParameter("occupation");
		String phone=request.getParameter("phone");
//		String dob=request.getParameter("DOB");
		
		if (pin!=confirmPin) {
	        request.setAttribute("error", "Pin and Confirm Pin do not match");
	        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
	        rd.forward(request, response);
	        return;
	    }
//		Date d = new Date();
//		int year=d.getYear();
//		int dobYear=Integer.parseInt(dob.substring(6));
//		if((year-dobYear)<18)
//		{
//			request.setAttribute("AgeMessage", "Age should be greater than 18");
//	        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
//	        rd.forward(request, response);
//	        return;
//		}
		
		RegisterBean rb=new RegisterBean();
		
		rb.setAccountNumber(accountNumber);
		rb.setPin(pin);
		rb.setConfirmPin(confirmPin);
		rb.setName(name);
		rb.setEducation(education);
		rb.setOccupation(occupation);
		rb.setPhone(phone);
//		rb.setDob(dob);
		
		UserDb ud=new UserDb();
		boolean accountExists =ud.checkAccountExists(accountNumber);
		
		if (accountExists) {
	        request.setAttribute("errorMessage", "User already exists with account number: " + accountNumber);
	        request.getRequestDispatcher("register.jsp").forward(request, response);
	        return;
	    }
		else
		{
		 ud.insertUser(rb);
		 request.setAttribute("RegisterMessage", "Registration Successful " + name+" !");
	     request.getRequestDispatcher("index.jsp").forward(request, response);
	     return;
		}
	}

}
