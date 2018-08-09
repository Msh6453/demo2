<%@ page import="com.iotek.model.T_Appeal" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/8
  Time: 14:09
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

    </script>
</head>
<body>
<%
    List<T_Appeal> ta= (List<T_Appeal>) request.getAttribute("taa1");
%>



<div  id="da">
    <div id="d1">
        <h2>待回复详情</h2>
        <div id="d4">
            &nbsp;&nbsp; <span><a id="a1" href="mananger">管理员界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
                    <th>复议月份</th>
                    <th>复议原因</th>
                    <th>复议结果</th>
                    <th>提交复议时间</th>
                    <th>回复</th>

                </tr>
                <%
                    if (ta==null){
                    }else{
                        for (int i = 0; i < ta.size(); i++) {
                %>

                <tr>
                    <td><%=ta.get(i).getApp_id()%></td>
                    <td><%=ta.get(i).getApp_month()%></td>
                    <td><%=ta.get(i).getApp_reason()%></td>
                    <td><%=ta.get(i).getApp_result()%></td>
                    <td><%=ta.get(i).getApp_time()%></td>
                    <td>
                        <a href="updateAppeal?app_id=<%=ta.get(i).getApp_id()%>"><button>回复</button></a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                <tr>
                    <td colspan="8">
                        <c:forEach begin="1" end="${requestScope.totalPages}" var="pagesize">
                        <a href="m_getAppeal?currentPage=${pagesize}">${pagesize}</a>
                    </c:forEach>
                    </td>
                </tr>
            </table>

        </div>
    </div>
</div>
</body>
</html>


