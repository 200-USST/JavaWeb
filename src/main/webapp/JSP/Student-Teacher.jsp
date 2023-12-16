<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>SystemManagerPage</title>
    <link rel="stylesheet" type="text/css" href="../CSS/Student-Teacher.css">

</head>
<body>
<div id="top">
    <div id="middle-photo">
        <a>
            <img src="../Image/admin-logo.png" alt="Welcome Image">
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

    <button class="funcbutt"  id="chatCommunity">
        →交流社区
    </button>

    <button class="funcbutt"  id="Retrieve">
        →检索
    </button>
</div>

<div id="middle-right">
    <div class="tooltip" id="personalInformationdiv" style="display:none;">
        <div id="personalInformationdivfunc1">
            <a href="#" class="tooltip-link" id="searchinfo-link">
                <img class="tooltip-func1" id="searchinfo-png" src="../Image/search.png" alt="Search Image">
            </a>
            <p class="tooltip-text">个人信息查询</p>
        </div>

        <div id="personalInformationdivfunc2">
            <a href="#" class="tooltip-link" id="modifyinfo-link">
                <img class="tooltip-func1" id="modifyinfo-png" src="../Image/modifyinfo.png" alt="Modify Image">
            </a>
            <p class="tooltip-text">个人信息修改</p>
        </div>
    </div>


    <div class="tooltip" id="chatCommunitydiv" style="display:none;">
        <div id="chatCommunitydivfunc1">
            <a href="#" class="tooltip-link" id="showcommunity-link">
                <img class="tooltip-func1" id="showcommunity-png" src="../Image/chat.png" alt="Chat Image">
            </a>
            <p class="tooltip-text">显示交流社区评论</p>
        </div>
        <div id="chatCommunitydivfunc2">
            <a href="#" class="tooltip-link" id="writecomment-link">
                <img class="tooltip-func1" id="writecomment-png" src="../Image/modifyinfo.png" alt="Modify Image">
            </a>
            <p class="tooltip-text">写评论</p>
        </div>
        <div id="chatCommunitydivfunc3">
            <a href="#" class="tooltip-link" id="mycomment-link">
                <img class="tooltip-func1" id="mycomment-png" src="../Image/search.png" alt="Search Image">
            </a>
            <p class="tooltip-text">我的发言</p>
        </div>

    </div>

    <div class="tooltip" id="Retrievediv" style="display:none;">
        <div id="Retrievedivfunc1">
            <a href="#" class="tooltip-link" id="dishretrieve-link">
                <img class="tooltip-func1" id="dishretrieve-png" src="../Image/search.png" alt="Search Image">
            </a>
            <p class="tooltip-text">菜品检索</p>
        </div>
        <div id="Retrievedivfunc2">
            <a href="#" class="tooltip-link" id="canteenretrieve-link">
                <img class="tooltip-func1" id="canteenretrieve-png" src="../Image/canteen.png" alt="Canteen Image">
            </a>
            <p class="tooltip-text">食堂检索</p>
        </div>

    </div>
</div>

<div id="bottom">
    <p>上海理工大学食堂交流评价社区</p>
</div>

<script src="../JS/Student-Teacher.js"></script>
</body>
</html>