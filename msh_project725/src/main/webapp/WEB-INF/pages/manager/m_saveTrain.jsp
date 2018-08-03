<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/2
  Time: 15:37
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
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#n2").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#n2").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

        $(function () {
            $("#n3").blur(function () {
                var p = $("#n3").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#n3").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#n3").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

        $(function () {
            $("#n4").blur(function () {
                var p = $("#n4").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#n4").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#n4").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

        $(function () {
            $("#n5").blur(function () {
                var p = $("#n5").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#n5").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#n5").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

        $(function () {
            $("#dept").blur(function () {
                var p = $("#dept").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#dept").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#dept").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })
    </script>
</head>
<body>

<div  id="da">
    <div id="d1">
        <h2>添加培训信息</h2>
        <div id="d4">
            &nbsp;&nbsp; <span><a id="a1" href="m_train">培训中心</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form  method="post" action="save2_Train">
                <table border=":solid 1px "  style="margin:auto;">
                    <tr>
                        <td><label>培训对象</label></td>
                        <td>
                            <select id="dept" name="tra_obj" >
                                <option>请选择</option>
                                <option value="0">试用期员工</option>
                                <c:forEach items="${requestScope.tDepts}" var="d">
                                    <option   value="${d.d_id}" id="dept1">${d.d_name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>主题</label></td>
                        <td><input type="text" id="n2" name="tra_theme">
                        </td>
                    </tr>
                    <tr>
                        <td><label>内容</label> </td>
                        <td><input type="text" id="n1" name="tra_content">
                        </td>
                    </tr>

                    <tr>
                        <td><label>开始时间</label></td>
                        <td><input type="date"  id="n3" name="tra_begintime">
                        </td>
                    </tr>

                    <tr>
                        <td><label>结束时间</label></td>
                        <td><input type="date" id="n4" name="tra_endtime">
                        </td>
                    </tr>

                    <tr>
                        <td><label>培训地址</label></td>
                        <td><input type="text" id="n5" name="tra_address">
                        </td>
                    </tr>
                </table>
                <input id="n10"  type="submit" value="提交">
            </form>
        </div>
    </div>
</div>
</body>
</html>

