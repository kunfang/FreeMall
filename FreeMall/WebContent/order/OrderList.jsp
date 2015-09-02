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
    
    <title>订单列表</title>
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
	$(function(){
		var provValue = $("#regionCode").val();
		var cityValue = $("#cityCode").val();
		$("#citydiv").citySelect({
		nodata:"none",
		required:false,
		url:"<%=path%>/source/city.min.js",
		prov:provValue,
		city:cityValue
		}); 
	});
	
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
		
		function exportCSV() {
			document.forms.method.value="exportCSV";
			document.forms.submit();
		}
	</script>
  </head>
  
  <body style="width:100%; margin:0px; padding:0px; font-size:13px;text-align:center">
		    <div class="box">
			<div class="box_top"></div>
			<div class="box_center">	
		<form:form commandName="orderVO" method="post" action="order.do" name="forms">
			<input type="hidden" name="method" value="getOrderList" />
					<div id="citydiv">
						<table class="table1" >
							<tr class="td1">
								<td align="right" class="mctitle">省份:</td>
								<td align="left" class="mctitle"><select id="provinceId" class="province_select"></select>
								<form:hidden path="regionCode" id="regionCode"/>
								</td>
								<td align="right" class="mctitle">城市:</td>
								<td align="left" class="mctitle"><select id="cityId" disabled="disabled"></select>
								<form:hidden path="cityCode" id="cityCode"/>
								</td>
								<%-- <td align="right" class="mctitle">产品类型:</td>
								<td align="left" class="mctitle"><form:select path="categoryId" items="${cateList}" itemValue="categoryId" itemLabel="categoryName" /></td> --%>
							</tr>
							<tr class="td1">
								<td align="right" class="mctitle">提交时间段:</td>
								<td align="left" class="mctitle"><form:input path="beginTime" class="Wdate" onClick="javacript:WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" size="30"/>---<form:input path="endTime" class="Wdate" onClick="javacript:WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/></td>
							</tr>
							<tr class="td1">
								<td align="right" class="mctitle">产品名称:</td>
								<td align="left" class="mctitle">
								<form:select path="prodName">
										<option value="">请选择产品</option>
										<form:options items="${prodList}" itemValue="prodName" itemLabel="prodName"/>
									</form:select>
								
								</td>
								<td align="right" class="mctitle">代理:</td>
								<td align="left" class="mctitle">
									<form:select path="agentName">
										<option value="">请选择代理</option>
										<form:options items="${agentList}" itemValue="agentName" itemLabel="agentName"/>
									</form:select>
								</td>
							</tr>
						</table>
					</div>
						&nbsp;
					<div align="center">
						<input type="button" class="buttonClass" value="查询(F)" onclick="toSearch('search')"/>&nbsp;&nbsp;
						<input type="button" class="buttonClass" value="导出" onclick="exportCSV()" />&nbsp;&nbsp;
					</div>
					<div style="width:95%; margin:0px auto;">
					
							<table class="table3" style="font-size:13px;">
							<tr>
								<th nowrap scope="col" height="24" >
									<div orderBy="true">序号</div>
								</th>
								<th nowrap scope="col" height="24" >
									<div orderBy="true">接收人名称</div>
								</th>
								<th scope="col" height="24" nowrap id=".truename">
									<div orderBy="true">省份</div>
								</th>
								<th scope="col" height="24" nowrap id=".orgid">
									<div orderBy="true">城市</div>
								</th>
								<th scope="col" height="24" nowrap id="">
									<div orderBy="true">县</div>
								</th>
							    <th scope="col" height="24" nowrap id="">
									<div orderBy="true">地址</div>
								</th>
								
								<th scope="col" height="24" nowrap id=".orgid">
									<div orderBy="true">手机</div>
								</th>
								<th scope="col" height="24" nowrapid=".orgid">
									<div orderBy="true">提交时间</div>
								</th>
								<th scope="col" height="24" nowrapid=".orgid">
									<div orderBy="true">产品名称</div>
								</th>
								<th scope="col" height="24" nowrap>
									<div orderBy="true">代理</div>
								</th>
							</tr>
							
							<%
								int i = 0;
								String trclass = "td2";
							%>
							<c1:forEach items="${orderList}" var="orderList" >
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
										  ${orderList.orderID}
										&nbsp;
									</td>
									<td>
										&nbsp;
										  ${orderList.receiverName}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${orderList.regionCode}
									</td>
									<td height="14">
										&nbsp;
										${orderList.cityCode}
										&nbsp;
									</td>
									
									<td height="14">
										&nbsp;
										${orderList.countyCode}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${orderList.address}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${orderList.receiverMobile}
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										<fmt:formatDate value="${orderList.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
										&nbsp;
									</td>
									<td height="14">
										&nbsp;
										${orderList.prodName}
										&nbsp;
									</td>
									<td height="14">
									    &nbsp;
										${orderList.agentName}
										&nbsp;
									</td>
								</tr>
							</c1:forEach>
						</table>
					</div>
		      </form:form>
			</div>
			<div class="box_bottom"></div>
			</div>
	</body>
</html>
