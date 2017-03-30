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
<title>油站基础数据</title>
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
	
	//添加便利店考核信息
	function saveOrUpdateOilBaseData() {
		window.location.href = "<%=basePath%>oilBaseData/saveOrUpdateOilBaseData.do";
	}
	
	//条件查询
	function searchOilBaseData() {
		$("#oilBaseDataForm").submit();
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
					<form action="<%=basePath%>oilBaseData/oilBaseDataList.do"
						name="oilBaseDataForm" id="oilBaseDataForm" method="post">
						<table>
							<tr>
								<td style="vertical-align:top;"><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text" class="span10 date-picker"
										name="yearMonth" value="${st.yearMonth}" data-date-format="yyyy-mm" style="vertical-align:top;width: 150px;"
										placeholder="这里选择年份月份" /> <i id="nav-search-icon"
										class="icon-search"></i>
								</span></td>
								<td style=""><a 
									class="btn btn-mini btn-info" onclick="searchOilBaseData();" style="margin-top:-11px;">查询</a></td>
								<td style=""><a
									class="btn btn-mini btn-info" onclick="saveOrUpdateOilBaseData();" style="margin-top:-11px;">添加或修改油站基础数据</a></td>
							</tr>
						</table>
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th colspan="4" class='center'>
										基础数据
									</th>
									<th colspan="2" class='center'>
										宿舍相关数据
									</th>
									<th colspan="3" class='center'>
										便利店相关数据
									</th>
									<th class='center'>时间轴</th>
								</tr>
								<tr>
									<th class='center'>油站名称</th>
									<th class='center'>编制数</th>
									<th class='center'>地区类型</th>
									<th class='center'>本月星站</th>
									<th class='center'>是否保留宿舍</th>
									<th class='center'>宿舍补贴</th>
									<th class='center'>便利店业绩得分</th>
									<th class='center'>便利店管理得分</th>
									<th class='center'>月度便利店津贴</th>
									<th class='center'>月份</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!empty pageList.records}">
										<c:forEach items="${pageList.records}" var="stationTarget"
											varStatus="vs">
											<tr>
												<td class="center">${stationTarget.stationName}</td>
												<td class="center">
													${stationTarget.stationStaffNum}
												</td>
												<td class="center">
													${stationTarget.areaName}
												</td>
												<td class="center">${stationTarget.stationLevelName}</td>
												<td class="center">
													<c:if test="${stationTarget.isKeepDormitory == 0 }">是</c:if>
													<c:if test="${stationTarget.isKeepDormitory == 1 }">否</c:if>
												</td>
												<td class="center">
													待计算
												</td>
												<td class="center">
													<fmt:formatNumber type="number" value="${stationTarget.storeMarkScore}" pattern="0.00" maxFractionDigits="2" />
												</td>
												<td class="center">
													<fmt:formatNumber type="number" value="${stationTarget.storeManageScore}" pattern="0.00" maxFractionDigits="2" />
												</td>
												<td class="center">
													待计算
												</td>
												<td class="center">
													${stationTarget.yearMonth}
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
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