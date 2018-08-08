<%@ page import="com.iotek.model.T_Salary" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/8
  Time: 1:00
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
            width: 1100px;
            background-color:rgba(0,0,0,0.2);
            margin-top: -600px;
            margin-left: 300px;
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
        td{
            text-align: center;
        }
        #te1,#te2,#tel3,#tel4{
            resize: none;
        }
    </style>
    <script src="jq-resources/jquery.js"></script>
    <script>

    </script>
</head>
<body>
<%
    T_Salary ts1= (T_Salary) request.getAttribute("ts2");
%>



<div  id="da">
    <div id="d1">
        <h2>薪资详情</h2>
        <div id="d4">
            &nbsp;&nbsp; <span><a id="a1" href="empjsp">员工主界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
                    <th>月份</th>
                    <th>基本薪资</th>
                    <th>奖惩金额</th>
                    <th>社保费用</th>
                    <th>绩效奖金</th>
                    <th>实发工资</th>

                </tr>

                <tr>
                    <td><%=ts1.getSa_id()%></td>
                    <td><%=ts1.getSa_month()%></td>
                    <td><%=ts1.getSa_salary()%></td>
                    <td><%=ts1.getSa_rpcost()%></td>
                    <td><%=ts1.getSa_sscost()%></td>
                    <td><%=ts1.getSa_bonus()%></td>
                    <td><%=ts1.getSa_allsalary()%></td>

                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>


