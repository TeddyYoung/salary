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
<title>薪资上传</title>
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
					<form action="<%=basePath%>salaryUpload/salaryUploadList.do"
						  name="salaryUploadForm" id="salaryUploadForm" method="post" enctype="multipart/form-data">
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class='center'>序号</th>
									<th class='center'>薪资表是否已上传</th>
									<th class='center'>月份</th>
									<th class='center'>操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td colspan="4" class="center">
										<font color="red">
											<c:if test="${Flag.flag == 1}">未选择薪资表，请选择一个薪资表上传！</c:if>
											<c:if test="${Flag.flag == 2}">请上传一个正确的薪资表！</c:if>
											<c:if test="${Flag.flag == 3}">请选择薪资表所属的月份！</c:if>
											<c:if test="${Flag.flag == 4}">请选择一个可以上传薪资表的月份！</c:if>
											<c:if test="${Flag.flag == 5}">没有提供下载薪资表的月份，请联系管理人员！</c:if>
											<c:if test="${Flag.flag == 6}">此月份还没有上传薪资表，无法提供下载！请先上传薪资表！</c:if>
											<c:if test="${Flag.flag == 7}">Excel文件中没有相应的工作簿，请核对Excel中工作簿的名称！</c:if>
											<c:if test="${Flag.flag == 8}">对不起，您不属于油站的任何分站，无法下载分站的薪资Excel文件！</c:if>
										</font>
										<a class="btn btn-mini btn-info" onclick="salaryImport();" 
										   style="margin-top:-11px;" href="<%=basePath%>salaryUpload/salaryUploadList.do">点击返回</a>
									</td>
								</tr>
							</tbody>
						</table>
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