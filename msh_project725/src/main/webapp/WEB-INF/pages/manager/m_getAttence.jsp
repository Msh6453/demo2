<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/7
  Time: 10:10
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
</head>
<body>

<div  id="da">
    <div id="d1">
        <h2>考勤详情</h2>
        <div id="d4">
            &nbsp;&nbsp; <span><a id="a1" href="mananger">管理员界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
                    <th>员工ID</th>
                    <th>月份</th>
                    <th>日期</th>
                    <th>上班打卡时间</th>
                    <th>下班打卡时间</th>
                    <th>考勤状态</th>
                    <th>考勤情况</th>

                </tr>
                <c:forEach items="${requestScope.tat}" var="re">
                    <tr>
                        <td>${re.a_id}</td>
                        <td>${re.e_id}</td>
                        <td>${re.a_moth}</td>
                        <td>${re.a_today}</td>
                        <td>${re.a_begintime}</td>
                        <td>${re.a_endtime}</td>
                        <td>
                            <c:if test="${re.a_state==0}">
                                ${"上班卡正常"}
                            </c:if>
                            <c:if test="${re.a_state==1}">
                                ${"上班迟到"}
                            </c:if>
                            <c:if test="${re.a_state==2}">
                                ${"早上旷工"}
                            </c:if>
                            <c:if test="${re.a_state==3}">
                                ${"正常上班卡，下班早退"}
                            </c:if>
                            <c:if test="${re.a_state==4}">
                                ${"正常上班卡，下班旷工"}
                            </c:if>
                            <c:if test="${re.a_state==5}">
                                ${"正常上班卡，下午加班"}
                            </c:if>
                            <c:if test="${re.a_state==6}">
                                ${"迟到上班卡，下班卡早退"}
                            </c:if>
                            <c:if test="${re.a_state==7}">
                                ${"迟到上班卡，下班卡旷工"}
                            </c:if>
                            <c:if test="${re.a_state==8}">
                                ${"迟到上班卡，下班卡加班"}
                            </c:if>
                            <c:if test="${re.a_state==9}">
                                ${"迟到上班卡，下班卡正常"}
                            </c:if>
                            <c:if test="${re.a_state==10}">
                                ${"正常上班卡，下班卡正常"}
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${re.a_statex==0}">
                                ${"没打下班卡"}
                            </c:if>
                            <c:if test="${re.a_statex==1}">
                                ${"考勤正常"}
                            </c:if>
                        </td>

                </c:forEach>
                <tr>
                    <td colspan="7">
                        <c:forEach begin="1" end="${requestScope.totalPages}" var="pagesize">
                            <a href="e_attence?currentPage=${pagesize}">${pagesize}</a>
                        </c:forEach>
                    </td>
                </tr>
            </table>
            ${requestScope.notAttence}
        </div>
    </div>
</div>
</body>
</html>


