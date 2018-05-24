package com.student.service;

import java.util.List;

import com.student.bean.Student;

/*** 
 * @author Renfu Gou
 * @E_mail 1779356953@qq.com
 * @create_time 2018年5月13日 下午9:28:11
 * @description StudentService接口
 * @version 1.0
*/
public interface StudentService {
	
	/**
	 * 添加学生信息
	 * @param student
	 * @throws Exception
	 */
	public void addStudent(Student student) throws Exception;
	
	/**
	 * 根据学生ID和密码查找学生
	 * @param student
	 * @return 
	 * @throws Exception
	 */
	public Student findStudentByIDAndPassword(Student student) throws Exception;
	
	/**
	 * 根据学生ID查找学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public Student findStudentByID(Student student) throws Exception;
	
	/**
	 * 根据学生姓名查找学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public List<Student> findStudentByName(Student student) throws Exception;
	
	/**
	 * 根据学生ID和姓名查找学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public Student findStudentByIDAndName(Student student) throws Exception;
	
	/**
	 * 更新学生部分信息
	 * @param student
	 * @throws Exception
	 */
	public void updateStudent(Student student) throws Exception;
	
	/**
	 * 更新学生全部信息
	 * @param student
	 * @throws Exception
	 */
	public void updateStudentAll(Student student) throws Exception;
	
	/**
	 * 删除学生
	 * @param student
	 * @throws Exception
	 */
	public void deleteStudent(Student student) throws Exception;
}
