<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>薪资差异处理列表</title>
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
	
	function salaryDifferenceFillOut() {
		window.location.href="<%=basePath%>salaryDifference/salaryDifferenceFillOut.do";
	}
	
	//条件查询
	function searchSalaryDifference() {
		$("#salaryDifferenceForm").submit();
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
					<form action="<%=basePath%>salaryDifference/salaryDifferenceList.do"
						name="salaryDifferenceForm" id="salaryDifferenceForm" method="post">
						<table>
							<tr>
								<td><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text"
										name="staffName" value="${salaryDifference.staffName}" placeholder="请输入员工名称" />
										<i id="nav-search-icon" class="icon-search"></i>
								</span></td>
								<td style="vertical-align:top;"><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text" class="span10 date-picker"
										name="yearMonth" value="${salaryDifference.yearMonth}" data-date-format="yyyy-mm" style="vertical-align:top;width: 150px;"
										placeholder="请选择年份月份" /> <i id="nav-search-icon"
										class="icon-search"></i>
								</span></td>
								<td style=""><a 
									class="btn btn-mini btn-info" onclick="searchSalaryDifference();" style="margin-top:-11px;">查询</a></td>
								<%--
								<c:if test="${!empty Flag && Flag.flag == 'yzkj'}">
									<td style=""><a
										class="btn btn-mini btn-info" onclick="salaryDifferenceFillOut();" style="margin-top:-11px;">薪资差异申请</a></td>
								</c:if>
								 --%>
								 <td style=""><a
										class="btn btn-mini btn-info" onclick="salaryDifferenceFillOut();" style="margin-top:-11px;">薪资差异申请</a></td>
							</tr>
						</table>
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">序号</th>
									<th class='center'>员工姓名</th>
									<!-- <th class='center'>当月薪资</th> -->
									<th class='center'>薪资差异调整额</th>
									<th class='center'>审批状态</th>
									<th class='center'>年月份</th>
									<th class='center'>说明</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!empty pageList.records}">
										<c:forEach items="${pageList.records}" var="salaryDifference" varStatus="vs">
											<tr>
												<td class='center'>
													${vs.count}
												</td>
												<td class="center">
													${salaryDifference.staffName}
												</td>
												<!-- 
												<td class="center">
													<c:if test="${empty salaryDifference.salarySummary}">${salaryDifference.yearMonth}月的薪资尚未试算</c:if>
													<c:if test="${!empty salaryDifference.salarySummary}">${salaryDifference.salarySummary}</c:if>
												</td>
												 -->
												<td class="center">
													<c:if test="${empty salaryDifference.salaryDifferencePositive}">申请正在审批中，尚未确认具体金额。</c:if>
													<c:if test="${!empty salaryDifference.salaryDifferencePositive}">
														<fmt:formatNumber type='number' value='${salaryDifference.salaryDifferencePositive}' pattern='0.00' maxFractionDigits='2' />
													</c:if>
												</td>
												<td class="center">
													<c:if test="${salaryDifference.approvalStatus == 0}">未审批</c:if>
													<c:if test="${salaryDifference.approvalStatus == 1}">审批中</c:if>
													<c:if test="${salaryDifference.approvalStatus == 2}">已审批</c:if>
												</td>
												<td class="center">
													${salaryDifference.yearMonth}
												</td>
												<td class="center">
													${salaryDifference.remark}
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