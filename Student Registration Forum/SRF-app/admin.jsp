<!DOCTYPE html>
<html>
<head>
	<title>Admin Page</title>
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
		<h2>Verify Students</h2>
		<table cellspacing="20px" style="text-align: center;">
			<tr>
				<th>Regno</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Department</th>
				<th>Gender</th>
				<th>Verified</th>
			</tr>
			<%@
				page import="student.Student"
			%>

			<%
				Student s[] = (Student [])request.getAttribute("students");
				Integer length = (Integer) request.getAttribute("length");
				
				int i = 0;
				while(i<length) {

				out.println("<tr>");%>

				<td><%=s[i].getRegNo()%></td>
				<td><%=s[i].getName()%></td>
				<td><%=s[i].getDOB()%></td>
				<td><%=s[i].getDept()%></td>
				<td><%=s[i].getGender()%></td>
				<td><%=s[i].getVerify()%></td>


				<%if(s[i].getVerify().equals("no"))
					out.println("<td><a href='verify?regno="+s[i].getRegNo()+"' >verify</a></td>");
				out.println("</tr>");
				i++;
				}
			%>
		</table>
		<br>
		<br>
		<a href="admin.html" style='font-family:sans-serif; font-size:20px; color:green'>Click here to go admin home</a>
	</center>
</body>
</html>