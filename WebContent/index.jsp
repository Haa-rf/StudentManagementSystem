<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta charset="UTF-8">
<title>Sign Up Login</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
</head>

<body>
<div class="cotn_principal">
  <div class="cont_centrar">
    <div class="cont_login">
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2>LOGIN</h2>
            <p>Login your system here</p>
            <button class="btn_login" onClick="cambiar_login()">LOGIN</button>
            <p style="color:red;font-size:12px;">${msg }</p>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2>SIGN UP</h2>
            <p>Sign up here if you don't have a account</p>
            <button class="btn_sign_up" onClick="cambiar_sign_up()">SIGN UP</button>
            <p style="color:red;font-size:12px;">${msg_re }</p>
          </div>
        </div>
      </div>
      <div class="cont_back_info">
        <div class="cont_img_back_grey"> <img src="img/po.jpg" alt="" /> </div>
      </div>
      <div class="cont_forms" >
        <div class="cont_img_back_"> <img src="img/po.jpg" alt="" /> </div>
        <form action="LoginServlet" name="login" method="post">
        <div class="cont_form_login" > <a href="#" onClick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
          <h2>LOGIN</h2>
          <input type="text" name="student_id_log" id="student_id_log" placeholder="Student ID" />
          <input type="password" name="student_password_log" id="student_password_log" placeholder="Password" />
          <button class="btn_login"  onClick="cambiar_login()">LOGIN</button>
        </div>
        </form>
        <form action="RegisterServlet" name="login" method="post">
        <div class="cont_form_sign_up"> <a href="#" onClick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
          <h2>SIGN UP</h2>
          <input type="text" name="student_id_reg" id="student_id_reg" onchange="check" placeholder="Student ID" />
          <input type="text" name="student_name_reg" id="student_name_reg" placeholder="User Name" />
          <input type="password" name="student_password_reg" id="student_password_reg" placeholder="Password" />
          <input type="password" name="confirm_password_reg" id="confirm_password_reg" placeholder="Confirm Password" />
          <button class="btn_sign_up"  onClick="cambiar_sign_up()">SIGN UP</button>
        </div>
        </form>
      </div>
    </div>
  </div>
</div>

<script src="js/index.js"></script>
</body>
</html>