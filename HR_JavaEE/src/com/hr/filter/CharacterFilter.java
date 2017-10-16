package com.hr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharacterFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		request.setCharacterEncoding("utf-8");
		arg2.doFilter(servletRequest, response);
	}

}
