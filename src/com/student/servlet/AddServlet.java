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
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		
		//将表单提交的数据放在Student类中
		Student student = new Student();
		String student_id = request.getParameter("student_id");
		String student_name = request.getParameter("student_name");
		String student_password = request.getParameter("student_password");
		String student_sex = request.getParameter("student_sex");
		String student_birthday = request.getParameter("student_birthday");
		String student_telephone = request.getParameter("student_telephone");
		String student_email = request.getParameter("student_email");
		String student_address = request.getParameter("student_address");
		String student_department = request.getParameter("student_department");
		
		student.setStudent_id(student_id);
		student.setStudent_name(student_name);
		student.setStudent_password(student_password);
		student.setStudent_sex(student_sex);
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday= sdf.parse(student_birthday);
			student.setStudent_birthday(birthday);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		student.setStudent_telephone(student_telephone);
		student.setStudent_email(student_email);
		student.setStudent_address(student_address);
		student.setStudent_department(student_department);
		
		 //调用业务逻辑
		StudentService studentService = new StudentServiceImpl();
		try {
			//判断用户名是否重复
			Student result = studentService.findStudentByID(student);
			 //如果不等于null则说明用户名重复
			if (result != null) {
				request.setAttribute("msg_add", "This account already exists.");
				request.getRequestDispatcher("addStudent.jsp").forward(request, response);
				return;
			} else {
				//用户名不重复时，执行添加操作
				studentService.addStudent(student);
				// 分发转向
	            response.getWriter().write("Add student successfully!");
	            request.getRequestDispatcher("admin_home.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
