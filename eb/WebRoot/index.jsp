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
    <base  target="main">
    
    <title>应急广播管理系统</title>
    
    
  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/event.css">
	<link rel="stylesheet" type="text/css" href="./css/button.css">
	<script src="./js/jquery.js"></script>

  </head>
  
  <body  class="bg">
	
  
  <header class="header-container">
    <span class="title"></span>
    <a href="/eb/Index" target="_self" class="handle button button-primary button-rounded button-small">刷新</a>    
  </header>
  <div class="main">  
<!-- left -->
     <div class="list">
      <span class="line"></span>
      <span class="line"></span>
      <div class="header">
        <div class="title">应急信息</div>
        <a target="_blank" class="my-select button button-primary button-rounded button-small" href="/eb/add.jsp">添加</a>
         <a target="_blank" class="transmission button button-primary button-rounded button-small" href="/eb/transmission.jsp">传输覆盖网</a>                
      </div>
      <ul class="table-container"  id="scroller-container">
        <li class="table-item">
<!--           <div> -->
<!--             <span class="cell">编号</span> -->
<!--           </div> -->
          <div>
            <span class="cell">标题</span>
          </div>
          <div>
            <span class="cell">源信息发布机构</span>
          </div>
          <div>
            <span class="cell">应急事件级别</span>
          </div>          
          <div>
          	<span class="cell">应急事件类型</span>
          </div>
          <div>
          	<span class="cell">建议播发开始时间</span>
          </div>

        </li>
        <%
        List<EB> eb=(List<EB>)request.getAttribute("eb");
        
        for(int i=0;i<eb.size();i++){
        %>
        <li class="table-item">
        	<div><%=eb.get(i).getEBI().getEBContent()[0].getHeadline() %></div>
        	<div><%=eb.get(i).getEBI().getEBMainInfo().getSender() %></div>
        	<div><%=eb.get(i).getEBI().getEBMainInfo().getEventLevel() %></div>
        	<div><%=eb.get(i).getEBI().getEBMainInfo().getEventType() %></div>
        	<div><%=eb.get(i).getEBI().getPublishStrategy().getBroadcastDateTime() %></div>
        	<div><a  target="_parent" class="button button-primary button-rounded button-small" href="/eb/EBServlet?ID=<%=eb.get(i).getID() %>&method=detail">查看</a></div>
        </li>
        <%
        }
        %>
      </ul>
    </div>
   </div>
  </body>

</html>
