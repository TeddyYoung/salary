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
<!-- jsp文件头和头部 -->
<%@ include file="../admin/top.jsp"%>   
<%@ include file="../../system/admin/top.jsp"%> 
<meta charset="utf-8" />
<title>数据字典</title>
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
	function addDataDictionary(){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="新增数据字典信息";
		 diag.URL = '<%=basePath%>dataDictionary/dataDictionaryToAdd.do';
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
		 diag.Title ="查看数据字典信息";
		 diag.URL = '<%=basePath%>dataDictionary/dataDictionaryToView.do?id='+id;
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
		 diag.Title ="修改数据字典信息";
		 diag.URL = '<%=basePath%>dataDictionary/dataDictionaryToEdit.do?id='+id;
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
	function todelete(id,valuename){
		bootbox.confirm("确定要删除["+valuename+"]吗?", function(result) {
			if(result) {
				var url = "<%=basePath%>dataDictionary/dataDictionaryDelById.do?id="+id+"&guid="+new Date().getTime();
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
	function searchDataDictionary(){
		$("#dataDictionaryForm").submit();
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
<%-- 	//批量操作
	function makeAll(msg){
		bootbox.confirm(msg, function(result) {
			if(result) {
				var str = '';
				for(var i=0;i < document.getElementsByName('ids').length;i++)
				{
					  if(document.getElementsByName('ids')[i].checked){
					  	if(str=='') str += document.getElementsByName('ids')[i].value;
					  	else str += ',' + document.getElementsByName('ids')[i].value;
					  }
				}
				if(str==''){
					bootbox.dialog("您没有选择任何内容!", 
						[
						  {
							"label" : "关闭",
							"class" : "btn-small btn-success",
							"callback": function() {
								//Example.show("great success");
								}
							}
						 ]
					);
					
					$("#zcheckbox").tips({
						side:3,
			            msg:'点这里全选',
			            bg:'#AE81FF',
			            time:8
			        });
					
					return;
				}else{
					if(msg == '确定要删除选中的数据吗?'){
						top.jzts();
						$.ajax({
							type: "POST",
							url: '<%=basePath%>zftd/deleteAll.do?tm='+new Date().getTime(),
					    	data: {DATA_IDS:str},
							dataType:'json',
							//beforeSend: validateData,
							cache: false,
							success: function(data){
								 $.each(data.list, function(i, list){
										nextPage(${page.currentPage});
								 });
							}
						});
					}
				}
			}
		});
	} --%>
</script>
</head>

<body>
<div class="container-fluid" id="main-container">


	<div id="page-content" class="clearfix">
						
  		<div class="row-fluid">


			<div class="row-fluid">
	
				<!-- 检索  -->
				<form action="<%=basePath%>dataDictionary/dataDictionaryList.do" method="post" name="dataDictionaryForm" id="dataDictionaryForm">
				<table>
					<tr>
						<td>
							<span class="input-icon">
								<input autocomplete="off" id="nav-search-input" type="text" name="codename" value="${codename}" placeholder="这里输入标识名称" />
								<i id="nav-search-icon" class="icon-search"></i>
							</span>
						</td>
						<%-- <td><input class="span10 date-picker" name="sysCreateTime" id="sysCreateTime"  value="${sysCreateTime}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:88px;" placeholder="开始日期" title="标识创建时间"/></td>
						<td><input class="span10 date-picker" name="sysUpdateTime" name="sysUpdateTime"  value="${sysUpdateTime}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:88px;" placeholder="结束日期" title="标识修改时间"/></td> --%>
						<td style="margin-top:-11px;"><a class="btn btn-mini btn-info" onclick="searchDataDictionary();"style="margin-top:-11px;">查询</a></td>
						<td style="margin-top:-11px;"><a class="btn btn-mini btn-info" onclick="addDataDictionary();"style="margin-top:-11px;">新增</a></td>
					</tr>
				</table>
				<!-- 检索  -->
				<table id="table_report"
					class="table table-striped table-bordered table-hover" style="margin-bottom:10px">
					<thead>
						<tr>
							<th class="center">
								<label><input type="checkbox" id="zcheckbox" /><span class="lbl"></span></label>
							</th>
							<th class='center'>序号</th>
							<th class='center'>标识类型</th>
							<th class='center'>标识名称</th>
							<th class='center'>值标识类型</th>
							<th class='center'>值标识名称</th>
							<th class='center'>备注</th>
							<th class='center'>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty page.records}">
								<c:forEach items="${page.records}" var="dataDictionary" varStatus="vs">
									<tr>
										<td class='center' style="width: 30px;">
											<label><input type='checkbox' name='ids' value="${dataDictionary.id}" /><span class="lbl"></span></label>
										</td>
										<td class='center' style="width: 30px;">${vs.index+1}</td>
										<td class='center'>${dataDictionary.codetype}</td>
										<td class='center'>${dataDictionary.codename}</td>
										<td class='center'>${dataDictionary.valuetype}</td>
										<td class='center'>${dataDictionary.valuename}</td>
										<td class='center'>${dataDictionary.remark}</td>
										<td class='center'> <a class='btn btn-mini btn-info' onclick="toEdit('${dataDictionary.id}')">修改</a>
										<a class="btn btn-mini btn-danger" onclick="todelete('${dataDictionary.id}','${dataDictionary.valuename}')">删除</a></td>
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