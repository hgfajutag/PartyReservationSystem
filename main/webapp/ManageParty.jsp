<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="InitialStyle.css">
<head>
<meta charset="ISO-8859-1">
<title>Sign-up</title>
</head>
<body>
<form action="action_page.php" style="border:1px solid #ccc">
  <div class="container">
    <h1>Create a Party</h1>
    <p>Please fill in this form to create a Party.</p>
    <hr>
    <label for="partyName"><b>Party Name:</b></label>
    <input type="text" placeholder="Enter Party" name="partyName" required>
    <label for="Location"><b>Capacity</b></label>
    <input type="text" placeholder="Enter Capacity" name="Capacity" required>
    <label for="dateOfbirth"><b>Date</b></label>
    <input type="text" placeholder="Enter Date" name="dateOfbirth" required>
    
    <label for="Time1"><b>Start Time:</b></label>
    <input type="text" placeholder="Start Time:" name="time1" required>

    <label for="Time2"><b>End Time</b></label>
    <input type="text" placeholder="End Time" name="time2" required>
   
   <p>Address Section</p>
   
    <label for="add"><b>Address</b></label>
    <input type="text" placeholder="End Time" name="address" required>
        <label for="zip"><b>Zip</b></label>
    <input type="text" placeholder="End Time" name="zip" required>
    
    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Agree
    </label>
    <p>By Hosting a Party you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
    <a href="http://localhost:8081/connecting/Host.jsp">  <button type="button" class="cancelbtn">Cancel</button>
     </a> <button type="submit" class="signupbtn">Create</button>
    </div>
  </div>
</form>
</body>
</html>