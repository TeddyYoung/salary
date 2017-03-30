<%
	String pathl = request.getContextPath();
	String basePathl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathl+"/";
%>
		<div id="sidebar" class="menu-min" style="overflow-y: scroll;overflow-x:hidden;height:100%;">
				<ul class="nav nav-list">

					<li class="active" id="fhindex">
					  <a><i class="icon-dashboard"></i><span>后台首页</span></a>
					</li>
			<c:forEach items="${menuList}" var="menu">
				<li id="lm${menu.id }">
					  <a style="cursor:pointer;" class="dropdown-toggle" >
						<i class="${menu.icon == null ? 'icon-desktop' : menu.icon}"></i>
						<span>${menu.name }</span>
						<b class="arrow icon-angle-down"></b>
					  </a>
					  <ul class="submenu">
							<c:forEach items="${menu.subMenu}" var="sub">
								<c:choose>
									<c:when test="${not empty sub.url}">
									<li id="z${sub.id }">
									<a style="cursor:pointer;" target="mainFrame"  onclick="siMenu('z${sub.id }','lm${menu.id }','${sub.name }','${sub.url }')"><i class="icon-double-angle-right"></i>${sub.name }</a></li>
									</c:when>
									<c:otherwise>
									<li><a href="javascript:void(0);"><i class="icon-double-angle-right"></i>${sub.name }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
				  		</ul>
				</li>
			</c:forEach>

				</ul><!--/.nav-list-->

				<div id="sidebar-collapse"><i class="icon-double-angle-left"></i></div>

			</div><!--/#sidebar-->

