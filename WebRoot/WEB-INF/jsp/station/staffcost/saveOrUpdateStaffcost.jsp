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
<title>添加或修改员工成本信息</title>
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
		var count=${fn:length(staffCostVOList)};
		var reg=new RegExp("^([0-9])+(\.[0-9]+)?$"); //数字就可以
			for(var i=0;i<count;i++){
				var staffCostAccFund = $("#staffCostAccFund"+i).val();
				if($("#staffCostAccFund"+i).val().length != 0){
					if(!reg.test($("#staffCostAccFund"+i).val())){
					$("#staffCostAccFund"+i).tips({
						side:1,
			            msg:'公积金格式不正确',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#staffCostAccFund"+i).focus();
					$("#staffCostAccFund"+i).val(1);
					return false;
					}
				}
			if($("#staffCostEndowment"+i).val().length != 0){
				if(!reg.test($("#staffCostEndowment"+i).val())){
					$("#staffCostEndowment"+i).tips({
						side:1,
			            msg:'请输入养老保险',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#staffCostEndowment"+i).focus();
					$("#staffCostEndowment"+i).val(1);
					return false;
				}}
			if($("#staffCostUnemployment"+i).val().length != 0){
				if(!reg.test($("#staffCostUnemployment"+i).val())){
					$("#staffCostUnemployment"+i).tips({
						side:1,
			            msg:'请输入失业保险',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#staffCostUnemployment"+i).focus();
					$("#staffCostUnemployment"+i).val(1);
					return false;
				}}
			if($("#staffCostMedical"+i).val().length != 0){
				if(!reg.test($("#staffCostMedical"+i).val())){
					$("#staffCostMedical"+i).tips({
						side:1,
			            msg:'请输入医疗保险',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#staffCostMedical"+i).focus();
					$("#staffCostMedical"+i).val(1);
					return false;
				}}
			} 
		$("#staffCostForm").submit();
	}

	//取消
	function no() {
		window.location.href = "<%=basePath%>staffCost/staffCostList.do";
	}
	function checkDigits(obj){
		var val = obj.value;
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
<style>
.input_100 {
	width:100px;
}
</style>
</head>
<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- 检索  -->
					<form action="<%=basePath%>staffCost/staffCostRealSaveOrUpdate.do"
						name="staffCostForm" id="staffCostForm" method="post">
						<table id="table_report"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">序号</th>
									<th class='center'>所属油站</th>
									<th class='center'>员工姓名</th>
									<th class='center'>员工职务</th>
									<th class='center'>公积金</th>
									<th class='center'>养老保险</th>
									<th class='center'>失业保险</th>
									<th class='center'>医疗保险</th>
									<th class='center'>月份</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${!empty staffCostVOList}">
										<c:forEach items="${staffCostVOList}" var="staffCostVO"
											varStatus="vs">
											<tr>
												<td class='center' style="width: 30px;">
													<input type="hidden" name="staffCostList[${vs.index}].id" value="${staffCostVO.staffCost.id}" />
													<input type="hidden" name="staffCostList[${vs.index}].staffCode" value="${staffCostVO.staffCode}" />
													<input type="hidden" name="staffCostList[${vs.index}].stationCode" value="${staffCostVO.stationCode}" />
													${vs.count}
												</td>
												<td class="center">
													<biztab:biz type="station" code="${staffCostVO.stationCode}">${obj.stationName }</biztab:biz>
													</td>
												<td class="center">${staffCostVO.staffName}</td>
												<td class="center"><biztab:biz type="duty"
														code="${staffCostVO.staffCost.dutyCode }">${obj.dutyName }</biztab:biz></td>
												<td class="center">
													<input type="text" name="staffCostList[${vs.index}].staffCostAccFund" 
														   value="<fmt:formatNumber type="number" pattern='0.00' value="${staffCostVO.staffCost.staffCostAccFund.unscaledValue() == 0 ? null : staffCostVO.staffCost.staffCostAccFund}"  maxFractionDigits="2" />"
														   id="staffCostAccFund${vs.index}" onblur="checkDigits(this)"
														   placeholder="请输入公积金" title="员工公积金" maxlength="7" class="input_100"/>
												</td>
												<td class="center">
													<input type="text" name="staffCostList[${vs.index}].staffCostEndowment" 
														   value="<fmt:formatNumber type="number" pattern='0.00' value="${staffCostVO.staffCost.staffCostEndowment.unscaledValue() == 0 ? null : staffCostVO.staffCost.staffCostEndowment}"  maxFractionDigits="2" />"
														   id="staffCostEndowment${vs.index}"
														   placeholder="请输入养老保险" title="员工养老保险" maxlength="7"  class="input_100" />
												</td>
												<td class="center">
													<input type="text" name="staffCostList[${vs.index}].staffCostUnemployment" 
														   value="<fmt:formatNumber type="number" pattern='0.00' value="${staffCostVO.staffCost.staffCostUnemployment.unscaledValue() == 0 ? null : staffCostVO.staffCost.staffCostUnemployment}"  maxFractionDigits="2" />"
														   id="staffCostUnemployment${vs.index}"
														   placeholder="请输入失业保险" title="员工失业保险" maxlength="7" class="input_100" />
												</td>
												<td class="center">
													<input type="text" name="staffCostList[${vs.index}].staffCostMedical" 
														   value="<fmt:formatNumber type="number" pattern='0.00' value="${staffCostVO.staffCost.staffCostMedical.unscaledValue() == 0 ? null : staffCostVO.staffCost.staffCostMedical}"  maxFractionDigits="2" />"
														   id="staffCostMedical${vs.index}"
														   placeholder="请输入医疗保险" title="员工医疗保险" maxlength="7"  class="input_100"/>
												</td>
												<td class="center">
													<input type="hidden" name="staffCostList[${vs.index}].staffCostYearMonth" value="${staffCostVO.staffCost.staffCostYearMonth}" />
													${staffCostVO.staffCost.staffCostYearMonth}
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="100" style="text-align: center;">此页没有相关数据</td>
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