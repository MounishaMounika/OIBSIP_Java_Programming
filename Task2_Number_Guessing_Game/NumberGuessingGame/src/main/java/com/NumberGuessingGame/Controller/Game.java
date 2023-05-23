package com.NumberGuessingGame.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Game
 */
public class Game extends HttpServlet {
	int score=0;
	int limit=5;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter()/*.append("Served at: ").append(request.getContextPath())*/;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		int num=Integer.parseInt(request.getParameter("number"));
		Random random = new Random();
	    int randomNumber = random.nextInt(101);
	    request.setAttribute("randomNumber", randomNumber);
	    if(limit!=1)
	    {
	    if(num>100||num<1)
	    {
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>Number Guessing Game</title>");
	    	out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
	    	out.println("</head>");
	    	out.println("<body>");
	    	out.println("<div class=\"container\">");
	    	out.println("<div class=\"box\">");
	    	out.println("Invalid Number<br>");
	    	out.println("Remaining attemps: "+limit);
	    	out.println("<form action=\"index.jsp\"><input type=\"submit\" value=\"Go Back\"></form>");
	    	out.println("</div>");
	    	out.println("</div>");
	    	out.println("</body>");
	    	out.println("</html>");
	    }
	    else
	    {
	    if(num>randomNumber)
	    {
	    	limit--;
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>Number Guessing Game</title>");
	    	out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
	    	out.println("</head>");
	    	out.println("<body>");
	    	out.println("<div class=\"container\">");
	    	out.println("<div class=\"box\">");
	    	out.println("Random Number is "+randomNumber+"<br>");
	    	out.println("Your Number is Higher<br>");
	    	out.println("Your score is "+score+"<br>");
	    	out.println("Remaining attemps: "+limit);
	    	out.println("<form action=\"index.jsp\"><input type=\"submit\" value=\"Go Back\"></form>");
	    	out.println("</body>");
	    	out.println("</html>");
	    }
	    else if(num<randomNumber)
	    {
	    	limit--;
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>Number Guessing Game</title>");
	    	out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
	    	out.println("</head>");
	    	out.println("<body>");
	    	out.println("<div class=\"container\">");
	    	out.println("<div class=\"box\">");
	    	out.println("Random Number is "+randomNumber+"<br>");
	    	out.println("Your Number is Lower<br>");
	    	out.println("Your score is "+score+"<br>");
	    	out.println("Remaining attemps: "+limit);
	    	out.println("<form action=\"index.jsp\"><input type=\"submit\" value=\"Go Back\"></form>");
	    	out.println("</body>");
	    	out.println("</html>");
	    }
	    else
	    {
	    	limit--;score++;
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>Number Guessing Game</title>");
	    	out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
	    	out.println("</head>");
	    	out.println("<body>");
	    	out.println("<div class=\"container\">");
	    	out.println("<div class=\"box\">");
	    	out.println("Random Number is "+randomNumber+"<br>");
	    	out.println("Hurraiah! That's Correct Number<br>");
	    	out.println("Your score is "+score+"<br>");
	    	out.println("Remaining attemps: "+limit);
	    	out.println("<form action=\"index.jsp\"><input type=\"submit\" value=\"Go Back\"></form>");
	    	out.println("</body>");
	    	out.println("</html>");
	    }
	    }
	    }
	    else if(limit==1)
	    {
	    	 if(num>100||num<1)
	 	    {
	    		out.println("<html>");
	 	    	out.println("<head>");
	 	    	out.println("<title>Number Guessing Game</title>");
	 	    	out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
	 	    	out.println("</head>");
	 	    	out.println("<body>");
	 	    	out.println("<div class=\"container\">");
		    	out.println("<div class=\"box\">");
	 	    	out.println("Invalid Number<br>");
	 	    	out.println("Remaining attemps: "+limit);
	 	    	out.println("</body>");
		    	out.println("</html>");
	 	    }
	 	    else
	 	    {
	 	    if(num>randomNumber)
	 	    {
	 	    	limit--;
	 	    	out.println("<html>");
		    	out.println("<head>");
		    	out.println("<title>Number Guessing Game</title>");
		    	out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
		    	out.println("</head>");
		    	out.println("<body>");
		    	out.println("<div class=\"container\">");
		    	out.println("<div class=\"box\">");
	 	    	out.println("Random Number is "+randomNumber+"<br>");
	 	    	out.println("Your Number is Higher<br>");
	 	    	out.println("Your score is "+score+"<br>");
	 	    	out.println("Remaining attemps: "+limit);
	 	    	out.println("</body>");
		    	out.println("</html>");
	 	    }
	 	    else if(num<randomNumber)
	 	    {
	 	    	limit--;
	 	    	out.println("<html>");
		    	out.println("<head>");
		    	out.println("<title>Number Guessing Game</title>");
		    	out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
		    	out.println("</head>");
		    	out.println("<body>");
		    	out.println("<div class=\"container\">");
		    	out.println("<div class=\"box\">");
	 	    	out.println("Random Number is "+randomNumber+"<br>");
	 	    	out.println("Your Number is Lower<br>");
	 	    	out.println("Your score is "+score+"<br>");
	 	    	out.println("Remaining attemps: "+limit);
	 	    	out.println("</body>");
		    	out.println("</html>");
	 	    }
	 	    else
	 	    {
	 	    	limit--;score++;
	 	    	out.println("<html>");
		    	out.println("<head>");
		    	out.println("<title>Number Guessing Game</title>");
		    	out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
		    	out.println("</head>");
		    	out.println("<body>");
		    	out.println("<div class=\"container\">");
		    	out.println("<div class=\"box\">");
	 	    	out.println("Random Number is "+randomNumber+"<br>");
	 	    	out.println("Hurraiah! That's Correct Number<br>");
	 	    	out.println("Your score is "+score+"<br>");
	 	    	out.println("Remaining attemps: "+limit);
	 	    	out.println("</body>");
		    	out.println("</html>");
	 	    }
	 	    }
	    	
	    	out.println("<form action=\"index.jsp\"><input type=\"submit\" value=\"Play Again\"></form>");
	    	limit=5;
	    	score=0;
	    	
	    }
		
	}

}
