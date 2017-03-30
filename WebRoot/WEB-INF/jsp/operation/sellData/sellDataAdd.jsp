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
		<title>销售数据</title>
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
		if($("#oilTargetVolume").val()==""){
			
			$("#oilTargetVolume").tips({
				side:3,
	            msg:'请输入油品本月目标销量（升）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#oilTargetVolume").focus();
			return false;
		}
		if(isNaN(Number($("#oilTargetVolume").val()))){
			
			$("#oilTargetVolume").tips({
				side:1,
	            msg:'请输入油品本月目标销量（升）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#oilTargetVolume").focus();
			$("#oilTargetVolume").val(1);
			return false;
		}
		
		if($("#oilRealVolume").val()==""){
			
			$("#oilRealVolume").tips({
				side:3,
	            msg:'请输入油品本月实际销量（升）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#oilRealVolume").focus();
			return false;
		}
		if(isNaN(Number($("#oilRealVolume").val()))){
			
			$("#oilRealVolume").tips({
				side:1,
	            msg:'请输入油品本月实际销量（升）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#oilRealVolume").focus();
			$("#oilRealVolume").val(1);
			return false;
		}
		
		if($("#oilDayAverageVolume").val()==""){
			
			$("#oilDayAverageVolume").tips({
				side:3,
	            msg:'请输入油品日均销量（升）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#oilDayAverageVolume").focus();
			return false;
		}
		if(isNaN(Number($("#oilDayAverageVolume").val()))){
			
			$("#oilDayAverageVolume").tips({
				side:1,
	            msg:'请输入油品日均销量（升）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#oilDayAverageVolume").focus();
			$("#oilDayAverageVolume").val(1);
			return false;
		}
		
		if($("#nonOilTargetVolume").val()==""){
			
			$("#nonOilTargetVolume").tips({
				side:3,
	            msg:'请输入非油品本月目标销量（元）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#nonOilTargetVolume").focus();
			return false;
		}
		if(isNaN(Number($("#nonOilTargetVolume").val()))){
			
			$("#nonOilTargetVolume").tips({
				side:1,
	            msg:'请输入非油品本月目标销量（元）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#nonOilTargetVolume").focus();
			$("#nonOilTargetVolume").val(1);
			return false;
		}
		
		if($("#nonOilRealVolume").val()==""){
			
			$("#nonOilRealVolume").tips({
				side:3,
	            msg:'请输入非油品本月实际销量（元）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#nonOilRealVolume").focus();
			return false;
		}
		if(isNaN(Number($("#nonOilRealVolume").val()))){
			
			$("#nonOilRealVolume").tips({
				side:1,
	            msg:'请输入非油品本月实际销量（元）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#nonOilRealVolume").focus();
			$("#nonOilRealVolume").val(1);
			return false;
		}
		
		if($("#nonOilDayAverageVolume").val()==""){
			
			$("#nonOilDayAverageVolume").tips({
				side:3,
	            msg:'请输入非油品日均销量',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#nonOilDayAverageVolume").focus();
			return false;
		}
		if(isNaN(Number($("#nonOilDayAverageVolume").val()))){
			
			$("#nonOilDayAverageVolume").tips({
				side:1,
	            msg:'请输入非油品日均销量',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#nonOilDayAverageVolume").focus();
			$("#nonOilDayAverageVolume").val(1);
			return false;
		}
		
		if($("#storeMarkScore").val()==""){
			
			$("#storeMarkScore").tips({
				side:3,
	            msg:'请输入便利店业绩得分',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#storeMarkScore").focus();
			return false;
		}
		if(isNaN(Number($("#storeMarkScore").val()))){
			
			$("#storeMarkScore").tips({
				side:1,
	            msg:'请输入便利店业绩得分',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#storeMarkScore").focus();
			$("#storeMarkScore").val(1);
			return false;
		}
		
		if($("#storeManageScore").val()==""){
			
			$("#storeManageScore").tips({
				side:3,
	            msg:'请输入便利店管理得分',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#storeManageScore").focus();
			return false;
		}
		if(isNaN(Number($("#storeManageScore").val()))){
			
			$("#storeManageScore").tips({
				side:1,
	            msg:'请输入便利店管理得分',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#storeManageScore").focus();
			$("#storeManageScore").val(1);
			return false;
		}
		if($("#stationTargetCode").val()==""){
			
			$("#stationTargetCode").tips({
				side:3,
	            msg:'这里输入销售数据编号',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#stationTargetCode").focus();
			return false;
		}     
		$("#stationTargetForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>


<body>
	<form  action="<%=basePath%>sellData/sellDataSaveOrUpdate.do" name="stationTargetForm" id="stationTargetForm" method="post" >
		<input type="hidden" name="id" id="id" value=""/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">所属油站：</td>
				<td><select name="stationCode" id="stationCode" class="chzn-select" data-placeholder="请选择所属油站" style="vertical-align:top;width: 220px;"  title="所属油站">
								<option value=""></option>
								<biztab:biz type="station" code="all">
									<option value="${obj.stationCode}">${obj.stationName}</option>
								</biztab:biz>
					</select></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">年份月份：</td>
				<td><input class="span10 date-picker" name="yearMonth" name="yearMonth"  value="" type="text" data-date-format="yyyy-mm" style="width:205px;" placeholder="年份月份" title="年份月份"/></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">油品本月目标销量（升）：</td>
				<td><input type="text" name="oilTargetVolume" id="oilTargetVolume" placeholder="这里输入油品本月目标销量（升）" value="" title="油品本月目标销量（升）" maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">油品本月实际销量（升）：</td>
				<td><input type="text" name="oilRealVolume" id="oilRealVolume" placeholder="这里输入油品本月实际销量（升）" value="" title="油品本月实际销量（升）" maxlength="32" /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">油品日均销量（升）：</td>
				<td><input type="text" name="oilDayAverageVolume" id="oilDayAverageVolume" placeholder="这里输入油品日均销量（升）" value="" title="油品日均销量（升）" maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">非油品本月目标销量（元）：</td>
				<td><input type="text" name="nonOilTargetVolume" id="nonOilTargetVolume" placeholder="这里输入非油品本月目标销量（元）" value="" title="非油品本月目标销量（元）" maxlength="32" /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">非油品本月实际销量（元）：</td>
				<td><input type="text" name="nonOilRealVolume" id="nonOilRealVolume" placeholder="这里输入非油品本月实际销量（元）" value="" title="非油品本月实际销量（元）" maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">非油品日均销量（元）：</td>
				<td><input type="text" name="nonOilDayAverageVolume" id="nonOilDayAverageVolume" placeholder="这里输入非油品日均销量（元）" value="" title="非油品日均销量（元）" maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">便利店业绩得分：</td>
				<td><input type="text" name="storeMarkScore" id="storeMarkScore" placeholder="这里输入便利店业绩得分" value="" title="便利店业绩得分" maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">便利店管理得分：</td>
				<td><input type="text" name="storeManageScore" id="storeManageScore" placeholder="这里输入便利店管理得分" value="" title="便利店管理得分" maxlength="32" /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">备注：</td>
				<td  colspan="10"><input type="text" name="remark" id="remark" placeholder="这里输入备注" style="width:656px;" value="" title="备注" /></td>
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