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
    
    <title>模拟调频</title>   
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
<div id ="b">
	<h2>模拟调频</h2><br/><br/>
	<form action="/eb/TransmissionServlet"  method="post" onsubmit="return check_submit();">
		<input type = "hidden"  name = "transType" value="2"/>
		数据包类型：
    	<select id="type" name="type" class="a" onchange="analogFMtype();">
			<option value="0">设置扫描频点列表信息</option>
			<option value="1">设置设备资源编码</option>
			<option value="2">设置采用/禁用维持指令</option>
			<option value="3">系统时间校时指令</option>
			<option value="4">设置回传参数</option>
			<option value="5">设置回传周期</option>
			<option value="6">应急广播证书授权列表更新指令</option>
			<option value="7">证书更新指令</option>
			<option value="8">状态/参数查询指令</option>
			<option value="11">应急开播/停播指令</option>
			<option value="12">设备复位指令</option>
			<option value="13">恢复出厂设置指令</option>
			<option value="14">应急演练指令</option>
			<option value="15">文本内容传输指令</option>
			<option value="21">维持指令</option>
			<option value="22">日常开播/停播指令</option>
			<option value="23">日常广播默认音量设置指令</option>
			<option value="24">终端功放开关设置指令</option>
    	</select><br/><br/>
    	
    	资源编码数量：
    	<input type="text" class="a"  name="number" id="number"/><br/><br/><br/>
    	<div id="codeid">
    		资源编码1：
    		<input type="text" class="a"  name="code" /><br/><br/>
    	</div><br/>
    	
    	
    	<div id="type0" style="display:block;">
	    	<div class="first"> 设置扫描频点列表信息：</div>
	    	<br/>
	    	频点数：
	    	<input type="text" class="a"  name="FrequencyPoints" id="FrequencyPoints"/><br/><br/><br/>
	    	<div id="FrequencySet">
	    		频点优先级1(数值低优先级高)：
	    		<input type="text" class="a"  name="FrequencyPointPriority" /><br/><br/>
	    		频率1（小数形式）：
	    		<input type="text" class="a"  name="Frequency" /><br/><br/><br/>
	    	</div>
    	</div>
    	
    	<div id="type1" style="display:none;">
    		<div class="first"> 设置设备资源编码：</div><br/>
    		设备物理地址：
    		<input type="text" class="a"  name="PhysicalAddress" /><br/><br/>
    		设备资源编码：
    		<input type="text" class="a"  name="EquipmentCode" /><br/><br/>
    	</div>
    	
    	<div id="type2" style="display:none;">
    		<div class="first"> 设置采用/禁用维持指令：</div><br/>
    		启用/禁用维持指令：
    		<select name="instructions" class="a">
				<option value="0">禁用</option>
				<option value="1">启用</option>
			</select><br/><br/>
			维持周期（秒）：
    		<input type="text" class="a"  name="MaintenanceCycle" /><br/><br/>
    	</div>
    	
    	<div id="type3" style="display:none;">
    		<div class="first"> 系统时间校时指令：</div><br/>
    		指定时间：
    		<input type="datetime-local" class="a"  name="time" /><br/><br/>
    		指定时间（秒）：
    		<input type="text" class="a"  name="second" /><br/><br/>
    	</div>
    	
    	<div id="type4" style="display:none;">
    		<div class="first">设置回传参数 ：</div><br/>
    		回传方式：
    		<select name="ReturnMode" class="a">
				<option value="1">短信</option>
				<option value="2">IP 地址和端口(示例：192.168.22.56:8080)</option>
				<option value="3">域名和端口号(示例： www.chinaeb-lab.org:8080)</option>
			</select><br/><br/>
			回传地址数据：
    		<input type="text" class="a"  name="ReturnData" /><br/><br/>
    	</div>
    	
    	<div id="type5" style="display:none;">
    		<div class="first"> 设置回传周期：</div><br/>
    		回传周期(秒)：
    		<input type="text" class="a"  name="ReturnCycle" /><br/><br/>
    	</div>
    	
    	<div id="type6" style="display:none;">
    		<div class="first">应急广播证书授权列表更新指令 ：</div><br/>
    		签名时间：
    		<input type="text" class="a"  name="SigTime" /><br/><br/>
    		发送端数字证书编号：
    		<input type="text" class="a"  name="CertificateSN6" /><br/><br/>
    		数字签名数据：
    		<input type="text" class="a"  name="Signature" /><br/><br/>
    	</div>
    	
    	<div id="type7" style="display:none;">
    		<div class="first"> 证书更新指令：</div><br/>
    		证书个数：
	    	<input type="text" class="a"  name="NumberOfCertificates" id="NumberOfCertificates"/><br/><br/><br/>
	    	<div id="cerdata">
	    		应急广播数字证书版本号1：
	    		<input type="text" class="a"  name="CertificateVersion" /><br/><br/>
	    		应急广播数字证书签发者编号1：
	    		<input type="text" class="a"  name="IssuerSN" /><br/><br/>
	    		应急广播数字证书编号1：
	    		<input type="text" class="a"  name="CertificateSN7" /><br/><br/>
	    		应急广播数字证书有效期(示例：2019.5)：
	    		<input type="text" class="a"  name="CertificateValidate" /><br/><br/>
	    		应急广播数字证书公钥数据1：
	    		<input type="text" class="a"  name="PublicKey" /><br/><br/>
	    		应急及广播数字证书签名数据1：
	    		<input type="text" class="a"  name="SignatureData" /><br/><br/>
	    	</div>
    	</div>
    	
    	<div id="type8" style="display:none;">
    		<div class="first"> 状态/参数查询指令：</div><br/>
    		状态/参数个数：
	    	<select name="NumberOfParameters" id="NumberOfParameters" class="a" onchange="NumberOfParameter();">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select><br/><br/>
			<div id="ParameterIdentification">
	    	参数标识1：
    		<select name="ParameterIdentification" class="a">
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
    	</div>
    	
    	<div id="type11" style="display:none;">
    		<div class="first"> 应急开播/停播指令：</div><br/>
    		开停播类型：
    		<select name="Start_StopType" class="a">
				<option value="1">开播</option>
				<option value="2">停播</option>
			</select><br/><br/>
			是否切换频点：
			<select name="Switching" class="a">
				<option value="1">切换</option>
				<option value="2">不切换</option>
			</select><br/><br/>
    		
			事件级别：
    		<select name="EventLevel" class="a">
				<option value="1">1 级（特别重大）</option>
				<option value="2">2 级（重大）</option>
				<option value="3">3 级（较大）</option>
				<option value="4">4 级（一般）</option>
			</select><br/><br/>
			事件类型编码：
	    	<input type="text" class="a"  name="Eventtype" /><br/><br/>
	    	应急广播消息 ID：
	    	<input type="text" class="a"  name="InfoID" /><br/><br/>
	    	频点信息(小数形式)：
	    	<input type="text" class="a"  name="FrequencyInformation" /><br/><br/>
    	</div>
    	
    	<div id="type12" style="display:none;">
    		<div class="first"> 设备复位指令：</div><br/>
    		指令类型：
    		<select name="InstructionType" class="a">
				<option value="1">复位</option>
			</select><br/><br/>
			是否更改默认频点：
			<select name="Switching12" class="a">
				<option value="1">更改</option>
				<option value="2">不更改</option>
			</select><br/><br/>
			默认频点信息(小数形式)：
	    	<input type="text" class="a"  name="FrequencyInformation12" /><br/><br/>
    	</div>
    	
    	<div id="type13" style="display:none;">
    		<div class="first"> 恢复出厂设置指令：</div><br/>
    		恢复出厂设置指令格式：
    		<select name="InstructionType13" class="a">
				<option value="1">恢复出厂设置</option>
			</select><br/><br/>
    	</div>
    	
    	<div id="type14" style="display:none;">
    		<div class="first"> 应急演练指令：</div><br/>
    		应急演练类型：
    		<select name="EmergencyType" class="a">
				<option value="1">系统演练</option>
				<option value="2">模拟演练</option>
				<option value="3">实际演练</option>
			</select><br/><br/>
			应急演练操作指令：
    		<select name="OperationInstruction" class="a">
				<option value="1">播出终端设备内预存音频</option>
				<option value="2">播出当前频点节目</option>
				<option value="3">回传状态参数</option>
				<option value="4">停播</option>
			</select><br/><br/>
			演练指令 ID：
	    	<input type="text" class="a"  name="ExerciseInstructionID" /><br/><br/>
    	</div>
    	
    	<div id="type15" style="display:none;">
    		<div class="first">文本内容传输指令 ：</div><br/>
    		文本内容类型：
    		<select name="TextType" class="a">
				<option value="1">应急事件文本</option>
				<option value="2">日常宣传文本</option>
				<option value="3">应急测试文本</option>
			</select><br/><br/>
			编码字符集：
    		<select name="CodedCharacterSet" class="a">
				<option value="1">GB 18030—2005</option>
				<option value="2">GB/T 13000—2010</option>
				<option value="3">GB/T 21669—2008</option>
				<option value="4">GB 16959—1997</option>
			</select><br/><br/>
			应急广播消息 ID：
	    	<input type="text" class="a"  name="InfoID15" /><br/><br/>
	    	消息文本内容：
	    	<textarea rows="5" cols="40" name="Text"></textarea>
	    	<br/><br/>
    	</div>
    	
    	<div id="type21" style="display:none;">
    		<div class="first"> 维持指令：</div><br/>
    		维持指令序号（0～255 循环计数）：
	    	<input type="text" class="a"  name="MaintenanceInstruction" /><br/><br/>
    	</div>
    	
    	<div id="type22" style="display:none;">
    		<div class="first"> 日常开播/停播指令：</div><br/>
    		日常开播/停播类型：
    		<select name="DailyType" class="a">
				<option value="1">开播</option>
				<option value="2">停播</option>
			</select><br/><br/>
			是否切换频点：
			<select name="Switching22" class="a">
				<option value="1">切换</option>
				<option value="2">不切换</option>
			</select><br/><br/>
			指令 ID：
	    	<input type="text" class="a"  name="InfoID22" /><br/><br/>
	    	切换频点信息(小数形式)：
	    	<input type="text" class="a"  name="FrequencyInformation22" /><br/><br/>
	    	播出音量(0~100)：
	    	<input type="text" class="a"  name="volume22" /><br/><br/>
    	</div>
    	
    	<div id="type23" style="display:none;">
    		<div class="first">日常广播音量设置 ：</div><br/>
    		播出音量(0~100)：
	    	<input type="text" class="a"  name="volume23" /><br/><br/>
    	</div>
    	
    	<div id="type24" style="display:none;">
    		<div class="first">终端功放开关设置 ：</div><br/>
    		功放开关状态：
			<select name="Switching24" class="a">
				<option value="1">关闭功放输出</option>
				<option value="2">打开功放输出</option>
			</select><br/><br/>
    	</div>
    	
		<input type="submit" class="a button button-primary button-rounded button-small" value="提交" />  <br/>
	</form>
</div>

  </body>
  <script type="text/javascript">
  var number = document.getElementById('number');
  var code = document.getElementById('codeid');  
  number.oninput = function(){ 
  	var text = "";
  	for(var i=0;i<number.value;i++){
  		text += '资源编码'+(i+1)+'：<input type="text" class="a"  name="code" /><br/><br/>';
  	} 
  	code.innerHTML=text;
  }
  
  var FrequencyPoints = document.getElementById('FrequencyPoints');
  var FrequencySet = document.getElementById('FrequencySet');  
  FrequencyPoints.oninput = function(){ 
  	var text = "";
  	for(var i=0;i<FrequencyPoints.value;i++){
  		text += '频点优先级1(数值低优先级高)'+(i+1)+'：<input type="text" class="a"  name="FrequencyPointPriority" /><br/><br/>频率1（小数形式）'
  			+(i+1)+'：<input type="text" class="a"  name="Frequency" /><br/><br/><br/>';
  	} 
  	FrequencySet.innerHTML=text;
  }
  
  var NumberOfCertificates = document.getElementById('NumberOfCertificates');
  var cerdata = document.getElementById('cerdata');  
  NumberOfCertificates.oninput = function(){ 
  	var text = "";
  	for(var i=0;i<NumberOfCertificates.value;i++){
  		text += '应急广播数字证书版本号'+(i+1)+'：<input type="text" class="a"  name="CertificateVersion" /><br/><br/>应急广播数字证书签发者编号'
  			+(i+1)+'：<input type="text" class="a"  name="IssuerSN" /><br/><br/>应急广播数字证书编号'
  			+(i+1)+'：<input type="text" class="a"  name="CertificateSN7" /><br/><br/>应急广播数字证书有效期(示例：2019.5)'
  			+(i+1)+'：<input type="text" class="a"  name="CertificateValidate" /><br/><br/>应急广播数字证书公钥数据'
  			+(i+1)+'：<input type="text" class="a"  name="PublicKey" /><br/><br/>应急及广播数字证书签名数据'
  			+(i+1)+'：<input type="text" class="a"  name="SignatureData" /><br/><br/><br/>';
  	} 
  	cerdata.innerHTML=text;
  }
  </script>
</html>
