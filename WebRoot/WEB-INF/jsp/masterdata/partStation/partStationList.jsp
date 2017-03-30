<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>过节费维护</title>
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
	function addPartStation() {
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="新增兼站人员";
		 diag.URL = '<%=basePath%>partStation/partStationToAdd.do';
		 diag.Width = 800;
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
	
	function updatePartStation(partStationId){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="修改过节费";
		 diag.URL = '<%=basePath%>partStation/partStationToUpdate.do?partStationId=' + partStationId;
		 diag.Width = 800;
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
	
	function partStationDelete(partStationId, partStationName){
		bootbox.confirm("确定要删除[" + partStationName + "]吗?", function(result) {
			if(result) {
				var url = "<%=basePath%>partStation/partStationDelete.do?partStationId=" + partStationId;
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
	
	//全选全不选
	function choose() {
		var choose = $("[name=allChecked]").attr("checked");
		if (choose) {
			$("[name=checked]").attr("checked",true);
		}else{
			$("[name=checked]").attr("checked",false);
		}
		
	}
</script>
</head>

<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<form id="partStationList" action="<%=basePath%>partStation/partStationList.do" method="post">
						<table>
							<tr>
								<td style="vertical-align: top;"><a
									class="btn btn-mini btn-info" onclick="addPartStation();">新增</a></td>
							</tr>
						</table>
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">序列号</th>
									<th class='center'>所属油站</th>
									<th class='center'>员工编号</th>
									<th class='center'>员工姓名</th>
									<th class='center'>所属职务</th>
									<th class='center'>兼站金额</th>
									<th class='center'>操作</th>
								</tr>
							</thead>
							<c:choose>
								<c:when test="${!empty pageList.records}">
									<c:forEach items="${pageList.records}" var="partStation" varStatus="vs">
										<tr>
											<td class="center">${vs.count}</td>
											<td class='center'>
												<biztab:biz type="station" code="${partStation.stationCode}">${obj.stationName }</biztab:biz>
											</td>
											<td class='center'>${partStation.staffCode}</td>
											<td class='center'>${partStation.staffName}</td>
											<td class='center'><biztab:biz type="duty"
														code="${partStation.dutyCode }">${obj.dutyName }</biztab:biz></td>
											<td class='center'>
												<fmt:formatNumber type="number" value="${partStation.baseAmt}" pattern="0.00" maxFractionDigits="2" />
											</td>
											<td class='center'> <a class='btn btn-mini btn-info'
												onclick="updatePartStation('${partStation.id}');">修改</a> <a
												class='btn btn-mini btn-danger'
												onclick="partStationDelete('${partStation.id}','${partStation.staffName}');">删除</a></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="100" style="text-align: center;">此页没有相关数据，请查看<font color="red">上一页</font>或<font color="red">添加相关数据</font></td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>
						<div align="right">
							<%@include file="../../common/page.jsp"%>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse"> <i
		class="icon-double-angle-up icon-only"></i>
	</a>
</body>
</html>