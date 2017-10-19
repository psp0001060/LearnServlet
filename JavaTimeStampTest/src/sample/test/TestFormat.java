package sample.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import sample.bean.Stu;
import sample.dao.StuDao;

public class TestFormat {
	
	@Test
	public void testInsert() {
		
		Stu stu = new Stu();
		stu.setStuNo(15);
		stu.setStuName("dalin");
		
		//String date to TimeStamp
		String date = "2009-07-16T19:20"; // <input type="datetime-local">
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"); 
		 try {
			Date dt = sdf.parse(date);
			stu.setCreateTime(new Timestamp(dt.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		StuDao stuDao = new StuDao();
		stuDao.testInsertStuPs(stu);
	}
	
	@Test
	public void testSelectByNo(){
		StuDao stuDao = new StuDao();
		Stu stu = stuDao.testSelectStuByNo(15);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		System.out.println(stu.getCreateTime()); //2009-07-16 19:20:00.0
		System.out.println(sdf.format(stu.getCreateTime())); //2009/07/16 19:20
	}
	
}
