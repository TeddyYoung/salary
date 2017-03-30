<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../base.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看当前流程图</title>
</head>
<body>
	<div>
		<!-- 1.获取到规则流程图 -->
		<img style="position: absolute; top: 0px; left: 0px;"
			src="<%=basePath%>activiti/checkFlowDiagram.do?deploymentId=${pd.deploymentId}&imageName=${pd.diagramResourceName}">

		<!-- 2.根据当前活动的坐标，动态绘制DIV -->
		<div
			style="position: absolute;border:1px solid red;top: ${map['y']}px;left:  ${map['x']}px;width:  ${map['width']}px;height:${map['height']}px;   "></div>
	</div>
	<div
		style="position: absolute; border: 0px solid red; top: 360px; left: 360px;">
		<input type="button"
			class="btn btn-mini btn-info" name="outcome"
			onclick="javascript:history.go(-1)" value="返回" />
	</div>
</body>
</html>