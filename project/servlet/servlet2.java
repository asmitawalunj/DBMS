package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.*;

/**
 * Servlet implementation class servlet2
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    String query = null;
    String url = null;
    String username = null;
    String password = null;
    
    public void init(ServletConfig config) throws ServletException {
    
     url = "jdbc:mysql://localhost:3306/art_gallery";
     username = "root"; 
     password = "root"; 
     try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    
      connection = (Connection) DriverManager.getConnection(url, username , password);
     }
     catch (Exception e) {
    
      e.printStackTrace();
     }
    
    }
    
    protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response
      ) throws ServletException, IOException {
    
     doPost(request, response);
    
    }   
    
    protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response
      ) throws ServletException, IOException {
    
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
    
     System.out.println("Inside servlet2");
     query = "select aname,img_id from artist";
     try {
      preparedStatement = (PreparedStatement) connection.prepareStatement(query);
      resultSet = preparedStatement.executeQuery();
    
      out.println("<html><body><h2>Artists: </h2>");
      out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
      out.println("<tr>");
      out.println("<td><b>Name</b></td>");
      out.println("<td><b>Image Id</b></td>");
      out.println("</tr>");
    
      while(resultSet.next()) {
       out.println("<tr>");
       out.println("<td>"+resultSet.getString(1) + "</td>");
       out.println("<td>"+resultSet.getInt(2) + "</td>");
       out.println("</tr>");
    
      }
      
      
   
      out.println("</body></html>");
      

      
      out.print("<form action=\"viewimage.jsp");
      
      out.print("\" ");
     out.println("method=POST>");
    
      out.println("<input type=submit &emsp value=\"Go!!\">");
      out.println("</form>");	
      out.println("</table></br><hr>");
     /* out.println("Enter Artist's Name:\n");
      
      out.print("<form action=\"show.jsp");
      
      out.print("\" ");
     out.println("method=POST>");
      out.println("<input type=text name=\"id>");
     
      out.println("<br>");
      
      out.println("<br>");
      
      out.println("<br>");
      out.println("<input type=submit &emsp value=\"Go!!\">");
      out.println("</form>");	
      out.println("</table></br><hr>");*/
     
  
   
     }
     
     catch (SQLException e) {
    
      e.printStackTrace();
     }
      
    }
    
   @Override
   public void destroy() {
       try {             
    	
           resultSet.close();
                   preparedStatement.close();
       }
       catch (SQLException e) {
    
           e.printStackTrace();
       }   
    
   }

}
