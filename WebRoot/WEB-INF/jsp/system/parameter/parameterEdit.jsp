<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="../../base.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		
		<meta charset="utf-8" />
		<title>修改参数</title>
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
		if($("#parameterKey").val()==""){
			
			$("#parameterKey").tips({
				side:3,
	            msg:'请输入参数的键',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#parameterKey").focus();
			return false;
		}
		if($("#menuUrl").val()==""){
			$("#menuUrl").val('#');
		}
	    if($("#parameterValue").val()==""){
			
			$("#parameterValue").tips({
				side:3,
	            msg:'请输入参数的值',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#parameterValue").focus();
			return false;
		}
	    if($("#parameterType").val()==""){
			
			$("#parameterType").tips({
				side:3,
	            msg:'请输入参数类型',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#parameterType").focus();
			return false;
		}
	    if($("#parameterTypeName").val()==""){
			
			$("#parameterTypeName").tips({
				side:3,
	            msg:'请输入参数类型名称',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#parameterTypeName").focus();
			return false;
		}
		
		$("#parameterForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
</script>


<body>
	<form  action="parameter/parameterSaveOrUpdate.do" name="parameterForm" id="parameterForm" method="post" >
		<input type="hidden" name="id" value="${parameter.id}" />
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
				<tr>
					<td style="width:120px;text-align: right;padding-top: 13px;">参数的键：</td>
					<td><input type="text" name="parameterKey" id="parameterKey" placeholder="这里输入参数的键" value="${parameter.parameterKey}" title="参数的键"  maxlength="32" /></td>
					<td style="width:120px;text-align: right;padding-top: 13px;">参数的值：</td>
					<td><input type="text" name="parameterValue" id="parameterValue" placeholder="这里输入参数的值" value="${parameter.parameterValue}" title="参数的值"  maxlength="32" /></td>
				</tr>
				<tr>
					<td style="width:120px;text-align: right;padding-top: 13px;">参数类型：</td>
						<td><select class="chzn-select" name="parameterType" id="parameterType" data-placeholder="请选择参数类型" style="vertical-align:top;width: 140px;">
							<systab:dataDictionary codeType="parameterType" valueType="all">
								<option value="${dataDictionary.valuetype}" ${parameter.parameterType ==dataDictionary.valuetype ? 'selected="selected"':''} >${dataDictionary.valuename}</option>
							</systab:dataDictionary>
					  	</select></td>
					<td style="width:120px;text-align: right;padding-top: 13px;">参数中文名称：</td>
					<td><input type="text" name="parameterTypeName" id="parameterTypeName" placeholder="这里输入参数中文名称" value="${parameter.parameterTypeName}" title="参数中文名称"  maxlength="32" /></td>
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