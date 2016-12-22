<!--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>-->
<%@ page import="java.lang.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <meta charset="utf-8">
    <title>Personal Information</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <link rel="stylesheet" type="text/css" href="css/cssOfIndex.css">
	  <link rel="stylesheet" type="text/css" href="css/cssOfPersonalInfo.css">
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
		<div class="car_bg_01">
			<div class="PersonalInfo_bg_01" style="height: 250px; margin-top: 100px">
				<div class="personalinfo_headimg">

				</div>
				<p class="PersonalInfo_info"><font color="gray">UserName:</font><%=session.getAttribute("userName")%></p>
				<p class="PersonalInfo_info"><font color="gray">Gender:</font><%=session.getAttribute("sex")%></p>
				<p class="PersonalInfo_info"><font color="gray">Phone:</font><%=session.getAttribute("phone")%></p>
				<p class="PersonalInfo_info"><font color="gray">Email:</font><%=session.getAttribute("email")%></p>
				<p class="PersonalInfo_info"><font color="gray">Address:</font><%=session.getAttribute("address")%></p>
			</div>
			<div class="personalinfo_bg_01" style="height: 150px; margin-top: 25px">
				<p class="PersonalInfo_OrderHeader">My Order</p>
				<div class="PersonalInfo_OrderSum"></div>
				<div class="PersonalInfo_OrderSum"></div>
				<div class="PersonalInfo_OrderSum"></div>
			</div>
			<div class="personalinfo_bg_01" style="height: 50px; margin-top: 25px">

			</div>

		</div>
		<div class="car_bg_02">

		</div>
	</div>
  </body>
</html>
