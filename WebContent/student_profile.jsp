<%@ page import="com.student.bean.Student" import="java.util.Date" import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" http-equiv="Content-Type" content="width=device-width, initial-scale=1" >
<title>Student Profile</title>
<link rel="stylesheet" href="css/style.css">
<link href="./css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="./css/style_StudentHome.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="./js/jquery.min.js"></script>
<link href='http://fonts.useso.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
</head>
<body>

<div class="cotn_principal">
  <div class="cont_centrar">  
   		<div class="header">
		<div class="header-banner">			
			<div class="container">
				<div class="header-banner-info text-center">
					<h3>HELLO</h3>
					<br/>
					<h1><span><%
								Student student = (Student)request.getSession().getAttribute("student");
								String student_id = student.getStudent_id();
								out.print(student_id);
					%></span> </h1>
					<br/><br/><br/>
					<form action="ProfileServlet" name="profile" method="post">
						<div class="container">
						<ul class="details">
							<li>Birthday     :    <input style="color: blue;" type="text" name="student_birthday" id="student_birthday" placeholder=<% 
													SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				            						String student_birthday = sdf.format(student.getStudent_birthday());
													out.print(student_birthday); %> /></li>
							<li>Sex     :    <input style="color: blue;" type="text" name="student_sex" id="student_sex" placeholder=<% 
													String student_sex = student.getStudent_sex();
													out.print(student_sex); %> /></li>
							<br/><br/><br/>
							<li>Telephone     :    <input style="color: blue;" type="text" name="student_telephone" id="student_telephone" placeholder=<% 
													String student_telephone = student.getStudent_telephone();
													out.print(student_telephone); %> /></li>
							<li>Email     :    <input style="color: blue;" type="text" name="student_email" id="student_email" placeholder=<% 
													String student_email = student.getStudent_email();
													out.print(student_email); %> /></li>
							<br/><br/><br/>
							<li>Studying at     :    <input style="color: blue;" type="text" name="student_department" id="student_department" placeholder=<% 
													String student_department = student.getStudent_department();
													out.print(student_department); %> /></li>
							<li>Address     :    <input style="color: blue;" type="text" name="student_address" id="student_address" placeholder=<% 
													String student_address = student.getStudent_address();
													out.print(student_address); %> /></li>		
						</ul>
						</div>
						<br/><br/><br/>
						<button class="btn_login" >Save Your Profile</a></button>
					</form>
				</div>
			</div>
		</div>
	</div>
  </div>
</div>   
</body>
</html>