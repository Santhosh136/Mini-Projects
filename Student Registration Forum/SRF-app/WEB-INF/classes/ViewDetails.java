import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import student.Student;

public class ViewDetails extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String dbURL = "jdbc:mysql://localhost:3306/"; 		
		String dbregister = "test"; 
		String dbUserregister = "root"; 
		String dbPassword = "student"; 
		String sql = "";

		String value = request.getParameter("choice");
		if(value.equals("single")) {
			
			String regno = request.getParameter("regno");
			sql = "select * from register where regno="+regno+";";
			
		}
		else if(value.equals("club")) {
			
			String club = request.getParameter("club");
			sql = "select * from register where regno in(select regno from "+club+")";
			
		}
		else if(value.equals("dept")) {
			
			String dept = request.getParameter("dept");
			sql = "select * from register where dept='"+dept+"';";
			
		}
		else {
			out.println("Please select an option");
		}

		try {
			Class.forName( "com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(dbURL + dbregister, dbUserregister, dbPassword); 

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			Integer i=0;

			Student s[] = new Student[10];
			while(rs.next()) {
				int regno = Integer.valueOf(rs.getString(1));
				String name = rs.getString(2);
				String dob = rs.getString(3);
				String dept = rs.getString(4);
				String gender = rs.getString(5);
				String passwd = rs.getString(6);
				String verify = rs.getString(7);

				s[i] = new Student(regno, name, dob, dept, gender, passwd, verify);
				i++;
			}

			request.setAttribute("students", s);
			request.setAttribute("length",i);
			request.getRequestDispatcher("details.jsp").forward(request, response);


		}
		catch(SQLException se){
			out.println(se+"\n");
		}  		
		catch(Exception e) {
			out.println(e);
		}
	}
}
