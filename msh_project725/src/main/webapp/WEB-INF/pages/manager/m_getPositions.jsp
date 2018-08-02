<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.T_Position" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.service.T_DeptService" %>
<%@ page import="com.iotek.model.T_Dept" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/1
  Time: 18:57
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
    </style>
</head>
<body>
<%
    List<T_Position> t= (List<T_Position>) request.getAttribute("t_positions");
    T_DeptService tds= (T_DeptService) request.getAttribute("tds");
%>

<div  id="da">
    <div id="d1">
        <h2>职位</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="m_deptAndposition">部门/职位</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
                    <th>部门名称</th>
                    <th>职位名称</th>
                    <th>修改</th>
                    <th>删除</th>
                </tr>
                <%
                    if (t==null){
                    }else{
                        for (int i = 0; i < t.size(); i++) {
                %>
                <%
                    T_Dept t1=new T_Dept();
                    t1.setD_id(t.get(i).getD_id());
                    T_Dept t2=tds.getT_DeptByid(t1);
                %>

                    <tr>
                        <td><%=t.get(i).getP_id()%></td>
                        <td><%=t2.getD_name()%></td>
                        <td><%=t.get(i).getP_name()%></td>
                        <td>
                            <a href="updatePos1?p_id=<%=t.get(i).getP_id()%>"><button >修改</button></a>
                        </td>
                        <td>
                            <a href="deletePos?p_id=<%=t.get(i).getP_id()%>"><button >删除</button></a>
                        </td>
                    </tr>
                <%
                        }
                    }
                %>

                <tr>
                    <td colspan="5">
                        <c:forEach begin="1" end="${requestScope.totalPages}" var="pagesize">
                            <a href="getdept?currentPage=${pagesize}">${pagesize}</a>
                        </c:forEach>
                    </td>
                </tr>
            </table>
            ${requestScope.pos}
        </div>
    </div>
</div>
</body>
</html>


