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
		if($("#areaCode").val()==""){
			
			$("#areaCode").tips({
				side:3,
	            msg:'请输入地区编号',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#areaCode").focus();
			return false;
		}
	    if($("#areaName").val()==""){
			
			$("#areaName").tips({
				side:3,
	            msg:'请输入地区名称',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#areaName").focus();
			return false;
		}
	    if($("#areaMealSupplement").val()==""){
			
	    	$("#areaMealSupplement").tips({
				side:3,
	            msg:'请输入用餐补贴',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#areaMealSupplement").focus();
			return false;
		}
	    
	    //验证输入的是否是数字
	    var re = /^[0-9]+.?[0-9]*$/;
	    if (!re.test($("#areaMealSupplement").val())) {
	    	$("#areaMealSupplement").tips({
				side:3,
	            msg:'请输入正确的用餐补贴',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#areaMealSupplement").focus();
			return false;
	    }
	    
	    if($("#areaHouseSupplement").val()==""){
			
			$("#areaHouseSupplement").tips({
				side:3,
	            msg:'请输入住宿补贴',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#areaHouseSupplement").focus();
			return false;
		}
	    
	    var re = /^[0-9]+.?[0-9]*$/;
	    if (!re.test($("#areaHouseSupplement").val())) {
	    	$("#areaHouseSupplement").tips({
				side:3,
	            msg:'请输入正确的住宿补贴',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#areaHouseSupplement").focus();
			return false;
	    }
		$("#areaForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
<body>
	<form action="<%=basePath%>area/areaSaveOrUpdate.do" name="areaForm" id="areaForm" method="post" >
		<input type="hidden" name="id" id="id" value=""/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">地区编号：</td>
				<td><input type="text" name="areaCode" id="areaCode" placeholder="这里输入地区编号" value="" title="地区编号"  maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">地区名称：</td>
				<td><input type="text" name="areaName" id="areaName" placeholder="这里输入地区名称" value="" title="地区名称"  maxlength="32" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">用餐补贴：</td>
				<td><input type="text" name="areaMealSupplement" id="areaMealSupplement" placeholder="这里输入用餐补贴" value="" title="用餐补贴"  maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">住宿补贴：</td>
				<td><input type="text" name="areaHouseSupplement" id="areaHouseSupplement" placeholder="这里输入住宿补贴" value="" title="住宿补贴"  maxlength="32" /></td>
			</tr>
			<!-- 
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">地区级别：</td>
				<td><input type="text" name="areaLevel" id="areaLevel" placeholder="这里输入地区级别" value="" title="地区级别"  maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">上级级别：</td>
				<td><input type="text" name="fatherAreaCode" id="fatherAreaCode" placeholder="这里输入上级级别" value="" title="地区级别"  maxlength="32" /></td>
			</tr>
			 -->
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">备注：</td>
				<td colspan="10"><input type="text" name="remark" id="remark" placeholder="这里输入备注" value="" title="备注" style="width:605px;" /></td>
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