<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/public.jsp"  %>
<%@ page import="com.ftc.freemall.vo.SysMenuVO" %>
<%@ page import="java.net.URLDecoder" %>

<%
	String menuid = "11";
	if(request.getParameter("menuid") != null && !request.getParameter("menuid").toString().trim().equals(""))
	{
		menuid = request.getParameter("menuid").toString().trim();
		session.setAttribute("memuid",menuid);
	}
	if(session.getAttribute("memuid") != null)
	{
		menuid = String.valueOf(session.getAttribute("memuid"));
	}
	
	List<SysMenuVO> assessSysMenuList =new ArrayList<SysMenuVO>();
	if(session.getAttribute("menuList")!=null){
	        assessSysMenuList = (List<SysMenuVO>)session.getAttribute("menuList");
	}
	
%>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<div class="navbar-brand"><span>零元汇</span>合伙人平台</div>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span><%=session.getAttribute("trueName")%><span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<!-- <li><a href="<%=context%>/userLoginlist.do?method=pwd&isnew=Y"><span class="glyphicon glyphicon-user"></span>修改密码</a></li> -->
							<!-- <li><a href="user.html"><span class="glyphicon glyphicon-cog"></span>设置</a></li> -->
							<li><a href="<%=context%>/userLoginlist.do?method=logout"><span class="glyphicon glyphicon-log-out"></span>登出</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		 <form name="searchs" role="search"> 
			<div class="form-group">
				菜单导航
			</div>
		</form>
		<ul class="nav menu">
			<%
			for(int i=0; i<assessSysMenuList.size(); i++){
				SysMenuVO assessSysMenuVO = assessSysMenuList.get(i);
			%>
			<!-- <li>
				<a href="ranking.html"><span class="glyphicon glyphicon-home"></span>首页</a>
			</li>
			<li><a href="order.html"><span class="glyphicon glyphicon-list-alt"></span>订单查询</a></li>
			<li><a href="geturl.html"><span class="glyphicon glyphicon-share"></span>申领推广链接</a></li>
			<li><a href="appeal.html"><span class="glyphicon glyphicon-earphone"></span>申诉</a></li>
			<li><a href="user.html"><span class="glyphicon glyphicon-user"></span>个人设置</a></li> -->
			<li>
				<a href="<%=context%><%=assessSysMenuVO.getMenuUrl()%>&agentID=<%=session.getAttribute("userId") %>&menuNme=<%=assessSysMenuVO.getMenuNme() %>&menuId=<%=assessSysMenuVO.getMenuId() %>"><span class="<%=assessSysMenuVO.getClassName() %>"></span><%=URLDecoder.decode(assessSysMenuVO.getMenuNme(),"UTF-8") %></a>
			</li>
			<%
			}
			%>
			<li role="presentation" class="divider"></li>
		</ul>
		<div class="attribution">copy right &copy;版权归零元汇所有</div>
	</div><!--/.sidebar-->
	
  <%-- <script language="javascript">
  //	document.getElementsByName("menumain")[<%=(Integer.parseInt(menuid)-11)%>].className = "line_on_li";  //设置菜单颜色
//	document.getElementById('menumain'+'<%=(Integer.parseInt(menuid))%>').className = "line_on_li";
//	function helponclick(){
 // 		alert("该功能暂未开放");
  //	}
  	
	ddsmoothmenu.init({
		mainmenuid: "smoothmenu1", //menu DIV id
		orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname: 'ddsmoothmenu', //class added to menu's outer DIV
		contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
	})
  </script>
  
  <div id="smoothmenu1" class="ddsmoothmenu">
		<ul>
			<%
				for(int i=0; i<assessSysMenuList.size(); i++){
					int ulstart = 0;
					int ulend = 0;
					SysMenuVO assessSysMenuVO = assessSysMenuList.get(i);
					
					if("1".equals(String.valueOf(assessSysMenuVO.getMenuLevel().intValue()))){			%>			 
						<li id="firstpage">
						<%
							if(assessSysMenuVO.getMenuUrl()==null || "".equals(assessSysMenuVO.getMenuUrl()) || "#".equals(assessSysMenuVO.getMenuUrl())){
								%>								 
								<a href="#"><%=assessSysMenuVO.getMenuNme() %></a>
								<%
							} else {
								%>							  				 						 						 
								<a href="<%=context%><%=assessSysMenuVO.getMenuUrl()%>&agentID=<%=session.getAttribute("userId") %>&menuNme=<%=assessSysMenuVO.getMenuNme() %>&menuId=<%=assessSysMenuVO.getMenuId() %>"><%=URLDecoder.decode(assessSysMenuVO.getMenuNme(),"UTF-8")   %></a>
								<input type="hidden" name="menuNme" value="<%=assessSysMenuVO.getMenuNme() %>"/>
								<input type="hidden" name="menuId" value="<%=assessSysMenuVO.getMenuId() %>"/>
								<%
							}
						%>
							<%
								for(int j=0; j<assessSysMenuList.size(); j++){
									SysMenuVO assessSysMenuVO2 = assessSysMenuList.get(j);
									if("2".equals(String.valueOf(assessSysMenuVO2.getMenuLevel().intValue())) && assessSysMenuVO2.getParentId().equals(assessSysMenuVO.getMenuId())){
										if(ulstart == 0){
											%>
											<ul>
											<%
										}
							%>
											<%
												if(assessSysMenuVO2.getMenuUrl()==null || "".equals(assessSysMenuVO2.getMenuUrl()) || "#".equals(assessSysMenuVO2.getMenuUrl())){
													%>													
														<li><a href="#"><%=assessSysMenuVO2.getMenuNme() %></a></li>
													<%
												}else{
													%>													
														<li>														
															<a href="<%=context%><%=assessSysMenuVO2.getMenuUrl() %>&agentID=<%=session.getAttribute("userId") %>&menuNme=<%=assessSysMenuVO2.getMenuNme() %>&menuId=<%=assessSysMenuVO2.getMenuId() %>"><%=assessSysMenuVO2.getMenuNme() %></a>
															<input type="hidden" name="menuNme" value="<%=assessSysMenuVO2.getMenuNme() %>"/>
															<input type="hidden" name="menuId" value="<%=assessSysMenuVO2.getMenuId() %>"/>
														</li>
													<%
												}
											%>
							<%
										ulstart++;
										ulend++;
									}
								}
								if(ulend > 0){
									%>
									</ul>
									<%
								}
							%>
						</li>
			<%
					}
				}
			%>
			
		</ul>
		<br style="clear: left" />
	</div> --%>