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
<title>员工信息</title>
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
	function addstaff(){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="员工信息录入";
		 diag.URL = '<%=basePath%>staff/staffToAdd.do';
		 diag.Width = 900;
		 diag.Height = 450;
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
		 diag.Title ="查看油站员工记录";
		 diag.URL = '<%=basePath%>staff/staffToView.do?id='+id;
		 diag.Width = 900;
		 diag.Height = 450;
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
		 diag.Title ="修改油站员工记录";
		 diag.URL = '<%=basePath%>staff/staffToEdit.do?id='+id;
		 diag.Width = 900;
		 diag.Height = 450;
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
	function todelete(id,staffName){
		bootbox.confirm("确定要删除["+staffName+"]吗?", function(result) {
			if(result) {
				var url = "<%=basePath%>staff/staffDelById.do?id="+id+"&guid="+new Date().getTime();
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
	//去离职申请页面
	function toLeaveOffice(id,flag,staffName){
		 window.location.href='<%=basePath%>staff/toLeaveOffice.do?id='+id+'&flag='+flag;
	}
	//去调动申请页面
	function toTransfer(id,flag){
		 window.location.href='<%=basePath%>staff/toStaffTransfer.do?id='+id+'&flag='+flag;
	}
	//导出Excel
	function exportExcel(){
		bootbox.confirm("确定要导出[全部的员工花名册]吗?", function(result) {
			if(result) {
				var url = "<%=basePath%>staff/exportExcel.do";
				location.href = url;
			}
		});
	}
	//条件查询
	function searchStaff() {
		$("#staffForm").submit();
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
					<form action="<%=basePath%>staff/staffList.do" name="staffForm"
						id="staffForm" method="post">
						<table>
							<tr>
								<td style="vertical-align: top;">
									<select name="dutyCode" id="dutyCode" class="chzn-select" data-placeholder="请选择员工所属职务" 
											style="vertical-align:top;width: 220px;" title="员工所属职务" >
												<option value=""></option>
												<biztab:biz type="duty" code="all">
													<option value="${obj.dutyCode}"  ${obj.dutyCode==dutyCode ? 'selected="selected"' : '' }>${obj.dutyName}</option>
												</biztab:biz>
									</select>
								</td>
								<td style="vertical-align: top;"><select
									class="chzn-select" name="staffStatus" id="staffStatus"
									data-placeholder="请选择员工状态"
									style="vertical-align: top; width: 140px;">
										<option value="all">全部</option>
										<systab:dataDictionary codeType="staffStatus" valueType="all">
											<option value="${dataDictionary.valuetype}"
												${staffStatus==dataDictionary.valuetype ? 'selected="selected"':''}>${dataDictionary.valuename}</option>
										</systab:dataDictionary>
								</select></td>
								<td><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text"
										name="staffName" value="${staffName}" placeholder="这里输入员工姓名" />
										<i id="nav-search-icon" class="icon-search"></i>
								</span></td>
								<td style="vertical-align: top;"><a
									class="btn btn-mini btn-info" onclick="searchStaff();"
									style="margin-top: 2px;">查询</a></td>
									<td style="vertical-align: top;"><a
										class="btn btn-mini btn-info" onclick="addstaff();"
										style="margin-top: 2px;">员工信息录入</a></td>
								<!-- <td style="vertical-align: top;"><a
									class="btn btn-mini btn-info" onclick="return false;"
									style="margin-top: 2px;">调动申请</a></td>
								<td style="vertical-align: top;"><a
									class="btn btn-mini btn-info" onclick="return false;"
									style="margin-top: 2px;">升迁申请</a></td> -->
								<!-- <td style="vertical-align: top;"><a
									class="btn btn-mini btn-info" onclick="return false;"
									style="margin-top: 2px;">处分/处罚</a></td> -->
								<td style="vertical-align: top;"><a
									class="btn btn-mini btn-info" onclick="exportExcel();"
									style="margin-top: 2px;">导出花名册</a></td>
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
									<!-- 									<th class='center'>员工编号</th> -->
									<th class='center'>员工姓名</th>
									<th class='center'>员工编号</th>
									<th class="center">员工职务</th>
									<th class='center'>身份证号</th>
									<th class='center'>联系电话</th>
									<th class='center'>员工性别</th>
									<th class='center'>开户行</th>
									<th class='center'>银行卡号</th>
									<!-- 				<th class='center'>员工照片（预留）</th> -->
									<th class='center'>员工状态</th>
									<th class='center'>入职日期</th>
									<!-- <th class='center'>离职日期</th> -->
									<th class='center'>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty pageList.records}">
										<c:forEach items="${pageList.records}" var="staff"
											varStatus="vs">
											<tr>
												<td class='center' style="width: 30px;"><label><input
														type='checkbox' name='ids' value="${staff.id}" /><span
														class="lbl"></span></label></td>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<%-- 												<td class="center">${staff.stationCode}</td> --%>
												<%-- 												<td class="center"><biztab:biz type="station" --%>
												<%-- 														code="${staff.stationCode}">${obj.stationName }</biztab:biz></td> --%>
												<%-- 												<td class="center">${staff.staffCode}</td> --%>
												<td class="center">${staff.staffName}</td>
												<td class="center">${staff.staffCode}</td>
												<td class="center"><biztab:biz type="duty"
														code="${staff.dutyCode }">${obj.dutyName }</biztab:biz></td>
												<td class="center">${staff.staffIdcard}</td>
												<td class="center">${staff.staffPhone}</td>
												<td class="center"><systab:dataDictionary
														codeType="staffSex" valueType="${staff.staffSex}">${dataDictionary.valuename}</systab:dataDictionary>
												</td>
												<td class="center">${staff.staffBank}</td>
												<td class="center">${staff.staffBankcard}</td>
												<%-- 					<td class="center">${staff.staffPhoto}</td> --%>
												<td class="center"><systab:dataDictionary
														codeType="staffStatus" valueType="${staff.staffStatus}">${dataDictionary.valuename }</systab:dataDictionary>
												</td>
												<td class='center'>${staff.staffInDate}</td>
												<%-- <td class='center'>${staff.staffOutDate}</td> --%>
												<td class='center'>
													<%-- 
													<a class="btn btn-mini btn-info" onclick="toView('${staff.id}');">查看</a>
													 --%>
													<a class="btn btn-mini btn-info" onclick="toEdit('${staff.id}');">修改</a>
												<%--  <a
													class="btn btn-mini btn-danger"
													onclick="todelete('${staff.id}','${staff.staffName}');">删除</a> --%>
													<%--
													<c:if test="${staff.staffStatus=='1' }">
													<c:if test="${staff.staffOutStatus ==null }">
														<c:if test="${staff.isAvailable ==0 }">
															<a class="btn btn-mini btn-danger"
																onclick="toLeaveOffice('${staff.id}','${staff.flag}','${staff.staffName}');">离职申请</a>
															<a class="btn btn-mini btn-info" onclick="toTransfer('${staff.id}','${staff.flag}');"
														style="margin-top: 2px;">调动申请</a>
														</c:if>
													</c:if>
													</c:if>
													 --%>
													 	<a class="btn btn-mini btn-danger"
																onclick="toLeaveOffice('${staff.id}','${staff.flag}','${staff.staffName}');">离职申请</a>
														<a class="btn btn-mini btn-info" onclick="toTransfer('${staff.id}','${staff.flag}');"
																style="margin-top: 2px;">调动申请</a>
													</td>
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
</body>
</html>