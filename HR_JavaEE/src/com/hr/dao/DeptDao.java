package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hr.common.DBUtil;
import com.hr.pojo.Dept;

public class DeptDao {

	public Dept queryById(int deptId){
		Connection conn = DBUtil.getConnection(); // �������ݿ�����
		PreparedStatement ps = null;// ����PreparedStatement����
		ResultSet result = null;// ���������ResultSet
		Dept dept = null;
		try {
			String sql = "select dept_id,dept_name,dept_loc from dept where dept_id =?";
			ps = conn.prepareStatement(sql); // ��ȡPreparedStatement����
			ps.setInt(1, deptId);
			result = ps.executeQuery();
			
			if (result.next()) {
				dept = new Dept();
				dept.setDeptId(result.getInt(1));
				dept.setDeptName(result.getString(2));
				dept.setDeptLoc(result.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(result);
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}

		return dept;
	}

	public Dept queryByName(String deptName) {
		Connection conn = DBUtil.getConnection(); // �������ݿ�����
		PreparedStatement ps = null;// ����PreparedStatement����
		ResultSet result = null;// ���������ResultSet
		Dept dept = null;
		try {
			String sql = "select dept_id,dept_name,dept_loc from dept where dept_name =?";
			ps = conn.prepareStatement(sql); // ��ȡPreparedStatement����
			ps.setString(1, deptName);
			result = ps.executeQuery();
			
			if (result.next()) {
				dept = new Dept();
				dept.setDeptId(result.getInt(1));
				dept.setDeptName(result.getString(2));
				dept.setDeptLoc(result.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(result);
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}

		return dept;
	}

	public void insert(Dept dept) {
		Connection conn = DBUtil.getConnection(); // �������ݿ�����
		PreparedStatement ps = null;// ����PreparedStatement����
		try {
			String sql = "insert into dept values(?,?,?)";
			ps = conn.prepareStatement(sql); // ��ȡPreparedStatement����
			ps.setInt(1, dept.getDeptId());
			ps.setString(2, dept.getDeptName());
			ps.setString(3, dept.getDeptLoc());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}
	}

	public void delete(Integer deptId) {
		Connection conn = DBUtil.getConnection(); // �������ݿ�����
		PreparedStatement ps = null;// ����PreparedStatement����
		try {
			String sql = "delete from dept where dept_id =?";
			ps = conn.prepareStatement(sql); // ��ȡPreparedStatement����
			ps.setInt(1, deptId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}
		
	}

	public List queryAll() {
		Connection conn = DBUtil.getConnection(); // �������ݿ�����
		PreparedStatement ps = null;// ����PreparedStatement����
		ResultSet result = null;// ���������ResultSet
		Dept dept = null;
		List<Dept> resultList = new ArrayList<Dept>();
		try {
			String sql = "select * from dept";
			ps = conn.prepareStatement(sql); // ��ȡPreparedStatement����
			result = ps.executeQuery();
			
			while(result.next()) {
				dept = new Dept();
				dept.setDeptId(result.getInt(1));
				dept.setDeptName(result.getString(2));
				dept.setDeptLoc(result.getString(3));
				resultList.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(result);
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}

		return resultList;
	}

	public void update(Dept dept) {
		Connection conn = DBUtil.getConnection(); // �������ݿ�����
		PreparedStatement ps = null;// ����PreparedStatement����
		try {
			String sql = "update dept set dept_name = ?,dept_loc = ? where dept_id = ?";
			ps = conn.prepareStatement(sql); // ��ȡPreparedStatement����
			ps.setString(1, dept.getDeptName());
			ps.setString(2, dept.getDeptLoc());
			ps.setInt(3, dept.getDeptId());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}
		
	}

	/**
	 * 分页查询记录
	 * @param pageNo 
	 * @param pageSize
	 * @return 
	 */
	public List<Dept> queryForPage(int pageNo, int pageSize) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet result = null;
		Dept dept = null;
		List<Dept> resultList = new ArrayList<Dept>();
		try {
			String startPageSql = "select * from(select rownum num,u.* from(";
			String innerSql = "select * from dept";
			String endPageSql = ") u where rownum<=?) where num>=?";
			String sql = startPageSql + innerSql + endPageSql;

			ps = conn.prepareStatement(sql);
			ps.setInt(1, pageNo * pageSize);
			ps.setInt(2, (pageNo - 1) * pageSize + 1);
			result = ps.executeQuery();

			while (result.next()) {
				dept = new Dept();
				dept.setDeptId(result.getInt(2));
				dept.setDeptName(result.getString(3));
				dept.setDeptLoc(result.getString(4));
				resultList.add(dept);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(result);
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}

		return resultList;
	}


	/**
	 * 获取总记录数
	 * @return
	 */
	public int getTotalNum() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet result = null;
		int totalCount = 0;
		
		try {
			String sql = "select count(1) from dept";
			ps = conn.prepareStatement(sql); 
			result = ps.executeQuery();
			
			if(result.next()) {
				totalCount = result.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(result);
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}

		return totalCount;
	}

}
