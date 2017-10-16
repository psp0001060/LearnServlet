package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hr.common.DBUtil;
import com.hr.pojo.Admin;

public class AdminDao {
	/**
	 * 根据界面输入的用户名及密码到DB中判断是否正确
	 * @param Admin
	 * @return true：正确，false：错误
	 */
	public boolean isLoginSuccess(Admin admin)  {
		
		Connection conn = DBUtil.getConnection(); // 创建数据库连接
		PreparedStatement ps = null;// 创建PreparedStatement对象
		ResultSet result = null;// 创建结果集ResultSet
		try {
			String sql = "select admin_name,admin_password from admin where admin_name =? and admin_password =?";
			ps = conn.prepareStatement(sql); // 获取PreparedStatement对象
			ps.setString(1, admin.getAdminName());
			ps.setString(2, admin.getAdminPassword());
			result = ps.executeQuery();
			if (result.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(result);
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}

		return false;
	}
	
	/**
	 * 根据界面输入的用户名及密码到DB获取admin记录
	 * @param Admin
	 * @return Admin对象
	 */
	public Admin queryAdmin(Admin admin)  {
		
		Connection conn = DBUtil.getConnection(); // 创建数据库连接
		PreparedStatement ps = null;// 创建PreparedStatement对象
		ResultSet result = null;// 创建结果集ResultSet
		try {
			String sql = "select admin_name,admin_password,status from admin where admin_name =? and admin_password =?";
			ps = conn.prepareStatement(sql); // 获取PreparedStatement对象
			ps.setString(1, admin.getAdminName());
			ps.setString(2, admin.getAdminPassword());
			result = ps.executeQuery();
			if (result.next()) {
				Admin adminTmp = new Admin() ;
				adminTmp.setAdminName(result.getString(1));
				adminTmp.setAdminPassword(result.getString(2));
				adminTmp.setStatus(result.getString(3));
				return adminTmp;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(result);
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}
		
		return null;
	}

}
