<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../base.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		
		<meta charset="utf-8" />
		<title>时薪设置</title>
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
		
		<link rel="stylesheet" href="static/css/datepicker.css" /><!-- 日期框 -->
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript" src="static/js/myjs/city.js"></script>
</head>

<script type="text/javascript">
	$(top.hangge());

	//保存
	function save(){
		if($("#normalHourly").val()==""){
			
			$("#normalHourly").tips({
				side:3,
	            msg:'请输入正常时薪（元）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#normalHourly").focus();
			return false;
		}
		if(isNaN(Number($("#normalHourly").val())) || $("#otHourly").val()<0){
			
			$("#normalHourly").tips({
				side:1,
	            msg:'请输入正常时薪（元）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#normalHourly").focus();
			$("#normalHourly").val(1);
			return false;
		}
		
		if($("#otHourly").val()==""){
			
			$("#otHourly").tips({
				side:3,
	            msg:'请输入加班时薪（元）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#otHourly").focus();
			return false;
		}
		if(isNaN(Number($("#otHourly").val())) || $("#otHourly").val()<0){
			
			$("#otHourly").tips({
				side:1,
	            msg:'请输入加班时薪（元）',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#otHourly").focus();
			$("#otHourly").val(1);
			return false;
		}
		if($("#areaCode").val()==""){
			
			$("#areaCode").tips({
				side:3,
	            msg:'请选择地区',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#areaCode").focus();
			return false;
		}     
		$("#areaHourlyForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>


<body>
	<form  action="<%=basePath%>areaHourly/areaHourlySaveOrUpdate.do" name="areaHourlyForm" id="areaHourlyForm" method="post" >
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<td  style="text-align: center;" colspan="10">职务：
						<select name="dutyCode" id="dutyCode" class="chzn-select" disabled="disabled" data-placeholder="请选择职务" style="vertical-align:top;width: 220px;" title="职务">
									<option value=""></option>
									<c:forEach items="${areaHourlyList }" var="areaHourly">
										<biztab:biz type="duty" code="all">
											<option value="${obj.dutyCode}" ${obj.dutyCode==areaHourly.dutyCode ? 'selected="selected"':'' }>${obj.dutyName}</option>
										</biztab:biz>
									</c:forEach>
						</select>
					</td>
				</tr>	
				<tr>
					<biztab:biz type="area" code="all">
						<th style="width:80px;text-align: center;padding-top: 6px;" colspan="2">${obj.areaName }</th>
					</biztab:biz>
				</tr>
				<tr>
					<biztab:biz type="area" code="all">
						<th style="width:80px;text-align: center;padding-top: 6px;">正常时薪（元）：</th>
						<th style="width:80px;text-align: center;padding-top: 6px;">加班时薪（元）：</th>
					</biztab:biz>
				</tr>
			</thead>
			<tr>
				<c:forEach items="${areaHourlyList }" var="areaHourly">
						<td style="text-align: center;">
							<input type="hidden" name="ids" id="ids" value="${areaHourly.id }"/>
							<input type="hidden" name="areaCodes" id="areaCode" value="${areaHourly.areaCode}"/>
							<input type="text" name="normalHourlys" id="normalHourly" placeholder="这里输入正常时薪（元）" style="width:80px;" value="<fmt:formatNumber value='${areaHourly.normalHourly }' pattern='##.##' minFractionDigits='2' ></fmt:formatNumber>" title="正常时薪（元）" maxlength="32" />
						</td >
						<td style="text-align: center;"><input type="text" name="otHourlys" id="otHourly" placeholder="这里输入加班时薪（元）" style="width:80px;" value="<fmt:formatNumber value='${areaHourly.otHourly }' pattern='##.##' minFractionDigits='2' ></fmt:formatNumber>" title="加班时薪（元）" maxlength="32" /></td>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach items="${areaHourlyList }" begin="0" end="0" var="areaHourly">
					<td style="text-align: center;" colspan="10">备注：<input type="text" name="remark" id="remark" placeholder="这里输入备注" value="${areaHourly.remark }" title="备注" /></td>
				</c:forEach>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
		</div>
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
	</form>
	<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript">
			$(function() {
				//单选框
				$(".chzn-select").chosen(); 
				$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
				
				//日期框
				$('.date-picker').datepicker();
			});
		</script>
</body>
</html>