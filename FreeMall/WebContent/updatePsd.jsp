<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>零元汇合伙人管理系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>

		<body style="width:100%; margin:0px; padding:0px; font-size:13px;text-align:center">
		<%@ include file="/menu.jsp" %>
	<script type="text/javascript" language="javascript">
	
	var myRequest = getXMLHttpObj();
		function updatePsdOk(){
		   var oldPsd = document.getElementById("oldPsd").value;
  	       var newPsd = document.getElementById("newPsd").value;
		   var newPsdAgain = document.getElementById("newPsdAgain").value;
		   if(oldPsd == "" || newPsd == "" || newPsdAgain == ""){
		      alert("密码不能为空");
		      return;
		    }
		    if(newPsd != newPsdAgain){
		       alert("新密码2次输入不一致");
		       document.getElementById("newPsd").value = "";
		       document.getElementById("newPsdAgain").value = "";
		       return;
		     } 
		    var url = "<%=context%>/userLoginlist.do?method=pwd";
		     url += "&oldPsd="+oldPsd;
		     url += "&newPsd="+newPsd;
			 //request=getXMLHttpObj();
			 url = encodeURI(url);
			 myRequest.open("POST", url, true);
			 myRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			 myRequest.onreadystatechange =callback_updatePsdOk;
			 myRequest.send(null);
		}
	
	function callback_updatePsdOk(){
		 if (myRequest.readyState == 4) {
					if (myRequest.status == 200) {
	                  var tt=myRequest.responseText;
	                    if(tt == "1"){
	                       alert("密码修改成功！");
	                    }else if(tt == "0"){
	                      alert("旧密码输入出错！");
	                      document.getElementById("oldPsd").value = "";
	                    }else{
	                      alert("操作出险异常！");
	                    }
	                  }
	     }
	}
	
	function getXMLHttpObj() {
		var axO = [ 'Msxml2.XMLHTTP.6.0', 'Msxml2.XMLHTTP.4.0',
				'Msxml2.XMLHTTP.3.0', 'Msxml2.XMLHTTP', 'Microsoft.XMLHTTP' ], i;
		for (i = 0; i < axO.length; i++)
			try {
				return new ActiveXObject(axO[i]);
			} catch (e) {
			}
		if (typeof (XMLHttpRequest) != 'undefined')
			return new XMLHttpRequest();
		return null;
	}
		
	</script>
	
	<form name="LoginForm" method="post" action="/userLoginlist.do">
	<div class="box">
			<div class="box_top"></div>
			<div class="box_center">
    		<table class="table1">
	
			<tr><td align="center"></td></tr>
		<tr >
			<td align="right" width="400px">
				旧密码：
			</td>
			<td align="left">
				&nbsp;&nbsp;<input type ="password" name="oldPsd" id="oldPsd" size="30" />
			</td>
		</tr>
		<tr style="margin-bottom:5px;">
			<td align="right">
				新密码：
			</td>
			<td align="left">
				&nbsp;&nbsp;<input type ="password" name="newPsd" id="newPsd" size="30" />
			</td>
		</tr>
		<tr>
			<td align="right">
				新密码确认：
			</td>
			<td align="left">
				&nbsp;&nbsp;<input type ="password" name="newPsdAgain" id="newPsdAgain" size="30"/>
			</td>
		</tr>
		<tr>
			<td align="center"  colspan="2">
				&nbsp;
			</td>
		</tr>
		<tr>
			<td align="center"  colspan="2">
				<input type="button" class="buttonClass" value="确 认" onclick="updatePsdOk()" />
			</td>
		</tr>
	</table>
	</div>
			<div class="box_bottom"></div>
			</div>
    	</form>
 
 
</body>

</html>

