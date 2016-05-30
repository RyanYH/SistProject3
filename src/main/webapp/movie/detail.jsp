<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet prefetch'
	href='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/neoui-0.1.0.min.css'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<script type="text/javascript"
	src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script type="text/javascript"
	src="http://www.amcharts.com/lib/3/serial.js"></script>
<script type="text/javascript"
	src="http://www.amcharts.com/lib/3/themes/none.js"></script>
<script src='https://code.jquery.com/jquery-1.11.2.min.js'></script>
<link rel="stylesheet" href="css/detail.css">
<script type="text/javascript">
$(function(){
	 	$("#linkHomeBtn").click(function(){
	 		location.href="home.do";
	 	})
});
var chart = AmCharts.makeChart("chartdiv", {
    "theme": "none",
    "type": "serial",
	"startDuration": 2,
    "dataProvider": 
    	<%=request.getAttribute("chart")%>
    
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
	<div id="top-bar">
		<div id="small-logo">상세 정보</div>
		<button value="home" id="linkHomeBtn">Home</button>
	</div>

	<div id="rate" ng-app="demo.rate" ng-controller="rateController">
		<div class="movie center-block">
			<div class="cover">
				<div class="skew">
					<img
						src="https://images.unsplash.com/photo-1429595518497-e7e060d84f7d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&s=833be352b819594acd95b997fe6a4693">

					<div class="meta">
						<p class="subhead">${vo.title}</p>
						<p>
							<span>${vo.rating}</span> <span>${vo.time}</span> <span>${vo.grade}</span>
						</p>
						<s-rate ng-model="rate" ng-init="rate = ${vo.grade/2}"></s-rate>
						<span> <i class="md-icon-favorite"></i> ${vo.gradeCount}
							likes
						</span>
					</div>
				</div>
			</div>
			<div class="info">
				<div class="preview">
					<div class="min">
						<img src="${vo.poster}">
					</div>
				</div>

				<div class="desc">
					<p class="director">
						<b>감독:</b>${vo.director}
					</p>
					<p class="stars">
						<b>배우:</b> ${vo.actor}
					</p>
					<p class="stars">
						<b>장르:</b> ${vo.genre}
					</p>
					<p>${vo.synopsis}</p>
				</div>
			</div>
		</div>
		<div class="content-back">
		<h2 class="tex">감성 분포 그래프</h2>
		
			<ul id="newsul">
				<li class="newsli"><c:if test="${chart!=null}">
						<div id="chartdiv"></div>
					</c:if> <c:if test="${chart==null}">
						<div id="chartxx">영화에 대한 평가가 없습니다</div>
					</c:if></li>
			</ul>
			<ul id="recom">
			<h2 class="tex1">장르 추천 영화</h2>
			<c:forEach items="${genlist }" var="gen" begin="0" end="2">
				<li class="recomlist">
					<p>
						<a href="detail.do?no=${gen.no }"><img src="${gen.poster }"></a>
					</p>
					<p>${gen.title }</p>
					<p>${gen.grade }</p>
				</li>
			</c:forEach>
		</ul>
		</div>
	</div>
	<!-- <div id="recom">
		
	</div> -->

	<script
		src='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/vendor.min.js'></script>
	<script
		src='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/neoui-0.1.0+std.min.js'></script>
	<script src="js/detail.js"></script>
</body>

</html>