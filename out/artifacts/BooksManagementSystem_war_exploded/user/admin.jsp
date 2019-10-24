<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Main</title>
	<link rel="stylesheet" type="text/css" href="../css/admin.css">
	<script type="text/javascript" src="../js/admin.js"></script>
</head>
<body>
	<div class="container">
		<div class="hd">
			<img src="../images/loginlogo.png" class="logo">
			<span class="name">图书管理系统</span>
			<div class="userinfo">
				<img src="../images/user.png">
				<span id="uname"></span>
			</div>
			<ul class="setting">
				<li>桌面</li>
				<li>设置</li>
				<li>帮助</li>
				<li class="quit"></li>
			</ul>
		</div>
		<div class="exit">
			<div class="top">
				<h5>提示信息</h5>
				<i></i>
			</div>
			<div class="content">
				<div class="pic">
					
				</div>
				<p>你确定要退出系统？</p>
				<div class="buttons">
					<button class="ok">确定</button>
					<button class="cancel">取消</button>
				</div>
			</div>
		</div>
		<div class="bd">
			<div class="toleft"></div>
			<div class="nav">
				<div class="desc">
					<img src="../images/left_tree.png">
					<span>图书管理系统</span>
				</div>
				<dl class="menus">
					<dt>
						<span class="menus-icon"></span>
						<span class="menus-text">系统管理</span>
					</dt>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;" id="userman">用户信息管理</a>
						</span>
					</dd>
				</dl>
				<dl class="menus">
					<dt>
						<span class="menus-icon"></span>
						<span class="menus-text">图书管理</span>
					</dt>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;" id="bookman">图书信息管理</a>
						</span>
					</dd>
				</dl>
				<dl class="menus">	
					<dt>
						<i class="menus-icon"></i>
						<span class="menus-text">接还管理</span>
					</dt>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;" id="bborrow">借书</a></span>
					</dd>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;" id="breturn">还书</a></span>
					</dd>
				</dl>
				<dl class="menus">	
					<dt>
						<i class="menus-icon"></i>
						<span class="menus-text">分类管理</span>
					</dt>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;" id="catogaryman">分类信息管理</a></span>
					</dd>
				</dl>
				<dl class="menus">	
					<dt>
						<i class="menus-icon"></i>
						<span class="menus-text">系统公告</span>
					</dt>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;"
							 data-id="5">公告管理</a></span>
					</dd>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;"
							 data-id="10">测试菜单项</a></span>
					</dd>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;"
							 data-id="11">测试菜单项</a></span>
					</dd>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;"
							 data-id="12">测试菜单项</a></span>
					</dd>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;"
							 data-id="13">测试菜单项</a></span>
					</dd>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;"
							 data-id="14">测试菜单项</a></span>
					</dd>
					<dd>
						<span class="submenu-icon"></span>
						<span class="submenu-text"><a href="" onclick="return false;"
							 data-id="15">测试菜单项</a></span>
					</dd>
				</dl>	
			</div>
			<div class="main">
				<div class="title">
					
				</div>
				<div class="content">
					<iframe data-id="0" width="100%" height="100%" frameborder="0" src="/BooksManagementSystem/user/index.html" id="leftFrame"></iframe>
				</div>
			</div>
		</div>
	</div>
</body>
</html>