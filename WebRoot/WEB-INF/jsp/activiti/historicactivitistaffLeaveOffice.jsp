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
	
	function down(staffOutUrl){
		window.open('<%=basePath%>uploadFiles' + staffOutUrl,'_blank');
	}
</script>


<body>

<fieldset>
	<legend>离职申请的查看</legend>
		<input type="hidden" name="id" id="id" value="${staff.id}"/>
		<input type="hidden" name="stationCode" id="stationCode" value="${staff.stationCode}"/>
		<input type="hidden" name="type" value="2" />
		<input type="hidden" name="taskId" value="${taskId}" />
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工编号：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">${staff.staffCode }</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工姓名：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">${staff.staffName }</td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">员工性别：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
					<systab:dataDictionary codeType="staffSex" valueType="${staff.staffSex }">
						${dataDictionary.valuename}
					</systab:dataDictionary>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">联系电话：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">${staff.staffPhone }</td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">所属油站：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
					<biztab:biz type="station" code="${staff.stationCode }">
						${obj.stationName}
					</biztab:biz>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工职务：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><biztab:biz type="duty" code="${staff.dutyCode}">
						 ${obj.dutyName}
					</biztab:biz>
				</td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">离职前人员类别：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
						<systab:dataDictionary codeType="outStaffCategory" valueType="${staff.outStaffCategory }">
							${dataDictionary.valuename}
						</systab:dataDictionary>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">离职类型：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
						<systab:dataDictionary codeType="staffOutType" valueType="${staff.staffOutType }">
							${dataDictionary.valuename}
						</systab:dataDictionary>
				</td>
			</tr>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">离职附件：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
					<c:if test="${staff.staffOutUrl!=null}">
						<input type="button" id="uploadPic" name="uploadPic" value="点击查看" onclick="down('${staff.staffOutUrl}')" style="width:220px;" />
					</c:if>
					<c:if test="${staff.staffOutUrl==null}">
						没有相关附件
					</c:if>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">离职原因：</td>
				<td colspan="2"  style="width: 120px; text-align: left; padding-top: 13px;">
					${staff.staffOutCause}
				</td>
			</tr>
			<tr>
				<td colspan="4" style="width:120px;text-align: center;padding-top: 13px;">
					<input type="button" class="btn btn-mini btn-danger" name="outcome" onclick="javascript:history.go(-1)" value="返回" />
				</td>
			</tr>
		</table>
		</div>
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
</fieldset>
<fieldset>
	<legend>离职申请的流程信息</legend>
	<table id="table_report" class="table table-striped table-bordered table-hover">
		<thead>
		<tr>
			<th class="center"  style="width: 50px;">序号</th>
			<th class='center'>任务名称</th>
			<th class='center'>执行者</th>
			<th class='center'>操作</th>
			<th class='center'>开始时间</th>
			<th class='center'>结束时间</th>
		</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty list}">
				<c:forEach items="${list}" var="generalStaffLeaveOffice" varStatus="vs">
				<tr>
				<td class="center">${vs.index+1}</td>
				<td class='center'>${generalStaffLeaveOffice.actHiActinst.actName} </td>
				<td class='center'>${generalStaffLeaveOffice.actHiActinst.assignee}</td>
				<td class='center'>${generalStaffLeaveOffice.actHiActinst.operation}</td>
				<td class='center'><fmt:formatDate value="${generalStaffLeaveOffice.actHiActinst.startTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
				<td class='center'><fmt:formatDate value="${generalStaffLeaveOffice.actHiActinst.endTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
				<td colspan="100">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</fieldset>
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