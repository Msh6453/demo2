<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/25
  Time: 14:56
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
            height: 220px;
            text-align: center;
            background-color:rgba(0,0,0,0.2);
        }
    </style>
    <script src="jq-resources/jquery.js"></script>
    <script>
        $(function () {
            $("#n1").blur(function () {
                var p = $("#n1").val();
                var reg = /\S/;
                if (reg.test(p)&&p.length>3) {
                    /*   $("#s1").css("color", "green");*/
                    $("#n3").removeAttr("disabled")
                    $("#s1").css("color", "green");
                } else {
                    /*    $("#s1").css("color", "red");*/
                    $("#n3").attr("disabled", "a")
                    $("#s1").css("color", "red");
                }
            })
        })
        $(function () {
            $("#n2").blur(function () {
                var p = $("#n2").val();
                var reg = /\S/;

                if (reg.test(p)&&p.length>5) {
                       $("#s2").css("color", "green");
                    $("#n3").removeAttr("disabled")
                } else {
                        $("#s2").css("color", "red");
                    $("#n3").attr("disabled", "a")

                }
            })
        })

    </script>

</head>
<body>
<div id="d1">
    <a id="a1" href="">首页</a><a id="a2" href="">员工登录</a>&nbsp;&nbsp;||&nbsp;&nbsp;<a id="a3" href="">管理员登录</a>
</div><br/>

<div id="d2">
    <img src="img/01.jpg">
    <div id="d3">
        <form method="post" action="res">
            <p>注册界面</p>

            用户名：<input id="n1" type="text" name="t_name"><br/>
            <span id="s1">* 提示:【必填字段，不能少于3位】</span><br/>
            &nbsp;&nbsp;密码：<input id="n2" type="password" name="t_password"><br/>
            <span id="s2">* 提示:【必填字段，不能少于6位】</span><br/>
            &nbsp;&nbsp;<input id="n3" type="submit" value="提交">   &nbsp;&nbsp;
            <a id="d4" href="index.jsp"><input type="button" value="返回登录"></a>
        </form>
        ${requestScope.re}
        ${requestScope.re1}
    </div>
</div>
</body>
</html>

