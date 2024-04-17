<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/nprogress.css">
    <link rel="stylesheet" href="css/demo.css">
    <script src="layui/layui.all.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/jquery.pjax.js"></script>
    <script src="js/nprogress.js"></script>
    <script src="js/demo.js"></script>
</head>
<body>
<ul class="layui-nav layui-nav-tree" >
	 <li class="layui-nav-item"><a href="javascript:;">交流论坛</a>
	        <dl class="layui-nav-child">
	            <dd>
	                <a class="pjax-a" href="blogList">帖子列表</a>
	            </dd>
	            <dd>
	                <a class="pjax-a" href="blogListByAuthor">我发布的</a>
	            </dd>
	        </dl></li>
    <li class="layui-nav-item"><a href="javascript:;">论坛管理</a>
        <dl class="layui-nav-child">
            <dd>
                <a class="pjax-a" href="blog_add.jsp">发布帖子</a>
            </dd>
            <dd>
                <a class="pjax-a" href="blogList2">管理帖子</a>
            </dd>
        </dl></li>
</ul>
</body>
</html>