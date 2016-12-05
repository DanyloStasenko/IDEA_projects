package jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private UserDatasource userDatasource;
	
	public LoginServlet() {
		userDatasource = new UserDatasource();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		if (username != null && password != null) {
			User user = userDatasource.getByUsernameAndPassword(username, password);
			if (user != null) {
				session.setAttribute("PRINCIPAL", user);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
				requestDispatcher.forward(request, response);
				return;	
			}
		}
		
		System.out.println("redirecting to invalid");
		response.sendRedirect("login.jsp?loginorpassword=invalid");
	}
}