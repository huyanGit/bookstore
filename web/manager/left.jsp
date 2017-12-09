<%--
  Created by IntelliJ IDEA.
  User: kohiko
  Date: 2017/12/8
  Time: 下午1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>左部导航</title>
</head>
<style type="text/css">
    .menu{
        display: none;
        margin-left: 10px;
    }
</style>
<script type="text/javascript">
    function test(e){
        var element = document.getElementById(e);
        element.style.display = element.style.display == 'block' ? 'none':'block';
    }
</script>
<body>
    <ul>
        <li>
            <a href="#" onclick="test('menu1')">分类管理
                <div id="menu1" class="menu">
                    <a href="${pageContext.request.contextPath}/manager/addcategory.jsp" target="right" >添加分类</a>
                    <a href="${pageContext.request.contextPath}/manager/CategoryServlet?method=listall" target="right">查看分类</a>
                </div>
            </a>
        </li>
        <li>
            <a href="#" onclick="test('menu2')">图书管理
                <div id="menu2" class="menu">
                    <a href="${pageContext.request.contextPath}/manager/BookServlet?method=addUI" target="right">添加图书</a>
                    <a href="${pageContext.request.contextPath}/manager/BookServlet?method=list" target="right">查看图书</a>
                </div>
            </a>
        </li>
        <li>
            <a href="#" onclick="test('menu3')">订单管理
                <div id="menu3" class="menu">
                    <a href="${pageContext.request.contextPath }/manager/OrderListServlet?state=false" target="right">未发货订单</a>
                    <a href="${pageContext.request.contextPath }/manager/OrderListServlet?state=true" target="right">已发货订单</a>
                </div>
            </a>
        </li>
    </ul>
</body>
</html>
