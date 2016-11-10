package jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private Integer status;
	
	public HomeServlet(){}

	@Override
	public void init() throws ServletException {
		status = Integer.parseInt(getServletConfig().getInitParameter("paramname"));
		System.out.println("Status: " +status);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setFirstName("Ivan");
		user.setLastName("Ivanov");
		user.setAge(15);
		
		request.setAttribute("user", user);
		
		request.setAttribute("a", 1);
		request.setAttribute("b", 222);
		request.setAttribute("status", status);
		
		// send data to home.jsp
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		requestDispatcher.forward(request, response);
		
//		String value = getServletContext().getInitParameter("name");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}