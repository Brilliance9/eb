<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <style type="text/css">
    .bgmsg {
    	padding: 0;
 		margin: 0;
 		height: 100%;
 		background: url("./images/background-image.png")  center center;
  		background-size: cover;
  		text-align: center;
 		color: white;
	}
    </style>
    
    <title>应急广播管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/event.css">
	<link rel="stylesheet" type="text/css" href="./css/button.css">

  </head>
  
  <body class="bgmsg">
  <header class="header-container">
    <span class="title"></span>
    
  </header>
  	<br/>
  	<br/>
    <h1>${msg}</h1>
    <br/>
    <br/>
    <a target="_parent" class="button button-primary button-rounded button-small"
     href="/eb/Index">返回主页</a>
  </body>
</html>
