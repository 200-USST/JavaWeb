<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div id="login-box">
    <h1>登录</h1>
    <form action="loginServlet" method="post">
        <!-- 使用 placeholder 属性提供输入框中的提示 -->

        <input type="text" id="loginusername" name="username" placeholder="请输入账号" required>

        <input type="password" id="loginpassword" name="password" placeholder="请输入密码" required>

        <input type="submit" id="loginbutton" value="登录">
    </form>
    <p><a href="register.jsp">新用户注册</a></p>
</div>
</body>
</html>
