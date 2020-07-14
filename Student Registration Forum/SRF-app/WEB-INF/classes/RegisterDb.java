import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class RegisterDb extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("uname");
		String regno = request.getParameter("regno");
		String dob = request.getParameter("dob");
		String dept = request.getParameter("dept");
		String gender = request.getParameter("gender");
		String passwd = request.getParameter("passwd");

		// out.println("<p>Name:"+name+"</p>");
		// out.println("<p>Register No:"+regno+"</p>");
		// out.println("<p>DOB:"+dob+"</p>");
		// out.println("<p>Department:"+dept+"</p>");
		// out.println("<p>Gender:"+gender+"</p>");

		String dbURL = "jdbc:mysql://localhost:3306/"; 
		// Database name to access 
		String dbName = "test"; 
		String dbUsername = "root"; 
		String dbPassword = "student"; 

		try {
			Class.forName( "com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword); 

			PreparedStatement st = con.prepareStatement("insert into register values(?,?,?,?,?,?,'no')");
			st.setString(1,regno);
			st.setString(2,name);
			st.setString(3,dob);
			st.setString(4,dept);
			st.setString(5,gender);
			st.setString(6,passwd);

			int i = st.executeUpdate();
			if(i>0) {
				out.write("<center><br><br>");
				out.write("<p style='font-family:sans-serif; font-size:20px; color:green'>Registered Successfully</p>");
				out.write("<a href='index.jsp'><p style='font-family:sans-serif; font-size:20px; color:green'>Click here to go home</p></a>");
			out.write("</center>");
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