package com.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.Admin;
import com.student.bean.Student;
import com.student.service.AdminService;
import com.student.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Admin admin = new Admin();
		AdminService adminService = new AdminServiceImpl();
		String admin_id = request.getParameter("admin_id");
		String admin_password = request.getParameter("admin_password");
		admin.setAdmin_id(admin_id);
		admin.setAdmin_password(admin_password);
		//验证输入
		if(admin_id.trim().equals("") || admin_password.trim().equals("")){  
	           request.setAttribute("msg_admin", "please input the id or password!");
	           request.getRequestDispatcher("admin.jsp").forward(request, response);  
	           return;  
	    }   
		try {
			Admin ad = adminService.findAdminByIDAndPassword(admin);
			//分发转向
			if (ad != null) {
				//如果登录成功，就把admin对象放到session对象中
				request.getSession().setAttribute("admin", ad);
				request.getRequestDispatcher("/admin_home.jsp").forward(request, response);
			} else {
				 request.setAttribute("msg_admin", "the ID or password is wrong!");  
				 request.getRequestDispatcher("/admin.jsp").forward(request, response);  
				 return;  
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
