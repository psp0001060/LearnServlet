package com.hr.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 该类封装了连接和关闭数据库的操作
 * 
 * @author Administrator
 *
 */
public class DBUtil {

	/**
	 * 获取连接
	 * @return conn
	 */
	public static Connection getConnection() {
		Connection conn = null; // 创建数据库连接
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序到内存
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "icsshr", "icsshr");// 获取连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭statement
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
	 * 关闭PreparedStatement
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
	 * 关闭ResultSet
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
	 * 关闭连接
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
