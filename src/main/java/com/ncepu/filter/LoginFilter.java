package com.ncepu.filter;


import javax.servlet.*;
import java.io.IOException;


/**
 * @date 2018-4-11
 * @author zhangC
 * 这是个过滤器 用于验证用户登陆 (查找session)
 * 把图片的路径过滤掉，否则会出现图片无法加载
 * 
 *
 */
public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
//		HttpServletRequest servletRequest = (HttpServletRequest)request;
//		HttpServletResponse servletResponse = (HttpServletResponse) response;
//		HttpSession session = servletRequest.getSession();
//
//		String path = servletRequest.getRequestURI();
//
//		System.out.println("当前路径："+path);
//		User currentUser = (User)session.getAttribute("currentUser");
//		if (path.indexOf("index3.jsp") > -1 || path.indexOf("teacherLogin.jsp") > -1
//				|| path.indexOf("studentLogin.jsp") > -1 || path.indexOf("adminLogin.jsp") > -1
//				|| path.indexOf("login") > -1 || path.indexOf("adminLogin.jsp") > -1 || path.indexOf(".jpg") > -1
//				|| path.indexOf(".html") > -1 || path.indexOf(".png") > -1 || path.indexOf(".css") > -1
//				|| path.indexOf(".js") > -1) {
//			chain.doFilter(servletRequest, servletResponse);
//			return;
//		}
//		if(currentUser == null || "".equals(currentUser)) {
//			//servletResponse.sendRedirect("${pageContext.request.contextPath}/index3.jsp");
//			//servletRequest.getRequestDispatcher("/index3.jsp").forward(request, response);
//			servletResponse.sendRedirect("/BSManager/index.jsp");
//		}else {
//			chain.doFilter(servletRequest, servletResponse);
//		}
		chain.doFilter(request,response);
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
