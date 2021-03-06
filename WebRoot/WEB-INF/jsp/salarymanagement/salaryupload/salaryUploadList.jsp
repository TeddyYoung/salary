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
	
	//上传薪资Excel表格
	function salaryImport() {
		if($("#nav-search-input2").val()==""){
			$("#nav-search-input2").tips({
				side:3,
	            msg:'薪资表所属月份不可为空！',
	            bg:'#AE81FF',
	            time:2
	        });
			return false;
		}
		$("#salaryUploadForm").attr("action", "<%=basePath%>salaryUpload/salaryImport.do");
		$("#salaryUploadForm").submit();
	}
	
	//下载薪资表
	function salaryDownLoad(yearM) {
		window.location.href="<%=basePath%>salaryUpload/salaryExport.do?yearM=" + yearM;
	}
	
	//条件查询
	function searchStationTrial() {
		$("#salaryUploadForm").submit();
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
					<form action="<%=basePath%>salaryUpload/salaryUploadList.do"
						  name="salaryUploadForm" id="salaryUploadForm" method="post" enctype="multipart/form-data">
						<input type="hidden" name="type" value="4" />  
						<table>
							<tr>
								<td style="vertical-align:top;"><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text" class="span10 date-picker"
										name="yearMonth" value="${st.yearMonth}" data-date-format="yyyy-mm" style="vertical-align:top;width: 150px;"
										placeholder="请选择年份月份" /> <i id="nav-search-icon"
										class="icon-search"></i>
								</span></td>
								<td style=""><a 
									class="btn btn-mini btn-info" onclick="searchStationTrial();" style="margin-top:-11px;">查询</a></td>
								<td>
									<input type="file" name="uploadFile" />
									<span class="input-icon">
										<input autocomplete="off" id="nav-search-input2" type="text" class="span10 date-picker"
											   name="ym" data-date-format="yyyy-mm" style="vertical-align:top;width: 150px;"
										       placeholder="薪资表所属月份" /> 
										<i id="nav-search-icon" class="icon-search"></i>
									</span>
									<a class="btn btn-mini btn-info" onclick="salaryImport();" style="margin-top:-11px;">上传薪资表</a>
								</td>
							</tr>
						</table>
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
								<c:choose>
									<c:when test="${!empty pageList.records}">
										<c:forEach items="${pageList.records}" var="salaryUpload" varStatus="vs">
											<tr>
												<td class="center">${vs.count}</td>
												<td class="center">
													<c:if test="${salaryUpload.isUpload == 0}">未上传</c:if>
													<c:if test="${salaryUpload.isUpload == 1}">已上传</c:if>
												</td>
												<td class="center">
													${salaryUpload.yearMonth}
												</td>
												<td class="center">
													<a class='btn btn-mini btn-info' onclick="salaryDownLoad('${salaryUpload.yearMonth}')">下载</a>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="100" style="text-align: center;">
												<font color="red">
													当月薪资Excel表格还未上传，请先去上传薪资Excel表格。
												</font>
											</td>
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