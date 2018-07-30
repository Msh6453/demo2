<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/29
  Time: 16:49
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
            text-align: center;
            z-index: 1;

        }
        #d4{
            margin-left: 900px;
        }
        #a1,#a2{
            text-decoration: none;
            color: white;
        }
        #da{
            text-align: center;
        }
        span{
            position: relative;
        }
    </style>
    <script src="jq-resources/jquery.js"></script>
    <script>
        $(function () {
            $("#n1").blur(function () {
                var p = $("#n1").val();
                var reg = /^[1-9]\d*|0$/;
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

<div  id="da">
    <div id="d1">
        <h2>选择简历</h2>
        <div id="d4">
            &nbsp;&nbsp; <span><a id="a1" href="recruit2?currentPage=1">招聘信息</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form method="post" action="saveFeedback2">
                简历id：<input id="n1" name="re_id" >
                <input id="n10" type="submit" value="提交">
            </form>
        </div>
    </div>

</div>
</body>
</html>

