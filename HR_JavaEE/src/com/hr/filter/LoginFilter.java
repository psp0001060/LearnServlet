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
		int nowHour = currentDate.getHours();//�Ӻ��ߴ���÷����Ѿ���ʱ�����Ա��µĴ��棬������Ȼ����ʹ��
		
		/* �·�ʽ
		 Calendar cal = Calendar.getInstance();
		int nowH = cal.get(Calendar.HOUR_OF_DAY);*/
		
		if (nowHour < start || nowHour >end) {
			request.setAttribute("msg", "����Ӫҵʱ��");
			request.getRequestDispatcher("../login.jsp").forward(request,response);

		}
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("username");
		if(null == userName){//δ��¼
			request.setAttribute("msg", "����Դ�����¼�����");
			request.getRequestDispatcher("../login.jsp").forward(request,response);
		}
		filterChain.doFilter(request, response);//����ִ��
	}

	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
