<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href='https://fonts.googleapis.com/css?family=Old+Standard+TT' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/style.css">
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='https://cdn.jsdelivr.net/bootstrap.material-design/0.5.8/css/bootstrap-material-design.min.css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/wrapper.css">
<link rel="stylesheet" href="css/radio.css">
<link rel="stylesheet" href="css/search.css">
 <link rel="stylesheet" href="css/graph.css">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/pie.js"></script>
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

<link rel="stylesheet" href="http://fonts.googleapis.com/earlyaccess/hanna.css">
<script>
$(function () {
    $('#container1').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Grade by movie'
        },
        xAxis: {
            type: 'category',
            labels: {
                rotation: -45,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: ''
            }
        },
        series: [{
            name: 'grade',
            data: <%= request.getAttribute("data1")%>,
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                format: '{point.y:.1f}', 
                y: 10
            }
        }]
    });
    
    var chart = AmCharts.makeChart( "chartdiv", {
    	  "type": "pie",
    	  "theme": "light",
    	  "dataProvider": <%= request.getAttribute("data2")%>,
    	  "valueField": "litres",
    	  "titleField": "country",
    	   "balloon":{
    	   "fixedPosition":true
    	  },
    	  "export": {
    	    "enabled": true
    	  }
    	} );
    
    $('#container3').highcharts({
        chart: {
            type: 'scatter',
            zoomType: 'xy'
        },
        title: {
            text: 'grade by playdate'
        },
        xAxis: {
            title: {
                enabled: true,
                text: 'playdate'
            },
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true
        },
        yAxis: {
            title: {
                text: 'grade'
            }
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            verticalAlign: 'top',
            x: 100,
            y: 70,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF',
            borderWidth: 1
        },
        plotOptions: {
            scatter: {
                marker: {
                    radius: 5,
                    states: {
                        hover: {
                            enabled: true,
                            lineColor: 'rgb(100,100,100)'
                        }
                    }
                },
                states: {
                    hover: {
                        marker: {
                            enabled: false
                        }
                    }
                },
                tooltip: {
                    headerFormat: '<b>{series.name}</b><br>',
                    pointFormat: '{point.x} year, {point.y} grade'
                }
            }
        },
        series: [{
            name: 'movie',
            color: 'rgba(223, 83, 83, .5)',
            data: <%= request.getAttribute("data3")%>

        }]
    });
    
 
});
</script>

<style>
#chartdiv {
	width		: 100%;
	height		: 500px;
	font-size	: 11px;
	font-family: 'Hanna';
	
}					
</style>
</head>
<body>
	<div role="main" class="blocks_container">
		<div class="big_block">
			<div id="container1" style="width: width:80%; height: 400px;"></div>
		</div>
		
		<br><hr><br>
		
		<div class="big_block">
			<div id="chartdiv"></div>					
		</div>
		
		<br><hr><br>
		
		<div class="big_block">
			<div id="container3" style="width: width:80%; height: 400px;"></div>
		</div>


	</div>
<footer role="contentinfo" class="footer">&copy; 2016 Movie Magazine</footer>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
<script src='https://cdn.jsdelivr.net/bootstrap.material-design/0.5.8/js/material.min.js'></script>

</body>

</html>
</body>
</html>