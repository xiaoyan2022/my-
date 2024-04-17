<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title></title>

<style>
	*{margin: 0;padding: 0;}
	#a1 {
		width: 80%;
		height: 70px;
		padding-left: 23px;
		padding-top: 20px;
		margin-bottom: 10px;
		margin-top: 5px;
		box-shadow: 0px 0px 1500px 0px #DDDDDD;
		float: left;
		z-index: 1;
	}
	#top{
		 /* background: linear-gradient(to right,#6495ED,mistyrose);
		        -webkit-background-clip: text;
		        color: transparent; */
				color: #6495ED;
	}
	#a2{width: 18%;height: 70px;float: left;margin-bottom: 10px;padding-top: 20px;
		margin-top: 5px;box-shadow: 0px 0px 1500px 0px #DDDDDD;z-index: 1;}
	#aa1,#aa2{width: 35%;height: 45px;float: left;margin-right: 10px;
	border-radius: 5px 5px 5px 5px;box-shadow: 0px 0px 20px 0px #DCDCDC;}
	#aa2 a,#aa1 a{font-size: larger;width: 100%;height: 42px;color: #6495ED;line-height: 42px;
	text-decoration: none;}
	#aa1 a:hover{color: #BD0A01;}
	#aa2 a:hover{color: #BD0A01;}
	#tab1{float: left;width: 220px;height: 550px;text-align: left;margin-top: 0px;border: 1px solid #6495ED;background:#6495ED;margin-left: 5px;box-shadow: 0px 0px 35px 0px #DDDDDD;}
	#tab2{float: left;width: 100%;height: 170px;text-align: center;border-bottom: 1px solid #000000;color: #DDDDDD;}
	#t2{height: 150px;width: 100%;}
	#t2 tr th{height: 30px;font-size: x-large;}
	img{border:0;}
	#img1{margin-top: 5px;border-radius: 50%;}
	ul,li{list-style-type:none;}
	a{color:#6495ED;text-decoration:none;}
	a:hover {color:#bd0a01;text-decoration:underline;}
	.boxmsg{width: 130px;background-color: ;height: 10px;}
	.treebox{ width: 100%; margin: 0px auto; background-color: #6495ED;}
	.menu{ overflow: hidden; border-color: #ddd; border-style: solid ; border-width: 0 1px 1px ; }
	/*第一层*/
	.menu li.level1>a{ 
		display:block;
		height: 47px;
		line-height: 47px;
		color: white;
		padding-left: 50px;
		border-bottom: 1px solid #000; 
		font-size: 15px;
		position: relative;
		transition:all .5s ease 0s;
	 }
	 #mg{height: 100px;background-color: #6495ED;text-align: center;width: 200px;}
	 .menu li.level1 a:hover{ text-decoration: none;background:-webkit-linear-gradient(left,#6495ED,mistyrose);/* border: 2px solid #000000; */}
	 
	 .menu li.level1 a.current{background:-webkit-linear-gradient(top,#6495ED,pink);}

	 .ico{ width: 20px; height: 20px; display:block;   position: absolute; left: 20px; top: 13px; background-repeat: no-repeat; background-image: url(images/ico1.png); }

	 
	 .level1 i{ width: 20px; height: 10px; background-image:url(images/arrow.png); background-repeat: no-repeat; display: block; position: absolute; right: 20px; top: 20px; }
	.level1 i.down{ background-position: 0 -10px; }

	 .ico1{ background-position: 0 0; }
	 .ico2{ background-position: 0 -20px; }
	 .ico3{ background-position: 0 -40px; }
	 .ico4{ background-position: 0 -60px; }
	.ico5{ background-position: 0 -80px; }


	 .menu li ul{ overflow: hidden; }
	 #xinxi{visibility: visible;}
	 .menu li ul.level2{ display: none;background: #6495ED; }
	 .menu li ul.level2 li a{
		display: block;
		height: 45px;
		line-height: 45px;
		color: white;
		text-indent: 60px;
		font-size: 17px;
		 transition:all 1s ease 0s;
	 }
	#zhu{width: 80%;height: 550px;float: left;margin-left: 5px; box-shadow: 0px 0px 35px 0px #DDDDDD;z-index: 0;}
    #zhu table tr td{
    width:200px;
    text-align:center;
    padding:10px;
    border-bottom:2px solid blue;
    }
</style>
</head>
<body>
	<div id="a1">
		<img src="img/logo_jw_d.png" style="vertical-align: bottom;">
		
			<font size="6"><b><span id="top">&nbsp;餐厅点餐系统后台管理</span></b></font>
	</div>
	<div id="a2">
		<center>
		<div id="aa1">
			<a href="javascript:;" onclick="custom_close()"><span id="top"><b>退出</b></span></a>
		</div>
		</center>
	</div>
<div id="tab1">
	<div id="tab2">
		<table border="0" cellspacing="0" cellpadding="0" id="t2">
			<tr><th>书&nbsp;店&nbsp;后&nbsp;台&nbsp;管&nbsp;理</th></tr>
			<tr><td ><img src="img/3d84e1a572d7a401ad5c01661b571b06.jpg" width="100px" height="100px" id="img1"></td></tr>
			<span style="text-align:right">欢迎管理员 : <%=session.getAttribute("adName")%></span>
		</table>
	</div>
<div class="treebox">
	<ul class="menu">
		<li class="level1">
			<a href="#none"><em class="ico ico5"></em>菜品管理<i class="down"></i></a>
			<ul class="level2">
				<li><a href="add_book.jsp">添加菜品</a></li>
				<li><a href="bookList" >菜品管理</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none"><em class="ico ico4"></em>用户管理<i></i></a>
			<ul class="level2">
				<li><a href="userList">用户信息</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none"><em class="ico ico3"></em>订单管理<i></i></a>
			<ul class="level2">
				<li><a href="cartList" >订单查询</a></li>
			</ul>
		</li>
	</ul>
</div>
</div>
<div id="zhu">
	<table>
	<tr><td>用户ID</td><td>用户名</td><td>密码</td><td>昵称</td><td>住址</td><td>手机号</td></tr>
	<c:forEach items="${users }" var="u">
	<tr>
	<td>${u.id }</td>
	<td>${u.username }</td>
	<td>${u.password }</td>
	<td>${u.nickname }</td>
	<td>${u.address }</td>
	<td>${u.tel }</td>
	</tr>
	</c:forEach>
	</table>
</div>
<!-- 引入 jQuery -->
<script src="js/jquery1.8.3.min.js"></script>
<script src="js/easing.js"></script>
<script>

$(function(){
	$(".treebox .level1>a").click(function(){
		$(this).addClass('current')   
		.find('i').addClass('down')  
		.parent().next().slideDown('slow','easeOutQuad')  
		.parent().siblings().children('a').removeClass('current')
		.find('i').removeClass('down').parent().next().slideUp('slow','easeOutQuad');
		 return false; 
	});
})
</script>
	<script language="JavaScript">
	function custom_close(){
		if(confirm('确认要退出吗？'))
		{
			window.location.href="logout"
		 }
	}
	</script>
	<script type="text/javascript">
		var btn = document.getElementById("btn");
		var body = document.getElementById("zhu");
		let array = ["cadetblue", "#DCDCDC", "mistyrose", "white", "pink", "#DEB887", "coral","#FFF"];
		let index = 0;
		btn.onclick = function () {
		body.style.backgroundColor = array[index];
		index = (index + 1) % array.length;
		}
	</script>
</body>
</html>