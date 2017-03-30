<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		
		<script type="text/javascript">
			$(top.hangge());
		</script>
	</head>
<body>

	<div class="page_and_btn">
		<div>
			<form name="importExcel" action="/importExcel.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name="type" value="0" />
				<table>
					<tr>
						<td>
							<a class="btn btn-mini btn-info" href="#" >导出模板</a>&nbsp;
							<input type="file" name="uploadFile" />
							<input class="btn btn-mini btn-info" type="submit" value="表格预览" />&nbsp;
							<a class="btn btn-mini btn-info" href="#" >确认提交</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<table id="importExcel" class="table table-striped table-bordered table-hover">
		<tr>
			<th class='center'>序列号</th>
			<th class='center'>用户ID</th>
			<th class='center'>用户姓名</th>
			<th class='center'>用户密码</th>
			<th class='center'>状态</th>
			<th class='center'>是否在线</th>
			<th class='center'>电子邮箱</th>
			<th class='center'>联系电话</th>
			<th class='center'>创建时间</th>
			<th class='center'>创建人</th>
			<th class='center'>修改时间</th>
		</tr>
		<c:choose>
			<c:when test="${not empty list}">
				<c:forEach items="${list}" var="list" varStatus="vs">
					<tr>
						<td class="center">${vs.index + 1}</td>
						<td class="center">${list.userid}</td>
						<td class="center">${list.username}</td>
						<td class="center">${list.userpwd}</td>
						<td class="center">${list.del}</td>
						<td class="center">${list.online}</td>
						<td class="center">${list.email}</td>
						<td class="center">${list.phone}</td>
						<td class="center"><fmt:formatDate value="${list.createdate}" type="both" pattern="yyyy-MM-dd"/></td>
						<td class="center">${list.operator}</td>
						<td class="center"><fmt:formatDate value="${list.changedate}" type="both" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:if test="${empty flag}">
					<tr>
						<td colspan="100" class="center">没有相关数据</td>
					</tr>
				</c:if>
				<c:if test="${flag.flag == 1}">
					<tr>
						<td colspan="100" class="center">
							<font color="red">您还没有选择Excel表格，请选择一个Excel表格上传！</font>
						</td>
					</tr>
				</c:if>
				<c:if test="${flag.flag == 2}">
					<tr>
						<td colspan="100" class="center">
							<font color="red">请上传正确的Excel表格！</font>
						</td>
					</tr>
				</c:if>
			</c:otherwise>
		</c:choose>
	</table>
	
</body>
</html>