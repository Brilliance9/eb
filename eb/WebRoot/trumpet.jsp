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
    
    <title>应急广播大喇叭</title>   
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
  
  	<h2>应急广播大喇叭</h2><br/><br/>
    <form action="/eb/TransmissionServlet"  method="post">
    	<input type = "hidden"  name = "transType" value="5"/>
    	指令类型：
    	<select id="protocol_type" name="protocol_type" class="a" onchange="protocolType(this);">
			<option value="0c">白名单更新</option>
			<option value="0d">回传参数设置</option>
			<option value="0e">输出通道查询</option>
			<option value="0f">输入通道查询</option>
			<option value="10">播发记录查询</option>
			<option value="11">故障详情查询</option>
			<option value="41">适配器证书更新指令</option>
			<option value="05">通用资源编码设置</option>
			<option value="06">通用音量设置</option>
			<option value="07">通用回传参数设置</option>
			<option value="08">终端参数/状态查询指令</option>
			<option value="09">通用时钟校准</option>
			<option value="0a">通用网络参数设置</option>
			<option value="0b">通用回传周期设置</option>
			<option value="3f">通用终端功放开关指令</option>
			<option value="40">通用证书更新</option>
			<option value="01">TS方案中的特殊指令</option>
			<option value="02">RDS方案中的特殊指令</option>
    	</select><br/><br/><br/><br/>
    	
    	<div id="type0c" style="display:block;">
    		白名单数量：
    		<input type="text" class="a"  name="white_list_length" id="white_list_length" oninput="whiteListFun(this);"/><br/><br/><br/>
    		<div id="whiteList">
    			操纵类型：
    			<select name="oper_type" class="a">
					<option value="1">增加</option>
					<option value="2">修改</option>
					<option value="3">删除</option>
				</select><br/><br/>
    			手机号码：
    			<input type="text" class="a"  name="phone_number" /><br/><br/>
    			姓名：
    			<input type="text" class="a"  name="user_name" /><br/><br/>
    			许可类型：
    			<select name="permission_type" class="a">
					<option value="1">短信</option>
					<option value="2">电话</option>
					<option value="3">短信和电话</option>
				</select><br/><br/>
				
    			<div id="codeid">
	    			授权区域数量：
	    			<input type="text" class="a"  name="permission_area_number" id="permission_area_number" oninput="permissionAreaFun(this)"/><br/><br/><br/>
		    		授权区域编码：
		    		<input type="text" class="a"  name="permission_area_code" /><br/><br/>
		    	</div><br/><br/><br/>
    		</div>
    	</div>
    	
    	<div id="type0d" style="display:none;">
    		回传地址类型：
   			<select name="reback_type0d" class="a">
				<option value="1">短信</option>
				<option value="2">IP 地址和端口(示例：192.168.22.56:8080)</option>
				<option value="3">域名和端口号(示例： www.chinaeb-lab.org:8080)</option>
			</select><br/><br/>
			回传周期：
   			<input type="text" class="a"  name="reback_cycle" /><br/><br/>
   			回传地址数据：
    		<input type="text" class="a"  name="reback_address0d" /><br/><br/>
    	</div>
    	
    	<div id="type0e" style="display:none;">
    		资源编码：
    		<input type="text" class="a"  name="front_code0e" /><br/><br/>
    		传输通道号：
    		<input type="text" class="a"  name="output_channel_id" /><br/><br/>
    		查询状态类型：
   			<select name="output_channel_state" class="a">
   				<option value="0">查询全部</option>
				<option value="1">查询空闲</option>
				<option value="2">查询占用</option>
				<option value="3">查询故障</option>
			</select><br/><br/>
    	</div>
    	
    	<div id="type0f" style="display:none;">
    		资源编码：
    		<input type="text" class="a"  name="front_code0f" /><br/><br/>
    		传输通道号：
    		<input type="text" class="a"  name="input_channel_id" /><br/><br/>
    		查询状态类型：
   			<select name="input_channel_state" class="a">
   				<option value="0">查询全部</option>
				<option value="1">查询空闲</option>
				<option value="2">查询占用</option>
				<option value="3">查询故障</option>
			</select><br/><br/>
    	</div>
    	
    	<div id="type10" style="display:none;">
    		资源编码：
    		<input type="text" class="a"  name="front_code10" /><br/><br/>
    		应急广播消息标识：
    		<input type="text" class="a"  name="ebm_id" /><br/><br/>
    		任务类型：
   			<select name="task_type" class="a">
   				<option value="0">全部节目</option>
				<option value="1">日常节目</option>
				<option value="2">应急节目</option>
			</select><br/><br/>
			播发记录开始时间：
    		<input type="text" class="a"  name="startTime" /><br/><br/>
    		播发记录结束时间：
    		<input type="text" class="a"  name="endTime" /><br/><br/>
    	</div>
    	
    	<div id="type11" style="display:none;">
    		资源编码：
    		<input type="text" class="a"  name="front_code11" /><br/><br/>
    	</div>
    	
    	<div id="type41" style="display:none;">
    		<div id="codeid">
    			证书链个数：
    			<input type="text" class="a"  name="permission_area_number" id="permission_area_number" oninput="permissionAreaFun(this)"/><br/><br/><br/>
	    		证书链数据：
	    		<input type="text" class="a"  name="permission_area_code" /><br/><br/>
	    	</div><br/><br/><br/>
	    	<div id="codeid">
    			证书个数：
    			<input type="text" class="a"  name="permission_area_number" id="permission_area_number" oninput="permissionAreaFun(this)"/><br/><br/><br/>
	    		证书数据：
	    		<input type="text" class="a"  name="permission_area_code" /><br/><br/>
	    	</div><br/><br/><br/>
    	</div>
    	
    	<div id="type05" style="display:none;">
    		
    	</div>
    	
    	<div id="type06" style="display:none;">
    		音量（1-100）：
	    	<input type="text" class="a"  name="volume" /><br/><br/>
	    	地址码类型：
	    	<select name="resource_code_type06" class="a">
	    		<option value="1">逻辑码寻址</option>
	    		<option value="2">物理码寻址</option>
	    	</select>
    	</div>
    	<input type="submit" class="a button button-primary button-rounded button-small" value="提交" /><br/>
    </form>
 
  </div>
  </body>
 
</html>
