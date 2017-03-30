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
	<!-- jsp文件头和头部 -->
	<%@ include file="../admin/top.jsp"%>   
	</head>
<body>
		
<div class="container-fluid" id="main-container">

		
 <div id="page-content">
						
  <div class="row-fluid">

	<div class="row-fluid">
	
<!--	<div>
 	<div id="breadcrumbs">
		<table class="center" style="width:100%;">
			<tr height="35">
				<c:if test="${QX.addQx == 1 }">
				<td style="width:69px;"><a href="javascript:addRole();" class="btn btn-small btn-success">新增</a></td>
				</c:if> 
					<c:choose>
					<c:when test="${not empty depParts}">
					<c:forEach items="${depParts}" var="dep" varStatus="vs">
						<c:if test="${dep.pStorePart=='0'}">
						<td style="width:100px;" class="center" 
								<c:choose><c:when test="${dep.pStorePart== depPart.storePart}">bgcolor="#FFC926" onMouseOut="javascript:this.bgColor='#FFC926';"</c:when><c:otherwise>bgcolor="#E5E5E5" onMouseOut="javascript:this.bgColor='#E5E5E5';"</c:otherwise></c:choose>
							  	onMouseMove="javascript:this.bgColor='#FFC926';" >
							
							<a href="<%=basePath%>depPart/role.do?roleId=${dep.id }" style="text-decoration:none; display:block;">&nbsp;<font color="#666666">${dep.storePartName }</font></a>
						</td>
						<td style="width:5px;"></td>
						</c:if>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
						<td colspan="100">没有相关数据</td>
						</tr>
					</c:otherwise>
					</c:choose>
				<td></td>
			</tr>
		</table>
	</div>	
		<table>
			<tr height="7px;"><td colspan="100"></td></tr>
			<tr>
			<td><font color="#808080">本组：</font></td>
			<td>
			<c:if test="${true}">
			<a class="btn btn-mini btn-info" onclick="addRole();">新增组</a>
			<a class="btn btn-mini btn-info" onclick="addRole2('${depPart.storePart }');">新增角色</a>
			<a class="btn btn-mini btn-info" onclick="editRole('${depPart.id }');">修改组名称</a>
			</c:if>
				<c:choose> 
					<c:when test="${false}">
					</c:when>
					<c:otherwise>
					 <c:if test="${true}">
					 <a class='btn btn-mini btn-danger' title="删除" onclick="delRole('${pd.ROLE_ID }','z','${pd.roleName }');"><i class='icon-trash'></i></a>
					 <a class='btn btn-mini btn-danger' title="删除" onclick="delRole('${depPart.id }','c','${depPart.storePartName }');"><i class='icon-trash'></i></a>
					 </c:if>
					</c:otherwise>
				</c:choose>
			</td>
			</tr>
			<tr height="7px;"><td colspan="100"></td></tr>
		</table>
		
		
	</div> --%>-->
	<table id="table_report" class="table table-striped table-bordered table-hover">
		<thead>
		<tr>
			<th class="center" style="width: 30px">序号</th>
			<th class="center">角色</th>
			<c:if test="${true}">
			</c:if>
			<th class="center">操作</th>
		</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty depParts}">
				<c:if test="${true }">
				<c:forEach items="${depParts}" var="var" varStatus="vs">
				<%-- <c:forEach items="${gysqxlist}" var="varG" varStatus="vsG">
					<c:if test="${var.qxId == varG.U_ID }">
						<c:set value="${varG.C1 }" var="c1"></c:set>
						<c:set value="${varG.C2 }" var="c2"></c:set>
						<c:set value="${varG.Q1 }" var="q1"></c:set>
						<c:set value="${varG.Q2 }" var="q2"></c:set>
					</c:if>
				</c:forEach> --%>
				
				<tr>
				<td class='center' style="width:30px;">${vs.index+1}</td>
				<td class="center" id="roleNameTd${var.id }">${var.storePartName }</td>
				
				<td class="center" style="width:255px;">
				
				<c:if test="${false}">
				<div style="width:100%;" class="center">
				<span class="label label-large label-grey arrowed-in-right arrowed-in"><i class="icon-lock" title="无权限"></i></span>
				</div>
				</c:if>
				
				<c:if test="${true}">
				<a class="btn btn-mini btn-info" onclick="editRights('${var.id }');">菜单权限</a>
		<%-- 		<a class='btn btn-mini btn-info' title="编辑" onclick="editRole('${var.id }');">编辑</a> --%>
				</c:if>
				<%-- <c:choose> 
					<c:when test="${false}">
					</c:when>
					<c:otherwise>
					 <c:if test="${true}">
					 <a class='btn btn-mini btn-danger' title="删除" onclick="delRole('${var.id }','c','${var.storePartName }');"><i class='icon-trash'></i></a>
					 </c:if>
					</c:otherwise>
				</c:choose> --%>
				</tr>
				</c:forEach>
				</c:if>
						<c:if test="${false}">
							<tr>
								<td colspan="100" class="center">您无权查看</td>
							</tr>
						</c:if>
			</c:when>
			<c:otherwise>
				<tr>
				<td colspan="100" class="center" >没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
 
 
 
 
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
	
</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->
		
		<!-- 返回顶部  -->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
		
		<!-- 引入 -->
		<script src="static/1.9.1/jquery.min.js"></script>
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		
		<script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<!-- 引入 -->
		<script type="text/javascript">
		
		top.hangge();
		
		//新增组
		function addRole(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增组";
			 diag.URL = '<%=basePath%>depPart/toAdd.do?pStorePart=0';
			 diag.Width = 222;
			 diag.Height = 90;
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					top.jzts();
					setTimeout("self.location.reload()",100);
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//新增角色
		function addRole2(pStorePart){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增角色或组";
			 diag.URL = '<%=basePath%>depPart/toAdd.do?pStorePart='+pStorePart;
			 diag.Width = 222;
			 diag.Height = 90;
			 diag.CancelEvent = function(){ //关闭事件
				if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					top.jzts();
					setTimeout("self.location.reload()",100);
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//修改
		function editRole(ROLE_ID){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = '<%=basePath%>depPart/toEdit.do?roleId='+ROLE_ID;
			 diag.Width = 222;
			 diag.Height = 90;
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					top.jzts();
					setTimeout("self.location.reload()",100);
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//删除
		function delRole(ROLE_ID,msg,roleName){
			bootbox.confirm("确定要删除["+roleName+"]吗?", function(result) {
				if(result) {
					var url = "<%=basePath%>depPart/delete.do?depPartId="+ROLE_ID+"&guid="+new Date().getTime();
					top.jzts();
					$.get(url,function(data){
						if("success" == data.result){
							if(msg == 'c'){
								top.jzts();
								document.location.reload();
							}else{
								top.jzts();
								window.location.href="/role.do";
							}
							
						}else if("false" == data.result){
							top.hangge();
							bootbox.dialog("删除失败，请先删除此管理下的角色!", 
									[
									  {
										"label" : "关闭",
										"class" : "btn btn-mini btn-info",
										"callback": function() {
											//Example.show("great success");
											}
										}]
								);
						}else if("false2" == data.result){
							top.hangge();
							bootbox.dialog("删除失败，请先删除此职位下的用户!", 
									[
									  {
										"label" : "关闭",
										"class" : "btn btn-mini btn-info",
										"callback": function() {
											//Example.show("great success");
											}
										}]
								);
						}
					});
				}
			});
		}
		
		</script>
		
		<script type="text/javascript">

	
		//扩展权限 ==============================================================
		var hcid1 = '';
		var qxhc1 = '';
		function kf_qx1(id,kefu_id,msg){
			if(id != hcid1){
				hcid1 = id;
				qxhc1 = '';
			}
			var value = 1;
			var wqx = $("#"+id).attr("checked");
			if(qxhc1 == ''){
				if(wqx == 'checked'){
					qxhc1 = 'checked';
				}else{
					qxhc1 = 'unchecked';
				}
			}
			if(qxhc1 == 'checked'){
				value = 0;
				qxhc1 = 'unchecked';
			}else{
				value = 1;
				qxhc1 = 'checked';
			}
				var url = "<%=basePath%>role/kfqx.do?kefu_id="+kefu_id+"&msg="+msg+"&value="+value+"&guid="+new Date().getTime();
				$.get(url,function(data){
					if(data=="success"){
						//document.location.reload();
					}
				});
		}
		
		var hcid2 = '';
		var qxhc2 = '';
		function kf_qx2(id,kefu_id,msg){
			if(id != hcid2){
				hcid2 = id;
				qxhc2='';
			}
			var value = 1;
			var wqx = $("#"+id).attr("checked");
			if(qxhc2 == ''){
				if(wqx == 'checked'){
					qxhc2 = 'checked';
				}else{
					qxhc2 = 'unchecked';
				}
			}
			if(qxhc2 == 'checked'){
				value = 0;
				qxhc2 = 'unchecked';
			}else{
				value = 1;
				qxhc2 = 'checked';
			}
				var url = "<%=basePath%>role/kfqx.do?kefu_id="+kefu_id+"&msg="+msg+"&value="+value+"&guid="+new Date().getTime();
				$.get(url,function(data){
					if(data=="success"){
						//document.location.reload();
					}
				});
		}
		
		var hcid3 = '';
		var qxhc3 = '';
		function kf_qx3(id,kefu_id,msg){
			if(id != hcid3){
				hcid3 = id;
				qxhc3='';
			}
			var value = 1;
			var wqx = $("#"+id).attr("checked");
			if(qxhc3 == ''){
				if(wqx == 'checked'){
					qxhc3 = 'checked';
				}else{
					qxhc3 = 'unchecked';
				}
			}
			if(qxhc3 == 'checked'){
				value = 0;
				qxhc3 = 'unchecked';
			}else{
				value = 1;
				qxhc3 = 'checked';
			}
				var url = "<%=basePath%>role/kfqx.do?kefu_id="+kefu_id+"&msg="+msg+"&value="+value+"&guid="+new Date().getTime();
				$.get(url,function(data){
					if(data=="success"){
						//document.location.reload();
					}
				});
		}
		
		var hcid4 = '';
		var qxhc4 = '';
		function kf_qx4(id,kefu_id,msg){
			if(id != hcid4){
				hcid4 = id;
				qxhc4='';
			}
			var value = 1;
			var wqx = $("#"+id).attr("checked");
			if(qxhc4 == ''){
				if(wqx == 'checked'){
					qxhc4 = 'checked';
				}else{
					qxhc4 = 'unchecked';
				}
			}
			if(qxhc4 == 'checked'){
				value = 0;
				qxhc4 = 'unchecked';
			}else{
				value = 1;
				qxhc4 = 'checked';
			}
				var url = "<%=basePath%>role/kfqx.do?kefu_id="+kefu_id+"&msg="+msg+"&value="+value+"&guid="+new Date().getTime();
				$.get(url,function(data){
					if(data=="success"){
						//document.location.reload();
					}
				});
		}
		
		//保存信件数
		function c1(id,msg,value,kefu_id){
				if(isNaN(Number(value))){
					alert("请输入数字!");
					$("#"+id).val(0);
					return;
				}else{
				var url = "<%=basePath%>role/gysqxc.do?kefu_id="+kefu_id+"&msg="+msg+"&value="+value+"&guid="+new Date().getTime();
				$.get(url,function(data){
					if(data=="success"){
						//document.location.reload();
					}
				});
				}
		}
		
		//菜单权限
		function editRights(ROLE_ID){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag = true;
			 diag.Title = "菜单权限";
			 diag.URL = '<%=basePath%>depPart/auth.do?roleId='+ROLE_ID;
			 diag.Width = 280;
			 diag.Height = 370;
			 diag.CancelEvent = function(){ //关闭事件
				diag.close();
			 };
			 diag.show();
		}
		
		//按钮权限
		function roleButton(ROLE_ID,msg){
			top.jzts();
			if(msg == 'add_qx'){
				var Title = "授权新增权限";
			}else if(msg == 'del_qx'){
				Title = "授权删除权限";
			}else if(msg == 'edit_qx'){
				Title = "授权修改权限";
			}else if(msg == 'cha_qx'){
				Title = "授权查看权限";
			}
			
			 var diag = new top.Dialog();
			 diag.Drag = true;
			 diag.Title = Title;
			 diag.URL = '<%=basePath%>role/button.do?ROLE_ID='+ROLE_ID+'&msg='+msg;
			 diag.Width = 200;
			 diag.Height = 370;
			 diag.CancelEvent = function(){ //关闭事件
				diag.close();
			 };
			 diag.show();
		}
		
		</script>
	</body>
</html>

