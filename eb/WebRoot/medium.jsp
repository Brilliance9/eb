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
    
    <title>中波调幅广播</title>   
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
  
  <h2>中波调幅广播</h2><br/><br/>
  
    <form action="/eb/TransmissionServlet"  method="post" onsubmit="return check_submit();">
    	<input type = "hidden"  name = "transType" value="1"/>
    	指令类型：
    	<select id="type" name="type" class="a" onchange="mediumtype();">
			<option value="1">开播</option>
			<option value="2">停播</option>
			<option value="3">更换默认锁定频点</option>
			<option value="4">证书授权指令</option>
    	</select><br/><br/>
    	应急广播消息编号：
    	<input type="text" class="a"  name="number" /><br/><br/>
    	发送源标识码：
    	<input type="text" class="a"  name="source" /><br/><br/>
    	目标区域数：
    	<select id ="areas" name="areas" class="a" onchange="numbers();">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>		
    	</select><br/><br/><br/>
    	<div id = "code">
    		<div>
    			目标区域编码1：<input type="text" class="a"  name="code" /><br/><br/>
    		</div>
    	</div>
    	
    	
    	
    
    	
    	
  		<br/><br/>
  		
  		
    	
    	<!-- 数据包时间：
    	<input type="text" class="a"  name="time" /><br/><br/>
    	证书编号：
    	<input type="text" class="a"  name="certificate" /><br/><br/>
    	数字签名：
    	<input type="text" class="a"  name="sign" /><br/><br/> -->
    	
    	
    	
    	<div id ="type1" style="display:block;">
    	播出时长(分钟)：
    	<input type="text" class="a"  name="duration" /><br/><br/>
    	事件级别：
        <select name="level" class="a">
        	<option value="0">未知级别（Unknown）</option>
			<option value="1">1 级（特别重大/红色预警/Red）</option>
			<option value="2">2 级（重大/橙色预警/Orange）</option>
			<option value="3">3 级（较大/黄色预警/Yellow）</option>
			<option value="4">4 级（一般/蓝色预警/Blue）</option>
    	</select><br/><br/>
    	事件类型：
    	<input type="text" class="a"  name="eventType" /><br/><br/>
    	</div>
    	
    	
    	<div id="type2" style="display:none;">
    	</div>
    	
    	<div id="type3" style="display:none;">
    	频点类型：
        <select name="frequencyType" class="a">
        	<option value="0">不切换）</option>
			<option value="1">中波</option>
    	</select><br/><br/>
    	频点值（整数形式）：
    	<input type="text" class="a"  name="value" /><br/><br/>
    	</div>
    	
    	<div id="type4" style="display:none;">
    	接收端编号：
    	<input type="text" class="a"  name="ReceiverSN" /><br/><br/>
    	证书授权序列号：
    	<input type="text" class="a"  name="CertsAuthSN" /><br/><br/>
    	证书数量：
    	<input type="text" class="a"  name="CertsCount" id="CertsCount"/><br/><br/><br/>
    	<div id="CertSNs">
    		证书编号列表1：
    		<input type="text" class="a"  name="CertSNs" /><br/><br/>
    	</div>
    	签名证书编号：
    	<input type="text" class="a"  name="SigSN" /><br/><br/>
    	数字签名数据：
    	<input type="text" class="a"  name="Signature" /><br/><br/>
    	</div>
    	<input type="submit" class="a button button-primary button-rounded button-small" value="提交" />  <br/>
    </form>
 
  </div>
  </body>
  <script type="text/javascript">
  var CertsCount = document.getElementById('CertsCount');

  var CertSNs = document.getElementById('CertSNs');  
  CertsCount.oninput = function(){ 
  	var text = "";
  	for(var i=0;i<CertsCount.value;i++){
  		text += '证书编号列表'+(i+1)+'：<input type="text" class="a"  name="CertSNs" /><br/><br/>';
  	} 
  	CertSNs.innerHTML=text;
  }
  </script>
</html>
