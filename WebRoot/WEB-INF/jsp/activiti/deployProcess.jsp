<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../base.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<%@ include file="../system/admin/top.jsp"%>
		<meta charset="utf-8" />
		<title>薪资试算</title>
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script>
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript" src="static/js/bootbox.min.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
			$(top.hangge());
		</script>
	</head>
	<body>
		<div class="container-fluid" id="main-container">
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="row-fluid">
						<form id="deployProcess" name="deployProcess" action="<%=basePath%>activiti/deploy.do" method="post" enctype="multipart/form-data" >
							<table id="table_report" style="width:60%;" class="table table-striped table-bordered table-hover">
								<tbody>
									<tr>
										<td class='left'>流程定义部署说明：</td>
										<td class='left'>请在下边分别选择流程定义bpmn文件和png文件</td>
									</tr>
									<tr>
										<td height=30 align=right>选择流程定义bpmn文件</td>
										<td class=category>
										<input type="file" name="resourcebpmn" />					
										</td>
									</tr>
									<tr>
										<td height=30 align=right>选择流程定义png文件</td>
										<td class=category>
										<input type="file" name="resourcepng" />					
										</td>
									</tr>
									<tr>
										<td align=center class=category>
											<input type="submit" class="btn btn-mini btn-info" value="确认部署"/> 
										</td>
										<td align=center class=category>
											<input type="submit" class="btn btn-mini btn-info" value="所有流程"/> 
										</td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>