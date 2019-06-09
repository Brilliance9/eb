<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="util.*"%>
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
	<link rel="stylesheet" type="text/css" href="./css/test.css">
	<script src="./js/jquery.js"></script>




  </head>
  
  <body  class="bg">
  <div class="wrapper">
  <div class="nav-ml">
  <ul>
   <li>
    <ul class="nav-first">
      <li ><a  class="item-1"><i></i>文书档案</a>
        <ul class="nav-second fold ">
          <li > <a class="item-2"><i></i>行政工作</a>
            <ul class="nav-three fold" >
              <li> <a >2015年行政工作行政财务报告</a></li>
              <li> <a >2015年行政工作行政财务报告</a></li>
            </ul>
          </li>
        </ul>
      </li>
    </ul>
    </li>
	<li>
    <ul class="nav-first">
      <li ><a  class="item-1"><i></i>会计档案</a>
        <ul class="nav-second fold ">
          <li > <a class="item-2"><i></i>会计工作</a>
            <ul class="nav-three fold" >
              <li> <a >报告</a></li>
              <li> <a >报告</a></li>
            </ul>
          </li>
        </ul>
      </li>
    </ul>
    </li>
	<li>
    <ul class="nav-first">
      <li ><a  class="item-1"><i></i>资产档案</a>
        <ul class="nav-second fold ">
          <li > <a class="item-2"><i></i>资产工作</a>
            <ul class="nav-three fold" >
              <li> <a >报告</a></li>
              <li> <a >报告</a></li>
            </ul>
          </li>
        </ul>
      </li>
    </ul>
    </li>
	<li>
	<ul class="nav-first">
      <li ><a  class="item-1"><i></i>文件档案</a>
        <ul class="nav-second fold ">
          <li > <a class="item-2"><i></i>文件工作</a>
            <ul class="nav-three fold" >
              <li> <a >报告</a></li>
              <li> <a >报告</a></li>
            </ul>
          </li>
        </ul>
      </li>
    </ul>
	
	</li>
	<li>
	<ul class="nav-first">
      <li ><a  class="item-1"><i></i>设备档案</a>
        <ul class="nav-second fold ">
          <li > <a class="item-2"><i></i>设备工作</a>
            <ul class="nav-three fold" >
              <li> <a >报告</a></li>
              <li> <a >报告</a></li>
            </ul>
          </li>
        </ul>
      </li>
    </ul>
	
	</li>
    </ul>
  </div>
</div>
  </body>
  <script language="javascript">
          $(".item-1").click(function(){
			$(this).parent().find(".nav-second").slideToggle(500);
			$(this).children("i").toggleClass("unfold");
		});
	       $(".item-2").click(function(){
			$(this).parent().find(".nav-three").slideToggle(500);
		    $(this).children("i").toggleClass("unfold");
		});
 
</script>
</html>

