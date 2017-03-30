<div class="navbar navbar-inverse">
    <div class="navbar-inner">
        <div class="container-fluid"style="margin-top:4px;">
            <small>
                <img  src="static/login/images/0.png"style="margin-right: 120px; vertical-align: -10px;"/><b style="font-size: 25px; color: white;">加油站薪酬管理系统</b>
            </small> 
            <ul class="nav ace-nav pull-right">
                <li class="light-blue user-profile">
                    <a class="user-menu dropdown-toggle" href="javascript:;" data-toggle="dropdown"style="margin-top:12px;">
                        <img alt="FH" src="static/avatars/user.jpg" class="nav-user-photo" />
                        <span id="user_info" style="top: 13px;">${sessionScope._CURRENT_USER.username}</span>
                        <span id="user_info" style="top: 13px;">${sessionScope._OrganiseCO.organiseName}</span>
                        <i class="icon-caret-down"></i>
                    </a>
                    <ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
                        <li><a onclick="editPassword();" style="cursor:pointer;"><i class="icon-user"></i> 修改密码</a></li>
                        <!-- <li class="divider"></li> -->
                        <li><a href="logout_logout.do"><i class="icon-off"></i> 退出</a></li>
                    </ul>
                </li>
            </ul><!--/.ace-nav-->
        </div><!--/.container-fluid-->
    </div><!--/.navbar-inner-->
</div><!--/.navbar-->
<!--引入属于此页面的js -->
<script type="text/javascript" src="static/js/myjs/head.js"></script>
<script type="text/javascript">
		// 修改密码
        function editPassword(){
             top.jzts();
             var diag = new top.Dialog();
             diag.Drag=true;
             diag.Title ="修改密码";
             diag.URL = '<%=basePath%>staff/toEditPwd.do';
             diag.Width = 400;
             diag.Height = 300;
             diag.CancelEvent = function(){//关闭事件
 				diag.close();
             };
             diag.show();
        }
</script>