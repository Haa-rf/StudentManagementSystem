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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
		Student stu = (Student)request.getSession().getAttribute("student");
		Student student = stu;
		try {
			student = studentService.findStudentByID(stu);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String student_sex = request.getParameter("student_sex");
		String student_birthday = request.getParameter("student_birthday");
		String student_telephone = request.getParameter("student_telephone");
		String student_email = request.getParameter("student_email");
		String student_address = request.getParameter("student_address");
		String student_department = request.getParameter("student_department");
		if (!student_sex.equals("")) {
			student.setStudent_sex(student_sex);
		}
		if (!student_birthday.equals("")) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = sdf.parse(student_birthday);
				student.setStudent_birthday(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!student_telephone.equals("")) {
			student.setStudent_telephone(student_telephone);
		}
		if (!student_email.equals("")) {
			student.setStudent_email(student_email);
		}
		if (!student_address.equals("")) {
			student.setStudent_address(student_address);
		}
		if (!student_department.equals("")) {
			student.setStudent_department(student_department);
		}
		
		
		try {
			studentService.updateStudent(student);
			// 分发转向
			request.getSession().setAttribute("student", student);
	        response.getWriter().write("Modified successfully!");
	        request.getRequestDispatcher("student_home.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
