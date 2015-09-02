//查询页面的清除按钮
function clean_onclick() {
	var formobj = document.forms[0];
	for(var i = 0; i < formobj.elements.length; i++){ 
		var elem = formobj.elements[i];
		if(elem.type=="select"){
			elem.selectIndex = 0;
		}else if(elem.type=="text"){
			elem.value = "";
		}
//		if(elem.type=="text"){
//			if(elem.name!="dptCde"&&elem.name!="interCde"&&elem.name!="dptNme"){
//				 elem.value = "";
//			}
//		} 
	}
}


//验证是否 整数
function isInt(strValue)
{
	// 数字必须是 0123456789 或者为空


	return checkExp( /^\d*$/g, strValue );

	//return  checkExp(/\ \^(-|\+)?\d+(\.\d+)?$/g, strValue );
}

//使用正则表达式，检测 s 是否满足模式 re
function checkExp( re, s )
{
	return re.test( s );
}

//去除空格
function trimStr(str){
	return str.replace(/(^\s*)|(\s*$)/g,"");
}

//验证录入的数字
function checkInt(obj){
	var dataValue=obj.value;
	if(!isInt(dataValue)){
		alert("请输入整数");
		obj.value="";
		return;
	}
}





