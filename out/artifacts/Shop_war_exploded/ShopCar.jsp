<!--<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>-->
<!--<%-->
<!--String path = request.getContextPath();-->
<!--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";-->
<!--%>-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My ShopCar</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <link rel="stylesheet" type="text/css" href="css/cssOfIndex.css">
	  <link rel="stylesheet" type="text/css" href="css/cssOfShopCar.css">
	  <!-- ? Bootstrap ?? CSS ?? -->
	  <link rel="stylesheet" href="css/bootstrap.min.css">

	  <!-- ???Bootstrap???????????? -->
	  <link rel="stylesheet" href="css/bootstrap-theme.min.css">

	  <!-- jQuery??????bootstrap.min.js ???? -->
	  <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

	  <!-- ??? Bootstrap ?? JavaScript ?? -->
	  <script src="js/bootstrap.min.js"></script>

	  <!-- ? Bootstrap ?? CSS ?? -->
	  <link rel="stylesheet" href="css/bootstrap.min.css">

  </head>
  
  <body>
    <div class="bg_01">
		<div class="bg_02">
			<p class="header">GameShop</p>
			<button type="button" class="bg_02_bt" style="margin-left: 150px">Home</button>
			<button type="button" class="bg_02_bt">Mall</button>
			<button type="button" class="bg_02_bt">Category</button>
			<button type="button" class="bg_02_bt">Activity</button>
			<button type="button" class="bg_02_bt">About</button>
			<button type="button" class="bg_02_bt" style="margin-left: 150px">Login</button>
		</div>
		<div class="car_bg_01">
			<div class="car_bg_03">
				<p class="car_bg_03_header">ShopCar</p>
			</div>
		</div>
		<div class="car_bg_02">

		</div>
	</div>
  </body>
</html>
