package jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.backend.Sender;

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
		
		System.out.println(request.getParameter("name"));
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		int res = a + b;
		
		request.setAttribute("result", res);
		
		System.out.println(a);
		System.out.println(b);
		
		// send data to home.jsp
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		requestDispatcher.forward(request, response);
		
//		String value = getServletContext().getInitParameter("name");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get data
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		// do logic
		int result = a + b;
		
		// send data
		request.setAttribute("result", result);
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/post.jsp");
		requestDispatcher.forward(request, response);
		
		
	}
}




