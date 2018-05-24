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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		
		//调用业务逻辑
		StudentService studentService = new StudentServiceImpl();
		String student_id = request.getParameter("student_id");
		Student stu = new Student();
		stu.setStudent_id(student_id);
		Student student = stu;
		try {
			student = studentService.findStudentByID(stu);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String student_name = request.getParameter("student_name");
		String student_password = request.getParameter("student_password");
		String student_sex = request.getParameter("student_sex");
		String student_birthday = request.getParameter("student_birthday");
		String student_telephone = request.getParameter("student_telephone");
		String student_email = request.getParameter("student_email");
		String student_address = request.getParameter("student_address");
		String student_department = request.getParameter("student_department");
		if (!student_name.trim().equals("")) {
			student.setStudent_name(student_name);
		}
		if (!student_password.trim().equals("")) {
			student.setStudent_password(student_password);
		}
		if (!student_sex.trim().equals("")) {
			student.setStudent_sex(student_sex);
		}
		if (!student_birthday.trim().equals("")) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = sdf.parse(student_birthday);
				student.setStudent_birthday(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!student_telephone.trim().equals("")) {
			student.setStudent_telephone(student_telephone);
		}
		if (!student_email.trim().equals("")) {
			student.setStudent_email(student_email);
		}
		if (!student_address.trim().equals("")) {
			student.setStudent_address(student_address);
		}
		if (!student_department.trim().equals("")) {
			student.setStudent_department(student_department);
		}
		
		
		try {
			studentService.updateStudentAll(student);
			// 分发转向
	        response.getWriter().write("Modified successfully!");
	        request.getRequestDispatcher("updateStudent.jsp?stu_id="+student_id).forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
