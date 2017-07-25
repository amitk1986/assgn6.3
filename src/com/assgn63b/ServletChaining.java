package com.assgn63b;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletChaining
 */
@WebServlet("/ServletChaining")
public class ServletChaining extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		String ss = request.getParameter("fusrb");
		hs.setAttribute("usr", ss);
		PrintWriter pw = response.getWriter();
		pw.println("Welcome user "+hs.getAttribute("usr"));
		pw.println("Session id is "+hs.getId());
		RequestDispatcher dis= request.getRequestDispatcher("/ServletChaining2");
		dis.include(request, response);
	}

}
