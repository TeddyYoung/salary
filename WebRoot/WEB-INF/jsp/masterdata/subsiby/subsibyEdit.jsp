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
		<title>过节费维护</title>
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
		if($("#yearMonth").val()==""){
			
			$("#yearMonth").tips({
				side:3,
	            msg:'请输入年份月份',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#yearMonth").focus();
			return false;
		}
// 	    if($("#holidayName").val()==""){
			
// 			$("#holidayName").tips({
// 				side:3,
// 	            msg:'请输入补贴名称',
// 	            bg:'#AE81FF',
// 	            time:2
// 	        });
			
// 			$("#holidayName").focus();
// 			return false;
// 		}
		if($("#holidayMoney").val()==""){
			
			$("#holidayMoney").tips({
				side:3,
	            msg:'请输入补贴金额',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#holidayMoney").focus();
			return false;
		}	
		var reg = new RegExp("^([0-9])+(\.[0-9]+)?$");
		if (!reg.test($("#holidayMoney").val())) {
			$("#holidayMoney").tips({
				side:1,
	            msg:'请输入正确的补贴金额',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#holidayMoney").focus();
			return false;
		}
		
		$("#holidayForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
</script>


<body>
	<form  action="<%=basePath%>subsiby/subsibySaveOrUpdate.do" name="holidayForm" id="holidayForm" method="post" >
		<input type="hidden" name="id" value="${holiday.id}" />
		<div id="zhongxin">
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<tr>
					<td style="width:120px;text-align: right;padding-top: 13px;">年份月份<span style="color:red;">*</span>：</td>
					<td><input type="text" name="yearMonth" id="yearMonth" placeholder="这里输入年份月份" value="${holiday.yearMonth}" title="年份月份"  maxlength="32" /></td>
<!-- 					<td style="width:120px;text-align: right;padding-top: 13px;">补贴名称<span style="color:red;">*</span>：</td> -->
<%-- 					<td><input type="text" name="holidayName" id="holidayName" placeholder="这里输入补贴名称" value="${holiday.holidayName}" title="补贴名称"  maxlength="32" /></td> --%>
					<td style="width:120px;text-align: right;padding-top: 13px;">补贴类型<span style="color:red;">*</span>：</td>
					<td>
					<select  name="type" id="type"  data-placeholder="请选择补贴类型"
							style="vertical-align:top;width: 220px;" title="补贴类型" >
						<systab:dataDictionary codeType="subsidy_type" valueType="all">
							<option value="${dataDictionary.valuetype}"  ${dataDictionary.valuetype==holiday.type ? 'selected="selected"' : '' }>${dataDictionary.valuename}</option>
						</systab:dataDictionary>
					</select>
				</td>
				</tr>
				<tr>
					<td style="width:120px;text-align: right;padding-top: 13px;">补贴金额<span style="color:red;">*</span>：</td>
					<td><input type="text" name="holidayMoney" id="holidayMoney" placeholder="这里输入补贴金额" value="<fmt:formatNumber type='number' value='${holiday.holidayMoney}' pattern='0.00' maxFractionDigits='2' />" title="补贴金额"  maxlength="32" /></td>
					<td colspan="2"></td>
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