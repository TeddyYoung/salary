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
		<title>岗位工资</title>
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
		
		if($("#dutyCode").val()==""){
			$("#dutyCode").tips({
				side:3,
	            msg:'职务编号不正确，请输入正确的职务编号',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#dutyCode").focus();
			return false;
		}
	    if($("#areaCode").val()==""){
			
			$("#areaCode").tips({
				side:3,
	            msg:'请选择职务',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#areaCode").focus();
			return false;
		}
	 
		if($("#salaryAmt").val()==""){
			
			$("#salaryAmt").tips({
				side:3,
	            msg:'请输入岗位工资',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#salaryAmt").focus();
			return false;
		}
	    //验证输入的是否是数字
	    var re = /^[0-9]+.?[0-9]*$/;
	    if (!re.test($("#salaryAmt").val())) {
	    	$("#salaryAmt").tips({
				side:3,
	            msg:'请输入正确的岗位工资',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#salaryAmt").focus();
			return false;
	    }
	    
		$("#dutySalaryForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
<body>
	<form action="<%=basePath%>dutySalary/dutySalarySaveOrUpdate.do" name="dutySalaryForm" id="dutySalaryForm" method="post" >
		<input type="hidden" name="id" value="${dutySalary.id}" />
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
		<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">所属职务<span style="color:red;">*</span>：</td>
				<td>
					<select name="dutyCode" id="dutyCode" data-placeholder="请选择员工所属职务" style="vertical-align:top;width: 220px;" title="员工所属职务">
						<biztab:biz type="duty" code="all">
							<option value="${obj.dutyCode}" ${obj.dutyCode==dutySalary.dutyCode ? 'selected="selected"' : '' }>${obj.dutyName}</option>
						</biztab:biz>
					</select>
				</td>
<!-- 				<td style="width:120px;text-align: right;padding-top: 13px;">地区类型<span style="color:red;">*</span>：</td> -->
<!-- 				<td colspan="10" style="width:120px;text-align: left;padding-top: 13px;"> -->
<!-- 				    <select name="areaCode" id="areaCode"  data-placeholder="请选择所属地区站" style="vertical-align:top;width: 220px;"   title="所属地区站"> -->
<%-- 								<biztab:biz type="area" code="all"> --%>
<%-- 									<option value="${obj.areaCode}" >${obj.areaName}</option> --%>
<%-- 								</biztab:biz> --%>
<!-- 					</select> -->
<!-- 				</td> -->
				<td style="width:120px;text-align: right;padding-top: 13px;">岗位级别<span style="color:red;">*</span>：</td>
				<td>
					<select  name="jobLevel" id="jobLevel" data-placeholder="请选择岗位级别"
							style="vertical-align:top;width: 220px;" title="岗位级别" >
						<systab:dataDictionary codeType="job_level" valueType="all">
							<option value="${dataDictionary.valuetype}"  ${dataDictionary.valuetype==dutySalary.jobLevel ? 'selected="selected"' : '' }>${dataDictionary.valuename}</option>
						</systab:dataDictionary>
					</select>
				</td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">岗位工资<span style="color:red;">*</span>：</td>
				<td><input type="text" name="salaryAmt" id="salaryAmt" value="${dutySalary.salaryAmt}" placeholder="这里输入岗位工资" value="" title="岗位工资"  maxlength="32" /></td>
				<td colspan="2"></td>
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