package com.hr.service;

import com.hr.dao.AdminDao;
import com.hr.pojo.Admin;

public class LoginService {

	/**
	 * ���ݽ���������û��������뵽DB���ж��Ƿ���ȷ
	 * 
	 * @param Admin
	 * @return true����ȷ��false������
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
