import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutDb extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}