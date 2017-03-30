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
					<form id="userCriteriaQuery" action="<%=basePath%>user/userList.do" method="post">
						<table>
							<tr>
								<td><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text"
										name="username" value="${storeEmployee.username}"
										placeholder="这里输入用户名称" /> <i id="nav-search-icon"
										class="icon-search"></i>
								</span></td>
								<td style=""><a
									class="btn btn-mini btn-info" onclick="criteriaQuery();"style="margin-top:-11px;">查询</a></td>
								<!-- 
								<c:if test="${flag==1}">
								<td style=""><a
									class="btn btn-mini btn-info" onclick="batchEditPWD();"style="margin-top:-11px;">批量设置密码初始化（无密码用户）</a></td>
								</c:if>
								 -->
							</tr>
						</table>
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">序列号</th>
									<th class='center'>用户编号</th>
									<th class='center'>用户名称</th>
									<th class='center'>用户角色</th>
									<!-- 
									<th class='center'>用户状态</th>
									<th class='center'>是否在线</th>
									 -->
									<th class='center'>用户邮箱</th>
									<th class='center'>用户电话</th>
									<th class='center'>所属部门</th>
									<!-- 
									<th class='center'>操作</th>
									 -->
								</tr>
							</thead>
							<c:choose>
								<c:when test="${!empty pageList.records}">
									<c:forEach items="${pageList.records}" var="storeEmployeeVO"
										varStatus="vs">
										<tr>
											<td class="center">${vs.count}</td>
											<td class='center'>${storeEmployeeVO.userid}</td>
											<td class='center'>${storeEmployeeVO.username}</td>
											<td class='center'>${storeEmployeeVO.storePartName}</td>
											<!-- 
											<td class='center'>
												<systab:dataDictionary codeType="userDel" valueType="${storeEmployeeVO.del}">${dataDictionary.valuename}</systab:dataDictionary>
											</td>
											<td class='center'>
												<systab:dataDictionary codeType="userOnline" valueType="${storeEmployeeVO.online}">${dataDictionary.valuename}</systab:dataDictionary>
											</td>
											 -->
											<td class='center'>${storeEmployeeVO.email}</td>
											<td class='center'>${storeEmployeeVO.phone}</td>
											<td class='center'>${storeEmployeeVO.organiseName}</td>
											<!-- 
											<td class='center'><a class='btn btn-mini btn-info' onclick="#">查看</a>
											<c:if test="${flag==1}">
												<a class='btn btn-mini btn-info' onclick="updatePWD('${storeEmployeeVO.id}','${storeEmployeeVO.username}','${storeEmployeeVO.userid}');">设置为初始化密码</a>
											</c:if>
											</td>
											 -->
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="100" style="text-align: center;">此页没有相关数据，请查看<font color="red">上一页</font>或<font color="red">添加相关数据</font></td>
									</tr>
								</c:otherwise>
							</c:choose>

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