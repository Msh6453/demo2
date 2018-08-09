<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/1
  Time: 20:10
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
        $(function () {
            $("#n2").blur(function () {
                var p = $("#n2").val();
                var reg = /^[1-9]\d*$/;
                if (reg.test(p)) {
                    $("#n10").removeAttr("disabled")
                    $("#n2").css('border','2px solid green');
                } else {
                    $("#n10").attr("disabled", "a")
                    $("#n2").css('border','1px solid red');
                }
            })
        })
    </script>
</head>
<body>


<div  id="da">
    <div id="d1">
        <h2>职位添加界面</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="m_deptAndposition">部门/职位</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form method="post" action="savePos2">
                <table border=":solid 1px "  style="margin:auto;">
                    <tr>
                        <td>部门</td>
                        <td> <select id="dept" name="d_id">
                            <%--<option>请选择部门</option>--%>
                            <c:forEach items="${requestScope.tD}" var="d">
                                <option   value="${d.d_id}" id="dept1">${d.d_name}</option>
                            </c:forEach>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td>职位名称：</td>
                        <td><input id="n1" type="text" name="p_name"></td>
                    </tr>
                    <tr>
                        <td>基本薪资：</td>
                        <td> <input id="n2" type="text" value="0" name="p_pay"></td>
                    </tr>

                </table>
                <input id="n10" type="submit" disabled="disabled" value="提交">
            </form>

            ${requestScope.nod_id}
            ${requestScope.yespos}
            ${requestScope.nopay}
            ${requestScope.noname}
        </div>
    </div>
</div>
</body>
</html>

