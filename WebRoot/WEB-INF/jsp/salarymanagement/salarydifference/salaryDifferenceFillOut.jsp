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
<title>薪资差异填写</title>
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
	
	function ok() {
		var checkedcount = $("input[type='checkbox']:checked").length;
		if(checkedcount < 1) {
			bootbox.dialog("您还没有选择员工， 请至少选择一个员工进行申请！", 
								[
								  {
									"label" : "好的",
									"class" : "btn btn-mini btn-info",
									"callback": function() 
										{
											//Example.show("great success");
										}
								  }
								]
						);
			return;
		}
		$("#salaryDifferenceForm").submit();
	}
	//取消申请
	function no() {
		window.location.href = "<%=basePath%>salaryDifference/salaryDifferenceList.do";
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
					<form action="<%=basePath%>salaryDifference/salaryDifferenceSaveOrUpdate.do"
						name="salaryDifferenceForm" id="salaryDifferenceForm" method="post">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">
										<label><input type="checkbox" id="zcheckbox"/>
											   <span class="lbl"></span>
										</label>
									</th>
									<th class="center">序号</th>
									<th class='center'>所属油站</th>
									<th class="center">员工编号</th>
									<th class='center'>员工姓名</th>
									<th class='center'>年月份</th>
									<th class='center'>薪资差异申请说明</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${empty Apply}">
									<c:choose>
										<c:when test="${!empty salaryDifferenceList}">
											<c:forEach items="${salaryDifferenceList}" var="sd"
												varStatus="vs">
												<tr>
													<td class='center' style="width: 30px;"><label><input
															type='checkbox' name='ids' value="${sd.staffCode}" /> <span
															class="lbl"></span> </label></td>
													<td class='center'><input type="hidden"
														name="salaryDifferenceList[${vs.index}].id"
														value="${sd.id}" /> ${vs.count}</td>
													<td class="center"><input type="hidden"
														name="salaryDifferenceList[${vs.index}].stationName"
														value="${sd.stationName}" /> ${sd.stationName}</td>
													<td class="center"><input type="hidden"
														name="salaryDifferenceList[${vs.index}].staffCode"
														value="${sd.staffCode}" /> ${sd.staffCode}</td>
													<td class="center"><input type="hidden"
														name="salaryDifferenceList[${vs.index}].staffName"
														value="${sd.staffName}" /> ${sd.staffName}</td>
													<td class="center"><input type="hidden"
														name="salaryDifferenceList[${vs.index}].yearMonth"
														value="${Flag.flag}" /> ${Flag.flag}</td>
													<td class="center">
														<textarea 
															style="width: 500px;height:60px; margin-top: 5px;" 
															name="salaryDifferenceList[${vs.index}].remark"
															placeholder="请输入调整说明" >${sd.remark}</textarea></td>
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
								</c:if>
								<c:if test="${!empty Apply && Apply.flag == 'wftjsq'}">
									<tr>
										<td colspan="100" style="text-align: center;">
											<font color="red">对不起， 当前还有正在审批中的流程！不可发起新的流程申请！</font>
											<a class="btn btn-mini btn-info" style="margin-top:-11px;" 
											   href="<%=basePath%>salaryDifference/salaryDifferenceFillOut.do">点击返回</a>
										</td>
									</tr>
								</c:if>
							</tbody>
						</table>
						<!-- 分页展示页面 -->
						<c:if test="${empty Apply}">
							<div align="right">
								<table>
									<tr>
										<td style=""><a 
											class="btn btn-mini btn-info" onclick="ok();" style="margin-top:-11px;">提交申请</a></td>
										<td style=""><a
											class="btn btn-mini btn-info" onclick="no();" style="margin-top:-11px;">取消申请</a></td>
									</tr>
								</table>
							</div>
						</c:if>
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