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

<style type="text/css">
.menuup {
color: #FF0000;
}
.menudown {
color: #000000;
}
</style>

<div class="top_img">
	<div style="float:left;margin-left:0px;"></div>
	<div style="float:left;margin-left:90px;margin-top:10px;" id="taskalert"  name="taskalert">
	</div>

</div>	
	<div style="width:980px; margin:0 auto; height:20px;">
		<ul class="top_ul">
				 
			<li><a href="<%=context%>/userLoginlist.do?method=pwd&isnew=Y">修改密码</a></li>
			<!--<li>|</li>-->
			<!--<li><a href="#" onclick="javascript:helponclick();">操作帮助</a></li>-->
			<li>|</li>
			<li><a href="<%=context%>/userLoginlist.do?method=logout">退出系统</a></li>
			<li>|</li>
			<li>操作员 : <%=session.getAttribute("trueName")%></li>    
		</ul>
		<!-- <div class="top_text"></div> -->
	</div>
	<%--
    <div class="line_ul_div" >
		<ul class="line_ul" >	
			<%
			String role = "";
			
			if(session.getAttribute("empModules") != null)
			{
				role = session.getAttribute("empModules").toString();
			}
			if("admin".equalsIgnoreCase(user.getUserCde()) || role.indexOf("1") >= 0)
			{
			%>
			<li  class="line_up_li" id="menumain11" name="menumain" ><a href="<%=context%>/info.do?mhd=toList&menuid=11">公告消息</a></li>
			<li class="line_li" >|</li>
			<%
			}
			if("admin".equalsIgnoreCase(user.getUserCde()) || role.indexOf("2") >= 0)
			{
			%>
			<li  class="line_up_li" id="menumain12" name="menumain" ><a href="<%=context%>/ad.do?mhd=toList&menuid=12" >首页图片</a></li>
			<li class="line_li">|</li>
			<%
			}
			if("admin".equalsIgnoreCase(user.getUserCde()) || role.indexOf("3") >= 0)
			{
			%>
			<li  class="line_up_li" id="menumain13" name="menumain" ><a href="<%=context%>/version.do?mhd=toList&menuid=13" >版本管理</a></li>
			<li class="line_li">|</li>
			<%
			}
			if("admin".equalsIgnoreCase(user.getUserCde()) || role.indexOf("4") >= 0)
			{
			%>
			<li  class="line_up_li" id="menumain14" name="menumain" ><a href="<%=context%>/product.do?mhd=toList&menuid=14" >产品管理</a></li>
			<li class="line_li">|</li>
			<%
			}
			if("admin".equalsIgnoreCase(user.getUserCde()) || role.indexOf("5") >= 0)
			{
			%>
			<li  class="line_up_li" id="menumain15" name="menumain" ><a href="<%=context%>/sync.jsp?menuid=15">数据同步</a>
			<li class="line_li">|</li>
			<%
			}
			if("admin".equalsIgnoreCase(user.getUserCde()) || role.indexOf("6") >= 0)
			{
			%>
			<li  class="line_up_li" id="menumain16" name="menumain" ><a href="<%=context%>/transaction.do?mhd=toList&menuid=16">交易清单</a></li>
			<li class="line_li">|</li>
			<%
			}
			if("admin".equalsIgnoreCase(user.getUserCde()) || role.indexOf("7") >= 0)
			{
			%>
			<li  class="line_up_li" id="menumain17" name="menumain" ><a href="<%=context%>/user/unemp.do?mhd=toList&menuid=17" >用户管理</a></li>
			<li class="line_li">|</li>
			<%
			}
			if("admin".equalsIgnoreCase(user.getUserCde()) || role.indexOf("8") >= 0)
			{
			%>
			<li  class="line_up_li" id="menumain18" name="menumain" ><a href="<%=context%>/client/usermodule.do?mhd=toClientInsert&menuid=18"  >权限管理</a></li>
			<li class="line_li">|</li>
			<%
			}
			if("admin".equalsIgnoreCase(user.getUserCde()) || role.indexOf("9") >= 0)
			{
			%>
			<li  class="line_up_li" id="menumain19" name="menumain" >
				<a href="<%=context%>/yc/casemanage.do?mhd=toList&menuid=19" >案件处理</a>
				<ul>
					<li><a href="www.baidu.com">百度</a></li>
					<li><a href="www.alipay.com">支付宝</a></li>
				</ul>	
			</li>
			<%
			}
			%>
		</ul>
	</div>
	 --%>
  <script language="javascript">
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
			<%--
			<li id="firstpage"><a href="<%=context%>/info.do?mhd=toList&menuid=11">公告消息</a></li>
			<li id="firstpage">
				<a href="<%=context%>/ad.do?mhd=toList&menuid=12">首页图片</a>
			</li>
			<li id="firstpage">
				<a href="<%=context%>/version.do?mhd=toList&menuid=13">版本管理</a>
			</li>
			<li id="firstpage"><a href="<%=context%>/product.do?mhd=toList&menuid=14" >产品管理</a></li>
			<li id="firstpage">
				<a href="<%=context%>/sync.jsp?menuid=15">数据同步</a>
			</li>
			<li id="firstpage"><a href="<%=context%>/transaction.do?mhd=toList&menuid=16">交易清单</a></li>
			<li id="firstpage">
				<a href="#" >用户管理</a>
				<ul>
					<li><a href="<%=context%>/user/unemp.do?mhd=toList&menuid=17">用户查询</a></li>
					<li><a href="<%=context%>/user/unemp.do?mhd=toList&menuid=17">新增用户</a></li>
				</ul>
			</li>
			<li id="firstpage"><a href="<%=context%>/client/usermodule.do?mhd=toClientInsert&menuid=18"  >权限管理</a></li> 
			<li id="firstpage"><a href="<%=context%>/yc/casemanage.do?mhd=toList" >案件处理</a></li>--%>
			
		</ul>
		<br style="clear: left" />
	</div>