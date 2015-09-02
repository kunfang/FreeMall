<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<% String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>代理排名</title>
    <link href="<%=path%>/css/page2.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/css/ddsmoothmenu.css" type="text/css" rel="stylesheet">
	<script language="javascript" type="text/javascript" src="<%=path%>/datePicker/WdatePicker.js"></script>
	
	<link href="<%=path %>/source/editAddress.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path %>/source/editAddress.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/source/jquery.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=path %>/source/jquery.cityselect.js" charset="utf-8"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	   function changeBgColorOnMouseOut(obj) {
			obj.style.backgroundColor = '';
		}
	
		function changeBgColorOnMouseOver(obj) {
			obj.style.backgroundColor = '#cccccc';
		}
		
		function toSearch(flag){
			$("#regionCode").val($("#provinceId").val());
			$("#cityCode").val($("#cityId").val());
			document.forms.method.value="getOrderList";
			document.forms.submit();
		}
	</script>
  </head>
  
  <body style="width:100%; margin:0px; padding:0px; font-size:13px;text-align:center">
  <%@ include file="/menu.jsp" %>
		    <div class="box">
			<div class="box_top"></div>
			<div class="box_center">	
			<input type="hidden" name="method" value="getOrderList" />
			<%-- 推广链接
					<div id="citydiv">
						<table class="table1" >
							<c1:forEach items="${prodList}" var="prodList" >
							<tr class="td1">
								<td align="right" class="mctitle">${prodList.prodName}:</td>
								<td align="left" class="mctitle"><input size="40" type="text" value="<%=basePath %>order/OrderEntry.jsp?prodid=${prodList.prodID}&prodname=${prodList.prodName}&price=${prodList.price}&agentid=<%=session.getAttribute("userId") %>">
							</tr>
							</c1:forEach>
						</table>
						
					</div> --%>
					
					<div style="width:95%; margin:0px auto;">
					
							<table class="table3" style="font-size:13px;">
							<tr>
								<th scope="col" height="24" nowrap>
									<div orderBy="true">代理</div>
								</th>
								<th scope="col" height="24" nowrap>
									<div orderBy="true">数量</div>
								</th>
							</tr>
							
							<%
								int i = 0;
								String trclass = "td2";
							%>
							<c1:forEach items="${agentList}" var="agentList" >
								<%
											i++;
											if (i % 2 == 0)
										trclass = "selecttr";
											else
										trclass = "";
								%>
								
								<tr
										onmouseover="javascript:changeBgColorOnMouseOver(this);"
										onmouseout="javascript:changeBgColorOnMouseOut(this);" >
									<td>
										&nbsp;
										  ${agentList.agentName}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${agentList.agentID}
									</td>
								</tr>
							</c1:forEach>
						</table>
					</div>
			</div>
			<div class="box_bottom"></div>
			</div>
	</body>
</html>
