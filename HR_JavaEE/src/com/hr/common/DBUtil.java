package com.hr.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �����װ�����Ӻ͹ر����ݿ�Ĳ���
 * 
 * @author Administrator
 *
 */
public class DBUtil {

	/**
	 * ��ȡ����
	 * @return conn
	 */
	public static Connection getConnection() {
		Connection conn = null; // �������ݿ�����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle���������ڴ�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "icsshr", "icsshr");// ��ȡ����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * �ر�statement
	 * @param stm
	 */
	public static void closeStatement(Statement stm){
		if (null != stm) {
			try {
				stm.close();
				stm = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �ر�PreparedStatement
	 * @param stm
	 */
	public static void closePreparedStatement(PreparedStatement pstm){
		if (null != pstm) {
			try {
				pstm.close();
				pstm = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �ر�ResultSet
	 * @param stm
	 */
	public static void closeResultSet(ResultSet rs){
		if (null != rs) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �ر�����
	 * @param stm
	 */
	public static void closeConnection(Connection cs){
		if (null != cs) {
			try {
				cs.close();
				cs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
