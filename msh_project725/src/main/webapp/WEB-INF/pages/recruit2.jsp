<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.T_Recruit" %>
<%@ page import="com.iotek.model.T_Tourist" %><%--
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
     #d4{
        margin-left: 900px;
     }
     #a1,#a2{
         text-decoration: none;
         color: white;
     }

</style>
</head>
<%
    List<T_Recruit> tRecruits= (List<T_Recruit>) request.getAttribute("recruitlist");
    int totalPages= (int) request.getAttribute("totalPages");
    T_Tourist tourist= (T_Tourist) session.getAttribute("tour");
%>
<body>
<div  id="da">
    <div id="d1">
        <h2>招聘信息</h2>
        <div id="d4"><span><%
            if (tourist!=null){
                out.print("欢迎游客"+tourist.getT_name());
            }
        %>
        </span>&nbsp;&nbsp; <span><a id="a1" href="getresume?currentPage=1">个人中心</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
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
                    <th>发布时间</th>
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
                    <td><%=tRecruits.get(i).getR_begintime()%></td>
                    <td><a href="saveFeedback1?currentPage=1&r_id=<%=tRecruits.get(i).getR_id()%>"><input type="button" value="投递"></a></td>
                </tr>

                <%
                    }
                %>
            </table>
            <%
                for (int i = 1; i <=totalPages; i++) {
            %>
            <a href="recruit?currentPage=<%=i%>"><%=i%></a><br/>
            <%
                }
            %>
            ${requestScope.Feedback1}
            ${requestScope.Feedback2}
            ${requestScope.noResumes}
        </div>
    </div>
</div>
</body>
</html>

