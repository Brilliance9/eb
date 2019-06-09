<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加警报</title>   
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/event.css">
	<link rel="stylesheet" type="text/css" href="./css/button.css">
	<link rel="stylesheet" type="text/css" href="./css/add.css">
	<script type="text/javascript" src="./js/add.js"></script>

  </head>
  
  <body class="bg" style="color:white;">
  
  <div class="header-container">
    <span class="title3"></span>
    
  </div>
  
  <div id="b">
  
  
    <form action="/eb/TransmissionServlet"  method="get">
    	
    	请选择传输覆盖网的类型：
    	<select name="type" class="a">
			<option value="1">中波调幅广播</option>
			<option value="2">模拟调频</option>
			<option value="3">有线数字电视</option>
			<option value="4">地面数字电视</option>
			<option value="5">应急广播大喇叭</option>		
    	</select><br/><br/>
    	

  		<input type="submit" class="a button button-primary button-rounded button-small" value="开始" />  <br/>
    </form>
 
  </div>
  </body>
</html>
