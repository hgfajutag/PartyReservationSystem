<%@ page import="java.sql.*"%>
<%@ page import="dbcon.ConnectionDB"%>
<link rel="stylesheet" type="text/css" href="InitialStyle.css">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home</title>

</head>

<body>

	<%
	try {

		Connection k = ConnectionDB.conn();
		Statement stmt6 = k.createStatement();
		ResultSet rs = stmt6.executeQuery("select typeofusers from users");
	%>


	<form method="post" action="login.jsp">
		<br>
		<center>
			<h2>Party Reservation System</h2>
		</center>

		<div class="container">

			<p>Please fill in this form to login.</p>
			<hr>
			<label for="email"><b>Enter Your Email</b></label> <input type="text"
				placeholder="Enter Email" name="email" required> <label
				for="password"><b>Enter Your Password </b></label> <input
				type="password" placeholder="Enter password" name="password"
				required> <label for="typeofusers"><b>User Type:
			</b></label> <select name="typeofusers">

				<option value="GUEST">Guest</option>
				<option value="HOST">Host</option>

				<%
				while (rs.next())

				{

					String typeofusers = rs.getString("email");
				%>

				<option value=<%=typeofusers%>><%=typeofusers%>
				</option>

				<%
				}
				} catch (SQLException r) {
				System.out.println(r);
				}
				%>

			</select>
			<div class="clearfix">
				<button type="submit" class="signupbtn">Log-in</button>
			</div>
			&nbsp;&nbsp;&nbsp; <a href="sign-up.jsp"> Sign-up </a>
		</div>


	</form>

</body>

</html>