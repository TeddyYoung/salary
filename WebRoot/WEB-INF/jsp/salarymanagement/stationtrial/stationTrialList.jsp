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
<title>薪资试算</title>
<!-- 引入 -->
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
	
	//导出薪资试算表
	function exportStationTrial() {
		bootbox.confirm("生成当月薪资表可能需要花几分钟时间，请您耐心等待。", function(result) {
			if(result) {
				top.jzts();
				window.location.href = "<%=basePath%>stationTrial/exportStationTrial.do";
			}
		});
	}
	
	//条件查询
	function searchStationTrial() {
		$("#stationTrialForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
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
</head>
<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- 检索  -->
					<form action="<%=basePath%>stationTrial/stationTrialList.do"
						name="stationTrialForm" id="stationTrialForm" method="post">
						<table>
							<tr>
								<td style="vertical-align:top;"><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text" class="span10 date-picker"
										name="yearMonth" value="${st.yearMonth}" data-date-format="yyyy-mm" style="vertical-align:top;width: 150px;"
										placeholder="这里选择年份月份" /> <i id="nav-search-icon"
										class="icon-search"></i>
								</span></td>
								<td style=""><a 
									class="btn btn-mini btn-info" onclick="searchStationTrial();" style="margin-top:-11px;">查询</a></td>
								<td style=""><a
									class="btn btn-mini btn-info" onclick="exportStationTrial();" style="margin-top:-11px;">生成当月薪资表</a></td>
							</tr>
						</table>
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class='center'>序号</th>
									<!-- 
									<th class='center'>油站名称</th>
									<th class='center'>地区类型</th>
									 -->
									<th class='center'>月份</th>
									<th class='center'>薪资是否已试算</th>
									<th class='center'>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!empty pageList.records}">
										<c:forEach items="${pageList.records}" var="stationTrial"
											varStatus="vs">
											<tr>
												<td class="center">${vs.count}</td>
												<!-- 
												<td class="center">
													${stationTrial.stationName}
												</td>
												<td class="center">
													${stationTrial.areaName}
												</td>
												 -->
												<td class="center">
													${stationTrial.yearMonth}
												</td>
												<td class="center">
													<c:if test="${stationTrial.isTrial == 0}">未试算</c:if>
													<c:if test="${stationTrial.isTrial == 1}">已试算</c:if>
												</td>
												<td class="center">
													<a class="btn btn-mini btn-info" 
															href="<%=basePath%>common/downloadTemplate.do?yearMonth=${stationTrial.yearMonth}">
														下载Zip文件
													</a>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<c:if test="${resultStr != null}">
												<td colspan="100" style="text-align: center;"><font
												color="red">${resultStr}</font></td>
											</c:if>
											<td colspan="100" style="text-align: center;">此页没有相关数据，请查看<font
												color="red">上一页</font>或<font color="red">添加相关数据</font></td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<!-- 分页展示页面 -->
						<div align="right">
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
	<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse"> <i
		class="icon-double-angle-up icon-only"></i>
	</a>
</body>
</html>