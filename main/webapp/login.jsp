<html>
<link rel="stylesheet" type="text/css" href="InitialStyle.css">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>

</head>

<body>

<%! String userdbName;

String userdbPsw;

String dbUsertype;

%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%

Connection con= null;

PreparedStatement ps = null;

ResultSet rs = null;



String driverName = "com.mysql.jdbc.Driver";

String url = "jdbc:mysql://localhost:3306/party_reservation_db";

String user = "root";

String dbpsw = "1";



String sql = "select * from users where email=? and password=? and typeofusers=?";



String email = request.getParameter("email");

String password = request.getParameter("password");

String typeofusers = request.getParameter("typeofusers");


out.println(email+" "+password+" "+typeofusers);

if((!(email.equals(null) || email.equals("")) && !(password.equals(null) || 
password.equals(""))) && !typeofusers.equals("select"))

{

try{

Class.forName(driverName);

con = DriverManager.getConnection(url, user, dbpsw);

ps = con.prepareStatement(sql);

ps.setString(1, email);

ps.setString(2, password);

ps.setString(3, typeofusers);

rs = ps.executeQuery();

if(rs.next())

{ 

userdbName = rs.getString("email");

userdbPsw = rs.getString("password");

dbUsertype = rs.getString("typeofusers");

if(email.equals(userdbName) && password.equals(userdbPsw) && typeofusers.equals(dbUsertype))

{
out.println(userdbName+" "+userdbPsw+" "+dbUsertype);
session.setAttribute("email",userdbName);
session.setAttribute("typeofusers", dbUsertype); 
if(dbUsertype.equals("HOST"))
response.sendRedirect("Host.jsp"); 
else
response.sendRedirect("Welcome.jsp"); 
	
} 
 

}

else
	
response.sendRedirect("index.jsp");

rs.close();

ps.close(); 

}

catch(SQLException sqe)

{

out.println(sqe);

} 

}

else

{

%>

<center><p style="color:red">Error In Login</p></center>

<% 

getServletContext().getRequestDispatcher("/index.jsp").include(request, 
response);

}

%>

</body>

</html>