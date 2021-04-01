<%@ page import="java.sql.*"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home</title>

</head>

<body>

	<%
	String zip = request.getParameter("zip");
	Connection con = null;

	PreparedStatement ps = null;

	ResultSet rs = null;

	String driverName = "com.mysql.jdbc.Driver";

	String url = "jdbc:mysql://localhost:3306/party_reservation_db";

	String user = "root";

	String password = "1";

	String sql = "select * from place";

	try {

		Class.forName(driverName);

		con = DriverManager.getConnection(url, user, password);

		ps = con.prepareStatement(sql);

		rs = ps.executeQuery();
	%>

	<form method="post" action="login.jsp">
		<div class="container">
		<br>
			<center>
				<h2 style="color: green">
					Place in/near Zip:
					<%
				out.println(zip);
				%>
				</h2>
			</center>



			<%
			int count = 1;
			while (rs.next())

			{

				out.println(count + ". " + rs.getString("name"));
				out.println(rs.getString("code"));
				out.println(rs.getString("locations") + "<br>");
				count++;
			%>

			</option>

			<%
			}

			}

			catch (SQLException sqe)

			{

			out.println("home" + sqe);

			}
			%>
		</div>

	</form>

</body>

</html>