package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import com.student.bean.Student;

/*** 
 * @author Renfu Gou
 * @E_mail 1779356953@qq.com
 * @create_time 2018年5月13日 下午9:13:05
 * @description 学生dao
 * @version 1.0
*/
public interface StudentDao {

	/**
	 * 添加学生信息
	 * @param student 学生
	 * @throws Exception
	 */
	public void addStudent(Student student) throws Exception;
	
	/**
	 * 根据学生学号和密码查找学生
	 * @param student 
	 * @return
	 * @throws Exception
	 */
	public Student findStudentByIDAndPassword(Student student) throws Exception;
	
	/**
	 * 根据学生学号查找学生
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
	public ArrayList<Student> findStudentByName(Student student) throws Exception;
	
	/**
	 * 根据学生ID和姓名查找学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public Student findStudentByIDAndName(Student student) throws Exception;
	
	/**
	 * 更新学生数据,除id，name，password
	 * @param student
	 * @throws Exception
	 */
	public void updateStudent(Student student) throws Exception;
	
	/**
	 * 更新学生全部数据
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
