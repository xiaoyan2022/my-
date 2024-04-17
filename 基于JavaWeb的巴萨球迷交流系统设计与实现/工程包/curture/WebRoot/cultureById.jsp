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


        h1{
            text-align: left;
            padding: 10px;
            text-indent: 10px;
        }
        table{
            display:block;
            text-align:center;
        }
        table tr td{
            padding: 10px;
            width: 200px;
        }

        #wrap {
            display: inline;
            margin: 10px;
            text-align: center;
        }

        #wrap h1{
            text-align: center;
        }
        #wrap a{
            color: black;
        }

        #return{
            float: left;margin-left: 20px;
            font-size: 20px;
        }
        #comment{
            height: 300px;
            overflow: scroll;
            text-align: left;
        }
        #author{
            font-size: 14px;
            margin-bottom: 10px;
        }
        #culture{
            height: auto;
            text-indent: 30px;
            margin-bottom: 10px;
            border-top: 2px solid orange;
            padding-bottom: 100px;
            padding-top: 20px;
            text-align: left;
        }
        #comment h1{
            text-align: left;
        }
        #comment p{
            padding: 10px;
        }
        #myContent{
            border-bottom: 2px solid orange;
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
        <h1>交流论坛</h1>
        <p>
            <a href="cultureList"><button id="return">返回</button></a>
        </p>
        <div id="wrap">
            <table>
                <h1>${c.title}</h1>
                <p id="author">作者 : ${c.name} 发布时间 : ${c.date}</p>
                <p id="culture">
                    ${c.content}
                </p>
                ${c.likes} <button onclick="addNum(${c.cno},1)">赞</button> ${c.dislike} <button onclick="addNum(${c.cno},0)">踩</button>
                <p>${msg}</p>
                <div id="comment">
                    <h1>评论</h1>
                    <c:forEach items="${co}" var="co" varStatus="v">
                        <div id="myContent">
                            <p>${v.index+1}楼 ${co.name} 评论时间 : ${co.date} <c:if test="${user.role == 1}"><button onclick="del(${co.cid},${co.cno})">删除</button></c:if></p>
                            <p>${co.content}</p>
                        </div>
                    </c:forEach>
                    <c:if test="${c.open==1}">
                        <form action="#" onsubmit="return false">
                        <textarea rows="10" cols="60" id="my_Content">
                        </textarea>
                            <input type="submit" value="添加评论" onclick="addComment(${c.cno},${user.uid})">
                        </form>
                    </c:if>
                    <c:if test="${c.open==0}">
                        评论已关闭
                    </c:if>
                </div>
            </table>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function addNum(cno,type) {
        window.location.href = "add_num?cno="+cno+"&type="+type
    }
    function addComment(cno,uid) {
        const content = document.getElementById("my_Content").value;
        if(uid==null){
            if(confirm("游客身份无法评论，是否跳转至登录？")){
                window.location.href = "login.jsp"
            }
        }else{
            if(content.length<30){
                alert("评论最少为6个字符")
            }else{
                window.location.href = "add_comment?cno="+cno+"&content="+content
            }
        }
    }
    function del(cid,cno) {
        window.location.href="del_comment?cid="+cid+"&cno="+cno

    }
</script>
