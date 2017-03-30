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
<title></title>
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
	
	function addParameter() {
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="新增参数管理";
		 diag.URL = '<%=basePath%>parameter/parameterToAdd.do';
		 diag.Width = 800;
		 diag.Height = 220;
		 diag.CancelEvent = function(){ //关闭事件
			if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
				top.jzts(); 
				setTimeout("location.reload()",100);
			}
			diag.close();
		 };
		 diag.show();
	}
	
	function updateParameter(parameterId){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="修改参数管理";
		 diag.URL = '<%=basePath%>parameter/parameterToUpdate.do?parameterId=' + parameterId;
		 diag.Width = 800;
		 diag.Height = 220;
		 diag.CancelEvent = function(){ //关闭事件
			if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
				top.jzts(); 
				setTimeout("location.reload()",100);
			}
			diag.close();
		 };
		 diag.show();
	}
	
	function parameterDelete(parameterId, parameterValue){
		bootbox.confirm("确定要删除["+parameterValue+"]吗?", function(result) {
			if(result) {
				var url = "<%=basePath%>parameter/parameterDelete.do?parameterId=" + parameterId;
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
	
	//条件过滤查询
	function criteriaQuery() {
		var formId = $("form").attr("id");
		$("#" + formId).submit();
	}
</script>
</head>

<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<form id="parameterCriteriaQuery" action="parameter/parameterList.do" method="post">
						<table>
							<tr>
								<td><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text"
										name="parameterValue" value="${para.parameterValue}"
										placeholder="这里输入参数的值" /> <i id="nav-search-icon"
										class="icon-search"></i>
								</span></td>
								<td style="margin-top: -11px;"><a
									class="btn btn-mini btn-info" onclick="criteriaQuery();"style="margin-top:-11px;">查询</a></td>
								<td style="margin-top: -11px;"><a
									class="btn btn-mini btn-info" onclick="addParameter();"style="margin-top:-11px;">新增</a></td>
							</tr>
						</table>
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">序列号</th>
									<th class='center'>参数的键</th>
									<th class='center'>参数的值</th>
									<th class='center'>参数类型</th>
									<th class='center'>参数类型名称</th>
									<th class='center'>操作</th>
								</tr>
							</thead>
							<c:choose>
								<c:when test="${!empty pageList.records}">
									<c:forEach items="${pageList.records}" var="parameter" varStatus="vs">
										<tr>
											<td class="center">${vs.count}</td>
											<td class='center'>${parameter.parameterKey}</td>
											<td class='center'>${parameter.parameterValue}</td>
											<td class='center'><systab:dataDictionary codeType="parameterType" valueType="${parameter.parameterType}" >${dataDictionary.valuename }</systab:dataDictionary></td>
											<td class='center'>${parameter.parameterTypeName}</td>
											<td class='center'> <a class='btn btn-mini btn-info'
												onclick="updateParameter('${parameter.id}');">修改</a> <a
												class='btn btn-mini btn-danger'
												onclick="parameterDelete('${parameter.id}','${parameter.parameterValue}');">删除</a></td>
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