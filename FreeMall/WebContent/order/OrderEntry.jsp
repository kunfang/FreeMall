<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
   String context =request.getContextPath();
   String prodid = (String)request.getParameter("prodid");
   String prodname = (String)request.getParameter("prodname");
   String price = (String)request.getParameter("price");
   
   String agentid = (String)request.getParameter("agentid");
   
   if (agentid == null) {
	   if (prodid.length() == 4){
		   agentid = prodid.substring(0, 2);
		   prodid = prodid.substring(3);
	   } else if (prodid.length() == 5) {
		   agentid = prodid.substring(0, 3);
		   prodid = prodid.substring(4);
	   } else if (prodid.length() == 1) {
		   agentid = "1";
	   }
	   
	   
	   
   }
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="<%=context %>/source/h5product_detail.css" rel="stylesheet" type="text/css">
<link href="<%=context %>/source/editAddress.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=context %>/source/editAddress.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=context %>/source/jquery.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=context %>/source/jquery.cityselect.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
	$("#citydiv").citySelect({
	nodata:"none",
	required:false,
	url:"<%=context%>/source/city.min.js"
	}); 
});
</script>
<title>活动报名</title>
</head>
<body>
	<div class="pd_box-border">
		<div class="pd_product-title-wrap">
                <div class="pd_product-title-box">
                    <h1 class="pd_product-title" id="pd_product-title" title="<%=prodname %>" style="text-align: center;"><span style="color: red">[免费领取]</span><%=prodname %></h1>
                    <h6 class="pd_product-subtitle" id="pd_product-subtitle" title="实际可用空间7.2G 足量 三年质量问题包换"></h6>
                    
                    <div style="color: red;word-spacing: normal;word-wrap: break-word;">货到付邮费，产品是免费赠送的，只需自付快递费，到付<%=price %>元，由快递公司收取</div>
                    <h1 class="pd_product-title" id="pd_product-title" title="<%=prodname %>" style="text-align: left;"><span style="color: red">请您先验货，后付款</span></h1>
                </div>               
            </div>
	</div>
	<div class="address_add_content">
	<input type="hidden" name="fromid" value="1">
	<input type="hidden" name="provinceId_temp2" id="provinceId_temp2">
	<input type="hidden" name="goodReceiverId" value="-1">
	<input type="hidden" name="grouponId" value="0">
	
	<input type="hidden" name="receiverPhone" id="receiverPhone" value="">
	<input type="hidden" id="defaultAddr" name="defaultAddr" class="setdefaultaddress">
	
	<input type="hidden" id="errorCode" value="">
<input type="hidden" id="errorMsg" value="">
<input type="hidden" id="errorData" value="">
<input type="hidden" id="errorMsgToCart" value="">
<input type="hidden" id="checkoutGoBack" value="">
	<div id="citydiv">
	<ul>
	<li>
	<input type="text" id="receiverName" value="" placeholder="收货人姓名" maxlength="20">
	</li>
	<li>
	<select id="provinceId" class="province_select"></select>
	</li>
	<li>
	<select id="cityId" disabled="disabled"></select>
	</li>
	<li>
	<select id="countyId" disabled="disabled"></select>
	</li>
	<li>
	<input type="text" id="address1Id" value="" placeholder="详细地址" maxlength="100">
	</li>
	<li>
	<input type="tel" id="receiverMobile" value="" placeholder="手机">
	</li>
	<!-- <li>
	<input type="tel" id="verifiCode" placeholder="验证码">
	<input type="button" class="save" onclick="getVerifiCode()" value="获取验证码" id="btn">
	</li> -->
	<li>
	<h3 class="pd_product-subtitle" id="pd_product-subtitle">活动说明:</h3>
	</li>
	<li>
	<div id="pd_product-subtitle" style="word-break">因活动发货量巨大，本活动发货环节已统一外包给快递公司负责（包括仓储，包装盒，打包，配送快递）本活动需自行向快递公司支付到付快递费<%=price %>元，由快递公司收取，货到后在付款给快递员！</div>
	</li>
	<li>
	<input type="radio" checked="checked">我已阅读并同意以上活动说明
	</li>
	<li><input type="submit" class="save" onclick="save()" value="提交" id="submitAddress"></li>
	</ul>
	</div>
	</div>
	<form id="cform" name="cform" method="post">
		<input name="receiverName" type="hidden">
		<input name="regionCode" type="hidden">
		<input name="cityCode" type="hidden">
		<input name="countyCode" type="hidden">
		<input name="address" type="hidden">
		<input name="receiverMobile" type="hidden">
		<input name="prodID" type="hidden" value="<%=prodid%>">
		<input name="prodName" type="hidden" value="<%=prodname%>">
		<input name="price" type="hidden" value="<%=price%>">
		<input name="agentID" type="hidden" value="<%=agentid%>">
	</form>
</body>
<script type="text/javascript">
	function getVerifiCode() {
		var b=document.getElementById("receiverMobile").value;
		if(b==null||b==""){H5Alert("请填写手机号码");return false}
		else{if(!validatePhone(b)){H5Alert("请填写正确的手机号码格式");return false}}
		
		$.ajax({
			type: "POST",
			url: "<%=context%>/verificode.do?method=sendCode&receiverMobile="+b,
			data: '',
			success: function(msg){
				if (msg=='000000') {
					var count = 60;
					var countdown = setInterval(CountDown, 1000);
					function CountDown() {
	                    $("#btn").attr("disabled", true);
	                    $("#btn").val("您在" + count + " 秒后可以再次获取!");
	                    if (count == 0) {
	                        $("#btn").val("重新获取验证码").removeAttr("disabled");
	                        clearInterval(countdown);
	                    }
	                    count--;
	                }
					
				} else {
					H5Alert("系统繁忙，请稍后重试");
				} 
			}
		});
	}

	function save(){
		
		var flag = check();
		if (!flag){
			return;
		}
		
		$('#submitAddress').attr('disabled','true');
		$('#submitAddress').css('background','gray');
		
		$.ajax({
			type: "POST",
			url: "<%=context%>/order.do?method=saveOrder",
			data: $('#cform').serialize(),
			success: function(msg){
				if (msg=='000000') {
					window.location="<%=context%>/order/Success.jsp"
				} else if (msg=='100000') {
					$('#submitAddress').attr('disabled','');
					$('#submitAddress').css('background','#fe5955');
					H5Alert("系统繁忙，请稍后重试");
				} else if (msg=='200000') {
					H5Alert("您已经享受过本次优惠了");
				}
			}
		});
	}
	function check() {
		var j=document.getElementById("provinceId").value;
		if(j==null||j==""){
			H5Alert("请选择省份");return false}
		var i=document.getElementById("cityId").value;
		if(i==null||i==""){H5Alert("请选择城市");return false}
		
		if (!document.getElementById("countyId").disabled) {
			var f=document.getElementById("countyId").value;
			if(f==null||f==""){H5Alert("请选择区域");return false}
		}
		
		var g=document.getElementById("receiverName").value;
		if(g==null||g==""){H5Alert("请填写收货人姓名");return false}
		var c=document.getElementById("address1Id").value;
		if(c==null||c==""){H5Alert("请填写详细地址");return false}
		var b=document.getElementById("receiverMobile").value;
		if(b==null||b==""){H5Alert("请填写手机号码");return false}
		else{if(!validatePhone(b)){H5Alert("请填写正确的手机号码格式");return false}}
		
		/* var code = document.getElementById("receiverMobile").value;
		if(!code){
			H5Alert("请输入验证码");return false
		} */
			
		document.cform.receiverName.value=g;
		document.cform.regionCode.value=j;
		document.cform.cityCode.value=i;
		document.cform.countyCode.value=f;
		document.cform.address.value=c;
		document.cform.receiverMobile.value=b;
		return true;
	}
</script>
</html>