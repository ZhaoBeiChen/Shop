<%--
  Created by IntelliJ IDEA.
  User: asus-pc
  Date: 2016/12/3
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.*" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上面3个meta标签必须置于最上面 -->

    <title>Shop</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/cssOfIndex.css">
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
<% request.getSession().setAttribute("NowPage", "index"); %>
<% request.getSession().setAttribute("shopClass", "all");%>
<%
    if(request.getSession().getAttribute("status") == null) {
        request.getSession().setAttribute("status", "no");
    }
%>
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
        <a style="margin-left: 80px" href="PersonalInfo.jsp" ><%=userName%></a>
        <a style="margin-left: 5px" href="ShopCar.jsp" >ShopCar</a>
        <a style="margin-left: 5px" href="controller/Logout" methods="get">Logout</a>
            <%}
            else {
                %>
        <a style="margin-left: 150px" href="Login.jsp" >Login</a>
        <%
            }
            %>
    </div>
    <div class="bg_03">

    </div>
    <div class="bg_04" >
        <div class="bg_04_01" style="float: left; margin-left: 25px; margin-top: 25px">

        </div>
        <div class="bg_04_01" style="margin-left: 487.5px; margin-top: 25px">

        </div>
        <div class="bg_04_01" style="float: left; margin-left: 25px; margin-top: 25px">

        </div>
        <div class="bg_04_01" style="margin-left: 487.5px; margin-top: 25px">

        </div>
    </div>
    <div class="bg_05">

    </div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
