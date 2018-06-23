package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class servlet4
 */
@WebServlet("/servlet4")
public class servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet4() {
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
		
		  response.setContentType("text/html;charset=UTF-8");
		     PrintWriter out = response.getWriter();
		
		 try {
			 String id1=request.getParameter("id");
				System.out.println(id1);
			Class.forName("com.mysql.jdbc.Driver");
		
		   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/art_gallery","root","root");
		   
		    
		    PreparedStatement ps = (PreparedStatement) con.prepareStatement("select  artist.aname,artist.img_id,paintings.id,paintings.price from paintings,artist where artist.aname=? and artist.img_id=paintings.img_id;");
		    
		    ps.setString(1,id1);
		  
		    ResultSet rs = (ResultSet) ps.executeQuery();
		 
		    out.println("<html><body><h2>Artists: </h2>");
		    out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
		    out.println("<tr>");
		    out.println("<td><b>Name</b></td>");
		    out.println("<td><b>Image-ID</b></td>");
		    out.println("<td><b>ID</b></td>");
		    out.println("<td><b>Price</b></td>");
		    out.println("</tr>");
		  
		    while(rs.next()) {
		     out.println("<tr>");
		     out.println("<td>"+rs.getString(1) + "</td>");
		     out.println("<td>"+rs.getString(2) + "</td>");
		     out.println("<td>"+rs.getString(3) + "</td>");
		     out.println("<td>"+rs.getInt(4) + "</td>");
		   
		     out.println("</tr>");
		  
		    }

		    
		 
		    out.println("</body></html>");
		    out.print("<form action=\"final.jsp");
		      
		      out.print("\" ");
		     out.println("method=POST>");
		    
		      out.println("<input type=submit &emsp value=\"NEXT\">");
		      out.println("</form>");	
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
