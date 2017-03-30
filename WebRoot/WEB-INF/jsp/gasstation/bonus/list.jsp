<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<div>
		<table>
			<tr height="7px;">
				<td colspan="100"></td>
			</tr>
			<tr>
				<td><a class="btn btn-mini btn-info" onclick="return false;">查询<i
						class="icon-arrow-right  icon-on-right"></i></a> <a
					class="btn btn-mini btn-purple" onclick="return false;">新增<i
						class="icon-pencil"></i></a> <a class='btn btn-mini btn-info'
					onclick="return false;">查询历史<i class='icon-trash'></i></a></td>
			</tr>
			<tr height="7px;">
				<td colspan="100"></td>
			</tr>
		</table>
	</div>
	<table id="table_report"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th class="center">主键ID</th>
				<th class='center'>所属员工编号</th>
				<th class='center'>所属年份</th>
				<th class='center'>所属月份</th>
				<th class='center'>公积金</th>
				<th class='center'>养老保险</th>
				<th class='center'>失业保险</th>
				<th class='center'>医疗保险</th>
				<th class='center'>创建时间</th>
				<th class='center'>更新时间</th>
				<th class="center">备注</th>
				<th class='center'>基本工资</th>
				<th class='center'>绩效系数</th>
				<th class='center'>管理奖金基数</th>
				<th class='center'>管理奖金</th>
				<th class='center'>岗位津贴基数</th>
				<th class='center'>岗位津贴</th>
				<th class='center'>兼站奖金</th>
				<th class='center'>通讯补贴</th>
				<th class='center'>高温补贴</th>
				<th class='center'>工作餐补贴</th>
				<th class='center'>住宿补贴</th>
				<th class='center'>交通补贴</th>
				<th class='center'>创建时间</th>
				<th class='center'>更新时间</th>
				<th class='center'>备注</th>
				<th class='center'>操作</th>
			</tr>
		</thead>
		<tr>
			<td class="center">主键ID</td>
			<td class='center'>所属员工编号</td>
			<td class='center'>所属年份</td>
			<td class='center'>所属月份</td>
			<td class='center'>公积金</td>
			<td class='center'>养老保险</td>
			<td class='center'>失业保险</td>
			<td class='center'>医疗保险</td>
			<td class='center'>创建时间</td>
			<td class='center'>更新时间</td>
			<td class="center">备注</td>
			<td class='center'>基本工资</td>
			<td class='center'>绩效系数</td>
			<td class='center'>管理奖金基数</td>
			<td class='center'>管理奖金</td>
			<td class='center'>岗位津贴基数</td>
			<td class='center'>岗位津贴</td>
			<td class='center'>兼站奖金</td>
			<td class='center'>通讯补贴</td>
			<td class='center'>高温补贴</td>
			<td class='center'>工作餐补贴</td>
			<td class='center'>住宿补贴</td>
			<td class='center'>交通补贴</td>
			<td class='center'>创建时间</td>
			<td class='center'>更新时间</td>
			<td class='center'>备注</td>
			<td class='center'><a class='btn btn-mini btn-warning'
				onclick="#">查看</a> <a class='btn btn-mini btn-warning' onclick="#">修改</a>
				<a class='btn btn-mini btn-warning' onclick="#">删除</a></td>
		</tr>
		<%-- <c:choose>
			<c:when test="${not empty list}">
				<c:forEach items="${list}" var="task" varStatus="vs">
				<tr id="tr${menu.id}">
				<td class="center">${vs.index+1}</td>
				<td class='center'>${task.assignee}</td>
				<td class='center'><fmt:formatDate value="${task.createTime}" type="both"/></td>
				<td>
				<a class='btn btn-mini btn-warning' onclick="execution('${task.id}')"  >查看</a>
				<a class='btn btn-mini btn-warning' onclick="execution('${task.id}')"  >执行</a>
				<a class='btn btn-mini btn-warning' onclick="execution('${task.id}')"  >驳回</a>
				</td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
				<td colspan="100">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose> --%>
	</table>
</body>
</html>