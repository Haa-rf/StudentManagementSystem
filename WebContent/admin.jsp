<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>Admin login</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<h3>Welcome</h3>
					<form action="AdminLoginServlet" id="admin_login" name="admin_login" method="post">
						<div class="input_outer">
							<span class="u_user"></span>
							<input name="admin_id" class="text" style="color: #FFFFFF !important" type="text" placeholder="Please enter the account">
						</div>
						<div class="input_outer">
							<span class="us_uer"></span>
							<input name="admin_password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="Please enter the password">
						</div>
						
						<div class="mb2"><a class="act-but submit" href="#" onclick="document.getElementById('admin_login').submit()" style="color: #FFFFFF">LOGIN</a></div>
						 <h3 style="color:red;">${msg_admin}</h3>
					</form>
				</div>
			</div>
		</div>
	</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
	</body>
</body>
</html>