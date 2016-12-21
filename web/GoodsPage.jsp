<%@ page import="model.struct.Goods" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8"  language="java" %>
<!DOCTYPE html>
<html lang="ZN-ch">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上面3个meta标签必须置于最上面 -->

    <title>GoodsPage</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/cssOfIndex.css">
    <link rel="stylesheet" type="text/css" href="css/cssOfGoodsPage.css">

</head>    <!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<body>
<div class="bg_01">
    <div class="bg_02">
        <p class="header">Shop</p>
        <button type="button" class="bg_02_bt" style="margin-left: 150px" onclick="javascript:window.location.href='index.jsp'">Home</button>
        <button type="button" class="bg_02_bt">Mall</button>
        <button type="button" class="bg_02_bt">Category</button>
        <button type="button" class="bg_02_bt">Activity</button>
        <button type="button" class="bg_02_bt">About</button>
        <% String userName = (String) session.getAttribute("userName");
        String status = (String) session.getAttribute("status");
        if(userName != null && status.equals("yes")){
        %>
        <a style="margin-left: 140px" href="PersonalInfo.jsp" ><%=userName%></a>
        <a>Logout</a>
        <%}
        else {
        %>
        <a style="margin-left: 150px" href="Login.jsp" >Login</a>
        <%
        }
        %>

    </div>
    <div class="goodsPage_01">
        <p class="goodsCategory">ALL</p>
        <p class="goodsCategory">FPS</p>
        <p class="goodsCategory">Role play</p>
    </div>
    <div class="goodsPage_02">
        <% Goods goods = new Goods();
            ArrayList<Goods> allGoods;
            allGoods = goods.getAllGoods();
            for(int i=0; i<allGoods.size(); i++){
                System.out.println(allGoods.get(i).getGoodsID());
        %>
        <div class="goods" style="background-image: url(<%=allGoods.get(i).getGoodsURL()%>)">
            <div class="goodsHeader">
                <p class="goodsHeadertext"><a href="#"><%=allGoods.get(i).getGoodsID()%></a></p>
            </div>
        </div>
        <%
            }
        %>

    </div>
    <div class="bg_05">

    </div>
</div>
</body>
</html>