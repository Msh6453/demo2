<%@ page import="com.iotek.model.T_Train" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.service.T_DeptService" %>
<%@ page import="com.iotek.model.T_Dept" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/3
  Time: 13:01
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
        td{
            text-align: center;
        }
    </style>
</head>
<body>
<%
    List<T_Train> t = (List<T_Train>) request.getAttribute("trains");
    T_DeptService tds= (T_DeptService) request.getAttribute("tds");
%>

<div  id="da">
    <div id="d1">
        <h2>未发布培训</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="m_train">培训中心</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
                    <th>培训主题</th>
                    <th>培训内容</th>
                    <th>培训对象</th>
                    <th>培训开始时间</th>
                    <th>培训结束时间</th>
                    <th>是否发布</th>
                    <th>发布</th>
                </tr>

                <%
                    if (t==null){
                    }else{
                        for (int i = 0; i < t.size(); i++) {
                %>
                <%
                    T_Dept t1=new T_Dept();
                    t1.setD_id(t.get(i).getTra_obj());
                    T_Dept t2=tds.getT_DeptByid(t1);
                %>

                <tr>
                    <td><%=t.get(i).getTra_id()%></td>
                    <td><%=t.get(i).getTra_theme()%></td>
                    <td><%=t.get(i).getTra_content()%></td>
                    <td><%
                        if (t.get(i).getTra_obj()==0){
                            out.print("试用期员工");
                        }else{
                            out.print(t2.getD_name());
                        }

                    %></td>
                    <td><%=t.get(i).getTra_begintime()%></td>
                    <td><%=t.get(i).getTra_endtime()%></td>
                    <td><%
                        if (t.get(i).getTra_state()==0){
                            out.print("未发布");
                        }else{
                            out.print("已发布");
                        }
                    %></td>
                    <td>
                        <a href="updateTrainState?id=<%=t.get(i).getTra_id()%>&state=<%=t.get(i).getTra_state()%>"><button >发布</button></a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>

                <tr>
                    <td colspan="8">
                        <c:forEach begin="1" end="${requestScope.totalPages}" var="pagesize">
                            <a href="getdept?currentPage=${pagesize}">${pagesize}</a>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>

