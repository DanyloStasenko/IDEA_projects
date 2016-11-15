package jsp;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;


public class AuthFilter implements Filter{
	
	private List<String> pathFilters = Arrays.asList(new String[]{"add","remove","update","home.html", "home.jsp"});
	
	
	public AuthFilter() {
		
	}

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
		throws IOException, ServletException {
		
		String uri = ((HttpServletRequest) request).getRequestURI();
		String path = StringUtils.substringAfterLast(uri, "/");
		
		if (!pathFilters.contains(path)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		User user = (User) session.getAttribute("PRINCIPAL");
		
		if (user != null) {
			filterChain.doFilter(request, response);
		}
		
		((HttpServletResponse) response).sendRedirect("login.jsp?loginorpassword=invalid");
	}
	
	
	@Override
	public void destroy() {
		
	}
}
