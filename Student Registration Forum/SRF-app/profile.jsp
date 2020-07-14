<!DOCTYPE html>
<html>
<head>
	<title>Profile</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<style type="text/css">
		
	</style>
</head>
<body>
	<center>
		<hr style="margin-top: 30px;"><h1>Students Extra Curriculuar Activities Registration Forum</h1><hr style="margin-bottom: 40px;">
		<h2> Department of Information Technology </h2>
		<h2 style="font-family: sans-serif; color: green"> Government College of Technology, CBE - 13</h2>
	<table cellspacing="20px" cellpadding="10px" style="font-size: 20px; font-family: sans-serif;">
	<%@ page import="student.Student"%>
	<%
		Student s = (Student)request.getAttribute("profile");
		out.write("<tr><td>Regno</td>");
		out.write("<td>"+s.getRegNo()+"</td></tr>");
		out.write("<tr><td>Name</td>");
		out.write("<td>"+s.getName()+"</td></tr>");
		out.write("<tr><td>DOB</td>");
		out.write("<td>"+s.getDOB()+"</td></tr>");
		out.write("<tr><td>Department</td>");
		out.write("<td>"+s.getDept()+"</td></tr>");
		out.write("<tr><td>Gender</td>");
		out.write("<td>"+s.getGender()+"</td></tr>");
		

	%>
	</table>
	<form action="displayActivities" method="post">
		<p style="display: inline; margin-right: 40px; font-family: sans-serif; font-size: 20px;">My activities...</p>
		<select name="club">
			<option value="tm">Tamizh Mandram</option>
			<option value="sjc">SJC</option>
			<option value="rac">Rac GCT</option>
			<option value="ys">Y's club</option>
			<option value="green">Green Club</option>
			<option value="lds">LDS</option>
		</select>
		<br><br>
		<input type="submit" name="">
	</form>
	<br>
	<br>
	<a href="index.jsp" style='font-family:sans-serif; font-size:20px; color:green'>Click here to go home</a>
	</center>

</body>
</html>