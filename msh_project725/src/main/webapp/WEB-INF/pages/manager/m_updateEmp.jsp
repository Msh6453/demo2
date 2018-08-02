<%@ page import="com.iotek.model.T_Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/2
  Time: 1:12
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
        #te1,#te2,#te3,#tel4{
            resize: none;
        }
    </style>
    <script src="jq-resources/jquery.js"></script>
    <script>
        $(function () {
            $("#n1").blur(function () {
                var p = $("#n1").val();
                var reg = /^[1-9]\d*$/;
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
            $("#n4").blur(function () {
                var p = $("#n4").val();
                var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$ /;
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


    </script>
</head>
<body>
<%
    T_Emp t= (T_Emp) request.getAttribute("tEmp");
%>

<div  id="da">
    <div id="d1">
        <h2>员工信息修改</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="getT_Emp?currentPage=1">返回上一界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form  method="post" action="updateemp2">
                <table border=":solid 1px "  style="margin:auto;">
                    <tr>
                        <td><label>姓名</label></td>
                        <td><input type="text" id="n2" name="e_name"
                                   value="<%=t.getE_name()%>"></td>
                    </tr>
                    <tr>
                        <td><label>年龄</label> </td>
                        <td><input type="text" id="n1" name="e_age"  value="<%=t.getE_age()%>">
                        </td>
                    </tr>

                    <tr>
                        <td><label>性别</label></td>
                        <td><input id="n3" type="text" name="e_sex"
                                   value="<%=t.getE_sex()%>"></td>
                    </tr>

                    <tr>
                        <td><label>电话</label></td>
                        <td><input type="text" id="n4" name="e_tel"
                                   value="<%=t.getE_tel()%>"></td>
                    </tr>

                    <tr>
                        <td><label>家庭住址</label></td>
                        <td>
                            <input type="text" id="n5" name="e_address"
                                   value="<%=t.getE_address()%>">
                        </td>
                    </tr>

                </table>
                <input type="hidden" name="e_id" value="<%=t.getE_id()%>">
                <input id="n10"  type="submit" value="提交">
            </form>
        </div>
    </div>
</div>
</body>
</html>

