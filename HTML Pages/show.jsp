

<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%

 
String connectionURL = "jdbc:mysql://localhost:3306/test";
String user = "root";
String pass = "root";
 
Connection con = null;

try{
    Class.forName("com.mysql.jdbc.Driver");
    con =DriverManager.getConnection("jdbc:mysql://localhost:3306/art_gallery","root","root");
    String id1 = request.getParameter("id");
    
    PreparedStatement ps = con.prepareStatement("select id,img_id,price from paintings where id=id1 ");
  
    ResultSet rs = ps.executeQuery();
 
    out.println("<html><body><h2>Artists: </h2>");
    out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
    out.println("<tr>");
    out.println("<td><b>ID</b></td>");
    out.println("<td><b>IMAGE ID</b></td>");
    out.println("<td><b>Price</b></td>");
    out.println("</tr>");
  
    while(rs.next()) {
     out.println("<tr>");
     out.println("<td>"+rs.getString(1) + "</td>");
     out.println("<td>"+rs.getString(2) + "</td>");
     out.println("<td>"+rs.getString(3) + "</td>");
   
     out.println("</tr>");
  
    }

    
 
    out.println("</body></html>");
}
catch(Exception e){
    e.printStackTrace();
}   
finally{
    if(con != null){
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
%>