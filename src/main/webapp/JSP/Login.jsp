<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Login.css">
</head>
<body>
<div id="login-box">
    <h1>登录</h1>
    <form action="${pageContext.request.contextPath}/login.do" method="get" >
        <!-- 使用 placeholder 属性提供输入框中的提示 -->

        <input type="text" id="userName" name="userName" placeholder="请输入用户名" required>


        <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required>

        <input type="submit" value="登录">

        <input type="reset" value="重置">

    </form>
    <p><a href="Register.jsp">新用户注册</a></p>
</div>
</body>
</html>
