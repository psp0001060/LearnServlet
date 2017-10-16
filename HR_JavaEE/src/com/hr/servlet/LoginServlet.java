package com.hr.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hr.pojo.Admin;
import com.hr.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int guestLoginCount = 0;//�û���¼����
		
		ServletContext ctxt = this.getServletContext();	
//		System.out.println(ctxt.getRealPath("login.jsp")); //��ȡ�ļ�ʵ��·��
//		System.out.println(ctxt.getInitParameter("level"));//�����ڲ���
		
		if(null !=ctxt.getAttribute("guestLoginCount")){
			guestLoginCount = Integer.valueOf(ctxt.getAttribute("guestLoginCount").toString());
		}
		
		LoginService ls = new LoginService();
		Admin admin = new Admin();
		admin.setAdminName(request.getParameter("userName"));
		admin.setAdminPassword(request.getParameter("pwd"));
		
		
		Admin adminRst = ls.queryAdmin(admin);
		if (null != adminRst) {

			switch (adminRst.getStatus()) {
			case "0":
				request.setAttribute("msg", "������ˣ���ȴ�");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				break;
			case "1":
				HttpSession session =request.getSession();
				
				//����û��Ѿ���¼�󣬽�ֹ���ˢ�º󣬷���������1
				if (session.getAttribute("username") == null) {
					guestLoginCount +=1;
				}
				
				//��¼�ɹ�����session�����key��username������
				session.setAttribute("username", request.getParameter("userName"));
				session.setMaxInactiveInterval(600);
				ctxt.setAttribute("guestLoginCount", guestLoginCount);

				
				int dayLenth = 0;
				
				if(null != request.getParameter("timelength")){
					Cookie userNameCookie = new Cookie("un",request.getParameter("userName"));
					Cookie pwdCookie = new Cookie("pwd",request.getParameter("pwd"));
					dayLenth =Integer.valueOf(request.getParameter("timelength"));
					userNameCookie.setMaxAge(dayLenth*24*3600);
					pwdCookie.setMaxAge(dayLenth*24*3600);
					
					Date date=new Date();
					SimpleDateFormat sf=new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");
					Cookie lastLoginTimeCookie = new Cookie("lastLoginTime",sf.format(date));
					lastLoginTimeCookie.setMaxAge(dayLenth*24*3600);
					response.addCookie(lastLoginTimeCookie);
					response.addCookie(userNameCookie);
					response.addCookie(pwdCookie);
				}
				request.getRequestDispatcher("main.jsp").forward(request, response);
				break;
			case "2":
				request.setAttribute("msg", "���δͨ����������ע��");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				break;
			case "3":
				request.setAttribute("msg", "�û������������");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				break;
			}
		} else {
			request.setAttribute("msg", "�û������������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
