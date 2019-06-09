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
  
  
    <form action="/eb/EBServlet" enctype="multipart/form-data" method="post" onsubmit="return check_submit();">
    
    	
    	<br/>
    	应急事件类型：
    	<select id="EventType" name="EventType" class="a">
			<option value="Natural Disaster">自然灾害</option>
			<option value="Accident Disaster">事故灾难</option>
			<option value="Public Health Events">公共卫生事件</option>
			<option value="Social Security Incidents">社会安全事件</option>
    	</select><span class="asterisk">*</span><br/><br/>
    	 应急事件级别：
    	<select id="EventLevel" name="EventLevel" class="a">
			<option value="01">红色或核应急事件场外应急（Ⅰ级响应）</option>
			<option value="02">橙色或核应急事件场区应急（Ⅱ级响应）</option>
			<option value="03">黄色或核应急事件厂房应急（Ⅲ级响应）</option>
			<option value="04">蓝色或核应急事件应急待命（Ⅳ级响应）</option>
    	</select><span class="asterisk">*</span><br/><br/>
    	 应急广播信息类型：
    	<select id="InfoType" name="InfoType" class="a">
			<option value="01">实际</option>
			<option value="02">演练</option>
			<option value="03">测试</option>
			<option value="04">预留</option>
    	</select><span class="asterisk">*</span><br/><br/>
    	 应急广播信息状态：
    	<select id="InfoStatus" name="InfoStatus" class="a">
			<option value="01">首发</option>
			<option value="02">更新</option>
			<option value="03">取消</option>
			<option value="04">错误</option>
			<option value="04">预留</option>
    	</select><span class="asterisk">*</span><br/><br/>
    	
    	 信息发布类型：
    	<select id="IsMediaRes" name="IsMediaRes" class="a">
			<option value="0">没有发布手段</option>
			<option value="1">有发布手段</option>
    	</select><span class="asterisk">*</span><br/><br/>
    	
    	 应对措施说明：
    	<input type="text" class="a" name="Instructions" /><br/><br/>
    	
    	
    	
    	<div class="first"> 应急广播内容：</div><br/>
    	
    	 应急广播信息标题：
    	<input id="Headline" type="text" class="a" name="Headline" /><span class="asterisk">*</span><br/><br/>
    	 应急广播信息描述：
    	<input id="EventDescription" type="text" class="a" name="EventDescription" /><span class="asterisk">*</span><br/><br/>
    	 指定频道节目号：
    	<input type="text" class="a" name="ProgramNum" /><br/><br/>
    	 签发人：
    	<input type="text" class="a" name="Signer" /><br/><br/><br/><br/>
    	
    	
    	
    	
    	
    	
    	
    	
    	<div class="first"> 信息建议性发布策略：</div><br/>
    	 发布范围：
    	<input id="PublishRegion" type="text" class="a" name="PublishRegion" /><span class="asterisk">*</span><br/><br/>
    	 播发开始时间：
    	<input id="BroadcastDateTime" type="date"  class="a" name="BroadcastDateTime" /><span class="asterisk">*</span><br/><br/>
    	 播发结束时间：
    	<input type="date" class="a"  name="OverDateTime" /><br/><br/>
    	
    	<div class="first"> 发布样式：</div><br/>
    	 发布手段：
    	<select id="PublishMeans" name="PublishMeans" class="a">
			<option value="0201">广播电视台</option>
			<option value="0202">电台</option>
			<option value="0203">电视台</option>
			<option value="0301">调频广播</option>
			<option value="0302">有线数字电视</option>
			<option value="0303">地面数字电视</option>
			<option value="0304">有线模拟电视</option>
			<option value="0305">地面模拟电视</option>
			<option value="0306">中波广播</option>
			<option value="0307">短波广播</option>
			<option value="0308">直播卫星</option>
			<option value="0309">卫星电视</option>
			<option value="0310">移动多媒体广播电视</option>
			<option value="0311">数字音频广播</option>
			<option value="0312">机动应急广播</option>
			<option value="0313">IPTV</option>
			<option value="0314">应急广播大喇叭系统</option>
			<option value="0315~0339">中央级预留</option>
			<option value="0340~0359">省级预留</option>
			<option value="0360~0379">市级预留</option>
			<option value="0380~0398">县级预留</option>
			<option value="0399">多类型台站/前端</option>
    	</select><span class="asterisk">*</span><br/><br/>
    	呈现方式：
    	<select id="Presentation" name="Presentation" class="a">
			<option value="0100">日常播出(电视台)</option>
			<option value="0102">播出-角标(电视台)</option>
			<option value="0103">播出-字幕-按发布频次播出(电视手段)</option>
			<option value="0104">播出-字幕-连续播出(电视手段)</option>
			<option value="0108">主持人立即直播(电视)</option>
			<option value="0201">跳转(直播星)</option>
			<option value="0301">日常播出(广播)</option>
			<option value="0302">主持人立即直播(广播)</option>
			<option value="0501">按时播出(应急广播大喇叭系统手段)</option>
			<option value="0502">播出(应急广播大喇叭系统手段)</option>
    	</select><span class="asterisk">*</span><br/><br/>
    	 发布频次：
    	<input id="PublishFrequency" type="text" class="a" name="PublishFrequency" /><span class="asterisk">*</span><br/><br/>
    	 频率内次数：
    	<input id="RollFrequency" type="text" class="a" name="RollFrequency" /><span class="asterisk">*</span><br/><br/>
  		<br/>
  		
  		<div id="attDiv">
    	</div>
    	
    	<input type="button" class="a button button-primary button-rounded button-small" value="添加一项附件" onclick="addAtt()"/><br/>
  		<br/><br/>
  
  
     
        
  
  		<div id="ebi" style="display:none;">
  		
  
  		<div id="earthDiv">
  			<input type="button" class="a button button-primary button-rounded button-small" value="添加地震类扩展信息" onclick="addEarth()"/><br/><br/><br/>
    		<input type="hidden" name="earth" value="0" />
  		</div>
  		
    	
    	
    	
    	<div id="airDiv">
    		<input type="button" class="a button button-primary button-rounded button-small" value="添加民航机场类扩展信息" onclick="addAir()"/><br/><br/><br/>
    		<input type="hidden" name="air" value="0" />
    	</div>
  		<div class="first">1 应急广播信息主体：</div><br/>
    	<div class="first">1.1 应急广播基础信息：</div><br/>
    	1.1.1 协议版本号：
    	<input id="EBIVersion" type="text" class="a" name="EBIVersion" value="1"/><span class="asterisk">*</span><br/><br/>
    	1.1.2 应急广播信息ID：
    	<input id="InfoID" type="text" class="a" name="InfoID" /><span class="asterisk">*</span><br/><br/>
    	1.1.3 源应急信息发布机构名称：
    	<input type="text" class="a" name="Sender" /><br/><br/>
    	1.1.4 源应急信息发布机构编码：
    	<input type="text" class="a" name="SenderCode" /><br/><br/>
    	1.1.5 源应急信息ID：
    	<input type="text" class="a" name="Identifier" /><br/><br/>
    	
    	1.1.10 引用应急广播信息ID：
    	<input type="text" class="a" name="ReferenceId" /><br/><br/>
    	
    	
    	1.1.12 音频文件标志位：
    	<select id="IsTTS" name="IsTTS" class="a">
			<option value="1">已制作文转语音频文件</option>
			<option value="2">不会制作文转语音频文件</option>
			<option value="3">制作视频文件</option>
			<option value="4">不会制作视频文件</option>
    	</select><span class="asterisk">*</span><br/><br/>
    	
    	
    	1.2.1 语言：
    	<input id="Language" type="text" class="a" name="Language" /><span class="asterisk">*</span><br/><br/>
    	1.2.2 语种代码：
    	<input id="LanguageCode" type="text" class="a" name="LanguageCode" /><span class="asterisk">*</span><br/><br/>
    	1.2.3 编码字符集：
    	<input id="CodeSet" type="text" class="a" name="CodeSet" /><span class="asterisk">*</span><br/><br/>
    	
  		<div class="first">1.5 区域信息：</div><br/>
        1.5.1 地理区域描述：
        <input type="text" class="a" name="AreaDescription" /><br/><br/>
        1.5.2 地理区域多边形表示：
        <input type="text" class="a" name="AreaPolygon" /><br/><br/>
        1.5.3 地理区域椭圆形表示：
        <input type="text" class="a" name="AreaCircle" /><br/><br/>
        
        
        
        <div class="first">2 应急广播业务数据：</div><br/>
        2.1 协议版本号：
        <input type="text" class="a" name="EBDVersion" value="1"/><br/><br/>
        2.2 数据包编号：
        <input type="text" class="a" name="EBDID" /><br/><br/>
        2.3 数据包类型：
        <input type="text" class="a" name="EBDType" /><br/><br/>
        
        <div class="first">2.4 数据包来源对象：</div><br/>
        2.4.1 数据包来源对象的资源编码：
        <input type="text" class="a" name="SRC_EBRID" /><br/><br/>
        2.4.2 数据包来源对象的网络地址：
        <input type="text" class="a" name="SRC_URL" /><br/><br/>
         
        <div class="first">2.5 数据包目标对象：</div><br/>
        2.5.1 数据包目标对象的资源编码：
        <input type="text" class="a" name="DEST_EBRID" /><br/><br/>
        2.6 数据包生成时间：
        <input type="text" class="a" name="EBDTime" /><br/><br/>
        
        <div class="first">2.7 关联数据包：</div><br/>
        2.7.1 关联数据包编号：
        <input type="text" class="a" name="Re_EBDID" /><br/><br/>
        <div class="first">2.8 应急广播消息：</div><br/>
        
        2.8.1 应急广播消息协议版本号：
        <input type="text" class="a" name="EBMVersion" value="1"/><br/><br/>
        2.8.2 应急广播消息编号：
        <input type="text" class="a" name="EBMID" /><br/><br/>
        2.8.3 关联应急广播信息编号：
        <input type="text" class="a" name="Re_EBIID" /><br/><br/>
        2.8.4 关联应急广播消息编号：
        <input type="text" class="a" name="Re_EBMID" /><br/><br/>
        
        <div class="first">2.8.5 消息基本信息：</div><br/>
        2.8.5.1 消息类型：
        <select name="MsgType" class="a">
			<option value="1">实际播发</option>
			<option value="2">取消播发</option>
			<option value="3">平台演练播发</option>
			<option value="4">前端演练播发</option>
			<option value="5">终端演练播发</option>
    	</select><br/><br/>
        2.8.5.2 发布机构名称：
        <input type="text" class="a" name="SenderName" /><br/><br/>
        2.8.5.3 发布机构编码：
        <input type="text" class="a" name="SenderCode2" /><br/><br/>
        2.8.5.3 发布时间：
        <input type="text" class="a" name="SendTime"/><br/><br/>
        2.8.5.5 时间类型编码：
        <input type="text" class="a" name="EventType2" /><br/><br/>
        2.8.5.6 事件级别：
        <select name="Severity" class="a">
        	<option value="0">未知级别（Unknown）</option>
			<option value="1">1 级（特别重大/红色预警/Red）</option>
			<option value="2">2 级（重大/橙色预警/Orange）</option>
			<option value="3">3 级（较大/黄色预警/Yellow）</option>
			<option value="4">4 级（一般/蓝色预警/Blue）</option>
    	</select><br/><br/>
        2.8.5.7 播发开始时间：
        <input type="text" class="a" name="StartTime" /><br/><br/>
        2.8.5.8 播发结束时间：
        <input type="text" class="a" name="EndTime" /><br/><br/>
        
        <div class="first">2.8.6 应急广播消息内容：</div><br/>
        2.8.6.1 语种代码：
        <input type="text" class="a" name="LanguageCode2" /><br/><br/>
        2.8.6.2 消息标题文本：
        <input type="text" class="a" name="MsgTitle" /><br/><br/>
        2.8.6.3 消息内容文本：
        <input type="text" class="a" name="MsgDesc" /><br/><br/>
        2.8.6.4 覆盖区域编码：
        <input type="text" class="a" name="AreaCode" /><br/><br/>
        2.8.6.5 详情频道节目号：
        <input type="text" class="a" name="ProgramNum2" /><br/><br/>
        
        
        2.8.6.6 辅助数据类型：
        <select name="AuxiliaryType" class="a">
        	<option value="0">保留</option>
			<option value="1">MPEG-1 LayerI/II 音频文件</option>
			<option value="2">MPEG-1 LayerIII 音频文件</option>
			<option value="3">DRA 音频文件</option>
			<option value="4">DRA+音频文件</option>
			<option value="5~40">预留</option>
			<option value="41">PNG 图片文件</option>
			<option value="42">JPEG 图片文件</option>
			<option value="43">GIF 图片文件</option>
			<option value="44~60">预留</option>
			<option value="61">音视频流</option>
			<option value="62~255">预留</option>
    	</select><br/><br/>
        2.8.6.7 辅助数据描述：
        <input type="text" class="a" name="AuxiliaryDesc" /><br/><br/>
        2.8.6.8 辅助数据文件大小：
        <input type="text" class="a" name="Size" /><br/><br/>
        2.8.6.9 辅助数据文件摘要：
        <input type="text" class="a" name="Digest2" /><br/><br/>
        
        
        <div class="first">2.8.7 调用资源信息：</div><br/>
        2.8.7.1 语种代码：
        <input type="text" class="a" name="LanguageCode2" /><br/><br/>
        
        2.8.7.2 应急广播平台编号：
        <input type="text" class="a" name="EBRPS_EBRID" /><br/><br/>
        2.8.7.3 电台/电视台编号：
        <input type="text" class="a" name="EBRRTS_EBRID" /><br/><br/>
        2.8.7.4 应急广播适配器编号：
        <input type="text" class="a" name="EBRAS_EBRID" /><br/><br/>
        2.8.7.5 传输覆盖播出设备类型：
        <input type="text" class="a" name="BrdSysType" /><br/><br/>
        2.8.7.6 传输覆盖播出设备详情：
        <input type="text" class="a" name="BrdSysInfo" /><br/><br/>
        </div>
        <a href="javascript:showebi();" id="ebihref" class="a button button-primary button-rounded button-small">展开其他信息</a><br/><br/><br/>
        
  
  		

  		
		<br/><br/>
  		<input type="submit" class="a button button-primary button-rounded button-small" value="提交" />  <br/>
    </form>
 
  </div>
  </body>
</html>
