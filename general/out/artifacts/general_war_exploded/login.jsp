<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/19
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    ${message}
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        学号：<input type="text" name="num"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="登录"><br>
    </form>
    <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
</body>
</html>
