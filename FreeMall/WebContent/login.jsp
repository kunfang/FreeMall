<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page buffer="10kb"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <%  
 	String context =request.getContextPath(); 
 	String loginErrInfo = (String)request.getSession().getAttribute("loginErrInfo");
 	if (loginErrInfo == null || loginErrInfo.length() == 0)
 		loginErrInfo = "";
 %>  
 <HEAD>
 <TITLE>代理商管理系统</TITLE>
   <meta http-equiv=Content-Type content="text/html; charset=utf-8"/>
   <meta content="MSHTML 6.00.2800.1400" name=GENERATOR/>
<style type="text/css">
        html {
            background-color: #dcdcdc;
        }
        .wrapper {
            margin: 140px auto;
            width: 884px;
        }
        .loginBox {
            background-color: #FEFEFE;
            border: 1px solid #BfD6E1;
            border-radius: 5px;
            color: #444;
            font: 14px 'Microsoft YaHei','微软雅黑';
            margin: 0 auto;
            width: 388px
        }
        .loginBox .loginBoxCenter {
            border-bottom: 1px solid #DDE0E8;
            padding: 24px;
        }
        .loginBox .loginBoxCenter p {
            margin-bottom: 10px
        }
        .loginBox .loginBoxButtons {
            background-color: #F0F4F6;
            border-top: 1px solid #FFF;
            border-bottom-left-radius: 5px;
            border-bottom-right-radius: 5px;
            line-height: 28px;
            overflow: hidden;
            padding: 20px 24px;
            vertical-align: center;
        }
        .loginBox .loginInput {
            border: 1px solid #D2D9dC;
            border-radius: 2px;
            color: #444;
            font: 12px 'Microsoft YaHei','微软雅黑';
            padding: 8px 14px;
            margin-bottom: 8px;
            width: 310px;
        }
        .loginBox .loginInput:FOCUS {
            border: 1px solid #B7D4EA;
            box-shadow: 0 0 8px #B7D4EA;
        }
        .loginBox .loginBtn {
            background-image: -moz-linear-gradient(to bottom, #B5DEF2, #85CFEE);
            border: 1px solid #98CCE7;
            border-radius: 20px;
            box-shadow:inset rgba(255,255,255,0.6) 0 1px 1px, rgba(0,0,0,0.1) 0 1px 1px;
            color: #FFF;
            cursor: pointer;
            float: right;
            font: bold 13px Arial;
            padding: 5px 14px;
        }
        .loginBox .loginBtn:HOVER {
            background-image: -moz-linear-gradient(to top, #B5DEF2, #85CFEE);
        }
        .loginBox a.forgetLink {
            color: #ABABAB;
            cursor: pointer;
            float: right;
            font: 11px/20px Arial;
            text-decoration: none;
            vertical-align: middle;
        }
        .loginBox a.forgetLink:HOVER {
            text-decoration: underline;
        }
        .loginBox input#remember {
            vertical-align: middle;
        }
        .loginBox label[for="remember"] {
            font: 11px Arial;
        }
    </style>
</HEAD>
<body onload="getFocus()" >
<form method="post" action="userLoginlist.do" name="forms" onsubmit="return login()">
<input type="hidden" name="method" value="getAssessSysMenubyList"/>
 <div class="wrapper">

        <div class="loginBox">
            <div class="loginBoxCenter">
                <p><label for="username">系统登陆：</label></p>
                <p><input type="text" id="username" name="username" class="loginInput" autofocus="autofocus" required="required" autocomplete="off" placeholder="请输入用户名" value="" /></p>
                <p><input type="password" id="password" name="password" class="loginInput" required="required" placeholder="请输入密码" value="" /></p>
                <div style="text-align:center;"><font color=red><%=loginErrInfo %></font></div>
            </div>
            
            <div class="loginBoxButtons">
                <button type="submit" class="loginBtn" data-toggle="button">登录</button>
            </div>
        </div>
</div>	
</form>
</body>
<script type="text/javascript" >
		function getFocus(){
			document.getElementById("username").focus();
		 }
		function login(){
		    var name = document.getElementById("username").value.replace(/(^\s*)|(\s*$)/g, "");
			if(name == ""){
		     	alert("请输入用户名称!");
		     	document.getElementById("username").focus();
		     	return false;
			}
			
		    var password = document.getElementById("password").value.replace(/(^\s*)|(\s*$)/g, "");
			if(password == ""){
		     	alert("请输入用户密码!");
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
		
		function refresh1(obj){
				nowTime = new Date();
		    	obj.src="<%=context%>/getpicservlet?validSession=1&r="+nowTime;
		    }
</script>

</html>