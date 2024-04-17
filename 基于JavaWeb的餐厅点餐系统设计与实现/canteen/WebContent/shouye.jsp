<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
		<style type="text/css">
			#a1{width: 230px;height: 120px;border-radius: 3px 3px 3px 3px;box-shadow: 0px 0px 35px 0px #dcdcdc;float: left;
			margin-left: 1%;margin-top: 20px;padding: 10px;}
			#a3{width: 23%;height: 120px;border-radius: 3px 3px 3px 3px;box-shadow: 0px 0px 35px 0px #dcdcdc;float: left;
			margin-left: 1%;margin-top: 20px;background-color: #6495ED;padding: 10px;}
#a2{width: 50%;height: 410px;border-radius: 23px 23px 23px 23px;box-shadow: 0px 0px 35px 0px #dcdcdc;float: right;
margin-top: 15px;background-color: #6495ED;}
			* {box-sizing:border-box;}
			ul {list-style-type: none;}
			body {font-family: Verdana,sans-serif;}
			.month {
			   padding: 50px 25px;
				height: 150px;
			    width: 100%;
			    background: #6495ED;
				border-radius: 23px 23px 0px 0px;
			}
			.month ul {
			    margin: 0;
			    padding: 0;
			}
			 
			.month ul li {
			    color: white;
			    font-size: 20px;
			    text-transform: uppercase;
			    letter-spacing: 3px;
			}
			 
			.month .prev {
			    float: left;
			   padding-top: 10px;
			}
			 
			.month .next {
			    float: right;
			   padding-top: 10px;
			}
			 
			.weekdays {
				height: 60px;
			    margin: 0;
			    padding: 10px 0;
				line-height: 40px;
			    background-color: #ddd;
			}
			 
			.weekdays li {
			    display: inline-block;
			    width: 13%;
			    color: #666;
			    text-align: center;
			}
			 
			.days {
			    padding: 10px 0;
				height: 200px;
				padding-top: 20px;
			    background: #eee;
			    margin: 0;
			}
			 
			.days li {
			    list-style-type: none;
			    display: inline-block;
			    width: 13%;
			    text-align: center;
			    margin-bottom: 5px;
			    font-size:16px;
			    color: #777;
			}
			 
			.days li .active {
			    padding: 5px;
			    background: #6495ED;
			    color: white !important
			}
			 
			/* 添加不同尺寸屏幕的样式 */
			@media screen and (max-width:720px) {
			    .weekdays li, .days li {width: 13.1%;}
			}
			 
			@media screen and (max-width: 420px) {
			    .weekdays li, .days li {width: 12.5%;}
			    .days li .active {padding: 2px;}
			}
			 
			@media screen and (max-width: 290px) {
			    .weekdays li, .days li {width: 12.2%;}
			}
			#i1{height: 220px;}
			#btoom{width: 100%;height: 40px;margin-top: 40px;font-size: 26px;color: white;}
			#btoom1{width: 100%;height: 40px;margin-top: 40px;font-size: 26px;color: #6495ED;}
			#biao{float: right;font-size: 26px;}
		</style>
	</head>
	<body>
		<h1><font style="color: #666;">~~首页~~</font></h1>
		<div id="a3">
			<font size="4" color="white">书店用户总人数</font>
			<hr color="#666" size="2" width="30%" align="left">
			<center>
			<div id="btoom">
			<b>1432人</b>
			<div id="biao">
				<b>Ⅰ</b>
			</div>
			</div></center>
		</div>
		<div id="a1">
			<font size="4" color="#6495ED">交易成功率</font>
			<hr color="#666" size="2" width="30%" align="left">
			<center>
			<div id="btoom1">
			<b>78%</b>
			<div id="biao">
				<b>Ⅱ</b>
			</div>
			</div></center>
		</div>
		<div id="a2">
			<div class="month">      
			<center>
			  <ul>
			    <li class="prev"><span style="font-size: 28px;">❮</span></li>
			    <li class="next"><span style="font-size: 28px;">❯</span></li>
			    <li style="text-align:center">
			      <span style="font-size: 28px;">April</span><br>
			      <span style="font-size:28px">2022</span>
			    </li>
			  </ul></center>
			</div>
			 
			<ul class="weekdays">
			  <li>Mo</li>
			  <li>Tu</li>
			  <li>We</li>
			  <li>Th</li>
			  <li>Fr</li>
			  <li>Sa</li>
			  <li>Su</li>
			</ul>
			 
			<ul class="days">  
			  <li>1</li>
			  <li>2</li>
			  <li>3</li>
			  <li>4</li>
			  <li>5</li>
			  <li>6</li>
			  <li>7</li>
			  <li>8</li>
			  <li>9</li>
			  <li>10</li>
			  <li>11</li>
			  <li>12</li>
			  <li>13</li>
			  <li>14</li>
			  <li>15</li>
			  <li>16</li>
			  <li>17</li>
			  <li>18</li>
			  <li>19</li>
			  <li>20</li>
			  <li>21</li>
			  <li>22</li>
			  <li>23</li>
			  <li>24</li>
			  <li><span class="active">25</span></li>
			  <li>26</li>
			  <li>27</li>
			  <li>28</li>
			  <li>29</li>
			  <li>30</li>
			  <li>31</li>
			</ul>
		</div>
		<div id="a1">
			<font size="4" color="#6495ED">交易总金额</font>
			<hr color="#666" size="2" width="30%" align="left">
			<center>
			<div id="btoom1">
			<b>*****</b>
			<div id="biao">
				<b>Ⅲ</b>
			</div>
			</div></center>
		</div>
		<div id="a3">
			<font size="4" color="white">销售数量</font>
			<hr color="#666" size="2" width="30%" align="left">
			<center>
			<div id="btoom">
			<b>*****</b>
			<div id="biao">
				<b>Ⅳ</b>
			</div>
			</div></center>
		</div>
		<div id="a3">
			<font size="4" color="white">公告</font>
			<hr color="#666" size="2" width="30%" align="left">
			<center>
			<div id="btoom">
			<b>待更新</b><div id="biao">
				<b>Ⅴ</b>
			</div>
			</div></center>
		</div>
		<div id="a1">
			<font size="4" color="#6495ED">黑名单人数</font>
			<hr color="#666" size="2" width="30%" align="left">
			<center>
			<div id="btoom1">
			<b>18人</b>
			<div id="biao">
				<b>Ⅵ</b>
			</div>
			</div></center>
		</div>
	</body>
</html>