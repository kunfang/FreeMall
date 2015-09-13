<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
   String context =request.getContextPath();
   int userid = (Integer)session.getAttribute("userId");
%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
<script type="text/javascript" src="<%=context %>/source/jquery.js" charset="utf-8"></script>
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
                	        text: '15天销量统计'
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
<title>销量统计</title>
</head>
<body>
	<div id="main" style="height:400px;"></div>
</body>
</html>