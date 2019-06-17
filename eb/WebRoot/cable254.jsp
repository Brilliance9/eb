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
  
  	<h2>有线数字电视应急广播内容表</h2><br/><br/>
    <form action="/eb/DigitalTelServlet"  method="post" onsubmit="return check_submit();">
    	<input type = "hidden"  name = "transType" value="3"/> 	
    	<input type = "hidden"  name = "type" value="254"/>
    	
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
    	应急广播消息标识：
    	<input type="text" class="a"  name="EBM_id" /><br/><br/>
    	多语种内容数量：
    	<input type="text" class="a"  name="multilingual_content_number"  id="multilingual_content_number" oninput="EBMFun(this)"/><br/><br/><br/><br/>
    	
    	
    	<div id="multilingual_content">
	    	语种代码：
  			<input type="text" class="a"  name="language_code" /><br/><br/>
  			编码字符集：
  			<select  name="code_character_set" class="a">
	  			<option value="0">GB/T 2312-1980</option>
	  			<option value="1">GB/T 18030-2005</option>
	  			<option value="2">GB/T 13000-2010</option>
	  			<option value="3">GB/T 21669-2008</option>
	  			<option value="4">GB/T 16959-1997</option>
  			</select><br/><br/>
  			文本内容：
  			<textarea rows="5" cols="40" name="message_text"></textarea><br/><br/>
  			消息发布机构名称：
  			<input type="text" class="a"  name="agency_name" /><br/><br/>
  			
	    	
  			<div id="auxiliary">
  			辅助数据数量：
  			<input type="text" class="a"  name="auxiliary_data_number" id="auxiliary_data_number" oninput="auxiliaryFun(this)"/><br/><br/>
  			辅助数据类型：
  			<select name="auxiliary_data_type" class="a">
  				<option value="1">MPEG-1 LayerI/II 音频文件</option>
  				<option value="2">MPEG-1 LayerIII 音频文件</option>
  				<option value="3">DRA 音频文件</option>
  				<option value="4">DRA+音频文件</option>
  				<option value="41">PNG 图片文件</option>
  				<option value="42">JPEG 图片文件</option>
  				<option value="43">GIF 图片文件</option>
  				<option value="61">音视频流</option>
  			</select><br/><br/>
  			辅助数据：
  			<input type="text" class="a"  name="auxiliary_data" /><br/><br/><br/><br/>
  			</div>
    	</div>
    	
    	
    	<input type="submit" class="a button button-primary button-rounded button-small" value="提交" /><br/>
    </form>
 
  </div>
  </body>
</html>
