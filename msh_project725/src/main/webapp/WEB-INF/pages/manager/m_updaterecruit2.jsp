<%@ page import="com.iotek.model.T_Recruit" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/30
  Time: 15:15
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
                var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$ /;
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
            $("#te1").blur(function () {
                var p = $("#te1").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#te1").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#te1").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

        $(function () {
            $("#te2").blur(function () {
                var p = $("#te2").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#te2").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#te2").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })
        $(function () {
            $("#te3").blur(function () {
                var p = $("#te3").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#te3").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#te3").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })
    </script>
</head>
<body>
<%
    T_Recruit tR= (T_Recruit) request.getAttribute("updaterecruit1");
%>

<div  id="da">
    <div id="d1">
        <h2>招聘信息修改</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="mananger">管理员界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form  method="post" action="updaterecruit2">
                <table border=":solid 1px "  style="margin:auto;">
                    <tr>
                        <td><label>薪资</label></td>
                        <td><input type="text" id="n2" name="r_pay"
                                   value="<%=tR.getR_pay()%>"></td>
                    </tr>
                    <tr>
                        <td><label>工作地址</label> </td>
                        <td><input type="text" id="n1" name="r_address"  value="<%=tR.getR_address()%>">
                        </td>
                    </tr>

                    <tr>
                        <td><label>电话号码</label></td>
                        <td><input id="n3" type="text" name="r_tel"
                                   value="<%=tR.getR_tel()%>"></td>
                    </tr>

                    <tr>
                        <td><label>邮箱</label></td>
                        <td><input type="text" id="n4" name="r_email"
                                   value="<%=tR.getR_email()%>"></td>
                    </tr>

                    <tr>
                        <td><label>工作经验</label></td>
                        <td>
                            <textarea id="te1" name="r_experience" cols="100" rows="10"
                                      style="width:200px; height:50px" >
                                <%=tR.getR_experience()%>
                            </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td><label>岗位需求</label></td>
                        <td>
                            <textarea id="te2" name="r_required" cols="100" rows="10"
                                      style="width:200px; height:50px" >
                              <%=tR.getR_required()%>
                            </textarea>
                        </td>
                    </tr>

                    <tr>
                        <td><label>公司福利</label></td>
                        <td>
                            <textarea id="te3" name="r_required" cols="100" rows="10"
                                      style="width:200px; height:50px" >
                              <%=tR.getR_describer()%>
                            </textarea>
                        </td>
                    </tr>

                </table>
                <input type="hidden" name="r_id" value="<%=tR.getR_id()%>">
                <input id="n10"  type="submit" value="提交">
            </form>
        </div>
    </div>
</div>
</body>
</html>

