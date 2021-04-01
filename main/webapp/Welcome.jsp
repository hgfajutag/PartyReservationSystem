<html>
<link rel="stylesheet" type="text/css" href="InitialStyle.css">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home</title>

</head>

<body>

	<form method="post" action="party.jsp">

		<center><br>
			<h2 style="color: green">
				Welcome
				<%
			out.println(session.getAttribute("email"));
			%>
				!
			</h2>
		</center>

		  <div class="container">
		  <table>
			<tr>

				<td>Enter Zipcode: <input type="text" name="zip" /> <button type="submit" class="signupbtn">Enter</button>

			</tr>
	
		</table>
		</div>

	</form>

</body>

</html>