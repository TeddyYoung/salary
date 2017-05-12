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
		<title></title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>

<script type="text/javascript">
	$(top.hangge());	
	function toCheck(id,flag){
		if(flag=="0") {// 离职申请
		 	window.location.href='<%=basePath%>activiti/staffLeaveOfficeToCheck.do?id='+id;
		} else if(flag=="1") {// 入职申请
		 	window.location.href='<%=basePath%>activiti/staffTransferToCheck.do?id='+id;
		} else if(flag=="2") {// 调动申请
		 	window.location.href='<%=basePath%>activiti/staffTransferToCheck.do?id='+id;
		} else if (flag=='3') {// 升迁申请
			window.location.href='<%=basePath%>activiti/staffTransferToCheck.do?id='+id;
		} else if (flag=='4') {// 考勤申请
			window.location.href='<%=basePath%>/activiti/attendance/toCheck.do?id='+id;
		} else if (flag=='5') {// 薪资差异申请
			window.location.href='<%=basePath%>/activiti/salaryDifferenceToCheck.do?id='+id;
		}
	}
</script>
</head>

<body>
	<fieldset>
	<legend>已办事项</legend>
	<table id="table_report" class="table table-striped table-bordered table-hover">
		<thead>
		<tr>
			<th class="center"  style="width: 50px;">序号</th>
			<th class='center'>流程类型</th>
			<th class='center'>所属油站</th>
			<th class='center'>任务名称</th>
			<th class='center'>执行者</th>
			<th class='center'>执行操作</th>
			<th class='center'>开始时间</th>
			<th class='center'>结束时间</th>
			<th class='center'>操作</th>
		</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty list}">
				<c:forEach items="${list}" var="generalStaffLeaveOffice" varStatus="vs">
				<tr>
				<td class="center">${vs.index+1}</td>
				
				<td class='center'>
					<c:if test="${generalStaffLeaveOffice.flag==0}">离职申请</c:if>
					<c:if test="${generalStaffLeaveOffice.flag==1}">入职申请</c:if>
					<c:if test="${generalStaffLeaveOffice.flag==2}">调动申请</c:if>
					<c:if test="${generalStaffLeaveOffice.flag==3}">升迁申请</c:if>
					<c:if test="${generalStaffLeaveOffice.flag==4}">考勤申请</c:if>
					<c:if test="${generalStaffLeaveOffice.flag==5}">薪资差异申请</c:if>
				</td>
				<td class='center'>${generalStaffLeaveOffice.staff.stationName}</td>
				<td class='left'>${generalStaffLeaveOffice.actHiActinst.actName}</td>
				<td class='left'>${generalStaffLeaveOffice.actHiActinst.assignee}</td>
				<td class='center'>${generalStaffLeaveOffice.actHiActinst.operation}</td>
				<td class='center'><fmt:formatDate value="${generalStaffLeaveOffice.actHiActinst.startTime}" type="both"/></td>
				<td class='center'><fmt:formatDate value="${generalStaffLeaveOffice.actHiActinst.endTime}" type="both"/></td>
				<td>
					<a class='btn btn-mini btn-info' onclick="toCheck('${generalStaffLeaveOffice.actHiActinst.procInstId}','${generalStaffLeaveOffice.flag}')"  >查看审批流程</a>
				</td>
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
<%-- 	<table id="table_report" class="table table-striped table-bordered table-hover">
		<thead>
		<tr>
			<th class="center"  style="width: 50px;">序号</th>
			<th class='center'>离职员工</th>
			<th class='center'>离职申请日期</th>
			<th class='center'>离职原因</th>
			<th class='center'>离职状态</th>
			<th class='center'>任务名称</th>
			<th class='center'>执行者</th>
			<th class='center'>任务执行时间</th>
			<th class='center'>任务结束时间</th>
			<th class='center'>操作</th>
		</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty list}">
				<c:forEach items="${list}" var="generalStaffLeaveOffice" varStatus="vs">
				<tr>
				<td class="center">${vs.index+1}</td>
				<td class='center'>${generalStaffLeaveOffice.staff.staffName}</td>
				<td class='center'>${generalStaffLeaveOffice.staff.staffOutDate} </td>
				<td class='center'>${generalStaffLeaveOffice.staff.staffOutCause}</td>
				<td class='center'>
					<systab:dataDictionary codeType="staffOutStatus" valueType="${generalStaffLeaveOffice.staff.staffOutStatus}">
						${dataDictionary.valuename}
					</systab:dataDictionary>
				</td>
				<td class='center'>${generalStaffLeaveOffice.historicActivityInstance.name}</td>
				<td class='center'>${generalStaffLeaveOffice.historicActivityInstance.assignee}</td>
				<td class='center'><fmt:formatDate value="${generalStaffLeaveOffice.historicActivityInstance.startTime}" type="both"/></td>
				<td class='center'><fmt:formatDate value="${generalStaffLeaveOffice.historicActivityInstance.endTime}" type="both"/></td>
				<td>
				<a class='btn btn-mini btn-info' onclick="toCheck('${generalStaffLeaveOffice.historicActivityInstance.processInstanceId}')"  >查看审批流程</a>
				</td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
				<td colspan="100">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table> --%>
</body>
</html>