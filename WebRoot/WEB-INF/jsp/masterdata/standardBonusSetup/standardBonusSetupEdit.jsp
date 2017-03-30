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
		<title>经理奖金设置</title>
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
		if($("#startRate").val()==""){
			
			$("#startRate").tips({
				side:3,
	            msg:'请输入起始达标率（%））',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#startRate").focus();
			return false;
		}
		if(isNaN(Number($("#startRate").val()))){
			
			$("#startRate").tips({
				side:1,
	            msg:'请输入起始达标率（%）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#startRate").focus();
			$("#startRate").val(1);
			return false;
		}     
		if($("#endRate").val()==""){
			
			$("#endRate").tips({
				side:3,
	            msg:'请输入封顶达标率（%）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#endRate").focus();
			return false;
		}
		if(isNaN(Number($("#endRate").val()))){
			
			$("#endRate").tips({
				side:1,
	            msg:'请输入封顶达标率（%）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#endRate").focus();
			$("#endRate").val(1);
			return false;
		}     
		if($("#bonusAmt").val()==""){
			
			$("#bonusAmt").tips({
				side:3,
	            msg:'请输入奖金基数（元）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#bonusAmt").focus();
			return false;
		}
		if(isNaN(Number($("#bonusAmt").val()))){
			
			$("#bonusAmt").tips({
				side:1,
	            msg:'请输入奖金基数（元）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#bonusAmt").focus();
			$("#bonusAmt").val(1);
			return false;
		}     
		if($("#bonusCoefficient").val()==""){
			
			$("#bonusCoefficient").tips({
				side:3,
	            msg:'请输入奖金系数',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#bonusCoefficient").focus();
			return false;
		}
		if(isNaN(Number($("#bonusCoefficient").val()))){
			
			$("#bonusCoefficient").tips({
				side:1,
	            msg:'请输入奖金系数',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#bonusCoefficient").focus();
			$("#bonusCoefficient").val(1);
			return false;
		}     
		$("#standardBonusSetupForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>


<body>
	<form  action="<%=basePath%>standardBonusSetup/standardBonusSetupSaveOrUpdate.do" name="standardBonusSetupForm" id="standardBonusSetupForm" method="post" >
		<input type="hidden" name="id" id="id" value="${standardBonusSetup.id }"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">起始达标率（升）：</td>
				<td><input type="text" name="startRate" id="startRate" placeholder="这里输入起始达标率（%）" value="${standardBonusSetup.startRate }" title="起始达标率（升）" maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">封顶达标率（升）：</td>
				<td><input type="text" name="endRate" id="endRate" placeholder="这里输入封顶达标率（%）" value="${standardBonusSetup.endRate }" title="封顶达标率（升）" maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">奖金基数（元）：</td>
				<td><input type="text" name="bonusAmt" id="bonusAmt" placeholder="这里输入奖金基数（元）" value="${standardBonusSetup.bonusAmt }" title="奖金基数（元）" maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">奖金系数：</td>
				<td><input type="text" name="bonusCoefficient" id="bonusCoefficient" placeholder="这里输入奖金系数" value="${standardBonusSetup.bonusCoefficient }" title="奖金系数（元）" maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">奖金类型：</td>
				<td><select class="chzn-select" name="standardBonusType" id="standardBonusType" data-placeholder="请选择油站状态" style="vertical-align:top;width: 140px;">
							<systab:dataDictionary codeType="standard_bonus_type" valueType="all">
								<option value="${dataDictionary.valuetype}" ${standardBonusSetup.standardBonusType ==dataDictionary.valuetype ? 'selected="selected"':''} >${dataDictionary.valuename}</option>
							</systab:dataDictionary>
					  	</select></td>
			<td style="width:120px;text-align: right;padding-top: 13px;">备注：</td>
				<td><input type="text" name="remark" id="remark" placeholder="这里输入备注" value="${standardBonusSetup.remark }" title="备注" maxlength="32" /></td>
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