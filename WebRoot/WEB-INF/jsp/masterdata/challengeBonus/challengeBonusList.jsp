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
	function addChallengeBonus() {
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="新增挑战奖金";
		 diag.URL = '<%=basePath%>challengeBonus/challengeBonusToAdd.do';
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
	
	function updateChallengeBonus(challengeBonusId){
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="修改挑战奖金";
		 diag.URL = '<%=basePath%>challengeBonus/challengeBonusToUpdate.do?challengeBonusId=' + challengeBonusId;
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
	
	function challengeBonusDelete(challengeBonusId, challengeBonusName){
		bootbox.confirm("确定要删除[" + challengeBonusName + "]吗?", function(result) {
			if(result) {
				var url = "<%=basePath%>challengeBonus/challengeBonusDelete.do?challengeBonusId=" + challengeBonusId;
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
	
	//导入Excel
	function importList() {
		bootbox.confirm("当前上传的Excel表格会自动将数据录入至上个月的数据中，请确认您上传的Excel表格是上个月的数据！", function(result) {
			if(result) {
				$("#challengeBonusList").attr("action", "<%=basePath%>challengeBonus/importList.do");
				$("#challengeBonusList").submit();
			}
		});
	}
	
	function searchList() {
		$("#challengeBonusList").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
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
					<form id="challengeBonusList" enctype="multipart/form-data"
							action="<%=basePath%>challengeBonus/challengeBonusList.do" method="post">
						<table>
							<tr>
								<td style="vertical-align:top;"><select name="districtCode" id="districtCode" class="chzn-select" data-placeholder="请选择所属区域" style="vertical-align:top;width: 220px;" title="所属区域">
									<option value="">全部</option>
										<biztab:biz type="district" code="all">
											<option value="${obj.organiseId}" ${obj.organiseId == searchVO.districtCode ? 'selected="selected"' : '' }>${obj.organiseName}</option>
										</biztab:biz>
								</select>
								</td>
								<td style="vertical-align:top;"><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text" class="span10 date-picker"
										name="yearMonth" value="${searchVO.yearMonth}" data-date-format="yyyy-mm" style="vertical-align:top;width: 150px;"
										placeholder="这里输入年份月份" /> <i id="nav-search-icon"
										class="icon-search"></i>
								</span></td>
								<td style="vertical-align:top;">
									<select name="type" id="type"  class="chzn-select" data-placeholder="挑战奖金类型" 
										style="vertical-align:top;width: 150px;" title="挑战奖金类型">
										<option value=""></option>
										<systab:dataDictionary codeType="challenge_bonus_type" valueType="all">
											<option value="${dataDictionary.valuetype}"  
												${dataDictionary.valuetype==searchVO.type ? 'selected="selected"' : '' }>
												${dataDictionary.valuename}</option>
										</systab:dataDictionary>
									</select>
								</td>
								<td style=""><a
									class="btn btn-mini btn-info" onclick="searchList();" >查询</a></td>
								<td style=""><a
								class="btn btn-mini btn-info" onclick="addChallengeBonus();">新增</a></td>
								<td>
									<input type="file" name="uploadFile" />
									<a class="btn btn-mini btn-info" onclick="importList();" style="margin-top:-11px;">导入Excel数据</a>
								</td>
								<td>
									<a class="btn btn-mini btn-info" href="<%=basePath%>common/downloadTemplate.do?fileType=15" style="margin-top:-11px;">模板下载</a>
								</td>
							</tr>
						</table>
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">序列号</th>
									<th class='center'>所属油站</th>
									<th class='center'>年份月份</th>
<!-- 									<th class='center'>计划天数</th> -->
									<th class='center'>基础目标</th>
<!-- 									<th class='center'>中间目标</th> -->
									<th class='center'>基础奖金</th>
									<th class='center'>挑战目标</th>
									<th class='center'>挑战奖金</th>
<!-- 									<th class='center'>非油品总额</th> -->
									<th class='center'>挑战奖金类型</th>
									<th class='center'>操作</th>
								</tr>
							</thead>
							<c:choose>
								<c:when test="${!empty pageList.records}">
									<c:forEach items="${pageList.records}" var="challengeBonus" varStatus="vs">
										<tr>
											<td class="center">${vs.count}</td>
											<td class='center'>
												<biztab:biz type="station" code="${challengeBonus.stationCode}">${obj.stationName }</biztab:biz>
											</td>
											<td class='center'>${challengeBonus.yearMonth}</td>
<%-- 											<td class='center'>${challengeBonus.planDay}</td> --%>
											<td class='center'>${challengeBonus.baseTarget}</td>
<%-- 											<td class='center'>${challengeBonus.middleTarget}</td> --%>
											<td class='center'>
												<fmt:formatNumber type="number" value="${challengeBonus.baseBonusAmt}" pattern="0.00" maxFractionDigits="2" />
											</td>
											<td class='center'>${challengeBonus.challengeTarget}</td>
											<td class='center'>
												<fmt:formatNumber type="number" value="${challengeBonus.challengeBonusAmt}" pattern="0.00" maxFractionDigits="2" />
											</td>
<!-- 											<td class='center'> -->
<%-- 												<fmt:formatNumber type="number" value="${challengeBonus.nonOilTotalAmt}" pattern="0.00" maxFractionDigits="2" /> --%>
<!-- 											</td> -->
											<td class="center"><systab:dataDictionary
														codeType="challenge_bonus_type" valueType="${challengeBonus.type}">${dataDictionary.valuename}</systab:dataDictionary>
											</td>
											<td class='center'> <a class='btn btn-mini btn-info'
												onclick="updateChallengeBonus('${challengeBonus.id}');">修改</a> <a
												class='btn btn-mini btn-danger'
												onclick="challengeBonusDelete('${challengeBonus.id}','${challengeBonus.stationCode}');">删除</a></td>
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