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
<title>住宿补贴</title>
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
	
	//条件查询
	function searchAccommodationSubsidy() {
		$("#accommodationSubsidyForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
	//导入Excel
	function importAccommodationSubsidy() {
		bootbox.confirm("当前上传的Excel表格会自动将数据录入至上个月的数据中，请确认您上传的Excel表格是上个月的数据！", function(result) {
			if(result) {
				$("#accommodationSubsidyForm").attr("action", "<%=basePath%>accommodationSubsidy/importAccommodationSubsidy.do");
				$("#accommodationSubsidyForm").submit();
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
</head>
<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- 检索  -->
					<form action="<%=basePath%>accommodationSubsidy/list.do"
						  name="accommodationSubsidyForm" id="accommodationSubsidyForm" method="post" enctype="multipart/form-data">
						<input type="hidden" name="type" value="10"/>  
						<table>
							<tr>
								<td style="vertical-align:top;"><select name="districtCode" id="districtCode" class="chzn-select" data-placeholder="请选择所属区域" style="vertical-align:top;width: 220px;" title="所属区域">
									<option value="">全部</option>
										<biztab:biz type="district" code="all">
											<option value="${obj.organiseId}" ${obj.organiseId == st.districtCode ? 'selected="selected"' : '' }>${obj.organiseName}</option>
										</biztab:biz>
								</select>
								</td>
								<td style="vertical-align:top;"><span class="input-icon"> <input readonly="readonly"
									autocomplete="off" id="nav-search-input" type="text" class="span10 date-picker"
									name="yearMonth" value="${st.yearMonth}" data-date-format="yyyy-mm" style="vertical-align:top;width: 150px;"
									placeholder="请选择年份月份" /> <i id="nav-search-icon"
									class="icon-search"></i>
								</span></td>
								<td style=""><a 
									class="btn btn-mini btn-info" onclick="searchAccommodationSubsidy();" style="margin-top:-11px;">查询</a></td>
								<td>
									<input type="file" name="uploadFile" />
									<a class="btn btn-mini btn-info" onclick="importAccommodationSubsidy();" style="margin-top:-11px;">导入Excel数据</a>
								</td>
								<td>
									<a class="btn btn-mini btn-info" href="<%=basePath%>common/downloadTemplate.do?fileType=17" style="margin-top:-11px;">模板下载</a>
								</td>
							</tr>
						</table>
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">序号</th>
									<th class="center">所属区域</th>
									<th class='center'>所属油站</th>
									<th class='center'>住宿补贴</th>
									<th class='center'>月份</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!empty pageList.records}">
										<c:forEach items="${pageList.records}" var="stationTarget"
											varStatus="vs">
											<tr>
												<td class='center' style="width: 30px;">${vs.count}</td>
												<td class="center">${stationTarget.districtName}</td>
												<td class="center">${stationTarget.stationName}</td>
												<td class="center">${stationTarget.accommodationSubsidy}</td>
												<td class="center">${stationTarget.yearMonth}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:if test="${!empty Flag.flag}">
											<c:if test="${Flag.flag == '1'}">
												<tr>
													<td colspan="100" style="text-align: center;"><font color="red">请选择一个Excel表格进行上传！</font></td>
												</tr>
											</c:if>
											<c:if test="${Flag.flag == '2'}">
												<tr>
													<td colspan="100" style="text-align: center;"><font color="red">请上传一个正确的Excel表格！</font></td>
												</tr>
											</c:if>
											<c:if test="${Flag.flag == '3'}">
												<tr>
													<td colspan="100" style="text-align: center;"><font color="red">您上传的不是搭伙补贴Excel文件，请确认后再上传一份正确的搭伙补贴Excel文件！</font></td>
												</tr>
											</c:if>
											<c:if test="${Flag.flag == '4'}">
												<tr>
													<td colspan="100" style="text-align: center;"><font color="red">营运部门还没有维护上月数据，请通知营运部门先行维护上月数据！</font></td>
												</tr>
											</c:if>
										</c:if>
										<c:if test="${Flag.flag != '1' && Flag.flag != '2' && Flag.flag != '3' && Flag.flag != '4'}">
											<tr>
												<td colspan="100" style="text-align: center;">此页没有相关数据，请查看<font
													color="red">上一页</font>或<font color="red">添加相关数据</font></td>
											</tr>
										</c:if>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<!-- 分页展示页面 -->
						<c:if test="${Flag.flag != '1' && Flag.flag != '2' && Flag.flag != '3' && Flag.flag != '4'}">
							<div align="right">
								<%@include file="../../common/page.jsp"%>
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