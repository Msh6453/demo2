<%@ page import="com.iotek.model.T_Appeal" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/8
  Time: 14:16
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
</head>
<body>
<%
    T_Appeal ta= (T_Appeal) request.getAttribute("tap");
%>



<div  id="da">
    <div id="d1">
        <h2>复议回复界面</h2>
        <div id="d4">
            &nbsp;&nbsp; <span><a id="a1" href="mananger">管理员界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form  method="post" action="updateAppeal2">
                <table border=":solid 1px "  style="margin:auto;">
                    <tr>
                        <td><label>复议月份</label></td>
                        <td><input type="text" id="n2" disabled="disabled"
                                   value="<%=ta.getApp_month()%>"></td>
                    </tr>
                    <tr>
                        <td><label>复议提交时间</label> </td>
                        <td><input type="text" id="n1"   disabled="disabled"
                                   value="<%=ta.getApp_time()%>">
                        </td>
                    </tr>
                    <tr>
                        <td><label>复议原因</label></td>
                        <td>
                            <textarea id="te1" cols="100" rows="10"  disabled="disabled"
                                      style="width:200px; height:50px" >
                                <%=ta.getApp_reason()%>
                            </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td><label>回复结果</label></td>
                        <td>
                            <textarea id="te2" name="app_result" cols="100" rows="10"
                                      style="width:200px; height:50px" >
                            </textarea>
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="app_id" value="<%=ta.getApp_id()%>">
                <input type="hidden" name="app_state" value="1">
                <input id="n10" disabled="disabled" type="submit" value="提交">
            </form>
        </div>
    </div>
</div>
</body>
</html>

