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
<title>时薪设置</title>
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
	function addAreaHourly(){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="新增时薪设置记录";
		 diag.URL = '<%=basePath%>areaHourly/areaHourlyToAdd.do';
		 diag.Width = 900;
		 diag.Height = 300;
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
	function toEdit(dutyCode){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="修改时薪设置记录";
		 diag.URL = '<%=basePath%>areaHourly/areaHourlyToEdit.do?dutyCode='+dutyCode;
		 diag.Width = 900;
		 diag.Height = 300;
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
	function todelete(dutyCode,areaHourlyName){
		bootbox.confirm("确定要删除["+areaHourlyName+"]吗?", function(result) {
			if(result) {
				var url = "<%=basePath%>areaHourly/areaHourlyDelById.do?dutyCode=" + dutyCode+ "&guid=" + new Date().getTime();
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
	function searchAreaHourly() {
		$("#areaHourlyForm").submit();
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
					<form action="<%=basePath%>areaHourly/areaHourlyList.do"
						name="areaHourlyForm" id="areaHourlyForm" method="post">
						<table>
							<tr>
								<td style="vertical-align:top;"><select name="dutyCode" id="dutyCode" class="chzn-select" data-placeholder="请选择职务" style="vertical-align:top;width: 220px;" title="职务">
								<option value=""></option>
								<biztab:biz type="duty" code="all">
									<option value="${obj.dutyCode}" ${obj.dutyCode==ah.dutyCode ? 'selected="selected"' : '' }>${obj.dutyName}</option>
								</biztab:biz>
								</select></td>
								<td style="margin-top: -11px;"><a
									class="btn btn-mini btn-info" onclick="searchAreaHourly();">查询</a></td>
								<td style="margin-top: -11px;"><a
									class="btn btn-mini btn-info" onclick="addAreaHourly();">新增</a></td>
							</tr>
						</table>
						<!-- 检索  -->
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center" rowspan="2"><label><input type="checkbox"
											id="zcheckbox" /><span class="lbl"></span></label></th>
									<th class="center" rowspan="2">序号</th>
									<th class="center" rowspan="2">职务</th>
									<biztab:biz type="area" code="all">
										<td class="center" colspan="2">${obj.areaName }</td>
									</biztab:biz>
									<th class='center' rowspan="2">操作</th>
								</tr>
								<tr>
									<biztab:biz type="area" code="all">
										<th class="center" >正常时薪（元）</th>
										<th class="center" >加班时薪（元）</th>
									</biztab:biz>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty pageList.records}">
										<c:forEach items="${pageList.records}" var="areaHourly"
											varStatus="vs">
											<tr>
												<td class='center' style="width: 30px;"><label><input
														type='checkbox' name='ids' value="${areaHourly.dutyCode}" /><span
														class="lbl"></span></label></td>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<td class="center"><biztab:biz type="duty"
														code="${areaHourly.dutyCode}">${obj.dutyName }</biztab:biz></td>
												<biztab:biz type="area" code="all">
													<td class="center">
													<biztab:bizAreaHourly areaCode="${obj.areaCode }" dutyCode="${areaHourly.dutyCode}">
														<fmt:formatNumber value=" ${areaHourlyTag.normalHourly}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>  
													</biztab:bizAreaHourly>
													</td>
													<td class="center">
														<biztab:bizAreaHourly areaCode="${obj.areaCode }" dutyCode="${areaHourly.dutyCode}">
															<fmt:formatNumber value="${areaHourlyTag.otHourly}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>  
														</biztab:bizAreaHourly>		
													</td>
												</biztab:biz>
												<td class='center'> <a
													class='btn btn-mini btn-info'
													onclick="toEdit('${areaHourly.dutyCode}');">修改</a> <a
													class='btn btn-mini btn-danger'
													onclick="todelete('${areaHourly.dutyCode}','此时薪设置信息');">删除</a></td>
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