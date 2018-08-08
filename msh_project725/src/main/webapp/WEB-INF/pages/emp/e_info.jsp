<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.T_Emp" %>
<%@ page import="com.iotek.service.T_DeptService" %>
<%@ page import="com.iotek.model.T_Position" %>
<%@ page import="com.iotek.service.T_PositionService" %>
<%@ page import="com.iotek.model.T_Dept" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/7
  Time: 1:01
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
        td{
            text-align: center;
        }
    </style>
</head>
<body>
<%
    T_Emp te= (T_Emp) request.getAttribute("temp");
    T_DeptService tds= (T_DeptService) request.getAttribute("tds");
    T_PositionService tps= (T_PositionService) request.getAttribute("tps");

%>
<div  id="da">
    <div id="d1">
        <h2>个人信息界面</h2>
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
                    <th>账号</th>
                    <th>密码</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>入职时间</th>
                    <th>所在部门</th>
                    <th>所在职位</th>
                    <th>状态</th>
                    <th>电话</th>
                    <th>地址</th>
                </tr>


                <tr>
                    <td><%=te.getE_id()%></td>
                    <td><%=te.getE_num()%></td>
                    <td><%=te.getE_password()%></td>
                    <td><%=te.getE_name()%></td>
                    <td><%=te.getE_age()%></td>
                    <td><%=te.getE_sex()%></td>
                    <td><%=te.getE_btime()%></td>
                    <td><%
                        T_Dept t1=new T_Dept();
                        t1.setD_id(te.getD_id());
                        T_Dept t2=tds.getT_DeptByid(t1);
                        out.print(t2.getD_name());
                    %></td>
                    <td><%
                        T_Position tP=new T_Position();
                        tP.setP_id(te.getP_id());
                        T_Position tpp=tps.get_PostionByid(tP);
                        out.print(tpp.getP_name());
                    %></td>


                    <td><%
                        if (te.getE_state()==0){
                            out.print("试用期员工");
                        }else{
                            out.print("正式工");
                        }
                    %></td>
                    <td><%=te.getE_tel()%></td>
                    <td><%=te.getE_address()%></td>
                </tr>

                <tr>
                    <td colspan="12">
                        <a href="updateemp?e_id=<%=te.getE_id()%>"><button >修改基本信息</button></a>
                    </td>
                </tr>

            </table>

        </div>
    </div>
</div>
</body>
</html>

