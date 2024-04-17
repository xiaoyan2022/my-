<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
    html{
        width: 100%;
        height: 100%;
        overflow: hidden;
        font-style: sans-serif;
    }
    body{
        width: 100%;
        height: 100%;
        font-family: 'Open Sans',sans-serif;
        margin: 0;
        background-color: #4A374A;
    }
    #login{
        position: absolute;
        top: 50%;
        left:50%;
        margin: -200px 0 0 -150px;
        width: 300px;
        height: 300px;
    }
    #login h1{
        color: #fff;
        text-shadow:0 0 10px;
        letter-spacing: 1px;
        text-align: center;
    }
    h1{
        font-size: 2em;
        margin: 0.67em 0;
    }
    .input_a{
        width: 278px;
        height: 18px;
        margin-bottom: 10px;
        outline: none;
        padding: 10px;
        font-size: 13px;
        color: #fff;
        text-shadow:1px 1px 1px;
        border-top: 1px solid #312E3D;
        border-left: 1px solid #312E3D;
        border-right: 1px solid #312E3D;
        border-bottom: 1px solid #56536A;
        border-radius: 4px;
        background-color: #2D2D3F;
    }
    .but{
        width: 300px;
        min-height: 20px;
        display: block;
        background-color: #4a77d4;
        border: 1px solid #3762bc;
        color: #fff;
        padding: 9px 14px;
        font-size: 15px;
        line-height: normal;
        border-radius: 5px;
        margin: 0;
    }
</style>
</head>
<body>
<div id="login">
    <h1>注册</h1>
    <table>
        <form action="reg" method="post">
            <tr><td><input class="input_a" type="text" required="required" placeholder="用户名" name="username" id="username"></td></tr>
            <tr><td><span id="userNameReg"></span></td></tr>
            <tr><td><input class="input_a" type="password" required="required" placeholder="密码" name="password" id="password"></td></tr>
            <tr><td><span id="passWordReg"></span></td></tr>
            <tr><td><span style="color: red">${msg}</span></td></tr>
            <tr><td style="color:white">请选择登录身份 : <input type="radio" value="0" name="role" checked="checked">普通用户<input type="radio" value="1" name="role">创作者</td></tr>
            <tr><td><button class="but" type="submit">注册</button></td></tr>
            <tr><td><button class="but" type="button" onclick="window.location.href='login.jsp'">返回</button></td></tr>
        </form>
    </table>
</div>
</body>
</body>
</html>