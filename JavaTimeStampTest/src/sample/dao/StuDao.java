package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sample.bean.Stu;
import sample.util.DBUtil;

public class StuDao {

	/**
	 * 插入stu表记录(PreparedStatement),效率更高,更安全
	 */
	 public void testInsertStuPs(Stu stu) {
		Connection conn = DBUtil.getConnection(); // 创建数据库连接
		PreparedStatement ps = null;// 创建PreparedStatement对象
		try {
			System.out.println("=========连接成功===============");
			String sql = "insert into stu values(?,?,?)";
			ps = conn.prepareStatement(sql); // 获取PreparedStatement对象
			ps.setInt(1, stu.getStuNo());
			ps.setString(2, stu.getStuName());
			ps.setTimestamp(3, stu.getCreateTime());
			
			int rs = ps.executeUpdate();// 执行更新语句
			if (rs != 0) {
				System.out.println("insert success");
			} else {
				System.out.println("insert fail");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeConnection(conn);
		}
	}
	 
	 /**
	 * 查询stu表记录
	 */
	public Stu testSelectStuByNo(int stuNo) {
		Connection conn = DBUtil.getConnection(); // 创建数据库连接
		PreparedStatement statement = null;// 创建statement对象
		ResultSet result = null;// 创建结果集ResultSet
		Stu stu = new Stu();
		try {
			String sql = "select * from stu where stuno=?";
			statement = conn.prepareStatement(sql); // 获取PreparedStatement对象
			statement.setInt(1, stuNo);
			result = statement.executeQuery();
			if (result.next()) {
				stu.setStuNo(result.getInt(1));
				stu.setStuName(result.getString(2));
				stu.setCreateTime(result.getTimestamp(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(result);
			DBUtil.closePreparedStatement(statement);
			DBUtil.closeConnection(conn);
		}
		return stu;
	}
}
