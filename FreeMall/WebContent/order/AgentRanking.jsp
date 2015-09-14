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
  	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>首页</title>
    <base href="<%=basePath%>">
    <link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path%>/css/datepicker3.css" rel="stylesheet">
	<link href="<%=path%>/css/styles.css" rel="stylesheet">
	
	<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
	<!--[if lt IE 9]>
	<script src="<%=path%>/js/html5shiv.js"></script>
	<script src="<%=path%>/js/respond.min.js"></script>
	<![endif]-->
	<script src="<%=path%>/js/jquery-1.11.1.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script src="<%=path%>/js/chart.min.js"></script>
	
	<script src="<%=path%>/js/easypiechart.js"></script>
	<script src="<%=path%>/js/bootstrap-datepicker.js"></script>
	
  </head>
	<body>
  		<%@ include file="/menu.jsp" %>
  		
  		
  		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  			<div class="row">
				<ol class="breadcrumb">
					<li class="active">推广排名</li>
				</ol>
			</div><!--/.row-->	
			<br>
			<div class="row">
				<div class="col-lg-9">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="canvas-wrapper">
								<!-- <canvas class="main-chart" id="line-chart" height="300" width="600"></canvas> -->
								<div id="main" style="height:500px;width: 800px"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="panel panel-blue">
						<div class="panel-heading dark-overlay"><span class="glyphicon glyphicon-check"></span>TOP 10</div>
						<div class="panel-body">
							<ul class="todo-list">
								<%
									int i = 1;
								%>
								<c1:forEach items="${agentList}" var="agentList" >
									<li class="todo-list-item">
										<div class="checkbox">
										<label>
										第<%=i++ %>名：${agentList.agentName}
										</label>
										</div>
									</li>
								</c1:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div><!--/.row-->
  		</div>
		<script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/line',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var echart = ec.init(document.getElementById('main'), 'macarons');
                echart.showLoading({  
                    text: '正在努力加载中...'  
                });
                var categories = [];  
                var values = [];
                
             	// 同步执行  
                $.ajaxSettings.async = false;  
             	
             	// 加载数据  
                $.getJSON('<%=context%>/order.do?method=getSalesStatis&userid=<%=session.getAttribute("userId")%>', function (json) {
                    categories = json.categories;
                    values = json.values;
                });
             	
             	
                var option = {
                	    title : {
                	        text: '每日销量统计（近15天）'
                	    },
                	    tooltip : {
                	    	show: true
                	    },
                	    legend: {
                	        data:['销量']
                	    },
                	    xAxis: [  
                                {  
                                    type: 'category',  
                                    data: categories  
                                }  
                        ],
                	    yAxis : [
                	        {
                	            type : 'value'
                	        }
                	    ],
                	    series : [
                	        {
                	            name:'销量',
                	            type:'line',
                	            data:values
                	            
                	        }
                	    ]
                	};
                
                // 为echarts对象加载数据 
                echart.setOption(option);
                echart.hideLoading();
            }
        );
    </script>			
	</body>
</html>
