<%--
  Created by IntelliJ IDEA.
  User: kohiko
  Date: 2017/12/8
  Time: 下午1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加分类</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/manager/CategoryServlet?method=add" method="post">
    分类名称：<input type="text" name="name"><br/><br/>
    分类描述：<textarea rows="5" cols="40" name="description"></textarea>
    <input type="submit" value="添加">
</form>
</body>
</html>
