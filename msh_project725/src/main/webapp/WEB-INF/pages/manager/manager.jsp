<%@ page import="com.iotek.model.T_Manager" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/30
  Time: 10:22
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
        #a3,#a4,#a5,#a6,#a7,#a8,#a9{
            font-size: 20px;
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<%
    T_Manager tm= (T_Manager) request.getAttribute("t_manager1");
%>
<div  id="da">
    <div id="d1">
        <h2>管理员界面</h2>
        <div id="d4"><span><%
            if (tm!=null){
                out.print("管理员"+tm.getM_name());
            }
        %>
        </span>&nbsp;&nbsp; <span><a id="a1" href="#">个人中心</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <a id="a3" href="m_feedback" >应聘中心</a> &nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a4" href="m_recruit" >招聘中心</a> &nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a5" href="m_emp" >员工管理</a>&nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a6" href="m_deptAndposition" >部门/职位</a>&nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a7" href="m_train" >培训中心</a>&nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a8" href="m_salary" >薪资管理</a>&nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a9" href="m_rwdpen" >奖惩管理</a>&nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a9" href="m_attence?currentPage=1" >查看考勤</a>&nbsp;&nbsp; &nbsp;&nbsp;
            <br/>
            ${requestScope.nostate6}
        </div>
    </div>
</div>
</body>
</html>
