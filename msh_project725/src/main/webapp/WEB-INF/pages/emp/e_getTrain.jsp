<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.T_Emp_Train" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.service.T_TrainService" %>
<%@ page import="com.iotek.model.T_Train" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/8
  Time: 9:21
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
            $("#n1").blur(function () {
                var p = $("#n1").val();
                var reg = /^[2]\d{3}-(0[1-9]|1[0-2])/;
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
    List<T_Emp_Train> te= (List<T_Emp_Train>) request.getAttribute("tet2");
    T_TrainService t= (T_TrainService) request.getAttribute("tts");
%>

<div  id="da">
    <div id="d1">
        <h2>培训详情</h2>
        <div id="d4">
            &nbsp;&nbsp; <span><a id="a1" href="empjsp">员工主界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
                    <th>主题</th>
                    <th>内容</th>
                    <th>对象</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>地址</th>
                    <th>发布时间</th>
                </tr>
                <%
                    if (te==null){
                    }else{
                        for (int i = 0; i < te.size(); i++) {
                %>
                <%
                   int tid=te.get(i).getTra_id();
                    T_Train ttt=new T_Train();
                    ttt.setTra_id(tid);
                    T_Train tt=t.getT_Train(ttt);
                %>
                <tr>
                    <td><%=tt.getTra_id()%></td>
                    <td><%=tt.getTra_theme()%></td>
                    <td><%=tt.getTra_content()%></td>
                    <td><%=tt.getTra_obj()%></td>
                    <td>
                        <%=tt.getTra_begintime()%>
                    </td>
                    <td><%=tt.getTra_endtime()%></td>
                    <td><%=tt.getTra_address()%></td>
                    <td><%=tt.getTra_releasetime()%></td>
                </tr>
                <%
                        }
                    }
                %>
                <tr>
                    <td colspan="8">
                        <c:forEach begin="1" end="${requestScope.totalPages}" var="pagesize">
                            <a href="e_train?currentPage=${pagesize}">${pagesize}</a>
                        </c:forEach>
                    </td>
                </tr>
            </table>
            ${requestScope.noredpen1}
            ${requestScope.noredpen}
        </div>
    </div>
</div>
</body>
</html>


