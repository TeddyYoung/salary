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
	
	function changeStaffCode(){
		var staffCode = $.trim($("#staffCode").val());
		var stationCdoe = $("#stationCode").val();
		$.ajax({
			type: "POST",
			url: '<%=basePath %>staff/getStaff.do',
	    	data: {staffCode:staffCode,stationCode:stationCode},
			dataType:'json',
			cache: false,
			success: function(data){
				var staff = data.staff;
				if (staff.id == null || staff.id == "") {
					//$("#id").val("");/*  */
					$("#staffName").val("");
					$("#staffBank").val("");
					$("#staffBankcard").val("");
					$("#staffIdcard").val("");
					$("#staffPhone").val("");
					$("#staffSex").val("");
					$("#staffInDate").val("");
					$("#dutyCode").val("");
					$("#stationCode").val("");
					$("#flag").val("1");
				} else {// 变更页面的值
					//$("#id").val(staff.id);
					$("#staffName").val(staff.staffName);
					$("#staffBank").val(staff.staffBank);
					$("#staffBankcard").val(staff.staffBankcard);
					$("#staffIdcard").val(staff.staffIdcard);
					$("#staffPhone").val(staff.staffPhone);
					$("#staffSex").val(staff.staffSex);
					$("#staffInDate").val(staff.staffInDate);
					$("#dutyCode").val(staff.dutyCode);
					$("#stationCode").val(staff.stationCode);
					$("#flag").val("0");
				}
			}
		});
	}
		
	//保存
	function save(){
		// 身份证正则表达式
		var regIdcard = "/(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3})|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])(\d{4}|\d{3}[x]))$/";

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
		if(!/(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3})|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])(\d{4}|\d{3}[X|x]))$/.test($("#staffIdcard").val())){
			$("#staffIdcard").tips({
				side:3,
	            msg:'请输入正确的身份证号',
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
		if($("#staffInDate").val()==""){
			$("#staffInDate").tips({
				side:3,
	            msg:'这里选择入职日期',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#staffInDate").focus();
			return false;
		}
		$("#staffForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>


<body>
	<form  action="<%=basePath%>staff/staffSaveOrUpdate.do" name="staffForm" id="staffForm" enctype="multipart/form-data" method="post" >
		<input type="hidden" name="id" id="id" value=""/>
		<input type="hidden" name="type" value="1" />
		<input type="hidden" name="flag" id="flag" value="0" />
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<c:if test="${not empty message }">
				<tr>
					<td colspan="2" align="center"><font color="red">${message}</font></td>
				</tr>
			</c:if>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工编号：</td>
				<c:choose>
				<c:when test="${staff.staffCode != null}">
					<td><input disabled="disabled" type="text" name="staffCode" id="staffCode" placeholder="这里输入员工编号" value="${staff.staffCode}" title="员工编号"   maxlength="32"  /></td>
				</c:when>
				<c:otherwise>
					<td><input onblur="changeStaffCode();" type="text" name="staffCode" id="staffCode" placeholder="这里输入员工编号" value="${staff.staffCode}" title="员工编号"   maxlength="32"  /></td>
				</c:otherwise>
				</c:choose>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工姓名：</td>
				<td><input type="text" name="staffName" id="staffName" placeholder="这里输入员工姓名" value="${staff.staffName }" title="员工姓名"   maxlength="32"  /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">开户行：</td>
				<td><input type="text" name="staffBank" id="staffBank" placeholder="这里输入开户行" value="${staff.staffBank }" title="开户行   maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">银行卡号：</td>
				<td><input type="text" name="staffBankcard" id="staffBankcard" placeholder="这里输入银行卡号" value="${staff.staffBankcard }" title="银行卡号"   maxlength="32" /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">身份证号：</td>
				<td><input type="text" name="staffIdcard" id="staffIdcard" placeholder="这里输入身份证号" value="${staff.staffIdcard }" title="身份证号"   maxlength="32" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">联系电话：</td>
				<td><input type="text" name="staffPhone" id="staffPhone" placeholder="这里输入联系电话" value="${staff.staffPhone }" title="联系电话"   maxlength="32" /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">员工性别：</td>
				<td><select name="staffSex" id="staffSex" class="chzn-select" data-placeholder="请选择员工性别" style="vertical-align:top;width: 220px;"  title="员工性别">
								<systab:dataDictionary codeType="staffSex" valueType="all">
									<option value="${dataDictionary.valuetype}"  ${staff.staffSex == dataDictionary.valuetype ? 'selected="selected"':'' }>${dataDictionary.valuename}</option>
								</systab:dataDictionary>
					</select>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工照片：</td>
				<td>
					<input type="file" id="uploadPic" name="uploadPic" value="" style="width:220px;" />
				</td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">入职日期：</td>
				<td><input class="span10 date-picker" name="staffInDate" id="staffInDate"  value="${staff.staffInDate }" type="text" data-date-format="yyyy-mm-dd" style="width:205px;" placeholder="入职日期" title="入职日期"/></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工所属职务：</td>
				<td><select name="dutyCode" id="dutyCode" class="chzn-select" data-placeholder="请选择员工所属职务" style="vertical-align:top;width: 220px;" title="员工所属职务">
						<biztab:biz type="duty" code="all">
							<option value="${obj.dutyCode}"}>${obj.dutyName}</option>
						</biztab:biz>
								<%-- <option value="ZW_0009" ${staff.staffSex == 'ZW_0009' ? 'selected="selected"':'' }>加油员</option>
								<option value="ZW_0015" ${staff.staffSex == 'ZW_0015' ? 'selected="selected"':'' }>收银员</option>
								<option value="ZW_0017" ${staff.staffSex == 'ZW_0017' ? 'selected="selected"':'' }>见习主管</option>
								<option value="ZW_0013" ${staff.staffSex == 'ZW_0013' ? 'selected="selected"':'' }>油站主管</option> --%>
					</select></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">员工所属油站：</td>
				<td>
					<input type="hidden" name="stationCode" value="${staff.stationCode}" />
								<biztab:biz type="station" code="${staff.stationCode}">
									<option value="${obj.stationCode}">${obj.stationName}</option>
								</biztab:biz>
					</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">备注：</td>
				<td><input type="text" name="remark" id="remark" placeholder="这里输入备注" value="${staff.remark }" title="备注" /></td>
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