<!--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>-->
<!--<%-->
<!--String path = request.getContextPath();-->
<!--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";-->
<!--%>-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <link rel="stylesheet" type="text/css" href="css/cssOfIndex.css">
	  <link rel="stylesheet" type="text/css" href="css/cssOfLogin.css">
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
		  <button type="button" class="bg_02_bt" style="margin-left: 150px">Home</button>
		  <button type="button" class="bg_02_bt">Mall</button>
		  <button type="button" class="bg_02_bt">Category</button>
		  <button type="button" class="bg_02_bt">Activity</button>
		  <button type="button" class="bg_02_bt">About</button>
		  <button type="button" class="bg_02_bt" style="margin-left: 150px">Login</button>
	  </div>
	  <div class="Login_bg_01">
		  <div class="Login_bg_03">
			  <div class="Login_bg_04">
				  <div class="Login_bg_05">
					  <p class="Login_bg_05_header">Login</p>
				  </div>
				  <form name="loginForm" action="controller/Login" method="post"  class="Login_form">
                      <div class="Login_input">
                          <label for="userid">UserID:</label>
                          <input style="border: 2px solid black" type="text" name="userID" id="userid" />
                      </div>
                      <div class="Login_input" style="margin-left: 23px; margin-top: 30px">
                          <label for="passwd">Password:</label>
                          <input style="border: 2px solid black" type="password" name="password" id="passwd" />
                      </div>
                      <input class="Login_submit" type="submit" value="Login" />
					  <% String messages ="";
					  messages = (String) request.getSession().getAttribute("message");
					  	if((messages!=null)&&(messages.compareTo("")!=0)){
					  	    %>
					  <p style="background-color: #dca7a7"><%=messages%></p>
						<% }
						%>
				  </form>

			  </div>
		  </div>
	  </div>
	  <div class="Login_bg_02">

	  </div>
  </div>
  </body>
</html>
