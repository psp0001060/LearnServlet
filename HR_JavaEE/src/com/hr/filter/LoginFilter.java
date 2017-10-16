package com.hr.filter;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private int start;
	private int end;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		start = Integer.valueOf(filterConfig.getInitParameter("start"));
		end = Integer.valueOf(filterConfig.getInitParameter("end"));
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		Date currentDate = new Date();
		int nowHour = currentDate.getHours();//加横线代表该方法已经过时，可以被新的代替，但是依然可以使用
		
		/* 新方式
		 Calendar cal = Calendar.getInstance();
		int nowH = cal.get(Calendar.HOUR_OF_DAY);*/
		
		if (nowHour < start || nowHour >end) {
			request.setAttribute("msg", "超出营业时间");
			request.getRequestDispatcher("../login.jsp").forward(request,response);

		}
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("username");
		if(null == userName){//未登录
			request.setAttribute("msg", "该资源必须登录后访问");
			request.getRequestDispatcher("../login.jsp").forward(request,response);
		}
		filterChain.doFilter(request, response);//继续执行
	}

	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
