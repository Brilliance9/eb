<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="util.*"%>
<%@ page import="EBIEntity.*"%>
<%@page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>应急广播消息详细信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/event.css">
	<link rel="stylesheet" type="text/css" href="./css/button.css">

  </head>
  
  <body class="bg">
 	<%
 	EB eb=(EB)request.getAttribute("eb");
 	%>
  <header class="header-container">
   <span class="title"></span>  
  </header>
  <div class="main">
  	<div class="EBI">
  		<span class="line"></span>
   		<span class="line"></span>
   		<div class="header">
   			<div class="title">应急广播信息主体信息</div>
<!--    			<a class="my-select button button-primary button-rounded button-small" href="/eb/Index">返回主页</a> -->
        
            <a class="delete button button-primary button-rounded button-small" 
            	href="/eb/EBServlet?ID=<%=eb.getID() %>&method=delete">删除</a>
            <a class="make button button-primary button-rounded button-small" 
          		href="/eb/EBServlet?ID=<%=eb.getID() %>&method=make">制作广播</a>
        
       
      </div>
   		<ul class="table-container">
        	<li class="table-item">
        	 <div>
            	<span class="cell">类型</span>
          	 </div>
          	 <div>
            	<span class="cell">内容</span>
          	 </div>
        	</li>
        	<li class="table-item">
          		<div class="first">应急广播基础信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="second">协议版本号</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getEBIVersion() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应 急 广 播 信 息ID</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getInfoID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">数据包编号</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getEBIID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">源 应 急 信 息 发布机构名称</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getSender() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">源应急信息发布机构编码</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getSenderCode() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">源应急信息 ID</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getIdentifier() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应急事件类型</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getEventType() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应急事件级别</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getEventLevel() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应急广播信息类型</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getInfoType() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应急广播信息状态</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getInfoStatus() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">引用应急广播信息 ID</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getReferenceId() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">信息发布类型</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getIsMediaRes() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">音频文件标志位</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getIsTTS() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应对措施说明</div>
         	 	<div><%=eb.getEBI().getEBMainInfo().getInstructions() %></div>
        	</li>
        	<li class="table-item">
          		<div class="first">应急广播内容</div>
         	 	<div></div>
        	</li>
        	<%
        	for(int i=0;i<eb.getEBI().getEBContent().length;i++){
        	%>
        	<li class="table-item">
          		<div class="first">应急广播内容<%=i+1 %></div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="second">语言</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getLanguage() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">语种代码</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getLanguageCode() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">编码字符集</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getCodeSet() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应急广播信息标题</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getHeadline() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应急广播信息描述</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getEventDescription() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">指定频道节目号</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getProgramNum() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">签发人</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getSigner() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">附件</div>
         	 	<div></div>
        	</li>
        	<%
        	for(int j=0;j<eb.getEBI().getEBContent()[i].getAttachments().length;j++){
        	%>
        	<li class="table-item">
          		<div class="second">附件<%=j+1 %></div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="third">附件名称</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getAttachments()[j].getAttName() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">附件描述</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getAttachments()[j].getAttDescription() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">附件大小</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getAttachments()[j].getAttSize() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">附件类型</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getAttachments()[j].getAttType() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">附件扩展名</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getAttachments()[j].getAttSuffix() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">附件位置</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getAttachments()[j].getAttURL() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">附件摘要编码</div>
         	 	<div><%=eb.getEBI().getEBContent()[i].getAttachments()[j].getDigest() %></div>
        	</li>     	
        	<%
        	}
        	%>      	
        	<%
        	}
        	%>
        	<li class="table-item">
          		<div class="first">信息建议性发布策略</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="second">发布范围</div>
         	 	<div><%=eb.getEBI().getPublishStrategy().getPublishRegion() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">播发开始时间</div>
         	 	<div><%=eb.getEBI().getPublishStrategy().getBroadcastDateTime() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">播发结束时间</div>
         	 	<div><%=eb.getEBI().getPublishStrategy().getOverDateTime() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">发布样式</div>
         	 	<div></div>
        	</li>
        	<%
        	for(int i=0;i<eb.getEBI().getPublishStrategy().getBroadcastStyle().length;i++){
        	%>
        	<li class="table-item">
          		<div class="second">发布样式<%=i+1 %></div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="third">发布手段</div>
         	 	<div><%=eb.getEBI().getPublishStrategy().getBroadcastStyle()[i].getPublishMeans() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">呈现方式</div>
         	 	<div><%=eb.getEBI().getPublishStrategy().getBroadcastStyle()[i].getPresentation() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">发布频次</div>
         	 	<div><%=eb.getEBI().getPublishStrategy().getBroadcastStyle()[i].getPublishFrequency() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">频率内次数</div>
         	 	<div><%=eb.getEBI().getPublishStrategy().getBroadcastStyle()[i].getRollFrequency() %></div>
        	</li>
        	<%
        	}
        	%>
        	<li class="table-item">
          		<div class="first">地震类扩展信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="second">震 中 所 在 行 政区划编码</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getLocation_code() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">震 中 所 在 行 政区划</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getPlace() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">地震发生时间</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getEarthquake_time() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">震级</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getLevel() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">震源深度</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getDepth() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">震中经度</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getLongitude() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">震中纬度</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getLatitude() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">地震类型</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getEq_type() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">地震信息类型</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getExpedited_reporting_type() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">距离震中最近的省会城市信息</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getNearest_provincial_capital() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">省会城市</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getShenghui() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">距离震中最近的地级市的信息</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getNearest_prefecture() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">地级市</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getDijishi() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">距离震中最近的县级市的信息</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getNearest_county() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">县级市</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getXianjishi() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">震中附近的村庄</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getNearest_village() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">村庄列表</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getVillages() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">震中附近的乡镇</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getNearest_town() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">乡镇列表</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getTowns() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">距离</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getJuli() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">震中方圆范围</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getRange() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">地震信息综合描述</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getSeismic_information() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">震中天气</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getWEATHER() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">海拔</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getAltitude() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">人口</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getPopulation() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">面积</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getArea() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">人均 GDP</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getGdp() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">最近 5次历史地震信息</div>
         	 	<div><%=eb.getEBI().getExtendInfo1().getFive_earthquake() %></div>
        	</li>
        	<li class="table-item">
          		<div class="first">民航机场类扩展信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="second">民航机场名称</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getAirport() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">民航机场代码</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getAirportcode() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">入港航班架次</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getInbound_flights() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">出港航班架次</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getOutbound_flights() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">入港旅客人数</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getInbound_numberofpeople() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">出港旅客人数</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getOutbound_numberofpeople() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">入港延误航班架次</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getInbound_Delayedflights() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">出港延误航班架次</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getOutbound_Delayedflights() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">民航机场状态</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getAirportStatus() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">入港延误航班号</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getInbound_flights_number() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">出港延误航班号</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getOutbound_flightsnumber() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">监测时间</div>
         	 	<div><%=eb.getEBI().getExtendInfo2().getTime() %></div>
        	</li>
        	<li class="table-item">
          		<div class="first">区域信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="second">地理区域描述</div>
         	 	<div><%=eb.getEBI().getArea().getAreaDescription() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">地 理 区 域 多 边形表示</div>
         	 	<div><%=eb.getEBI().getArea().getAreaPolygon() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">地 理 区 域 椭 圆形表示</div>
         	 	<div><%=eb.getEBI().getArea().getAreaCircle() %></div>
        	</li>
        	
        	
        	
<!--         	        应急广播业务数据EBD                -->
        </ul>
  	</div> 
  	<br/><br/>
  	<div class="EBD">
  		<span class="line"></span>
   		<span class="line"></span>
   		<div class="header">
   		<div class="title">应急广播业务数据</div>
        
       
      </div>
   		<ul class="table-container">
        	<li class="table-item">
        	 <div>
            	<span class="cell">类型</span>
          	 </div>
          	 <div>
            	<span class="cell">内容</span>
          	 </div>
        	</li>
        	<li class="table-item">
          		<div class="first">协 议 版 本号</div>
         	 	<div><%=eb.getEBD().getEBDVersion() %></div>
        	</li>
        	<li class="table-item">
          		<div class="first">数 据 包 编号</div>
         	 	<div><%=eb.getEBD().getEBDID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="first">数 据 包 类型</div>
         	 	<div><%=eb.getEBD().getEBDType() %></div>
        	</li>
        	<li class="table-item">
          		<div class="first">数 据 包 来源对象</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="second">数 据 包 来源 对 象 的资源编码</div>
         	 	<div><%=eb.getEBD().getSRC().getEBRID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">数 据 包 来源 对 象 的网络地址</div>
         	 	<div><%=eb.getEBD().getSRC().getURL() %></div>
        	</li>
        	<li class="table-item">
          		<div class="first">数 据 包 目标对象</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="second">数据包目标对象的资源编码</div>
         	 	<div><%=eb.getEBD().getDEST().getEBRID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="first">数 据 包 生成时间</div>
         	 	<div><%=eb.getEBD().getEBDTime() %></div>
        	</li>
        	<li class="table-item">
          		<div class="first">关 联 数 据包</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="second">关 联 数 据包编号</div>
         	 	<div><%=eb.getEBD().getRelatedEBD().getEBDID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="first">应急广播消息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应急广播消息协议版本号</div>
         	 	<div><%=eb.getEBD().getEBM().getEBMVersion() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应急广播消息编号</div>
         	 	<div><%=eb.getEBD().getEBM().getEBMID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">关联信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="third">关联应急广播信息编号</div>
         	 	<div><%=eb.getEBD().getEBM().getRelatedInfo().getEBIID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">关联应急广播信息编号</div>
         	 	<div><%=eb.getEBD().getEBM().getRelatedInfo().getEBMID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">消息基本信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="third">消息类型</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgBasicInfo().getMsgType() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">发布机构名称</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgBasicInfo().getSenderName() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">发布机构编码</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgBasicInfo().getSenderCode() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">发布时间</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgBasicInfo().getSendTime() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">事件类型编码</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgBasicInfo().getEventType() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">事件级别</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgBasicInfo().getSeverity() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">播发开始时间</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgBasicInfo().getStartTime() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">播发结束时间</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgBasicInfo().getEndTime() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">应急广播消息内容</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="third">语种代码</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgContent().getLanguageCode() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">消息标题文本</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgContent().getMsgTitle() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">消息内容文本</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgContent().getMsgDesc() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">覆盖区域编码</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgContent().getAreaCode() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">详情频道节目号</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgContent().getProgramNum() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">辅助数据</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="fourth">辅助数据类型</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgContent().getAuxiliary().getAuxiliaryType() %></div>
        	</li>
        	<li class="table-item">
          		<div class="fourth">辅助数据描述</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgContent().getAuxiliary().getAuxiliaryDesc() %></div>
        	</li>
        	<li class="table-item">
          		<div class="fourth">辅助数据文件大小</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgContent().getAuxiliary().getSize() %></div>
        	</li>
        	<li class="table-item">
          		<div class="fourth">辅助数据文件摘要</div>
         	 	<div><%=eb.getEBD().getEBM().getMsgContent().getAuxiliary().getDigest() %></div>
        	</li>
        	<li class="table-item">
          		<div class="second">调用资源信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="third">语种代码</div>
         	 	<div><%=eb.getEBD().getEBM().getDispatch().getLanguageCode() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">应急广播平台信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="fourth">应急广播平台编号</div>
         	 	<div><%=eb.getEBD().getEBM().getDispatch().getEBRPS().getEBRID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">电 台 /电视台信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="fourth">电 台 /电视台编号</div>
         	 	<div><%=eb.getEBD().getEBM().getDispatch().getEBRRTS().getEBRID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">应急广播适配器信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="fourth">应急广播适配器编号</div>
         	 	<div><%=eb.getEBD().getEBM().getDispatch().getEBRAS().getEBRID() %></div>
        	</li>
        	<li class="table-item">
          		<div class="third">传输覆盖播出设备信息</div>
         	 	<div></div>
        	</li>
        	<li class="table-item">
          		<div class="fourth">传输覆盖播出设备类型</div>
         	 	<div><%=eb.getEBD().getEBM().getDispatch().getEBRBS().getBrdSysType() %></div>
        	</li>
        	<li class="table-item">
          		<div class="fourth">传输覆盖播出设备详情</div>
         	 	<div><%=eb.getEBD().getEBM().getDispatch().getEBRBS().getBrdSysInfo() %></div>
        	</li>
        </ul>
  </div>
  </body>
</html>
