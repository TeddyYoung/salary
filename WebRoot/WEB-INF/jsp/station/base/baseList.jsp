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
<title>油站信息</title>
<!-- 引入 -->
<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/ace-elements.min.js"></script>
<script src="static/js/ace.min.js"></script>
<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
<script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- 确认窗口 -->
<!-- 引入 -->
<script type="text/javascript" src="static/js/jquery.tips.js"></script><!--提示框-->
<script type="text/javascript">
	$(top.hangge());
	
	//新增
	function addstation(){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="新增油站信息";
		 diag.URL = '<%=basePath%>station/stationToAdd.do';
		 diag.Width = 800;
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
		 diag.Title ="查看油站信息";
		 diag.URL = '<%=basePath%>station/stationToView.do?id='+id;
		 diag.Width = 800;
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
		 diag.Title ="修改油站信息";
		 diag.URL = '<%=basePath%>station/stationToEdit.do?id='+id;
		 diag.Width = 800;
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
	//指标设置
	function toStationTargetSettings(stationCode){
				var url = "<%=basePath%>stationTarget/toStationTargetSettings.do?stationCode="+stationCode;
				location.href = url;
	}
	
	//删除
	function todelete(id,stationName){
		bootbox.confirm("确定要删除["+stationName+"]吗?", function(result) {
			if(result) {
				var url = "<%=basePath%>station/stationDelById.do?id="+id+"&guid="+new Date().getTime();
				top.jzts();
				$.get(url,function(data){
					if("success" == data.result){
							top.jzts();
							document.location.reload();
					}else if("false" == data.result)
						{
						top.hangge();
						bootbox.dialog("删除失败!", 
								[
								  {
									"label" : "关闭",
									"class" : "btn btn-mini btn-info",
									"callback": function() 
										{
											//Example.show("great success");
										}
								  }
								]
						);
					}
				});
			}
		});
	}
	//条件查询
	function searchStation(){
		$("#stationForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
</script>
<script type="text/javascript">
	$(function() {
		
		//下拉框
		$(".chzn-select").chosen(); 
		$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
		
		//日期框
		$('.date-picker').datepicker();
		
		//复选框
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
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
			<form action="<%=basePath%>station/stationList.do" name="stationForm" id="stationForm" method="post">
			<table>
				<tr>
					<td style="vertical-align:top;"><select name="districtCode" id="districtCode" class="chzn-select" data-placeholder="请选择所属区域" style="vertical-align:top;width: 220px;" title="所属区域">
									<option value="">全部</option>
										<biztab:biz type="district" code="all">
											<option value="${obj.organiseId}" ${obj.organiseId == districtCode ? 'selected="selected"' : '' }>${obj.organiseName}</option>
										</biztab:biz>
								</select>
								</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="stationName"  value="${stationName}" placeholder="这里输入油站名称" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<%--
					<td style="vertical-align:top;"> 
					 	<select class="chzn-select" name="stationStatus" id="stationStatus" data-placeholder="请选择油站状态" style="vertical-align:top;width: 140px;">
							<option value=""></option>
							<option value="">全部</option>
							<systab:dataDictionary codeType="stationStation" valueType="all">
								<option value="${dataDictionary.valuetype}" ${stationStatus==dataDictionary.valuetype ? 'selected="selected"':''} >${dataDictionary.valuename}</option>
							</systab:dataDictionary>
					  	</select>
					</td>
					 --%>
					<td style=""><a class="btn btn-mini btn-info"  onclick="searchStation();"style="margin-top:-11px;">查询</a></td>
					<td style=""><a class="btn btn-mini btn-info"  onclick="addstation();"style="margin-top:-11px;">新增</a></td>
				</tr>
			</table>
			<!-- 检索  -->
			<table id="table_report"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center">
							<label><input type="checkbox" id="zcheckbox" /><span class="lbl"></span></label>
						</th>
						<th class="center">序号</th>
						<th class='center'>区域</th>
						<th class='center'>编号</th>
						<th class='center'>名称</th>
<!-- 						<th class='center'>定编人数</th> -->
						<th class="center">地区类型</th>
						<th class="center">会计奖金油站类型</th>
						<th class="center">油站性质</th>
						<%-- <th class='center'>状态</th>
						<th class='center'>星级</th> --%>
						<th class='center'>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${not empty page.records}">
						<c:forEach items="${page.records}" var="station" varStatus="vs">
							<tr>
							<td class='center' style="width: 30px;">
								<label><input type='checkbox' name='ids' value="${station.id}" /><span class="lbl"></span></label>
							</td>
							<td class='center' style="width: 30px;">${vs.index+1}</td>
							<td class='center'><biztab:biz type="district" code="${station.districtCode}">${obj.organiseName }</biztab:biz></td>
							<td class='center'>${station.stationCode}</td>
							<td class='center'>${station.stationName}</td>
<%-- 							<td class='center'>${station.stationStaffNum}</td> --%>
							<td class="center"><biztab:biz type="area" code="${station.areaCode}">${obj.areaName }</biztab:biz></td>
							<td class='center'><systab:dataDictionary codeType="station_type" valueType="${station.stationType}">${dataDictionary.valuename }</systab:dataDictionary></td>
							<td class='center'>
								<systab:dataDictionary codeType="station_nature" valueType="${station.stationNature}">
									${dataDictionary.valuename }</systab:dataDictionary></td>
							<%-- 
							<td class='center'>
								<systab:dataDictionary codeType="stationStation" valueType="${station.stationStatus}">${dataDictionary.valuename }</systab:dataDictionary>
							</td>
							<td class='center'><biztab:biz type="stationLevel" code="${station.stationLevelCode}">${obj.stationLevelName }</biztab:biz></td>
							 --%>
							<td class='center'>
								<%-- <a class='btn btn-mini btn-info' onclick="toView('${station.id}')">查看</a> --%>
								<a class='btn btn-mini btn-info' onclick="toEdit('${station.id}')">修改</a>
								<a class='btn btn-mini btn-danger' onclick="todelete('${station.id}','${station.stationName}')">删除</a>
								<a class='btn btn-mini btn-info' onclick="toStationTargetSettings('${station.stationCode}')">指标设置</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="100" style="text-align: center;">此页没有相关数据，请查看<font color="red">上一页</font>或<font color="red">添加相关数据</font></td>
						</tr>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
				<!-- 分页展示页面 -->
			<div align="right">
				<%@include  file="../../common/page.jsp" %>
			</div>
			</form>
		</div>
	  <!-- PAGE CONTENT ENDS HERE -->
	  </div><!--/row-->
	</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->
		
		<!-- 返回顶部  -->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
</body>
</html>