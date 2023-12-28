<%--
  Created by IntelliJ IDEA.
  User: rlagofla
  Date: 12/19/23
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ch">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
    <title>Dashboard</title>
</head>
<body>

<div id="storage"
cmJson='${cmJson}'>

<div class="container">
    <!-- Sidebar Section -->
    <aside>
        <div class="toggle">
            <div class="logo">
                <img src="${pageContext.request.contextPath}/img/logo.png">
                <h2>上理<span class="danger">食堂</span></h2>
            </div>
            <div class="close" id="close-btn">
                    <span class="material-icons-sharp">
                        close
                    </span>
            </div>
        </div>

        <div class="sidebar">
            <a href="#" class="active" id="dashboard">
                    <span class="material-icons-sharp">
                        dashboard
                    </span>

                <h3>仪表盘</h3>
            </a>
            <a href="#" id="personal-info">
                    <span class="material-icons-sharp">
                        person_outline
                    </span>
                <h3>个人信息</h3>
            </a>
<c:if test="${user.userIdentity == 'root'}">
            <a href="#" id="canteen-info">
                    <span class="material-icons-sharp">
                        restaurant
                    </span>
                <h3>食堂管理</h3>
            </a>
            <a href="#" id="accounts-manage">
                    <span class="material-icons-sharp">
                        manage_accounts
                    </span>
                <h3>账号管理</h3>
            </a>
            <a href="#" id="community-manage">
                    <span class="material-icons-sharp">
                        forum
                    </span>
                <h3>社区管理</h3>
            </a>
</c:if>
<c:if test="${user.userIdentity == 'user'}">
            <a href="#" id="community-chat">
                    <span class="material-icons-sharp">
                        forum
                    </span>
                <h3>交流社区</h3>
            </a>
            <a href="#" id="canteen-search">
                    <span class="material-icons-sharp">
                        restaurant
                    </span>
                <h3>食堂检索</h3>
            </a>
            <a href="#" id="dishes-search">
                    <span class="material-icons-sharp">
                        ramen_dining
                    </span>
                <h3>菜品检索</h3>
            </a>
</c:if>
<c:if test="${user.userIdentity == 'manager'}">
            <a href="#" id="canteen-guard">
                    <span class="material-icons-sharp">
                        restaurant
                    </span>
                <h3>食堂维护</h3>
            </a>
            <a href="#" id="dishes-guard">
                    <span class="material-icons-sharp">
                        ramen_dining
                    </span>
                <h3>菜品维护</h3>
            </a>
            <a href="#" id="canteen-comments">
                    <span class="material-icons-sharp">
                        comment
                    </span>
                <h3>食堂评价</h3>
            </a>
</c:if>

            <a href="logout" id="logout">
                    <span class="material-icons-sharp">
                        logout
                    </span>
                <h3>退出登陆</h3>
            </a>
        </div>
    </aside>
    <!-- End of Sidebar Section -->

    <!-- Main Content -->
    <div class="main-wrapper">


        <main id="personal-info-main">
            <h1>个人信息</h1>
            <div class="function">
                <form action="${pageContext.request.contextPath}/modifyProfile?activeBar=personal-info" method="post" class="switch">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>用户名</h3>
                            <input type="text" name="userName" placeholder="用户名" value="${user.userName}" readonly>
                            </p>
                            <p>
                            <h3>用户类型</h3>
                            <input type="text" name="userIdentity" value="${user.userIdentity}" readonly class="cannot-modify">
                            </p>
                        </div>
                        <div class="split">

                            <p>
                            <h3>性别</h3>
                            <input type="text" name="userGender" placeholder="性别" value="${user.userGender}" readonly>
                            </p>
                            <p>
                            <h3>年龄</h3>
                            <input type="text" name="userAge" placeholder="年龄" value="${user.userAge}" readonly>
                            </p>

                        </div>
                        <div class="align-center"><div class="split">
                            <button type="button" class="modify">修改</button>
                            <button type="submit" class="submit" style="display: none;">提交修改</button>
                        </div></div>
                    </div>
                </form>
            </div>
            <h2>修改密码</h2>

            <div class="function">
                <form action="${pageContext.request.contextPath}/modifyPsw?activeBar=personal-info" method="post">
                    <div class="two-split">
                        <div class="split">
                            <p>
                            <h3>旧密码</h3>
                            <input type="password" name="oldPsw" placeholder="旧密码">
                            </p>
                            <p>
                            <h3>新密码</h3>
                            <input type="password" name="newPsw" placeholder="新密码">
                            </p>
                            <p>
                            <h3>新密码</h3>
                            <input type="password" name="newPswRepeat" placeholder="确认密码">
                            </p>
                        </div>
                        <div class="align-center"><div class="split">
                            <button type="submit" class="submit">提交修改</button>
                        </div></div>
                    </div>
                </form>
            </div>

        </main>

        <main id="canteen-info-main">
            <h1>食堂信息管理</h1>
            <div class="recent-orders">
                <table>
                    <thead>
                    <tr>
                        <th>食堂名</th>
                        <th>食堂位置</th>
                    </tr>
                    </thead>
                    <tbody>
<c:forEach items="${canteenList}" var="canteen">
                    <tr class="canteen-tr"
                        cid="${canteen.canteenId}"
                        cname="${canteen.canteenName}"
                        clocation="${canteen.canteenLocation}"
                        cabstract="${canteen.canteenAbstract}"
                        cpic="${canteen.canteenPic}">
                        <td>${canteen.canteenName}</td>
                        <td>${canteen.canteenLocation}</td>
                    </tr>
</c:forEach>
                    </tbody>
                </table>
            </div>


            <h2>食堂信息</h2>
            <div class="function">
                <form class="switch" action="${pageContext.request.contextPath}/adminServlet?type=modifyCanteen&activeBar=canteen-info" enctype="multipart/form-data" method="post">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>食堂名</h3>
                            <input type="text" name="canteenName" readonly>
                            </p>
                            <p>
                            <h3>食堂位置</h3>
                            <input type="text" name="canteenLocation" readonly>
                            </p>
                            <p>
                            <h3>食堂简介</h3>
                            <textarea name="canteenAbstract" rows="4" readonly></textarea>
                            </p>
                            <h3>食堂管理者</h3>
                            <p class="input-like"></p>
                        </div>
                        <div class="split">
                            <p>
                            <h3>食堂照片</h3>
                            <input type="file" name="file" accept="image/*" class="img-upload" readonly disabled>
                            <img src="" basesrc="${pageContext.request.contextPath}/data/canteen_pics/">
                            </p>
                        </div>
                        <div class="align-center"><div class="split">
                            <button type="button" class="modify">修改</button>
                            <button type="submit" name="action" value="modify" class="submit" style="display: none;">提交修改</button>
                            <br><br>
                            <button type="submit" name="action" value="delete" class="delete" style="display: none;">确认删除</button>
                        </div></div>
                    </div>
                    <input type="hidden" name="canteenId">
                    <input type="hidden" name="canteenPic">
                </form>
            </div>


            <h2>添加食堂</h2>
            <div class="function">
                <form action="${pageContext.request.contextPath}/adminServlet?type=addCanteen&activeBar=canteen-info" enctype="multipart/form-data" method="post">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>食堂名</h3>
                            <input type="text" name="canteenName" placeholder="食堂名">
                            </p>
                            <p>
                            <h3>食堂位置</h3>
                            <input type="text" name="canteenLocation" placeholder="食堂位置">
                            </p>
                            <p>
                            <h3>食堂简介</h3>
                            <textarea name="canteenAbstract" placeholder="食堂简介" rows="4"></textarea>
                            </p>
                        </div>
                        <div class="split">
                            <p>
                            <h3>食堂照片</h3>
                            <input type="file" name="file" accept="image/*" class="img-upload">
                            <img src="">
                            </p>
                        </div>
                        <div class="align-center"><div class="split">
                            <button type="submit" class="submit">添加</button>
                        </div></div>
                    </div>
                </form>
            </div>
        </main>

        <main id="accounts-manage-main">
            <h1>账号信息管理</h1>
            <div class="recent-orders">
                <table>
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>身份</th>
                        <th>食堂管理</th>
                        <th>性别</th>
                        <th>年龄</th>
                    </tr>
                    </thead>
                    <tbody>
<c:forEach items="${userList}" var="account">
                        <tr class="account-tr"
                            uid="${account.id}"
                            uname="${account.userName}"
                            upassword="${account.userPassword}"
                            uidentity="${account.userIdentity}"
                            ugender="${account.userGender}"
                            uage="${account.userAge}"
                            ucanteen="${mcMap[account.userName].canteenName}">
                            <td>${account.userName}</td>
                            <td>${account.userIdentity}</td>
                            <td>${mcMap[account.userName].canteenName}</td>
                            <td>${account.userGender}</td>
                            <td>${account.userAge}</td>
                        </tr>
</c:forEach>
                    </tbody>
                </table>
            </div>

            <h2>账号信息</h2>
            <div class="function">
                <form class="switch" action="activeBar=accounts-manage">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>用户名</h3>
                            <input type="text" name="userName" readonly>
                            </p>
                            <p>
                            <h3>用户密码</h3>
                            <input type="text" name="userPassword" readonly>
                            </p>
                            <p>
                            <h3>用户类型</h3>
                            <input type="text" name="userIdentity" readonly>
                            </p>
                        </div>
                        <div class="split">

                            <p>
                            <h3>性别</h3>
                            <input type="text" name="userGender" readonly>
                            </p>
                            <p>
                            <h3>年龄</h3>
                            <input type="text" name="userAge" readonly>
                            </p>
                            <p>
                            <h3>管理食堂</h3>
                            <input type="text" name="userManagement" readonly>
                            </p>

                        </div>
                        <div class="align-center"><div class="split">
                            <button type="button" class="modify">修改</button>
                            <button type="submit" name="action" value="modify" class="submit" style="display: none;">提交修改</button>
                            <br><br>
                            <button type="submit" name="action" value="delete" class="delete" style="display: none;">确认删除</button>
                        </div></div>
                    </div>
                    <input type="hidden" name="userId">
                </form>
            </div>


            <h2>分发管理员账号</h2>
            <div class="function">
                <form action="${pageContext.request.contextPath}/register.do?type=manager&activeBar=accounts-manage" class="switch" method="post">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>用户名</h3>
                            <input type="text" name="userName" placeholder="用户名">
                            </p>
                            <p>
                            <h3>用户密码</h3>
                            <input type="password" name="userPassword" placeholder="密码">
                            </p>
                            <h3>密码确认</h3>
                            <input type="password" name="userPasswordRepeat" placeholder="再次输入密码">
                            </p>
                            <p>
                            <h3>管理食堂</h3>
                            <input type="text" name="canteenName" placeholder="管理食堂">
                            </p>
                        </div>
                        <div class="split">

                            <p>
                            <h3>性别</h3>
                            <input type="text" name="userGender" placeholder="性别">
                            </p>
                            <p>
                            <h3>年龄</h3>
                            <input type="text" name="userAge" placeholder="年龄">
                            </p>

                        </div>
                        <div class="align-center"><div class="split">
                            <button type="submit" class="submit">添加</button>
                        </div></div>
                    </div>
                </form>
            </div>


        </main>

        <main id="canteen-guard-main">
            <h1>食堂信息维护</h1>
            <div class="function">
                <form class="switch" action="${pageContext.request.contextPath}/manager?type=modifyCanteen&activeBar=canteen-guard">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>食堂名</h3>
                            <input type="text" name="canteenName" value="${mcMap[user.userName].canteenName}" readonly>
                            </p>
                            <p>
                            <h3>食堂位置</h3>
                            <input type="text" name="canteenLocation" value="${mcMap[user.userName].canteenLocation}" readonly>
                            </p>
                            <p>
                            <h3>食堂简介</h3>
                            <textarea name="canteenAbstract" rows="4" readonly>${mcMap[user.userName].canteenAbstract}</textarea>
                            </p>
                            <h3>食堂管理者</h3>
                            <p class="input-like" cname="${mcMap[user.userName].canteenName}"></p>
                        </div>
                        <div class="split">
                            <p>
                            <h3>食堂照片</h3>
<%--                            <input type="file" name="file" accept="image/*" class="img-upload" readonly disabled>--%>
                            <img src="${pageContext.request.contextPath}/img/profile-1.jpg">
                            </p>
                        </div>
                        <div class="align-center"><div class="split">
                            <button type="button" class="modify">修改</button>
                            <button type="submit" name="action" value="modify" class="submit" style="display: none;">提交修改</button>
                            <br><br>
                            <button type="submit" name="action" value="delete" class="delete" style="display: none;">确认删除</button>
                        </div></div>
                    </div>
                    <input type="hidden" name="canteenId" value="${mcMap[user.userName].canteenId}">
                </form>
            </div>
        </main>

        <main id="dishes-guard-main">
            <h1>菜品信息维护</h1>
            <div class="recent-orders">
                <table>
                    <thead>
                    <tr>
                        <th>菜品名</th>
                        <th>菜系</th>
                        <th>价格</th>
                    </tr>
                    </thead>
                    <tbody>
<c:forEach items="${cdMap[mcMap[user.userName].canteenName]}" var="dishes">
                        <tr class="dishes-tr"
                            did="${dishes.dishId}"
                            dname="${dishes.dishName}"
                            dclass="${dishes.dishClass}"
                            dprice="${dishes.dishPrice}"
                            dinfo="${dishes.dishInfo}"
                            dcanteen="${dishes.dishCanteenId}"
                            dpic="${dishes.dishPic}">
                            <td>${dishes.dishName}</td>
                            <td>${dishes.dishClass}</td>
                            <td>${dishes.dishPrice}</td>
                        </tr>
</c:forEach>
                    </tbody>
                </table>
            </div>

            <h2>菜品信息</h2>
            <div class="function">
                <form class="switch" action="${pageContext.request.contextPath}/manager?type=modifyDish&activeBar=dishes-guard" method="post" enctype="multipart/form-data">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>菜品名</h3>
                            <input type="text" name="dishName" readonly>
                            </p>
                            <p>
                            <h3>菜系</h3>
                            <input type="text" name="dishClass" readonly>
                            </p>
                            <p>
                            <h3>价格</h3>
                            <input type="text" name="dishPrice" readonly>
                            </p>
                            <p>
                            <h3>简介</h3>
                            <textarea name="dishInfo" rows="4" readonly></textarea>
                            </p>
                        </div>
                        <div class="split">

                            <p>
                            <h3>菜品图片</h3>
                            <input type="file" name="file" accept="image/*" class="img-upload" readonly disabled>
                            <img src="" basesrc="${pageContext.request.contextPath}/data/dish_pics/">
                            </p>

                        </div>
                        <div class="align-center"><div class="split">
                            <button type="button" class="modify">修改</button>
                            <button type="submit" name="action" value="modify" class="submit" style="display: none;">提交修改</button>
                            <br><br>
                            <button type="button" name="action" value="delete" class="delete" style="display: none;">确认删除</button>
                        </div></div>
                    </div>
                    <input type="hidden" name="dishId">
                    <input type="hidden" name="dishPic">
                </form>
            </div>

            <h2>添加菜品</h2>
            <div class="function">
                <form action="${pageContext.request.contextPath}/manager?type=newDish&activeBar=dishes-guard" method="post" enctype="multipart/form-data">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>菜品名</h3>
                            <input type="text" name="dishName" placeholder="菜品名">
                            </p>
                            <p>
                            <h3>菜系</h3>
                            <input type="text" name="dishClass" placeholder="菜系">
                            </p>
                            <p>
                            <h3>价格</h3>
                            <input type="text" name="dishPrice" placeholder="价格">
                            </p>
                            <p>
                            <h3>简介</h3>
                            <textarea name="dishInfo" rows="4" placeholder="简介"></textarea>
                            </p>
                        </div>
                        <div class="split">

                            <p>
                            <h3>菜品图片</h3>
                            <input type="file" name="file" accept="image/*" class="img-upload">
                            <img src="">
                            </p>

                        </div>
                        <div class="align-center"><div class="split">
                            <button type="submit" class="submit">添加</button>
                        </div></div>
                    </div>
                </form>
            </div>

        </main>

        <main id="dishes-search-main">
            <h1>菜品检索</h1>
            <div class="function">
                <form class="check" action="dishes-search">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>检索框</h3>
                            <input type="text" name="checkbox">
                            </p>
                        </div>
                        <div class="split">
                            <p>
                            <h3>按菜系/价格/食堂检索</h3>
                            <input type="text" name="checkby">
                            </p>
                        </div>
                        <div class="align-center"><div class="split">
                            <button type="button" class="check-in">检索</button>
                        </div></div>
                    </div>
                </form>
                <div class="user-list">
<c:forEach items="${dishesList}" var="dishes">
                    <div class="user"
                         did="${dishes.dishId}"
                         dname="${dishes.dishName}"
                         dclass="${dishes.dishClass}"
                         dprice="${dishes.dishPrice}"
                         dinfo="${dishes.dishInfo}"
                         dcanteen="${dishes.dishCanteenId}"
                         dpic="${dishes.dishPic}">
                        <img src="${pageContext.request.contextPath}/data/dish_pics/${dishes.dishPic}">
                        <h2>${dishes.dishName}</h2>
                        <p>${dishes.dishPrice} 元</p>
                    </div>
</c:forEach>
                </div>
            </div>

            <form action="dishes-search" class="info-display">
            <h2>菜品信息</h2>
                <div class="function">
                    <div class="two-split">
                        <div class="split">
                            <h3>菜品名</h3>
                            <p class="input-like"></p>
                            <h3>菜系</h3>
                            <p class="input-like"></p>
                            <h3>价格</h3>
                            <p class="input-like"></p>
                            <h3>简介</h3>
                            <p class="input-like"></p>
                        </div>
                        <div class="split">
                            <h3>菜品图片</h3>
                            <img src="" basesrc="${pageContext.request.contextPath}/data/dish_pics/">
                        </div>
                    </div>
                </div>

            <h2>评价</h2>
            <div class="function">
                <p>
                <textarea name="comments" rows="4" readonly></textarea>
                </p>
            </div>
                <input type="hidden" name="dishId">
            </form>

        </main>

        <main id="canteen-search-main">
            <h1>食堂检索</h1>
            <div class="function">
                <form class="check" action="canteen-search">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>检索框</h3>
                            <input type="text" name="checkbox">
                            </p>
                        </div>
                        <div class="split">
                            <p>
                            <h3>按菜系/价格/食堂检索</h3>
                            <input type="text" name="checkby">
                            </p>
                        </div>
                        <div class="align-center"><div class="split">
                            <button type="button" class="check-in">检索</button>
                        </div></div>
                    </div>
                </form>
                <div class="user-list">
<c:forEach items="${canteenList}" var="canteen">
                    <div class="user"
                         cid="${canteen.canteenId}"
                         cname="${canteen.canteenName}"
                         clocation="${canteen.canteenLocation}"
                         cabstract="${canteen.canteenAbstract}"
                         cpic="${canteen.canteenPic}">
                        <img src="${pageContext.request.contextPath}/data/canteen_pics/${canteen.canteenPic}">
                        <h2>${canteen.canteenName}</h2>
                        <p>${canteen.canteenLocation}</p>
                    </div>
</c:forEach>
                </div>
            </div>

            <form action="canteen-search" class="info-display">
                <h2>食堂信息</h2>
                <div class="function">
                    <div class="two-split">
                        <div class="split">
                            <h3>食堂名</h3>
                            <p class="input-like"></p>
                            <h3>食堂位置</h3>
                            <p class="input-like"></p>
                            <h3>食堂简介</h3>
                            <p class="input-like"></p>
                        </div>
                        <div class="split">
                            <h3>食堂照片</h3>
                            <img src="" basesrc="${pageContext.request.contextPath}/data/canteen_pics/">
                        </div>
                    </div>
                </div>

            <h2>评价</h2>
            <div class="function">
                <p>
                    <textarea name="comments" rows="4" readonly></textarea>
                </p>
            </div>
            <input type="hidden" name="dishId">
            </form>


        </main>

    </div>
    <!-- End of Main Content -->

    <!-- Right Section -->
    <div class="right-section">
        <div class="nav">
            <button id="menu-btn">
                    <span class="material-icons-sharp">
                        menu
                    </span>
            </button>
            <div class="dark-mode">
                    <span class="material-icons-sharp active">
                        light_mode
                    </span>
                <span class="material-icons-sharp">
                        dark_mode
                    </span>
            </div>

            <div class="profile">
                <div class="info">
                    <p>Hey, <b>${user.userName}</b></p>
                    <small class="text-muted">${user.userIdentity}</small>
                </div>
                <div class="profile-photo">
                    <img src="${pageContext.request.contextPath}/img/profile-1.jpg">
                </div>
            </div>

        </div>
        <!-- End of Nav -->

        <div class="user-profile">
            <div class="logo">
                <img src="${pageContext.request.contextPath}/img/logo.png">
                <h2>上理食堂社区</h2>
                <p>一站式就餐信息查询</p>
            </div>
        </div>

        <div class="reminders">
            <div class="header">
                <h2>今日特惠</h2>
                <span class="material-icons-sharp">
                        notifications_none
                    </span>
            </div>

            <div class="notification">
                <div class="icon">
                        <span class="material-icons-sharp">
                            volume_up
                        </span>
                </div>
                <div class="content">
                    <div class="info">
                        <h3>番茄鸡蛋</h3>
                        <small class="text_muted">
                            四餐厅
                        </small>
                    </div>
                    <span class="material-icons-sharp">
                            more_vert
                        </span>
                </div>
            </div>

            <div class="notification deactive">
                <div class="icon">
                        <span class="material-icons-sharp">
                            edit
                        </span>
                </div>
                <div class="content">
                    <div class="info">
                        <h3>猪脚饭</h3>
                        <small class="text_muted">
                            第五食堂
                        </small>
                    </div>
                    <span class="material-icons-sharp">
                            more_vert
                        </span>
                </div>
            </div>

            <!--                <div class="notification add-reminder">-->
            <!--                    <div>-->
            <!--                        <span class="material-icons-sharp">-->
            <!--                            add-->
            <!--                        </span>-->
            <!--                        <h3>Add Reminder</h3>-->
            <!--                    </div>-->
            <!--                </div>-->

        </div>

    </div>


</div>

<script src="${pageContext.request.contextPath}/js/dashboard.js"></script>

<%--刷新回到定位--%>
<script>
    active ( document.getElementById("${empty activeBar ? 'dashboard' : activeBar}") )
</script>

</body>

</html>
