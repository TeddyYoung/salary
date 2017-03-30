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

<meta charset="utf-8" />
<title>油站系数</title>
<meta name="description" content="overview & stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="static/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link rel="stylesheet" href="static/css/font-awesome.min.css" />
<!-- 下拉框 -->
<link rel="stylesheet" href="static/css/chosen.css" />

<link rel="stylesheet" href="static/css/ace.min.css" />
<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
<link rel="stylesheet" href="static/css/ace-skins.min.css" />

<link rel="stylesheet" href="static/css/datepicker.css" />
<!-- 日期框 -->
<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="static/js/jquery.tips.js"></script>
<script type="text/javascript" src="static/js/myjs/city.js"></script>
</head>

<script type="text/javascript">
$(top.hangge());

//全选全不选
function choose() {
	var choose = $("[name=allChecked]").attr("checked");
	if (choose) {
		$("[name=checked]").attr("checked",true);
	}else{
		$("[name=checked]").attr("checked",false);
	}
	
}

//取消
function no(){
	window.location.href = "<%=basePath%>stationTarget/stationTargetList.do";
}

//确认添加或修改信息
function ok() {
	var count=${fn:length(stationTargetList)};
	var reg=new RegExp("^([0-9])+(\.[0-9]+)?$"); //数字就可以
		for(var i=0;i<count;i++){
			if($("#oilTargetVolume"+i).val().length != 0){
				if(!reg.test($("#oilTargetVolume"+i).val())){
					$("#oilTargetVolume"+i).tips({
						side:1,
			            msg:'您的输入有误！',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#oilTargetVolume"+i).focus();
					$("#oilTargetVolume"+i).val(1);
					return false;
				}
			}
			if($("#nonOilTargetVolume"+i).val().length != 0){
				if(!reg.test($("#nonOilTargetVolume"+i).val())){
					$("#nonOilTargetVolume"+i).tips({
						side:1,
			            msg:'您的输入有误！',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#nonOilTargetVolume"+i).focus();
					$("#nonOilTargetVolume"+i).val(1);
					return false;
				}
			}
		} 
	$("#stationTargetForm").submit();
}
//指标设置
function toStationTargetSettings(stationCode){
			var url = "<%=basePath%>stationTarget/toStationTargetSettings.do?stationCode="+stationCode;
			location.href = url;
}

//条件过滤查询
function criteriaQuery() {
	var formId = $("form").attr("id");
	$("#" + formId).submit();
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

<body>
	<%-- 	<input autocomplete="off" id="nav-search-input" type="text"
		class="span10 date-picker" name="yearMonth"
		value="${st.yearMonth}" data-date-format="yyyy"
		style="vertical-align: top; width: 150px;"
		placeholder="请选择年份并确认" /> <i id="nav-search-icon"
		class="icon-search"></i>
	<input type="hidden" value="${stationCode}">
	<a class="btn btn-mini btn-info"
	onclick="toStationTargetSettings(${stationCode});" style="margin-top: -11px;">确认</a> --%>
	<form action="<%=basePath%>stationTarget/stationTargetSaveOrUpdate.do"
		name="stationTargetForm" id="stationTargetForm" method="post">
		<div id="zhongxin">
			<table id="table_report"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center">序号</th>
						<th class='center'>所属油站</th>
						<th class='center'>年份月份</th>
						<th class='center'>油品本月目标销量（升）</th>
						<th class='center'>非油品本月目标销量（元）</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty stationTargetList}">
							<c:forEach items="${stationTargetList}" var="stationTarget"
								varStatus="vs">
								<tr>
									<td class='center' style="width: 30px;">${vs.index+1}</td>
									<td class="center"><biztab:biz type="station"
											code="${stationTarget.stationCode}">${obj.stationName }</biztab:biz></td>
									<td class="center">
									<input type="hidden" name='stationTargetList[${vs.index}].id' id="id${vs.index}" value="${stationTarget.id}" />
									<input type="hidden" name='stationTargetList[${vs.index}].yearMonth' id="yearMonth${vs.index}" value="${stationTarget.yearMonth}" />
									<input type="hidden" name='stationTargetList[${vs.index}].stationCode' id="stationCode${vs.index}" value="${stationTarget.stationCode}" />
										${stationTarget.yearMonth}
									</td>
									<td class="center"><input type="text"
										name="stationTargetList[${vs.index}].oilTargetVolume" id="oilTargetVolume${vs.index}"
										placeholder="这里输入油品本月目标销量（升）"
										value="<fmt:formatNumber value="${stationTarget.oilTargetVolume}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>"
										title="油品本月目标销量（升）" maxlength="32" /></td>
									<td class="center"><input type="text"
										name="stationTargetList[${vs.index}].nonOilTargetVolume" id="nonOilTargetVolume${vs.index}"
										placeholder="这里输入非油品本月目标销量（元）"
										value="<fmt:formatNumber value="${stationTarget.nonOilTargetVolume}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>"
										title="非油品本月目标销量（元）" maxlength="32" /></td>
								</tr>
							</c:forEach>
							<tr>
								<td style="text-align: center;" colspan="10"><a
									class="btn btn-mini btn-primary" onclick="ok();">保存</a> <a
									class="btn btn-mini btn-primary" onclick="no();">取消</a>
								</td>
							</tr>
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
		</div>

		<div id="zhongxin2" class="center" style="display: none">
			<br />
			<br />
			<br />
			<img src="static/images/jiazai.gif" /><br />
			<h4 class="lighter block green"></h4>
		</div>
	</form>
	<!-- 引入 -->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");
	</script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/ace-elements.min.js"></script>
	<script src="static/js/ace.min.js"></script>
	<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script>
	<!-- 下拉框 -->
	<script type="text/javascript"
		src="static/js/bootstrap-datepicker.min.js"></script>
	<!-- 日期框 -->
	<script type="text/javascript">
		$(function() {
			//单选框
			$(".chzn-select").chosen();
			$(".chzn-select-deselect").chosen({
				allow_single_deselect : true
			});

			//日期框
			$('.date-picker').datepicker();
		});
	</script>
</body>
</html>