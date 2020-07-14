import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class VerifyUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String regno = request.getParameter("regno");
		String dbURL = "jdbc:mysql://localhost:3306/"; 		
		String dbregister = "test"; 
		String dbUserregister = "root"; 
		String dbPassword = "student"; 

		try {
			Class.forName( "com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(dbURL + dbregister, dbUserregister, dbPassword); 
			Statement st = con.createStatement();
			String sql = "update register set verify='yes' where regno="+regno+";";

			int i = st.executeUpdate(sql);
			request.getRequestDispatcher("admin").forward(request, response);
		}
		catch(SQLException se){
			System.out.println(se+"\n");
		}  		
		catch(Exception e) {
			System.out.println(e);
		}		

	}
}

