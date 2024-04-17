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
    #search{
      width: 500px;
      height: 30px;
      margin-bottom: 20px;
    }
    #m_con{
      margin-left: 100px;
      width: 1000px;
      height: 300px;
      background: white;
      padding: 15px;
      overflow: scroll;
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
    .wait{
      border: 2px solid green;
      color: green;
      padding: 2px;
      margin-right: 20px;
    }
    .des{
      font-size: 14px;
    }
    #detail p{
      text-align: left;
      font-size: 14px;
      text-indent: 10px;
      padding: 10px;
    }

    #detail table td{
      width: 250px;
      border-bottom: 1px solid black;
      padding: 10px;
      font-size: 12px;
      text-align: left;
    }

    #detail button{
      font-size: 12px;
      padding: 5px;
      margin-top: 40px;
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
  <p id="title">活动中心</p>
  <div id="mession">
    <div id="search">
      <form action="taskListByCondition" >
        活动名称&nbsp;<input type="text" id="title2" name="title" placeholder="请输入活动名称" >
        <input type="submit" value="搜索" >
      </form>
    </div>
    <ul id="m_con">
     <c:forEach items="${task}" var="t">
       <li>
         <p><span class="wait">活动未开始</span><span class="des" onclick="detail(${t.tid})">${t.title}</span></p>
         <p>发起人 : ${t.pub}<span style="margin-left:30px;margin-right: 30px;">开始时间:${t.time}</span><span style="margin-right: 30px;">结束时间:${t.end}</span>参与人数：${t.reward}</p>
       </li>
     </c:forEach>
    </ul>
  </div>
</div>
</body>
</html>
<script>
  function detail(tid) {
    window.location.href="taskDetailList?tid="+tid
  }
</script>
