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
		<title>菜单</title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>	
		<!--提示框-->
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
		<script type="text/javascript">
			$(top.hangge());	
			$(document).ready(function(){
					if($("#menuId").val()!=""){
						var parentId = $("#pId").val();
						if(parentId=="0"){
							$("#parentId").attr("disabled",true);
						}else{
							$("#parentId").val(parentId);
							$("#form-field-radio1").attr("disabled",true);
							$("#form-field-radio2").attr("disabled",true);
							$("#form-field-radio1").attr("checked",false);
							$("#form-field-radio2").attr("checked",false);
						}
					}
				});
				
				var menuUrl = "";
				function setMUR(){
					menuUrly = $("#menuUrl").val();
					if(menuUrly != ''){menuUrl = menuUrly;}
					if($("#parentId").val()=="0"){
						$("#menuUrl").attr("readonly",true);
						$("#menuUrl").val("");
						$("#form-field-radio1").attr("disabled",false);
						$("#form-field-radio2").attr("disabled",false);
					}else{
						$("#menuUrl").attr("readonly",false);
						$("#menuUrl").val(menuUrl);
						$("#form-field-radio1").attr("disabled",true);
						$("#form-field-radio2").attr("disabled",true);
						$("#form-field-radio1").attr("checked",false);
						$("#form-field-radio2").attr("checked",false);
					}
				}
				
				//保存
				function save(){
					if($("#menuName").val()==""){
						
						$("#menuName").tips({
							side:3,
				            msg:'请输入菜单名称',
				            bg:'#AE81FF',
				            time:2
				        });
						
						$("#menuName").focus();
						return false;
					}
					if($("#menuUrl").val()==""){
						$("#menuUrl").val('');
					}
					if($("#menuOrder").val()==""){
						
						$("#menuOrder").tips({
							side:1,
				            msg:'请输入菜单序号',
				            bg:'#AE81FF',
				            time:2
				        });
						
						$("#menuOrder").focus();
						return false;
					}
					
					if(isNaN(Number($("#menuOrder").val()))){
						
						$("#menuOrder").tips({
							side:1,
				            msg:'请输入菜单序号',
				            bg:'#AE81FF',
				            time:2
				        });
						
						$("#menuOrder").focus();
						$("#menuOrder").val(1);
						return false;
					}
					
					$("#menuForm").submit();
					$("#zhongxin").hide();
					$("#zhongxin2").show();
				}
				
				function setType(value){
					$("#title").val(value);
				}
		</script>
		
	</head>
	
	<body>
		<form action="menu/edit.do" name="menuForm" id="menuForm" method="post">
			<input type="hidden" name="id" id="menuId" value="${menu.id}"/>
			<input type="hidden" name="pId" id="pId" value="${menu.pid}"/>
			<input type="hidden" name="title" id="title" value="${menu.title }"/>
			<div id="zhongxin">
			<table>
				<tr>
					<td>
						<select name="pid" id="parentId" onchange="setMUR()" title="菜单">
							<option value="0">顶级菜单</option>
							<c:forEach items="${parentMenu}" var="parentM">
								<option value="${parentM.id }">${parentM.name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td><input type="text" name="name" id="menuName" placeholder="这里输入菜单名称" value="${menu.name }" title="名称"/></td>
				</tr>
				<tr>
					<td><input type="text" name="url" id="menuUrl" placeholder="这里输入链接地址" value="${menu.url }" title="地址"/></td>
				</tr>
				<tr>
					<td><input type="number" name="orderby" id="menuOrder" placeholder="这里输入序号" value="${menu.orderby}" title="序号"/></td>
				</tr> 
				<tr>
					<td style="text-align: center;">
						<label style="float:left;padding-left: 32px;"><input name="form-field-radio" id="form-field-radio1" onclick="setType('1');" <c:if test="${menu.title == '1' }">checked="checked"</c:if> type="radio" value="icon-edit"><span class="lbl">系统菜单</span></label>
						<label style="float:left;padding-left: 5px;"><input name="form-field-radio" id="form-field-radio2" onclick="setType('2');" <c:if test="${menu.title != '1' }">checked="checked"</c:if> type="radio" value="icon-edit"><span class="lbl">业务菜单</span></label>
					</td>
				</tr>
				<tr>
				<td style="text-align: center; padding-top: 10px;">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
			</table>
			</div>
			<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
		</form>
	</body>
</html>