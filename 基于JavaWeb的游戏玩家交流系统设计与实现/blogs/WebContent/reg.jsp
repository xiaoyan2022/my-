<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <style type="text/css">
        .container{
            width: 420px;
            height: 320px;
            min-height: 320px;
            max-height: 320px;
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
            margin: auto;
            padding: 20px;
            z-index: 130;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
            font-size: 16px;
        }

        .close{
            background-color: white;
            border: none;
            font-size: 18px;
            margin-left: 410px;
            margin-top: -10px;
        }

        .layui-input{
            border-radius: 5px;
            width: 300px;
            height: 40px;
            font-size: 15px;
        }

        .layui-form-item{
            margin-left: -20px;
        }

        #logoid{
            margin-top: -16px;
            padding-left:150px;
            padding-bottom: 15px;
        }

        .layui-btn{
            margin-left: -50px;
            border-radius: 5px;
            width: 350px;
            height: 40px;
            font-size: 15px;
        }

        .verity{
            width: 120px;
        }

        .font-set{
            font-size: 13px;
            text-decoration: none;
            margin-left: 120px;
        }

        a:hover{
            text-decoration: underline;
        }
        
        h1{
            text-align:center;
            padding:10px;
        }

    </style>
</head>

<body background="https://cn.bing.com/th?id=OHR.BigHole_ZH-CN2671071218_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp">
<form class="layui-form" action="reg">
    <div class="container">

        <h1>注册</h1>

        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username" id="username"required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密 &nbsp;&nbsp;码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" id="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="login" id="login" type="submit">
                    注册
                </button>
            </div>
        </div>
        
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="login" id="login" type="button" onclick="window.location.href="login.jsp"">
                    登录
                </button>
            </div>
        </div>
        

        <p style="color:red;text-align: center">${msg }</p>

    </div>
</form>

<script type="text/javascript"  src="layui/layui.js"></script>
</body>
</html>