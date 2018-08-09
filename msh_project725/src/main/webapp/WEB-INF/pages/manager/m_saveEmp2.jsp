<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.T_Resume" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31
  Time: 15:56
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
        #n1,#n2,#n3,#n4,#n5,#n8,#n9{

        }
    </style>
    <script src="jq-resources/jquery.js"></script>
    <script>
        $(function () {
            $("#n1").blur(function () {
                var p = $("#n1").val();
                var reg = /^\d{3,20}$/;
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
            $("#pos").blur(function () {
                var p = $("#pos").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#n10").removeAttr("disabled")
                    $("#pos").css('border','2px solid green');
                } else {
                    $("#n10").attr("disabled", "a")
                    $("#pos").css('border','1px solid red');
                }
            })
        })


        $(function () {
            $("#n2").blur(function () {
                var p = $("#n2").val();
                var reg = /^\d{3,20}$/;
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
                var reg = /^[1-9]\d*$/;
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
                var reg = /^[\u4e00-\u9fa5]{1,2}$/;
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
            $("#5").blur(function () {
                var p = $("#5").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#5").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#5").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

        $(function () {
            $("#8").blur(function () {
                var p = $("#8").val();
                var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
                if (reg.test(p)) {
                    $("#8").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#8").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })
        $(function () {
            $("#9").blur(function () {
                var p = $("#9").val();
                var reg = /\S/;
                if (reg.test(p)) {
                    $("#9").css('border','2px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#9").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

        $(function(){
            $("#dept").click(function(){
                var a=$("#dept").val();
                $.ajax({
                    url:"getPosition",
                    data:"d_id="+a,
                    type:"post",
                    success:function (obj) {
                        $("#pos option").remove();
                        $.each(obj,function (i,item) {
                            var b=item.p_id;
                       $("#pos").append(
                           "<option  value="+b+">"+item.p_name+"</option>"

                            )
                        })
                    }
                })
            })
        })

    </script>
</head>
<body>
<%
    T_Resume te= (T_Resume) request.getAttribute("tRsume1");
%>

<div  id="da">
    <div id="d1">
        <h2>员工新增</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="m_emp">员工管理界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form  method="post" action="saveemp3">
                <table border=":solid 1px "  style="margin:auto;">
                    <tr>
                        <td>
                            <label>账号</label>
                        </td>
                        <td><input type="text"  id="n1" name="e_num" value="<%=te.getRe_tel()%>"></td>
                    </tr>

                    <tr>
                        <td><label>密码</label></td>
                        <td><input type="text"   id="n2" name="e_password" value="123"></td>
                    </tr>

                    <tr>
                        <td><label>姓名</label> </td>
                        <td><input type="text"  id="n5" name="e_name" value="<%=te.getRe_name()%>">
                        </td>
                    </tr>

                    <tr>
                        <td><label>年龄</label></td>
                        <td><input id="n3" type="text"   name="e_age" value="<%=te.getRe_age()%>"></td>
                    </tr>

                    <tr>
                        <td><label>性别</label></td>
                        <td><input type="text" id="n4"  name="e_sex"  value="<%=te.getRe_sex()%>"></td>
                    </tr>

                    <tr>
                        <td><label>部门/职位</label></td>
                        <td>
                            <select id="dept" name="d_id">
                                <option>请选择部门</option>
                                <c:forEach items="${requestScope.tDepts}" var="d">
                                    <option   value="${d.d_id}" id="dept1">${d.d_name}</option>
                                </c:forEach>
                            </select>

                            <select id="pos" name="p_id">
                            </select>
                        </td>
                    </tr>


                    <tr>
                        <td><label>电话</label></td>
                        <td><input type="text" id="n8"   name="e_tel" value="<%=te.getRe_tel()%>"></td>
                    </tr>
                    <tr>
                        <td><label>家庭住址</label></td>
                        <td><input type="text" id="n9"   name="e_address" value="<%=te.getRe_address()%>"></td>
                    </tr>

                </table>

                <input id="n10" disabled="disabled" type="submit" value="提交">
            </form>
        </div>
    </div>
</div>
</body>
</html>


