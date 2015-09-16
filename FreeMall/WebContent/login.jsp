<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page buffer="10kb"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="cn" xmlns="http://www.w3.org/1999/xhtml">
 <%  
 	String context =request.getContextPath(); 
 	String loginErrInfo = (String)request.getSession().getAttribute("loginErrInfo");
 	request.getSession().removeAttribute("loginErrInfo");
 	if (loginErrInfo == null || loginErrInfo.length() == 0)
 		loginErrInfo = "";
 %>  
<HEAD>
<TITLE>零元汇合伙人管理系统</TITLE>
<meta charset="utf-8" />
<meta http-equiv=Content-Type content="text/html; charset=utf-8"/>
<meta content="MSHTML 6.00.2800.1400" name=GENERATOR/>
    <link rel="stylesheet" type="text/css" href="<%=context %>/css/bootstrap.min.css" />
    <%-- <link rel="stylesheet" href="<%=context %>/login/css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="<%=context %>/login/css/style.css" />
    <link rel="stylesheet" href="<%=context %>/login/css/theme.css" />

    <link rel="stylesheet" type="text/css" href="<%=context %>/js/lightbox/themes/default/jquery.lightbox.css" /> --%>
    <!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="js/lightbox/themes/default/jquery.lightbox.ie6.css" />
<![endif]-->
    <%-- <script type="text/javascript" src="<%=context %>/login/js/bootstrap-carousel.js"></script> --%>
    <script type="text/javascript" src="<%=context %>/login/js/jquery-1.8.3.min.js"></script>
    <%-- <script type="text/javascript" src="<%=context %>/login/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="<%=context %>/login/js/lightbox/jquery.lightbox.min.js"></script> --%>

    <style type="text/css">
	html,body {
		height: 100%;
	}
	.box {
		/*filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF');   IE */
		/*background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
		background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
		background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
		background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
		background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%); */
		
		background-color:#f1f4f7;
		
		margin: 0 auto;
		position: relative;
		width: 100%;
		height: 100%;
	}
	.login-box {
		width: 100%;
		max-width:500px;
		height: 400px;
		position: absolute;
		top: 50%;
	
		margin-top: -200px;
		/*设置负值，为要定位子盒子的一半高度*/
		
	}
	@media screen and (min-width:500px){
		.login-box {
			left: 50%;
			/*设置负值，为要定位子盒子的一半宽度*/
			margin-left: -250px;
		}
	}	
	
	.form {
		width: 100%;
		max-width:500px;
		height: 275px;
		margin: 25px auto 0px auto;
		padding-top: 25px;
	}	
	.login-content {
		/* height: 300px; */
		width: 100%;
		max-width:500px;
		background-color: rgba(255, 250, 2550, .6);
		float: left;
	}		
		
		
	.input-group {
		margin: 0px 0px 30px 0px !important;
	}
	.form-control,
	.input-group {
		height: 40px;
	}
	
	.form-group {
		margin-bottom: 0px !important;
	}
	.login-title {
		padding: 20px 10px;
		background-color: rgba(45,157, 243, .6);
	}
	.login-title h1 {
		margin-top: 10px !important;
	}
	.login-title small {
		color: #fff;
	}
	
	.link p {
		line-height: 20px;
		margin-top: 30px;
	}
	.btn-sm {
		padding: 8px 24px !important;
		font-size: 16px !important;
	}
	</style>
</HEAD>
<body>
    <div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small>欢迎使用零元汇合伙人平台</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="userLoginlist.do" method="post" onsubmit="return login()">
				<input type="hidden" name="method" value="getAssessSysMenubyList"/>
				<div class="form-group">
					<div class="col-xs-12  ">
					<font color=red id="errorInfo"><%=loginErrInfo %></font>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" id="username" name="username" class="form-control" placeholder="手机号">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" id="password" name="password" class="form-control" placeholder="密码">
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4 ">
						<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-off"></span> 登录</button>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-6 link">
					</div>
					<div class="col-xs-6 link">
						<p class="text-center remove-margin"><small>还没注册?</small> <a href="<%=context%>/userLoginlist.do?method=registerUser" ><small>注册</small></a>
						</p>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
	</div>
</body>
<script type="text/javascript" >
	
		function getFocus(){
			document.getElementById("username").focus();
		 }
		function login(){
		    var name = document.getElementById("username").value.replace(/(^\s*)|(\s*$)/g, "");
			if(name == ""){
		     	document.getElementById("errorInfo").innerText="请输入登陆手机号";
		     	document.getElementById("username").focus();
		     	return false;
			}
			
		    var password = document.getElementById("password").value.replace(/(^\s*)|(\s*$)/g, "");
			if(password == ""){
		     	document.getElementById("errorInfo").innerText="请输入用户密码";
		     	document.getElementById("password").focus();
		     	return false;
		     	
			}
		    /*var inputValidateCode = document.forms[0].validateCode.value.replace(/(^\s*)|(\s*$)/g, "");
			if(inputValidateCode == ""){
		     	alert("请输入验证码!");
			  	document.getElementsByName("validateCode")[0].focus();
		     	return false;
			}*/
		}
		
<%-- 		function refresh1(obj){
				nowTime = new Date();
		    	obj.src="<%=context%>/getpicservlet?validSession=1&r="+nowTime;
		    } --%>
</script>
<script type="text/javascript"> 
var isChrome = window.navigator.userAgent.indexOf("Chrome") !== -1;
    if (!isChrome) {
        $("body").html("为了更好的操作体验，请使用Chrome浏览器，<a href=\"http://w.x.baidu.com/alading/anquan_soft_down_ub/14744\" data-softurl=\"http://w.x.baidu.com/alading/anquan_soft_down_ub/14744\" target=\"_blank\">点击下载</a>");
    }
</script>
</html>
