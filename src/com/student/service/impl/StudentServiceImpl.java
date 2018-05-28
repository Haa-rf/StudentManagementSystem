package com.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.student.bean.Student;
import com.student.dao.StudentDao;
import com.student.dao.impl.StudentDaoImpl;
import com.student.service.StudentService;

/*** 
 * @author Renfu Gou
 * @E_mail 1779356953@qq.com
 * @create_time 2018年5月13日 下午9:30:04
 * @description StudentServiceImpl实现类
 * @version 1.0
*/
public class StudentServiceImpl implements StudentService {

	StudentDao studentDao = new StudentDaoImpl();
	@Override
	public void addStudent(Student student) throws Exception {
		studentDao.addStudent(student);
	}
	
	@Override
	public Student findStudentByIDAndPassword(Student student) throws Exception {
		return studentDao.findStudentByIDAndPassword(student);
	}

	@Override
	public Student findStudentByID(Student student) throws Exception {
		return studentDao.findStudentByID(student);
	}

	@Override
	public ArrayList<Student> findStudentByName(Student student) throws Exception {
		return studentDao.findStudentByName(student);
	}

	@Override
	public Student findStudentByIDAndName(Student student) throws Exception {
		return studentDao.findStudentByIDAndName(student);
	}
	
	@Override
	public void updateStudent(Student student) throws Exception {
		studentDao.updateStudent(student);
	}

	@Override
	public void updateStudentAll(Student student) throws Exception {
		studentDao.updateStudentAll(student);
	}

	@Override
	public void deleteStudent(Student student) throws Exception {
		studentDao.deleteStudent(student);
	}

}
