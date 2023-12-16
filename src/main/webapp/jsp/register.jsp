<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>
<div id="login-box">
    <h1>新用户注册</h1>
    <form action="${pageContext.request.contextPath}/register.do" method="get" >
        <input type="text" id="username" name="userName" placeholder="请输入注册账号" required>
        <input type="password" id="password1" name="userPassword" placeholder="请输入注册密码" required>
        <input type="password" id="password2" name="userPasswordRepeat" placeholder="请再次输入注册密码" required>
        <input type="hidden" name="type" value="user">
        <input type="submit" value="确认">
        <input type="reset" value="重置">
    </form>
    <p><a href="login.jsp">返回</a></p>
</div>
</body>
</html>
