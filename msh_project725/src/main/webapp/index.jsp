<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/25
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <style>
        #d1{
            background-color: lightblue;
            width:100%;
            text-align: center;
        }
        #a1{
            color: white;
            text-decoration: none;
            margin-right: 700px;
        }
        #a2,#a3,#d4{
            color: white;
            text-decoration: none;

        }
        #d2{
            text-align: center;
           background-color: skyblue;
        }
        #d3{
            position:absolute;
            left: 500px;
            top: 400px;
            width: 300px;
            height: 200px;
            text-align: center;
            background-color:rgba(0,0,0,0.2);
        }
    </style>
</head>
<body>
<div id="d1">
    <a id="a1" href="recruit?currentPage=1">首页</a><a id="a2" href="empxx">员工登录</a>&nbsp;&nbsp;||&nbsp;&nbsp;
    <a id="a3" href="managerLongin">管理员登录</a>
</div><br/>

<div id="d2">
    <img src="img/01.jpg">
    <div id="d3">
        <form method="post" action="login">
            <p>游客登录界面</p>
            用户名：<input type="text" name="t_name"><br/><br/>
            &nbsp;&nbsp;密码：<input type="password" name="t_password"><br/><br/>
            &nbsp;&nbsp;<input type="submit" value="登录"> &nbsp;&nbsp;  &nbsp;&nbsp;
            <a id="d4" href="register.jsp"><input type="button" value="注册"></a><br/>
            ${requestScope.tt}
            ${requestScope.ts}
        </form>
    </div>
</div>
</body>
</html>