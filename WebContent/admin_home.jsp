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
	Connection connection = DBUtil.getConnection();
	Statement statement;
	int intPageSize;//一页显示的记录数
	int intRowCount;//记录总数
	int intPageCount;//总页数
	int intPage;//待显示页码
	String strPage;
	int i;
	//设置一页显示的记录数
	intPageSize = 10;
	//取得待显示页码
	strPage = request.getParameter("page");
	if(strPage==null){
       //表明在QueryString中没有page这一个参数，此时显示第一页数据
       intPage = 1;
	} else {
       //将字符串转换成整型
       intPage =java.lang.Integer.parseInt(strPage);
       if(intPage<1) {
    	   intPage = 1;
       }
	}
	//创建语句对象
	statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	ResultSet rs = statement.executeQuery("SELECT * FROM student ORDER BY student_id ASC");
	//获取记录总数
	rs.last();
	intRowCount = rs.getRow();
	//记算总页数
	intPageCount = (intRowCount+intPageSize-1)/intPageSize;
	//调整待显示的页码
	if(intPage>intPageCount) intPage = intPageCount;
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
    <div class="xt-bt">Basic information > Student Information</div>
    <div class="xt-input">
        <input type="button" value="Add Student" class="green-int" onclick="window.location.href='addStudent.jsp';"/>
        <input type="button" value="Find Student" class="yellow-int" onclick="window.location.href='findStudent.jsp';"/>
    </div>
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
            <%
            	if(intPageCount>0){
            		//将记录指针定位到待显示页的第一条记录上
            		rs.absolute((intPage-1)*intPageSize+1);
            		//显示数据
                    i = 0;
                    while(i<intPageSize &&!rs.isAfterLast()){
            %>
            <tr>
                <td><% out.print(rs.getString(1)); %></td>
                <td><% out.print(rs.getString(2)); %></td>
                <td><% out.print(rs.getString(3)); %></td>
                <td><% out.print(rs.getString(4)); %></td>
                <td><% out.print(rs.getString(5)); %></td>
                <td><% out.print(rs.getString(6)); %></td>
                <td><% out.print(rs.getString(7)); %></td>
                <td><% out.print(rs.getString(8)); %></td>
                <td><% out.print(rs.getString(9)); %></td>
                <td><a href="updateStudent.jsp?stu_id=<%=rs.getString(1)%>" class="yellow-xt">Modify</a><a href="DeleteServlet?stu_id=<%=rs.getString(1)%>" class="red-xt">Delete</a></td>
            </tr>
            <%
            	rs.next();
            	i++;
            	}
            }
            %>

        </table>
    </div>
    <div class="xt-fenye">
        <div class="xt-fenye-left"><span class="xt-yanse">Now,<%=intPage%> Page ,total <%=intPageCount%> Pages, <%=intRowCount%> Records</span></div>
        <div class="xt-fenye-right">
        	<% if(intPage>1){ %>
            <a href="admin_home.jsp?page=1">First Page</a>
            <% }else{ %>
            <a href="#">First Page</a>
            <% } %>
            
            <% if(intPage>1){ %>
            <a href="admin_home.jsp?page=<%=intPage-1%>">Previous Page</a>
            <% }else{ %>
            <a href="#">Previous Page</a>
            <% } %>
            
            <% if(intPage<intPageCount){ %>
            <a href="admin_home.jsp?page=<%=intPage+1%>">Next Page</a>
            <% }else{ %>
            <a href="#">Next Page</a>
            <% } %>
            
            <% if(intPage<intPageCount){ %>
            <a href="admin_home.jsp?page=<%=intPageCount%>">Last Page</a>
            <% }else{ %>
            <a href="#">Last Page</a>
            <% } %>         
        </div>

    </div>
</div>
</div>

</body>
</html>