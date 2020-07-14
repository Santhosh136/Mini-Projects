import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class LoginDb extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String dbURL = "jdbc:mysql://localhost:3306/"; 
		
		String dbName = "test"; 
		String dbUsername = "root"; 
		String dbPassword = "student"; 

		String reg = request.getParameter("regno");
		String passwd = request.getParameter("passwd");
		out.write("<center>");
		try {
			Class.forName( "com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword); 

			//PreparedStatement st = con.prepareStatement("select * from register where regno=? and passwd=?");
			// st.setString(1,reg);
			// st.setString(2,passwd);
			Statement st = con.createStatement();
			String sql = "select * from register where regno="+reg+" and passwd='"+passwd+"';";
			ResultSet rs = st.executeQuery(sql);

			//Statement stmt = con.createStatement();
			//String sql;
			//sql = "SELECT * FROM register";
			//ResultSet rs = stmt.executeQuery(sql);

			if(rs.next() == false) {
				out.write("<h2>There is no such entry please register...</h2>");
				out.write("<a href='index.jsp'><p style='font-family:sans-serif; font-size:20px; color:green'>Click here to go home</p></a>");
			}
			else if(rs.getString("verify").equals("no")) {
				out.write("<h2>User is not yet verified</h2>");
				out.write("<a href='index.jsp'><p style='font-family:sans-serif; font-size:20px; color:green'>Click here to go home</p></a>");
			}
			else {
				String regno = rs.getString(1);
				Cookie r = new Cookie("regno",regno);

				response.addCookie(r);

				session.setAttribute("isLogin", "yes");
				session.setAttribute("regno",regno);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		catch(SQLException se){
			out.write("<h2>Something went wrong with database server. </h2>");
			out.write("<a href='index.jsp'><p style='font-family:sans-serif; font-size:20px; color:green'>Click here to go home</p></a>");
		}  		
		catch(Exception e) {
			out.write("<h2>Something went wrong</h2>");
			out.write("<a href='index.jsp'><p style='font-family:sans-serif; font-size:20px; color:green'>Click here to go home</p></a>");
		}
		out.write("<center>");
		out.close();

	}
}
