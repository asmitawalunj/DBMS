<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
body{
background-image: url("http://www.amfahdehumidifier.com/images/solution/art.jpg");


background-position:center;
background-repeat:off;
background-size:cover;
}
fieldset{
border:3px solid rgb(0,150,200);
font-size:16pt;

margin: auto;text-align:center;
}
</style>
<title>Login Page</title>
</head>
<body>
<form action="servlet" method="get">
  <fieldset  style="width:350px" >
    <legend><h2><font color="black"><i>LOGIN!!</i></h2></legend>

   UserName:<br>
    <input type="text" name="email" >
	<br>
	<br>
	
	Password:<br>
	<input type="password" name="pass">
	<br>
	<br>
	
    
<input type="submit" style="align:center" value="LOGIN" >
<br>
  </fieldset>
</form>
</body>
</html>