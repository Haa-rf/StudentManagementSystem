package com.student.service.impl;

import com.student.bean.Admin;
import com.student.dao.AdminDao;
import com.student.dao.impl.AdminDaoImpl;
import com.student.service.AdminService;

/*** 
 * @author Renfu Gou
 * @E_mail 1779356953@qq.com
 * @create_time 2018年5月21日 下午7:50:04
 * @description 
 * @version 1.0
*/
public class AdminServiceImpl implements AdminService{

	AdminDao adminDao = new AdminDaoImpl();
	@Override
	public Admin findAdminByIDAndPassword(Admin admin) throws Exception {
		return adminDao.findAdminByIDAndPassword(admin);
	}

}
