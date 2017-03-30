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
	//新增
	function addstation() {
		top.jzts();
		var diag = new top.Dialog();
		diag.Drag = true;
		diag.Title = "新增油站员工记录";
		diag.URL = '/staff_toAdd.do';
		diag.Width = 700;
		diag.Height = 450;
		diag.CancelEvent = function() { //关闭事件
			if (diag.innerFrame.contentWindow.document
					.getElementById('zhongxin').style.display == 'none') {
				top.jzts();
				setTimeout("location.reload()", 100);
			}
			diag.close();
		};
		diag.show();
	}
	//查看
	function toView(id) {
		top.jzts();
		var diag = new top.Dialog();
		diag.Drag = true;
		diag.Title = "查看油站员工记录";
		diag.URL = '/staff_toView?id=' + id;
		diag.Width = 288;
		diag.Height = 150;
		diag.CancelEvent = function() { //关闭事件
			if (diag.innerFrame.contentWindow.document
					.getElementById('zhongxin').style.display == 'none') {
				top.jzts();
				setTimeout("location.reload()", 100);
			}
			diag.close();
		};
		diag.show();
	}
	//修改
	function toEdit(id) {
		top.jzts();
		var diag = new top.Dialog();
		diag.Drag = true;
		diag.Title = "修改油站员工记录";
		diag.URL = '/staff_toEidt.do?id=' + id;
		diag.Width = 660;
		diag.Height = 366;
		diag.CancelEvent = function() { //关闭事件
			if (diag.innerFrame.contentWindow.document
					.getElementById('zhongxin').style.display == 'none') {
				top.jzts();
				setTimeout("location.reload()", 100);
			}
			diag.close();
		};
		diag.show();
	}
	//删除
	function todelete(id) {
		var flag = false;
		if (confirm("确定要删除该油站员工记录吗？")) {
			flag = true;
		}
		if (flag) {
			top.jzts();
			var url = "/staff_delById.do?id=" + id + "&guid="
					+ new Date().getTime();
			$.get(url, function(data) {
				top.jzts();
				document.location.reload();
			});
		}
	}
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
					class="btn btn-mini btn-purple" onclick="addstation();">新增<i
						class="icon-pencil"></i></a></td>
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
				<th class='center'>员工编号</th>
				<th class='center'>员工姓名</th>
				<th class='center'>身份证号</th>
				<th class='center'>联系电话</th>
				<th class='center'>员工性别</th>
				<th class='center'>员工照片（预留）</th>
				<th class='center'>员工状态</th>
				<th class='center'>入职日期</th>
				<th class='center'>离职日期</th>
				<th class="center">员工所属职务编号</th>
				<th class="center">员工所属</th>
				<th class='center'>创建日期</th>
				<th class='center'>更新日期</th>
				<th class='center'>备注</th>
				<th class='center'>操作</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty page}">
				<c:forEach items="${page.records}" var="staff" varStatus="vs">
					<tr>
						<td class="center">${staff.id}</td>
						<td class="center">${staff.staffCode}</td>
						<td class="center">${staff.staffName}</td>
						<td class="center">${staff.staffIdcard}</td>
						<td class="center">${staff.staffPhone}</td>
						<td class="center">${staff.staffSex}</td>
						<td class="center">${staff.staffName}</td>
						<td class="center">${staff.staffPhoto}</td>
						<td class="center">${staff.staffStatus}</td>
						<td class='center'><fmt:formatDate
								value="${staff.staffInDate}" type="both" /></td>
						<td class='center'><fmt:formatDate
								value="${staff.staffOutDate}" type="both" /></td>
						<td class="center">${staff.dutyCode}</td>
						<td class="center">${staff.stationCode}</td>
						<td class='center'><fmt:formatDate
								value="${staff.sysCreateTime}" type="both" /></td>
						<td class='center'><fmt:formatDate
								value="${staff.sysUpdateTime}" type="both" /></td>
						<td class="center">${staff.remark}</td>
						<td class='center'><a class='btn btn-mini btn-warning'
							onclick="toView('${staff.id}');">查看</a> <a
							class='btn btn-mini btn-warning' onclick="toEdit('${staff.id}');">修改</a>
							<a class='btn btn-mini btn-warning'
							onclick="todelete('${staff.id}');">删除</a></td>
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
	</table>
</body>
</html>