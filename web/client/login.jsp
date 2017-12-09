<%--
  Created by IntelliJ IDEA.
  User: kohiko
  Date: 2017/12/5
  Time: 下午9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上书店登录页</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/client/LoginServlet" method="post">
        用户名：<input type="text" name="username" style="width:60px;">
        密码：<input type="password" name="password" style="width:60px;">
        <input type="submit" value="登陆">
        <input id="sub" type="button" value="注册">
    </form>
</div>
<script type="text/javascript">
    var btn = document.getElementById("sub");
    btn.onclick = function(){
        window.location.href = "${pageContext.request.contextPath }/client/register.jsp";
    }
</script>
</body>
</html>
