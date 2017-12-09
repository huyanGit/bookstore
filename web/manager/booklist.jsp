<%--
  Created by IntelliJ IDEA.
  User: kohiko
  Date: 2017/12/8
  Time: 下午1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>书籍列表</title>
</head>
<body style="text-align:center;">
<h2>图书信息</h2>
<table border="1" width="60%" align="center">
    <tr>
        <td>图书名称</td>
        <td>作者</td>
        <td>价格</td>
        <td>图片</td>
        <td>描述</td>
        <td>操作</td>
    </tr>
    <c:forEach var="book" items="${page.list}">
        <tr>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>
                <a href="${pageContext.request.contextPath}/images/${book.image}">查看图片</a>
            </td>
            <td>${book.description}</td>
            <td>
                <a href="#">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
当前第[${page.pagenum}]页
<c:forEach var="pagenum" begin="${page.startpage}" end="${page.endpage}">
    [<a href="${pageContext.request.contextPath }/manager/BookServlet?method=list&pagenum=${pagenum}">${pagenum}</a> ]
</c:forEach>
总共[${page.totalpage}]页，共[${page.totalrecord}]条记录
<br>
<a href="${pageContext.request.contextPath }/manager/BookServlet?method=list&pagenum=${page.pagenum-1}">上一页</a>
<a href="${pageContext.request.contextPath }/manager/BookServlet?method=list&pagenum=${page.pagenum+1}">下一页</a>
</body>
</html>
