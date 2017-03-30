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
		<title>油站星级</title>
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
		<!-- 日期控件 -->
		<script type="text/javascript" src="/datepicker/WdatePicker.js"></script>
</head>

<script type="text/javascript">
	$(top.hangge());
	//上传 （异步）
	function uploadPic(){
		//本次 jquery.form.js
		var options = {
				url : "/upload_uploadPic.do",
				type : "post",
				dataType : "json",
				success : function(data){
					//执行回调的程序 
					//img src = data.path 
					$("#allUrl").attr("src",data.path);
				}
		};
		//使用form
		$("#staffForm").ajaxSubmit(options);
		
	}
	//保存
	function save(){
		if($("#staffName").val()==""){
			
			$("#staffName").tips({
				side:3,
	            msg:'这里输入员工姓名',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#staffName").focus();
			return false;
		}     
		if($("#staffIdcard").val()==""){
			
			$("#staffIdcard").tips({
				side:3,
	            msg:'这里输入身份证号',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#staffIdcard").focus();
			return false;
		}     
		if($("#staffPhone").val()==""){
			
			$("#staffPhone").tips({
				side:3,
	            msg:'这里输入联系电话',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#staffPhone").focus();
			return false;
		}     
		$("#staffForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>


<body>
	<form  action="/staff_saveOrUpdate.do" name="staffForm" id="staffForm" method="post" >
		<input type="hidden" name="id" id="id" value="${staff.id}"/>
		<input type="hidden" name="staffCode" id="staffCode" value="${staff.staffCode }"/>
		<div id="zhongxin">
		<table>
			<tr>
				<td>员工姓名：</td><td><input type="text" name="staffName" id="staffName" placeholder="这里输入员工姓名" value="${staff.staffName }" title="员工姓名"/></td>
				<td>身份证号：</td><td><input type="text" name="staffIdcard" id="staffIdcard" placeholder="这里输入身份证号" value="${staff.staffIdcard }" title="身份证号"/></td>
			</tr>
			<tr>
				<td>联系电话：</td><td><input type="text" name="staffPhone" id="staffPhone" placeholder="这里输入联系电话" value="${staff.staffPhone }" title="联系电话"/></td>
				<td>员工性别：</td><td>
				<input type="radio" name="staffSex" value="0" ${staff.staffSex==0 ? 'checked="checked"' : '' } />男
				<input type="radio" name="staffSex" value="1" ${staff.staffSex==1 ? 'checked="checked"' : '' }/>女
				</td>
			</tr>
			<tr>
				<td>员工照片：</td><td><input type="file" value="${staff.staffPhoto}" onchange="uploadPic()"/><img id="allUrl" src="${staff.staffPhoto}"/></td>
				<td>员工状态：</td><td><select name="staffStatus" id="staffStatus" class="input_txt" title="员工状态">
								<option value="0">员工状态</option>
								<c:forEach items="${statusList}" var="status">
									<option value="${status.mark}" ${status.mark==staff.staffStatus ? 'selected="selected"' : '' } >${status.name}</option>
								</c:forEach>
							</select></td>
			</tr>
			<tr>
				<td>入职日期：</td><td><input type="text" style="width:90px;" name="staffInDate"
	             value="${staff.staffInDate}"
	             onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/></td>
				<td>离职日期：</td><td><input type="text" style="width:90px;" name="staffOutDate"
	             value="${staff.staffOutDate}"
	             onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/></td>
			</tr>
			<tr>
				<td>员工所属职务：</td><td><select name="dutyCode" id="dutyCode" class="input_txt" title="员工所属职务">
								<option value="null">职务列表</option>
								<c:forEach items="${dutyList}" var="duty">
									<option value="${duty.dutyCode}" ${duty.dutyCode==staff.dutyCode ? 'selected="selected"' : '' }>${duty.dutyName}</option>
								</c:forEach>
							</select></td>
				<td>员工所属油站：</td><td><select name="stationCode" id="stationCode" class="input_txt" title="员工所属油站">
								<option value="null">油站列表</option>
								<c:forEach items="${stationList}" var="station">
									<option value="${station.stationCode}" ${station.stationCode==staff.stationCode ? 'selected="selected"' : '' }>${station.stationName}</option>
								</c:forEach>
							</select></td>
			</tr>
			<tr>
				<td>备注：</td><td><textarea rows="4" cols="68" name="remark" id="remark" placeholder="备注" title="备注">${staff.remark}</textarea>
				</td>
			</tr>
			<tr><td>&nbsp;</td>
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