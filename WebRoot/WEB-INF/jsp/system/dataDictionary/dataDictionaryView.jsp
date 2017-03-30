<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../base.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		
		<meta charset="utf-8" />
		<title>数据字典</title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<!--提示框-->
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
</head>

<script type="text/javascript">
	$(top.hangge());
</script>


<body>
	<input type="hidden" name="id" id="id" value="${dataDictionary.id }" readonly="readonly"/>
		<input type="hidden" name="id" id="id" value="${dataDictionary.id }"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">标识类型：</td>
				<td><input type="text" readonly="readonly" name="codetype" id="codetype" placeholder="这里输入标识类型" value="${dataDictionary.codetype }" title="标识类型" maxlength="32"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">标识名称：</td>
				<td><input type="text" readonly="readonly" name="codename" id="codename" placeholder="这里输入标识名称" value="${dataDictionary.codename }" title="标识名称" maxlength="32"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">值标识类型：</td>
				<td><input type="text" readonly="readonly" name="valuetype" id="valuetype" placeholder="这里输入值标识类型" value="${dataDictionary.valuetype }" title="值标识类型" maxlength="32"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">值标识名称：</td>
				<td><input type="text" readonly="readonly" name="valuename" id="valuename" placeholder="这里输入值标识名称" value="${dataDictionary.valuename }" title="值标识名称" maxlength="32"/></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">备注：</td>
				<td><textarea rows="4" cols="68" readonly="readonly" name="remark" id="remark" placeholder="备注" title="备注">${dataDictionary.remark }</textarea></td>
			</tr>
		</table>
		</div>
	<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
</body>
</html>