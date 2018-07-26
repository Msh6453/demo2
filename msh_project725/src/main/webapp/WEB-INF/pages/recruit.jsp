<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.T_Recruit" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/25
  Time: 15:22
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
        function check(d0) {
            var dd=document.getElementById(d0);
            if(dd.style.display=="block"){
                dd.style.display="none";
            }else{
                dd.style.display="block"
            }
        }
    </script>
    <style>
        #d1{
            width: 100%;
            height: 50px;
        }
        #d2{

            width: 100%;
            height: 800px;
            text-align: center;
           background-color: cornflowerblue;
        }
        #d3{
            position:relative;
          /*  background-color:rgba(0,0,0,0.2);*/
            margin-top: -700px;

        }

    </style>
</head>
<%
    List<T_Recruit> tRecruits= (List<T_Recruit>) request.getAttribute("recruitlist");
%>
<body>
<div id="d1">
    <h2>招聘信息</h2>
</div>
<div id="d2">
    <img src="img/01.jpg">

<div id="d3">
    <table border=":solid 1px " bgcolor="#add8e6" style="margin:auto;">
        <tr>
            <th>ID</th>
            <th>工作岗位</th>
            <th>薪资</th>
            <th>工作地址</th>
            <th>联系电话</th>
            <th>Email</th>
            <th>工作经验</th>
            <th>岗位需求</th>
            <th>公司介绍及福利</th>
            <th>投递简历</th>

        </tr>
            <%
        for (int i = 0; i < tRecruits.size(); i++) {
    %>
        <tr>
            <td><%=tRecruits.get(i).getR_id()%></td>
            <td><%=tRecruits.get(i).getR_job()%></td>
            <td><%=tRecruits.get(i).getR_pay()%></td>
            <td><%=tRecruits.get(i).getR_address()%></td>
            <td><%=tRecruits.get(i).getR_tel()%></td>
            <td><%=tRecruits.get(i).getR_email()%></td>
            <td><%=tRecruits.get(i).getR_experience()%></td>
            <td><%=tRecruits.get(i).getR_required()%></td>
            <td><%=tRecruits.get(i).getR_describer()%></td>
            <td><a href=""><input type="button" value="投递"></a></td>
        </tr>
            <%
        }
    %>
</div>
</div>


</body>
</html>

