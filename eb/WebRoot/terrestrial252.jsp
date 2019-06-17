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
    
    <title>地面数字电视</title>   
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
  
  	<h2>地面数字电视应急广播证书授权列表</h2><br/><br/>
    <form action="/eb/DigitalTelServlet"  method="post" onsubmit="return check_submit();">
    	<input type = "hidden"  name = "transType" value="4"/> 	
    	<input type = "hidden"  name = "type" value="252"/>
    	
    	扩展表标识：
   		<input type="text" class="a"  name="table_id_extension" /><br/><br/>
   		应急广播索引表版本：
   		<input type="text" class="a"  name="version_number" /><br/><br/>
   		当前下一个指示符：
    	<select  name="current_next_indicator" class="a">
			<option value="1">应急广播索引表当前适用</option>
			<option value="0">应急广播索引表当前不适用</option>
    	</select><br/><br/>
    	当前段序号：
   		<input type="text" class="a"  name="section_number" /><br/><br/>
   		最后段序号：
   		<input type="text" class="a"  name="last_section_number" /><br/><br/>
   		
   		
   		证书授权列表数量：
    	<input type="text" class="a"  name="CertAuth_number"  id="CertAuth_number" oninput="CertAuthFun(this)"/><br/><br/><br/><br/>
    	<div id="CertAuth">
    		证书授权列表数据：
  			<textarea rows="5" cols="40" name="CertAuth_data"></textarea><br/><br/>
    	</div><br/><br/>
    	
    	证书数量：
    	<input type="text" class="a"  name="cert_number"  id="cert_number" oninput="certFun(this)"/><br/><br/><br/><br/>
    	<div id="cert">
    		证书数据：
  			<textarea rows="5" cols="40" name="cert_data"></textarea><br/><br/>
    	</div>
    	
    	<input type="submit" class="a button button-primary button-rounded button-small" value="提交" /><br/>
    </form>
 
  </div>
  </body>
 
</html>
