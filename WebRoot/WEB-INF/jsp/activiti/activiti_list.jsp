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
		<title>油站会计-待办事项</title>
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
	
	//办理任务 
	function toView(id,flag){
		if("0"==flag) {
			window.location.href='<%=basePath%>activiti/staffLeaveOfficeToView.do?taskId='+id+"&flag="+flag;// 离职申请
		} else if("2"==flag) {
			window.location.href='<%=basePath%>activiti/staffTransferToView.do?taskId='+id+"&flag="+flag;// 调动申请
		} else if("4"==flag) {
			window.location.href='<%=basePath%>activiti/attendance/toView.do?taskId='+id+"&flag="+flag;// 考勤申请
		} else if ("5" == flag) {
			window.location.href='<%=basePath%>activiti/salaryDifferenceToView.do?taskId='+id+"&flag="+flag;// 薪资差异申请
		}
		
	}
	//查看当前流程图
	function toCheckFlowDiagram(id){
		 window.location.href='<%=basePath%>activiti/toCheckFlowDiagram.do?id='+id;
	}
</script>
</head>

<body>
<fieldset>
	<legend>待办事项</legend>
	<table id="table_report" class="table table-striped table-bordered table-hover">
		<thead>
		<tr>
			<th class="center"  style="width: 50px;">序号</th>
			<th class='center'>流程类型</th>
			<th class='center'>任务名称</th>
			<th class='center'>执行者</th>
			<th class='center'>开始时间</th>
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
				<td class='center'>${generalStaffLeaveOffice.task.name}</td>
				<td class='center'>${generalStaffLeaveOffice.task.assignee}</td>
				<td class='center'><fmt:formatDate value="${generalStaffLeaveOffice.task.createTime}" type="both"/></td>
				<td class="center">
					<a class='btn btn-mini btn-info' onclick="toView('${generalStaffLeaveOffice.task.id}','${generalStaffLeaveOffice.flag}')"  >办理任务</a>
				<a class='btn btn-mini btn-info' onclick="toCheckFlowDiagram('${generalStaffLeaveOffice.task.id}')"  >查看当前流程图</a>
				</td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
				<td class='center' colspan="100">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
<%-- 	<table id="table_report" class="table table-striped table-bordered table-hover">
		<thead>
		<tr>
			<th class="center"  style="width: 50px;">序号</th>
			<th class='center'>流程类型</th>
			<th class='center'>任务名称</th>
			<th class='center'>执行者</th>
			<th class='center'>流程状态</th>
			<th class='center'>创建时间</th>
			<th class='center'>操作</th>
		</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty list}">
				<c:forEach items="${list}" var="tbWorkflowUserDUser" varStatus="vs">
				<tr>
				<td class="center">${vs.index+1}</td>
				<td class='center'>${tbWorkflowUserDUser.flowType}</td>
				<td class='center'>${tbWorkflowUserDUser.task.name}</td>
				<td class='center'>${tbWorkflowUserDUser.task.assignee}</td>
				<td class='center'><systab:dataDictionary codeType="tbWorkflowUserDUserDiff" valueType="${tbWorkflowUserDUser.diff}">
						${dataDictionary.valuename}
					</systab:dataDictionary></td>
				<td class='center'><fmt:formatDate
								value="${tbWorkflowUserDUser.beginDate}" type="both" /></td>
				<td>
				<a class='btn btn-mini btn-info' onclick="toView('${tbWorkflowUserDUser.task.id}','${tbWorkflowUserDUser.id}')"  >办理任务</a>
				<a class='btn btn-mini btn-info' onclick="toCheckFlowDiagram('${tbWorkflowUserDUser.task.id}')"  >查看当前流程图</a>
				</td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
				<td class="center" colspan="100">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table> --%>
	<%-- <table id="table_report" class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th class='center'>序号</th>
				<th class='center'>薪资差异员工</th>
				<th class='center'>所属油站</th>
				<th class='center'>应发薪资（差异结算前）</th>
				<th class='center'>调整金额（补差）</th>
				<th class='center'>调整说明（扣款）</th>
				<th class='center'>应发薪资（差异结算后）</th>
				<th class='center'>申请状态</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${!empty sdOfficelist}">
				<c:forEach items="${sdOfficelist}" var="sdOffice" varStatus="vs">
					<tr>
						<td class="center">${vs.count}</td>
						<td class="center">${sdOffice.staffList.get(vs.index).staffName}</td>
						<td class="center">${sdOffice.stationList.get(vs.index).stationName}</td>
						<td class="center">${sdOffice.salaryDifferenceList.get(vs.index).salarySummary}</td>
						<td class="center">${sdOffice.salaryDifferenceList.get(vs.index).salaryDifferencePositive}</td>
						<td class="center">${sdOffice.salaryDifferenceList.get(vs.index).salaryDifferenceNegative}</td>
						<td class="center">
						
						</td>
						<td>${sdOffice.task.assignee}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td class="center" colspan="7">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table> --%>
</fieldset>
</body>
</html>