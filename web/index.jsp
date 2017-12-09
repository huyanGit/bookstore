<%--
  Created by IntelliJ IDEA.
  User: kohiko
  Date: 2017/12/4
  Time: 下午6:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>前台首页</title>
  </head>
  <frameset rows="26%,*">
    <frame src="${pageContext.request.contextPath }/client/head.jsp" name="head">
    <frame src="${pageContext.request.contextPath }/client/IndexServlet?method=getAll" name="body">
  </frameset>
  <body>
  </body>
</html>
