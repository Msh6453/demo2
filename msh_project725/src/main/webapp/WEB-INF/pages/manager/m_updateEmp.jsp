<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.T_Emp" %>
<%@ page import="com.iotek.service.T_DeptService" %>
<%@ page import="com.iotek.service.T_PositionService" %>
<%@ page import="com.iotek.model.T_Dept" %>
<%@ page import="com.iotek.model.T_Position" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/2
  Time: 1:12
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
        #te1,#te2,#te3,#tel4{
            resize: none;
        }
    </style>
    <script src="jq-resources/jquery.js"></script>
    <script>
        $(function(){
            $("#dept").click(function(){
                var a=$("#dept").val();
                $.ajax({
                    url:"getPosition",
                    data:"d_id="+a,
                    type:"post",
                    success:function (obj) {
                        $("#pos option").remove();
                        $.each(obj,function (i,item) {
                            var b=item.p_id;
                            $("#pos").append(
                                "<option  value="+b+">"+item.p_name+"</option>"

                            )
                        })
                    }
                })
            })
        })

    </script>
</head>
<body>
<%
    T_Emp t= (T_Emp) request.getAttribute("tEmp");
    T_DeptService tds= (T_DeptService) request.getAttribute("tds");
    T_PositionService tps= (T_PositionService) request.getAttribute("tps");
    T_Dept t1=new T_Dept();
    t1.setD_id(t.getD_id());
    T_Dept t2=tds.getT_DeptByid(t1);

    T_Position tP=new T_Position();
    tP.setP_id(t.getP_id());
    T_Position tpp=tps.get_PostionByid(tP);


%>

<div  id="da">
    <div id="d1">
        <h2>员工信息修改</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="getT_Emp?currentPage=1">返回上一界面</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">

        <div id="d3">
            <form  method="post" action="updateemp2">
                <table border=":solid 1px "  style="margin:auto;">

                    <tr>
                        <td><label>原部门名称</label></td>
                        <td><input type="text" id="n2" disabled="disabled"
                                   value="<%=t2.getD_name()%>"></td>
                    </tr>
                    <tr>
                        <td><label>原职位名称</label></td>
                        <td><input type="text" id="n1" disabled="disabled"
                                   value="<%=tpp.getP_name()%>"></td>
                    </tr>
                    <tr>
                        <td><label>部门/职位</label></td>
                        <td>
                            <select id="dept" name="d_id">
                                <option>请选择部门</option>
                                <c:forEach items="${requestScope.tDepts}" var="d">
                                    <option   value="${d.d_id}" id="dept1">${d.d_name}</option>
                                </c:forEach>
                            </select>

                            <select id="pos" name="p_id">
                            </select>
                        </td>
                    </tr>

                </table>
                <input type="hidden" name="e_id" value="<%=t.getE_id()%>">
                <input id="n10"  type="submit" value="提交">
            </form>
        </div>
    </div>
</div>
</body>
</html>

