package com.student.bean;
/*** 
 * @author Renfu Gou
 * @E_mail 1779356953@qq.com
 * @create_time 2018年5月21日 下午7:32:02
 * @description admin实体类
 * @version 1.0
*/
public class Admin {
	private String admin_id;
	private String admin_name;
	private String admin_password;
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
}
