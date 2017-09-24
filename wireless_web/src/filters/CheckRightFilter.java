package filters;

import java.io.IOException;
import java.util.ArrayList;
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

import entity.Usertbl;


public class CheckRightFilter implements Filter{
	private String sessionKey;
	private String checkUris;
	private String pageTogo;
	private List uris = new ArrayList();
	private FilterConfig config = null;
	
	public void destroy() {
		uris.clear();
		System.out.println("CheckRight");		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		request.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if(null == sessionKey){
			chain.doFilter(request, response);
		}else{
			HttpSession session = req.getSession();
			Object obj = session.getAttribute(sessionKey);
			
			if(this.isInCheckUris(req) && obj == null){
				res.sendRedirect(req.getContextPath()+pageTogo);
				return;
			}
			chain.doFilter(request, response);
		}
	}

	public void init( FilterConfig config) throws ServletException {
		this.config = config;
		this.sessionKey = config.getInitParameter("sessionKey");
		this.checkUris = config.getInitParameter("checkUris");
		this.uris.clear();
		this.uris = Arrays.asList(this.checkUris.split(";"));
		for(int i=0;i<uris.size();i++){
			System.out.println(uris.get(i));
		}
		this.pageTogo = config.getInitParameter("pageTogo");
	}
	
	public boolean isInCheckUris(HttpServletRequest req){
		String ContextPath = req.getContextPath();
		String path = req.getServletPath();
		String pathInfo = req.getPathInfo();
		String allpath = path + (pathInfo == null ? "" : pathInfo);
		System.out.println("allpath = "+allpath);
		return this.uris.contains(allpath);		
	}


}
