<%--
  Created by IntelliJ IDEA.
  User: kohiko
  Date: 2017/12/8
  Time: 下午1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>订单明细</title>
</head>
<body style="text-align:center;">
<h3>订单明细</h3>
<table border="1" width="50%" align="center" style="text-align: center;">
    <tr>
        <td>书名</td>
        <td>售价</td>
        <td>数量</td>
        <td>应收货款</td>
    </tr>
    <c:forEach var="orderitem" items="${order.orderitems }">
        <tr>
            <td>${orderitem.book.name }</td>
            <td>${orderitem.book.price }</td>
            <td>${orderitem.quantity }</td>
            <td>${orderitem.price }</td>
        </tr>
    </c:forEach>

    <tr>
        <td>订单总价</td>
        <td colspan="3">${order.price }</td>
    </tr>

</table>

<h3>收货人详细信息</h3>
<table border="1" width="50%" align="center" style="text-align: center;">
    <tr>
        <td>用户</td>
        <td>电话</td>
        <td>手机</td>
        <td>地址</td>
        <td>邮箱</td>
    </tr>
    <tr>
        <td>${order.user.username }</td>
        <%--<td>${order.user.phone }</td>--%>
        <%--<td>${order.user.cellphone }</td>--%>
        <%--<td>${order.user.address }</td>--%>
        <%--<td>${order.user.email }</td>--%>
    </tr>
</table>
<a href="${pageContext.request.contextPath }/manager/ConfirmOrderServlet?orderid=${order.id}">确认发货</a>
</body>
</html>
