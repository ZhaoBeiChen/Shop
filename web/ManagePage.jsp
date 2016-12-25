<%@ page import="model.struct.Goods" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.struct.User" %>
<!--Created by IntelliJ IDEA.-->
  <!--User: asus-pc-->
  <!--Date: 2016/12/23-->
  <!--Time: 15:46-->
  <!--To change this template use File | Settings | File Templates.-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% request.getSession().setAttribute("NowPage","ManagePage"); %>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Manage</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" type="text/css" href="css/cssOfIndex.css">
  <link rel="stylesheet" type="text/css" href="css/cssOfGoodsPage.css">

  <link rel="stylesheet" href="css/bootstrap.min.css">


  <link rel="stylesheet" href="css/bootstrap-theme.min.css">


  <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>


  <script src="js/bootstrap.min.js"></script>


  <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="bg_01">
  <div class="bg_02">
    <p class="header">GameShop</p>
    <button type="button" class="bg_02_bt" style="margin-left: 150px" onclick="javascript:window.location.href='ManagePage.jsp'">Manage</button>
    <a style="margin-left: 500px;" href="controller/Logout" methods="get">Logout</a>

  </div>
  <div class="goodsPage_01">
    <form action="controller/manage/M_DelShopClass" method="get">
      <input type="hidden" name="class_0" value="user"/>
      <input type="submit" class="goodsCategory" value="User"/>
    </form>
    <form action="controller/manage/M_DelShopClass" method="get">
      <input type="hidden" name="class_0" value="goods"/>
      <input type="submit" style="margin-top: 6px" class="goodsCategory" value="Goods" />
    </form>
  </div>
  <div class="goodsPage_02">
    <% User user = new User();
    Goods good = new Goods();
      ArrayList<User> userlist = new ArrayList<User>();
      ArrayList<Goods> goodslist = new ArrayList<Goods>();
      int size = 0;
    String classes = (String)session.getAttribute("shopClass");
    if(classes!=null) {
    if ( !classes.equals("user")) {
      goodslist = good.getAllGoods();
      size = goodslist.size();
    } else {
      userlist = user.getUserList();
      size = userlist.size();
    }
    }
    else {
      userlist = user.getUserList();
      size = userlist.size();
    }
    for(int i=0; i<size; i++){
    %>
    <div class="goods">
      <div class="goodsHeader">
        <form action="controller/manage/DelManageInfo" method="get">
          <% if(classes.equals("goods")) {%><input type="hidden" name="thing_id" value="<%=goodslist.get(i).getGoodsID() %>" /><%}%>
          <% if (classes.equals("user")) {%><input type="hidden" name="thing_id" value="<%=userlist.get(i).getUserID() %>" /><%}%>
          <input type="submit" class="goodsHeadertext" <% if(classes.equals("user")){ %> value="<%=userlist.get(i).getUserID()%>" <% } else { %> value="<%=goodslist.get(i).getGoodsID()%>" <% } %>/>
        </form>
      </div>
    </div>
    <%
    }
    %>

  </div>
</div>
</body>
</html>
