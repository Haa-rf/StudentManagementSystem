package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.Student;
import com.student.service.StudentService;
import com.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		Student student = new Student();
		StudentService studentService = new StudentServiceImpl();
		
		String student_id = request.getParameter("student_id_log");
		String student_password = request.getParameter("student_password_log");
		student.setStudent_id(student_id);
		student.setStudent_password(student_password);
		
		//验证输入
		if(student_id.equals("") || student_password.equals("")){  
	           request.setAttribute("msg", "please input the student_id or password!");
	           request.getRequestDispatcher("index.jsp").forward(request, response);  
	           return;  
	    }   
		
		try {
			Student stu = studentService.findStudentByIDAndPassword(student);
			
			//分发转向
			if (stu != null) {
				//如果登录成功，就把student对象放到session对象中
				request.getSession().setAttribute("student", stu);
				request.getRequestDispatcher("/student_home.jsp").forward(request, response);
			} else {
				 request.setAttribute("msg", "the ID or password is wrong!");  
				 request.getRequestDispatcher("/index.jsp").forward(request, response);  
				 return;  
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
