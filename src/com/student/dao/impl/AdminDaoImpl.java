package com.student.dao.impl;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.student.bean.Admin;
import com.student.bean.Student;
import com.student.dao.AdminDao;
import com.student.utils.DBUtil;

/*** 
 * @author Renfu Gou
 * @E_mail 1779356953@qq.com
 * @create_time 2018年5月21日 下午7:37:37
 * @description 
 * @version 1.0
*/
public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin findAdminByIDAndPassword(Admin admin) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin ad = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT * FROM sys_admin WHERE admin_id=? and admin_password=?");
			ps.setString(1, admin.getAdmin_id());
			ps.setString(2, admin.getAdmin_password());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				ad = new Admin();
				ad.setAdmin_id(rs.getString(1));
				ad.setAdmin_name(rs.getString(2));
				ad.setAdmin_password(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ad;
	}

}
