package com.project.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.project.pojo.pojoclass;
import com.project.pojo.pojoclass1;

public class daoclass implements daointerface {
	public boolean insert(pojoclass p)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/art_gallery", "root", "root");
			System.out.println("Dao class");
			PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getAddress());
			ps.setDouble(3,p.getMob());
			ps.setString(4,p.getEmail());
			ps.setString(5,p.getPassword());
			int i=ps.executeUpdate();
			if(i>0){
			System.out.println("Success");
			return true;
			}
			else
				System.out.println("Error");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error");
		}
		return false;
		
	}

	@Override
	public boolean search(pojoclass1 p1) {
		// TODO Auto-generated method stub
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/art_gallery", "root", "root");

			System.out.println("dao starts");
			
System.out.println(p1.getEmail()+"  "+p1.getPassword());
			PreparedStatement ps=con.prepareStatement("select * from customer where email=? and password=?");
			ps.setString(1,p1.getEmail());
			ps.setString(2,p1.getPassword());
			ResultSet rs=ps.executeQuery();
			System.out.println("dao complete");
			/* while (rs.next()) {
					
				
					String em=rs.getString("email");
					String pass=rs.getNString("password");
					
					System.out.println(em +"  "+pass );
				 
				}*/
			
			if(rs!=null )
			{
			System.out.println("Success");
			return true;
			}
			else
			{
				System.out.println("Error");
			}
		
	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error");
			return false;
		}
		return false;
	}

	
}
