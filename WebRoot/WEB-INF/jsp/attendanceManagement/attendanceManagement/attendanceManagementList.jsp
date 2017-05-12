<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../base.jsp"%>
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
<%@ include file="../../system/admin/top.jsp"%>
<meta charset="utf-8" />
<title>考勤管理</title>
<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/ace-elements.min.js"></script>
<script src="static/js/ace.min.js"></script>
<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script>
<!-- 下拉框 -->
<script type="text/javascript"
	src="static/js/bootstrap-datepicker.min.js"></script>
<!-- 日期框 -->
<script type="text/javascript" src="static/js/bootbox.min.js"></script>
<!-- 确认窗口 -->
<!-- 引入 -->
<script type="text/javascript" src="static/js/jquery.tips.js"></script>
<!--提示框-->

<script type="text/javascript">
	$(top.hangge());
	
	//添加星级评测信息
	function saveOrUpdateAttendanceManagement() {
		if($("#nav-search-input").val() != "${searchVO.yearMonth}"){
			$("#nav-search-input").tips({
				side:3,
	            msg:'对不起，仅可以添加或修改上个月的考勤管理信息',
	            bg:'#AE81FF',
	            time:2
	        });
			return false;
		}
		
		if($("#status").val() == '1' && $("#isResubmit").val() == '0'){
			$("#saveOrUpdateAttendanceManagement").tips({
				side:3,
	            msg:'考勤已经生效,不能重复修改',
	            bg:'#AE81FF',
	            time:2
	        });
			return false;
		}
		
		$.ajax({
			type: "POST",
			url: '<%=basePath %>attendanceManagement/checkSubmittedAtten.do',
			dataType:'json',
			async: false, 
			cache: false,
			success: function(data){
				var result = data.result;
				if(result == 1){
					$("#saveOrUpdateAttendanceManagement").tips({
						side:3,
			            msg:'有审批中的考勤,不能修改',
			            bg:'#AE81FF',
			            time:2
			        });
					return false;
				}else{
					window.location.href = "<%=basePath%>attendanceManagement/saveOrUpdateattendanceManagement.do?stationCode=" + $("#stationCode").val();
				}
			}
		});
		
	}
	
	function exportExcel() {
		window.location.href = "<%=basePath%>attendanceManagement/exportExcel.do?stationCode=" + $("#stationCode").val();
	}
	
	//条件查询
	function searchAttendanceManagement() {
		$("#attendanceManagementCriteriaQuery").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
	function getStationList(districtCode) {
		$.ajax({
			type: "POST",
			url: '<%=basePath %>station/getListByDistrict.do',
			data: {districtCode:districtCode},
			dataType:'json',
			async:false,
			cache: true,
			success: function(data){
				var html = "<option value=''></option>"
				  $.each(data.list,function(index,value){
                      html += "<option value='"+value.stationCode+"'>"+value.stationName+"</option>";
                  })
			//	console.log(html);
				console.log($("#stationCode").html());
				$("#stationCode").html(html);
				console.log($("#stationCode").html());
			}
		});
	
	}
	
</script>
<script type="text/javascript">
$(function() {

	//下拉框
	$(".chzn-select").chosen();
	$(".chzn-select-deselect").chosen({
		allow_single_deselect : true
	});

	//日期框
	$('.date-picker').datepicker();

	//复选框
	$('table th input:checkbox').on(
			'click',
			function() {
				var that = this;
				$(this).closest('table').find(
						'tr > td:first-child input:checkbox').each(
						function() {
							this.checked = that.checked;
							$(this).closest('tr').toggleClass('selected');
						});

			});

});
</script>
<style>
.table th, .table td {
    padding:20px;
    line-height: 20px;
    text-align: left;
    vertical-align: top;
    border-top: 1px solid rgb(221, 221, 221);
}
.table-bordered thead:first-child tr th {
    border-width: 0px 0px 0px 1px;
    border-color: rgb(221, 221, 221);
    vertical-align:baseline;
}
</style>
</head>
<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<form id="attendanceManagementCriteriaQuery"
						  action="<%=basePath%>attendanceManagement/attendanceManagementList.do" method="post">
						<table>
							<input type="hidden" name="isSearchHide" value="${searchVO.isSearchHide}" />
							<input type="hidden" id="status"  value="${searchVO.status}" />
							<input type="hidden" id="isResubmit"  value="${isResubmit}" />
							<c:if test="${isSearchHide == '0'}">
							<tr>
								<td style="vertical-align:top;"><select name="districtCode" id="districtCode" 
									 onchange="getStationList(this.value)" class="chzn-select" data-placeholder="请选择所属区域" style="vertical-align:top;width: 220px;" title="所属区域">
									<option value=""></option>
										<biztab:biz type="district" code="all">
											<option value="${obj.organiseId}" ${obj.organiseId == searchVO.districtCode ? 'selected="selected"' : '' }>${obj.organiseName}</option>
										</biztab:biz>
								</select>
								</td>
								 <td style="vertical-align:top;">
								 <select name="stationCode" id="stationCode" 
								 	 data-placeholder="请选择所属油站" 
								 		style="vertical-align:top;width: 220px;" title="所属油站">
									<option value=""></option>
									<biztab:biz type="station" code="all" pcode="${searchVO.districtCode}">
										<option value="${obj.stationCode}" ${obj.stationCode == searchVO.stationCode ? 'selected="selected"' : '' }>${obj.stationName}</option>
									</biztab:biz>
								</select>
								</td>
								<td style="vertical-align: top;"><span class="input-icon">
										<input autocomplete="off" id="nav-search-input" type="text"
										class="span10 date-picker" name="yearMonth"
										value="${searchVO.yearMonth}" data-date-format="yyyy-mm"
										style="vertical-align: top; width: 150px;"
										placeholder="请选择年份月份" /> <i id="nav-search-icon"
										class="icon-search"></i>
								</span></td>
								<td style=""><a
									class="btn btn-mini btn-info" onclick="searchAttendanceManagement();" style="margin-top:-11px;">查询</a></td>
									<c:if test="${isMod == '1'}">
								<td style=";"><a
									class="btn btn-mini btn-info" id="saveOrUpdateAttendanceManagement" onclick="saveOrUpdateAttendanceManagement();" style="margin-top:-11px;">考勤维护</a></td>
									</c:if>
<!-- 								<td style=";"><a -->
<!-- 									class="btn btn-mini btn-info" onclick="exportExcel();" style="margin-top:-11px;">下载公示</a></td> -->
								<td align="right" class="position"><a>考勤维护截止日期：2017-05-08 18时</a></td>
							</tr>
							</c:if>
							<c:if test="${isSearchHide == '1'}">
								<input type="hidden" name="stationCode" value="${searchVO.stationCode}" />
							</c:if>
						</table>
						<table id="table_report" border="1px" style="width:3400px;height:350px;border:1px solid #ddd;">
							<thead>
								<tr style="background:linear-gradient(to bottom,#f8f8f8 0,#ececec 100%);">
									<!-- 
									<th class="center"style="width:70px;color:#707070" >油站名称</th>
									<th class="center"style="width:75px;color:#707070">油站编号</th>
									<th class="center"style="width:80px;color:#707070">地区类型</th>
									<th class="center"style="width:75px;color:#707070">油站星级</th>
									 -->
									<th class="center"style="width:35px;color:#707070">序号</th>
									<th class="center"style="width:65px;color:#707070">员工编号</th>
									<th class="center"style="width:65px;color:#707070">员工姓名</th>
		                            <th class="center" style="width:60px;color:#707070">职务</th>
									<th class="center"style="width:80px;color:#707070">入职日期</th>
									<th class="center"style="width:80px;color:#707070">离职日期</th>
									<th class="center"style="width:40px;color:#707070">工作日</th>
									<th class="center" style="width:60px;color:#707070">(是否)本月离职</th>
									<th class="center"style="width:100px;color:#707070">是否管站\带班</th>
									<th class="center" style="width:100px;color:#707070">是否实习期内</th>
									<th class="center" style="width:140px;color:#707070">本月实习期满后工作天数</th>
									<th class="center" style="width:65px;color:#707070">平时超时</th>
									<th class="center" style="width:65px;color:#707070">节日加班</th>
									<th class="center" style="width:80px;color:#707070">跨站支援(天)</th>
									<th class="center" style="width:80px;color:#707070">年夜饭在岗</th>
									<th class="center"style="width:120px;color:#707070">春节在岗</th>
<!-- 									<th class="center"style="width:120px;color:#707070">春节在岗（阶段二）</th> -->
									<th class="center" style="width:60px;color:#707070">夜班在岗</th>
									<th class="center" style="width:50px;color:#707070">事假</th>
									<th class="center" style="width:50px;color:#707070">旷工</th>
									<th class="center" style="width:50px;color:#707070">病假</th>
									<th class="center" style="width:50px;color:#707070">年假</th>
									<th class="center" style="width:50px;color:#707070">婚假</th>
									<th class="center" style="width:50px;color:#707070">产假</th>
									<th class="center" style="width:50px;color:#707070">丧假</th>
									<th class="center" style="width:50px;color:#707070">调休</th>
									<th class="center" style="width:50px;color:#707070">警告</th>
									<th class="center" style="width:50px;color:#707070">记过</th>
									<th class="center" style="width:75px;color:#707070">重大事故</th>
									<th class="center" style="width:100px;color:#707070">是否保留宿舍</th>
									<th class="center" style="width:100px;color:#707070">是否搭伙</th>
									<th class="center" style="width:90px;color:#707070">精彩卡-蓝色版</th>
									<th class="center" style="width:90px;color:#707070">精彩卡-绿色版</th>
									<th class="center" style="width:110px;color:#707070">兼职便利店员比例(%)</th>
									<th class="center" style="width:130px;color:#707070">月度绩效<font color="red">（百分制）</font></th>
									<th class="center" style="width:110px;color:#707070">经理奖金分配比例(%)</th>
									<th class="center" style="width:50px;color:#707070">备注</th>
									<th class="center" style="width:50px;color:#707070">考勤状态</th>
									<th class="center" style="width:70px;color:#707070">月份</th>
								</tr>
							</thead>
							<c:choose>
								<c:when test="${!empty pageList.records}">
									<c:forEach items="${pageList.records}" var="am" varStatus="vs">
										<tr class="center" >
											<!-- 
											<td>${am.stationName}</td>
											<td>${am.stationCode}</td>
											<td>${am.areaName}</td>
											<td>${am.stationLevelName}</td>
											 -->
											<td>${vs.count}</td>
											<td>${am.staffCode}</td>
											<td>${am.staffName}</td>
											<td>${am.dutyName}</td>
											<td>${am.staffInDate}</td>
											<td>${am.staffOutDate}</td>
											<td><fmt:formatNumber type='number' value='${am.workingDay}' pattern='0.0' maxFractionDigits='2' /></td>
											<td>${am.isDeparture}</td>
											<td>${am.isStamanageForeman}</td>
											<td>${am.isInternship}</td>
											<td><fmt:formatNumber type='number' value='${am.afterIntershipWorking}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.peacetimeTimeout}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.holidayOvertime}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.supportDays}' pattern='0.0' maxFractionDigits='2' /></td>
<%-- 											<td><fmt:formatNumber type='number' value='${am.familyReunionDinnerOn}' pattern='0.0' maxFractionDigits='2' /></td> --%>
											<td>${am.isFamilyReunionDinnerOn}</td>
											<td><fmt:formatNumber type='number' value='${am.onTheSpringFestivaOne}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.nightShiftDays}' pattern='0.0' maxFractionDigits='1' /></td>
											<td><fmt:formatNumber type='number' value='${am.casualLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.absenteeism}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.sickLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.annualLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.marriageLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.maternityLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.funeralLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.daysOff}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.verbalWarnings}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.writtenWarning}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.majorAccident}' pattern='0.0' maxFractionDigits='2' /></td>
											<td>${am.isAccomodate}</td>
											<td>${am.isBoarder}</td>
											<td><fmt:formatNumber type='number' value='${am.splendorCardBlue}' pattern='0' /></td>
											<td><fmt:formatNumber type='number' value='${am.splendorCardGreen}' pattern='0' /></td>
											<td><fmt:formatNumber type='number' value='${am.partTimeScale}' pattern='0.00' maxFractionDigits='2' />%</td>
											<td><fmt:formatNumber type='number' value='${am.monthPerformance}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${am.managerBonusScale}' pattern='0.00' maxFractionDigits='2' />%</td>
											<td>${am.remark}</td>
											<td>${am.status == 1 ? '已生效' : '未生效'}</td>
											<td>${am.yearMonth}</td>
										</tr>
									</c:forEach>
									<tr class="center" >
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td>合计：</td>
											<td><fmt:formatNumber type='number' value='${sumVO.workingDay}' pattern='0.0' maxFractionDigits='2' /></td>
											<td>${am.isDeparture}</td>
											<td>${am.isStamanageForeman}</td>
											<td>${am.isInternship}</td>
											<td><fmt:formatNumber type='number' value='${sumVO.afterIntershipWorking}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.peacetimeTimeout}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.holidayOvertime}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.supportDays}' pattern='0.0' maxFractionDigits='2' /></td>
											<td>——</td>
											<td><fmt:formatNumber type='number' value='${sumVO.onTheSpringFestiva}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.nightShiftDays}' pattern='0.0' maxFractionDigits='1' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.casualLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.absenteeism}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.sickLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.annualLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.marriageLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.maternityLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.funeralLeave}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.daysOff}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.verbalWarnings}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.writtenWarning}' pattern='0.0' maxFractionDigits='2' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.majorAccident}' pattern='0.0' maxFractionDigits='2' /></td>
											<td>——</td>
											<td>——</td>
											<td><fmt:formatNumber type='number' value='${sumVO.splendorCardBlue}' pattern='0' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.splendorCardGreen}' pattern='0' /></td>
											<td><fmt:formatNumber type='number' value='${sumVO.partTimeScale}' pattern='0.00' maxFractionDigits='2' />%</td>
											<td>——</td>
											<td><fmt:formatNumber type='number' value='${sumVO.managerBonusScale}' pattern='0.00' maxFractionDigits='2' />%</td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="100" style="text-align: center;">此页没有相关数据，请查看<font
											color="red">上一页</font>或<font color="red">添加相关数据</font></td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>

						<!-- 分页展示页面 -->
						<div align="right" style="margin-top:20px;position:fixed;margin-left:70%">
							<%@include file="../../common/page.jsp"%>
						</div>
					</form>
				</div>
				<!-- PAGE CONTENT ENDS HERE -->
			</div>
			<!--/row-->
		</div>
		<!--/#page-content-->
	</div>
	<!--/.fluid-container#main-container-->

	<!-- 返回顶部  -->
	<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse" style="position:fixed"> <i
	   class="icon-double-angle-up icon-only"></i>
	</a>
	<style>
		table tr:hover{background:#f9f9f9;}
		table tr:nth-child(odd){background:#F9F9F9;}
		.position{position: absolute;right: 15px;margin-top: 5px;}
	</style>
</html>