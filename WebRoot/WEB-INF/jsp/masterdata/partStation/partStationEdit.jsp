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
		<title>兼站人员</title>
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
		if($("#staffCode").val()==""){
			$("#staffCode").tips({
				side:3,
	            msg:'请输入员工编号',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#staffCode").focus();
			return false;
		}
	    if($("#dutyCode").val()==""){
			
			$("#dutyCode").tips({
				side:3,
	            msg:'请选择职务',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#dutyCode").focus();
			return false;
		}
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
	    
		if($("#baseAmt").val()==""){
			
			$("#baseAmt").tips({
				side:3,
	            msg:'请输入兼站金额',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#baseAmt").focus();
			return false;
		}
	    //验证输入的是否是数字
	    var re = /^[0-9]+.?[0-9]*$/;
	    if (!re.test($("#baseAmt").val())) {
	    	$("#baseAmt").tips({
				side:3,
	            msg:'请输入正确的兼站金额',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#baseAmt").focus();
			return false;
	    }
	    
		$("#partStationForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
<body>
	<form action="<%=basePath%>partStation/partStationSaveOrUpdate.do" name="partStationForm" id="partStationForm" method="post" >
		<input type="hidden" name="id" value="${partStation.id}" />
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工编号<span style="color:red;">*</span>：</td>
				<td><input disabled="disabled" type="text" name="staffCode" id="staffCode" value="${partStation.staffCode}" placeholder="这里输入员工" value="" title="员工"  maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">兼站金额<span style="color:red;">*</span>：</td>
				<td><input type="text" name="baseAmt" id="baseAmt" value="${partStation.baseAmt}" placeholder="这里输入兼站金额" value="" title="兼站金额"  maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">所属职务<span style="color:red;">*</span>：</td>
				<td>
					<select disabled="disabled" name="dutyCode" id="dutyCode" data-placeholder="请选择员工所属职务" style="vertical-align:top;width: 220px;" title="员工所属职务">
						<biztab:biz type="duty" code="all">
							<option value="${obj.dutyCode}" ${obj.dutyCode==partStation.dutyCode ? 'selected="selected"' : '' }>${obj.dutyName}</option>
						</biztab:biz>
					</select>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">所属油站<span style="color:red;">*</span>：</td>
				<td>
					<select disabled="disabled" name="stationCode" id="stationCode" data-placeholder="请选择员工所属职务" style="vertical-align:top;width: 220px;" title="员工所属职务">
						<biztab:biz type="station" code="all" >
							<option value="${obj.stationCode}" ${obj.stationCode==partStation.stationCode ? 'selected="selected"' : '' }>${obj.stationName}</option>
						</biztab:biz>
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
</body>
</html>