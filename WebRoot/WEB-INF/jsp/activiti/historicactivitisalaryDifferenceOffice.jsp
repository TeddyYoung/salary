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
	<legend>薪资差异申请的查看</legend>
		<table id="table_report"
			class="table table-striped table-bordered table-hover">
			<tr>
				<td class="center"
					style="width: 120px; text-align: right; padding-top: 13px;">
					员工编号</td>
				<td class="center"
					style="width: 120px; text-align: right; padding-top: 13px;">员工姓名</td>
				<td class="center"
					style="width: 120px; text-align: right; padding-top: 13px;">所属油站</td>
				<td class="center"
					style="width: 120px; text-align: right; padding-top: 13px;">申请说明</td>
				<td class="center"
					style="width: 120px; text-align: right; padding-top: 13px;">年月份</td>
				<c:if test="${!empty Flag && Flag.flag == 'rlzyb'}">
					<td class="center"
						style="width: 120px; text-align: right; padding-top: 13px;">最终差异调整额</td>
				</c:if>
			</tr>
			<c:forEach items="${salaryDifferenceList}" var="sd" varStatus="vs">
				<tr>
					<td class="center"
						style="width: 120px; text-align: right; padding-top: 13px;">
						<input type="hidden"
						name="salaryDifferenceList[${vs.index}].staffCode"
						value="sd.staffCode" /> ${sd.staffCode}
					</td>
					<td class="center"
						style="width: 120px; text-align: right; padding-top: 13px;">${sd.staffName}</td>
					<td class="center"
						style="width: 120px; text-align: right; padding-top: 13px;">${sd.stationName}</td>
					<td class="center"
						style="width: 120px; text-align: right; padding-top: 13px;">${sd.remark}</td>
					<td class="center"
						style="width: 120px; text-align: right; padding-top: 13px;">${sd.yearMonth}</td>
					<c:if test="${!empty Flag && Flag.flag == 'rlzyb'}">
						<td class="center"
							style="width: 120px; text-align: right; padding-top: 13px;">
							<input type="text" id="salaryDifferencePositive${vs.index}"
							name="salaryDifferenceList[${vs.index}].salaryDifferencePositive"
							placeholder="请输入薪资差异调整额" />
						</td>
					</c:if>
				</tr>
			</c:forEach>
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">
					<input type="button" class="btn btn-mini btn-primary" name="outcome" onclick="javascript:history.go(-1)" value="返回" />
				</td>
			</tr>
		</table>
	</fieldset>
<fieldset>
	<legend>薪资差异申请的流程信息</legend>
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