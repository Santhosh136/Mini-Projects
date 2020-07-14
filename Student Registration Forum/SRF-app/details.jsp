<!DOCTYPE html>
<html>
<head>
	<title>Student Details</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<style type="text/css">
		table,td,th {
			border:1px solid black;
		}

		table {
			border-collapse: collapse;
			width: 70%;
		}
	</style>
</head>
<body>
	<center>
		<hr style="margin-top: 30px;"><h1>Students Extra Curriculuar Activities Registration Forum</h1><hr style="margin-bottom: 40px;">
		<h2> Department of Information Technology </h2>
		<h2 style="font-family: sans-serif; color: green"> Government College of Technology, CBE - 13</h2>
		<br>
		<h2>Students Details</h2>
		<table cellspacing="20px" style="text-align: center;">
			<%@ page import="student.Student"%>
			<%
				Student s[] = (Student[])request.getAttribute("students");
				//int i=0;
				Integer length = (Integer) request.getAttribute("length");

				int i = 0;
				if(length==0) {
					out.println("<h2>No records</h2>");
				}	

				else {
					out.println("<tr>");
					out.println("<th>Regno</th>");
					out.println("<th>Name</th>");
					out.println("<th>DOB</th>");
					out.println("<th>Department</th>");
					out.println("<th>Gender</th>");
					out.println("<th>Password</th>");
					out.println("<th>Verified</th>");
					out.println("</tr>");

					while(i<length) {
					out.println("<tr>");
					out.println("<td>"+s[i].getRegNo()+"</td>");
					out.println("<td>"+s[i].getName()+"</td>");				
					out.println("<td>"+s[i].getDOB()+"</td>");
					out.println("<td>"+s[i].getDept()+"</td>");
					out.println("<td>"+s[i].getGender()+"</td>");
					out.println("<td>"+s[i].getPasswd()+"</td>");
					out.println("<td>"+s[i].getVerify()+"</td>");
					out.println("</tr>");
					i++;
					}
				}
			%>
		</table>
		<br>
		<br>
		<a href="admin.html" style='font-family:sans-serif; font-size:20px; color:green'>Click here to go admin home</a>
	</center>
</body>
</html>