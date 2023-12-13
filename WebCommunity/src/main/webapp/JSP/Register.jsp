<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="../CSS/Login.css">
</head>
<body>
<div id="login-box">
    <h1>新用户注册</h1>
    <form action="registerServlet" method="post" >
        <input type="text" id="registerusername" name="username" placeholder="请输入注册账号" required>
        <input type="password" id="registerpassword1" name="password" placeholder="请输入注册密码" required>
        <input type="password" id="registerpassword2" name="password" placeholder="请再次输入注册密码" required>

        <input type="submit" id="registerbutton" value="确认">
    </form>
    <p><a href="Login.jsp">返回</a></p>
</div>
</body>
</html>
