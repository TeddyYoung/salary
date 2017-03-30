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
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<!-- 引入 -->
		<script src="static/1.9.1/jquery.min.js"></script>
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<script type="text/javascript">
		$(top.hangge());
		//新增
		function addmenu(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增菜单";
			 diag.URL = '<%=basePath%>menu/toAdd.do';
			 diag.Width = 223;
			 diag.Height = 256;
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
		function editmenu(id){
			 top.jzts();
		   	 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑菜单";
			 diag.URL = '<%=basePath%>menu/toEdit.do?id='+id;
			 diag.Width = 223;
			 diag.Height = 256;
			 diag.CancelEvent = function(){ //关闭事件
				if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					top.jzts(); 
					setTimeout("location.reload()",100);
				}
				diag.close();
			 };
			 diag.show();
		}
		//编辑顶部菜单图标
		function editTb(id){
			 top.jzts();
		   	 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑图标";
			 diag.URL = '<%=basePath%>menu/toEditicon.do?id='+id;
			 diag.Width = 530;
			 diag.Height = 150;
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
		function delmenu(id,menuName){
			bootbox.confirm("确定要删除["+menuName+"]吗?", function(result) {
				if(result) {
					var url = "<%=basePath%>menu/del.do?id="+id+"&guid="+new Date().getTime();
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
						}else if("false2" == data.result){
							top.hangge();
							bootbox.dialog("删除失败，请先删除此菜单下的子菜单!", 
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
		// 展开/折叠
		function openClose(id,curObj,trIndex){
			var txt = $(curObj).text();
			if(txt=="展开"){
				$(curObj).text("折叠");
				$("#tr"+id).after("<tr id='tempTr"+id+"'><td colspan='5' class='center'>数据载入中</td></tr>");
				if(trIndex%2==0){
					$("#tempTr"+id).addClass("main_table_even");
				}
				var url = "menu/sub.do?id="+id+"&guid="+new Date().getTime();
				$.get(url,function(data){
					if(data.length > 0 && data[0] != null && data[0] != '') {
						var html = "";
						$.each(data,function(i){
							html = "<tr style='height:24px;line-height:24px;' align='center' name='subTr"+id+"'>";
							html += "<td></td>";
							html += "<td class='center'><span style='width:80px;display:inline-block;'></span>";
							if(i==data.length-1)
								html += "<img src='static/images/joinbottom.gif' style='vertical-align: middle;'/>";
							else
								html += "<img src='static/images/join.gif' style='vertical-align: middle;'/>";
							html += "<span style='width:100px;text-align:left;display:inline-block;'>"+this.name+"</span>";
							html += "</td>";
							html += "<td>"+this.url+"</td>";
							html += "<td class='center'>"+this.orderby+"</td>";
							html += "<td><a class='btn btn-mini btn-info' title='编辑' onclick='editmenu(\""+this.id+"\")'>编辑</a> <a class='btn btn-mini btn-danger' title='删除' onclick='delmenu(\""+this.id+"\",false)'><i class='icon-trash'></i></a></td>";
							html += "</tr>";
							$("#tempTr"+id).before(html);
						});
						$("#tempTr"+id).remove();
						if(trIndex%2==0){
							$("tr[name='subTr"+id+"']").addClass("main_table_even");
						}
					}else{
						$("#tempTr"+id+" > td").html("没有相关数据");
					}
				},"json");
			}else{
				$("#tempTr"+id).remove();
				$("tr[name='subTr"+id+"']").remove();
				$(curObj).text("展开");
			}
		}
	</script>

</head>

<body>
	<div class="page_and_btn">
		<div>
			&nbsp;&nbsp;<a class="btn btn-mini btn-info" onclick="addmenu();">新增菜单</a>
		</div>
	</div>
	<table id="table_report" class="table table-striped table-bordered table-hover">
		<thead>
		<tr>
			<th class="center"  style="width: 50px;">序号</th>
			<th class='center'>名称</th>
			<th class='center'>资源路径</th>
			<th class='center'>排序</th>
			<th class='center'>操作</th>
		</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty parentMenu}">
				<c:forEach items="${parentMenu}" var="menu" varStatus="vs">
				<tr id="tr${menu.id}">
				<td class="center">${vs.index+1}</td>
				<td class='center'><i class="${menu.icon }">&nbsp;</i>${menu.name }&nbsp;
					<c:if test="${menu.title == '1' }">
					<span class="label label-success arrowed">系统</span>
					</c:if>
					<c:if test="${menu.title != '1' }">
					<span class="label label-important arrowed-in">业务</span>
					</c:if>
				</td>
				<td>${menu.url == '#'? '': menu.url}</td>
				<td class='center'>${menu.target }</td>
				<td style="width: 25%;">
				<a class='btn btn-mini btn-info' onclick="openClose('${menu.id}',this,${vs.index})" >展开</a>
				<a class='btn btn-mini btn-info' title="图标" onclick="editTb('${menu.id}')" >图标</a>
				<a class='btn btn-mini btn-info' title="编辑" onclick="editmenu('${menu.id}')" >编辑</a>
				<a class='btn btn-mini btn-danger' title="删除"  onclick="delmenu('${menu.id}','${menu.name}')"><i class='icon-trash'></i></a>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
				<td colspan="100">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	
</body>
</html>