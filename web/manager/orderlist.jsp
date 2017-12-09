<%--
  Created by IntelliJ IDEA.
  User: kohiko
  Date: 2017/12/8
  Time: 下午1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body style="text-align:center;">
<h2>订单列表</h2>
<table width="60%" border="1" align="center" style="text-align: center;">
    <tr>
        <td>订单号</td>
        <td>订单人</td>
        <td>订单时间</td>
        <td>订单总价</td>
        <td>订单状态</td>
        <td>操作</td>
    </tr>
    <c:forEach var="order" items="${orders }">
        <tr>
            <td>${order.id }</td>
            <td>${order.user.username }</td>
            <td>${order.ordertime }</td>
            <td>${order.price }</td>
            <td>${order.state==true?'已发货':'未发货' }</td>
            <td>
                <a href="${pageContext.request.contextPath }/manager/OrderDetailServlet?orderid=${order.id}">查看明细</a>
                <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
