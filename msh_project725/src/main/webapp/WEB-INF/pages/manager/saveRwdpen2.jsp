<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/8
  Time: 16:14
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
            $("#8").blur(function () {
                var p = $("#8").val();
                var reg = /^[1-9]\d*$/;
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


<div  id="da">
    <div id="d1">
        <h2>奖惩新增</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="mananger">管理员界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form  method="post" action="saveRwdpen2">
                <table border=":solid 1px "  style="margin:auto;">
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
                        <td><label>奖励/惩罚</label></td>
                        <td><input type="radio" name="rp_state" checked="checked" value="1">奖励
                            <input type="radio" name="rp_state"  value="0">惩罚</td>
                    </tr>
                    <tr>
                        <td><label>金钱</label></td>
                        <td><input type="text" id="n9"   name="rp_money" ></td>
                    </tr>
                    <tr>
                        <td><label>原因</label></td>
                        <td>  <textarea id="te2" id="n8"   name="rp_reason" cols="100" rows="10"
                                        style="width:200px; height:50px" >
                            </textarea>
                        </td>
                    </tr>
                </table>
                <input id="n10"  type="submit" value="提交">
            </form>
            ${requestScope.noid}
        </div>
    </div>
</div>
</body>
</html>



