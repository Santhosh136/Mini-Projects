import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import student.Student;

public class AdminDb extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String dbURL = "jdbc:mysql://localhost:3306/"; 		
		String dbregister = "test"; 
		String dbUserregister = "root"; 
		String dbPassword = "student"; 

		try {
			Class.forName( "com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(dbURL + dbregister, dbUserregister, dbPassword); 

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from register");

			Integer i=0;

			// String register[][] = new String[10][7];

			Student s[] = new Student[10];

			while(rs.next()) {
				// out.write("<tr>");
				// out.write("<td>"+rs.getString(1)+"</td>");
				// out.write("<td>"+rs.getString(2)+"</td>");
				// out.write("<td>"+rs.getString(3)+"</td>");
				// out.write("<td>"+rs.getString(4)+"</td>");
				// out.write("<td>"+rs.getString(5)+"</td>");
				// out.write("<td>"+rs.getString(7)+"</td>");
				// session.setAttribute("regno", rs.getString(1));
				// if(rs.getString(7).equals("no"))out.write("<td><a href='verify.jsp?regno="+rs.getString(1)+"' >verify</a></td>");
				// out.write("</tr>");

				s[i] = new Student(Integer.valueOf(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				i++;
			}

			request.setAttribute("students", s);
			request.setAttribute("length",i);
			request.getRequestDispatcher("admin.jsp").forward(request, response);


		}
		catch(SQLException se){
			out.println(se+"\n");
		}  		
		catch(Exception e) {
			out.println(e);
		}
	}
}