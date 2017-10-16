package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hr.common.DBUtil;
import com.hr.pojo.Admin;

public class AdminDao {
	/**
	 * ���ݽ���������û��������뵽DB���ж��Ƿ���ȷ
	 * @param Admin
	 * @return true����ȷ��false������
	 */
	public boolean isLoginSuccess(Admin admin)  {
		
		Connection conn = DBUtil.getConnection(); // �������ݿ�����
		PreparedStatement ps = null;// ����PreparedStatement����
		ResultSet result = null;// ���������ResultSet
		try {
			String sql = "select admin_name,admin_password from admin where admin_name =? and admin_password =?";
			ps = conn.prepareStatement(sql); // ��ȡPreparedStatement����
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
	 * ���ݽ���������û��������뵽DB��ȡadmin��¼
	 * @param Admin
	 * @return Admin����
	 */
	public Admin queryAdmin(Admin admin)  {
		
		Connection conn = DBUtil.getConnection(); // �������ݿ�����
		PreparedStatement ps = null;// ����PreparedStatement����
		ResultSet result = null;// ���������ResultSet
		try {
			String sql = "select admin_name,admin_password,status from admin where admin_name =? and admin_password =?";
			ps = conn.prepareStatement(sql); // ��ȡPreparedStatement����
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
