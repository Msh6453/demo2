<%@ page import="com.iotek.model.T_Dept" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/1
  Time: 14:30
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
            width: 100%;
            height: 50px;
            background-color:rgba(0,0,0,0.2);
        }
        #d2{
            margin:0 auto;
            width: 1700px;
            height: 750px;
            text-align: center;
            background-color: cornflowerblue;
        }
        #d3{
            margin:0 auto;
            position: absolute;
            width: 1000px;
            background-color:rgba(0,0,0,0.2);
            margin-top: -600px;
            margin-left: 350px;
            z-index: 1;

        }
        #da{
            text-align: center;
        }
        #d4{
            margin-left: 900px;
        }
        span{
            position: relative;
        }
        #a1,#a2{
            text-decoration: none;
            color: white;
        }
        #a3,#a4{
            font-size: 20px;
            text-decoration: none;
            color: black;
        }
    </style>
    <script src="jq-resources/jquery.js"></script>
    <script>
        $(function () {
            $("#n1").blur(function () {
                var p = $("#n1").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#n10").removeAttr("disabled")
                    $("#n1").css('border','2px solid green');
                } else {
                    $("#n10").attr("disabled", "a")
                    $("#n1").css('border','1px solid red');
                }
            })
        })
    </script>
</head>
<body>
<%
    T_Dept tDept= (T_Dept) request.getAttribute("dept");
%>

<div  id="da">
    <div id="d1">
        <h2>部门修改界面</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="getdept?currentPage=1">返回上一页</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form method="post" action="updateDept2">
                部门名称：<input id="n1" type="text" name="d_name" value="<%=tDept.getD_name()%>">
                <input type="hidden" name="d_id" value="<%=tDept.getD_id()%>"><br/>
                <input id="n10" type="submit" value="提交">
            </form>
        </div>
    </div>
</div>
</body>
</html>


