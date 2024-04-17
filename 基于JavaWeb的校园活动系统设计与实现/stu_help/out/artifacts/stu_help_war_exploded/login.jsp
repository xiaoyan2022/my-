<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <script src="js/jquery-3.6.0.min.js"></script>
  <script src="js/left.js"></script>
  <style>
    li{
      cursor: pointer;
    }
    *{
      list-style: none;
      margin: 0 auto;
      padding: 0;
    }
    a{
      text-decoration: none;
      color: white;
    }

    #header{
      height: 50px;
      background: black;
      color: white;
      line-height: 50px;
      font-size: 14px;
      padding-right: 10px;
      padding-left: 30px;
    }
    #header li{
      display: inline;
    }
    #help{
      color:rgb(0,133,137);
      font-size: 20px;
      font-weight: bold;
    }
    #side a{
      display: inline;
      font-size: 13px;
      margin-left: 20px;
    }
    #login{
      float: right;
    }
    #login a{
      display: inline;
      padding: 20px;
    }
    #left{
      width: 10%;
      height: 700px;
      background:rgb(57,62,75);
      color: white;
      float: left;
    }
    #left li{
      width: 100%-20px;
      height: 30px;
      line-height: 30px;
      font-size: 13px;
      padding: 5px 0 5px 10px;
    }

    #main{
      margin: 0 auto;
      height: 700px;
      background-color: rgb(243,242,243);
      text-align: center;
    }
    .num{
      float: right;
      padding-right: 20px;
    }
    .par{
      background: rgb(0,116,119);
    }
    #title{
      font-weight: bold;
      padding: 30px;
      text-indent: 30px;
      text-align: left;
    }
    form{
      display: inline;
    }
    #mession{
      width: 500px;
      height: 500px;
      float: left;
      margin: 0 auto;
    }

    #m_con{
      margin-left: 100px;
      width: 1000px;
      height: 330px;
      background: white;
      padding: 15px;
      text-align: left;
    }
    #m_con li{
      margin-top: 5px;
      border-bottom: 1px solid gainsboro;
    }
    #m_con li a{
      color: black;
    }
    #m_con li p{
      font-size: 12px;
      padding: 5px;
    }
    table{
      padding: 10px;
      font-size: 13px;
      float: left;
    }
    table tr td{
      padding:10px;
      float: left;
    }
  </style>
</head>
<body>

<ul id="header">
  <li><span id="help">欢迎进入校园活动系统</span></li>
  <c:if test="${empty user}">
    <li id="login"><a href="reg.jsp">注册</a><a href="login.jsp">登录</a></li>
  </c:if>
  <c:if test="${not empty user}">
    <li id="login">欢迎用户 : ${user.name}<a href="login.jsp">退出</a></li>
  </c:if>
</ul>
<ul id="left">
  <li>请登录后查看</li>
</ul>


<div id="main">
  <p id="title">登录</p>
  <div id="mession">
    <ul id="m_con">
      <form action="login" method="post" onsubmit="return check()">
        <table>
          <tr><td>学号 <input type="text" name="sno" id="sno"></td><tr><td><span style="color: red">${msg}</span></td></tr></tr>
          <tr><td><span id="userNameReg"></span></td></tr>
          <tr><td>密码 <input type="password" name="pwd" id="pwd"></td></tr>
          <tr><td><span id="passWordReg"></span></td></tr>
          <tr><td><input type="submit" value="登录"></td></tr>
        </table>
      </form>
    </ul>
  </div>
</div>
</body>
</html>
<script>
  function check() {
    const sno = document.getElementById("sno").value;
    const pwd = document.getElementById("pwd").value;

    if(sno ==''||pwd ==''){
      alert("请完整填写信息")
      return false;
    }else{
      return true
    }
  }
</script>
