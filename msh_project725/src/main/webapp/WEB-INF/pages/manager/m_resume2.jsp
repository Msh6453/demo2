<%@ page import="com.iotek.model.T_Resume" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31
  Time: 0:43
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
        #a1,#a2,#a3{
            text-decoration: none;
            color: white;
        }
      /*  #a3,#a4{
            font-size: 20px;
            text-decoration: none;
            color: black;
        }*/
        #te1,#te2{
            resize: none;
        }
    </style>
</head>
<body>
<%
    T_Resume t= (T_Resume) request.getAttribute("tResume1");
%>

<div  id="da">
    <div id="d1">
        <h2>简历详情</h2>
        <div id="d4">&nbsp;&nbsp; <span><a id="a1" href="m_feedback">应聘中心</a></span>
            &nbsp;&nbsp;<span><a id="a3" href="saveemp1?currentPage=1">返回上一页</a></span>
            &nbsp;&nbsp;<span><a id="a2" href="exit1">退出</a></span>
        </div>
    </div>
    <div id="d2">
        <img src="img/01.jpg">
        <div id="d3">
            <table border=":solid 1px "  style="margin:auto;">
                <tr>
                    <td><label>姓名</label></td>
                    <td><%=t.getRe_name()%></td>
                </tr>
                <tr>
                    <td><label>年龄</label></td>
                    <td><%=t.getRe_age()%></td>
                </tr>
                <tr>
                    <td><label>性别</label></td>
                    <td><%=t.getRe_sex()%></td>
                </tr>
                <tr>
                    <td><label>出生年月</label></td>
                    <td><%=t.getRe_birday()%></td>
                </tr>
                <tr>
                    <td><label>专业</label></td>
                    <td><%=t.getRe_major()%></td>
                </tr>
                <tr>
                    <td><label>学历</label></td>
                    <td><%=t.getRe_edu()%></td>
                </tr>
                <tr>
                    <td><label>毕业时间</label></td>
                    <td><%=t.getRe_endtime()%></td>
                </tr>
                <tr>
                    <td><label>兴趣爱好</label></td>
                    <td><%=t.getRe_hobby()%></td>
                </tr>
                <tr>
                    <td><label>电话</label></td>
                    <td><%=t.getRe_tel()%></td>
                </tr>
                <tr>
                    <td><label>家庭住址</label></td>
                    <td><%=t.getRe_address()%></td>
                </tr>
                <tr>
                    <td><label>工作经验</label></td>
                    <td>
                         <textarea id="te1"cols="100" rows="10"
                                   style="width:200px; height:50px" >
                                <%=t.getRe_experience()%>
                         </textarea>
                    </td>
                </tr>
                <tr>
                    <td><label>技能</label></td>
                    <td>
                        <textarea id="te2" cols="100" rows="10"
                                  style="width:200px; height:50px" >
                                <%=t.getRe_skill()%>
                         </textarea>
                    </td>
                </tr>

            </table>
        </div>
    </div>
</div>
</body>
</html>


