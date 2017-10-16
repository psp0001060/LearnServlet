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
@WebServlet("/DeptInsertServlet")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		Dept dept = new Dept();
		DeptService ds = new DeptService();
		dept.setDeptId(Integer.valueOf(request.getParameter("DeptId")));
		dept.setDeptName(request.getParameter("deptName"));
		dept.setDeptLoc(request.getParameter("deptAddr"));
		try {
			ds.insert(dept);
		} catch (Exception e) {
			request.setAttribute("lastDept", dept);
			request.setAttribute("toPage", "dept/deptInsert.jsp");
			request.setAttribute("msg", e.getMessage());
		}
		request.getRequestDispatcher("DeptListServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
