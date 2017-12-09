<%--
  Created by IntelliJ IDEA.
  User: kohiko
  Date: 2017/12/8
  Time: 下午1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>后台首页</title>
</head>
<frameset rows="15%,*">
    <frame src="${pageContext.request.contextPath }/manager/head.jsp" name="head">
    <frameset cols="11.5%,*">
        <frame src="${pageContext.request.contextPath }/manager/left.jsp" name="left">
        <frame src="${pageContext.request.contextPath }/manager/right.jsp" name="right">
    </frameset>
</frameset>
</html>
