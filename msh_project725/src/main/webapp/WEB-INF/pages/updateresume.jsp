<%@ page import="com.iotek.model.T_Resume" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26
  Time: 13:51
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
            $("#n6").blur(function () {
                var p = $("#n6").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#n6").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#n6").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

        $(function () {
            $("#n7").blur(function () {
                var p = $("#n7").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#n7").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#n7").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

        $(function () {
            $("#n8").blur(function () {
                var p = $("#n8").val();
                var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
                if (reg.test(p)) {
                    $("#n8").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#n8").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

        $(function () {
            $("#n9").blur(function () {
                var p = $("#n9").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#n9").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#n9").css('border','1px solid red');
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
    </script>
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
        span{
            position: relative;
        }
    </style>
</head>
<body>
<%
    T_Resume tResume= (T_Resume) request.getAttribute("getRe");
%>
<div  id="da">
    <div id="d1">
        <h2>修改</h2>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form  method="post" action="updateresume2">
                <table border=":solid 1px "  style="margin:auto;">
                    <tr>
                        <td>
                            <label>姓名</label>
                        </td>
                        <td><input type="text" id="n1" name="re_name"
                        value="<%=tResume.getRe_name()%>"></td>
                    </tr>

                    <tr>
                        <td><label>年龄</label></td>
                        <td><input type="text" id="n2" name="re_age"
                                   value="<%=tResume.getRe_age()%>"></td>
                    </tr>

                    <tr>
                        <td><label>性别</label> </td>
                        <td><input type="radio" name="re_sex" checked="checked" value="男">男
                            <input type="radio" name="re_sex"  value="女">女</td>
                    </tr>

                    <tr>
                        <td><label>出生年月</label></td>
                        <td><input id="n3" type="date" name="re_birday"
                                   value="<%=tResume.getRe_birday()%>"></td>
                    </tr>

                    <tr>
                        <td><label>专业</label></td>
                        <td><input type="text" id="n4" name="re_major"
                                   value="<%=tResume.getRe_major()%>"></td>
                    </tr>

                    <tr>
                        <td><label>学历</label></td>
                        <td><input type="text" id="n5" name="re_edu"
                                   value="<%=tResume.getRe_edu()%>"></td>
                    </tr>
                    <tr>
                        <td><label>毕业时间</label></td>
                        <td><input  id="n6" type="date" name="re_endtime"
                                    value="<%=tResume.getRe_endtime()%>"></td>
                    </tr>

                    <tr>
                        <td><label>爱好</label></td>
                        <td><input type="text" id="n7" name="re_hobby"
                                   value="<%=tResume.getRe_hobby()%>"></td>
                    </tr>

                    <tr>
                        <td><label>电话</label></td>
                        <td><input type="text" id="n8" name="re_tel"
                                   value="<%=tResume.getRe_tel()%>"></td>
                    </tr>
                    <tr>
                        <td><label>家庭住址</label></td>
                        <td><input type="text" id="n9" name="re_address"
                                   value="<%=tResume.getRe_address()%>"></td>
                    </tr>

                    <tr>
                        <td><label>工作经验</label></td>
                        <td><textarea id="te1" name="re_experience"  cols="100" rows="10"
                                      style="width:200px; height:50px" ><%=tResume.getRe_experience()%></textarea></td>
                    </tr>

                    <tr>
                        <td><label>专业技能</label></td>
                        <td><textarea id="te2" name="re_skill" cols="100" rows="10"
                                      style="width:200px; height:50px" ><%=tResume.getRe_skill()%></textarea></td>
                    </tr>
                </table>
                <input type="hidden" name="re_id" value="<%=tResume.getRe_id()%>">
                <input id="n10"  type="submit" value="提交">
            </form>
        </div>
    </div>

</div>
</body>
</html>

