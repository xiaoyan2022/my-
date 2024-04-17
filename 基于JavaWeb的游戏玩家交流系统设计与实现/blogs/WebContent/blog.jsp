<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title></title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.all.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="color:white">游戏玩家交流系统</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="javascript:;"> <c:if test="${user == null }">欢迎游客</c:if><c:if test="${user !=null }">欢迎用户 : ${user.nickname }</c:if></a></li>
            <li class="layui-nav-item"><a href="logout">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <jsp:include page="leftMenu.jsp"></jsp:include>
        </div>
    </div>

     <div class="layui-body" style="margin:20px">
        <!-- 内容主体区域 -->
        <div id="rightMain">
        <div class="cms-breadcrumb">
	<i class="layui-icon layui-icon-flag"></i>
	<span class="layui-breadcrumb" >
	  	<a>交流论坛</a>
	  	<a>帖子列表</a>
	</span>
</div>

<div class="body-card layui-card">
	<div class="">
		<form class="layui-form" action="blogListByCondition" >
  			<div class="layui-inline" style="margin:10px">
	    		<label class="layui-form-label">游戏名称</label>
	   			<div class="layui-input-inline">
	      			<input type="text" name="type" placeholder="请输入游戏名称" class="layui-input" >
	    		</div>
  			</div>
  			<div class="layui-inline">
    			<label class="layui-form-label">帖子标题</label>
    			<div class="layui-input-inline">
      				<input type="text" name="title" placeholder="请输入帖子标题" class="layui-input" >
    			</div>
  			</div>
  			<div class="layui-inline">
		    	<div class="layui-input-inline">
		      		<button class="layui-btn" type="submit">查询</button>
		    	</div>
		  	</div>
  		</form>
	</div>
	<table class="layui-table">
	  	<colgroup>
	    	<col width="250">
	    	<col width="250">
	    	<col width="250">
	    	<col width="250">
	    	<col width="250">	
	    	<col width="200">
	  	</colgroup>
	 	<thead>
	    	<tr>
	      		<th>序号</th>
				<th>游戏名称</th>
				<th>帖子标题</th>
				<th>发布时间</th>
				<th>更新时间</th>
				<th>作者</th>
				<th>操作</th>
	    	</tr> 
	  	</thead>
	  	<tbody>
	  	<c:forEach items="${blogList }" var="b">
	  	<tr>
					<td>${b.id }</td>
					<td>${b.type}</td>
					<td>${b.title}</td>
					<td>${b.create_time}</td>
					<td>${b.update_time}</td>
					<td>${b.name}</td>
					<td>
						<a href="blog_detail?id=${b.id }"><button class="layui-btn" type="button">查看详情</button></a>
					</td>
				</tr>
	  	</c:forEach>
				
	  	</tbody>
	  	
	</table>
</div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
       游戏玩家交流系统
    </div>
</div>
<script>
    //JavaScript代码区域
    var element = layui.element;
    element.render();//对垂直导航、面包屑进行刷新，解决不显示的问题

    var form = layui.form;
    form.render();

    var layer = layui.layer;
    var tree = layui.tree;
</script>
</body>
</html>

