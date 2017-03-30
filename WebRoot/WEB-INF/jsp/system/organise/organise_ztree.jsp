<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title></title>

<link href="static/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="static/css/font-awesome.min.css" />

<link type="text/css" rel="stylesheet" href="plugins/zTree/3.5/zTreeStyle.css"/>
<link rel="stylesheet" href="static/css/ace.min.css" />
<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
<link rel="stylesheet" href="static/css/ace-skins.min.css" />
<script type="text/javascript" src="static/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="plugins/zTree/3.5/jquery.ztree.core-3.5.js"></script>
<!-- <script type="text/javascript" src="plugins/zTree/3.5/jquery.ztree.excheck-3.5.min.js"></script> -->

<script type="text/javascript">
$(top.hangge());
			var setting = {
			    showLine: true
			};
			var zTreeNodes = ${zTreeNodes};
	
	$(document).ready(function(){
		$.fn.zTree.init($("#tree"), setting, zTreeNodes);
	});
	</script>
</head>
<body>
	<div class="zTreeDemoBackground left">
		<ul id="tree" class="ztree"></ul>
	</div>
</body>
</html>