<%@page import="com.student.bean.Student"%>
<%@page import="com.student.service.impl.StudentServiceImpl"%>
<%@page import="com.student.service.StudentService"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.student.bean.Admin"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.student.utils.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Administration Center</title>
<link href="css/style_admin.css" rel="stylesheet" type="text/css">
</head>

<script>
function windowHeight() {
	var de = document.documentElement;
	return self.innerHeight||(de && de.clientHeight)||document.body.clientHeight;
}
window.onload=window.onresize=function(){
	var wh=windowHeight();
	document.getElementById("xt-left").style.height = document.getElementById("xt-right").style.height = (wh-document.getElementById("xt-top").offsetHeight)+"px";
}
</script>
<%
	Student stu = new Student();
	StudentService studentService = new StudentServiceImpl();
	String student_id;
	student_id = request.getParameter("stu_id");
	stu.setStudent_id(student_id);
	Student student = studentService.findStudentByID(stu);
 %>
<body>

<!-- top -->
<div id="xt-top">
    <div class="xt-geren">
    	<%
	    	Admin admin = (Admin)request.getSession().getAttribute("admin");
			String admin_name = admin.getAdmin_name();
    	%>
        <div class="xt-exit"><span class="xt-span">Hello,<span class="xt-yanse"><%out.print(admin_name); %></span>!Welcome log in administration center.</span><a href="#" class="help">Help</a>
            <a href="#" class="exit">LOG OUT</a></div>
    </div>
</div>
<!-- left -->
<div class="xt-center">
<div id="xt-left">
    <div class="xt-logo"></div>
     <div class="xt-menu">
        <ul>
            <li><a href="admin_home.jsp?page=1" class="hover"><em class="one"></em>Basic Information</a></li>
            <li><a href="addStudent.jsp"><em class="two"></em>Add Student</a></li>
            <li><a href="findStudent.jsp"><em class="three"></em>Find Student</a></li>
        </ul>
        <div class="xt-menu-list"></div>
        <ul>
            <li><a href="AdminLogoutServlet" style="color: red;"><em class="two"></em>LOG OUT</a></li>
        </ul>
    </div>
</div>
<!-- right -->
<div id="xt-right">
    <div class="xt-bt">Basic information > Student Information > Modify</div>
    <div class="xt-table">
        <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
            <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Student Password</th>
            <th>Student Sex</th>
            <th>Student Birthday</th>
            <th>Student Telephone</th>
            <th>Student Email</th>
            <th>Student Address</th>
            <th>Student Department</th>
            <th>Options</th>
            </tr>
          	<form action="UpdateServlet" id="update" name="update" method="post">
            <tr>
                <td><input style="width:100px" type="text" name="student_id" value=<%=student.getStudent_id()%>></td>
              	<td><input style="width:60px" type="text" name="student_name" placeholder=<%=student.getStudent_name()%>></td>
              	<td><input style="width:100px" type="text" name="student_password" placeholder=<%=student.getStudent_password()%>></td>
              	<td><input style="width:40px" type="text" name="student_sex" placeholder=<%=student.getStudent_sex()%>></td>
              	<td><input style="width:100px" type="text" name="student_birthday" placeholder=<%=student.getStudent_birthday()%>></td>
              	<td><input style="width:100px" type="text" name="student_telephone" placeholder=<%=student.getStudent_telephone()%>></td>
              	<td><input style="width:100px" type="text" name="student_email" placeholder=<%=student.getStudent_email()%>></td>
              	<td><input style="width:100px" type="text" name="student_address" placeholder=<%=student.getStudent_address()%>></td>
              	<td><input style="width:100px" type="text" name="student_department" placeholder=<%=student.getStudent_department()%>></td>
              	
                <td><a href="#" onclick="document.getElementById('update').submit()" class="blue-xt">Save</a></td>
            </tr>
         	</form>

        </table>
    </div>
</div>
</div>

</body>
</html>