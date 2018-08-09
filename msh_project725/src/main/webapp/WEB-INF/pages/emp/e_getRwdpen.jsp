<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/7
  Time: 11:35
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
        $(function () {
            $("#n1").blur(function () {
                var p = $("#n1").val();
                var reg = /^[2]\d{3}-(0[1-9]|1[0-2])/;
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
        <h2>奖惩详情</h2>
        <div id="d4">
            &nbsp;&nbsp; <span><a id="a1" href="empjsp">员工主界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form action="getRwdpenByMoth" method="post">
                选择月份：<input type="text" id="n1" name="moth">
                <input type="hidden" value="1"  name="currentPage">
                <input type="submit" id="n10" value="查询"><br/>
                <span>格式：2018-07</span>

            </form>

            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
                    <th>月份</th>
                    <th>日期</th>
                    <th>状态</th>
                    <th>费用</th>
                    <th>原因</th>
                </tr>
                <c:forEach items="${requestScope.tr2}" var="re">
                <tr>
                    <td>${re.rp_id}</td>
                    <td>${re.rp_moth}</td>
                    <td>${re.rp_time}</td>
                    <td>
                        <c:if test="${re.rp_state==0}">
                            ${"惩罚"}
                        </c:if>
                        <c:if test="${re.rp_state==1}">
                            ${"奖励"}
                        </c:if>
                    </td>
                    <td>${re.rp_money}</td>
                    <td>${re.rp_reason}</td>
                <tr>
                </c:forEach>
                    <td colspan="7">
                        <c:forEach begin="1" end="${requestScope.totalPages}" var="pagesize">
                            <a href="e_rwdpen?currentPage=${pagesize}">${pagesize}</a>
                        </c:forEach>
                    </td>
                </tr>
            </table>
            ${requestScope.noredpen1}
            ${requestScope.noredpen}
        </div>
    </div>
</div>
</body>
</html>

