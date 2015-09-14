<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<% String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单列表</title>

	<link href="<%=path %>/source/editAddress.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path %>/css/datepicker3.css" rel="stylesheet">
	<link href="<%=path %>/css/styles.css" rel="stylesheet">
	<link href="<%=path %>/css/index.css" rel="stylesheet">	
	<script type="text/javascript" src="<%=path %>/source/editAddress.js" charset="utf-8"></script>
	<!-- <script type="text/javascript" src="<%=path %>/source/jquery.js" charset="utf-8"></script> -->
	
	<script language="javascript" type="text/javascript" src="<%=path%>/js/datePicker/WdatePicker.js"></script>
	
	<script src="<%=path %>/js/jquery-1.11.1.min.js"></script>
	<script src="<%=path %>/js/bootstrap.min.js"></script>
	<%-- <script src="<%=path %>/js/chart.min.js"></script>
	<script src="<%=path %>/js/chart-data.js"></script>
	<script src="<%=path %>/js/easypiechart.js"></script>
	<script src="<%=path %>/js/easypiechart-data.js"></script>
	<script src="<%=path %>/js/bootstrap-datepicker.js"></script>
	<script src="<%=path %>/js/bootstrap-table.js"></script> --%>
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
		
		function toSearch(flag,obj){	
			if(obj=="go"){
				document.myform.curPage.value=1;
			}
			$("#regionCode").val($("#provinceId").val());
			$("#cityCode").val($("#cityId").val());
			document.myform.method.value="getOrderList";
			document.myform.submit();
		}
		
		function exportCSV() {
			document.myform.method.value="exportCSV";
			document.myform.submit();
		}
	</script>
  </head>
  
  <body>
  <form:form commandName="orderVO" method="post" action="order.do" name="myform">
  <input type="hidden" name="method" value="getOrderList" />  
  <%@ include file="/menu.jsp" %>
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li class="active">订单查询</li>
			</ol>
		</div><!--/.row-->
        <br>
		<div id="citydiv">

						<div class="col-md-6">
							<div class="form-group">
								<label>省份</label>
								<select id="provinceId" class="form-control"></select>
								<form:hidden path="regionCode" id="regionCode"/>
							</div>
							<div class="form-group">
								<label>产品</label>
								<form:select class="form-control" path="prodName">
										<option value="">请选择产品</option>
										<form:options items="${prodList}" itemValue="prodName" itemLabel="prodName"/>
								</form:select>
							</div>
							<div class="form-group">
								<label>提交时间段</label>
								<form:input path="beginTime" class="Wdate" onClick="javacript:WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" size="30"/>---<form:input path="endTime" class="Wdate"  onClick="javacript:WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});"/>
							</div>							
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>城市</label>
								<form:hidden path="cityCode" id="cityCode"/>
								<select class="form-control" id="cityId" disabled="disabled"></select>								
							</div>
							<div class="form-group">
								<label>代理</label>
								<form:select class="form-control"  path="agentName">
										<option value="">请选择代理</option>
										<form:options items="${agentList}" itemValue="agentName" itemLabel="agentName"/>
								</form:select>
							</div>
									
						</div>
		</div>			
		<div class="row" >
			<div class="col-lg-12">
				<div class="panel panel-default">
					
					<div class="panel-body" style=" overflow:scroll; width:1400px;">
					<div class="bootstrap-table">
					<div class="fixed-table-toolbar">
						<div class="search" style="margin-left:480px;">
							<input type="button" class="btn btn-primary" value="查询(F)" onclick="toSearch('search','go')"/>&nbsp;&nbsp;
							<input type="button" class="btn btn-primary" value="导出" onclick="exportCSV()" />&nbsp;&nbsp;
						</div>		
					</div>
					<div class="fixed-table-container">
						<div class="fixed-table-header"><table></table></div>
						<div class="fixed-table-body">
							<table data-toggle="table" class="table table-hover" >
						    <thead>
						    <tr>
						        <th style="border-right:1px solid #eee" >序号</th>
						        <th style="border-right:1px solid #eee">接收人名称 </th>
						        <th style="border-right:1px solid #eee">省份</th>
						        <th style="border-right:1px solid #eee">城市</th>
								<th style="border-right:1px solid #eee">区县</th>
								<th style="border-right:1px solid #eee">地址</th>
								<th style="border-right:1px solid #eee">手机</th>
								<th style="border-right:1px solid #eee">提交时间</th>
								<th style="border-right:1px solid #eee">产品名称</th>
								<th style="border-right:1px solid #eee">代理</th>
						    </tr>							
						    </thead>
							<tbody>
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
								<tr data-index="<%=i%>">
									<td style="font-family: Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 14px;">
										&nbsp;
										  ${orderList.orderID}
										&nbsp;
									</td>
									<td style="font-family: Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 14px;">
										&nbsp;
										  ${orderList.receiverName}
										&nbsp;
									</td>
									<td style="font-family: Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 14px;">
										&nbsp;
										${orderList.regionCode}
										&nbsp;
									</td>
									<td style="font-family: Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 14px;">
										&nbsp;
										${orderList.cityCode}
										&nbsp;
									</td>
									<td style="font-family: Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 14px;">
										&nbsp;
										${orderList.countyCode}
										&nbsp;
									</td>
									<td style="font-family: Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 14px;">
										&nbsp;
										${orderList.address}
										&nbsp;
									</td>
									<td style="font-family: Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 14px;">
										&nbsp;
										${orderList.receiverMobile}
										&nbsp;
									</td>
									<td style="font-family: Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 14px;">
										&nbsp;
										<fmt:formatDate value="${orderList.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
										&nbsp;
									</td>
									<td style="font-family: Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 14px;">
										&nbsp;
										${orderList.prodName}
										&nbsp;
									</td>
									<td style="font-family: Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 14px;">
										&nbsp;
										${orderList.agentName}
										&nbsp;
									</td>
								</tr>
								</c1:forEach>
							</tbody>
						</table>
						</div><div class="fixed-table-pagination"></div></div></div>
						<%@ include file="/common/pageLocation.in" %>
					</div>
					
				</div>
			</div>
		</div><!--/.row-->	


		
	</div><!--/.main-->


	 </form:form>	
  </body>
</html>
