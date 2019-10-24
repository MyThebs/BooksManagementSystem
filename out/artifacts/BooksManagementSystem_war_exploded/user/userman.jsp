<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="pojo.User" %>
<%@ page import="DBUtils.DBUtils" %>
<%@ page import="dao.daoImpl.UserDao" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户信息管理</title>
    <link rel="stylesheet" type="text/css" href="/BooksManagementSystem/css/userman.css">
</head>
<body>
<div class="addstu" tabindex="1">
    <div class="top">
        <h4>增加用戶信息</h4>
        <i></i>
    </div>
    <div class="main">
        <h5>
            <span>用戶信息</span>
        </h5>
        <div class="stuform">
            <form action="${pageContext.request.contextPath }/loginServlet?type=adduser" method="post" id="addform">
                <p>
                    <span>账号：</span>
                    <input type="text" name="uname" id="uname"/>
                </p>
                <p>
                    <span>密码：</span>
                    <input type="password" name="upwd" id="upwd"/>
                </p>
                <p>
                    <span>真实姓名：</span>
                    <input type="text" name="rname" id="rname"/>
                </p>
                <p>
                    <span>邮箱：</span>
                    <input type="text" name="email" id="email"/>
                </p>
                <p>
                    <span>电话：</span>
                    <input type="text" name="mobile" id="mobile"/>
                </p>
                <p>
                    <input type="submit" class="submit" value="增加"/>
                    <input type="reset" class="cancel" value="取消"/>
                </p>
            </form>
        </div>
    </div>
</div>
<div class="updatestu" tabindex="2">
    <div class="top">
        <h4>修改用户信息</h4>
        <i></i>
    </div>
    <div class="main">
        <h5>
            <span>用户信息</span>
        </h5>
        <div class="stuform">
            <form action="" method="post" id="updateform">
                <p>
                    <span>账号：</span>
                    <input type="hidden" name="uid" id="uid">
                    <input type="text" name="uname" id="uuname"/>
                </p>
                <p>
                    <span>密码：</span>
                    <input type="password" name="upwd" id="uupwd"/>
                </p>
                <p>
                    <span>真实姓名：</span>
                    <input type="text" name="rname" id="urname"/>
                </p>
                <p>
                    <span>邮箱：</span>
                    <input type="text" name="email" id="uemail"/>
                </p>
                <p>
                    <span>电话：</span>
                    <input type="text" name="mobile" id="umobile"/>
                </p>
                <p>
                    <input type="submit" class="submit" value="修改"/>
                    <input type="reset" class="cancel" value="取消"/>
                </p>
            </form>
        </div>
    </div>
</div>
<div class="container">
    <div class="bd">
        <div class="toolbar">
            <div class="opt">
					 <span class="optarea">
                        <a href="javascript:void(0);" class="add">
                            <i class="icon"></i>
                            <span class="text">添加</span>
                        </a>
                        <a href="javascript:void(0);" class="delete">
                            <i class="icon"></i>
                            <span class="text">删除</span>
                        </a>                       
                        <a href="javascript:void(0);" class="statistics">
                            <i class="icon"></i>
                            <span class="text">统计</span>
                        </a>
                    </span>
            </div>
        </div>
        <div class="table">
            <table cellpadding="0" cellspacing="0" class="tablebd">
                <thead>
                <tr id="head">
                    <td id="id">
                        <span>ID</span>
                        <a href="javascript:void(0)" id="sort"></a>
                    </td>
                    <td id="uname">
                        <span>账号</span>
                        <a href="javascript:void(0)" id="sort"></a>
                    </td>
                    <td id="upwd">
                        <span>密码</span>
                    </td>
                    <td id="rname">
                        <span>真实姓名</span>
                    </td>
                    <td id="email">
                        <span>邮箱</span>
                    </td>
                    <td id="mobile">
                        <span>电话</span>
                    </td>
                    <td id="oper">
                        <span>操作</span>
                    </td>
                </tr>
                </thead>
                <tbody>

                    <%
						List<User> userList= (List<User>) session.getAttribute("userList");
						for (User user : userList)
						{
							out.print("<tr id=\"data\">");
							out.print("<td><span>");
							out.print(user.getUid());
							out.print("</span></td>");

							out.print("<td><span>");
							out.print(user.getUname());
							out.print("</span></td>");

							out.print("<td><span>");
							out.print(user.getUpwd());
							out.print("</span></td>");

							out.print("<td><span>");
							out.print(user.getRname());
							out.print("</span></td>");

							out.print("<td><span>");
							out.print(user.getEmail());
							out.print("</span></td>");

							out.print("<td><span>");
							out.print(user.getMobile());
							out.print("</span></td>");
							out.print("</tr>");
						}
					%>
                </tbody>
            </table>
        </div>
    </div>
    <div id="page" class="page_div">
        <a href="/BooksManagementSystem/Login?type=showusers&currentPage=1" id="firstpage">首页</a>
        <a href="/BooksManagementSystem/Login?type=showusers&currentPage=${currentPage-1 }" id="prevpage">上一页</a>
        <span>${currentPage }/${pages }</span>
        <a href="/BooksManagementSystem/Login?type=showusers&currentPage=${currentPage+1 }" id="nextpage">下一页</a>
        <a href="/BooksManagementSystem/Login?type=showusers&currentPage=${pages }" id="lastpage">末页</a>
    </div>
</div>
<script type="text/javascript">
    var addbtn = document.querySelector(".toolbar .add");
    var adduserdlg = document.querySelector(".addstu");
    var exitpic = document.querySelector(".top i");
    addbtn.addEventListener("click", function () {
        adduserdlg.style.display = "block";
    });
    exitpic.addEventListener("click", function () {
        adduserdlg.style.display = "none";
    });

    var info = "${param.info}";
    if (info != '') {
        alert(info);
    }

    //更新用户信息对话框
    var tablebd = document.querySelector(".tablebd tbody");
    var atags = tablebd.getElementsByTagName("a");
    var updatedlg = document.querySelector(".updatestu");
    var uidctrl = document.querySelector("#updateform #uid");
    for (var i = 0; i < atags.length; i++) {
        if (atags[i].getAttribute("id") == "update") {
            atags[i].addEventListener("click", function () {
                updatedlg.style.display = "block";
                var id = this.getAttribute("uid");
                uidctrl.value = id;
            });
        }
    }
    var exitpic = updatedlg.querySelector(".top i");
    exitpic.addEventListener("click", function () {
        updatedlg.style.display = "none";
    });
</script>
</body>
</html>