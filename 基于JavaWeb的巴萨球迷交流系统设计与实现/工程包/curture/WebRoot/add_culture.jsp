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

        #title{
            float: left;
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
            <a href="cultureListByAuthor"><button>返回</button></a>
        </p>
        <form action="#" onsubmit="return false">
            <table>
               <tr>
                   <td>请输入标题 : </td><td><input type="text" id="title" ></td>
               </tr>
                <tr>
                    <td>请输入内容 : </td><td><textarea rows="10" cols="60" id="myContent"></textarea></td>
                </tr>
                <tr>
                    <td>是否开放评论 : <input type="radio" name="open" value="1" checked="checked">是&nbsp<input type="radio" name="open" value="0" >否</td>
                </tr>
                <tr><td><input type="submit" value="添加" onclick="add()"></td></tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
<script>
    function add() {
        const title = document.getElementById("title").value;
        const content = document.getElementById("myContent").value;
        const obj = document.getElementsByName("open");

        function getChecked(){
            for(let i=0;i<obj.length;i++){
                if(obj[i].checked){
                    return obj[i].value;
                }
            }
        }
        window.location.href = "add_culture?title="+title+"&content="+content+"&open="+getChecked()
    }
</script>
