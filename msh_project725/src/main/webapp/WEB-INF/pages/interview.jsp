<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.T_Feedback" %>
<%@ page import="com.iotek.service.T_RecruitService" %>
<%@ page import="com.iotek.model.T_Recruit" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/30
  Time: 8:51
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
        span{
            position: relative;
        }
    </style>
</head>
<body>
<%
    List<T_Feedback> tf= (List<T_Feedback>) request.getAttribute("state1");
    T_RecruitService trs= (T_RecruitService) request.getAttribute("trs");
    int totalPages= (int) request.getAttribute("totalPages");
%>
<div  id="da">
    <div id="d1">
        <h2>面试邀请</h2>
    </div>
    <div id="d2">
        <img src="img/01.jpg">
        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <th>ID</th>
                    <th>工作岗位</th>
                    <th>面试时间</th>
                    <th>面试地址</th>
                    <th>联系电话</th>
                    <th>接受面试</th>
                    <th>拒绝面试</th>
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
                    <td><%=tf.get(i).getF_interviewtime()%></td>
                    <td><%=tR.getR_address()%></td>
                    <td><%=tR.getR_tel()%></td>
                    <td>
                        <a href="updatestate34?state=3&f_id=<%=tf.get(i).getF_id()%>"><button >接受</button></a>
                    </td>
                    <td>
                        <a href="updatestate34?state=4&f_id=<%=tf.get(i).getF_id()%>"><button >拒绝</button></a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                <%
                    for (int i = 1; i <=totalPages; i++) {
                %>
                <a href="state1?currentPage=<%=i%>"><%=i%></a>
                <%
                    }
                %>
                ${requestScope.nostate1}
                ${requestScope.state3}
                ${requestScope.state4}
            </table>
        </div>
    </div>
</div>
</body>
</html>


