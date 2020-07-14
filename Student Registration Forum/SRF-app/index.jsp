<!DOCTYPE html>
<html>
<head>
	<title>Welcome</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<style type="text/css">
		.grid-container {
			margin-top: 100px; 
			display: grid;
			grid-template-columns: auto auto auto;
			grid-gap: 50px;
		}
		.grid-item {
			display: inline-grid;
		}
		.grid-item p {
			font-family: sans-serif;
			font-size: 20px;
			
		}
		.grid-item img{
			border-color: limegreen;
			border-radius: 20px;
			border-style: solid;
		}
		hr {
			color: green;
			width: 300px;
			border: solid;
			border-width: 2px;
		}

	</style>
</head>
<body background="bg.jpg">
	<div class="bar" align="right">
		<%
			// if user is logged in 
			if(session.getAttribute("isLogin") != null) {
				out.write("<a href='activities.html' style='color:white'>Add activities</a>");
			}
		%>
		<%
			// if user is not logged in
			if(session.getAttribute("isLogin") == null ) {
				out.write("<a href='register.html' style='color:white'>Register</a>");
			}else {
			}	
		%>
		<%
			// if user is not logged in
			if(session.getAttribute("isLogin") == null ) {
				out.write("<a href='login.html' style='color:white'>Login</a>");
			}else { // else show options for profile and logout 
				out.write("<a href='profile' style='color:white'>Profile</a>");
				out.write("<a href='logout' style='color:white'>Logout</a>");
			}
		%>
	</div>
	<center>
		<hr style="margin-top: 30px;"><h1>Students Extra Curriculuar Activities Registration Forum</h1><hr style="margin-bottom: 40px;">
		<h2> Department of Information Technology </h2>
		<h2 style="font-family: sans-serif; color: green"> Government College of Technology, CBE - 13</h2>
	</center>
	<center>
		<div class="grid-container">
			<div class="grid-item"><img src="images/img-6.png" height="300px" width="300px"><p style='color:white'>Tamizh Mandram</p></div>
			<div class="grid-item"><img src="images/img-2.jpeg" height="300px" width="300px"><p style='color:white'>SJC</p></div>
			<div class="grid-item"><img src="images/img-3.jpeg" height="300px" width="300px"><p style='color:white'>RAC GCT</p></div>
			<div class="grid-item"><img src="images/img-5.jfif" height="300px" width="300px"><p>Y's club</p></div>
			<div class="grid-item"><img src="images/img-1.jfif" height="300px" width="300px"><p>Green Club</p></div>
			<div class="grid-item"><img src="images/img-4.png" height="300px" width="300px"><p>LDS</p></div>
		</div>
	</center>
	<center>
		<hr style="margin-top: 30px">
		<h3>About</h3>
		<h3> Contact Us</h3>
		<h4>Copyrights reserved 2020</h4>
		<hr style="margin-bottom: 20px;">
	</center>
	
</body>
</html>