import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class AddActivitiesDb extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String dbURL = "jdbc:mysql://localhost:3306/"; 
		String dbName = "test"; 
		String dbUsername = "root"; 
		String dbPassword = "student"; 

		HttpSession session = request.getSession();

		try {
			Class.forName( "com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword); 
			String club = request.getParameter("club");
			String activity = request.getParameter("activity");
			String regno =(String) session.getAttribute("regno");

			Statement st = con.createStatement();
			String sql = "insert into "+club+" values(now(),"+regno+",'"+activity+"');";

			int i = st.executeUpdate(sql);

			String clubName= null;
			if(club.equals("tm")) clubName = "Tamizh Mandram";
			else if(club.equals("sjc")) clubName = "SJC";
			else if(club.equals("rac")) clubName = "Rac DCT";
			else if(club.equals("ys")) clubName = "Y's club";
			else if(club.equals("green")) clubName = "Green Club";
			else if(club.equals("lds")) clubName = "LDS";

			if(i>0) {
				out.write("<center><br><br>");
				out.write("<p style='font-family:sans-serif; font-size:20px; color:green'>Added Successfully for "+clubName+"</p>");
				out.write("<a href='activities.html'><p style='font-family:sans-serif; font-size:20px; color:green'>Click here to go activities form</p></a>");
			out.write("</center>");
			}
			else {
			out.write("<p style='font-family:sans-serif; font-size:20px; color:green'>Went wrong</p>"); 
			}

		}
		catch(SQLException se){
			out.println(se+"\n");
		}  		
		catch(Exception e) {
			out.println(e);
		}

	}
}