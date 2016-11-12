package jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		
		Cookie cookie = new Cookie("coo", "123");
		cookie.setMaxAge(60*60*24); 			// 1 day
		// cookie.setMaxAge(0); 				// delete cookie = setMaxAge(0) and add it !!!
		response.addCookie(cookie);
		
		for (Cookie tempCookie : request.getCookies()) {
			tempCookie.setMaxAge(0);
			response.addCookie(tempCookie);
		}
		
		
		
		// send data to home.jsp
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		requestDispatcher.forward(request, response);
		
		
		/*	// get cookies
		Cookie [] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
		}*/
		
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




