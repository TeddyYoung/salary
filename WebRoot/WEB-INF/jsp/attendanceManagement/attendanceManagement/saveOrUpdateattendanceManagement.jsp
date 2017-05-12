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
<title>添加或修改考勤管理</title>
<!-- 引入 -->
<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/ace-elements.min.js"></script>
<script src="static/js/ace.min.js"></script>
<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script>
<!-- 下拉框 -->
<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script>
<!-- 日期框 -->
<script type="text/javascript" src="static/js/bootbox.min.js"></script>
<!-- 确认窗口 -->
<!-- 引入 -->
<script type="text/javascript" src="static/js/jquery.tips.js"></script>
<!-- <script src="http://cdn.bootcss.com/jquery/1.12.2/jquery.js"></script> -->
<script src="static/js/dataTables/dataTables.fixedColumns.min.js"></script>
<link href='static/js/dataTables/fixedColumns.bootstrap.min.css'/>
<script>
$(document).ready(function() {
    var table = $('#table-body').DataTable( {
        scrollY:        "3500px",
        scrollX:        true,
        scrollCollapse: true,
        paging:         false,
        ordering: false,//排序功能
        searching: false,
        fixedColumns:   {
            leftColumns: 5
        }
    } );
} );
</script>
<!--提示框-->
<script type="text/javascript">
	$(top.hangge());
	
	//确认添加或修改信息
	function ok(flag) {
		//验证每一个输入域的值, 必须是数字
		var count=${fn:length(attendanceManagementList)};
		var reg=new RegExp("^([0-9])+(\\.[0-9]+)?$"); //数字就可以
		var reg2=new RegExp("^(\\d{1,2}(\\.\\d{1,2})?|100|100.0|100.00)$"); //1-100之间的数字
		//var reg3=new RegExp("^(100|[1-9]?/d(/./d/d?/d?)?)%$|0$"); //1-100之间的百分数
		for(var i=0;i<count;i++){
			if ($("#workingDay"+i).val().length == 0) {
				$("#workingDay"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#workingDay"+i).focus();
				return false;
			}
			if(!reg.test($("#workingDay"+i).val())){
				$("#workingDay"+i).tips({
					side:1,
		            msg:'请输入正确的工作日天数!',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#workingDay"+i).focus();
				return false;
			}
			if ($("#isStamanageForeman"+i).val().length == 0) {
				$("#isStamanageForeman"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#isStamanageForeman"+i).focus();
				return false;
			}
			if ($("#isInternship"+i).val().length == 0) {
				$("#isInternship"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#isInternship"+i).focus();
				return false;
			}
			if ($("#afterIntershipWorking"+i).val().length == 0) {
				$("#afterIntershipWorking"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#afterIntershipWorking"+i).focus();
				return false;
			}
			if(!reg.test($("#afterIntershipWorking"+i).val())){
				$("#afterIntershipWorking"+i).tips({
					side:1,
		            msg:'请输入正确的实习期满后工作天数!',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#afterIntershipWorking"+i).focus();
				return false;
			}
			if ($("#peacetimeTimeout"+i).val().length == 0) {
				$("#peacetimeTimeout"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#peacetimeTimeout"+i).focus();
				return false;
			}
			if(!reg.test($("#peacetimeTimeout"+i).val())){
				$("#peacetimeTimeout"+i).tips({
					side:1,
		            msg:'请输入正确的平时超时!',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#peacetimeTimeout"+i).focus();
				return false;
			}
			if ($("#holidayOvertime"+i).val().length == 0) {
				$("#holidayOvertime"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#holidayOvertime"+i).focus();
				return false;
			}
			if(!reg.test($("#holidayOvertime"+i).val())){
				$("#holidayOvertime"+i).tips({
					side:1,
		            msg:'请输入正确的节日加班',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#holidayOvertime"+i).focus();
				return false;
			}
			if ($("#isFamilyReunionDinnerOn"+i).val().length == 0) {
				$("#isFamilyReunionDinnerOn"+i).tips({
					side:1,
		            msg:'这里还没有填!',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#isFamilyReunionDinnerOn"+i).focus();
				return false;
			}
// 			if(!reg.test($("#isFamilyReunionDinnerOn"+i).val())){
// 				$("#isFamilyReunionDinnerOn"+i).tips({
// 					side:1,
// 		            msg:'请输入正确的年夜饭在岗',
// 		            bg:'#AE81FF',
// 		            time:2
// 		        });
// 				$("#isFamilyReunionDinnerOn"+i).focus();
// 				return false;
// 			}
			if($("#onTheSpringFestivaOne"+i).val().length == 0) {
				$("#onTheSpringFestivaOne"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#onTheSpringFestivaOne"+i).focus();
				return false;
			}
			if(!reg.test($("#onTheSpringFestivaOne"+i).val())){
				$("#onTheSpringFestivaOne"+i).tips({
					side:1,
		            msg:'请输入正确的春节在岗',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#onTheSpringFestivaOne"+i).focus();
				return false;
			}
// 			if ($("#onTheSpringFestivaTwo"+i).val().length == 0) {
// 				$("#onTheSpringFestivaTwo"+i).tips({
// 					side:1,
// 		            msg:'这里还没有填！',
// 		            bg:'#AE81FF',
// 		            time:2
// 		        });
// 				$("#onTheSpringFestivaTwo"+i).focus();
// 				return false;
// 			}
// 			if(!reg.test($("#onTheSpringFestivaTwo"+i).val())){
// 				$("#onTheSpringFestivaTwo"+i).tips({
// 					side:1,
// 		            msg:'请输入正确的春节在岗（阶段二）',
// 		            bg:'#AE81FF',
// 		            time:2
// 		        });
// 				$("#onTheSpringFestivaTwo"+i).focus();
// 				return false;
// 			}
// 			if ($("#monthDeparture"+i).val().length == 0) {
// 				$("#monthDeparture"+i).tips({
// 					side:1,
// 		            msg:'这里还没有填！',
// 		            bg:'#AE81FF',
// 		            time:2
// 		        });
// 				$("#monthDeparture"+i).focus();
// 				return false;
// 			}
// 			if(!reg.test($("#monthDeparture"+i).val())){
// 				$("#monthDeparture"+i).tips({
// 					side:1,
// 		            msg:'请输入正确的本月离职',
// 		            bg:'#AE81FF',
// 		            time:2
// 		        });
// 				$("#monthDeparture"+i).focus();
// 				return false;
// 			}
			if ($("#casualLeave"+i).val().length == 0) {
				$("#casualLeave"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#casualLeave"+i).focus();
				return false;
			}
			if(!reg.test($("#casualLeave"+i).val())){
				$("#casualLeave"+i).tips({
					side:1,
		            msg:'请输入正确的事假',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#casualLeave"+i).focus();
				return false;
			}
			if ($("#absenteeism"+i).val().length == 0) {
				$("#absenteeism"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#absenteeism"+i).focus();
				return false;
			}
			if(!reg.test($("#absenteeism"+i).val())){
				$("#absenteeism"+i).tips({
					side:1,
		            msg:'请输入正确的旷工',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#absenteeism"+i).focus();
				return false;
			}
			if ($("#sickLeave"+i).val().length == 0) {
				$("#sickLeave"+i).tips({
					side:1,
		            msg:'这还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#sickLeave"+i).focus();
				return false;
			}
			if(!reg.test($("#sickLeave"+i).val())){
				$("#sickLeave"+i).tips({
					side:1,
		            msg:'请输入正确的病假',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#sickLeave"+i).focus();
				return false;
			}
			if ($("#annualLeave"+i).val().length == 0) {
				$("#annualLeave"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#annualLeave"+i).focus();
				return false;
			}
			if(!reg.test($("#annualLeave"+i).val())){
				$("#annualLeave"+i).tips({
					side:1,
		            msg:'请输入正确的年假',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#annualLeave"+i).focus();
				return false;
			}
			if ($("#marriageLeave"+i).val().length == 0) {
				$("#marriageLeave"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#marriageLeave"+i).focus();
				return false;
			}
			if(!reg.test($("#marriageLeave"+i).val())){
				$("#marriageLeave"+i).tips({
					side:1,
		            msg:'请输入正确的婚假',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#marriageLeave"+i).focus();
				return false;
			}
			if ($("#maternityLeave"+i).val().length == 0) {
				$("#maternityLeave"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#maternityLeave"+i).focus();
				return false;
			}
			if(!reg.test($("#maternityLeave"+i).val())){
				$("#maternityLeave"+i).tips({
					side:1,
		            msg:'请输入正确的产假',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#maternityLeave"+i).focus();
				return false;
			}
			if ($("#funeralLeave"+i).val().length == 0) {
				$("#funeralLeave"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#funeralLeave"+i).focus();
				return false;
			}
			if(!reg.test($("#funeralLeave"+i).val())){
				$("#funeralLeave"+i).tips({
					side:1,
		            msg:'请输入正确的丧假',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#funeralLeave"+i).focus();
				return false;
			}
			if ($("#daysOff"+i).val().length == 0) {
				$("#daysOff"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#daysOff"+i).focus();
				return false;
			}
			if(!reg.test($("#daysOff"+i).val())){
				$("#daysOff"+i).tips({
					side:1,
		            msg:'请输入正确的调休',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#daysOff"+i).focus();
				return false;
			}
			if ($("#verbalWarnings"+i).val().length == 0) {
				$("#verbalWarnings"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#verbalWarnings"+i).focus();
				return false;
			}
			if(!reg.test($("#verbalWarnings"+i).val())){
				$("#verbalWarnings"+i).tips({
					side:1,
		            msg:'请输入正确的警告',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#verbalWarnings"+i).focus();
				return false;
			}
			if ($("#writtenWarning"+i).val().length == 0) {
				$("#writtenWarning"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#writtenWarning"+i).focus();
				return false;
			}
			if(!reg.test($("#writtenWarning"+i).val())){
				$("#writtenWarning"+i).tips({
					side:1,
		            msg:'请输入正确的记过',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#writtenWarning"+i).focus();
				return false;
			}
			if ($("#majorAccident"+i).val().length == 0) {
				$("#majorAccident"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#majorAccident"+i).focus();
				return false;
			}
			if(!reg.test($("#majorAccident"+i).val())){
				$("#majorAccident"+i).tips({
					side:1,
		            msg:'请输入正确的重大事故',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#majorAccident"+i).focus();
				return false;
			}
			if ($("#isAccomodate"+i).val().length == 0) {
				$("#isAccomodate"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#isAccomodate"+i).focus();
				return false;
			}
			if ($("#isBoarder"+i).val().length == 0) {
				$("#isBoarder"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#isBoarder"+i).focus();
				return false;
			}
			if ($("#splendorCardBlue"+i).val().length == 0) {
				$("#splendorCardBlue"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#splendorCardBlue"+i).focus();
				return false;
			}
			if(!reg.test($("#splendorCardBlue"+i).val())){
				$("#splendorCardBlue"+i).tips({
					side:1,
		            msg:'请输入正确的精彩卡-蓝色版',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#splendorCardBlue"+i).focus();
				return false;
			}
			if ($("#splendorCardGreen"+i).val().length == 0) {
				$("#splendorCardGreen"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#splendorCardGreen"+i).focus();
				return false;
			}
			if(!reg.test($("#splendorCardGreen"+i).val())){
				$("#splendorCardGreen"+i).tips({
					side:1,
		            msg:'请输入正确的精彩卡-绿色版',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#splendorCardGreen"+i).focus();
				return false;
			}
			if ($("#partTimeScale"+i).val().length == 0) {
				$("#partTimeScale"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#partTimeScale"+i).focus();
				return false;
			}
			if(!reg.test($("#partTimeScale"+i).val())){
				$("#partTimeScale"+i).tips({
					side:1,
		            msg:'请输入正确的兼职便利店员比例',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#partTimeScale"+i).focus();
				return false;
			}
			if ($("#monthPerformance"+i).val().length == 0) {
				$("#monthPerformance"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#monthPerformance"+i).focus();
				return false;
			}
			if(!reg2.test($("#monthPerformance"+i).val())){
				$("#monthPerformance"+i).tips({
					side:1,
		            msg:'月度绩效的小数点后面保留不超过两位',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#monthPerformance"+i).focus();
				return false;
			}
			if ($("#managerBonusScale"+i).val().length == 0) {
				$("#managerBonusScale"+i).tips({
					side:1,
		            msg:'这里还没有填！',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#managerBonusScale"+i).focus();
				return false;
			}
			if(!reg.test($("#managerBonusScale"+i).val())){
				$("#managerBonusScale"+i).tips({
					side:1,
		            msg:'请输入正确的经理奖金分配比例',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#managerBonusScale"+i).focus();
				return false;
			}
		} 
		//top.jzts();
		bootbox.confirm("请确认考勤信息已填写完整无误,审批中的考勤信息将不能修改。确定立即提交？", function(result) {
			if(result) {
				if(flag == 1){
					$.ajax({
		                type: "POST",
		                url:'<%=basePath%>attendanceManagement/attendanceUpdate.do?isSubmit=0',
		                data:$('#attendanceManagementForm').serialize(),// 
		                async: false,
		                error:function() {
		                	alert("保存失败");
		                },
		                success: function(data) {
		                	if(data.result == 1){
		                		alert("保存成功,请提交审批");
			                	window.close();
		                	}else{
		                		alert(date.message);
		                	}
		                	
		                }
		            });
				}else{
					$("#attendanceManagementForm").submit();
				}
				
			}
		});	
		
	}

	//取消
	function no() {
		window.location.href = "<%=basePath%>attendanceManagement/attendanceManagementList.do";
	}
	
	//下拉框改变时刷新信息
	function choose() {
		window.location.href = "<%=basePath%>attendanceManagement/saveOrUpdateattendanceManagement.do?stationCode=" + $("#stationCode").val();
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
<script type ="text/javascript">

// $(window).scroll(function (){//滚动条监听
//     var st = $(this).scrollTop();
   
//     if(st <= $(window).width()){
//         $(".table-body").css({'position':''});
//     }else{
//         $(".table-body").css({'position':'fixed'});
        
//     }
  
// });
</script>
<style>
.table th, .table td {
    padding:20px;
    line-height: 20px;
    text-align: left;
    vertical-align: top;
    border-top: 1px solid rgb(221, 221, 221);
}
.table-bordered thead:first-child tr th {
    border-width: 0px 0px 0px 1px;
    border-color: rgb(221, 221, 221);
    vertical-align:baseline;
}
th, td { white-space: nowrap; }
.DTFC_LeftBodyWrapper{
	background:#fff;
}
#table-body_info{
	display:none
}
</style>
</head>
<body style="overflow-x:hidden">
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix" style="padding:0px 20px 24px;">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- 检索  -->
					<form action="<%=basePath%>attendanceManagement/attendanceManagementRealSaveOrUpdate.do"
						  name="attendanceManagementForm" id="attendanceManagementForm" method="post">
						<!-- 
						<table>
							<tr>
								<td style="vertical-align:top;">
									<select name="stationCode" id="stationCode" class="chzn-select" 
											data-placeholder="请选择所属油站" style="vertical-align:top; 
											width: 220px;" title="所属油站" onchange="choose()">
										<option value="">全部</option>
											<biztab:biz type="station" code="all">
												<option value="${obj.stationCode}" ${obj.stationCode == Flag2.flag ? 'selected="selected"' : '' }>${obj.stationName}</option>
											</biztab:biz>
									</select>
								</td>
							</tr>
						</table>
						 -->  
						 <!-- 分页展示页面 -->
						<div style="margin-left:-100px;position:fixed;background:white; padding: 7px;padding-left:0;width: 5500px;margin-top: -5px;">
							<table>
								<tr>
								<c:choose>  
							   <c:when test="${isSave == 1}">
					                   <td><a 
										class="btn btn-mini btn-info" onclick="ok(1);" style="margin-top:-10px;margin-left:100px;">
										保存</a></td>      
							   </c:when>  
							   <c:otherwise>
							    <td><a 
									class="btn btn-mini btn-info" onclick="ok(0);" style="margin-top:-10px;margin-left:100px;">
										  提交审批</a></td>     
							   </c:otherwise>  
							</c:choose>  
									<td><a
										class="btn btn-mini btn-danger" onclick="no();" style="margin-top:-10px;">取消</a>
								</tr>
							</table>
						</div>
						<div style="height:30px;"></div>
<!-- 						<table id="table_report" border="1px" style="width:3500px;border:1px solid #ddd;position:absolute!important;"> -->
							
<!-- 							<thead > -->
<!-- 								<tr style="background:linear-gradient(to bottom,#f8f8f8 0,#ececec 100%);"> -->
<!-- 									
<!-- 									<th class="center"style="width:70px;color:#707070" >油站名称</th> -->
<!-- 									<th class="center"style="width:75px;color:#707070">油站编号</th> -->
<!-- 									<th class="center"style="width:80px;color:#707070">地区类型</th> -->
<!-- 									<th class="center"style="width:75px;color:#707070">油站星级</th> -->
<!-- 									 --> 
<!-- 									<th class="center"style="width:33px;color:#707070">序号</th> -->
<!-- 									<th class="center"style="width:65px;color:#707070">员工编号</th> -->
<!-- 									<th class="center"style="width:65px;color:#707070">员工姓名</th> -->
<!-- 		                            <th class="center" style="width:60px;color:#707070">职务</th> -->
<!-- 									<th class="center"style="width:80px;color:#707070">入职日期</th> -->
<!-- 									<th class="center"style="width:44px;color:#707070">工作日</th> -->
<!-- 									<th class="center"style="width:100px;color:#707070">是否管站\带班</th> -->
<!-- 									<th class="center" style="width:100px;color:#707070">是否实习期内</th> -->
<!-- 									<th class="center" style="width:140px;color:#707070">本月实习期满后工作天数</th> -->
<!-- 									<th class="center" style="width:65px;color:#707070">平时超时</th> -->
<!-- 									<th class="center" style="width:65px;color:#707070">节日加班</th> -->
<!-- 									<th class="center" style="width:80px;color:#707070">跨站支援(天)</th> -->
<!-- 									<th class="center" style="width:80px;color:#707070">年夜饭在岗</th> -->
<!-- 									<th class="center"style="width:120px;color:#707070">春节在岗</th> -->
<!-- <!-- 									<th class="center"style="width:120px;color:#707070">春节在岗（阶段二）</th> --> 
<!-- 									<th class="center"style="width:120px;color:#707070">夜班在岗</th> -->
<!-- 									<th class="center" style="width:60px;color:#707070">本月离职</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">事假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">旷工</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">病假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">年假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">婚假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">产假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">丧假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">调休</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">警告</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">记过</th> -->
<!-- 									<th class="center" style="width:75px;color:#707070">重大事故</th> -->
<!-- 									<th class="center" style="width:100px;color:#707070">是否保留宿舍</th> -->
<!-- 									<th class="center" style="width:100px;color:#707070">是否搭伙</th> -->
<!-- 									<th class="center" style="width:90px;color:#707070">精彩卡-蓝色版</th> -->
<!-- 									<th class="center" style="width:90px;color:#707070">精彩卡-绿色版</th> -->
<!-- 									<th class="center" style="width:110px;color:#707070">兼职便利店员比例(%)</th> -->
<!-- 									<th class="center" style="width:130px;color:#707070">月度绩效<font color="red">（百分制）</font></th> -->
<!-- 									<th class="center" style="width:110px;color:#707070">经理奖金分配比例(%)</th> -->
<!-- 									<th class="center" style="width:100px;color:#707070">备注</th> -->
<!-- 									<th class="center" style="width:70px;color:#707070">月份</th> -->
<!-- 								</tr> -->
<!-- 							</thead> -->
<!-- 							</table> -->
							
							<div class="table-body" style="margin-top:45px;">
							<table id="table-body" border="1px" style="width:3500px;border:1px solid #ddd;" class="11 stripe row-border order-column" cellspacing="0" width="100%">
							<thead>
						
							<tr style="background:linear-gradient(to bottom,#f8f8f8 0,#ececec 100%);">
									<!-- 
									<th class="center"style="width:70px;color:#707070" >油站名称</th>
									<th class="center"style="width:75px;color:#707070">油站编号</th>
									<th class="center"style="width:80px;color:#707070">地区类型</th>
									<th class="center"style="width:75px;color:#707070">油站星级</th>
									 -->
									<th class="center"style="width:40px;color:#707070">序号</th>
									<th class="center"style="width:65px;color:#707070">员工编号</th>
									<th class="center"style="width:65px;color:#707070">员工姓名</th>
		                            <th class="center" style="width:60px;color:#707070">职务</th>
									<th class="center"style="width:80px;color:#707070">入职日期</th>
									<th class="center"style="width:80px;color:#707070">离职日期</th>
									<th class="center"style="width:44px;color:#707070">工作日</th>
									<th class="center"style="width:100px;color:#707070">是否管站\带班</th>
									<th class="center" style="width:100px;color:#707070">是否实习期内</th>
									<th class="center" style="width:140px;color:#707070">本月实习期满后工作天数</th>
									<th class="center" style="width:65px;color:#707070">平时超时</th>
									<th class="center" style="width:65px;color:#707070">节日加班</th>
									<th class="center" style="width:80px;color:#707070">跨站支援(天)</th>
									<th class="center" style="width:80px;color:#707070">年夜饭在岗</th>
									<th class="center"style="width:120px;color:#707070">春节在岗</th>
<!-- 									<th class="center"style="width:120px;color:#707070">春节在岗（阶段二）</th> -->
									<th class="center"style="width:120px;color:#707070">夜班在岗</th>
									<th class="center" style="width:60px;color:#707070">本月离职</th>
									<th class="center" style="width:50px;color:#707070">事假</th>
									<th class="center" style="width:50px;color:#707070">旷工</th>
									<th class="center" style="width:50px;color:#707070">病假</th>
									<th class="center" style="width:50px;color:#707070">年假</th>
									<th class="center" style="width:50px;color:#707070">婚假</th>
									<th class="center" style="width:50px;color:#707070">产假</th>
									<th class="center" style="width:50px;color:#707070">丧假</th>
									<th class="center" style="width:50px;color:#707070">调休</th>
									<th class="center" style="width:50px;color:#707070">警告</th>
									<th class="center" style="width:50px;color:#707070">记过</th>
									<th class="center" style="width:75px;color:#707070">重大事故</th>
									<th class="center" style="width:100px;color:#707070">是否保留宿舍</th>
									<th class="center" style="width:100px;color:#707070">是否搭伙</th>
									<th class="center" style="width:90px;color:#707070">精彩卡-蓝色版</th>
									<th class="center" style="width:90px;color:#707070">精彩卡-绿色版</th>
									<th class="center" style="width:110px;color:#707070">兼职便利店员比例(%)</th>
									<th class="center" style="width:130px;color:#707070">月度绩效<font color="red">（百分制）</font></th>
									<th class="center" style="width:110px;color:#707070">经理奖金分配比例(%)</th>
									<th class="center" style="width:100px;color:#707070">备注</th>
									<th class="center" style="width:70px;color:#707070">月份</th>
								</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${!empty attendanceManagementList}">
										<c:forEach items="${attendanceManagementList}" var="am" varStatus="vs">
											<tr class="center" >
												<!-- 
												<td>
													${am.stationName}
												</td>
												<td>${am.stationCode}</td>
												<td>${am.areaName}</td>
												<td>${am.stationLevelName}</td>
												 -->
												<td style="width:40px;">
													${vs.count}
												</td>
												<input type="hidden" name="attendanceManagementList[${vs.index}].id" value="${am.id}" />
												<input type="hidden" name="attendanceManagementList[${vs.index}].staffCode" value="${am.staffCode}" />
												<input type="hidden" name="attendanceManagementList[${vs.index}].stationCode" value="${am.stationCode}" />
												<td style="width:82px;">${am.staffCode}</td>
												<td style="width:82px;">${am.staffName}</td>
												<td style="width:76px;">${am.dutyName}</td>
												<td style="width:101px;">${am.staffInDate}</td>
												<td style="width:101px;">${am.staffOutDate}</td>
												<td style="width:56px;">
													<input style="width:40px;margin-top:5px;" type="text" id="workingDay${vs.index}" name="attendanceManagementList[${vs.index}].workingDay"
														   value="<fmt:formatNumber type='number' value='${am.workingDay==null?0:am.workingDay}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="margin-top:5px;width:126px;">
													<select id="isStamanageForeman${vs.index}" name="attendanceManagementList[${vs.index}].isStamanageForeman"style="margin-top:5px;width:100px;">
														<option value="N" ${"N" == am.isStamanageForeman || null == am.isStamanageForeman ? 'selected="selected"' : '' }>N</option>
														<option value="Y" ${"Y" == am.isStamanageForeman ? 'selected="selected"' : '' }>Y</option>
													</select>
												</td>
												<td style="margin-top:5px;width:126px;">
													<select id="isInternship${vs.index}" name="attendanceManagementList[${vs.index}].isInternship" style="margin-top:5px;width:100px;">
														<option value="N" ${"N" == am.isInternship  || null == am.isInternship? 'selected="selected"' : '' }>N</option>
														<option value="Y" ${"Y" == am.isInternship ? 'selected="selected"' : '' }>Y</option>
													</select>
												</td>
												<td style=width:177px; >
													<input style="width:144px;margin-top:5px;"type="text" name="attendanceManagementList[${vs.index}].afterIntershipWorking" 
														   id="afterIntershipWorking${vs.index}" value="<fmt:formatNumber type='number' value='${am.afterIntershipWorking==null?0:am.afterIntershipWorking}' pattern='0.0' maxFractionDigits='2' />"/>
														   
												</td>
												<td style="width: 82px;">
													<input style="width:60px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].peacetimeTimeout" 
														   id="peacetimeTimeout${vs.index}" value="<fmt:formatNumber type='number' value='${am.peacetimeTimeout==null?0:am.peacetimeTimeout}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width: 82px;">
													<input style="width:60px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].holidayOvertime" 
														   id="holidayOvertime${vs.index}" value="<fmt:formatNumber type='number' value='${am.holidayOvertime==null?0:am.holidayOvertime}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width: 82px;">
													<input style="width:60px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].supportDays" 
														   id="supportDays${vs.index}" value="<fmt:formatNumber type='number' value='${am.supportDays==null?0:am.supportDays}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td  style="width: 101px;">
<%-- 													<input style="width:80px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].familyReunionDinnerOn"  --%>
<%-- 														   id="familyReunionDinnerOn${vs.index}" value="<fmt:formatNumber type='number' value='${am.familyReunionDinnerOn==null?0:am.familyReunionDinnerOn}' pattern='0.0' maxFractionDigits='2' />"/> --%>
														   <select id="isFamilyReunionDinnerOn${vs.index}" name="attendanceManagementList[${vs.index}].isFamilyReunionDinnerOn" style="margin-top:5px;width:100px;">
														<option value="N" ${"N" == am.isFamilyReunionDinnerOn  || null == am.isFamilyReunionDinnerOn? 'selected="selected"' : '' }>N</option>
														<option value="Y" ${"Y" == am.isFamilyReunionDinnerOn ? 'selected="selected"' : '' }>Y</option>
													</select>
												</td>
												<td style="width:152px;">
													<input style="width:120px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].onTheSpringFestivaOne" 
														   id="onTheSpringFestivaOne${vs.index}" value="<fmt:formatNumber type='number' value='${am.onTheSpringFestivaOne==null?0:am.onTheSpringFestivaOne}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
<!-- 												<td style="width:152px;"> -->
<%-- 													<input style="width:120px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].onTheSpringFestivaTwo"  --%>
<%-- 														   id="onTheSpringFestivaTwo${vs.index}" value="<fmt:formatNumber type='number' value='${am.onTheSpringFestivaTwo==null?0:am.onTheSpringFestivaTwo}' pattern='0.0' maxFractionDigits='1' />"/> --%>
<!-- 												</td> -->
												<td style="width:152px;">
													<input style="width:120px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].nightShiftDays" 
														   id="nightShiftDays${vs.index}" value="<fmt:formatNumber type='number' value='${am.nightShiftDays==null?0:am.nightShiftDays}' pattern='0.0' maxFractionDigits='1' />"/>
												</td>
												<td style="width:76px;">
												     <select id="isDeparture${vs.index}" name="attendanceManagementList[${vs.index}].isDeparture" style="margin-top:5px;width:100px;">
														<option value="N" ${"N" == am.isDeparture  || null == am.isDeparture? 'selected="selected"' : '' }>N</option>
														<option value="Y" ${"Y" == am.isDeparture ? 'selected="selected"' : '' }>Y</option>
													</select>
												</td>
												<td style="width:64px;">
													<input style="width:46px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].casualLeave" 
														   id="casualLeave${vs.index}" value="<fmt:formatNumber type='number' value='${am.casualLeave==null?0:am.casualLeave}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width:64px;">
													<input style="width:46px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].absenteeism" 
														  id="absenteeism${vs.index}" value="<fmt:formatNumber type='number' value='${am.absenteeism==null?0:am.absenteeism}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width:64px;">
													<input style="width:46px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].sickLeave" 
														   id="sickLeave${vs.index}" value="<fmt:formatNumber type='number' value='${am.sickLeave==null?0:am.sickLeave}' pattern='0.0' maxFractionDigits='2' />"/>
														   
												</td>
												<td style="width:64px;">
													<input style="width:46px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].annualLeave" 
														   id="annualLeave${vs.index}" value="<fmt:formatNumber type='number' value='${am.annualLeave==null?0:am.annualLeave}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width:64px;">
													<input style="width:46px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].marriageLeave" 
														   id="marriageLeave${vs.index}" value="<fmt:formatNumber type='number' value='${am.marriageLeave==null?0:am.marriageLeave}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width:64px;">
													<input style="width:46px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].maternityLeave" 
														   id="maternityLeave${vs.index}" value="<fmt:formatNumber type='number' value='${am.maternityLeave==null?0:am.maternityLeave}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width:64px;">
													<input style="width:46px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].funeralLeave" 
														   id="funeralLeave${vs.index}" value="<fmt:formatNumber type='number' value='${am.funeralLeave==null?0:am.funeralLeave}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width:64px;">
													<input style="width:46px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].daysOff" 
														   id="daysOff${vs.index}" value="<fmt:formatNumber type='number' value='${am.daysOff==null?0:am.daysOff}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width:64px;">
													<input style="width:46px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].verbalWarnings" 
														   id="verbalWarnings${vs.index}" value="<fmt:formatNumber type='number' value='${am.verbalWarnings==null?0:am.verbalWarnings}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width:64px;">
													<input style="width:46px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].writtenWarning" 
														   id="writtenWarning${vs.index}" value="<fmt:formatNumber type='number' value='${am.writtenWarning==null?0:am.writtenWarning}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="width:95px;">
													<input style="width:75px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].majorAccident" 
														   id="majorAccident${vs.index}" value="<fmt:formatNumber type='number' value='${am.majorAccident==null?0:am.majorAccident}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td style="margin-top:5px;width:126px;">
													<select id="isAccomodate${vs.index}" style="width:90px;margin-top:5px;" name="attendanceManagementList[${vs.index}].isAccomodate">
														<option value="是" ${"是" == am.isAccomodate || null == am.isAccomodate ? 'selected="selected"' : '' }>是</option>
														<option value="否" ${"否" == am.isAccomodate ? 'selected="selected"' : '' }>否</option>
													</select>
												</td>
												<td style="margin-top:5px;width:128px;">
													<select id="isBoarder${vs.index}" style="width:90px;margin-top:5px;" name="attendanceManagementList[${vs.index}].isBoarder">
														<option value="是" ${"是" == am.isBoarder  || null == am.isBoarder? 'selected="selected"' : '' }>是</option>
														<option value="否" ${"否" == am.isBoarder ? 'selected="selected"' : '' }>否</option>
													</select>
												</td>
												<td style="width:114px;">
													<input style="width:90px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].splendorCardBlue" 
														   id="splendorCardBlue${vs.index}" value="<fmt:formatNumber type='number' value='${am.splendorCardBlue==null?0:am.splendorCardBlue}' pattern='0' maxFractionDigits='0' />"/>
												</td>
												<td style="width:114px;">
													<input style="width:90px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].splendorCardGreen" 
														   id="splendorCardGreen${vs.index}" value="<fmt:formatNumber type='number' value='${am.splendorCardGreen==null?0:am.splendorCardGreen}' pattern='0' maxFractionDigits='0' />"/>
												</td>
												<td  style="width:139px;">
													<input style="width:110px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].partTimeScale" 
														   id="partTimeScale${vs.index}" value="<fmt:formatNumber type='number' value='${am.partTimeScale==null?0:am.partTimeScale}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td  style="width:167px;">
													<input style="width:130px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].monthPerformance" 
														   id="monthPerformance${vs.index}" value="<fmt:formatNumber type='number' value='${am.monthPerformance==null?0:am.monthPerformance}' pattern='0.0' maxFractionDigits='2' />"/>
														   
												</td>
												<td  style="width:140px;">
													<input style="width:110px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].managerBonusScale" 
														   id="managerBonusScale${vs.index}" value="<fmt:formatNumber type='number' value='${am.managerBonusScale==null?0:am.managerBonusScale}' pattern='0.0' maxFractionDigits='2' />"/>
												</td>
												<td  style="width:127px;">
													<input style="width:100px;margin-top:5px;" type="text" name="attendanceManagementList[${vs.index}].remark" 
														   value="${am.remark}"/>
												</td>
												<td>
													<input style="width:70px;margin-top:5px;" type="hidden" name="attendanceManagementList[${vs.index}].yearMonth" 
														   value="${Flag.flag}" />
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
<!-- 						<table id="table_report" border="1px" style="width:3500px;border:1px solid #ddd;position:absolute!important;"> -->
							
<!-- 							<thead > -->
<!-- 								<tr style="background:linear-gradient(to bottom,#f8f8f8 0,#ececec 100%);"> -->
<!-- 									
<!-- 									<th class="center"style="width:70px;color:#707070" >油站名称</th> -->
<!-- 									<th class="center"style="width:75px;color:#707070">油站编号</th> -->
<!-- 									<th class="center"style="width:80px;color:#707070">地区类型</th> -->
<!-- 									<th class="center"style="width:75px;color:#707070">油站星级</th> -->
<!-- 									 --> 
<!-- 									<th class="center"style="width:33px;color:#707070">序号</th> -->
<!-- 									<th class="center"style="width:65px;color:#707070">员工编号</th> -->
<!-- 									<th class="center"style="width:65px;color:#707070">员工姓名</th> -->
<!-- 		                            <th class="center" style="width:60px;color:#707070">职务</th> -->
<!-- 									<th class="center"style="width:80px;color:#707070">入职日期</th> -->
<!-- 									<th class="center"style="width:44px;color:#707070">工作日</th> -->
<!-- 									<th class="center"style="width:100px;color:#707070">是否管站\带班</th> -->
<!-- 									<th class="center" style="width:100px;color:#707070">是否实习期内</th> -->
<!-- 									<th class="center" style="width:140px;color:#707070">本月实习期满后工作天数</th> -->
<!-- 									<th class="center" style="width:65px;color:#707070">平时超时</th> -->
<!-- 									<th class="center" style="width:65px;color:#707070">节日加班</th> -->
<!-- 									<th class="center" style="width:80px;color:#707070">年夜饭在岗</th> -->
<!-- 									<th class="center"style="width:120px;color:#707070">春节在岗（阶段一）</th> -->
<!-- 									<th class="center"style="width:120px;color:#707070">春节在岗（阶段二）</th> -->
<!-- 									<th class="center" style="width:60px;color:#707070">本月离职</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">事假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">旷工</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">病假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">年假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">婚假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">产假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">丧假</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">调休</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">警告</th> -->
<!-- 									<th class="center" style="width:50px;color:#707070">记过</th> -->
<!-- 									<th class="center" style="width:75px;color:#707070">重大事故</th> -->
<!-- 									<th class="center" style="width:100px;color:#707070">是否保留宿舍</th> -->
<!-- 									<th class="center" style="width:100px;color:#707070">是否搭伙</th> -->
<!-- 									<th class="center" style="width:90px;color:#707070">精彩卡-蓝色版</th> -->
<!-- 									<th class="center" style="width:90px;color:#707070">精彩卡-绿色版</th> -->
<!-- 									<th class="center" style="width:110px;color:#707070">兼职便利店员比例(%)</th> -->
<!-- 									<th class="center" style="width:130px;color:#707070">月度绩效<font color="red">（百分制）</font></th> -->
<!-- 									<th class="center" style="width:110px;color:#707070">经理奖金分配比例(%)</th> -->
<!-- 									<th class="center" style="width:100px;color:#707070">备注</th> -->
<!-- 									<th class="center" style="width:70px;color:#707070">月份</th> -->
<!-- 								</tr> -->
<!-- 							</thead> -->
<!-- 							</table> -->
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
	<a href="#" id="btn-scroll-up"style="position:fixed" class="btn btn-small btn-inverse"> <i
		class="icon-double-angle-up icon-only"></i>
	</a>
	<style>
		table tr:hover{background:#f9f9f9;}
		table tr:nth-child(odd){background:#F9F9F9;}
	</style>
</body>

</html>