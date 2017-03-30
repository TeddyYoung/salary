<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <meta charset="utf-8" />
  <base href="<%=basePath%>">
<title>应用程序异常 (500)</title> 

<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
    <style type="text/css"> 
        body { background-color: #fff; color: #666; text-align: center; font-family: arial, sans-serif; }
        div.dialog {
            width: 80%;
            padding: 1em 4em;
            margin: 4em auto 0 auto;
            border: 1px solid #ccc;
            border-right-color: #999;
            border-bottom-color: #999;
        }
        h1 { font-size: 100%; color: #f00; line-height: 1.5em; }
    </style> 
</head> 
 
<body> 
  <div class="dialog"> 
<!--     <h1>已经拼了命的为您加载……对不起，当前系统正忙！</h1>  -->
<!--     <p>服务器正在忙碌中，请稍后再试或者联系系统管理员！</p> -->
    <h1 style="text-align: left;" >提示内容：</h1> 
    <div style="text-align: left;" id="err">${exception}</div>
    <p>
		<a href="javascript:history.back(-1)">返 回</a> 
    </p> 
  </div>
  
  <script type="text/javascript">
  $(top.hangge());
  function showErr(){
  	document.getElementById("err").style.display = "";
  }
  </script>
</body> 
</html>
