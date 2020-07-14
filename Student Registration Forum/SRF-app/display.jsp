<!DOCTYPE html>
<html>
<head>
	<title>Activities</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<style type="text/css">
		table,td,th {
			border:1px solid black;
			text-align: center;
		}

		table {
			border-collapse: collapse;
			width: 40%;
		}
	</style>
</head>
<body>
	<center>
		<hr style="margin-top: 30px;"><h1>Students Extra Curriculuar Activities Registration Forum</h1><hr style="margin-bottom: 40px;">
		<h2> Department of Information Technology </h2>
		<h2 style="font-family: sans-serif; color: green"> Government College of Technology, CBE - 13</h2>
		<hr>
		<br>
		<%
			String club = request.getParameter("club");
			String regno =(String) session.getAttribute("regno");
			String clubName= null;
			if(club.equals("tm")) clubName = "Tamizh Mandram";
			else if(club.equals("sjc")) clubName = "SJC";
			else if(club.equals("rac")) clubName = "Rac GCT";
			else if(club.equals("ys")) clubName = "Y's club";
			else if(club.equals("green")) clubName = "Green Club";
			else if(club.equals("lds")) clubName = "LDS";

			out.write("<h1>"+clubName+"</h1>");
			
		%>

		<table cellspacing="20px" style="font-family: sans-serif; font-size: 20px; border-width: 2px; border-style: solid;">
		<%
			String empty = (String) request.getAttribute("empty");
			if(empty.equals("yes")) {
				out.println("<h4>No more activities in this club</h4>");
			}
			else {
				String activity[][] = (String[][]) request.getAttribute("activity");
				int length = (Integer) request.getAttribute("length");
				
				int i = 0;
				out.println("<tr><th>Date and Time</th><th>Acitivity</th></tr>");
				while(i<length) {
					out.println("<tr><td>"+activity[i][0]+"</td><td>"+activity[i][1]+"</td></tr>");
					i++;
				}
			}	
		%>
	</table>
	<br>

	<a href="index.jsp" style='font-family:sans-serif; font-size:20px; color:green'>Click here to go home</a>
	</center>
</body>
</html>