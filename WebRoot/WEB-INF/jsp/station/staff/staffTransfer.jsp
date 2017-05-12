<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="systab" uri="http://www.systab.com/jsp/tld/examples" %>
<%@ taglib prefix="biztab" uri="http://www.biztab.com/jsp/tld/examples" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		
		<meta charset="utf-8" />
		<title>调动申请</title>
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
		<script type="text/javascript" src="static/js/bootbox.min.js"></script>
</head>

<script type="text/javascript">
	$(top.hangge());
	
	//保存
	function save(){
		bootbox.confirm("请确认调动信息填写正确,提交后立即生效,确认立即提交？", function(result) {
			if(result) {
				$("#staffForm").submit();
				$("#zhongxin").hide();
				$("#zhongxin2").show();
			}
		});	
	}
	
</script>


<body>
	<form  action="<%=basePath%>staff/staffTransfer.do" name="staffForm" id="staffForm" enctype="multipart/form-data" method="post" >
		<div id="zhongxin">
		<input type="hidden" name="type" value="5" />
		<input type="hidden" name="sign" value="2" />
		<input type="hidden" name="flag" value="${flag}" />
		<input type="hidden" name="staffId" value="${staff.id }" />
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工编号：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">${staff.staffCode }<input type="hidden" name="staffCode" id="staffCode" value="${staff.staffCode }"/></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工姓名：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">${staff.staffName }</td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">调动前油站：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><biztab:biz type="station" code="${staff.stationCode }">
									<option value="${obj.stationCode}">${obj.stationName}</option>
								</biztab:biz>
								<input type="hidden" name="beforeStationCode" id="beforeStationCode" value="${staff.stationCode }" /></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">调动前职务：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
								<biztab:biz type="duty" code="${staff.dutyCode }">
									<option value="${obj.dutyCode}">${obj.dutyName}</option>
								</biztab:biz>
				<input type="hidden" name="beforeDutyCode" id="beforeDutyCode" value="${staff.dutyCode }" /></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">调动日期：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><input class="span10 date-picker" name="staffTransferDate" name="staffTransferDate" style="width:205px;"  value="${date}" type="text" data-date-format="yyyy-mm-dd" style="width:88px;" placeholder="调动日期" title="调动日期"/></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">调动附件：</td>
				<td>
					<input disabled="disabled" type="file" id="uploadPic" name="uploadPic" value="" style="width:220px;" />
				</td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">调动后油站：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><select name="afterStationCode" id="afterStationCode" class="chzn-select" data-placeholder="请选择员工调动后油站" style="vertical-align:top;width: 220px;" title="员工调动后油站">
								<biztab:biz type="station" code="all">
									<option value="${obj.stationCode}">${obj.stationName}</option>
								</biztab:biz>
					</select></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">调动后职务：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
					<select name="afterDutyCode" id="afterDutyCode" class="chzn-select" data-placeholder="请选择员工调动后职务" style="vertical-align:top;width: 220px;" title="员工调动后职务">
								<biztab:biz type="duty" code="all">
									<option value="${obj.dutyCode}" 
									 >
									${obj.dutyName}
									</option>
								</biztab:biz>
					</select></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">调动原因：</td>
				<td colspan="3">
					<textarea rows="4" cols="38" style="width: 666px" name="staffTransferCause"></textarea>
				</td>
			</tr>
			<tr>
				<td  style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">提交</a>
					<a class="btn btn-mini btn-danger" onclick="javascript:history.go(-1)">取消</a>
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