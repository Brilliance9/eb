<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  
  		<div class="first">1.2.8 附件信息：</div><br/>
    	1.2.8.1 附件名称：
    	<input type="text" class="a" name="AttName" /><br/><br/>
    	1.2.8.2 附件描述：
    	<input type="text" class="a" name="AttDescription" /><br/><br/>
    	1.2.8.3 附件大小（Byte）：
    	<input type="text" class="a" name="AttSize" /><br/><br/>
    	1.2.8.4 附件类型：
    	<select name="AttType" class="a">
			<option value="01">视频</option>
			<option value="02">音频</option>
			<option value="03">数字图像</option>
			<option value="04">文档</option>
			<option value="04">预留</option>
    	</select><br/><br/>
    	1.2.8.5 附件扩展名：
    	<input type="text" class="a" name="AttSuffix" /><br/><br/>
    	1.2.8.6 附件位置：
    	<input type="text" class="a" name="AttURL" /><br/><br/>
    	1.2.8.7 附件摘要编码：
    	<input type="text" class="a" name="Digest" /><br/><br/>
  
  
  
  		<div class="first">1.4.1 地震类扩展信息：</div><br/>1 震中所在行政区划编码：<input type="text" class="a" name="location_code" /><br/><br/>2 震中所在行政区划：<input type="text" class="a" name="place" /><br/><br/>3 地震发生时间：<input type="text" class="a" name="earthquake_time" /><br/><br/>4 地震震级：<input type="text" class="a" name="level" /><br/><br/>5 震源深度（公里）：<input type="text" class="a" name="depth" /><br/><br/>6 地震震中经度：<input type="text" class="a" name="longitude" /><br/><br/>7 地震震中纬度：<input type="text" class="a" name="latitude" /><br/><br/>8 地震类型：<select name="eq_type" class="a"><option value="自然地震">自然地震</option><option value="人工地震">人工地震</option></select><br/><br/>9 地震信息类型：<select name="expedited_reporting_type" class="a"><option value="自然速报">自然速报</option><option value="正式速报">正式速报</option><option value="其他">其他</option></select><br/><br/>10 距离震中最近的省会城市的信息：<input type="text" class="a" name="nearest_provincial_capital" /><br/><br/>11 省会列表：<input type="text" class="a" name="shenghui" /><br/><br/>12 距离震中最近的地级市的信息：<input type="text" class="a" name="nearest_prefecture" /><br/><br/>13 地级市列表：<input type="text" class="a" name="dijishi" /><br/><br/>14 距离震中最近的县级市的信息：<input type="text" class="a" name="nearest_county" /><br/><br/>15 县级市列表：<input type="text" class="a" name="xianjishi" /><br/><br/>16 震中附近的村庄：<input type="text" class="a" name="nearest_village" /><br/><br/>17 村庄列表：<input type="text" class="a" name="villages" /><br/><br/>18 震中附近的乡镇：<input type="text" class="a" name="nearest_town" /><br/><br/>19 乡镇列表：<input type="text" class="a" name="towns" /><br/><br/>20 距离：<input type="text" class="a" name="juli" /><br/><br/>21 震中方圆范围：<input type="text" class="a" name="range" /><br/><br/>22 地震信息综合描述：<input type="text" class="a" name="Seismic_information" /><br/><br/>23 天气：<input type="text" class="a" name="WEATHER" /><br/><br/>24 海拔（米）：<input type="text" class="a" name="altitude" /><br/><br/>25 人口（万人）：<input type="text" class="a" name="population" /><br/><br/>26 面积（平方公里）：<input type="text" class="a" name="area" /><br/><br/>27 人均GDP（万元）：<input type="text" class="a" name="gdp" /><br/><br/>28 最近五次地震信息：<input type="text" class="a" name="five_earthquake" /><br/><br/><input type="button" class="a button button-primary button-rounded button-small" value="删除地震类扩展信息" onclick="deleteAtt(this)"/><br/><br/>
    	
    	
    	
    	
    	<div class="first">1.4.1 地震类扩展信息：</div><br/> 
    	1.4.1.1 震中所在行政区划编码：
    	<input type="text" class="a" name="location_code" /><br/><br/>
    	1.4.1.2 震中所在行政区划：
    	<input type="text" class="a" name="place" /><br/><br/>
    	1.4.1.3 地震发生时间：
    	<input type="text" class="a" name="earthquake_time" /><br/><br/>
    	1.4.1.4 地震震级：
    	<input type="text" class="a" name="level" /><br/><br/>
    	1.4.1.5 震源深度（公里）：
    	<input type="text" class="a" name="depth" /><br/><br/>
    	1.4.1.6 地震震中经度：
    	<input type="text" class="a" name="longitude" /><br/><br/>
    	1.4.1.7 地震震中纬度：
    	<input type="text" class="a" name="latitude" /><br/><br/>
    	1.4.1.8 地震类型：
    	<select name="eq_type" class="a">
			<option value="自然地震">自然地震</option>
			<option value="人工地震">人工地震</option>
    	</select><br/><br/>
    	1.4.1.9 地震信息类型：
    	<select name="expedited_reporting_type" class="a">
			<option value="自然速报">自然速报</option>
			<option value="正式速报">正式速报</option>
			<option value="其他">其他</option>
    	</select><br/><br/>
    	1.4.1.10 距离震中最近的省会城市的信息：
    	<input type="text" class="a" name="nearest_provincial_capital" /><br/><br/>
    	1.4.1.11 省会列表：
    	<input type="text" class="a" name="shenghui" /><br/><br/>
    	1.4.1.12 距离震中最近的地级市的信息：
    	<input type="text" class="a" name="nearest_prefecture" /><br/><br/>
    	1.4.1.13 地级市列表：
    	<input type="text" class="a" name="dijishi" /><br/><br/>
    	1.4.1.14 距离震中最近的县级市的信息：
    	<input type="text" class="a" name="nearest_county" /><br/><br/>
    	1.4.1.15 县级市列表：
    	<input type="text" class="a" name="xianjishi" /><br/><br/>
    	1.4.1.16 震中附近的村庄：
    	<input type="text" class="a" name="nearest_village" /><br/><br/>
    	1.4.1.17 村庄列表：
    	<input type="text" class="a" name="villages" /><br/><br/>
    	1.4.1.18 震中附近的乡镇：
    	<input type="text" class="a" name="nearest_town" /><br/><br/>
    	1.4.1.19 乡镇列表：
    	<input type="text" class="a" name="towns" /><br/><br/>
    	1.4.1.20 距离：
    	<input type="text" class="a" name="juli" /><br/><br/>
    	1.4.1.21 震中方圆范围：
    	<input type="text" class="a" name="range" /><br/><br/>
    	1.4.1.22 地震信息综合描述：
    	<input type="text" class="a" name="Seismic_information" /><br/><br/>
    	1.4.1.23 天气：
    	<input type="text" class="a" name="WEATHER" /><br/><br/>
    	1.4.1.24 海拔（米）：
    	<input type="text" class="a" name="altitude" /><br/><br/>
    	1.4.1.25 人口（万人）：
    	<input type="text" class="a" name="population" /><br/><br/>
    	1.4.1.26 面积（平方公里）：
    	<input type="text" class="a" name="area" /><br/><br/>
    	1.4.1.27 人均GDP（万元）：
    	<input type="text" class="a" name="gdp" /><br/><br/>
    	1.4.1.28 最近五次地震信息：
    	<input type="text" class="a" name="five_earthquake" /><br/><br/>
 
    
        <div class="first">1.4.2 民航机场类扩展信息：</div><br/>
        1.4.2.1 民航机场名称：
        <input type="text" class="a" name="Airport" /><br/><br/>
        1.4.2.2 民航机场代码：
        <input type="text" class="a" name="Airportcode" /><br/><br/>
        1.4.2.3 入港航班架次：
        <input type="text" class="a" name="Inbound_flights" /><br/><br/>
        1.4.2.4 出港航班架次：
        <input type="text" class="a" name="Outbound_flights" /><br/><br/>
        1.4.2.5 入港旅客人数：
        <input type="text" class="a" name="Inbound_numberofpeople" /><br/><br/>
        1.4.2.6 出港旅客人数：
        <input type="text" class="a" name="Outbound_numberofpeople" /><br/><br/>
        1.4.2.7 入港延误航班架次：
        <input type="text" class="a" name="Inbound_Delayedflights" /><br/><br/>
        1.4.2.8 出港延误航班架次：
        <input type="text" class="a" name="Outbound_Delayedflights" /><br/><br/>
        1.4.2.9 民航机场状态：
        <select name="AirportStatus" class="a">
			<option value="1">流量正常</option>
			<option value="2">大面积延误</option>
			<option value="3">民航机场关闭</option>
			<option value="4">民航机场（重新）开放</option>
    	</select><br/><br/>
        1.4.2.10 入港延误航班号：
        <input type="text" class="a" name="Inbound_flights_number" /><br/><br/>
        1.4.2.11 出港延误航班号：
        <input type="text" class="a" name="Outbound_flightsnumber" /><br/><br/>
        1.4.2.12 监测时间：
        <input type="text" class="a" name="Time" /><br/><br/>
        
        
        <div class="first">1.4.2 民航机场类扩展信息：</div><br/>1 民航机场名称：<input type="text" class="a" name="Airport" /><br/><br/>2 民航机场代码：<input type="text" class="a" name="Airportcode" /><br/><br/>3 入港航班架次：<input type="text" class="a" name="Inbound_flights" /><br/><br/>4 出港航班架次：<input type="text" class="a" name="Outbound_flights" /><br/><br/>5 入港旅客人数：<input type="text" class="a" name="Inbound_numberofpeople" /><br/><br/>6 出港旅客人数：<input type="text" class="a" name="Outbound_numberofpeople" /><br/><br/>7 入港延误航班架次：<input type="text" class="a" name="Inbound_Delayedflights" /><br/><br/>8 出港延误航班架次：<input type="text" class="a" name="Outbound_Delayedflights" /><br/><br/>9 民航机场状态：<select name="AirportStatus" class="a"><option value="1">流量正常</option><option value="2">大面积延误</option><option value="3">民航机场关闭</option><option value="4">民航机场（重新）开放</option></select><br/><br/>10 入港延误航班号：<input type="text" class="a" name="Inbound_flights_number" /><br/><br/>11 出港延误航班号：<input type="text" class="a" name="Outbound_flightsnumber" /><br/><br/>1.4.2.12 监测时间：<input type="text" class="a" name="Time" /><br/><br/><br/><br/><input type="button" class="a button button-primary button-rounded button-small" value="删除民航机场类扩展信息" onclick="deleteAir()"/><br/><br/><br/><br/>
    	
        
    <div class="pn">
		<p>博主简介</p>
		<p>湖南人，90后，爱笑的女娃</p>
		<div class="hpn" id="mm" style="display:none;">
			<p>特点：人长得很特很特点</p>
			<p>爱好：看电影睡觉爬山</p>
		</div>
	</div>
	<p class="slide"><a href="javascript:showdiv();" id="strhref" class="btn-show">展开</a></p>
	<script type="text/javascript">
		function showdiv(){
			document.getElementById('mm').style.display = 'block';
			document.getElementById('strhref').innerHTML="收起";
			document.getElementById('strhref').href="javascript:hidediv()";
		}
		function hidediv(){
			document.getElementById('mm').style.display = 'none';
			document.getElementById('strhref').innerHTML="展开";
			document.getElementById('strhref').href="javascript:showdiv()";
 
		}
	</script>
  </body>
</html>
