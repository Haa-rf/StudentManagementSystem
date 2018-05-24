package com.student.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.Student;
import com.student.service.StudentService;
import com.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//将表单提交的数据放在Student类中
		Student student = new Student();
		student.setStudent_id(request.getParameter("student_id_reg"));
		student.setStudent_name(request.getParameter("student_name_reg"));
		student.setStudent_password(request.getParameter("student_password_reg"));
		student.setStudent_sex(" ");
		Date date = new Date();
		student.setStudent_birthday(date);
		student.setStudent_telephone(" ");
		student.setStudent_email(" ");
		student.setStudent_address(" ");
		student.setStudent_department(" ");
		
		 //调用业务逻辑
		StudentService studentService = new StudentServiceImpl();
		try {
			//判断用户名是否重复
			Student result = studentService.findStudentByID(student);
			 //如果不等于null则说明用户名重复
			if (result != null) {
				request.setAttribute("msg_re", "This account already exists.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			} else {
				//用户名不重复时，执行添加操作
				studentService.addStudent(student);
				// 分发转向
	            response.getWriter().write("Sign up successfully!");
	            request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
