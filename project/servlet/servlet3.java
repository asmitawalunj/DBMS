package com.project.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.InputStream;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class servlet3
 */
@WebServlet("/servlet3")
public class servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			System.out.println("inside servlet3");
			 Class.forName("com.mysql.jdbc.Driver");
			  Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/art_gallery","root","root");
			    
			    PreparedStatement ps = (PreparedStatement) con.prepareStatement("select artist.name,paintings.id,paitings.price from paintings,artist where artist.name=? and artist.img_id=paintings.img_id");
			   
			    ResultSet rs = (ResultSet) ps.executeQuery();
			 
			    if(rs.next()){
			        Blob blob = (Blob) rs.getBlob("image");
			        byte byteArray[] = blob.getBytes(1, (int)blob.length());
			 
			        response.setContentType("image.jpg");
			        OutputStream os = response.getOutputStream();
			        os.write(byteArray);
			        os.flush();
			        os.close();
			    }
			    System.out.println("success");
		}
			
			 catch (Exception e){
			e.printStackTrace();
			}
			}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
