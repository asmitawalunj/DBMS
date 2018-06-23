package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.daoclass;
import com.project.dao.daointerface;
import com.project.pojo.pojoclass;
import com.project.pojo.pojoclass1;
import com.project.pojo.pojoclass3;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("in get");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		pojoclass3 pj=new pojoclass3();
		pj.setUser(email);
	//System.out.println(email+" "+password);
		pojoclass1 p1=new pojoclass1();
		p1.setEmail(email);
		p1.setPassword(password);
		
		System.out.println(p1.getEmail()+"  "+p1.getPassword());
		
		daointerface in=new daoclass();
		boolean b=in.search(p1);
		
		if(b)
			response.sendRedirect("menu.html");
		else
			response.sendRedirect("error.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("register"))
		{
			String name=request.getParameter("name");
			String address=request.getParameter("add");
			double mob=Double.parseDouble(request.getParameter("mob"));
			
			String email=request.getParameter("email");
			String password=request.getParameter("pass");
			
			
			pojoclass p=new pojoclass();
			p.setName(name);
			p.setAddress(address);
			p.setMob(mob);
			p.setEmail(email);
			p.setPassword(password);
			
			
			
			daointerface in=new daoclass();
			boolean b=in.insert(p);
			if(b)
				response.sendRedirect("menu.html");
			else
				response.sendRedirect("error.jsp");

		}
		
		else if(action!=null && action.equalsIgnoreCase("login"))
		{
			response.sendRedirect("login.jsp");
		}
		else if(action!=null && action.equalsIgnoreCase("artist"))
		{
			response.sendRedirect("servlet2");
		}
		else if(action!=null && action.equalsIgnoreCase("paintings"))
		{
			response.sendRedirect("img.html");
		}
		
		
	}

}
