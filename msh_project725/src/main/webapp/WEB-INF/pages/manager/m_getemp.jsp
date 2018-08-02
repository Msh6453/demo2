<%@ page import="com.iotek.service.T_DeptService" %>
<%@ page import="com.iotek.model.T_Position" %>
<%@ page import="com.iotek.service.T_PositionService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.T_Emp" %>
<%@ page import="com.iotek.model.T_Dept" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/2
  Time: 0:23
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
    List<T_Emp> t= (List<T_Emp>) request.getAttribute("temp");
    T_DeptService tds= (T_DeptService) request.getAttribute("tds");
    T_PositionService tps= (T_PositionService) request.getAttribute("tps");
%>

<div  id="da">
    <div id="d1">
        <h2>查看员工</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="m_emp">员工管理</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
                    <th>部门</th>
                    <th>职位</th>
                    <th>账号</th>
                    <th>密码</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>入职时间</th>
                    <th>电话</th>
                    <th>住址</th>
                    <th>状态</th>
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

                    T_Position tP=new T_Position();
                    tP.setP_id(t.get(i).getP_id());
                    T_Position tpp=tps.get_PostionByid(tP);
                %>

                <tr>
                    <td><%=t.get(i).getE_id()%></td>
                    <td><%=t2.getD_name()%></td>
                    <td><%=tpp.getP_name()%></td>
                    <td><%=t.get(i).getE_num()%></td>
                    <td><%=t.get(i).getE_password()%></td>
                    <td><%=t.get(i).getE_name()%></td>
                    <td><%=t.get(i).getE_age()%></td>
                    <td><%=t.get(i).getE_sex()%></td>
                    <td><%=t.get(i).getE_btime()%></td>
                    <td><%=t.get(i).getE_tel()%></td>
                    <td><%=t.get(i).getE_address()%></td>
                    <td><%
                    if (t.get(i).getE_state()==0){
                        out.print("试用期");
                    }else if(t.get(i).getE_state()==1){
                        out.print("正式工");
                    }else{
                        out.print("已离职");
                    }

                    %></td>
                    <td>
                        <a href="updateemp1?e_id=<%=t.get(i).getE_id()%>"><button >修改</button></a>
                    </td>
                    <td>
                        <a href="deleteemp?e_state=<%=t.get(i).getE_state()%>&e_id=<%=t.get(i).getE_id()%>"><button >删除</button></a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>

                <tr>
                    <td colspan="14">
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

