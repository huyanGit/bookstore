<%--
  Created by IntelliJ IDEA.
  User: kohiko
  Date: 2017/12/5
  Time: 下午6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>首页头</title>
</head>
<body style="text-align:center;">
    <c:if test="${user==null}">
        <a href="${pageContext.request.contextPath }/client/login.jsp">请登录</a>
    </c:if>
    <c:if test="${user!=null}">
    欢迎您：${user.username}<a href="${pageContext.request.contextPath }/client/LoginOutServlet">注销</a>
    </c:if>
    <h1>网上书店</h1>
    <br/>
    <div>
        <a href="${pageContext.request.contextPath }/client/IndexServlet?method=getAll" target="body">首页</a>
        <a href="${pageContext.request.contextPath }/client/cartlist.jsp" target="body">查看购物车</a>
        <a href="${pageContext.request.contextPath }/client/ClientOrderListServlet?userid=${user.userId}" target="body">查看订单</a>
    </div>

</body>
</html>
