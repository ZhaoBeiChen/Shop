<%--
  Created by IntelliJ IDEA.
  User: asus-pc
  Date: 2016/12/26
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ResetPassword</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/cssOfIndex.css">
    <link rel="stylesheet" type="text/css" href="css/cssOfPersonalInfoChange.css">
    <link rel="stylesheet" type="text/css" href="css/cssOfShopCar.css">
    <link rel="stylesheet" type="text/css" href="css/cssOfShopCar.css">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
<div class="bg_01">
    <div class="bg_02">
        <p class="header">GameShop</p>
        <button type="button" class="bg_02_bt" style="margin-left: 150px" onclick="javascript:window.location.href='index.jsp'">Home</button>
        <button type="button" class="bg_02_bt" onclick="javascript:window.location.href='GoodsPage.jsp'">Mall</button>
        <button type="button" class="bg_02_bt">Category</button>
        <button type="button" class="bg_02_bt">Activity</button>
        <button type="button" class="bg_02_bt">About</button>
        <% String userName = (String) session.getAttribute("userName");
            String status = (String) session.getAttribute("status");
            if(userName != null && status.equals("yes")){
        %>
        <a style="margin-left: 80px;" href="PersonalInfo.jsp" ><%=userName%></a>
        <a style="margin-left: 5px;"  href="ShopCar.jsp" >ShopCar</a>
        <a style="margin-left: 5px" href="controller/Logout" methods="get">Logout</a>
        <%}
        else {
        %>
        <a style="margin-left: 150px" href="Login.jsp" >Login</a>
        <%
            }
        %>
    </div>
    <div class="InfoChange_bg_01" style="height: 550px">
        <form action="controller/ResetPassword" method="post">
            <p class="InfoChange_header" style="width: 150px; margin-left: 40px; clear: both"><font color="gray">New PassWord:</font></p>
            <input class="InfoChange_text" name="resetNewPasswd"  style="margin-top: 50px; margin-left: 10px" type="password" />
            <p class="InfoChange_header" style="width: 180px; margin-left: 10px; clear: left"><font color="gray">Confirm PassWord:</font></p>
            <input class="InfoChange_text" name="resetConfirmPasswd" value="" style="margin-top: 50px; margin-left: 10px;" type="password" />
            <input class="InfoChange_but" style="margin-left: 40px" type="submit" value="Confirm" />
        </form>
    </div>
    <div class="car_bg_02" style="margin-top: 200px; margin-left: -3px">

    </div>
</div>

</body>
</html>
