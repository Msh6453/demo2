<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.T_Resume" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sun.corba.se.spi.ior.IdentifiableFactory" %><%--
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
            text-align: center;
        }
        #d4{
            margin-left: 900px;
        }
        #a1,#a2{
            text-decoration: none;
            color: white;
        }
        #a3,#a4,#a5{
            font-size: 20px;
            text-decoration: none;
            color: black;
        }
        #te1,#te2,#tel3,#tel4{
            resize: none;
        }
        td{
            text-align:center;
        }
        td{
            word-wrap:break-word;
            word-break: break-all;
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

</head>
<body>
<%
    List<T_Resume> tr= (List<T_Resume>) request.getAttribute("tResumes");


%>
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
            <a id="a3" href="getresume?currentPage=1" onmouseenter="check('dd1','dd2')">查看简历</a> &nbsp;&nbsp; &nbsp;&nbsp;
            <a id="a4" onclick="check('dd2','dd1')">添加简历</a>
            &nbsp;&nbsp; &nbsp;&nbsp;<a id="a5" href="state1?currentPage=1">查看面试邀请</a>
            <div id="dd1">
                <table border=":solid 1px "  style="margin:auto;">
                    <tr>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>性别 </th>
                        <th>出生年月</th>
                        <th>专业</th>
                        <th>学历</th>
                        <th>毕业时间</th>
                        <th>爱好</th>
                        <th>电话</th>
                        <th>家庭住址</th>
                        <th>工作经验</th>
                        <th>专业技能</th>
                        <th>修改</th>
                        <th>删除</th>
                    </tr>

                    <%
                        if (tr==null){

                        }else{
                            for (int i = 0; i < tr.size(); i++) {

                    %>
                    <tr>
                        <td><%=tr.get(i).getRe_name()%></td>
                        <td><%=tr.get(i).getRe_age()%></td>
                        <td><%=tr.get(i).getRe_sex()%></td>
                        <td><%=tr.get(i).getRe_birday()%></td>
                        <td><%=tr.get(i).getRe_major()%></td>
                        <td><%=tr.get(i).getRe_edu()%></td>
                        <td><%=tr.get(i).getRe_endtime()%></td>
                        <td><%=tr.get(i).getRe_hobby()%></td>
                        <td><%=tr.get(i).getRe_tel()%></td>
                        <td><%=tr.get(i).getRe_address()%></td>
                        <td >
                            <textarea id="tel4" name="re_experience"  cols="100" rows="10"
                                       style="width:100px; height:50px"><%=tr.get(i).getRe_experience()%>
                            </textarea>
                        </td>
                        <td  style="width: 30px">
                            <textarea id="tel3" name="re_skill" cols="100" rows="10"
                                      style="width:100px; height:50px"><%=tr.get(i).getRe_skill()%></textarea></td>
                        <td><a href="updateresume1?re_id=<%=tr.get(i).getRe_id()%>"><button>修改</button></a></td>
                        <td><a href="deleteresume?re_id=<%=tr.get(i).getRe_id()%>"><button>删除</button></a></td>
                    </tr>
                    <%
                        }
                        }
                    %>
                </table>
                <tr>
                    <td colspan="14">
                        <c:forEach begin="1" end="${requestScope.totalPages}" var="pagesize">
                            <a href="getresume?currentPage=${pagesize}">${pagesize}</a>
                        </c:forEach>
                    </td>
                </tr>

                ${requestScope.noResumes}
            </div>
            <div id="dd2">
                <h3>添加简历</h3>

                <form  method="post" action="saveResume">

                    <table border=":solid 1px "  style="margin:auto;">

                        <tr>
                            <td>
                                <label>姓名</label>
                            </td>
                            <td><input type="text" id="n1" name="re_name"></td>
                        </tr>

                        <tr>
                            <td><label>年龄</label></td>
                            <td><input type="text" id="n2" name="re_age"></td>
                        </tr>

                       <tr>
                            <td><label>性别</label> </td>
                            <td><input type="radio" name="re_sex" checked="checked" value="男">男
                                <input type="radio" name="re_sex"  value="女">女</td>
                        </tr>

                       <tr>
                            <td><label>出生年月</label></td>
                            <td><input id="n3" type="date" name="re_birday"></td>
                        </tr>

                        <tr>
                           <td><label>专业</label></td>
                           <td><input type="text" id="n4" name="re_major"></td>
                       </tr>

                       <tr>
                           <td><label>学历</label></td>
                           <td><input type="text" id="n5" name="re_edu"></td>
                       </tr>
                        <tr>
                            <td><label>毕业时间</label></td>
                            <td><input  id="n6" type="date" name="re_endtime"></td>
                        </tr>

                        <tr>
                            <td><label>爱好</label></td>
                            <td><input type="text" id="n7" name="re_hobby"></td>
                        </tr>

                        <tr>
                             <td><label>电话</label></td>
                             <td><input type="text" id="n8" name="re_tel"></td>
                         </tr>
                        <tr>
                            <td><label>家庭住址</label></td>
                            <td><input type="text" id="n9" name="re_address"></td>
                        </tr>

                        <tr>
                            <td><label>工作经验</label></td>
                            <td><textarea id="te1" name="re_experience"  cols="100" rows="10"
                                          style="width:200px; height:50px"></textarea></td>
                        </tr>

                        <tr>
                            <td><label>专业技能</label></td>
                            <td><textarea id="te2" name="re_skill" cols="100" rows="10"
                                          style="width:200px; height:50px"></textarea></td>
                        </tr>
                    </table>

                        <input id="n10"  type="submit" value="提交">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
