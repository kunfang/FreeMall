<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<% String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>申领推广链接</title>
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path %>/css/datepicker3.css" rel="stylesheet">
	<link href="<%=path %>/css/styles.css" rel="stylesheet">
	<link href="<%=path %>/css/index.css" rel="stylesheet">
 <script>
	window._bd_share_config = {
		common : {
			bdText : '百年蔷薇五件套',	
			bdDesc : '',
			bdUrl : '<%=basePath %>/lingyh/Item3.jsp?prodid=3&price=23&prodname=百年蔷薇五件套&agentid=<%=session.getAttribute("userId")%>', 	
			bdPic : '<%=path %>/img/item/item1.png'
		},
		share : [{
			"bdSize" : 32
		}],
		image : [{
			viewType : 'list',
			viewPos : 'top',
			viewColor : 'black',
			viewSize : '32',
			viewList : ['weixin','sqq','qzone','tsina']
		}],
		selectShare : [{
			"bdselectMiniList" : ['weixin','sqq','qzone','tsina']
		}]
	}
	with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion='+~(-new Date()/36e5)];
	
</script>
</head>
  
  <body>
	<%@ include file="/menu.jsp" %>
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li class="active">申领推广链接</li>
			</ol>
		</div><!--/.row-->


		<article>

			<div class="bloglist left">
				<h3>百年蔷薇刀具五件套</h3>
				<figure><img src="<%=path %>/img/item/item1.png"></figure>
				<ul>
					<p>韩国百年蔷薇刀具五件套，做工精细，质量保证。蔷薇绽放，惊艳厨房。韩国百年蔷薇刀具五件套，做工精细，质量保证。蔷薇绽放，惊艳厨房。韩国百年蔷薇刀具五件套，做工精细，质量保证。蔷薇绽放，惊艳厨房...</p>
					
					<div class="bdsharebuttonbox" data-tag="share_1">
						<a class="bds_mshare" data-cmd="mshare"></a>
						<a class="bds_weixin" data-cmd="weixin"></a>
						<a class="bds_sqq" data-cmd="sqq"></a>
						<a class="bds_qzone" data-cmd="qzone" href="#"></a>
						<a class="bds_tsina" data-cmd="tsina"></a>
						<a class="bds_baidu" data-cmd="baidu"></a>										
						<a class="bds_more" data-cmd="more">更多</a>
						<a class="bds_count" data-cmd="count"></a>		
					</div>	
				</ul>
				<p class="dateview"><span>2015-08-08</span><span>作者：ww</span></p>
			</div>
		</article>
		<br>


	<script src="<%=path %>/js/jquery-1.11.1.min.js"></script>
	<script src="<%=path %>/js/bootstrap.min.js"></script>
	<script src="<%=path %>/js/chart.min.js"></script>
	<script src="<%=path %>/js/chart-data.js"></script>
	<script src="<%=path %>/js/easypiechart.js"></script>
	<script src="<%=path %>/js/easypiechart-data.js"></script>
	<script src="<%=path %>/js/bootstrap-datepicker.js"></script>
	<script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>
