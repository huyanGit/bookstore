<%--
  Created by IntelliJ IDEA.
  User: kohiko
  Date: 2017/12/5
  Time: 下午10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上书店注册页</title>
</head>
<body style="text-align:center;">
    <form action="${pageContext.request.contextPath }/client/RegisterServlet" method="post">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="password" name="password"><br/>
        <input type="submit" value="注册">
    </form>
</body>
</html>
