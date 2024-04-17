<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <script src="js/jquery-3.6.0.min.js"></script>
  <script src="js/left.js"></script>
  <script>
    function search(){
      window.location.href="#"
    }
  </script>
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
      width: 100%;
      height: 350px;
      font-size: 13px;
    }
    table tr td{
      padding:10px;
      float: left;
    }
  </style>
</head>
<body>

<ul id="header">
  <li><span id="help">欢迎进入校园活动系统</span><span id="side"><a href="userList">个人中心</a><a href="taskList">活动中心</a><a href="goodList">交流中心</a></span></li>
  <c:if test="${empty user}">
    <li id="login"><a href="#">注册</a><a href="#">登录</a></li>
  </c:if>
  <c:if test="${not empty user}">
    <li id="login">欢迎用户 : ${user.name}<a href="logout">退出</a></li>
  </c:if>
</ul>
<ul id="left">
  <li>校园活动系统</li>
  <ul class="task">
    <li class="par">活动管理</li>
    <li><a href="taskListBySno?status=1">已发布活动</a><span class="num">${count}</span></li>
    <li><a href="taskListBySno?status=0">已报名活动</a><span class="num">${count2}</span></li>
    <li><a href="add_task.jsp">发布新活动</a></li>
  </ul>
  <ul class="sell">
    <li class="par">活动交流</li>
    <li><a href="goodListBySno?status=1">我的帖子</a><span class="num">${count3}</span></li>
    <li><a href="add_good.jsp">发布帖子</a></li>
  </ul>
  <ul class="me">
    <li class="par">个人中心</li>
    <li><a href="userList">个人信息</a></li>
    <li><a href="user_update.jsp">资料修改</a></li>
    <li><a href="password.jsp">安全设置</a></li>
  </ul>
</ul>


<div id="main">
  <p id="title">发布新活动</p>
  <div id="mession">
    <ul id="m_con">
      <form action="add_task" method="post" onsubmit="return check()">
        <table>
          <tr><td>活动标题 <input type="text" name="title" id="title2"></td></tr>
          <tr><td>活动描述 <input type="text" name="des" id="des"></td></tr>
          <tr><td>活动人数 <input type="text" name="reward" id="reward"></td></tr>
          <tr><td>开始时间 <input type="date" name="time" id="time"></td></tr>
          <tr><td>结束时间 <input type="date" name="end" id="end"></td></tr>
          <tr><td><input type="submit" value="添加"></td></tr>
        </table>
      </form>
    </ul>
  </div>
</div>
</body>
</html>
<script>
  function check() {
    const title = document.getElementById("title2").value;
    const des = document.getElementById("des").value;
    const reward = document.getElementById("reward").value;
    const time = document.getElementById("time").value;
    const end = document.getElementById("end").value;

    if(title==''||des==''||reward==''||time==''||end==''){
      alert("请填写完整信息")
      return false;
    }else{
      return true;
    }
  }
</script>