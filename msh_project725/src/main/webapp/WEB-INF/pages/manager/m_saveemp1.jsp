<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.T_Feedback" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.service.T_RecruitService" %>
<%@ page import="com.iotek.model.T_Recruit" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31
  Time: 14:35
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
    List<T_Feedback> tf= (List<T_Feedback>) request.getAttribute("state6");
   /* int totalPages= (int) request.getAttribute("totalPages");*/
    T_RecruitService trs= (T_RecruitService) request.getAttribute("trs");
%>


<div  id="da">
    <div id="d1">
        <h2>添加员工</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="mananger">管理员界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
                    <th>工作岗位</th>
                    <th>查看简历</th>
                    <th>投递时间</th>
                    <th>是否查阅</th>
                    <th>简历状态</th>
                    <th>添加</th>
                </tr>
                <%
                    if (tf==null){
                    }else{
                        for (int i = 0; i < tf.size(); i++) {
                %>
                <%
                    T_Recruit tRecruit=new T_Recruit();
                    tRecruit.setR_id(tf.get(i).getR_id());
                    T_Recruit tR=trs.getByR_id(tRecruit);
                %>
                <tr>
                    <td><%=tf.get(i).getF_id()%></td>

                    <td><%=tR.getR_job()%></td>
                    <td>
                        <a href="getmresume?a=2&f_id=<%=tf.get(i).getF_id()%>&f_read=<%=tf.get(i).getF_read()%>
                    &re_id=<%=tf.get(i).getRe_id()%>">查看详情</a>
                    </td>
                    <td><%=tf.get(i).getF_btime()%></td>
                    <td>
                        <%
                            if (tf.get(i).getF_read()==1){
                                out.print("已查阅");
                            }else{
                                out.print("未查阅");
                            }
                        %>
                    </td>
                    <td>
                        <%
                            if (tf.get(i).getF_state()==0){
                                out.print("刚投递");
                            }else if (tf.get(i).getF_state()==1){
                                out.print("已邀请");
                            }else if (tf.get(i).getF_state()==3){
                                out.print("投递人拒绝面试");
                            }else if (tf.get(i).getF_state()==4){
                                out.print("投递人接受面试");
                            }else if (tf.get(i).getF_state()==5){
                                out.print("不符合条件");
                            }else if (tf.get(i).getF_state()==6){
                                out.print("已经录用");
                            }else {
                                out.print("未录用");
                            }
                        %>
                    </td>
                    <td>
                        <a href="saveemp2?f_id=<%=tf.get(i).getF_id()%>"><button >新增</button></a>
                    </td>
                </tr>

                <%
                        }
                    }
                %>

                <tr>
                    <td colspan="7">
                        <c:forEach begin="1" end="${requestScope.totalPages}" var="pagesize">
                            <a href="state1?currentPage=${pagesize}">${pagesize}</a>
                        </c:forEach>
                    </td>
                </tr>
            </table>
            ${requestScope.temp}
        </div>
    </div>
</div>
</body>
</html>


