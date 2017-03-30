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
		<title>油站信息</title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<!-- 下拉框 -->
		<link rel="stylesheet" href="static/css/chosen.css" />
		
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		
		<link rel="stylesheet" href="static/css/datepicker.css" /><!-- 日期框 -->
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript" src="static/js/myjs/city.js"></script>
</head>

<script type="text/javascript">
	$(top.hangge());

	//保存
	function save(){
		if($("#stationLevelCode").val()==""){
			
			$("#stationLevelCode").tips({
				side:3,
	            msg:'请输入油站星级编号',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#stationLevelCode").focus();
			return false;
		}  
		if($("#stationLevelName").val()==""){
			
			$("#stationLevelName").tips({
				side:3,
	            msg:'请输入油站星级名称',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#stationLevelName").focus();
			return false;
		}     
		$("#stationLevelForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>


<body>
	<form  action="<%=basePath%>stationLevel/stationlevelSaveOrUpdate.do" name="stationLevelForm" id="stationLevelForm" method="post" >
		<input type="hidden" name="id" id="id" value="${stationLevel.id }"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">星级编号：</td>
				<td><input type="text" name="stationLevelCode" id="stationLevelCode" placeholder="这里输入星级编号" value="${stationLevel.stationLevelCode }" title="星级编号" maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">星级名称：</td>
				<td><input type="text" name="stationLevelName" id="stationLevelName" placeholder="这里输入星级名称" value="${stationLevel.stationLevelName}" title="星级名称" maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">经理奖金：</td>
				<td><input type="text" name="managerBonusAmt" id="managerBonusAmt" placeholder="这里输入经理奖金" value="${stationLevel.managerBonusAmt}" title="经理奖金" maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">备注：</td>
				<td><textarea rows="4" cols="68" name="remark" id="remark" placeholder="备注" title="备注">${stationLevel.remark}</textarea></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
		</div>
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
	</form>
	<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript">
			$(function() {
				//单选框
				$(".chzn-select").chosen(); 
				$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
				
				//日期框
				$('.date-picker').datepicker();
			});
		</script>
</body>
</html>