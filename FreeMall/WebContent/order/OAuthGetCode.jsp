<%@ page language="java" pageEncoding="utf-8"%>
<html>
	<head>
		<meta name="viewport" content="width=device-width,user-scalable=0">
	</head>
	<body>
	<script language="javascript" type="text/javascript">
		window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid }&redirect_uri=${redirect_url }&response_type=code&scope=snsapi_base&state=${outTradeNum }#wechat_redirect";
	</script>
	</body>
</html>