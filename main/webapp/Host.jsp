<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="InitialStyle.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Event</title>
</head>
<body>
<center><br>
			<h2 style="color: green">
				Welcome
				<%
			out.println(session.getAttribute("email"));
			%>
				!
			</h2>
		</center>
		<form method="post" action="ManageParty.jsp">
    <div class="clearfix">
      <button type="submit" class="signupbtn">Manage Existing Party</button>
    
    </div>
        <div class="clearfix">
     
      <button type="submit" class="signupbtn">Create a Party</button>
    </div>
    </form>
</body>
</html>