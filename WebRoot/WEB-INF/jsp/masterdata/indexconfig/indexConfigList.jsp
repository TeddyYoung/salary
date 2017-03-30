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
<title></title>
<script type="text/javascript">
	window.jQuery
			|| document
					.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");
</script>
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

	//全选全不选
	function choose() {
		var choose = $("[name=allChecked]").attr("checked");
		if (choose) {
			$("[name=checked]").attr("checked", true);
		} else {
			$("[name=checked]").attr("checked", false);
		}

	}

	//条件过滤查询
	function criteriaQuery() {
		var formId = $("form").attr("id");
		$("#" + formId).submit();
	}
</script>
</head>

<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<form id="indexConfigCriteriaQuery"
						action="<%=basePath%>indexConfig/indexConfigList.do" method="post">
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">MMP得分</th>
									<c:forEach items="${mmpList}" var="mmp">
										<th class="center">${mmp.indexName}</th>
									</c:forEach>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="center">标值</td>
									<c:forEach items="${mmpList}" var="mmp">
										<td class="center">${mmp.indexStandard}</td>
									</c:forEach>
								</tr>
								<tr>
									<td class="center">MMP系数</td>
									<c:forEach items="${mmpList}" var="mmp">
										<td class="center"><fmt:formatNumber type="number"
												value="${mmp.indexValue}" pattern="0.00"
												maxFractionDigits="2" /></td>
									</c:forEach>
								</tr>
							</tbody>
						</table>
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">LOSS损耗值</th>
									<c:forEach items="${spoilageList}" var="spoilage">
										<th class="center">${spoilage.indexName}</th>
									</c:forEach>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="center">损耗系数</td>
									<c:forEach items="${spoilageList}" var="spoilage">
										<td class="center"><fmt:formatNumber type="number"
												value="${spoilage.indexValue}" pattern="0.00"
												maxFractionDigits="2" /></td>
									</c:forEach>
								</tr>
							</tbody>
						</table>
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">NPS得分</th>
									<c:forEach items="${npsList}" var="nps">
										<th class="center">${nps.indexName}</th>
									</c:forEach>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="center">标值</td>
									<c:forEach items="${npsList}" var="nps">
										<td class="center">${nps.indexStandard}</td>
									</c:forEach>
								</tr>
								<tr>
									<td class="center">MMP系数</td>
									<c:forEach items="${npsList}" var="nps">
										<td class="center"><fmt:formatNumber type="number"
												value="${nps.indexValue}" pattern="0.00"
												maxFractionDigits="2" /></td>
									</c:forEach>
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
</body>
</html>