package com.assgn63;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fusr");
		if (fname.equals(""))
		{
			fname = "nita";
		}
		String lname = request.getParameter("lusr");
		if (lname.equals(""))
		{
			lname = "more";
		}
		String email = request.getParameter("email");
		if (email.equals(""))
		{
			email = "aa@yahoo.com";
		}
		
		HttpSession hs = request.getSession();
		
		hs.setAttribute("fuser", fname);
		hs.setAttribute("luser", lname);
		hs.setAttribute("euser", email);
		hs.setMaxInactiveInterval(25);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<b> Session Created successfully </b>");
		pw.println("<br>");
		pw.println(" Welcome "+hs.getAttribute("fuser")+" "+hs.getAttribute("luser"));
		pw.println("Your email id is "+hs.getAttribute("euser"));
		pw.println("Session id is "+hs.getId());
		pw.println("Session created at "+new Date());
		
		
		
		
		
		
		
	}

}
