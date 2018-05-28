package com.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import com.student.bean.Student;
import com.student.dao.StudentDao;
import com.student.utils.DBUtil;

/*** 
 * @author Renfu Gou
 * @E_mail 1779356953@qq.com
 * @create_time 2018年5月13日 下午9:15:24
 * @description 
 * @version 1.0
*/
public class StudentDaoImpl implements StudentDao {

	@Override
	public void addStudent(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("INSERT INTO student(student_id,student_name,student_password,student_sex,student_birthday,student_telephone,student_email,student_address,student_department) VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, student.getStudent_id());
			ps.setString(2, student.getStudent_name());
			ps.setString(3, student.getStudent_password());
			ps.setString(4, student.getStudent_sex());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(student.getStudent_birthday());
			ps.setString(5, birthday);
			ps.setString(6, student.getStudent_telephone());
			ps.setString(7, student.getStudent_email());
			ps.setString(8, student.getStudent_address());
			ps.setString(9, student.getStudent_department());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败!");
		}
	}

	@Override
	public Student findStudentByIDAndPassword(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT * FROM student WHERE student_id=? and student_password=?");
			ps.setString(1, student.getStudent_id());
			ps.setString(2, student.getStudent_password());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				stu = new Student();
				stu.setStudent_id(rs.getString(1));
				stu.setStudent_name(rs.getString(2));
				stu.setStudent_password(rs.getString(3));
				stu.setStudent_sex(rs.getString(4));
				stu.setStudent_birthday(rs.getDate(5));
				stu.setStudent_telephone(rs.getString(6));
				stu.setStudent_email(rs.getString(7));
				stu.setStudent_address(rs.getString(8));
				stu.setStudent_department(rs.getString(9));
			}
		} catch (Exception e) {
			
		}
		return stu;
	}

	@Override
	public Student findStudentByID(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT * FROM student WHERE student_id=?");
			ps.setString(1, student.getStudent_id());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				stu = new Student();
				stu.setStudent_id(rs.getString(1));
				stu.setStudent_name(rs.getString(2));
				stu.setStudent_password(rs.getString(3));
				stu.setStudent_sex(rs.getString(4));
				stu.setStudent_birthday(rs.getDate(5));
				stu.setStudent_telephone(rs.getString(6));
				stu.setStudent_email(rs.getString(7));
				stu.setStudent_address(rs.getString(8));
				stu.setStudent_department(rs.getString(9));
			}
		} catch (Exception e) {
			
		}
		return stu;
	}
	
	@Override
	public ArrayList<Student> findStudentByName(Student student) throws Exception {
		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT * FROM student WHERE student_name=?");
			ps.setString(1, student.getStudent_name());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Student stu  = new Student();
				stu.setStudent_id(rs.getString(1));
				stu.setStudent_name(rs.getString(2));
				stu.setStudent_password(rs.getString(3));
				stu.setStudent_sex(rs.getString(4));
				stu.setStudent_birthday(rs.getDate(5));
				stu.setStudent_telephone(rs.getString(6));
				stu.setStudent_email(rs.getString(7));
				stu.setStudent_address(rs.getString(8));
				stu.setStudent_department(rs.getString(9));
				students.add(stu);
			}
		} catch (Exception e) {
			
		}
		return students;
	}
	
	@Override
	public Student findStudentByIDAndName(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT * FROM student WHERE student_id=? and student_name=?");
			ps.setString(1, student.getStudent_id());
			ps.setString(2, student.getStudent_name());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				stu = new Student();
				stu.setStudent_id(rs.getString(1));
				stu.setStudent_name(rs.getString(2));
				stu.setStudent_password(rs.getString(3));
				stu.setStudent_sex(rs.getString(4));
				stu.setStudent_birthday(rs.getDate(5));
				stu.setStudent_telephone(rs.getString(6));
				stu.setStudent_email(rs.getString(7));
				stu.setStudent_address(rs.getString(8));
				stu.setStudent_department(rs.getString(9));
			}
		} catch (Exception e) {
			
		}
		return stu;
	}

	@Override
	public void updateStudent(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("UPDATE student SET student_sex=?,student_birthday=?,student_telephone=?,student_email=?,student_address=?,student_department=? WHERE student_id=?");
			ps.setString(1, student.getStudent_sex());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(student.getStudent_birthday());
			ps.setString(2, birthday);
			ps.setString(3, student.getStudent_telephone());
			ps.setString(4, student.getStudent_email());
			ps.setString(5, student.getStudent_address());
			ps.setString(6, student.getStudent_department());
			ps.setString(7, student.getStudent_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新失败!");
		}
	}

	@Override
	public void updateStudentAll(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("UPDATE student SET student_name=?,student_password=?,student_sex=?,student_birthday=?,student_telephone=?,student_email=?,student_address=?,student_department=? WHERE student_id=?");
			ps.setString(1, student.getStudent_name());
			ps.setString(2, student.getStudent_password());
			ps.setString(3, student.getStudent_sex());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(student.getStudent_birthday());
			ps.setString(4, birthday);
			ps.setString(5, student.getStudent_telephone());
			ps.setString(6, student.getStudent_email());
			ps.setString(7, student.getStudent_address());
			ps.setString(8, student.getStudent_department());
			ps.setString(9, student.getStudent_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新失败!");
		}
	}

	@Override
	public void deleteStudent(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("DELETE FROM student WHERE student_id=?");
			ps.setString(1, student.getStudent_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败!");
		}
	}
}
