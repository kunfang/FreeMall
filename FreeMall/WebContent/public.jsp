<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ftc.freemall.vo.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"  %>
<%
	String context =request.getContextPath();  
	String imgPath="";//SystemUtils.getSystemAttribute("imgPath");
 	String compCde = "";
 	String deptCde = "";
 	String taskStat = ""; 
 	String lossManNme = "";	
 	User user =(User) session.getAttribute("userInfo");
	if(user == null || user.getUsername() == null){
	//response.sendRedirect(context + "/login.do?mhd=doLogoutCsseSession");
%>
	<script language="javascript"> 
		//top.location.href = "<%=context%>/login.do?mhd=doLogoutCsseSession";
	</script>
<%
	} else {
	 	//compCde = user.getCompCde();
	 	//deptCde = user.getDeptCde();
	 	//taskStat = user.getVideoSrvyStat();
	 	//lossManNme = user.getUserNme();
 	}
%>
<script language="javascript">
	var menuColor = "#060896";
	var context = "<%=context%>";
	function f_over(obj){
		obj.className = "line_up_hover";
	}
	function f_out(obj){
		obj.className = "line_up_out";
	}

</script>
<link href="<%=context%>/css/page2.css" rel="stylesheet" type="text/css">
<link href="<%=context%>/css/ddsmoothmenu.css" type="text/css" rel="stylesheet">
<link href="<%=context %>/source/editAddress.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=context %>/source/jquery.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=context %>/source/editAddress.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=context %>/source/jquery.cityselect.js" charset="utf-8"></script>


<script type="text/javascript" src="<%=context%>/javascript/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=context%>/javascript/ajax.js"></script>

<script language="javascript" type="text/javascript" src="<%=context%>/datePicker/WdatePicker.js"></script>
<!-- 为了使用无复选框树，无顺序 -->
<%-- <script src="<%=context%>/platform/xyTree/TreeNormal.js"></script>
<script src="<%=context%>/platform/xyTree/NodeNormal.js"></script>
<script src="<%=context%>/platform/xyTree/DivTreeNormal.js"></script>

<!-- 为了使用带复选框树，无顺序 -->
<script src="<%=context%>/platform/xyTree/DivTree.js"></script>
<script src="<%=context%>/platform/xyTree/Tree.js"></script>
<script src="<%=context%>/platform/xyTree/Node.js"></script> --%>

<link href="<%=context%>/css/ddsmoothmenu.css" type="text/css" rel="stylesheet">
<%-- <script src="<%=context%>/javascript/jquery-1.7.1.js" type="text/javascript"></script> --%>
<script src="<%=context%>/javascript/ddsmoothmenu.js" type="text/javascript"></script>

<script type="text/javascript" src="<%=context%>/javascript/main.js"></script>
<meta http-equiv="Expires" content="0">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Pragma" content="no-cache">
