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
		if($("#dutyCode").val()==""){
			
			$("#dutyCode").tips({
				side:3,
	            msg:'请输入职务编号',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#dutyCode").focus();
			return false;
		}
		if($("#menuUrl").val()==""){
			$("#menuUrl").val('#');
		}
	    if($("#dutyName").val()==""){
			
			$("#dutyName").tips({
				side:3,
	            msg:'请输入职务名称',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#dutyName").focus();
			return false;
		}
		
		$("#dutyForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>


<body>
	<form  action="<%=basePath%>duty/dutySaveOrUpdate.do" name="dutyForm" id="dutyForm" method="post" >
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">职务编号：</td>
				<td><input type="text" name="dutyCode" id="dutyCode" placeholder="这里输入职务编号" value="" title="职务编号"  maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">职务名称：</td>
				<td><input type="text" name="dutyName" id="dutyName" placeholder="这里输入职务名称" value="" title="职务名称"  maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">职务类型：</td>
				<td><select name="dutyType" id="dutyType" class="chzn-select" data-placeholder="请选择职务类型" style="vertical-align:top;width: 220px;"  title="职务类型">
								<option value=""></option>
								<systab:dataDictionary codeType="duty_type" valueType="all">
									<option value="${dataDictionary.valuetype}" >${dataDictionary.valuename}</option>
								</systab:dataDictionary>
					</select>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">职务性质：</td>
				<td><select name="dutyNature" id="dutyNature" class="chzn-select" data-placeholder="请选择职务性质" style="vertical-align:top;width: 220px;"  title="职务性质">
								<option value=""></option>
								<systab:dataDictionary codeType="duty_nature" valueType="all">
									<option value="${dataDictionary.valuetype}" >${dataDictionary.valuename}</option>
								</systab:dataDictionary>
					</select>
				</td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">排序：</td>
				<td><input type="text" name="sort" id="sort" placeholder="这里输入排序" value="" title="排序"  maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">备注：</td>
				<td colspan="10"><input type="text" name="remark" id="remark" placeholder="这里输入备注" value="" title="备注" maxlength="32"  /></td>
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