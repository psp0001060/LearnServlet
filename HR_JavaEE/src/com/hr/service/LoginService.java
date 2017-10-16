package com.hr.service;

import com.hr.dao.AdminDao;
import com.hr.pojo.Admin;

public class LoginService {

	/**
	 * 根据界面输入的用户名及密码到DB中判断是否正确
	 * 
	 * @param Admin
	 * @return true：正确，false：错误
	 */
	public boolean isLoginSuccess(Admin admin) {
		AdminDao ad = new AdminDao();
		return ad.isLoginSuccess(admin);
	}
	
	public Admin queryAdmin(Admin admin) {
		AdminDao ad = new AdminDao();
		return ad.queryAdmin(admin);
	}

}
