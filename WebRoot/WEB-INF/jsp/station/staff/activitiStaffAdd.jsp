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
		<title>油站员工</title>
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
	            msg:'这里输入员工编号',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#staffCode").focus();
			return false;
		}     
		if($("#staffName").val()==""){
			
			$("#staffName").tips({
				side:3,
	            msg:'这里输入员工姓名',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#staffName").focus();
			return false;
		}     
		if($("#staffIdcard").val()==""){
			
			$("#staffIdcard").tips({
				side:3,
	            msg:'这里输入身份证号',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#staffIdcard").focus();
			return false;
		}     
		if($("#staffPhone").val()==""){
			
			$("#staffPhone").tips({
				side:3,
	            msg:'这里输入联系电话',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#staffPhone").focus();
			return false;
		}     
		$("#staffForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>


<body>
	<form  action="<%=basePath%>staff/staffSaveOrUpdate.do" name="staffForm" id="staffForm" method="post" >
		<input type="hidden" name="id" id="id" value=""/>
		<input type="hidden" name="type" value="1" />
		<input type="hidden" name="flag" value="${flag}" />
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工编号：</td>
				<td><input type="text" name="staffCode" id="staffCode" placeholder="这里输入员工编号" value="" title="员工编号"   maxlength="32"  /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工姓名：</td>
				<td><input type="text" name="staffName" id="staffName" placeholder="这里输入员工姓名" value="" title="员工姓名"   maxlength="32"  /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">身份证号：</td>
				<td><input type="text" name="staffIdcard" id="staffIdcard" placeholder="这里输入身份证号" value="" title="身份证号"   maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">联系电话：</td>
				<td><input type="text" name="staffPhone" id="staffPhone" placeholder="这里输入联系电话" value="" title="联系电话"   maxlength="32" /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">员工性别：</td>
				<td><select name="staffSex" id="staffSex" class="chzn-select" data-placeholder="请选择员工性别" style="vertical-align:top;width: 220px;"  title="员工性别">
								<option value=""></option>
								<systab:dataDictionary codeType="staffSex" valueType="all">
									<option value="${dataDictionary.valuetype}">${dataDictionary.valuename}</option>
								</systab:dataDictionary>
					</select>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工所属职务：</td>
				<td><select name="dutyCode" id="dutyCode" class="chzn-select" data-placeholder="请选择" style="vertical-align:top;width: 220px;" title="员工所属职务">
									<option value="ZW_0009">加油员</option>
									<option value="ZW_0015">收银员</option>
									<option value="ZW_0017">见习主管</option>
									<option value="ZW_0013">油站主管</option>
					</select></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">学历：</td>
				<td><select name="education" id="education" class="chzn-select" data-placeholder="请选择" style="vertical-align:top;width: 220px;" title="员工所属职务">
								<option value=""></option>
							<systab:dataDictionary codeType="education" valueType="all">
								<option value="${dataDictionary.valuetype}">${dataDictionary.valuename}</option>
							</systab:dataDictionary>
					</select></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">用工类别：</td>
				<td><select name="staffCategory" id="staffCategory" class="chzn-select" data-placeholder="请选择" style="vertical-align:top;width: 220px;" title="员工所属油站">
								<option value=""></option>
							<systab:dataDictionary codeType="staff_category" valueType="all">
								<option value="${dataDictionary.valuetype}">${dataDictionary.valuename}</option>
							</systab:dataDictionary>
					</select></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">合同类型：</td>
				<td><select name="contractType" id="contractType" class="chzn-select" data-placeholder="请选择" style="vertical-align:top;width: 220px;" title="员工所属职务">
								<option value=""></option>
							<systab:dataDictionary codeType="contract_type" valueType="all">
								<option value="${dataDictionary.valuetype}">${dataDictionary.valuename}</option>
							</systab:dataDictionary>
					</select></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">合同期限：</td>
				<td><select name="contractPeriod" id="contractPeriod" class="chzn-select" data-placeholder="请选择" style="vertical-align:top;width: 220px;" title="员工所属油站">
								<option value=""></option>
							<systab:dataDictionary codeType="contract_period" valueType="all">
								<option value="${dataDictionary.valuetype}">${dataDictionary.valuename}</option>
							</systab:dataDictionary>
					</select></td>
			</tr>
			<tr>
			<td style="width:120px;text-align: right;padding-top: 13px;">到岗日期：</td>
				<td><input class="span10 date-picker" name="entryDate" name="entryDate"  value="" type="text" data-date-format="yyyy-mm-dd" style="width:205px;" placeholder="入职日期" title="入职日期"/></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">备注：</td>
				<td><input type="text" name="remark" id="remark" placeholder="这里输入备注" value="" title="备注" /></td>
			</tr>
			<tr>
				<td  style="text-align: center;" colspan="10">
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
				
				/* $('#staffPhoto').ace_file_input({
					no_file:'请选择图片 ...',
					btn_choose:'选择',
					btn_change:'更改',
					droppable:false,
					onchange:null,
					thumbnail:false //| true | large
					//whitelist:'gif|png|jpg|jpeg'
					//blacklist:'exe|php'
					//onchange:''
				}); */
			});
		</script>
</body>
</html>