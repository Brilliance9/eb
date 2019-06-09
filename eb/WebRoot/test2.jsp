<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="./js/add.js"></script>
    
  </head>
  
  <body>
    <form action="/eb/Test" method="post" enctype="multipart/form-data">  
    <input type="time"  name ="time">
   	 用户名:<input name="username" type="text"><br/> 
   	 <div id="btn">
   	 用户名2:<input name="username" type="text"><br/> 
   	 用户名3:<input name="username" type="text"><br/>
   	 </div>
   	 <input type="button" id="bbb">
   	 密码：<input name="password"/>
   	 <div id="attDiv">
    	</div>
    <input type="button" class="a button button-primary button-rounded button-small" value="添加资源附件" onclick="addAtt()"/><br/>
    	 
   	
   <input type="submit" value="提交上传" />   
   </form>
   
    
 
  </body>
</html>
