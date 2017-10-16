package com.hr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.pojo.Dept;
import com.hr.pojo.PageModel;
import com.hr.service.DeptService;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/DeptListServlet")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageSize = 0; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override 
    public void init() throws ServletException { 
    	pageSize = Integer.valueOf(this.getServletContext().getInitParameter("pageSize")); 
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = 1;//默认是第一页
		if (null != request.getParameter("pageNo")) {
			pageNo = Integer.parseInt(request.getParameter("pageNo")); 
		}
		 
		DeptService ds = new DeptService();
		if(null !=request.getAttribute("msg")){
			String toPage = (String) request.getAttribute("toPage");
			request.getRequestDispatcher(toPage).forward(request, response);
		}else{
//			List<Dept> list = ds.queryAll();
			PageModel<Dept> pagination = ds.queryForPage(pageNo,pageSize);
			request.setAttribute("pagination", pagination);
			request.getRequestDispatcher("dept/deptList.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
