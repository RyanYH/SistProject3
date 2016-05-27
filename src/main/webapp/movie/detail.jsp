<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet prefetch' href='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/neoui-0.1.0.min.css'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/detail.css">
<script type="text/javascript" src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript" src="http://www.amcharts.com/lib/3/themes/none.js"></script>
<script src='https://code.jquery.com/jquery-1.11.2.min.js'></script>
<script type="text/javascript">
var chart = AmCharts.makeChart("chartdiv", {
    "theme": "none",
    "type": "serial",
	"startDuration": 2,
    "dataProvider": 
    	<%= request.getAttribute("chart")
    	
    	%>
    
    "valueAxes": [{
        "position": "left",
        "axisAlpha":0,
        "gridAlpha":0         
    }],
    "graphs": [{
        "balloonText": "[[category]]: <b>[[value]]</b>",
        "colorField": "color",
        "fillAlphas": 0.85,
        "lineAlpha": 0.1,
        "type": "column",
        "topRadius":1,
        "valueField": "숫자"
    }],
    "depth3D": 40,
	"angle": 30,
    "chartCursor": {
        "categoryBalloonEnabled": false,
        "cursorAlpha": 0,
        "zoomable": false
    },    
    "categoryField": "감성",
    "categoryAxis": {
        "gridPosition": "start",
        "axisAlpha":0,
        "gridAlpha":0
        
    },
	"exportConfig":{
		"menuTop":"20px",
        "menuRight":"20px",
        "menuItems": [{
        "icon": '/lib/3/images/export.png',
        "format": 'png'	  
        }]  
    }
},0);

jQuery('.chart-input').off().on('input change',function() {
	var property	= jQuery(this).data('property');
	var target		= chart;
	chart.startDuration = 0;

	if ( property == 'topRadius') {
		target = chart.graphs[0];
	}

	target[property] = this.value;
	chart.validateNow();
});
</script>
</head>
<body>
	<div id="rate" ng-app="demo.rate" ng-controller="rateController">
		<div class="movie center-block">
			<div class="cover">
				<div class="skew">
					<img
						src="https://images.unsplash.com/photo-1429595518497-e7e060d84f7d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&s=833be352b819594acd95b997fe6a4693">

					<div class="meta">
						<p class="subhead">${vo.title} </p>
						<p>
							<span>${vo.rating}</span> <span>${vo.time}</span> <span>${vo.grade}</span>
						</p>
						<s-rate ng-model="rate" ng-init="rate = 4.4"></s-rate>
						<span> <i class="md-icon-favorite"></i> 740,216 likes
						</span>
					</div>
				</div>
			</div>
			<div class="info">
				<div class="preview">
					<div class="min">
						<img
							src="${vo.poster}">

					</div>
				</div>

				<div class="desc">
					<p class="director">
						<b>감독:</b>${vo.director}
					</p>
					<p class="stars">
						<b>배우:</b> ${vo.actor}
					</p>
					<p>${vo.synopsis}</p>

					<!-- <p class="writers">
						<b>극본:</b> <a href="//www.imdb.com/name/nm0634300/?ref_=tt_ov_wr">Jonathan
							Nolan</a>, <a href="//www.imdb.com/name/nm0634240/?ref_=tt_ov_wr">Christopher
							Nolan</a>
					</p> -->
							
					<!-- <div class="action">
						<button class="md-btn md-btn-mint">
							<i class="md-icon-add"></i> Watchlist
						</button>

						<button class="md-btn md-btn-coral">Watch Trailer</button>
					</div> -->
				</div>
			</div>
		</div>
		<div class="content-back">
			<ul id="newsul">
				<li class="newsli">
					<div id="chartdiv"></div>
					<div class="container-fluid">
					  <div class="row text-center" style="overflow:hidden;">
							<div class="col-sm-3" style="float: none !important;display: inline-block;">
								<label class="text-left">Top Radius:</label>
								<input class="chart-input" data-property="topRadius" type="range" min="0" max="1.5" value="1" step="0.01" />
							</div>
					
							<div class="col-sm-3" style="float: none !important;display: inline-block;">
								<label class="text-left">Angle:</label>
								<input class="chart-input" data-property="angle" type="range" min="0" max="89" value="30" step="1" />	
							</div>
					
							<div class="col-sm-3" style="float: none !important;display: inline-block;">
								<label class="text-left">Depth:</label>
								<input class="chart-input" data-property="depth3D" type="range" min="1" max="120" value="40" step="1" />
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>

	</div>




<script src='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/vendor.min.js'></script>
<script src='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/neoui-0.1.0+std.min.js'></script>
<script src="js/detail.js"></script>
</body>

</html>