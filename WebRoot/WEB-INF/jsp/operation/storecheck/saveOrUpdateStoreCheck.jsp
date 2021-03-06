<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>添加或修改便利店考核信息</title>
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
	
	//确认添加或修改信息
	function ok() {
		//验证每一个输入域的值, 必须是数字
		var count=${fn:length(stationTargetList)};
		var reg=new RegExp("^([0-9])+(\\.[0-9]+)?$");
		for(var i=0;i<count;i++){
			if ($("#storeMarkScore"+i).val().length != 0) {
				if(!reg.test($("#storeMarkScore"+i).val())){
					$("#storeMarkScore"+i).tips({
						side:1,
			            msg:'请输入正确的便利店考核业绩得分',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#storeMarkScore"+i).focus();
					return false;
				}
			}
			if ($("#storeManageScore"+i).val().length != 0) {
				if(!reg.test($("#storeManageScore"+i).val())){
					$("#storeManageScore"+i).tips({
						side:1,
			            msg:'请输入正确的便利店考核管理得分',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#storeManageScore"+i).focus();
					return false;
				}
			}
		} 
		$("#storeCheckForm").submit();
	}

	//取消
	function no() {
		window.location.href = "<%=basePath%>storeCheck/storeCheckList.do";
	}
	
	//下拉框改变时刷新信息
	function choose() {
		window.location.href = "<%=basePath%>storeCheck/saveOrUpdateStoreCheck.do?districtCode=" + $("#districtCode").val();
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
					<form action="<%=basePath%>storeCheck/storeCheckRealSaveOrUpdate.do"
						  name="storeCheckForm" id="storeCheckForm" method="post">
						<table>
							<tr>
								<td style="vertical-align:top;">
									<select name="districtCode" id="districtCode" class="chzn-select" 
											data-placeholder="请选择所属区域" style="vertical-align:top; 
											width: 220px;" title="所属区域" onchange="choose()">
										<option value="">全部</option>
											<biztab:biz type="district" code="all">
												<option value="${obj.organiseId}" ${obj.organiseId == Flag2.flag ? 'selected="selected"' : '' }>${obj.organiseName}</option>
											</biztab:biz>
									</select>
								</td>
							</tr>
						</table>
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">序号</th>
									<th class='center'>所属油站</th>
									<th class='center'>便利店业绩得分</th>
									<th class='center'>便利店管理得分</th>
									<th class='center'>月份</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!empty stationTargetList}">
										<c:forEach items="${stationTargetList}" var="stationTarget"
											varStatus="vs">
											<tr>
												<td class='center' style="width: 30px;padding-top:10px;">
													<input type="hidden" name="stationTargetList[${vs.index}].id" value="${stationTarget.id}" />
													<input type="hidden" name="stationTargetList[${vs.index}].stationCode" value="${stationTarget.stationCode}" />
													<input type="hidden" name="stationTargetList[${vs.index}].districtCode" value="${stationTarget.districtCode}" />
													<input type="hidden" name="stationTargetList[${vs.index}].stationName" value="${stationTarget.stationName}" />
													${vs.count}
												</td>
												<td class="center"style="padding-top:10px;">${stationTarget.stationName}</td>
												<td class="center">
													<input type="text" id="storeMarkScore${vs.index}" name="stationTargetList[${vs.index}].storeMarkScore" 
														   value="<fmt:formatNumber type="number" value="${stationTarget.storeMarkScore}" pattern="0.00" maxFractionDigits="2" />"
														   id="storeMarkScore${stationTarget.id}"
														   placeholder="请输入便利店考核业绩得分" title="便利店考核业绩得分" maxlength="32"style="margin-top:8px;" />
												</td>
												<td class="center">
													<input type="text" id="storeManageScore${vs.index}" name="stationTargetList[${vs.index}].storeManageScore" 
														   value="<fmt:formatNumber type="number" value="${stationTarget.storeManageScore}" pattern="0.00" maxFractionDigits="2" />"
														   id="storeManageScore${stationTarget.id}"
														   placeholder="请输入便利店考核管理得分" title="便利店考核管理得分" maxlength="32" style="margin-top:8px;"/>
												</td>
												<td class="center"style="padding-top:10px;">
													<input type="hidden" name="stationTargetList[${vs.index}].yearMonth" value="${Flag.flag}" />
													${Flag.flag}
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="100" style="text-align: center;">此页没有相关数据，<font color="red">请添加相关数据</font></td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<!-- 分页展示页面 -->
						<div align="right">
							<table>
								<tr>
									<td style=""><a 
										class="btn btn-mini btn-info" onclick="ok();" style="margin-top:-11px;">确认</a></td>
									<td style=""><a
										class="btn btn-mini btn-info" onclick="no();" style="margin-top:-11px;">取消</a>
								</tr>
							</table>
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