package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet5
 */
@WebServlet("/servlet5")
public class servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String page=request.getParameter("page");
		
		if(page!=null && page.equalsIgnoreCase("1"))
		{
			response.sendRedirect("buy1.html");
		}
		else if(page!=null && page.equalsIgnoreCase("2"))
		{
			response.sendRedirect("buy2.html");
		}
		else if(page!=null && page.equalsIgnoreCase("3"))
		{
			response.sendRedirect("buy3.html");
		}

		else if(page!=null && page.equalsIgnoreCase("4"))
		{
			response.sendRedirect("buy4.html");
		}

		else if(page!=null && page.equalsIgnoreCase("5"))
		{
			response.sendRedirect("buy5.html");
		}

	}

}
