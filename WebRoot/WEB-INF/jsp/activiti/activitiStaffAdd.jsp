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
<fieldset>
 <legend>入职申请的任务办理</legend>
	<form  action="<%=basePath%>activiti/execution.do" name="staffForm" id="staffForm" method="post" >
		<input type="hidden" name="id" id="id" value="${staffTemp.id}"/>
		<input type="hidden" name="type"
				value="2" /> <input type="hidden" name="taskId" value="${taskId}" />
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工编号：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">${staffTemp.staffCode}</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工姓名：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">${staffTemp.staffName}</td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">身份证号：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">${staffTemp.staffIdcard} </td>
				<td style="width:120px;text-align: right;padding-top: 13px;">联系电话：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">${staffTemp.staffPhone}</td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">员工性别：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><systab:dataDictionary codeType="staffSex"
								valueType="${staffTemp.staffSex }">
						${dataDictionary.valuename}
					</systab:dataDictionary>
				</td>
				<td style="width:120px;text-align: right;padding-top: 13px;">协议期限：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">${staffTemp.agreementDeadline}</td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">员工所属职务：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><biztab:biz
								type="duty" code="${staffTemp.dutyCode}">
						 ${obj.dutyName}
					</biztab:biz></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">员工所属油站：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><biztab:biz type="station" code="${staffTemp.stationCode }">
						${obj.stationName}
					</biztab:biz></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">学历：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;"><systab:dataDictionary codeType="education"
								valueType="${staffTemp.education }">
						${dataDictionary.valuename}
					</systab:dataDictionary></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">用工类别：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
				<systab:dataDictionary codeType="staff_category"
								valueType="${staffTemp.staffCategory }">
						${dataDictionary.valuename}
					</systab:dataDictionary></td>
			</tr>
			<tr>	
				<td style="width:120px;text-align: right;padding-top: 13px;">合同类型：</td>
				<td style="width:120px;text-align: left;padding-top: 13px;">
				<systab:dataDictionary codeType="contract_type"
								valueType="${staffTemp.contractType }">
						${dataDictionary.valuename}
					</systab:dataDictionary></td>
				<td style="width:120px;text-align: right;padding-top: 13px;">合同期限：</td>
				<td  style="width:120px;text-align: left;padding-top: 13px;">
				<systab:dataDictionary codeType="contract_period"
								valueType="${staffTemp.contractPeriod }">
						${dataDictionary.valuename}
					</systab:dataDictionary></td>
			</tr>
			<tr>
			<td style="width:120px;text-align: right;padding-top: 13px;">到岗日期：</td>
				<td  style="width:120px;text-align: left;padding-top: 13px;">${staffTemp.entryDate}</td>
				<td style="width: 120px; text-align: right; padding-top: 13px;">指定审批人：</td>
						<td style="width: 120px; text-align: left; padding-top: 13px;"><select
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
			<tr>
						<td style="width: 120px; text-align: right; padding-top: 13px;">批注：</td>
						<td colspan="3"><textarea rows="4" cols="38"
								style="width: 666px" id="message" name="message"></textarea></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="10"><c:forEach
								items="${variableList}" var="variable" varStatus="vs">
								<input type="submit" class="btn btn-mini btn-primary"
									name="outcome" value="${variable}">
							</c:forEach></td>
					</tr>
		</table>
		</div>
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
	</form>
	</fieldset>
		<fieldset>
		<legend>入职申请的批注信息</legend>
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