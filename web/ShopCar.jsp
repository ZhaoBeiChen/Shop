<%@ page contentType="text/html; charset=UTF-8" import="java.util.*"  language="java" %>
<%@ page import="model.struct.ShopCar" %>
<%@ page import="model.struct.Goods" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My ShopCar</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <link rel="stylesheet" type="text/css" href="css/cssOfIndex.css">
	  <link rel="stylesheet" type="text/css" href="css/cssOfShopCar.css">
	  <!-- ? Bootstrap ?? CSS ?? -->
	  <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css">

	  <!-- ???Bootstrap???????????? -->
	  <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap-theme.min.css">

	  <!-- jQuery??????bootstrap.min.js ???? -->
	  <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

	  <!-- ??? Bootstrap ?? JavaScript ?? -->
	  <script src="${ pageContext.request.contextPath }/js/bootstrap.min.js"></script>

	  <!-- ? Bootstrap ?? CSS ?? -->
	  <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/bootstrap.min.css">

  </head>
  
  <body>
  <% request.getSession().setAttribute("NowPage", "ShopCar"); %>
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
		<div class="car_bg_01">
			<div class="car_bg_03">
				<p class="car_bg_03_header">ShopCar</p>
			</div>
			<%
				String userID = (String)request.getSession().getAttribute("userName");
				ShopCar car = new ShopCar();
				Goods good = new Goods();
				ArrayList<ShopCar> carList = new ArrayList<ShopCar>();
				carList = car.getCarList(userID);
				for(int i=0; i<carList.size(); i++){
				    good = good.getGoodsInfo(carList.get(i).getGoodsID());
			%>
			<div class="car_item">
				<div class="car_item_img" style="background-image: url(<%=good.getGoodsURL()%>_small.jpg)"></div>
				<p class="car_item_header"><font color="gray">GameName:</font><%=carList.get(i).getGoodsID()%></p>
				<form action="controller/DelChangeShopCarNum" style="float:left;">
					<input type="hidden" name="shopcar_carid" value="<%=carList.get(i).getCarID()%>" />
					<input class="car_item_num" type="number" value="<%=carList.get(i).getNum()%>" min="0" max="99" name="shopcar_num" />
					<input class="car_item_num" style="width: 100px; background-color: #269abc" type="submit" value="Change" />
				</form>
				<form action="controller/DelDeleteShopCar">
					<input type="hidden" name="shopcar_carid" value="<%=carList.get(i).getCarID()%>" />
					<input class="car_item_num" style="width: 100px; background-color: #a94442" type="submit" value="Delete" />
				</form>
			</div>
			<%
				}
			%>
		</div>
		<div class="car_order_div">
			<p class="car_order_price"><font color="gray">TotalPrice:</font><%=car.totalprice(userID)%>￥</p>
			<form action="controller/DelPlaceTheOrder">
				<input type="hidden" name="shopcar_order" value="<%=userID%>" />
				<% if(car.ifCarEmpty(userID)){ %>
				<input type="submit" value="Place the order!" class="car_order_put" />
				<%
				}else {
				%>
				<input type="button" value="Place the order!" class="car_order_put"/>
				<%
					}
				%>
			</form>
		</div>
		<div class="car_bg_02">

		</div>
	</div>
  </body>
</html>
