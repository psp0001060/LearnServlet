package com.hr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.pojo.Dept;
import com.hr.service.DeptService;

/**
 * Servlet implementation class DeptInsertServlet
 */
@WebServlet("/ToDeptUpdateServlet")
public class ToDeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDeptUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptId = Integer.valueOf(request.getParameter("deptId"));
		DeptService ds = new DeptService();
		
		try {
			Dept dept = ds.queryById(deptId);
			request.setAttribute("dept",dept);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		request.getRequestDispatcher("dept/deptUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
