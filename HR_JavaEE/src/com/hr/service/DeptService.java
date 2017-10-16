package com.hr.service;

import java.util.List;

import javax.swing.JOptionPane;

import com.hr.dao.DeptDao;
import com.hr.pojo.Dept;
import com.hr.pojo.PageModel;

public class DeptService {
	DeptDao deptDao = new DeptDao();

	public Dept queryById(int deptId) throws Exception {
		Dept dept = deptDao.queryById(deptId);

		if (dept == null) {
			throw new Exception("查询部门不存在");
		}

		return dept;

	}

	public void insert(Dept dept) throws Exception {

		if (deptDao.queryById(dept.getDeptId()) != null) {
			throw new Exception("部门编号不可重复");
		}

		if (deptDao.queryByName(dept.getDeptName()) != null) {
			throw new Exception("部门名称不可重复");
		}

		deptDao.insert(dept);

	}

	public void delete(Integer deptId) throws Exception {
		Dept dept = deptDao.queryById(deptId);
		if (dept == null) {
			throw new Exception("部门编号不存在");
		}
		
		int option = JOptionPane.showConfirmDialog(null, "部门编号:"+dept.getDeptId()+"\n部门名称:"
				+dept.getDeptName()+"\n部门地址:"+dept.getDeptLoc()+"\n确定删除该部门吗？");
		if (option ==0) {//是
			deptDao.delete(deptId);
		}else{
			throw new Exception("操作已取消");
		}

	}

	/**
	 * 查询所有部门记录
	 */
	public List queryAll() {
		
		DeptDao deptDao = new DeptDao();
		return deptDao.queryAll();
		
	}

	public void update(Dept dept)  throws Exception{

		if (deptDao.queryById(dept.getDeptId()) == null) {
			throw new Exception("部门编号不存在");
		}

		Dept dbDept = deptDao.queryByName(dept.getDeptName());
		
		if (dbDept != null && (dbDept.getDeptId() !=dept.getDeptId())) {
			throw new Exception("部门名称不可重复");
		}

		deptDao.update(dept);
	}

	/**
	 * 分页查询记录
	 * @param pageNo 
	 * @param pageSize
	 * @return 
	 */
	public PageModel<Dept> queryForPage(int pageNo, int pageSize) {
		DeptDao deptDao = new DeptDao();

		PageModel<Dept> pagination = new PageModel<Dept>();
		pagination.setList(deptDao.queryForPage(pageNo, pageSize));
		pagination.setPageNo(pageNo);
		pagination.setPageSize(pageSize);
		pagination.setTotalNum(deptDao.getTotalNum());
		return pagination;
	}
}
