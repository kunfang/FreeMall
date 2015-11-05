<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
    String context =request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>订单支付</title>
		<link href="<%=context %>/source/h5product_detail.css" rel="stylesheet" type="text/css">
		<link href="<%=context %>/source/editAddress.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<%=context %>/source/editAddress.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=context %>/source/jquery.js" charset="utf-8"></script>
		<script type="text/javascript" src="<%=context %>/source/jquery.cityselect.js" charset="utf-8"></scrip
		<script type="text/javascript" src="<%=context %>/source/jquery.js" charset="utf-8"></script>
		<meta http-equiv="content-type" content="text/html;charset=utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	li{
	height:30px;
	line-height:30px; 
	border:1px solid #f3f3f3;
	}
	</style>
</head>
	<body>
			<div class="pd_box-border">
		<div class="pd_product-title-wrap">
                <div class="pd_product-title-box">
                    <h1 class="pd_product-title" id="pd_product-title" style="text-align: center;font-size：2.5rem;"><span style="color: red">[免费领取]</span></h1>
                 </div>               
            </div>
	</div>
	<div class="address_add_content">
	<div id="citydiv">
	<ul>
	<li>
	&nbsp;&nbsp;${receiverName}
	</li>
	<li>
	&nbsp;&nbsp;${regionCode}
	</li>
	<li>
	&nbsp;&nbsp;${cityCode}
	</li>
	<li>
	&nbsp;&nbsp;
	<c:if test="${empty countyCode}">&nbsp;&nbsp;</c:if>
 	<c:if test="${not empty select}"> ${countyCode} </c:if>
	</li>
	<li>
	&nbsp;&nbsp;${address}
	</li>
	<li>
	&nbsp;&nbsp;${receiverMobile}
	</li>
	
	<li style="border:0px;height:50px;border-bottom:1px solid #f3f3f3;">
	<input id="wxpay" type="radio" style="line-height:50px; " name="payradio" checked="checked" value="Y">
	<img alt="" src="<%=context %>/img/wxpay.jpeg" onclick="chooseRadio('Y')">
	<font color="red" size="4px" style="margin-left: 150px;line-height:50px; "><strong>￥${price-1}</strong></font>
	</li>
	<li style="border:0px;margin-top:5px;height:50px;border-bottom:1px solid #f3f3f3;">
	<input type="radio" style="line-height:50px; " name="payradio" value="N">
	<img id="gohomepay" src="<%=context %>/img/gohomepay.jpg" onclick="chooseRadio('N')">
	<font color="red" size="4px" style="margin-left: 100px;line-height:50px; "><strong>￥${price}</strong></font>
	</li>
	<li style="border:0px;">
	<input type="submit" class="save" onclick="save()" value="支付" id="submitAddress"></li>
	</ul>
	</div>
	</div>
		<br>
		<form id="cform" name="cform" method="post">

		<input name="receiverName" type="hidden" value="${receiverName}">
		<input name="regionCode" type="hidden" value="${regionCode}">
		<input name="cityCode" type="hidden" value="${cityCode}">
		<input name="countyCode" type="hidden" value="${countyCode}">
		<input name="address" type="hidden" value="${address}">
		<input name="receiverMobile" type="hidden" value="${receiverMobile}">
		<input name="prodID" type="hidden" value="${prodID}">
		<input name="prodName" type="hidden" value="${prodName}">
		<input name="price" type="hidden" value="${price}">
		<input name="agentID" type="hidden" value="${agentID}">
		<input name="orderCode" type="hidden" value="${orderCode}">
		<input name="openId" type="hidden" value="${openid}">		
		<input name="isPaid" type="hidden">
		<input name="paidOk" type="hidden" value="N">	
					
	</form>
	</body>
<script type="text/javascript">


function chooseRadio(obj){
	if(obj=="Y"){
		$("input[name='payradio']").eq(1).removeAttr("checked");
        $("input[name='payradio']").eq(0).attr("checked","checked");       
        $("input[name='payradio']").eq(0).click();
	}else{
		 $("input[name='payradio']").eq(0).removeAttr("checked");
	     $("input[name='payradio']").eq(1).attr("checked","checked");
	     $("input[name='payradio']").eq(1).click();
	}
	
}

function save(){
	var iswxpay = $('input[name="payradio"]:checked ').val(); 
	$('input[name="isPaid"]').val(iswxpay);
	
	$.ajax({
		type: "POST",
		url: "<%=context%>/order.do?method=saveOrder",
		data: $('#cform').serialize(),
		success: function(msg){
			if (msg=='000000') {
				if(iswxpay=="Y"){
					WxPay();
				}else{				
					window.location="<%=context%>/order/Success.jsp"
				}				
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
function WxPay(){
	var str = window.navigator.userAgent;
	var version = str.substring(8, 11);
	if (version != "5.0") {
		alert("微信浏览器系统版本过低，请将微信升级至5.0以上");
	} else {
		WeixinJSBridge
				.invoke('getBrandWCPayRequest', {
					"appId" : "${appId}", //公众号名称，由商户传入
					"timeStamp" : "${timeStamp}", //时间戳
					"nonceStr" : "${nonceStr}", //随机串
					"package" : "${wxPackage}",//统一支付接口返回的prepay_id 参数值，提交格式如：prepay_id=***
					"signType" : "${signType}", //微信签名方式:sha1
					"paySign" : "${paySign}" //微信签名
				}, function(res) {
					    // get_brand_wcpay_request:cancel 用户取消
						// get_brand_wcpay_request:fail 发送失败
						// get_brand_wcpay_request:ok //发送成功
						// WeixinJSBridge.log(res.err_msg);alert(res);
						//alert(res.err_code + res.err_desc);
						//alert(res.err_msg);
						if (res.err_msg == "get_brand_wcpay_request:ok") {
							window.location.href = "<%=context%>/order.do?method=updatepaidok&orderCode=${orderCode}&paidOk=Y";
						} else if (res.err_msg == "get_brand_wcpay_request:cancel") {
							H5Alert("取消支付");
						} else if (res.err_msg == "get_brand_wcpay_request:fail") {
							H5Alert("支付失败");
						}
					});
	}
}

</script>
</html>
