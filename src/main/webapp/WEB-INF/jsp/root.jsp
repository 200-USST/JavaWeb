<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>SystemManagerPage</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/root.css">

</head>
<body>

<c:set var="user" value="${sessionScope.user}"/>

<div id="top">
    <div id="middle-photo">
        <a>
            <img src="${pageContext.request.contextPath}/img/admin-logo.png" alt="Welcome Image">
        </a>
        <p>欢迎您, ${user.userName}</p>
    </div>

    <div id="topbut">
        <button id="topbutton">退出登录</button>
    </div>
</div>

<div id="middle-left">
    <div id="function">
        <h3>功能列表</h3>
    </div>

    <button class="funcbutt" id="personalInformation">
        →个人信息
    </button>

    <button class="funcbutt"  id="canteenManage">
        →食堂基本信息管理
    </button>

    <button class="funcbutt"  id="accountManage">
        →账号管理
    </button>

    <button class="funcbutt"  id="communityManage">
        →社区管理
    </button>
</div>

<div id="middle-right">
    <div class="tooltip" id="personalInformationdiv" style="display:none;">
        <div id="personalInformationdivfunc1">
            <a href="#" class="tooltip-link" id="searchinfo-link">
                <img class="tooltip-func1" id="searchinfo-png" src="${pageContext.request.contextPath}/img/search.png" alt="Search Image">
            </a>
            <p class="tooltip-text">个人信息查询</p>
        </div>

        <div id="personalInformationdivfunc2">
            <a href="#" class="tooltip-link" id="modifyinfo-link">
                <img class="tooltip-func1" id="modifyinfo-png" src="${pageContext.request.contextPath}/img/modifyinfo.png" alt="Modify Image">
            </a>
            <p class="tooltip-text">个人信息修改</p>
        </div>
    </div>

    <div class="tooltip" id="searchinfo-pngdiv" style="display:none;">
        <p>用户名：${user.userName}</p>
        <p>身份类型：${user.userIdentity}</p>
        <p>性别：${user.userGender}</p>
        <p>年龄：${user.userAge}</p>
    </div>

    <div class="tooltip" id="modifyinfo-pngdiv" style="display:none;">
        <form action="#" method="post">
            <label for="name-mod">用户名：</label>
            <input type="text" name="userName" id="name-mod" value="${user.userName}" required>
            <br><br>
            <label for="password-mod">密码：</label>
            <input type="password" name="userPassword" id="password-mod" value="${user.userPassword}" required>
            <br><br>
            <label for="id-mod">身份类型：</label>
            <input type="text" name="userIdentity" id="id-mod" value="${user.userIdentity}" required>
            <br><br>
            <label for="gender-mod">性别：</label>
            <input type="text" name="userGender" id="gender-mod" value="${user.userGender}" required>
            <br><br>
            <label for="age-mod">年龄：</label>
            <input type="text" name="userAge" id="age-mod" value="${user.userAge}" required>
            <br><br>
            <input type="submit" value="提交">
        </form>
    </div>

<%----%>


    <div class="tooltip" id="canteenManagediv" style="display:none;">
        <div id="canteenManagedivfunc1">
            <a href="#" class="tooltip-link" id="addcanteen-link">
                <img class="tooltip-func1" id="addcanteen-png" src="${pageContext.request.contextPath}/img/add.png" alt="Add Image">
            </a>
            <p class="tooltip-text">增添食堂</p>
        </div>
        <div id="canteenManagedivfunc2">
            <a href="#" class="tooltip-link" id="deletecanteen-link">
                <img class="tooltip-func1" id="deletecanteen-png" src="${pageContext.request.contextPath}/img/delete.png" alt="Delete Image">
            </a>
            <p class="tooltip-text">删除食堂</p>
        </div>
        <div id="canteenManagedivfunc3">
            <a href="#" class="tooltip-link" id="modifycanteen-link">
                <img class="tooltip-func1" id="modifycanteen-png" src="${pageContext.request.contextPath}/img/modifyinfo.png" alt="Modify Image">
            </a>
            <p class="tooltip-text">修改食堂信息</p>
        </div>
    </div>

    <div class="tooltip" id="addcanteen-pngdiv" style="display:none;">
        <form>
            <label for="canteenName">食堂名称：</label>
            <input type="text" name="canteenName" id="canteenName" value="" required>
            <br><br>
            <label for="canteenLoc">食堂位置：</label>
            <input type="text" name="canteenLocation" id="canteenLoc" value="" required>
            <br><br>
            <label for="canteenAb">食堂简介：</label>
            <input type="text" name="canteenAbstract" id="canteenAb" value="" required>
            <br><br>
        </form>
    </div>


    <%--        --%>


    <div class="tooltip" id="accountManagediv" style="display:none;">
        <div id="accountManagedivfunc1">
            <a href="#" class="tooltip-link" id="setmanager-link">
                <img class="tooltip-func1" id="setmanager-png" src="${pageContext.request.contextPath}/img/add.png" alt="Add Image">
            </a>
            <p class="tooltip-text">设置食堂管理员账号</p>
        </div>
        <div id="accountManagedivfunc2">
            <a href="#" class="tooltip-link" id="deleteaccount-link">
                <img class="tooltip-func1" id="deleteaccount-png" src="${pageContext.request.contextPath}/img/delete.png" alt="Delete Image">
            </a>
            <p class="tooltip-text">删除已有账号</p>
        </div>
        <div id="accountManagedivfunc3">
            <a href="#" class="tooltip-link" id="modifyaccount-link">
                <img class="tooltip-func1" id="modifyaccount-png" src="${pageContext.request.contextPath}/img/modifyinfo.png" alt="Modify Image">
            </a>
            <p class="tooltip-text">修改账号</p>
        </div>
    </div>


<%--    --%>


    <div class="tooltip" id="communityManagediv" style="display:none;">
        <div id="communityManagedivfunc1">
            <a href="#" class="tooltip-link" id="deletecomment-link">
                <img class="tooltip-func1" id="deletecomment-png" src="${pageContext.request.contextPath}/img/delete.png" alt="Delete Image">
            </a>
            <p class="tooltip-text">删除评论</p>
        </div>
        <div id="communityManagedivfunc2">
            <a href="#" class="tooltip-link" id="modifycomment-link">
                <img class="tooltip-func1" id="modifycomment-png" src="${pageContext.request.contextPath}/img/modifyinfo.png" alt="Modify Image">
            </a>
            <p class="tooltip-text">修改评论</p>
        </div>
    </div>
</div>

<div id="bottom">
    <p>上海理工大学食堂交流评价社区</p>
</div>


<script src="${pageContext.request.contextPath}/js/root.js"></script>

</body>
</html>