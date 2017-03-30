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
		<title>地区信息</title>
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
	            msg:'请选择所属油站',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#stationCode").focus();
			return false;
		}
	    if($("#baseTarget").val()==""){
			
			$("#baseTarget").tips({
				side:3,
	            msg:'请输入基础目标',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#baseTarget").focus();
			return false;
		}
	    
		if($("#challengeTarget").val()==""){
			
			$("#challengeTarget").tips({
				side:3,
	            msg:'请输入挑战目标',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#challengeTarget").focus();
			return false;
		}
	    if($("#challengeBonusAmt").val()==""){
			
	    	$("#challengeBonusAmt").tips({
				side:3,
	            msg:'请输入挑战奖金',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#challengeBonusAmt").focus();
			return false;
		}
	    
	    //验证输入的是否是数字
	    var re = /^[0-9]+.?[0-9]*$/;
	    if (!re.test($("#challengeBonusAmt").val())) {
	    	$("#challengeBonusAmt").tips({
				side:3,
	            msg:'请输入正确的挑战奖金',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#challengeBonusAmt").focus();
			return false;
	    }
	    
		$("#challengeBonusForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
	$(function() {

		//下拉框
		$(".chzn-select").chosen();
		$(".chzn-select-deselect").chosen({
			allow_single_deselect : true
		});

		//日期框
		$('.date-picker').datepicker();

		//复选框
		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});

	});
	
</script>
<body>
	<form action="<%=basePath%>challengeBonus/challengeBonusSaveOrUpdate.do" name="challengeBonusForm" id="challengeBonusForm" method="post" >
		<input type="hidden" name="id" value="${challengeBonus.id}" />
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">所属油站<span style="color:red;">*</span>：</td>
				<td>
					<select name="stationCode" id="stationCode" data-placeholder="请选择员工所属油站" style="vertical-align:top;width: 220px;" title="员工所属职务">
						<biztab:biz type="station" code="all">
							<option value="${obj.stationCode}"  ${obj.stationCode==challengeBonus.stationCode ? 'selected="selected"' : '' }>${obj.stationName}</option>
						</biztab:biz>
					</select>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">挑战奖金类型<span style="color:red;">*</span>：</td>
				<td>
					<select  name="type" id="type"  data-placeholder="请选择挑战奖金类型"
							style="vertical-align:top;width: 220px;" title="挑战奖金类型" >
						<systab:dataDictionary codeType="challenge_bonus_type" valueType="all">
							<option value="${dataDictionary.valuetype}"  ${dataDictionary.valuetype==challengeBonus.type ? 'selected="selected"' : '' }>${dataDictionary.valuename}</option>
						</systab:dataDictionary>
					</select>
				</td>
				</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">年份月份<span style="color:red;">*</span>：</td>
				<td><input type="text" value="${challengeBonus.yearMonth}" name="yearMonth" id="yearMonth" placeholder="这里输入年份月份" value="" title="年份月份"  maxlength="32" /></td>
<!-- 				<td style="width:120px;text-align: right;padding-top: 13px;">计划天数<span style="color:red;">*</span>：</td> -->
<%-- 				<td><input type="text" value="${challengeBonus.planDay}" name="planDay" id="planDay" placeholder="这里输入计划天数" value="" title="计划天数"  maxlength="32" /></td> --%>
					<td colspan="2"></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">基础目标<span style="color:red;">*</span>：</td>
				<td><input type="text" name="baseTarget" id="baseTarget" value="${challengeBonus.baseTarget}" placeholder="这里输入基础目标" value="" title="基础目标"  maxlength="32" /></td>
<!-- 				<td style="width:120px;text-align: right;padding-top: 13px;">非油品总额<span style="color:red;">*</span>：</td> -->
<%-- 				<td><input type="text" value="${challengeBonus.nonOilTotalAmt}" name="nonOilTotalAmt" id="nonOilTotalAmt" placeholder="这里输入非油品总额" value="" title="非油品总额"  maxlength="32" /></td> --%>
				<td style="width:120px;text-align: right;padding-top: 13px;">基础奖金<span style="color:red;">*</span>：</td>
				<td><input type="text" value="${challengeBonus.baseBonusAmt}" name="baseBonusAmt" id="baseBonusAmt" placeholder="这里输入基础奖金" value="" title="基础奖金"  maxlength="32" /></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td style="width:120px;text-align: right;padding-top: 13px;">中间目标<span style="color:red;">*</span>：</td> -->
<%-- 				<td><input type="text" value="${challengeBonus.middleTarget}" name="middleTarget" id="middleTarget" placeholder="这里输入中间目标" value="" title="中间目标"  maxlength="32" /></td> --%>
<!-- 				<td style="width:120px;text-align: right;padding-top: 13px;">中间奖金<span style="color:red;">*</span>：</td> -->
<%-- 				<td><input type="text" value="${challengeBonus.middleBonusAmt}" name="middleBonusAmt" id="middleBonusAmt" placeholder="这里输入中间奖金" value="" title="中间奖金"  maxlength="32" /></td> --%>
<!-- 			</tr> -->
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">挑战目标<span style="color:red;">*</span>：</td>
				<td><input type="text" name="challengeTarget" id="challengeTarget" value="${challengeBonus.challengeTarget}"  placeholder="这里输入挑战目标" value="" title="挑战目标"  maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">挑战奖金<span style="color:red;">*</span>：</td>
				<td><input type="text" name="challengeBonusAmt" id="challengeBonusAmt" value="${challengeBonus.challengeBonusAmt}" placeholder="这里输入挑战奖金" value="" title="挑战奖金"  maxlength="32" /></td>
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
</body>
</html>