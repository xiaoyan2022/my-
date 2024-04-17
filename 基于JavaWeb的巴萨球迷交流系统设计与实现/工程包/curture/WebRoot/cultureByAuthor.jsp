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

        form {
            display: inline;
            margin: 10px;
        }
        #by{
            cursor: pointer;
        }
        #by:hover{
            color: orange;
        }

        p button{
            display:inline;
            float: left;
            margin-right: 10px;
            margin-top: 21px;
            border:1px solid orange;
            padding: 5px;
            cursor: pointer;
            font-weight: bold;
        }
        table tr td{
            padding: 10px;
            width: 200px;
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
        <p id="top">欢迎<c:if test="${user.role == 0}">用户</c:if><c:if test="${user.role == 1}">创作者</c:if> : <span>${user.nickname }</span></p>
    </c:if>
    <c:if test="${user == null}">
        <p id="top">欢迎游客 : visitor<span></span></p>
    </c:if>
    <div id="content">
        <h1>帖子管理</h1>
        <p>
            <a href="add_culture.jsp"><button>添加</button></a>
        </p>
        <form action="#" method="post" onsubmit="return false">
            <table>
                <tr><td>编号</td><td>标题</td><td>作者</td><td>发布时间</td><td>开放评论</td><td>操作</td></tr>
                <c:forEach items="${cu}" var="cu">
                    <tr><td>${cu.cno}</td>
                        <td id="by" onclick="window.location.href='cultureById?cno=${cu.cno}'">${cu.title}</td>
                        <td>${cu.name}</td>
                        <td>${cu.date}</td>
                        <td><c:if test="${cu.open==1}">是</c:if><c:if test="${cu.open==0}">否</c:if></td>
                        <td><button onclick="update(${cu.cno})">修改</button>&nbsp;<button onclick="del(${cu.cno})">删除</button></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
</div>
</body>
</html>
<script>
    function del(cno) {
        window.location.href = "del_culture?cno="+cno
    }

    function update(cno) {
        window.location.href = "cultureUpdateList?cno="+cno
    }
</script>