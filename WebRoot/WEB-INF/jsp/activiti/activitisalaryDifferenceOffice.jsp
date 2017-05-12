<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="systab" uri="http://www.systab.com/jsp/tld/examples"%>
<%@ taglib prefix="biztab" uri="http://www.biztab.com/jsp/tld/examples"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">

<meta charset="utf-8" />
<title>区域经理</title>
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

<link rel="stylesheet" href="static/css/datepicker.css" />
<!-- 日期框 -->
<script src="static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="static/js/jquery.tips.js"></script>
<script type="text/javascript" src="static/js/myjs/city.js"></script>
</head>

<script type="text/javascript">
	$(top.hangge());
	
	function check() {
// 		var ui = "${!empty Flag && Flag.flag == 'rlzyb'}";
		if ("${!empty Flag && Flag.flag == 'rlzyb'}") {
			var count=${fn:length(salaryDifferenceList)};
			var reg=new RegExp("^[-+]?[0-9]+(\\.[0-9]+)?$"); //正负小数数
			for(var i=0;i<count;i++){
				if ($("#salaryDifferencePositive"+i).val().length != 0) {
					if(!reg.test($("#salaryDifferencePositive"+i).val())){
						$("#salaryDifferencePositive"+i).tips({
							side:1,
				            msg:'请输入正确的最终差异调整额!',
				            bg:'#AE81FF',
				            time:2
				        });
						$("#salaryDifferencePositive"+i).focus();
						return false;
					}
				}
			}
		}else{
			return true;
		}
	}
	
	function toCheck(id,flag){
		if(flag=="0")
		 window.location.href='<%=basePath%>activiti/salaryDifferenceToCheck.do?id='+id;
		if(flag=="2")
		 window.location.href='<%=basePath%>activiti/staffTransferToCheck.do?id='+id;
	}
</script>
<body>
	<fieldset>
		<legend>薪资差异申请审批</legend>
		<form action="<%=basePath%>activiti/salaryDifferenceExecution.do" onsubmit="return check();" name="salaryDifferenceForm"
			  id="salaryDifferenceForm" method="post">
			<input type="hidden" name="type" value="2"/> 
			<input type="hidden" name="taskId" value="${taskId}"/>
			<input type="hidden" name="sign" value="2"/>
			<input type="hidden" name="tbWorkflowUserDUserId" value="${tbWorkflowUserDUserId}" />
<%-- 			<c:forEach items="${variableList}" var="variable" varStatus="vs"> --%>
<%-- 				<input type="hidden" name="outcome" value="${variable}" id="outcome_" + vs> --%>
<%-- 			</c:forEach> --%>
			<input type="hidden" name="flowType" value="薪资差异申请" />
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">
							员工编号
						</td>
						<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">员工姓名</td>
						<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">所属油站</td>
						<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">申请说明</td>
						<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">年月份</td>
						<c:if test="${!empty Flag && Flag.flag == 'rlzyb'}">
							<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">最终差异调整额</td>
						</c:if>
					</tr>
					<c:forEach items="${salaryDifferenceList}" var="sd" varStatus="vs">
						<tr>
							<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">
								<input type="hidden" name="salaryDifferenceList[${vs.index}].staffCode" value="sd.staffCode" />
								${sd.staffCode}
							</td>
							<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">${sd.staffName}</td>
							<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">${sd.stationName}</td>
							<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">${sd.remark}</td>
							<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">${sd.yearMonth}</td>
							<c:if test="${!empty Flag && Flag.flag == 'rlzyb'}">
								<td class="center" style="width: 120px; text-align: right; padding-top: 13px;">
									<input type="text" id="salaryDifferencePositive${vs.index}" name="salaryDifferenceList[${vs.index}].salaryDifferencePositive" placeholder="请输入薪资差异调整额" />
								</td>
							</c:if>
						</tr>
					</c:forEach>
					<c:if test="${empty Flag.flag}">
						<tr>
							<td style="width: 120px; text-align: right; padding-top: 13px;">指定审批人：</td>
							<td colspan="5" style="width: 120px; text-align: left; padding-top: 13px;"><select
								name="nextUserName" id="nextUserName" class="chzn-select"
								data-placeholder="请选择指定审批人"
								style="vertical-align: top; width: 220px;" title="指定审批人">
									<c:forEach items="${storeEmployeeVOList}" var="storeEmployeeVO">
										<option value="${storeEmployeeVO.username }">
											${storeEmployeeVO.username }-${storeEmployeeVO.storePartName }
										</option>
										<input type="hidden" name="nextStorePartName" value="${storeEmployeeVO.storePartName}" />
										<input type="hidden" name="nextOrganiseName" value="${storeEmployeeVO.organiseName}" />
									</c:forEach>
							</select></td>
						</tr>
					</c:if>
					<tr>
						<td style="width: 120px; text-align: right; padding-top: 13px;">批注：</td>
						<td colspan="3">
							<textarea rows="4" cols="38" style="width: 666px" id="message" name="message"></textarea>
						</td>
					</tr>
					<!-- 
					<tr>
						<td style="width: 120px; text-align: right; padding-top: 13px; ">添加抄送：</td>
						<td colspan="3">
								    <select multiple="multiple" name="storePartNameCC" id="storePartNameCC" class="chzn-select" >
								        <c:forEach items="${storeEmployeeList}" var="storeEmployee" varStatus="vs">
								        	<option value="${storeEmployee.storePartName}-${storeEmployee.username}">${storeEmployee.storePartName}-${storeEmployee.username}</option>
								        </c:forEach>
								    </select>
						</td>
					</tr>
					-->
					<tr>
						<td style="text-align: center;" colspan="10">
							<c:forEach items="${variableList}" var="variable" varStatus="vs">
									<input type="submit" class="btn btn-mini btn-primary" name="outcome" value="${variable}">
							</c:forEach>
						</td>
					</tr>
				</table>
			</div>
			<div id="zhongxin2" class="center" style="display: none">
				<br /> <br /> <br /> <img src="static/images/jiazai.gif" /><br />
				<h4 class="lighter block green"></h4>
			</div>
		</form>
	</fieldset>
	<fieldset>
		<legend>薪资差异申请的批注信息</legend>
		<a class='btn btn-mini btn-info' onclick="toCheck('${task.processInstanceId}','0')">查看历史审批流程信息</a>
		<table id="table_report"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th class="center" style="width: 50px;">序号</th>
					<th class='center'>时间</th>
					<th class='center'>批注人</th>
					<th class='center'>批注信息</th>
				</tr>
			</thead>
			<c:choose>
				<c:when test="${not empty list}">
					<c:forEach items="${list}" var="comment" varStatus="vs">
						<tr>
							<td class="center">${vs.index+1}</td>
							<td class='center'><fmt:formatDate value="${comment.time}"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td class='center'>${comment.userId}</td>
							<td class='center'>${comment.fullMessage}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td class="center" colspan="100">没有相关数据</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</fieldset>
	<!-- 引入 -->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");
	</script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/ace-elements.min.js"></script>
	<script src="static/js/ace.min.js"></script>
	<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script>
	<!-- 下拉框 -->
	<script type="text/javascript"
		src="static/js/bootstrap-datepicker.min.js"></script>
	<!-- 日期框 -->
	<script type="text/javascript">
		$(function() {
			//单选框
			$(".chzn-select").chosen();
			$(".chzn-select-deselect").chosen({
				allow_single_deselect : true
			});

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