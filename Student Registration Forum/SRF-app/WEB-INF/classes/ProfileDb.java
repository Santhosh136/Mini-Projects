import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import student.Student;

public class ProfileDb extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String profile[] = new String[5];
		HttpSession session = request.getSession();
		String dbURL = "jdbc:mysql://localhost:3306/"; 
		// Database name to access 
		String dbName = "test"; 
		String dbUsername = "root"; 
		String dbPassword = "student"; 


		String regno =(String) session.getAttribute("regno");
		try {
			Class.forName( "com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword); 

			PreparedStatement st = con.prepareStatement("select * from register where regno=?");
			st.setString(1,regno);
			ResultSet rs = st.executeQuery();

			rs.next();

			String name = rs.getString(2);
			String dob = rs.getString(3);
			String dept = rs.getString(4);
			String gender = rs.getString(5);

			Student s = new Student(Integer.valueOf(regno), name, dob, dept, gender, "", "");

			request.setAttribute("profile", s);
			request.getRequestDispatcher("profile.jsp").forward(request, response);
			// out.println(rs.getString(1));
			// out.println(rs.getString(2));
			// out.println(rs.getString(3));
			// out.println(rs.getString(4));
			// out.println(rs.getString(5));

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}