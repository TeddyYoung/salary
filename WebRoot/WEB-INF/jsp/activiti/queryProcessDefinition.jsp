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
			function deleteDeployment(id){
				bootbox.confirm("您确认删除该流程吗?", function(result) {
					if(result) {
						window.location="<%=basePath%>activiti/delDeployment.do?id="+id;
					}
				});	
		    }
		</script>
	</head>
	<body>
		<div class="container-fluid" id="main-container">
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="row-fluid">
					<form id="queryProcessDefinition" name="queryProcessDefinition" method="post">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<TBODY>
								<tr>
									<td colspan="100"><a class="btn btn-mini btn-delete" href="<%=basePath%>activiti/todeploy.do">返回</a></td>
								</tr>
								<tr>
									<td>流程部署id</td>
									<td>流程定义id</td>
									<td>流程定义名称</td>
									<td>流程定义key</td>
<!-- 									<td>流程定义版本</td> -->
									<td>配置文件</td>
									<td>流程图</td>
									<td class="center">操作</td>
								</tr>
								<c:forEach items="${list }" var="processDefinition">
									<tr>
										<td class="left">${processDefinition.deploymentId}</td>
										<td class="left">${processDefinition.id}</td>
										<td class="left">${processDefinition.name}</td>
										<td class="left">${processDefinition.key}</td>
<%-- 										<td class=category>${processDefinition.version}</td> --%>
										<td class="center"><a href="<%=basePath%>activiti/checkBpmn.do?deploymentId=${processDefinition.deploymentId}&bpmnFileNam=${processDefinition.resourceName}" target="_blank">查看</a></td>
										<td class="center"><a href="<%=basePath%>activiti/checkFlowDiagram.do?deploymentId=${processDefinition.deploymentId}&imageName=${processDefinition.diagramResourceName}" target="_blank">查看</a></td>
										<td class="center"><a class="btn btn-mini btn-info" onclick="deleteDeployment('${processDefinition.deploymentId}')" >删除流程</a></td>
									</tr>
								</c:forEach>
							</TBODY>
						</TABLE>
					</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>