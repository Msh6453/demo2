<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26
  Time: 13:22
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
    <script>
        function check(d0,d1) {
            var dd=document.getElementById(d0);
            var d1=document.getElementById(d1);
            if(dd.style.display=="block"){
                dd.style.display="none";
            }else{
                d1.style.display="none";
                dd.style.display="block"
            }
        }
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
            margin-top: -680px;
            margin-left: 350px;
            z-index: 1;

        }
        #da{
            text-align: center;
        }
        span{
            position: relative;
        }
        #dd1,#dd2{
            display: none;
        }
        #d4{
            margin-left: 900px;
        }
        #a1,#a2{
            text-decoration: none;
            color: white;
        }
        #a3,#a4{
            font-size: 20px;
        }
        #te1,#te2{
            resize: none;
        }
        td{
            text-align:center;
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
                    $("#n1").css('border','1px solid green');
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
                    $("#n2").css('border','1px solid green');
                    $("#n10").removeAttr("disabled")
                } else {
                    $("#n2").css('border','1px solid red');
                    $("#n10").attr("disabled", "a")
                }
            })
        })

    </script>

</head>
<body>
<div  id="da">
    <div id="d1">
        <h2>个人中心</h2>
        <div id="d4">
        &nbsp;&nbsp; <span><a id="a1" href="recruit2?currentPage=1">招聘信息</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <a id="a3" onclick="check('dd1','dd2')">查看简历</a> &nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a4" onclick="check('dd2','dd1')">添加简历</a>
            <div id="dd1">sdadada</div>
            <div id="dd2">
                <h3>添加简历</h3>
                <form method="post" action="saveresume">
                    <table border=":solid 1px "  style="margin:auto;">
                        <tr>
                            <td>姓名 </td>
                            <td><input id="n1" name="re_name"></td>
                        </tr>
                        <tr>
                            <td>年龄 </td>
                            <td><input id="n2" name="re_age"></td>
                        </tr>
                        <tr>
                            <td>性别 </td>
                            <td><input type="radio" name="re_sex" checked="checked" value="男">男
                                <input type="radio" name="re_sex"  value="女">女</td>
                        </tr>
                        <tr>
                            <td>出生年月</td>
                            <td><input id="n3" type="date" name="re_birday"></td>
                        </tr>
                        <tr>
                            <td>专业</td>
                            <td><input id="n4" name="re_major"></td>
                        </tr>
                        <tr>
                            <td>学历</td>
                            <td><input id="n5" name="re_edu"></td>
                        </tr>
                        <tr>
                            <td>毕业时间</td>
                            <td><input id="n6" type="date" name="re_endtime"></td>
                        </tr>
                        <tr>
                            <td>爱好</td>
                            <td><input id="n7" name="re_hobby"></td>
                        </tr>
                        <tr>
                            <td>电话</td>
                            <td><input id="n8" name="re_tel"></td>
                        </tr>
                        <tr>
                            <td>家庭住址</td>
                            <td><input id="n9" name="re_address"></td>
                        </tr>
                        <tr>
                            <td>工作经验</td>
                            <td><textarea id="te1" name="re_experience"  cols="100" rows="10"
                                          style="width:200px; height:50px"></textarea></td>
                        </tr>
                        <tr>
                            <td>专业技能</td>
                            <td><textarea id="te2" name="re_skill" cols="100" rows="10"
                                          style="width:200px; height:50px"></textarea></td>
                        </tr>
                    </table>
                        <input id="n10" type="submit" value="提交">
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
