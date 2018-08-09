<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.T_Resume" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/29
  Time: 16:49
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
            text-align: center;
            z-index: 1;

        }
        #d4{
            margin-left: 900px;
        }
        #a1,#a2{
            text-decoration: none;
            color: white;
        }
        #da{
            text-align: center;
        }
        span{
            position: relative;
        }
        #te1,#te2,#tel3,#tel4{
            resize: none;
        }
        td{
            text-align: center;
        }
    </style>
    <script src="jq-resources/jquery.js"></script>
    <script>
        $(function () {
            $("#n1").blur(function () {
                var p = $("#n1").val();
                var reg = /^[1-9]\d*|0$/;
                if (reg.test(p)) {
                    $("#n10").removeAttr("disabled")
                    $("#n1").css('border','2px solid green');
                } else {
                    $("#n10").attr("disabled", "a")
                    $("#n1").css('border','1px solid red');
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
        <h2>选择简历</h2>
        <div id="d4">
            &nbsp;&nbsp; <span><a id="a1" href="recruit2?currentPage=1">招聘信息</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form method="post" action="saveFeedback2">
                简历id：<input id="n1" name="re_id" >
                <input id="n10" type="submit" value="提交">
            </form>
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
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

                </tr>

                <%
                    if (tr==null){

                    }else{
                        for (int i = 0; i < tr.size(); i++) {

                %>
                <tr>
                    <td><%=tr.get(i).getRe_id()%></td>
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
                                      style="width:100px; height:50px"><%=tr.get(i).getRe_skill()%>
                            </textarea>
                      </tr>
                <%
                        }
                    }
                %>

                <tr>
                    <td colspan="13">
                        <c:forEach begin="1" end="${requestScope.totalPages}" var="pagesize">
                            <a href="getresume1?currentPage=${pagesize}">${pagesize}</a>
                        </c:forEach>
                    </td>
                </tr>

            </table>

        </div>
    </div>

</div>
</body>
</html>

