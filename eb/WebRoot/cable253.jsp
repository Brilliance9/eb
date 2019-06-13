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
  
  	<h2>有线数字电视应急广播索引表</h2><br/><br/>
    <form action="/eb/CableServlet"  method="post" onsubmit="return check_submit();">
    	<input type = "hidden"  name = "transType" value="3"/> 	
    	<input type = "hidden"  name = "cableType" value="253"/> 	
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
	    		应急广播消息级别：
	    		<select  name="EBM_level" class="a">
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
	    			<select  name="FEC_inner" class="a">
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
								<option value="80">简单型（SP）</option>
								<option value="64">主型（MP）</option>
								<option value="48">SNR分级型</option>
								<option value="32">空间分级型</option>
								<option value="16">高型（HP）</option>
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
		    		自由格式标志字段：
		    		<select  name="free_format_flag" class="a"> 
						<option value="0">0</option>
						<option value="1">1</option>
		    		</select><br/><br/>
		    		ID字段：
		    		<select  name="ID" class="a"> 
						<option value="0">0</option>
						<option value="1">1</option>
		    		</select><br/><br/>
		    		层字段：
		    		<select  name="layer" class="a"> 
						<option value="3">第一层</option>
						<option value="2">第二层</option>
						<option value="1">第三层</option>
		    		</select><br/><br/>
					可变速率音频指示符字段：
		    		<select  name="variable_rate_audio_indicator" class="a"> 
						<option value="0">连续的音频帧之间相关音频流的比特速率可变</option>
						<option value="1">比特速率不可变</option>
		    		</select><br/><br/><br/><br/>
					
					<div class="first"> 层次描述符：</div><br/>
					ID字段：
		    		<select  name="hierarchy_type" class="a"> 
						<option value="1">GB/T 17975.2 空间可伸缩性</option>
						<option value="2">GB/T 17975.2 SNR可伸缩扩展性</option>
						<option value="3">GB/T 17975.2 当前可伸缩扩展性</option>
						<option value="4">GB/T 17975.2 数据分割</option>
						<option value="5">GB/T 17975.3 扩展比特流</option>
						<option value="6">GB/T 17975.1 专用流</option>
						<option value="15">基本层</option>
		    		</select><br/><br/>
					层次层索引字段：
    				<input type="text" class="a"  name="hierarchy_layer_index" /><br/><br/>
					分层嵌入层索引字段：
    				<input type="text" class="a"  name="hierarchy_embedded_layer_index" /><br/><br/>
					层次通道字段：
    				<input type="text" class="a"  name="hierarchy_channel" /><br/><br/><br/><br/>
    				
    				<div class="first"> 登记描述符：</div><br/>
    				格式标识符字段：
    				<input type="text" class="a"  name="format_identifier" /><br/><br/>
    				附加鉴定信息字段：
    				<input type="text" class="a"  name="additional_identification_info" /><br/><br/><br/><br/>
    				
    				<div class="first"> 数据流对齐描述符：</div><br/>
    				对齐类型字段：
		    		<select  name="alignment_type" class="a" id="alignment_type" onchange="alignmenttype();"> 
						<option value="0">视频流</option>
						<option value="1">音频流</option>
		    		</select><br/><br/>
		    		<div id="alignment0" style="display:block;">
		    			视频流对齐值：
			    		<select  name="alignment_type0"  class="a"> 
							<option value="1">片或视频接入单元</option>
							<option value="2">视频接入单元</option>
							<option value="3">GOP或SEG</option>
							<option value="4">SEQ</option>
			    		</select><br/><br/>
		    		</div>
		    		<div id="alignment1" style="display:none;">
		    			音频流对齐值：
			    		<select  name="alignment_type1"  class="a"> 
							<option value="1">同步字</option>
			    		</select><br/><br/>
		    		</div><br/><br/>
		    		<div class="first"> 目标背景栅格描述符：</div><br/>
		    		水平尺寸字段（像素）：
    				<input type="text" class="a"  name="horizontal_size" /><br/><br/>
    				垂直尺寸字段（像素）：
    				<input type="text" class="a"  name="vertical_size" /><br/><br/>
    				像素宽高比/DAR：
		    		<select  name="aspect_ratio_information"  class="a"> 
						<option value="0">禁止</option>
						<option value="1">1.0（方像素）</option>
						<option value="2">3/4</option>
						<option value="3">9/16</option>
						<option value="4">1/2.21</option>
		    		</select><br/><br/><br/><br/>
		    		
		    		<div class="first"> 视频窗描述符：</div><br/>
		    		水平偏移字段：
    				<input type="text" class="a"  name="horizontal_offset" /><br/><br/>
    				垂直偏移字段：
    				<input type="text" class="a"  name="vertical_offset" /><br/><br/>
    				窗口优先级字段：
		    		<select  name="window_priority"  class="a"> 
						<option value="0">0</option>
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
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
		    		</select><br/><br/><br/><br/>
		    		
		    		<div class="first"> 条件接入描述符：</div><br/>
		    		CA系统ID字段：
    				<input type="text" class="a"  name="CA_system_ID" /><br/><br/>
    				CA PID字段：
    				<input type="text" class="a"  name="CA_PID" /><br/><br/>
    				私有数据：
    				<input type="text" class="a"  name="private_data_byte" /><br/><br/><br/><br/>
    				
    				<div class="first"> ISO_639语言描述符：</div><br/>
    				ISO-639-2语种代码：
    				<input type="text" class="a"  name="IS0_639_language_code" /><br/><br/>
    				音频类型：
    				<select  name="audio_type"  class="a"> 
						<option value="0">未定义</option>
						<option value="1">无声效果</option>
						<option value="2">受损的听力</option>
						<option value="3">受损的视觉的评述</option>
		    		</select><br/><br/><br/><br/>
    				
    				<div class="first"> 系统时钟描述符：</div><br/>
    				外部时钟参考指示符字段：
		    		<select  name="external_clock_reference_indicator" class="a"> 
						<option value="0">无</option>
						<option value="1">系统时钟来源于解码器中可能有的外部频率参考</option>
		    		</select><br/><br/>
		    		时钟精度整数字段：
    				<input type="text" class="a"  name="clock_accuracy_integer" /><br/><br/>
    				时钟精度指数字段：
    				<input type="text" class="a"  name="clock_accuracy_exponent" /><br/><br/><br/><br/>
    				
    				<div class="first"> 复用缓冲区应用描述符：</div><br/>
    				边界有效标志字段：
		    		<select  name="bound_valid_flag" id="bound_valid_flag" class="a" onchange="externalclock();"> 
						<option value="1">有效</option>
						<option value="0">无效</option>
		    		</select><br/><br/>
		    		<div id="external_clock_reference">
			    		LTW偏移下界字段：
	    				<input type="text" class="a"  name="LTW_offset_lower_bound" /><br/><br/>
	    				LTW偏移上界字段：
	    				<input type="text" class="a"  name="LTW_offset_upper_bound" /><br/><br/>
		    		</div><br/><br/>
		    		
		    		<div class="first"> 复用缓冲区应用描述符：</div><br/>
		    		版权标识符字段：
    				<input type="text" class="a"  name="copyright_identifier" /><br/><br/>
    				版权附加信息字段：
    				<input type="text" class="a"  name="additional_copyright_info" /><br/><br/><br/><br/>
    				
    				<div class="first"> 最大比特率描述符：</div><br/>
    				节目元素或节目中比特率上界（50字节/s）：
    				<input type="text" class="a"  name="maximum_bitrate" /><br/><br/><br/><br/>
    				
    				<div class="first"> 专用数据指示符描述符：</div><br/>
    				专用数据指示符：
    				<input type="text" class="a"  name="private_data_indicator" /><br/><br/><br/><br/>
    				
    				<div class="first"> 平滑缓冲区描述符：</div><br/>
    				平滑缓冲区泄露速率字段（单位：400bit/s）：
    				<input type="text" class="a"  name="sb_leak_rate" /><br/><br/>
    				平滑缓冲区大小字段（单位：字节）：
    				<input type="text" class="a"  name="sb_size" /><br/><br/><br/><br/>
    				
    				<div class="first"> STD描述符：</div><br/>
    				泄露有效标志字段：
		    		<select  name="leak_valid_flag"  class="a" > 
						<option value="1">1</option>
						<option value="0">0</option>
		    		</select><br/><br/><br/><br/>
		    		
		    		<div class="first"> IBP描述符：</div><br/>
		    		闭合图像组标志字段：
		    		<select  name="closed_gop_flag"  class="a" > 
						<option value="1">图像头组在每个Ⅰ帧之前编码</option>
						<option value="0">其他</option>
		    		</select><br/><br/>
		    		相同图像组标志字段：
		    		<select  name="identical_gop_flag"  class="a" > 
						<option value="1">Ⅰ帧之间的P帧与B帧的数目，且图像编码类型及Ⅰ图像之间的图像类型序列在整个序列中相同</option>
						<option value="0">其他</option>
		    		</select><br/><br/>
		    		最大图像组长度字段（不能为0）：
    				<input type="text" class="a"  name="max_gop_length" /><br/><br/><br/><br/>
    				
    				<div class="first"> GB/T 20090.2视频流描述符：</div><br/>
    				档次标识：
		    		<select  name="profile_id" class="a">
						<option value="5">简单型（SP）</option>
						<option value="4">主型（MP）</option>
						<option value="3">SNR分级型</option>
						<option value="2">空间分级型</option>
						<option value="1">高型（HP）</option>
		    		</select><br/><br/>
		    		级别标识：
		    		<select  name="level_id" class="a">
						<option value="10">低级（LL）</option>
						<option value="8">主级（ML）</option>
						<option value="6">高级1440（H-1440）</option>
						<option value="4">高级（HL）</option>
		    		</select><br/><br/>
		    		多种帧速率标志：
		    		<select  name="multiple_frame_rate_flag2" class="a">
						<option value="0">单一帧速率</option>
						<option value="1">多种帧速率</option>
		    		</select><br/><br/>
		    		帧速率码字段：
	    			<select  name="frame_rate_code2" class="a">
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
		    		AVS静态图像：
		    		<select  name="AVS_still_present" class="a">
						<option value="0">可包含运动或静态的图像</option>
						<option value="1">只含静态图像</option>
		    		</select><br/><br/>
		    		色差格式字段：
		    		<select  name="chroma_format2" class="a"> 
						<option value="1">4:2:0</option>
						<option value="2">4:2:2</option>
						<option value="3">4:4:4</option>
		    		</select><br/><br/>
		    		采样精度：
    				<input type="text" class="a"  name="sample_precision" /><br/><br/><br/><br/><br/><br/><br/><br/>
    				
   <!-- 流信息 --> 				
    				<div class="first"> 流信息：</div><br/>
    				流类型：
		    		<select  name="stream_type" class="a"> 
						<option value="1">GB/T 17191.2视频</option>
						<option value="2">GB/T 17975.2视频或 GB/T17191.2受限参数视频流</option>
						<option value="3">GB/T 17191.3音频</option>
						<option value="4">GB/T 17975.2音频</option>
						<option value="5">GB/T 17975.1 private_sections</option>
						<option value="6">包含专用数据的 GB/T 17975.1 PES分组</option>
						<option value="7">ISO/IEC 13522 MHEG</option>
						<option value="8">附录A-DSM CC</option>
						<option value="9">IUT-T Rec.H.222.1</option>
						<option value="10">ISO/IEC 13818-6 类型A</option>
						<option value="11">ISO/IEC 13818-6 类型B</option>
						<option value="12">ISO/IEC 13818-6 类型C</option>
						<option value="13">ISO/IEC 13818-6 类型D</option>
						<option value="14">GB/T 17975.1 辅助</option>
						<option value="66">GB/T 20090.3 视频</option>
						<option value="67">GB/T 20090.3 音频</option>
		    		</select><br/><br/>
		    		基本PID：
		    		<input type="text" class="a"  name="elementary_PID" /><br/><br/>
		    		
		    		
		    		<div class="first"> 视频流描述符 GB/T 17975.2或GB/T 17191.2：</div><br/>
		    		多种帧速率标志字段：
	    			<select  name="multiple_frame_rate_flag12" class="a">
						<option value="0">单一帧速率</option>
						<option value="1">多种帧播放速率</option>
		    		</select><br/><br/>
		    		帧速率码字段：
	    			<select  name="frame_rate_code12" class="a">
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
		    		<select  name="MPEG_1_only_flag2" id="MPEG_1_only_flag2" class="a" onchange="MPEG2();">
						<option value="0">可能包含GB/T 17975.2视频数据和受限参数GB/T 17191.2视频数据</option>
						<option value="1">该视频流仅含GB/T 17191.2数据</option>
		    		</select><br/><br/>
		    		受限参数标志字段：
		    		<select  name="constrained_parameter_flag2" class="a">
						<option value="0">可能包含受限参数和非受限的GB/T 17975.2视频数据</option>
						<option value="1">视频流不包括非受限GB/T 17191.2受限数据</option>
		    		</select><br/><br/>
		    		静态图像标志字段：
		    		<select  name="still_picture_flag2" class="a">
						<option value="0">可能包含静态和动态的图像数据</option>
						<option value="1">视频流只含静态图像</option>
		    		</select><br/><br/>
		    		<div id="MPEG_12" >
		    			档次与级别转义比特标志字段：
			    		<select  name="Transferred2" id="Transferred2" class="a" onchange="transferred2();"> 
							<option value="0">0</option>
							<option value="1">1</option>
			    		</select><br/><br/>
			    		<div id="Transferred02" style="display:block;">
			    			型标识：
				    		<select  name="ProfileIdentifier2" class="a">
								<option value="5">简单型（SP）</option>
								<option value="4">主型（MP）</option>
								<option value="3">SNR分级型</option>
								<option value="2">空间分级型</option>
								<option value="1">高型（HP）</option>
				    		</select><br/><br/>
				    		级标识：
				    		<select  name="LevelIdentifier2" class="a">
								<option value="10">低级（LL）</option>
								<option value="8">主级（ML）</option>
								<option value="6">高级1440（H-1440）</option>
								<option value="4">高级（HL）</option>
				    		</select><br/><br/>
			    		</div>
			    		<div id="Transferred12" style="display:none;">
			    			型和级指示：
			    			<select  name="ProfileLevel2" class="a">
								<option value="142">MVP@LL</option>
								<option value="141">MVP@ML</option>
								<option value="139">MVP@H-1440L</option>
								<option value="138">MVP@HL</option>
								<option value="133">4:2:2P@ML</option>
				    		</select><br/><br/>
			    		</div>
			    		色差格式字段：
			    		<select  name="chroma_format12" class="a"> 
							<option value="1">4:2:0</option>
							<option value="2">4:2:2</option>
							<option value="3">4:4:4</option>
			    		</select><br/><br/>
			    		帧速率扩展标志字段：
			    		<select  name="frame_rate_extension_flag2" class="a"> 
							<option value="0">0</option>
							<option value="1">1</option>
			    		</select><br/><br/><br/><br/>
		    		</div>
		    		<div class="first"> 音频流描述符：</div><br/>
		    		自由格式标志字段：
		    		<select  name="free_format_flag2" class="a"> 
						<option value="0">0</option>
						<option value="1">1</option>
		    		</select><br/><br/>
		    		ID字段：
		    		<select  name="ID2" class="a"> 
						<option value="0">0</option>
						<option value="1">1</option>
		    		</select><br/><br/>
		    		层字段：
		    		<select  name="layer2" class="a"> 
						<option value="3">第一层</option>
						<option value="2">第二层</option>
						<option value="1">第三层</option>
		    		</select><br/><br/>
					可变速率音频指示符字段：
		    		<select  name="variable_rate_audio_indicator2" class="a"> 
						<option value="0">连续的音频帧之间相关音频流的比特速率可变</option>
						<option value="1">比特速率不可变</option>
		    		</select><br/><br/><br/><br/>
					
					<div class="first"> 层次描述符：</div><br/>
					ID字段：
		    		<select  name="hierarchy_type2" class="a"> 
						<option value="1">GB/T 17975.2 空间可伸缩性</option>
						<option value="2">GB/T 17975.2 SNR可伸缩扩展性</option>
						<option value="3">GB/T 17975.2 当前可伸缩扩展性</option>
						<option value="4">GB/T 17975.2 数据分割</option>
						<option value="5">GB/T 17975.3 扩展比特流</option>
						<option value="6">GB/T 17975.1 专用流</option>
						<option value="15">基本层</option>
		    		</select><br/><br/>
					层次层索引字段：
    				<input type="text" class="a"  name="hierarchy_layer_index2" /><br/><br/>
					分层嵌入层索引字段：
    				<input type="text" class="a"  name="hierarchy_embedded_layer_index2" /><br/><br/>
					层次通道字段：
    				<input type="text" class="a"  name="hierarchy_channel2" /><br/><br/><br/><br/>
    				
    				<div class="first"> 登记描述符：</div><br/>
    				格式标识符字段：
    				<input type="text" class="a"  name="format_identifier2" /><br/><br/>
    				附加鉴定信息字段：
    				<input type="text" class="a"  name="additional_identification_info2" /><br/><br/><br/><br/>
    				
    				<div class="first"> 数据流对齐描述符：</div><br/>
    				对齐类型字段：
		    		<select  name="alignment_type2" class="a" id="alignment_type2" onchange="alignmenttype2();"> 
						<option value="0">视频流</option>
						<option value="1">音频流</option>
		    		</select><br/><br/>
		    		<div id="alignment02" style="display:block;">
		    			视频流对齐值：
			    		<select  name="alignment_type02"  class="a"> 
							<option value="1">片或视频接入单元</option>
							<option value="2">视频接入单元</option>
							<option value="3">GOP或SEG</option>
							<option value="4">SEQ</option>
			    		</select><br/><br/>
		    		</div>
		    		<div id="alignment12" style="display:none;">
		    			音频流对齐值：
			    		<select  name="alignment_type12"  class="a"> 
							<option value="1">同步字</option>
			    		</select><br/><br/>
		    		</div><br/><br/>
		    		<div class="first"> 目标背景栅格描述符：</div><br/>
		    		水平尺寸字段（像素）：
    				<input type="text" class="a"  name="horizontal_size2" /><br/><br/>
    				垂直尺寸字段（像素）：
    				<input type="text" class="a"  name="vertical_size2" /><br/><br/>
    				像素宽高比/DAR：
		    		<select  name="aspect_ratio_information2"  class="a"> 
						<option value="0">禁止</option>
						<option value="1">1.0（方像素）</option>
						<option value="2">3/4</option>
						<option value="3">9/16</option>
						<option value="4">1/2.21</option>
		    		</select><br/><br/><br/><br/>
		    		
		    		<div class="first"> 视频窗描述符：</div><br/>
		    		水平偏移字段：
    				<input type="text" class="a"  name="horizontal_offset2" /><br/><br/>
    				垂直偏移字段：
    				<input type="text" class="a"  name="vertical_offset2" /><br/><br/>
    				窗口优先级字段：
		    		<select  name="window_priority2"  class="a"> 
						<option value="0">0</option>
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
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
		    		</select><br/><br/><br/><br/>
		    		
		    		<div class="first"> 条件接入描述符：</div><br/>
		    		CA系统ID字段：
    				<input type="text" class="a"  name="CA_system_ID2" /><br/><br/>
    				CA PID字段：
    				<input type="text" class="a"  name="CA_PID2" /><br/><br/>
    				私有数据：
    				<input type="text" class="a"  name="private_data_byte2" /><br/><br/><br/><br/>
    				
    				<div class="first"> ISO_639语言描述符：</div><br/>
    				ISO-639-2语种代码：
    				<input type="text" class="a"  name="IS0_639_language_code2" /><br/><br/>
    				音频类型：
    				<select  name="audio_type2"  class="a"> 
						<option value="0">未定义</option>
						<option value="1">无声效果</option>
						<option value="2">受损的听力</option>
						<option value="3">受损的视觉的评述</option>
		    		</select><br/><br/><br/><br/>
    				
    				<div class="first"> 系统时钟描述符：</div><br/>
    				外部时钟参考指示符字段：
		    		<select  name="external_clock_reference_indicator2" class="a"> 
						<option value="0">无</option>
						<option value="1">系统时钟来源于解码器中可能有的外部频率参考</option>
		    		</select><br/><br/>
		    		时钟精度整数字段：
    				<input type="text" class="a"  name="clock_accuracy_integer2" /><br/><br/>
    				时钟精度指数字段：
    				<input type="text" class="a"  name="clock_accuracy_exponent2" /><br/><br/><br/><br/>
    				
    				<div class="first"> 复用缓冲区应用描述符：</div><br/>
    				边界有效标志字段：
		    		<select  name="bound_valid_flag2" id="bound_valid_flag2" class="a" onchange="externalclock2();"> 
						<option value="1">有效</option>
						<option value="0">无效</option>
		    		</select><br/><br/>
		    		<div id="external_clock_reference2">
			    		LTW偏移下界字段：
	    				<input type="text" class="a"  name="LTW_offset_lower_bound2" /><br/><br/>
	    				LTW偏移上界字段：
	    				<input type="text" class="a"  name="LTW_offset_upper_bound2" /><br/><br/>
		    		</div><br/><br/>
		    		
		    		<div class="first"> 复用缓冲区应用描述符：</div><br/>
		    		版权标识符字段：
    				<input type="text" class="a"  name="copyright_identifier2" /><br/><br/>
    				版权附加信息字段：
    				<input type="text" class="a"  name="additional_copyright_info2" /><br/><br/><br/><br/>
    				
    				<div class="first"> 最大比特率描述符：</div><br/>
    				节目元素或节目中比特率上界（50字节/s）：
    				<input type="text" class="a"  name="maximum_bitrate2" /><br/><br/><br/><br/>
    				
    				<div class="first"> 专用数据指示符描述符：</div><br/>
    				专用数据指示符：
    				<input type="text" class="a"  name="private_data_indicator2" /><br/><br/><br/><br/>
    				
    				<div class="first"> 平滑缓冲区描述符：</div><br/>
    				平滑缓冲区泄露速率字段（单位：400bit/s）：
    				<input type="text" class="a"  name="sb_leak_rate2" /><br/><br/>
    				平滑缓冲区大小字段（单位：字节）：
    				<input type="text" class="a"  name="sb_size2" /><br/><br/><br/><br/>
    				
    				<div class="first"> STD描述符：</div><br/>
    				泄露有效标志字段：
		    		<select  name="leak_valid_flag2"  class="a" > 
						<option value="1">1</option>
						<option value="0">0</option>
		    		</select><br/><br/><br/><br/>
		    		
		    		<div class="first"> IBP描述符：</div><br/>
		    		闭合图像组标志字段：
		    		<select  name="closed_gop_flag2"  class="a" > 
						<option value="1">图像头组在每个Ⅰ帧之前编码</option>
						<option value="0">其他</option>
		    		</select><br/><br/>
		    		相同图像组标志字段：
		    		<select  name="identical_gop_flag2"  class="a" > 
						<option value="1">Ⅰ帧之间的P帧与B帧的数目，且图像编码类型及Ⅰ图像之间的图像类型序列在整个序列中相同</option>
						<option value="0">其他</option>
		    		</select><br/><br/>
		    		最大图像组长度字段（不能为0）：
    				<input type="text" class="a"  name="max_gop_length2" /><br/><br/><br/><br/>
    				
    				<div class="first"> GB/T 20090.2视频流描述符：</div><br/>
    				档次标识：
		    		<select  name="profile_id2" class="a">
						<option value="5">简单型（SP）</option>
						<option value="4">主型（MP）</option>
						<option value="3">SNR分级型</option>
						<option value="2">空间分级型</option>
						<option value="1">高型（HP）</option>
		    		</select><br/><br/>
		    		级别标识：
		    		<select  name="level_id2" class="a">
						<option value="10">低级（LL）</option>
						<option value="8">主级（ML）</option>
						<option value="6">高级1440（H-1440）</option>
						<option value="4">高级（HL）</option>
		    		</select><br/><br/>
		    		多种帧速率标志：
		    		<select  name="multiple_frame_rate_flag22" class="a">
						<option value="0">单一帧速率</option>
						<option value="1">多种帧速率</option>
		    		</select><br/><br/>
		    		帧速率码字段：
	    			<select  name="frame_rate_code22" class="a">
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
		    		AVS静态图像：
		    		<select  name="AVS_still_present2" class="a">
						<option value="0">可包含运动或静态的图像</option>
						<option value="1">只含静态图像</option>
		    		</select><br/><br/>
		    		色差格式字段：
		    		<select  name="chroma_format22" class="a"> 
						<option value="1">4:2:0</option>
						<option value="2">4:2:2</option>
						<option value="3">4:4:4</option>
		    		</select><br/><br/>
		    		采样精度：
    				<input type="text" class="a"  name="sample_precision2" /><br/><br/><br/><br/>
	    		</div>
		    		
	    		
    		</div><!-- EBM -->
    	
  

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
