package com.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*** 
 * @author Renfu Gou
 * @E_mail 1779356953@qq.com
 * @create_time 2018年5月13日 下午8:53:55
 * @description 数据库工具类
 * @version 1.0
*/
public class DBUtil {
	private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    
    static {
    	ResourceBundle rBundle = ResourceBundle.getBundle("db");
    	driverClass = rBundle.getString("driverClass");
    	url = rBundle.getString("url");
    	username = rBundle.getString("username");
    	password = rBundle.getString("password");
    	try {
			//注册驱动
    		Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
}
