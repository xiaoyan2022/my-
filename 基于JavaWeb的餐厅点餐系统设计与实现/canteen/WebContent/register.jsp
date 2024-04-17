<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/new_file.css">
    <title>注册界面</title>
</head>
<body>
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>注 册</h4>
             <form action="reg" method="post" onsubmit="return check()">
               <input class="acc" type="text" name="adminNum" id="name" placeholder="用户名">
                <input class="acc" type="password" name="adminPwd" id="pass" placeholder="密码">
                <input class="submit" type="submit" value="注册">
            </form>
            <div class="fn">
                <a href="adminLogin.jsp">返回登录</a>
                <a href="javascript:;">找回密码</a>
            </div>
        </div> 
    </div>
    <%
    String msg=(String)session.getAttribute("msg");
    if("".equals(msg)&&msg==null){
    }
 else if("false".equals(msg)){%>
    <script type="text/javascript">
    window.setTimeout("alert('用户名或密码错误')",100);
    </script>
 <%
    session.setAttribute("msg", ""); 
 }%>
</body>
</html>
<script>
function check(){
	var name = document.getElementById("name").value;
	var pass = document.getElementById("pass").value;
	
	if(name==''||pass==''){
		alert("请填写完整信息")
		return false
	}else{
		return true
	}
}
</script>