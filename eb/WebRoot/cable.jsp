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
    
    <title>有线数字电视</title>   
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
	<script type="text/javascript" src="./js/transmission.js"></script>
  </head>
  
  <body class="bg" style="color:white;">
  
  <div class="header-container">
    <span class="title3"></span>
    
  </div>
  
  <div id="b">
  
  	<h2>有线数字电视</h2><br/><br/>
    <form action="/eb/DigitalTelServlet"  method="get" onsubmit="return check_submit();">
    	<input type = "hidden"  name = "transType" value="3"/>
    	表类型：
    	<select name="type" class="a" >
			<option value="253">应急广播索引表</option>
			<option value="254">应急广播内容表</option>
			<option value="252">应急广播证书授权表</option>
			<option value="251">管理配置表</option>
    	</select><br/><br/><br/><br/>
    	<input type="submit" class="a button button-primary button-rounded button-small" value="下一步" /><br/>
    </form>
 
  </div>
  </body>
 
</html>
