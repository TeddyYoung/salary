<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<title>加油站薪酬管理系统</title>
	<meta charset="UTF-8" />
	<meta name="renderer" content="webkit">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<link rel="stylesheet" href="static/login/bootstrap.min.css" />
	<link rel="stylesheet" href="static/login/css/camera.css" />
	<link rel="stylesheet" href="static/login/bootstrap-responsive.min.css" />
	<link rel="stylesheet" href="static/login/matrix-login.css" />
	<link href="static/login/font-awesome.css" rel="stylesheet" />
	
	<script type="text/javascript" src="static/js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
	// 选择所属部门
	function changeOrganise(){
		var organiseId = $.trim($("#organiseId").val());
		var userId = $.trim($("#userId").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath %>login_default2.do',
	    	data: {organiseId:organiseId,userId:userId},
			dataType:'json',
			cache: false,
			success: function(data){
				var userDepPartList = data.userDepPartList;
				var htmlStr = "";
				for (var i=0; i < userDepPartList.length; i++) {
					htmlStr = htmlStr 
					+ 		"<option value=" + userDepPartList[i].id + ">" 
					+ 		userDepPartList[i].storePartName
					+		"</option>";
					
				}
				var depPartId = $("#depPartId");
				depPartId.html(htmlStr);
			}
		});
	}
	
	function submitRole() {
		$("#loginForm").submit();
	}
	
	function onkeydown() {
		if (event.keyCode == 13) {
			$("#to-recover").click();
		}
	}
	</script> 
	</head>
	<body style="background-image:url(static/login/images/banner_slide_01.jpg);background-size:cover;" onkeydown="onkeydown();">
		<div style="width:100%;text-align: center;margin: 0 auto;position: absolute;">
			<div id="loginbox">
				<form action="submitRole.do" method="post" name="loginForm" id="loginForm">
					<div class="control-group normal_text">
						<h4>请选择您要登陆的部门及角色</h4>
					</div>
					<input type="hidden" id="userId" value="${userId}" name="userId" />
					<div class="control-group">
						<div class="controls">
							<div class="main_input_box"style="margin-top:-35px;">
<!-- 								<span class="add-on bg_lg"> -->
<!-- 									<i><img height="37" src="static/login/user.png" /></i> -->
<!-- 								</span> -->
								<select onchange="changeOrganise();" name="organiseId" id="organiseId" class="chzn-select" data-placeholder="请选择部门" style="vertical-align:top;width: 220px;" title="所属部门">
									<c:forEach items="${userOrganiseCOList}" var="organise" varStatus="vs">
										<option value="${organise.organiseId}">${organise.organiseName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<div class="main_input_box"style="margin-top:-35px;">
<!-- 								<span class="add-on bg_ly"> -->
<!-- 									<i><img height="37" src="static/login/suo.png" /></i> -->
<!-- 								</span> -->
								<select name="depPartId" id="depPartId" class="chzn-select" data-placeholder="请选择角色" style="vertical-align:top;width: 220px;" title="所属角色">
									<c:forEach items="${userRoleList}" var="userRole" varStatus="vs">
										<option value="${userRole.id}">${userRole.storePartName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-actions">
						<div style="width:86%;padding-left:8%;">
							<span class="pull-right">
								<a onclick="submitRole();" class="flip-link btn btn-info" id="to-recover">确定</a>
							</span>
						</div>
					</div>
				</form>
			</div>
		</div>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/jquery-1.7.2.js"></script>
		<script src="static/login/js/jquery.easing.1.3.js"></script>
		<script src="static/login/js/jquery.mobile.customized.min.js"></script>
		<script src="static/login/js/camera.min.js"></script>
		<script src="static/login/js/templatemo_script.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript" src="static/js/jquery.cookie.js"></script>
	</body>
</html>