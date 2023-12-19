<%--
  Created by IntelliJ IDEA.
  User: rlagofla
  Date: 12/19/23
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a href="#" id="canteen-info">
                    <span class="material-icons-sharp">
                        restaurant
                    </span>
                <h3>食堂信息</h3>
            </a>
            <a href="#" id="accounts-manage">
                    <span class="material-icons-sharp">
                        manage_accounts
                    </span>
                <h3>账号管理</h3>
            </a>
            <a href="#" id="community">
                    <span class="material-icons-sharp">
                        forum
                    </span>
                <h3>社区管理</h3>
            </a>
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
                <form action="${pageContext.request.contextPath}/modifyProfile" method="post" class="personal-info-profile">
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>用户名</h3>
                            <input type="text" name="userName" placeholder="用户名" value="${user.userName}" readonly>
                            </p>
                            <p>
                            <h3>用户类型</h3>
                            <input type="text" name="userIdentity" value="${user.userIdentity}" readonly id="cannot-modify">
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
                <form action="${pageContext.request.contextPath}/modifyPsw" method="post">
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
                        <th>Payment</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                        <td>5</td>
                    </tr>
                    </tbody>
                </table>
                <a href="#">Show All</a>
            </div>

            <h2>添加食堂</h2>
            <div class="function">
                <form>
                    <div class="three-split">
                        <div class="split">
                            <p>
                            <h3>食堂名</h3>
                            <input type="text" name="userName" placeholder="食堂名">
                            </p>
                            <p>
                            <h3>食堂位置</h3>
                            <input type="text" name="userPassword" placeholder="食堂位置">
                            </p>
                            <p>
                        </div>
                        <div class="split">
                            <p>
                            <h3>食堂简介</h3>
                            <textarea id="message" name="message" rows="4"></textarea>
                            </p>
                            <p>
                        </div>
                        <div class="align-center"><div class="split">
                            <button type="submit" class="submit">添加</button>
                        </div></div>
                    </div>
                </form>
            </div>
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
</body>

</html>
