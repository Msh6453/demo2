<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/30
  Time: 13:07
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
</head>
<body>

<div  id="da">
    <div id="d1">
        <h2>查看简历</h2>
        <div id="d4">
            &nbsp;&nbsp; <span><a id="a1" href="mrecruit">招聘中心</a></span>
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
                    <th>薪资</th>
                    <th>工作地址</th>
                    <th>联系电话</th>
                    <th>Email</th>
                    <th>工作经验</th>
                    <th>岗位需求</th>
                    <th>公司介绍及福利</th>
                    <th>发布时间</th>
                    <th>状态</th>
                    <th>发布</th>
                    <th>撤销</th>
                    <th>修改</th>
                    <th>删除</th>
                </tr>
                <c:forEach items="${requestScope.recruitlist}" var="re">
                    <tr>
                        <td>${re.r_id}</td>
                        <td>${re.r_job}</td>
                        <td>${re.r_pay}</td>
                        <td>${re.r_address}</td>
                        <td>${re.r_tel}</td>
                        <td>
                             <%--<textarea id="tel3" name="re_experience"  cols="100" rows="10"
                                       style="width:80px; height:50px">${re.r_email}
                             </textarea>--%>
                                     ${re.r_email}
                        </td>
                        <td>
                             <textarea id="tel4" name="re_experience"  cols="100" rows="10"
                                       style="width:80px; height:50px">${re.r_experience}
                            </textarea>
                        </td>
                        <td>
                            <textarea id="te1" name="re_experience"  cols="100" rows="10"
                                       style="width:80px; height:50px"> ${re.r_required}
                            </textarea>
                        </td>
                        <td>
                             <textarea id="te2" name="re_experience"  cols="100" rows="10"
                                       style="width:80px; height:50px"> ${re.r_describer}
                             </textarea>
                        </td>
                        <td>${re.r_begintime}</td>
                        <td>
                            <c:if test="${re.r_state==1}">
                                ${"还未发布"}
                            </c:if>
                            <c:if test="${re.r_state==2}">
                                ${"已发布"}
                            </c:if>
                        </td>
                        <td>
                            <a href="updaterecruit12?r=2&r_id=${re.r_id}&r_state=${re.r_state}"><button >发布</button></a>
                        </td>
                        <td>
                            <a href="updaterecruit12?r=1&r_id=${re.r_id}&r_state=${re.r_state}"><button >撤销</button></a>
                        </td>
                        <td>
                            <a href="updaterecruit1?r_id=${re.r_id}"><button >修改</button></a>
                        </td>
                        <td>
                            <a href="deleterecruit?r_id=${re.r_id}"><button >删除</button></a>
                        </td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td colspan="15">
                            <c:forEach begin="1" end="${requestScope.totalPages}" var="pagesize">
                                <a href="getm_recruit?currentPage=${pagesize}">${pagesize}</a>
                            </c:forEach>
                        </td>
                    </tr>
            </table>
            ${requestScope.state2}
            ${requestScope.state1}
            ${requestScope.norecruits}
        </div>
    </div>
</div>
</body>
</html>

