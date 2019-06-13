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
  
  	<h2>有线数字电视管理配置表</h2><br/><br/>
    <form action="/eb/CableServlet"  method="post" onsubmit="return check_submit();">
    	<input type = "hidden"  name = "transType" value="3"/> 	
    	<input type = "hidden"  name = "cableType" value="251"/>
    	
    	
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
   		
   		
   		配置指令数量：
    	<select  name="configure_cmd_number" id="configure_cmd_number" class="a" onchange="configureNumber();">
    		<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
    	</select><br/><br/><br/><br/>
    	<div id="configure">
    		
    	</div>
    	<div id= "configureExample" style="display:none;">
    	<div>
    		<div id="configType" style="display:block;">
    			配置指令类型：
		    	<select  name="configure_cmd_tag" id="configure_cmd_tag" class="a" onchange="configureTag(this);">
					<option value="1">时钟校准指令</option>
					<option value="2">资源编码设置指令</option>
					<option value="3">锁定频率设置指令</option>
					<option value="4">设置回传方式/回传地址指令</option>
					<option value="5">设置回传周期指令</option>
					<option value="6">设置默认音量指令</option>
					<option value="7">状态/参数查询指令</option>
		    	</select><br/><br/>
    		</div>
	    	
	    	<div id="tag1" style="display:block;">
	    		时间：
	    		<input type="datetime-local" class="a"  name="time" /><br/><br/>
	    		秒：
	    		<input type="text" class="a"  name="second" /><br/><br/><br/><br/>
	    	</div>
	    	
	    	<div id="tag2" style="display:none;">
	    		物理地址：
	    		<input type="text" class="a"  name="terminal_address" /><br/><br/>
	    		资源编码：
	    		<input type="text" class="a"  name="resource_code" /><br/><br/><br/><br/>
	    	</div>
	    	
	    	<div id="tag3" style="display:none;">
	    		主频频率：
	    		<input type="text" class="a"  name="freq" /><br/><br/>
	    		符号率：
	    		<input type="text" class="a"  name="symbolrate" /><br/><br/>
	    		调制方式:
	    		<select  name="constellation_mapping" class="a" >
					<option value="1">QAM16</option>
					<option value="2">QAM32</option>
					<option value="3">QAM64</option>
					<option value="4">QAM128</option>
					<option value="5">QAM256</option>

		    	</select><br/><br/>
	    		
	    		<div id="codeid">
	    			资源编码个数：
	    			<input type="text" class="a"  name="terminal_number" id="terminal_number" oninput="terminalNumber(this);"/><br/><br/>
	    			资源编码：
	    			<input type="text" class="a"  name="resource_address" /><br/><br/>
	    		</div>
	    		<br/><br/>
	    	</div>
	    	
	    	<div id="tag4" style="display:none;">
	    		回传方式：
	    		<select name="reback_type" class="a">
					<option value="1">短信</option>
					<option value="2">IP 地址和端口(示例：192.168.22.56:8080)</option>
					<option value="3">域名和端口号(示例： www.chinaeb-lab.org:8080)</option>
				</select><br/><br/>
				回传地址数据：
    			<input type="text" class="a"  name="reback_address" /><br/><br/>
    			
	    		<div id="codeid4">
	    			终端资源编码个数：
	    			<input type="text" class="a"  name="terminal_number4" id="terminal_number4" oninput="terminalNumber4(this);"/><br/><br/>
	    			终端资源编码：
	    			<input type="text" class="a"  name="resource_address4" /><br/><br/>
	    		</div>
	    		<br/><br/>
	    	</div>
	    	
	    	<div id="tag5" style="display:none;">
	    		回传周期(秒)：
    			<input type="text" class="a"  name="reback_period" /><br/><br/>
	    		
	    		<div id="codeid5">
	    			终端资源编码个数：
	    			<input type="text" class="a"  name="terminal_number5" id="terminal_number5" oninput="terminalNumber5(this);"/><br/><br/>
	    			终端资源编码：
	    			<input type="text" class="a"  name="resource_address5" /><br/><br/>
	    		</div>
	    		<br/><br/>
	    	</div>
	    	
	    	<div id="tag6" style="display:none;">
	    		音量(0-100)：
    			<input type="text" class="a"  name="volume" /><br/><br/>
	    		
	    		<div id="codeid6">
		    		终端资源编码个数：
		    		<input type="text" class="a"  name="terminal_number6" id="terminal_number6" oninput="terminalNumber6(this);"/><br/><br/>
	    			终端资源编码：
	    			<input type="text" class="a"  name="resource_address6" /><br/><br/>
	    		</div>
	    		<br/><br/>
	    	</div>
	    	
	    	<div id="tag7" style="display:none;">
	    		<div id="ParameterIdentification">
		    		状态/参数个数：
			    	<input type="text" class="a"  name="parameter_number" id="parameter_number" oninput="parameterNumber(this);"/><br/><br/>
				
			    	参数标识1：
		    		<select name="parameter_tag" class="a">
						<option value="1">终端音量</option>
						<option value="2">本地地址</option>
						<option value="3">回传地址</option>
						<option value="4">终端资源编码</option>
						<option value="5">物理地址编码</option>
						<option value="6">工作状态</option>
						<option value="7">故障代码</option>
						<option value="8">设备类型</option>
						<option value="9">硬件版本号</option>
						<option value="10">软件版本号</option>
					</select><br/><br/>
				</div>
				
	    		<div id="codeid7">
	    			终端资源编码个数：
	    			<input type="text" class="a"  name="terminal_number7" id="terminal_number7" oninput="terminalNumber7(this);"/><br/><br/>
	    			终端资源编码：
	    			<input type="text" class="a"  name="resource_address7" /><br/><br/>
	    		</div>
	    		<br/><br/>
	    	</div><!-- tag7 -->
	    </div>
    	</div>
    	
    	<input type="submit" class="a button button-primary button-rounded button-small" value="提交" /><br/>
    </form>
 
  </div>
  </body>
 
</html>
