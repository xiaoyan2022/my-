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
      padding-left: 300px;
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
      width: 1000px;
      height: 300px;
      background: white;
      padding: 15px;
      overflow: scroll;
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
  </style>
</head>
<body>

<ul id="header">
  <li><span id="help">校园帮服务平台</span><span id="side"><a href="#">个人中心</a><a href="#">任务中心</a><a href="#">交易中心</a></span></li>
  <li id="login"><a href="#">注册</a><a href="#">登录</a></li>
</ul>
<ul id="left">
  <li>校园即时服务平台</li>
  <ul class="task">
    <li class="par">任务管理</li>
    <li><a href="#">已发布任务</a><span class="num">0</span></li>
    <li><a href="#">已接受任务</a><span class="num">0</span></li>
    <li><a href="#">发布新任务</a></li>
  </ul>
  <ul class="sell">
    <li class="par">二手商品交易</li>
    <li><a href="#">我的商品</a><span class="num">0</span></li>
    <li><a href="#">商品订单</a><span class="num">0</span></li>
    <li><a href="#">发布商品</a></li>
  </ul>
  <ul class="me">
    <li class="par">个人中心</li>
    <li><a href="#">个人信息</a></li>
    <li><a href="#">资料修改</a></li>
    <li><a href="#">安全设置</a></li>
  </ul>
</ul>


<div id="main">
  <p id="title">任务平台</p>
  <div id="mession">
    <div id="search">
      类型
      <select>
        <option>未选择</option>
        <option>跑腿</option>
        <option>跑腿</option>
        <option>跑腿</option>
        <option>跑腿</option>
      </select>
      <form action="" onsubmit="return false">
        <input type="text">
        <input type="submit" value="搜索" onclick="search()">
      </form>
    </div>
    <p>任务</p>
    <ul id="m_con">
      <li>
        <p><span class="wait">待解决</span><span class="des"><a href="task_info.jsp">好兄弟，帮忙拿个快递</a></span></p>
        <p>马牛逼<span style="margin-left:30px;margin-right: 30px;">2022-12-07</span>悬赏：10￥</p>
      </li>
      <li>
        <p><span class="wait">待解决</span><span class="des">好兄弟，帮忙拿个快递</span></p>
        <p>马牛逼<span style="margin-left:30px;margin-right: 30px;">2022-12-07</span>悬赏：10￥</p>
      </li>
      <li>
        <p><span class="wait">待解决</span><span class="des">好兄弟，帮忙拿个快递</span></p>
        <p>马牛逼<span style="margin-left:30px;margin-right: 30px;">2022-12-07</span>悬赏：10￥</p>
      </li>
      <li>
        <p><span class="wait">待解决</span><span class="des">好兄弟，帮忙拿个快递</span></p>
        <p>马牛逼<span style="margin-left:30px;margin-right: 30px;">2022-12-07</span>悬赏：10￥</p>
      </li>
      <li>
        <p><span class="wait">待解决</span><span class="des">好兄弟，帮忙拿个快递</span></p>
        <p>马牛逼<span style="margin-left:30px;margin-right: 30px;">2022-12-07</span>悬赏：10￥</p>
      </li>
      <li>
        <p><span class="wait">待解决</span><span class="des">好兄弟，帮忙拿个快递</span></p>
        <p>马牛逼<span style="margin-left:30px;margin-right: 30px;">2022-12-07</span>悬赏：10￥</p>
      </li>
    </ul>
  </div>
</div>
</body>
</html>
