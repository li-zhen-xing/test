<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/28
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><fmt:message key="welcomeinfo"/> </h1>
<form action="login">
    <fmt:message key="username"/>：<input type="text" name="username"/><br/>
    <fmt:message key="password"/>：<input type="text" name="passward"/><br/>
    <input type="submit" value="<fmt:message key="loginBtn"/>"/>
</form>
</body>
</html>
