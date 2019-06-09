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
    <form action="/eb/TransmissionServlet"  method="post" onsubmit="return check_submit();">
    	<input type = "hidden"  name = "transType" value="3"/>
    	表类型：
    	<select id="type" name="type" class="a" onchange="tabletype();">
			<option value="253">应急广播索引表</option>
			<option value="254">应急广播内容表</option>
			<option value="252">应急广播证书授权表</option>
			<option value="251">管理配置表</option>
    	</select><br/><br/>
    	
    	
    	<div id ="type1" style="display:block;">
    		扩展表标识：
    		<input type="text" class="a"  name="table_id_extension" /><br/><br/>
    		应急广播索引表版本：
    		<input type="text" class="a"  name="version_number" /><br/><br/>
    		表类型：
	    	<select  name="current_next_indicator" class="a">
				<option value="1">应急广播索引表当前适用</option>
				<option value="0">应急广播索引表当前不0适用</option>
	    	</select><br/><br/>
	    	当前段序号：
    		<input type="text" class="a"  name="section_number" /><br/><br/>
    		最后段序号：
    		<input type="text" class="a"  name="last_section_number" /><br/><br/>
    		应急广播消息数量：
    		<input type="text" class="a" id="EBM_number" name="EBM_number" /><br/><br/>
    		
    		<div id="EBM">
    			应急广播消息标识符：
    			<input type="text" class="a"  name="EBM_id" /><br/><br/>
    			应急广播原始网络标识符：
    			<input type="text" class="a"  name="EBM_original_network_id" /><br/><br/>
    			应急广播消息开始时间：
    			<input type="datetime-local" class="a"  name="EBM_start_time" /><br/><br/>
    			应急广播消息结束时间：
    			<input type="datetime-local" class="a"  name="EBM_end_time" /><br/><br/>
    			应急广播消息类别：
    			<input type="text" class="a"  name="EBM_type" /><br/><br/>
    			应急广播消息分类：
	    		<select  name="EBM_class" class="a">
					<option value="1">发布系统演练</option>
					<option value="2">模拟演练</option>
					<option value="3">实际演练</option>
					<option value="4">应急广播</option>
	    		</select><br/><br/>
	    		应急广播消息分类：
	    		<select  name="EBM_class" class="a">
					<option value="1">1级（特别重大）</option>
					<option value="2">2级（重大）</option>
					<option value="3">3级（较大）</option>
					<option value="4">4级（一般）</option>
	    		</select><br/><br/>
	    		应急广播系统资源编码数量：
			    <input type="text" class="a"  name="EBM_resource_number" id="EBM_resource_number"/><br/><br/><br/>
			    <div id="EBM_resource_code">
    				资源编码1：
    				<input type="text" class="a"  name="EBM_resource_code" /><br/><br/>
    			</div><br/>
    			指定频道有无标识：
    			<select  name="details_channel_indicate" id="details_channel_indicate" class="a" onchange="details();">
					<option value="1">应急广播消息有指定频道</option>
					<option value="0">应急广播消息无指定频道</option>
	    		</select><br/><br/>
	    		
	    		<div id="details_channel">
	    			网络标识符：
    				<input type="text" class="a"  name="details_channel_network_id" /><br/><br/>
    				传送流标识符：
    				<input type="text" class="a"  name="details_channel_transport_stream_id" /><br/><br/>
    				节目号：
    				<input type="text" class="a"  name="details_channel_program_number" /><br/><br/>
    				指定频道PCR标识：
    				<input type="text" class="a"  name="details_channel_PCR_PID" /><br/><br/>
    				描述符：
	    			<select  name="des" class="a">
						<option value="2">视频流描述符</option>
						<option value="3">音频流描述符</option>
						<option value="4">层次流描述符</option>
						<option value="5">登记描述符</option>
						<option value="6">数据流对齐描述符</option>
						<option value="7">目标背景栅格描述符</option>
						<option value="8">视频窗描述符</option>
						<option value="9">条件接入描述符</option>
						<option value="10">ISO_639语言描述符</option>
						<option value="11">系统时钟描述</option>
						<option value="12">复用缓冲区应用描述符</option>
						<option value="13">版权描述符</option>
						<option value="14">最大比特率描述符</option>
						<option value="15">专用数据指示符描述符</option>
						<option value="16">平滑缓冲区描述符</option>
						<option value="17">STD描述符</option>
						<option value="18">IBP描述符</option>
						<option value="63">AVS Video descriptor</option>
		    		</select><br/><br/><br/><br/>
		    		<div class="first"> 有线传送系统描述符：</div><br/>
		    		频率(小数形式)：
    				<input type="text" class="a"  name="frequency" /><br/><br/>
    				前向纠错外码：
	    			<select  name="FEC_outer" class="a">
						<option value="1">无FEC外码</option>
						<option value="2">RS(204,188)</option>
		    		</select><br/><br/>
		    		调制方式：
	    			<select  name="modulation" class="a">
						<option value="1">16QAM</option>
						<option value="2">32QAM</option>
						<option value="3">64QAM</option>
						<option value="4">128QAM</option>
						<option value="5">256QAM</option>
		    		</select><br/><br/>
		    		符号率(小数形式)：
    				<input type="text" class="a"  name="symbol_rate" /><br/><br/>
    				前向纠错内码：
	    			<select  name="FEC_outer" class="a">
						<option value="1">卷积码率1/2</option>
						<option value="2">卷积码率2/3</option>
						<option value="3">卷积码率3/4</option>
						<option value="4">卷积码率5/6</option>
						<option value="5">卷积码率7/8</option>
						<option value="6">卷积码率3/5</option>
						<option value="7">卷积码率4/5</option>
						<option value="8">卷积码率9/10</option>
						<option value="9">卷积码率13/15</option>
						<option value="15">无卷积编码</option>
		    		</select><br/><br/><br/><br/>
		    		
		    		
		    		<div class="first"> 视频流描述符 GB/T 17975.2或GB/T 17191.2：</div><br/>
		    		多种帧速率标志字段：
	    			<select  name="multiple_frame_rate_flag1" class="a">
						<option value="0">单一帧速率</option>
						<option value="1">多种帧播放速率</option>
		    		</select><br/><br/>
		    		帧速率码字段：
	    			<select  name="frame_rate_code1" class="a">
						<option value="0">禁止</option>
						<option value="1">24000/1001（23.976）</option>
						<option value="2">24</option>
						<option value="3">25</option>
						<option value="4">30000/1001（29.97）</option>
						<option value="5">30</option>
						<option value="6">50</option>
						<option value="7">60000/1001（59.94）</option>
						<option value="8">60</option>
		    		</select><br/><br/>
		    		仅含MPEG1标志字段：
		    		<select  name="MPEG_1_only_flag" id="MPEG_1_only_flag" class="a" onchange="MPEG();">
						<option value="0">可能包含GB/T 17975.2视频数据和受限参数GB/T 17191.2视频数据</option>
						<option value="1">该视频流仅含GB/T 17191.2数据</option>
		    		</select><br/><br/>
		    		受限参数标志字段：
		    		<select  name="constrained_parameter_flag" class="a">
						<option value="0">可能包含受限参数和非受限的GB/T 17975.2视频数据</option>
						<option value="1">视频流不包括非受限GB/T 17191.2受限数据</option>
		    		</select><br/><br/>
		    		静态图像标志字段：
		    		<select  name="still_picture_flag" class="a">
						<option value="0">可能包含静态和动态的图像数据</option>
						<option value="1">视频流只含静态图像</option>
		    		</select><br/><br/>
		    		<div id="MPEG_1" >
		    			档次与级别转义比特标志字段：
			    		<select  name="Transferred" id="Transferred" class="a" onchange="transferred();"> 
							<option value="0">0</option>
							<option value="1">1</option>
			    		</select><br/><br/>
			    		<div id="Transferred0" style="display:block;">
			    			型标识：
				    		<select  name="ProfileIdentifier" class="a">
								<option value="5">简单型（SP）</option>
								<option value="4">主型（MP）</option>
								<option value="3">SNR分级型</option>
								<option value="2">空间分级型</option>
								<option value="1">高型（HP）</option>
				    		</select><br/><br/>
				    		级标识：
				    		<select  name="LevelIdentifier" class="a">
								<option value="10">低级（LL）</option>
								<option value="8">主级（ML）</option>
								<option value="6">高级1440（H-1440）</option>
								<option value="4">高级（HL）</option>
				    		</select><br/><br/>
			    		</div>
			    		<div id="Transferred1" style="display:none;">
			    			型和级指示：
			    			<select  name="ProfileLevel" class="a">
								<option value="142">MVP@LL</option>
								<option value="141">MVP@ML</option>
								<option value="139">MVP@H-1440L</option>
								<option value="138">MVP@HL</option>
								<option value="133">4:2:2P@ML</option>
				    		</select><br/><br/>
			    		</div>
			    		色差格式字段：
			    		<select  name="chroma_format1" class="a"> 
							<option value="1">4:2:0</option>
							<option value="2">4:2:2</option>
							<option value="3">4:4:4</option>
			    		</select><br/><br/>
			    		帧速率扩展标志字段：
			    		<select  name="frame_rate_extension_flag" class="a"> 
							<option value="0">0</option>
							<option value="1">1</option>
			    		</select><br/><br/><br/><br/>
		    		</div>
		    		<div class="first"> 音频流描述符：</div><br/>
	    		</div>
	    		
    		</div>
    	</div>
    	
    	<div id ="type2" style="display:block;">
    	</div>
    	
    	<div id ="type3" style="display:block;">
    	</div>
    	
    	<div id ="type4" style="display:block;">
    	</div>

    	<input type="submit" class="a button button-primary button-rounded button-small" value="提交" /><br/>
    </form>
 
  </div>
  </body>
  <script type="text/javascript">
	  var EBM_resource_number = document.getElementById('EBM_resource_number');
	  var EBM_resource_code = document.getElementById('EBM_resource_code');  
	  EBM_resource_number.oninput = function(){ 
	  	var text = "";
	  	for(var i=0;i<EBM_resource_number.value;i++){
	  		text += '资源编码'+(i+1)+'：<input type="text" class="a"  name="EBM_resource_code" /><br/><br/>';
	  	} 
	  	EBM_resource_code.innerHTML=text;
	  }
  </script>
</html>
