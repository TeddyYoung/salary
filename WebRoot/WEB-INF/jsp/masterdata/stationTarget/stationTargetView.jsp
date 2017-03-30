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
		<title>油站系数</title>
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
</script>


<body>
		<input type="hidden" name="id" id="id" value="${stationTarget.id }" readonly="readonly"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">所属油站：</td>
				<td><select name="stationCode" id="stationCode" class="chzn-select" disabled="disabled" data-placeholder="请选择所属油站" style="vertical-align:top;width: 220px;"  title="所属油站">
								<option value=""></option>
								<biztab:biz type="station" code="all">
									<option value="${obj.stationCode}" ${stationTarget.stationCode==obj.stationCode ? 'selected="selected"':'' } >${obj.stationName}</option>
								</biztab:biz>
					</select></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">年份月份：</td>
				<td><input class="span10 date-picker" name="yearMonth" name="yearMonth" readonly="readonly" value="${stationTarget.yearMonth }" type="text" data-date-format="yyyy-mm" style="width:205px;" placeholder="年份月份" title="年份月份"/></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">油品本月目标销量（升）：</td>
				<td><input type="text" name="oilTargetVolume" id="oilTargetVolume" readonly="readonly" placeholder="这里输入油品本月目标销量（升）" value="${stationTarget.oilTargetVolume }" title="油品本月目标销量（升）" maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">油品本月实际销量（升）：</td>
				<td><input type="text" name="oilRealVolume" id="oilRealVolume" readonly="readonly" placeholder="这里输入油品本月实际销量（升）" value="${stationTarget.oilRealVolume }" title="油品本月实际销量（升）" maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">油品日均销量（升）：</td>
				<td><input type="text" name="oilDayAverageVolume" id="oilDayAverageVolume" readonly="readonly" placeholder="这里输入油品日均销量（升）" value="${stationTarget.oilDayAverageVolume }" title="油品日均销量（升）" maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">非油品本月目标销量（元）：</td>
				<td><input type="text" name="nonOilTargetVolume" id="nonOilTargetVolume" readonly="readonly" placeholder="这里输入非油品本月目标销量（元）" value="${stationTarget.nonOilTargetVolume }" title="非油品本月目标销量（元）" maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">非油品本月实际销量（元）：</td>
				<td><input type="text" name="nonOilRealVolume" id="nonOilRealVolume" readonly="readonly" placeholder="这里输入非油品本月实际销量（元）" value="${stationTarget.nonOilRealVolume }" title="非油品本月实际销量（元）" maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">非油品日均销量（元）：</td>
				<td><input type="text" name="nonOilDayAverageVolume" id="nonOilDayAverageVolume" readonly="readonly" placeholder="这里输入非油品日均销量（元）" value="${stationTarget.nonOilDayAverageVolume }" title="非油品日均销量（元）" maxlength="32" /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">便利店业绩得分：</td>
				<td><input type="text" name="storeMarkScore" id="storeMarkScore" readonly="readonly" placeholder="这里输入便利店业绩得分" value="${stationTarget.storeMarkScore }" title="便利店业绩得分" maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">便利店管理得分：</td>
				<td><input type="text" name="storeManageScore" id="storeManageScore" readonly="readonly" placeholder="这里输入便利店管理得分" value="${stationTarget.storeManageScore }" title="便利店管理得分" maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">备注：</td>
				<td  colspan="10"><input type="text" name="remark" id="remark" placeholder="这里输入备注" style="width:656px;" readonly="readonly" value="${stationTarget.remark }" title="备注"/></td>
			</tr>
		</table>
		</div>
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
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