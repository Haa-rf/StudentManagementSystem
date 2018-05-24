(function validate_login(){
   var name = document.getElementById("user").value;
   var password = document.getElementById("pass").value;
   if(name==null || name==""){
     alert("姓名不能为空");
     return false;
   }
    if(password==null || password==""){
     alert("密码不能为空");
     return false;
   }
   return true;
  })