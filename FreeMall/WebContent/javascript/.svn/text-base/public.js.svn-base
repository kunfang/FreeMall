/*
*功能:一些表公用的JS脚本
*作者：
*/


///回车键转成tab
function entryToTab()
{
	if(event.keyCode==13)
	{
		if(event.srcElement.tagName=="TEXTAREA")
		{
			return;
		}
		event.keyCode=9	;
	}
}
window.document.onkeydown  = entryToTab;


var context="/aas"
function changeBgColorOnMouseOut(obj){
	obj.style.backgroundColor='';
}
function changeBgColorOnMouseOver(obj){
	obj.style.backgroundColor='#cccccc';
}
function setContext(myContext){
	context=myContext;
}
//在模块的OnLoad处调用
function onLoadInTemplate(myContext,title){
 	setContext(myContext);
 	top.document.title=title;
}

//加入一个参数(如keyValue = "type=0");
function addParam(url,  keyValue) {
	if (url == null) {
		return "";
	}
	var index = url.indexOf("?");
	if (index < 0) {
		return url + "?" + keyValue;
	} else {
		return url + "&" + keyValue;
	}
}
function onChangeIt(){
 document.forms[0].submit();
}
//
function loadOrderInList(form,orderType,orderFid,fidIsNull,orderdown,orderup){
	if(form == "" || form == "undefined" || form == undefined)
	{
		return;
	}
	var myForm  = form;
	//如果fid不为空
	if(fidIsNull==false){
	 myForm.elements["orderFid"].value=orderFid;
	}
	myForm.elements["orderType"].value=orderType;
 	var currentObj=myForm.elements["orderFid"].value;
 	if(document.all[currentObj]){
 	 var children = document.all[currentObj].children;
  	  for(i=0;i<children.length;i++){
    	    if(children[i].tagName=="DIV"&&children[i].orderBy=="true"){
    	        if (myForm.elements["orderType"].value=="asc")
		    children[i].innerHTML+="<img src='"+orderdown+"'>";
    	        else
		    children[i].innerHTML+="<img src='"+orderup+"'>";
    	     break;
	    }//if
	    }//for
	  }
}

//在列表记录中双击
function doDblClick(fid,operation){
	if(operation==false)
	 return;
	var dblClick = "";
	var mForm = document.forms[0];
	var myUrl = mForm.action;
	mForm.mhd.value="toView";
	myUrl = addParam(myUrl,'mhd=toView');
	mForm.action=addParam(myUrl,'fid='+fid);
	mForm.submit();
}

//重载的doDblClick函数，以使其适应自定义方法名与主键列名的情况，突破toView与fid的限制
//added by 
//@param idvalue 表中行记录的主键值
//@param mhd 方法名;
//@param idname　表中行记录的主键列名

function doDblClick1(idvalue,operation,mhd,idname){
	if(operation==false)
	 return;
	var dblClick = "";
	var mForm = document.forms[0];
	var myUrl = mForm.action;
	mForm.mhd.value=mhd;
	myUrl = addParam(myUrl,'mhd='+mhd);
	mForm.action=addParam(myUrl,idname+'='+idvalue);
	mForm.submit();
}

function toUrl(myUrl,isCheck){
	//如果是click查看按钮
	if (isCheck == true){
		if (checkSelect()== false){
			return ;
		}
	}
	var mForm = document.forms[0];
	if(myUrl.charAt(0)=='/')
	 myUrl=context+myUrl;
	mForm.action =myUrl;
	mForm.submit();
}
//检查是否有选择记录
function checkSelect(){
	var count = 0;
	var length = 0;
	try{
		 length = document.forms[0].fid.length;
	} catch(e){
		alert("没有任何记录！");
		return false;
	}
	if (isNaN(length))	{
		try{
			if (document.forms[0].fid.checked)	{
				++count;
			}
		}catch(e){}
	}

	for(var i=0;i<document.forms[0].fid.length;i++){
		if(document.forms[0].fid[i].checked)
			count++;
	}
	if(count==0){
		alert("您没有选择任何记录！");
		return false;
	} else if (count >1){
		alert("请选择单条记录");
		return false;
	}

	return true;
}

function checkAll(obj,fid){

  if(obj.form.elements[fid]!=null){
    var size=obj.form.elements[fid].length;
    if(size!=null){
      for(i=0;i<size;i++){
       if(!obj.form.elements[fid][i].disabled)//如果没有变灰
          obj.form.elements[fid][i].checked = obj.checked;
      }
    }
    else{//只有一行记录时
      if(!obj.form.elements[fid].disabled)
        obj.form.elements[fid].checked = obj.checked;
      }

  }
}

function orderBy(obj){
  var currentID = obj.id;
  var children = obj.children;
  var myForm = document.forms[0];
  var oldID = myForm.elements["orderFid"].value;
  var orderType =myForm.elements["orderType"].value;
  for(i=0;i<children.length;i++){
    if(children[i].tagName=="DIV"&&children[i].orderBy=="true"){
     if(currentID==oldID){
    	if (orderType=="asc"){
	    	orderType="desc";
    	}
    	else{
	   	orderType="asc";
    }
  }//if
    myForm.elements["orderFid"].value = currentID;
    myForm.elements["orderType"].value = orderType;
    break;
    }
  }
  myForm.submit();
}
function toView(){
 if(document.forms.length>1){
    alert("注意:有两个或多个form存在,此方法可能不适用");
    return false;
  }
 if(checkSelect()==false)
   return false;
  var myForm = document.forms[0];
  myForm.mhd.value="toView";
  myForm.submit();
}

function toUpdate(){
 if(document.forms.length>1){
    alert("注意:有两个或多个form存在,此方法可能不适用");
    return false;
  }
 if(checkSelect()==false)
   return false;
  var myForm = document.forms[0];
  myForm.mhd.value="toUpdate";
  myForm.submit();
}
function toInsert(){
  if(document.forms.length>1){
    alert("注意:有两个或多个form存在,此方法可能不适用");
    return false;
  }
  var myForm = document.forms[0];
  myForm.mhd.value="toInsert";
  myForm.submit();
 }
function doDelete(){
  	var count = 0;
	var length = 0;
	try{
		 length = document.forms[0].fid.length;
	} catch(e){
		alert("没有任何记录！");
		return false;
	}
	if (isNaN(length))	{
		try{
			if (document.forms[0].fid.checked)	{
				++count;
			}
		}catch(e){}
	}
	for(var i=0;i<document.forms[0].fid.length;i++){
		if(document.forms[0].fid[i].checked)
			count++;
	}
	if(count==0){
		alert("您没有选择任何记录！");
		return false;
	}
	if(confirm("有"+count+"条记录被选中,您确定要删除吗？") == false){
		return false;
	}
  	document.forms[0].mhd.value="doDelete";
  	document.forms[0].submit();
 }





///////////////////////////////////////////////////////////////////的扩展
function toUpdate2(method){
 if(document.forms.length>1){
    alert("注意:有两个或多个form存在,此方法可能不适用");
    return false;
  }
 if(checkSelect()==false)
   return false;
  var myForm = document.forms[0];
  myForm.mhd.value=method;
  myForm.submit();
}
function doDelete2(method){
  	var count = 0;
	var length = 0;
	try{
		 length = document.forms[0].fid.length;
	} catch(e){
		alert("没有任何记录！");
		return false;
	}
	if (isNaN(length))	{
		try{
			if (document.forms[0].fid.checked)	{
				++count;
			}
		}catch(e){}
	}
	for(var i=0;i<document.forms[0].fid.length;i++){
		if(document.forms[0].fid[i].checked)
			count++;
	}
	if(count==0){
		alert("您没有选择任何记录！");
		return false;
	}
	if(confirm("有"+count+"条记录被选中,您确定要删除吗？") == false){
		return false;
	}
  	document.forms[0].mhd.value=method;
  	document.forms[0].submit();
 }

 function doQuery(){
  	document.forms[0].currentPage.value="1";
	return true;
 }
 
 
/**
 * 验证车牌号格式是否正确
 * @param obj
 * @return
 */
function checkCarTarget(obj){
	if(obj.value==null||obj.value=="") return false;
	if(obj.value=="*") return true;

    myRegExp = /^[京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新农台中武亥戌酉申未午巳辰卯寅丑子葵壬辛庚己戊丁丙乙甲北南兰沈济成广海空军使][A-HJ-NP-Z][A-HJ-NP-Z0-9*领警学]{5}$/;
	
    if(myRegExp.test(obj.value)==false){
    	myRegExp = /^[W][J][0-3][0-9][消边通森金警电0-9][A-HJ-NP-Z0-9*]{4}$/;
		if(myRegExp.test(obj.value)==false){

    		myRegExp = /^[河][南][A-HJ-NP-Z0-9*]{5}$/;
			if(myRegExp.test(obj.value)==false){
    			myRegExp = /^[北][京][A-HJ-NP-Z0-9*]{5}$/;
				if(myRegExp.test(obj.value)==false){
    				myRegExp = /^[山][西][A-HJ-NP-Z0-9*]{5}$/;
					if(myRegExp.test(obj.value)==false){
			    		return false;
					}
				}
			}
    	}
    }
    
    return true;
}
 
 

	//改变派工类型(只有三者车可以添加多个任务，其余任务类型最多只能有一个)
	function disptype_change(obj){
		var displist = document.getElementById('displist') ;
		//row为当前操作的行号
		var row = event.srcElement.parentElement.parentElement.rowIndex ;
		if(obj.value == "0170003"){		//选择本车定损时写入本车车牌号码
			document.getElementById("assessTaskInfoVOList[" + (row - 1) + "].vhl").value = document.getElementById('vo.lcnNo').value ;
		}else{
			document.getElementById("assessTaskInfoVOList[" + (row - 1) + "].vhl").value = "" ;
		}
		if(document.getElementById("assessTaskInfoVOList[" + (row - 1) + "].vhl").value == ""){
		    document.getElementById("assessTaskInfoVOList[" + (row - 1) + "].vhl").value = "*";
		}
		
		//派工类型编号、名称数组,用于判断并提示
		var taskTypeCdes = new Array('0170002','0170003','0170005','0170006') ;
		var taskTypeNmes = new Array('现场查勘','本车定损','财物定损','医疗查勘') ;
		//如果选择的派工类型不为"三者车定损"或"财务定损"时,判断是否重复添加了其它任务类型
		if(obj.value != "" && obj.value != "0170004" && obj.value!= "0170005"){
			for(var i=1; i<displist.rows.length-1; i++){
				var curobj = document.getElementById("assessTaskInfoVOList[" + (i-1) + "].taskTypeCde") ;
				if(row != i && curobj.value == obj.value){
					for(var j=0; j<taskTypeCdes.length; j++){
						if(obj.value == taskTypeCdes[j]){
							alert("不可以重复 " + taskTypeNmes[j] + " 派工，请重新选择！") ;
							obj.value = "" ;
							return false ;
						}
					}
				}
			}
		}
	}
		
	//简易调度
	function disp_onclick(){
		var sel = document.getElementsByName("dispsel");
		var selecteds = 0 ;
		for(var i=0; i<sel.length; i++){
			if(sel[i].checked){
				selecteds++ ;
			}
		}
		
		
		 if(selecteds > 0){
		  for(var i=0; i<sel.length; i++){
			var name = "assessTaskInfoVOList" + "[" + i + "]." ;
			if(sel[i].checked){
			   var untaskMarkValue =  document.getElementById(name + "untaskMark").value;
			   //返回修改可以从新派工|| untaskMarkValue == "6"
			   if(untaskMarkValue == "4" || untaskMarkValue == "5" || untaskMarkValue == "7"|| untaskMarkValue == "8"){ 
			      alert("已经提交的任务不能再改派");
			      return;
			   }
			   if(untaskMarkValue == "C"){ 
			      alert("已经取消调度的任务不能再改派");
			      return;
			   }
		    }
		 }
		}
		
		if(selecteds > 0){
		var url = "../dispatch/dispatchedit.do?mhd=toChooseEmp";
		url += "&caseNo="+document.getElementById("vo.caseNo").value; //公估号
		url += "&accidentAddr="+document.getElementById("vo.accidentAddr").value; //出险地点
		url += "&lcnNo="+document.getElementById("vo.lcnNo").value;               //车牌号
			var obj = window.showModalDialog(encodeURI(url),document
			,"dialogHeight:700px;dialogWidth:1000px;top=0,left=0,status=yes,toolbar=no,menubar=no,location=no,scrollbars =yes");
			if(obj != null){
				for(var i=0; i<sel.length; i++){
					var name = "assessTaskInfoVOList" + "[" + i + "]." ;
					if(sel[i].checked && document.getElementById(name + "untaskMark").value != 'C'){
						//查勘人代码、姓名、机构代码、机构名称
						document.getElementById(name + "surveyEmpCde").value = obj.surveyEmpCde ;
						document.getElementById(name + "surveyEmpNme").value = obj.surveyEmpNme ;
						document.getElementById(name + "surveyDptCde").value = obj.surveyDptCde ;
						document.getElementById(name + "surveyDptNme").value = obj.surveyDptNme ;
						//任务调度人代码、姓名、机构代码、机构名称
						document.getElementById(name + "dispEmpCde").value = obj.dispEmpCde ;
						document.getElementById(name + "dispEmpNme").value = obj.dispEmpNme ;
						document.getElementById(name + "dispDptCde").value = obj.dispDptCde ;
						document.getElementById(name + "dispDptNme").value = obj.dispDptNme ;
					}
					sel[i].checked = false ;
				}
			}
		}else{
			alert("请选择要派工的任务！");
			return false ;
		}
	}
	
	//打开地图
	var callid;			//用于GPS的调度
	var request=null;	//ajax对象
	function openmap_onclick(){
		var sel = document.getElementsByName("dispsel") ;
		var selecteds = 0 ;
		for(var i=0; i<sel.length; i++){
			if(sel[i].checked){
				selecteds++ ;
			}
		}
		
		  if(selecteds > 0){
		  for(var i=0; i<sel.length; i++){
			var name = "assessTaskInfoVOList" + "[" + i + "]." ;
			if(sel[i].checked){
			   var untaskMarkValue =  document.getElementById(name + "untaskMark").value;
			   //返回修改可以从新派工 || untaskMarkValue == "6"
			   if(untaskMarkValue == "4" || untaskMarkValue == "5"|| untaskMarkValue == "7"|| untaskMarkValue == "8"){ 
			      alert("已经提交的任务不能再改派");
			      return;
			   }
			   if(untaskMarkValue == "C"){ 
			      alert("已经取消调度的任务不能再改派");
			      return;
			   }
		    }
		 }
		}
		if(selecteds == 0){
			alert("请选择要派工的任务,需要派工的任务必需是没有派工的任务和派工后未进行查勘定损的任务！");
			return;
		}
		var compCde =document.getElementById("vo.compCde").value;
		callid = new Date().getTime()+ "" + Math.random();
		var url = "http://www.bao16.com:5858/estargps/gpsDispatch?tempId=" + callid; 
		//var url = "http://localhost:8081/estargps/gpsDispatch?tempId=" + callid; 
		url += "&rptNo="+document.getElementById("vo.rptNo").value;		//报案号
		url += "&compCde=" +compCde;//公司号码
		url += "&scheId=0";		//任务号
		url += "&damageTm="+document.getElementById("vo.accidentTm").value;	//出险时间 
		url += "&damageAdd="+document.getElementById("vo.accidentAddr").value;	//出险地点
		url += "&damageDesc="+document.getElementById("vo.accidentCourse").value;//出险经过
		url += "&rptTm="+document.getElementById("vo.rptTm").value;		//报案时间
		url += "&rptNme="+document.getElementById("vo.reporterNme").value;	//报案人
		//url += "&rptPhone="+document.getElementById("rptInfoVO.reporterMobile").value;	//报案人电话
		url += "&carMark="+document.getElementById("vo.lcnNo").value;//车辆信息,（标的车牌、车架号、发动机号）（可以为空）
		url += "&survPlace="+document.getElementById("vo.accidentAddr").value;	//查勘地点 ,现在默认是出险地点
		url += "&taskTyp=0";		//任务类型（可以为空）
		url += "&firstFlag=0";		//是否第一现场（可以为空）
		url += "&returnUrl=";		//返回URL	（可以为空）
		url = encodeURI(url);
		//alert("请求地址");
		
		window.showModalDialog(url,document,"dialogHeight:700px;dialogWidth:1015px;dialogTop=0,dialogLeft=0,status=yes,toolbar=no,menubar=yes,location=no,scrollbars =yes");
		getGpsDispatch();
		//window.open(url,"_blank","height=700,width=1020,top=0,left=0,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes");
	}
	
	function getGpsDispatch(){
		var url = "http://www.bao16.com:5858/estargps/schedu.do?tempId="+escape(callid) + "&mhd=getSchedu";
		//alert("回调函数地址");
		//alert(url);
		request=getXMLHttpObj();
		request.open("GET", url, true);
		request.onreadystatechange =rollback_dispatch;
    	request.send(null);
	}
	
	function rollback_dispatch(){
		if (request.readyState == 4) {
			if (request.status == 200) {
				var s=request.responseText;
				var a = new Array();
    			var temp = s.split(',');
    			var t='';
    			var length=0;
    			// alert(s);
			    for(var i=0; i<temp.length;i++){
			    	t = temp[i].split(':')[0];
			    	length=t.length;
			    	if(length<3){
			    		continue;
			    	}
		    		t=t.substring(1,length-1);
			    	if(t=="survId"){
			    		a[0]=temp[i].split(':')[1].substring(1,temp[i].split(':')[1].length-1);
			    	}
			    	if(t=="survNme"){
			    		a[1]=temp[i].split(':')[1].substring(1,temp[i].split(':')[1].length-1);
			    	}
			    }
			    if(a==null||a.length==0) return ;
			    if(a[0]=="尚未选定") return;
			    var sel = document.getElementsByName("dispsel");
			    var prefix = "assessTaskInfoVOList";
				for(var i=0;i<sel.length;i++){
					var name = prefix+"["+i+"].";
					if(sel[i].checked){
						document.getElementById(name+"surveyEmpCde").value = a[0];
						document.getElementById(name+"surveyEmpNme").value = a[1];
						document.getElementById(name+"surveyDptCde").value = "";
						document.getElementById(name+"surveyDptNme").value = "";
					}
					sel[i].checked = false ;
				}
			} else{
				alert("system error,status is " + request.status);
			}
		}
	}
	
	function getXMLHttpObj(){
		var axO=['Msxml2.XMLHTTP.6.0', 'Msxml2.XMLHTTP.4.0','Msxml2.XMLHTTP.3.0', 'Msxml2.XMLHTTP', 'Microsoft.XMLHTTP'], i;
		for(i=0;i<axO.length;i++)
		try{
			return new ActiveXObject(axO[i]);
		}catch(e){}
		if(typeof(XMLHttpRequest)!='undefined')
			return new XMLHttpRequest();
		return null;
	}	
/**
 * 选择机构
 * @writer 王俊伟
 * @date 2012-08-10
 * @param url
 * @return
 */
function selectDeptModal(url,elem) {	
	url += "&time=";
	url += (new Date()).getTime();
	var node = window.showModalDialog(url,document,"dialogHeight:600px;dialogWidth:350px;dialogTop=20,dialogLeft=300,center=yes,status=yes,toolbar=no,menubar=no,location=no,scrollbars =yes");
	//var node = window.open(url);
	
	if (node != null) {
		//obj.value=node.name;
		
		//elem.parentNode.getElementsByTagName('input')[0].value=node.id;
		//elem.parentNode.getElementsByTagName('input')[0].value=node.name;
		document.getElementsByName("dptNme")[0].value=node.name;
		document.getElementsByName("dptCde")[0].value=node.id;
	}
}







/**
 * 定损员可操作机构分配
 * @writer 王俊伟
 * @date 2012-12-11
 * @param url
 * @return
 */
function selectDepEmptModal(url,elem) {	
	url += "&time=";
	url += (new Date()).getTime();
	var codeAndNameStr = window.showModalDialog(url,document,"dialogHeight:600px;dialogWidth:350px;dialogTop=20,dialogLeft=300,center=yes,status=yes,toolbar=no,menubar=no,location=no,scrollbars =yes");
	if (codeAndNameStr != null) {
		document.getElementById("dptCdeAndNme").value=codeAndNameStr;
	}
}

/**
 * 选择模块权限
 * 
 * @param url
 * @return
 */
function selectUserMemu(url,elem) {	
	url += "&time=";
	url += (new Date()).getTime();
	var codeAndNameStr = window.showModalDialog(url,document,"dialogHeight:600px;dialogWidth:350px;dialogTop=20,dialogLeft=300,center=yes,status=yes,toolbar=no,menubar=no,location=no,scrollbars =yes");
	if (codeAndNameStr != null) {
		document.getElementById("dptCdeAndNme").value=codeAndNameStr;
	}
}

/**
 * @writer 王俊伟
 * @date 2012-08-10
 * @param url
 * @return
 */
function show_blank(url, height, width) {
	if (!height)
		height = window.screen.availHeight - 60;
	if (!width)
		width = window.screen.availWidth - 6;

	var top = 0;
	var left = 0;

	var detail = 'height='
			+ height
			+ ',width='
			+ width
			+ ',top='
			+ top
			+ ',left='
			+ left
			+ ',toolbar=no,menubar=no,scrollbars=yes,resizable=no,location=no,status=yes';

	window.open(url, '_self', detail);
}

/**
 * 取得名称为chName的复选框值组成的字符串

 * @param chName
 * @return
 */
function getCheckedChStr(chName){
	var chArray = new Array();
	var elePath = ":checkbox[name='"+chName+"']:checked:enabled";
	jQuery(elePath).each(function(){
		var curCh = jQuery(this);
		
		if(curCh.val()!=null && curCh.val()!="")
			chArray.push(curCh.val());
	});
	return chArray.toString();
}

/**
* 批量删除
*/
function delete_batch(chName,url){	
	var ids = getCheckedChStr(chName);	
	if(ids!=null && ids!=""){
		if(window.confirm("您确定要删除选定的列吗?")){
			url+=ids;
			show_blank(url);
		}
	}
	else
	{
		alert("请选中要删除的记录");
		  return;
	}
}

	/**
	* 公共操作方法
	*/
	function todo_batch(chName,url){
		var ids = getCheckedChStr(chName);
			if(ids!=null && ids!="")
			{
				if(ids.indexOf(",")>0)
			       {
			    	    alert("请只选中某一条记录,不要多选");
						return;
			       }else{
						url+=ids;
						show_blank(url);
			          }
		  }else
		  {
			  alert("请选中某一条记录");
			  return;
		  }
	}

/**取服务器ip**/
function getServerIp()
{
	var url = document.location.href;
	url = url.substring(url.indexOf("//")+2,url.length);
	url = url.substring(0,url.indexOf(":"));
	/*
	if(url.indexOf("/")<url.indexOf("\\") || url.indexOf("\\")<0)
	{
		url = url.substring(0,url.indexOf("/"));
	}
	else
	{
		url = url.substring(0,url.indexOf("\\"));
	}*/
	
	return url;
}

//按时间排序
		function orderDateClick()
		{
			var obj = document.getElementsByName("orderDate")[0];
			if(obj.value == "1")
			{
				obj.value = "2";
			}
			else
			{
				obj.value = "1";
			}
			if(document.getElementsByName("currentPage").length > 0)
			{
				document.getElementsByName("currentPage")[0].value = "0";
			}
			document.forms[0].submit();
		}