<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/2
  Time: 13:20
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
        #a3,#a4,#a5,#a6{
            font-size: 20px;
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>

<div  id="da">
    <div id="d1">
        <h2>培训管理界面</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="mananger">管理员界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <a id="a3" href="getT_Train?currentPage=1" >查看培训</a> &nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a4" href="saveTrain?" >添加培训</a>&nbsp;&nbsp; &nbsp;&nbsp;<br/>
            ${requestScope.noemp}
            ${requestScope.notrains}
        </div>
    </div>
</div>
</body>
</html>
