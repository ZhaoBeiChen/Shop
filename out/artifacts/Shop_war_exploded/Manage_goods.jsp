<%@ page import="model.struct.Goods" %><%--
  Created by IntelliJ IDEA.
  User: asus-pc
  Date: 2016/12/26
  Time: 17:11
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
<% request.getSession().setAttribute("NowPage","ManagePage"); %>
<body>
<div class="bg_01">
    <div class="bg_02">
        <p class="header">GameShop</p>
        <button type="button" class="bg_02_bt" style="margin-left: 150px" onclick="javascript:window.location.href='ManagePage.jsp'">Manage</button>
        <a style="margin-left: 500px" href="controller/Logout" methods="get">Logout</a>
    </div>
    <div class="InfoChange_bg_01">
        <%
            String goodsID = (String)request.getSession().getAttribute("thingID");
            Goods good = new Goods();
            good = good.getGoodsInfo(goodsID);
            String classes = good.getClassID();
            if(classes.equals("fps")){
                classes = "FPS";
            }
            else {
                classes = "RolePlay";
            }
            String url = good.getGoodsURL();
            double price = good.getPrice();
            String introduce = good.getGoodsIntrduce();
        %>
        <div class="InfoChange_img" style="background-image: url(<%=good.getGoodsURL()%>_small.jpg); width: 80px; height: 80px">

        </div>
        <form action="controller/manage/M_DelGoodsInfoChange" method="post">
            <p class="InfoChange_text"><font color="gray">GoodsID:</font><%=goodsID%></p>
            <input type="hidden" name="M_infoChange_goodsID" value="<%=goodsID%>"/>
            <p class="InfoChange_header" style="clear: both"><font color="gray">Type:</font></p>
            <input class="InfoChange_text" name="M_infoChange_classes" value="fps" style="margin-top: 50px; width: 150px" type="radio" <% if(classes.equals("FPS")) {  %> checked="checked" <%  } %> /><p class="InfoChange_text" style="width: 40px; margin-left: 0px; margin-top: 48px; border: none">FPS</p>
            <input class="InfoChange_text" name="M_infoChange_classes" value="roleplay" style="margin-top: 50px; width: 150px; margin-left: 20px" type="radio" <% if(classes.equals("RolePlay")) {  %> checked="checked" <%  } %> /><p class="InfoChange_text" style="width: 45px; margin-left: 0px; margin-top: 48px; border: none">RolePlay</p>
            <p class="InfoChange_header"  style="clear: both"><font color="gray">Price:</font></p>
            <input class="InfoChange_text" name="M_infoChange_price" value="<%=price%>" style="margin-top: 50px;" type="tel" />
            <p class="InfoChange_header" style="clear: both"><font color="gray">IMGurl:</font></p>
            <input class="InfoChange_text" name="M_infoChange_url" value="<%=url%>" style="margin-top: 50px;" type="text" />
            <p class="InfoChange_header" style="clear: both"><font color="gray">Introduce:</font></p>
            <input class="InfoChange_text" name="M_infoChange_introduce" value="<%=introduce%>" style="margin-top: 50px;" type="text" />
            <input class="InfoChange_but" style="margin-left: -40px" type="submit" value="ConFirm The Change" />
        </form>
        <form action="controller/manage/M_DelDeleteGoods" method="post">
            <input type="hidden" name="M_infoDelete_goodsid" value="<%=goodsID%>" />
            <input class="InfoChange_but" style="margin-left: 40px; background-color: #b92c28" type="submit" value="Delete This goods" />
        </form>
    </div>
    <div class="car_bg_02" style="margin-top: 150px; margin-left: -3px">

    </div>
</div>

</body>
</html>
