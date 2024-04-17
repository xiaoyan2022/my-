<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Document</title>
    <style>
        *{
            margin: 0 auto;
            padding: 0;
            list-style: none;
        }
        a{
            text-decoration: none;
            color: white;
        }
        #main{
            width: 100%;
            height: 700px;
        }
        #left{
            padding-top: 20px;
            width: 10%;
            height: 700px;
            float: left;
            background: rgb(56,55,79);
        }
        #left li{
            padding: 20px;
            display: block;
            text-align: center;
            color: white;
        }
        #top{
            background-color:#ff9900;
            box-shadow: 100px 5px 5px #888888;
            height:40px;
            line-height: 40px;
            padding-right: 20px;
            font-weight: bold;
            text-align: right;
        }

        #left li img{
            width: 30px;
            height: 30px;
            float: left;
        }
        #content{
            margin: 0 auto;
            width: 100%;
            height: 660px;
            text-align: center;
        }
        #content p{
            padding: 30px;
            text-indent: 20px;
        }

        h1{
            text-align: left;
            padding: 10px;
            text-indent: 10px;
        }
        table{
            display:block;
            text-align:center;
            border: 2px solid orange;
        }
        table tr td{
            padding: 10px;
        }

        form {
            display: inline;
            margin: 10px;
        }

        button{
            display:inline;
            float: left;
            margin-right: 10px;
            margin-top: 21px;
            border:1px solid orange;
            padding: 5px;
            cursor: pointer;
            font-weight: bold;
        }
    </style>
</head>
<body>
<ul id="left">
    <li><a href="index.jsp">首页<img src="images/shouye.png"></a></li>
    <li><a href="cultureList">交流论坛<img src="images/chuantongwenshi.png"></a></li>
    <c:if test="${user != null}">
        <c:if test="${user.role==1}">
            <li><a href="cultureListByAuthor">帖子管理<img src="images/houtai.png"></a></li>
        </c:if>
        <li><a href="userList">我的信息<img src="images/wode.png"></a></li>
    </c:if>
    <li><a href="logout">退出登录<img src="images/tuichudenglu.png"></a></li>
</ul>
<div id="main">
    <c:if test="${user != null}">
        <p id="top">欢迎<c:if test="${user.role == 0}">用户</c:if><c:if test="${user.role == 1}">博主</c:if> : <span>${user.nickname }</span></p>
    </c:if>
    <c:if test="${user == null}">
        <p id="top">欢迎游客 : visitor<span></span></p>
    </c:if>
    <div id="content">
        <h1>我的信息</h1>
        <p>
            <a href="userList"><button>基本信息</button></a>
            <a href="password.jsp"><button>修改密码</button></a>
        </p>
        <form action="updateUser" method="post">
            <table>
                <tr><td>用户名 : </td><td><span style="text-align: left;display: block">${user.username}</span></td></tr>
                <tr><td>昵称 : </td><td><input type="text" name="nickname" value="${user.nickname}"></td><td><span style="color: red">${msg}</span></td></tr>
                <tr><td><input type="submit" value="保存"></td></tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
