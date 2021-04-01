<%@ page import="java.sql.*" %>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home</title>

</head>

<body>

<%

Connection con= null;

PreparedStatement ps = null;

ResultSet rs = null;



String driverName = "com.mysql.jdbc.Driver";

String url = "jdbc:mysql://localhost:3306/party_reservation_db";

String user = "root";

String password = "1";



String sql = "select typeofusers from users";



try {

Class.forName(driverName);

con = DriverManager.getConnection(url, user, password);

ps = con.prepareStatement(sql);

rs = ps.executeQuery(); 

%>

<form method="post" action="login.jsp">

<center><h2 style="color:green">Party Reservation System Login Example</h2></center>

<table border="1" align="center">

<tr>

<td>Enter Your Email :</td>

<td><input type="text" name="email"/></td>

</tr>

<tr>

<td>Enter Your Password :</td>

<td><input type="password" name="password"/></td>

</tr>

<tr>

<td>Select UserType</td>

<td><select name="typeofusers">

<option value="select">select</option>
<option value="Guest">Guest </option>
<option value="Host">Host</option>

<%

while(rs.next())

{

String typeofusers = rs.getString("email");
%>

<option value=<%=typeofusers%>><%=typeofusers%> </option>

<% 

}

}

catch(SQLException sqe)

{

out.println("home"+sqe);

}

%>

</select>

</td>

</tr>

<tr>

<td></td>

<td><input type="submit" value="submit"/>
	&nbsp;&nbsp;&nbsp; <a href="/Signup.jsp"> Sign-up </a>
</td>



</table>

</form>

</body>

</html>