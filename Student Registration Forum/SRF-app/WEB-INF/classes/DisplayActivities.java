import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DisplayActivities extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String club = request.getParameter("club");
		String regno =(String) session.getAttribute("regno");

		String dbURL = "jdbc:mysql://localhost:3306/"; 			
		String dbName = "test"; 
		String dbUsername = "root"; 
		String dbPassword = "student"; 
		String activity[][] = new String[10][2];

		try{		

			Class.forName( "com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword); 

			Statement st = con.createStatement();

			String sql = "select * from "+club+" where regno="+regno+";";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()==false) 
				request.setAttribute("empty","yes");
			else {
				Integer i = 0;
				request.setAttribute("empty","no");
				rs.beforeFirst();

				while(rs.next()) {
					activity[i][0] = rs.getString(1);
					activity[i][1] = rs.getString(3);
					i++;
				}

				request.setAttribute("length",i);
				request.setAttribute("activity", activity);
			}
			request.getRequestDispatcher("display.jsp").forward(request, response);
			out.close();
		}
		catch(Exception e) {
			out.println(e);
		}

	}
}