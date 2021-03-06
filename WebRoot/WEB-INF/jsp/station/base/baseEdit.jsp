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
		if($("#stationCode").val()==""){
			
			$("#stationCode").tips({
				side:3,
	            msg:'请输入',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#stationCode").focus();
			return false;
		}
		if($("#stationName").val()==""){
			
			$("#stationName").tips({
				side:3,
	            msg:'请输入',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#stationName").focus();
			return false;
		}
		if($("#stationStaffNum").val()==""){
			
			$("#stationStaffNum").tips({
				side:1,
	            msg:'请输入定编人数',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#stationStaffNum").focus();
			return false;
		}
		
		if(isNaN(Number($("#stationStaffNum").val()))){
			
			$("#stationStaffNum").tips({
				side:1,
	            msg:'请输入定编人数',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#stationStaffNum").focus();
			$("#stationStaffNum").val(1);
			return false;
		}
		if($("#stationStaffNumFloat").val()==""){
			
			$("#stationStaffNumFloat").tips({
				side:1,
	            msg:'请输入浮动定编人数',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#stationStaffNumFloat").focus();
			return false;
		}
		
		if(isNaN(Number($("#stationStaffNumFloat").val()))){
			
			$("#stationStaffNumFloat").tips({
				side:1,
	            msg:'请输入浮动定编人数',
	            bg:'#AE81FF',
	            time:2
	        });
			
			if($("#stationStaffNumFloat").val()==""){
				
				$("#stationStaffNumFloat").tips({
					side:1,
		            msg:'请输入浮动定编人数',
		            bg:'#AE81FF',
		            time:2
		        });
				
				$("#stationStaffNumFloat").focus();
				return false;
			}
			
			$("#stationStaffNumFloat").focus();
			$("#stationStaffNumFloat").val(1);
			return false;
		}
		
		if($("#stationType").val()==""){
			
			$("#stationType").tips({
				side:1,
	            msg:'请选择会计奖金油站类型',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#stationType").focus();
			return false;
		}
		
		$("#stationForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>


<body>
	<form  action="<%=basePath%>station/stationSaveOrUpdate.do" name="stationForm" id="stationForm" method="post" >
		<input type="hidden" name="id" id="id" value="${station.id }"/style="margin-top:10px;">
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 16px;">油站编号：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><input type="text" name="stationCode" id="stationCode" placeholder="这里输入" value="${station.stationCode }" title="编号"  maxlength="32"/></td>
				<td style="width:120px;text-align: right;padding-top: 16px;">油站名称：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><input type="text" name="stationName" id="stationName" placeholder="这里输入" value="${station.stationName }" title="名称"  maxlength="32" /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 16px;">定编人数：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><input type="text" name="stationStaffNum" id="stationStaffNum" placeholder="这里输入定编人数" value="${station.stationStaffNum }" title="定编人数"  maxlength="32" "/></td>
				<td style="width:120px;text-align: right;padding-top: 16px;">浮动编制人数：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><input type="text" name="stationStaffNumFloat" id="stationStaffNumFloat" placeholder="这里输入" value="${station.stationStaffNumFloat }" title=""  maxlength="32" /></td>
			</tr>
			<tr>	
				<%-- 
				<td style="width:120px;text-align: right;padding-top: 16px;">油站状态：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><select class="chzn-select" name="stationStatus" data-placeholder="请选择油站状态" style="margin-top:10px;width: 220px;" id="stationStatus" title="油站状态">
								<option value=""></option>
								<systab:dataDictionary codeType="stationStation" valueType="all">
									<option value="${dataDictionary.valuetype}" ${dataDictionary.valuetype==station.stationStatus ? 'selected="selected"' : '' }>${dataDictionary.valuename}</option>
								</systab:dataDictionary>
					</select>
				</td>
				 --%>
				<%-- <td style="width:120px;text-align: right;padding-top: 16px;">所属星级站：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><select name="stationLevelCode" id="stationLevelCode" class="chzn-select" data-placeholder="请选择所属星级站" style="margin-top:10px;;width: 220px;" title="所属星级站">
								<option value=""></option>
								<biztab:biz type="stationLevel" code="all">
									<option value="${obj.stationLevelCode}" ${obj.stationLevelCode==station.stationLevelCode ? 'selected="selected"' : '' } >${obj.stationLevelName}</option>
								</biztab:biz>
					</select>
				</td> 
				<td style="width:120px;text-align: right;padding-top: 16px;">所属区域站：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><select name="districtCode" id="districtCode" class="chzn-select" data-placeholder="请选择所属区域站" style="margin-top:10px;width: 220px;"  title="所属区域站">
								<option value=""></option>
								<biztab:biz type="district" code="all">
									<option value="${obj.districtCode}" ${obj.districtCode==station.districtCode ? 'selected="selected"' : '' } >${obj.districtName}</option>
								</biztab:biz>
					</select>
				</td>
				</tr>
			<tr>--%>
				<td style="width:120px;text-align: right;padding-top: 16px;">地区类型：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><select name="areaCode" id="areaCode" class="chzn-select" data-placeholder="请选择所属地区站" style="margin-top:10px;width: 220px;"  title="所属地区站">
								<option value=""></option>
								<biztab:biz type="area" code="all">
									<option value="${obj.areaCode}"  ${obj.areaCode==station.areaCode ? 'selected="selected"' : '' } >${obj.areaName}</option>
								</biztab:biz>
					</select>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">会计奖金油站类型：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
					<select name="stationType" id="stationType" class="chzn-select" data-placeholder="请选择会计奖金油站类型"
							 style="vertical-align:top;width: 220px;" title="会计奖金油站类型">
						<option value=""></option>
						<systab:dataDictionary codeType="station_type" valueType="all">
							<option value="${dataDictionary.valuetype}" ${dataDictionary.valuetype==station.stationType ? 'selected="selected"' : '' }>${dataDictionary.valuename}</option>
						</systab:dataDictionary>
					</select>
				</td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 16px;">所属区域：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><select name="districtCode" id="districtCode" class="chzn-select" data-placeholder="请选择所属区域站" style="margin-top:10px;width: 220px;"  title="所属区域站">
								<option value=""></option>
								<biztab:biz type="district" code="all">
									<option value="${obj.organiseId}" ${obj.organiseId==station.districtCode ? 'selected="selected"' : '' } >${obj.organiseName}</option>
								</biztab:biz>
					</select>
				</td>
				<td style="width:120px;text-align: right;padding-top: 16px;">油站性质：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
					<select name="stationNature" id="stationNature" class="chzn-select" data-placeholder="请选择油站性质"
							 style="vertical-align:top;width: 220px;" title="油站性质">
						<option value=""></option>
						<systab:dataDictionary codeType="station_nature" valueType="all">
							<option value="${dataDictionary.valuetype}"
							 ${dataDictionary.valuetype==station.stationNature ? 'selected="selected"' : '' }>
							 ${dataDictionary.valuename}</option>
						</systab:dataDictionary>
					</select>
				</td>
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