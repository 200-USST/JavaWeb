<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>SystemManagerPage</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/root.css">

</head>
<body>
<div id="top">
    <div id="middle-photo">
        <a>
            <img src="${pageContext.request.contextPath}/img/admin-logo.png" alt="Welcome Image">
        </a>
        <p>欢迎您, ${username}</p>
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