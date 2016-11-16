package jsp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class HomeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	//private Integer status;
	
	public HomeServlet(){}

	
	@Override
	public void init() throws ServletException {
		//status = Integer.parseInt(getServletConfig().getInitParameter("paramname"));
		System.out.println("HomeServlet initialization: ");
	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("attribute", request.getAttribute("status"));
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		requestDispatcher.forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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