package jsp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CurrentFilter implements Filter{

	public CurrentFilter() {}
	
	private boolean status;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// some initialization
		this.status = Boolean.parseBoolean(filterConfig.getInitParameter("status"));
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		//	request -> (if filter) -> doFilter -> than servlet
		//	do filter = init + doFilter
		
		request.setAttribute("status", this.status);
		filterChain.doFilter(request, response);
		
	}
	
	@Override
	public void destroy() {
		// nothing to write here
	}
}