<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ch">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared.css">
    <title>登陆界面</title>
</head>

<body>

<c:if test="${not empty info}">
    <div id="message-box">
        <p>${info.description}</p>
    </div>
</c:if>

<div class="container" id="container">
    <div class="form-container sign-up">
        <form action="${pageContext.request.contextPath}/register.do" method="get">
            <h1>注册账户</h1>
            <div class="social-icons">
                <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
            </div>
            <input type="text" name="userName" placeholder="用户名">
            <input type="password" name="userPassword" placeholder="密码">
            <input type="password" name="userPasswordRepeat" placeholder="确认密码">
            <input type="hidden" name="type" value="user">
            <button>注册</button>
        </form>
    </div>
    <div class="form-container sign-in">
        <form action="${pageContext.request.contextPath}/login.do" method="post">
            <h1>登陆账户</h1>
            <div class="social-icons">
                <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
            </div>
            <input type="text" name="userName" placeholder="用户名">
            <input type="password" name="userPassword" placeholder="密码">
            <a href="#">忘记密码？</a>
            <button type="submit">登陆</button>
        </form>
    </div>
    <div class="toggle-container">
        <div class="toggle">
            <div class="toggle-panel toggle-left">
                <h1>欢迎回来！</h1>
                <p>已有账号？前往登陆 👈</p>
                <button class="hidden" id="login">登陆</button>
            </div>
            <div class="toggle-panel toggle-right">
                <h1>你好朋友！</h1>
                <p>没有账号？前往注册 👉</p>
                <button class="hidden" id="register">注册</button>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/login-register.js"></script>
<script src="${pageContext.request.contextPath}/js/shared.js"></script>
</body>

</html>
