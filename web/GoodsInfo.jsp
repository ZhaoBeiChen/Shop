<%@ page import="model.struct.Goods" %>
<%@ page contentType="text/html; charset=UTF-8"  language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上面3个meta标签必须置于最上面 -->

    <title>GoodsInfo</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/cssOfIndex.css">
    <link rel="stylesheet" type="text/css" href="css/cssOfGoodsInfo.css">
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
<% request.getSession().setAttribute("NowPage","GoodsInfo"); %>
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
        <a style="margin-left: 150px" href="PersonalInfo.jsp" ><%=userName%></a>
        <a style="margin-left: 5px" href="controller/Logout" methods="get">Logout</a>
        <%}
        else {
        %>
        <a style="margin-left: 150px" href="Login.jsp" >Login</a>
        <%
        }
        %>
    </div>
    <% String goodsid = (String)request.getSession().getAttribute("goodsID");
        Goods good= new Goods();
        good = good.getGoodsInfo(goodsid);
    %>
    <div class="GoodsInfo_bg">
        <div class="GoodsInfo_Image" style="background-image:url(<%=good.getGoodsURL()%>_big.jpg); float: left">

        </div>
        <p class="GoodsInfo_Infos" style="margin-top: 48px"><font color="gray">GameName:</font><%=good.getGoodsID()%></p>
        <p class="GoodsInfo_Infos"><font color="gray">GameType:</font><%=good.getClassID()%></p>
        <p class="GoodsInfo_Infos"><font color="gray">Price:</font><%=good.getPrice()%>￥</p>
        <form action="controller/DelAddShopCar" method="post" name="addToCar">
            <input type="hidden" name="goodsInfo_goodsid" value="<%=good.getGoodsID()%>" />
            <input type="number" class="GoodsInfo_num" value="0" min="0" max="99" name="goodsInfo_num"/>
            <input type="submit" value="Add to ShopCar" class="GoodsInfo_addButton"/>
        </form>
        <p class="GoodsInfo_Infos" style="clear: both; text-align: left"><font color="gray">Date Issued:</font><%=good.getAddDate()%></p>
        <p class="GoodsInfo_Infos" style="width: 800px; height: 100px; text-align: left"><font color="gray">Goods Description:</font><%=good.getGoodsIntrduce()%></p>
    </div>
    <div class="bg_05" style="margin-top: 180px">

    </div>
</div>
</body>
</html>