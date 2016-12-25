<%--
  Created by IntelliJ IDEA.
  User: asus-pc
  Date: 2016/12/23
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>PersonalInfoChange</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/cssOfIndex.css">
    <link rel="stylesheet" type="text/css" href="css/cssOfPersonalInfoChange.css">
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
<% request.getSession().setAttribute("NowPage","PersonalInfo"); %>
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
    <div class="InfoChange_bg_01">
        <%
            String userID = (String)request.getSession().getAttribute("userName");
            String sex = (String)request.getSession().getAttribute("sex");
            long phone = Long.parseLong(request.getSession().getAttribute("phone").toString());
            String email = (String)request.getSession().getAttribute("email");
            String address =(String) request.getSession().getAttribute("address");
        %>
        <div class="InfoChange_img" style="background-image: url(resource/defaultUserHead.jpg)">

        </div>
        <form action="controller/DelPersonalInfoChange" method="post">
            <p class="InfoChange_text"><font color="gray">UserID:</font><%=userID%></p>
            <input type="hidden" name="infoChange_userID" value=""/>
            <p class="InfoChange_header" style="clear: both"><font color="gray">Sex:</font></p>
            <input class="InfoChange_text" name="infoChange_sex" value="male" style="margin-top: 50px; width: 150px" type="radio" <% if(sex.equals("Male")) {  %> checked="checked" <%  } %> /><p class="InfoChange_text" style="width: 40px; margin-left: 0px; margin-top: 48px; border: none">Male</p>
            <input class="InfoChange_text" name="infoChange_sex" value="female" style="margin-top: 50px; width: 150px; margin-left: 20px" type="radio" <% if(sex.equals("Female")) {  %> checked="checked" <%  } %> /><p class="InfoChange_text" style="width: 45px; margin-left: 0px; margin-top: 48px; border: none">Female</p>
            <p class="InfoChange_header"  style="clear: both"><font color="gray">Phone:</font></p>
            <input class="InfoChange_text" name="infoChange_phone" value="<%=phone%>" style="margin-top: 50px;" type="tel" />
            <p class="InfoChange_header" style="clear: both"><font color="gray">Email:</font></p>
            <input class="InfoChange_text" name="infoChange_email" value="<%=email%>" style="margin-top: 50px;" type="email" />
            <p class="InfoChange_header" style="clear: both"><font color="gray">Address:</font></p>
            <input class="InfoChange_text" name="infoChange_address" value="<%=address%>" style="margin-top: 50px;" type="text" />
            <input class="InfoChange_but" type="submit" value="ConFirm The Change" />
        </form>
    </div>
    <div class="car_bg_02" style="margin-top: 150px; margin-left: -3px">

    </div>
</div>

</body>
</html>
