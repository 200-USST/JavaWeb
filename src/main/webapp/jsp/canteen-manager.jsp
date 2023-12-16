<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>SystemManagerPage</title>
    <link rel="stylesheet" type="text/css" href="../css/canteen-manager.css">

</head>
<body>
<div id="top">
    <div id="middle-photo">
        <a>
            <img src="../img/admin-logo.png" alt="Welcome Image">
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
        →食堂信息维护
    </button>

    <button class="funcbutt"  id="maintainDish">
        →菜品维护
    </button>

    <button class="funcbutt"  id="communityManage">
        →食堂评价处理
    </button>
</div>

<div id="middle-right">
    <div class="tooltip" id="personalInformationdiv" style="display:none;">
        <div id="personalInformationdivfunc1">
            <a href="#" class="tooltip-link" id="searchinfo-link">
                <img class="tooltip-func1" id="searchinfo-png" src="../img/search.png" alt="Search Image">
            </a>
            <p class="tooltip-text">个人信息查询</p>
        </div>

        <div id="personalInformationdivfunc2">
            <a href="#" class="tooltip-link" id="modifyinfo-link">
                <img class="tooltip-func1" id="modifyinfo-png" src="../img/modifyinfo.png" alt="Modify Image">
            </a>
            <p class="tooltip-text">个人信息修改</p>
        </div>
    </div>


    <div class="tooltip" id="canteenManagediv" style="display:none;">
        <div id="canteenManagedivfunc1">
            <a href="#" class="tooltip-link" id="searchcanteen-link">
                <img class="tooltip-func1" id="searchcanteen-png" src="../img/search.png" alt="Search Image">
            </a>
            <p class="tooltip-text">查询食堂信息</p>
        </div>

        <div id="canteenManagedivfunc2">
            <a href="#" class="tooltip-link" id="modifycanteen-link">
                <img class="tooltip-func1" id="modifycanteen-png" src="../img/modifyinfo.png" alt="Modify Image">
            </a>
            <p class="tooltip-text">修改食堂信息</p>
        </div>

    </div>
    <div class="tooltip" id="maintainDishdiv" style="display:none;">
        <div id="maintainDishdivfunc1">
            <a href="#" class="tooltip-link" id="adddish-link">
                <img class="tooltip-func1" id="adddish-png" src="../img/add.png" alt="Add Image">
            </a>
            <p class="tooltip-text">添加菜品</p>
        </div>
        <div id="maintainDishdivfunc2">
            <a href="#" class="tooltip-link" id="deletedish-link">
                <img class="tooltip-func1" id="deletedish-png" src="${pageContext.request.contextPath}/img/delete.png" alt="Delete Image">
            </a>
            <p class="tooltip-text">删除菜品</p>
        </div>
        <div id="maintainDishdivfunc3">
            <a href="#" class="tooltip-link" id="modifydish-link">
                <img class="tooltip-func1" id="modifydish-png" src="${pageContext.request.contextPath}/img/modifyinfo.png" alt="Modify Image">
            </a>
            <p class="tooltip-text">修改菜品</p>
        </div>
    </div>
    <div class="tooltip" id="communityManagediv" style="display:none;">
        <div id="communityManagedivfunc1">
            <a href="#" class="tooltip-link" id="checkcomment-link">
                <img class="tooltip-func1" id="checkcomment-png" src="${pageContext.request.contextPath}/img/search.png" alt="Check Image">
            </a>
            <p class="tooltip-text">查看并回复评论</p>
        </div>

    </div>
</div>

<div id="bottom">
    <p>上海理工大学食堂交流评价社区</p>
</div>

<script src="${pageContext.request.contextPath}/js/canteen-manager.js"></script>
</body>
</html>