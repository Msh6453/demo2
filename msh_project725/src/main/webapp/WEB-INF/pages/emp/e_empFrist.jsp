<%@ page import="com.iotek.model.T_Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/3
  Time: 15:16
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
        #a3,#a4,#a5,#a6,#a7,#a8{
            font-size: 20px;
            text-decoration: none;
            color: black;
        }

    </style>
</head>
<body >
<%
    T_Emp te= (T_Emp) session.getAttribute("success");
%>
<div  id="da">
    <div id="d1">
        <h2>员工界面</h2>

        <div id="d4"><span><%
            if (te!=null){
                out.print("员工:"+te.getE_name());
            }
        %>
        </span>&nbsp;&nbsp; <span><a id="a1" href="#">个人中心</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span><br/><br/>

            &nbsp;&nbsp;<span><a id="a11" href="saveAttence1"><button>上班打卡</button></a></span>
            &nbsp;&nbsp;<span><a id="a22" href="updateAttenceEndtime"><button>下班打卡</button></a></span><br/>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <a id="a6" href="e_info?eid=<%=te.getE_id()%>" >个人信息</a>&nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a7" href="e_attence?currentPage=1" >个人考勤</a> &nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a3" href="e_rwdpen?currentPage=1" >个人奖惩</a> &nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a4" href="e_salary" >个人薪资</a>&nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a5" href="e_train?currentPage=1" >培训信息</a>&nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a8" href="e_appeal?currentPage=1" >查看复议结果</a>&nbsp;&nbsp; &nbsp;&nbsp;
            <br/>
            ${requestScope.state0}
            ${requestScope.state1}
            ${requestScope.state2}
            ${requestScope.tatt}
            ${requestScope .nobegintime}
            ${requestScope.success1}
            ${requestScope.x1}
            ${requestScope.y1}
            ${requestScope.norwpen}
            ${requestScope.notTrain}
            ${requestScope.notAppeal}
        </div>
    </div>
</div>
</body>
</html>

