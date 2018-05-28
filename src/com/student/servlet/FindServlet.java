package com.student.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.Student;
import com.student.service.StudentService;
import com.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
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
		String student_name = request.getParameter("student_name");
		Student stu = new Student();
		Student student = stu;
		List<Student> students = new ArrayList<Student>();
		try {
			if (student_id.trim().equals("")) {
				if (student_name.trim().equals("")) {
					request.setAttribute("msg_find", "The ID or Name Cann't be null.");
					request.getRequestDispatcher("findStudent.jsp").forward(request, response);
					return;
				}else {
					stu.setStudent_name(student_name);
					students = studentService.findStudentByName(stu);
				}	
			}else {
				if (student_name.trim().equals("")) {
					stu.setStudent_id(student_id);
					student = studentService.findStudentByID(stu);
					students.add(student);
				}else {
					stu.setStudent_id(student_id);
					stu.setStudent_name(student_name);
					student = studentService.findStudentByIDAndName(stu);
					students.add(student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("students", students);
		// 分发转向
        response.getWriter().write("Find successfully!");
        request.getRequestDispatcher("findStudentShow.jsp").forward(request, response);
	}

}
