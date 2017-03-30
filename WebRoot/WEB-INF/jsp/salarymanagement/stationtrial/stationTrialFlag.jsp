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
		window.location.href = "<%=basePath%>stationTrial/exportStationTrial.do"; 
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
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class='center'>序号</th>
									<th class='center'>油站名称</th>
									<th class='center'>地区类型</th>
									<th class='center'>薪资是否已试算</th>
									<th class='center'>月份</th>
									<th class='center'>操作</th>
								</tr>
							</thead>
								<c:if test="${Flag.flag == 2}">
									<tr>
										<td colspan="100" style="text-align: center;">
											<font color="red">对不起，上月基础数据录取不全，无法试算薪资。请先完善基础数据！</font>
										</td>
									</tr>
								</c:if>
								<c:if test="${Flag.flag == 3}">
									<tr>
										<td colspan="100" style="text-align: center;">
											<font color="red">对不起，上月基础数据尚未录入，无法试算薪资。请先添加基础数据！</font>
										</td>
									</tr>
								</c:if>
								<c:if test="${Flag.flag == 4}">
									<tr>
										<td colspan="100" style="text-align: center;">
											<font color="red">对不起，Excel的模板不正确！请检查Excel中的工作簿模板！</font>
										</td>
									</tr>
								</c:if>
						</table>
					</form>
				</div>
				<!-- PAGE CONTENT ENDS HERE -->
			</div>
			<!--/row-->
		</div>
		<!--/#page-content-->
	</div>
</body>
</html>