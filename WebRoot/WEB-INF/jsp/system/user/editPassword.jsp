<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
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
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<!--提示框-->
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
		<script type="text/javascript">
			$(top.hangge());
			//保存
			function save(){
				if($("#password").val()==""){
					$("#password").tips({
						side:3,
			            msg:'请输入原密码',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#password").focus();
					return false;
				}
				if($("#newPassword").val()==""){
                    $("#newPassword").tips({
                        side:3,
                        msg:'请输入新密码',
                        bg:'#AE81FF',
                        time:2
                    });
                    $("#newPassword").focus();
                    return false;
                }
				if($("#checkPassword").val()==""){
                    $("#checkPassword").tips({
                        side:3,
                        msg:'请输入确认新密码',
                        bg:'#AE81FF',
                        time:2
                    });
                    $("#checkPassword").focus();
                    return false;
                }
				if($("#newPassword").val()!=$("#checkPassword").val()){
					$("#checkPassword").tips({
						side:3,
			            msg:'两次密码不相同',
			            bg:'#AE81FF',
			            time:3
			        });
					$("#chkpwd").focus();
					return false;
				}
			    $("#userForm").submit();
			    $("#zhongxin").hide();
			    $("#zhongxin2").show();
			}
		 </script>
	</head>
	<body>
		<form action="staff/editPassword.do" name="userForm" id="userForm" method="post">
			<div id="zhongxin">
			<table class="table table-striped table-bordered table-hover">
				<tr>
				    <td style="width:120px;text-align: right;padding-top: 13px;">原密码</td>
					<td style="text-align: center"><input type="password"  name="userpwd"  id="password"  maxlength="32"  placeholder="输入原密码" title="原密码"/></td>
				</tr>
				<tr>
				    <td style="width:120px;text-align: right;padding-top: 13px;">新密码</td>
					<td style="text-align: center"><input type="password" name="newPassword"  id="newPassword"  maxlength="32"  placeholder="输入新密码"  title="输入新密码"/></td>
				</tr>
				<tr>
				    <td style="width:120px;text-align: right;padding-top: 13px;">确认密码</td>
					<td style="text-align: center"><input type="password" name="checkPassword"  id="checkPassword"  maxlength="32"  placeholder="确认新密码"  title="确认新密码" /></td>
				</tr>
				<tr>
					<td style="text-align: center" colspan="2">
						<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
						<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
					</td>
				</tr>
			</table>
			</div>
			<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
		</form>
			<!-- 引入 -->
			<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
			<script src="static/js/bootstrap.min.js"></script>
			<script src="static/js/ace-elements.min.js"></script>
			<script src="static/js/ace.min.js"></script>
			<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
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