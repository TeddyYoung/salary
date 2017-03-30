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
<%@ include file="../../system/admin/top.jsp"%>
<meta charset="utf-8" />
<title>油站星级</title>
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
	//新增
	function addStationLevel(){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="新增油站星级记录";
		 diag.URL = '<%=basePath%>stationLevel/stationlevelToAdd.do';
		 diag.Width = 450;
		 diag.Height = 400;
		 diag.CancelEvent = function(){ //关闭事件
			if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
				top.jzts(); 
				setTimeout("location.reload()",100);
			}
			diag.close();
		 };
		 diag.show();
	}
	//查看
	function toView(id){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="查看油站星级记录";
		 diag.URL = '<%=basePath%>stationLevel/stationlevelToView.do?id='+id;
		 diag.Width = 450;
		 diag.Height = 400;
		 diag.CancelEvent = function(){ //关闭事件
			if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
				top.jzts(); 
				setTimeout("location.reload()",100);
			}
			diag.close();
		 };
		 diag.show();
	}
	//修改
	function toEdit(id){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="修改油站星级记录";
		 diag.URL = '<%=basePath%>stationLevel/stationlevelToEdit.do?id='+id;
		 diag.Width = 450;
		 diag.Height = 400;
		 diag.CancelEvent = function(){ //关闭事件
			if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
				top.jzts(); 
				setTimeout("location.reload()",100);
			}
			diag.close();
		 };
		 diag.show();
	}
	//删除
	function todelete(id,stationLevelName){
		bootbox.confirm("确定要删除["+stationLevelName+"]吗?", function(result) {
			if(result) {
				var url = "<%=basePath%>stationLevel/stationlevelDelById.do?id="
										+ id + "&guid=" + new Date().getTime();
								top.jzts();
								$.get(url, function(data) {
									if ("success" == data.result) {
										top.jzts();
										document.location.reload();
									} else if ("false" == data.result) {
										top.hangge();
										bootbox.dialog("删除失败!", [ {
											"label" : "关闭",
											"class" : "btn btn-mini btn-info",
											"callback" : function() {
												//Example.show("great success");
											}
										} ]);
									}
								});
							}
						});
	}
	//条件查询
	function searchStationLevel() {
		$("#stationLevelForm").submit();
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
					<form action="<%=basePath%>stationLevel/stationlevelList.do"
						name="stationLevelForm" id="stationLevelForm" method="post">
						<table>
							<tr>
								<td><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text"
										name="stationLevelName" value="${stationLevelName}"
										placeholder="这里输入星级名称" /> <i id="nav-search-icon"
										class="icon-search"></i>
								</span></td>
								<td style=""><a
									class="btn btn-mini btn-info" onclick="searchStationLevel();"style="margin-top:-11px;">查询</a></td>
								<td style=""><a
									class="btn btn-mini btn-info" onclick="addStationLevel();"style="margin-top:-11px;">新增</a></td>
							</tr>
						</table>
						<!-- 检索  -->
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center"><label><input type="checkbox"
											id="zcheckbox" /><span class="lbl"></span></label></th>
									<th class="center">序号</th>
									<th class='center'>星级编号</th>
									<th class='center'>星级名称</th>
									<th class='center'>经理奖金</th>
									<!-- 
									<th class='center'>创建时间</th>
									<th class='center'>更新时间</th>
									<th class='center'>备注</th>
									 -->
									<th class='center'>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="stationLevel"
											varStatus="vs">
											<tr>
												<td class='center' style="width: 30px;"><label><input
														type='checkbox' name='ids' value="${stationLevel.id}" /><span
														class="lbl"></span></label></td>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<td class="center">${stationLevel.stationLevelCode}</td>
												<td class="center">${stationLevel.stationLevelName}</td>
												<td class="center">
													<fmt:formatNumber value="${stationLevel.managerBonusAmt}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>
												</td>
												<!-- 
												<td class='center'><fmt:formatDate
														value="${stationLevel.sysCreateTime}" type="both" /></td>
												<td class='center'><fmt:formatDate
														value="${stationLevel.sysUpdateTime}" type="both" /></td>
												<td class="center">${stationLevel.remark}</td>
												 -->
												<td class='center'>
													<!-- 
													<a class='btn btn-mini btn-info'
													onclick="toView('${stationLevel.id}');">查看</a> 
													 -->
													<a
													class='btn btn-mini btn-info'
													onclick="toEdit('${stationLevel.id}');">修改</a> <a
													class='btn btn-mini btn-danger'
													onclick="todelete('${stationLevel.id}','${stationLevel.stationLevelName}');">删除</a></td>
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