<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/list.css">
<link rel='stylesheet prefetch'
	href='http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css'>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script type="text/javascript">
$(function(){
	$(".listFrm").click(function(){
		$(this).submit();
	});
});

</script>
</head>
<body>
	<div id="top-bar">
		<div id="small-logo">검색 결과</div>
	</div>

	
	
	<ul id="portfolio-list">
	  <c:if test="${list!=null}">
	  <c:forEach var="vo" items="${list}">
		<li class="item video">
			<div class="item-body">
			<form action="detail.do?no=${vo.no}" method="post" class="listFrm">
				<div class="item-image">
					<img
						src="${vo.poster}"
						alt="veteran memories project documentary screenshot" />
					<p id="title">${vo.title}</p>
					<p id="director">감독:${vo.director}</p>
					<p id="actor">출연:${vo.actor}</p>
					<article class="review review-1">
					  <c:choose>
					     <c:when test="${vo.grade<=2}">
					        <span class="ratings one"></span>
					     </c:when>
					     <c:when test="${vo.grade<=3}">
					        <span class="ratings onehalf"></span>
					     </c:when>
					     <c:when test="${vo.grade<=4}">
					        <span class="ratings two"></span>
					     </c:when>
					     <c:when test="${vo.grade<=5}">
					        <span class="ratings twohalf"></span>
					     </c:when>
					     <c:when test="${vo.grade<=6}">
					        <span class="ratings three"></span>
					     </c:when>
					     <c:when test="${vo.grade<=7}">
					        <span class="ratings threehalf"></span>
					     </c:when>
					     <c:when test="${vo.grade<=8}">
					        <span class="ratings four"></span>
					     </c:when>
					     <c:when test="${vo.grade<=9}">
					        <span class="ratings fourhalf"></span>
					     </c:when>
					     <c:otherwise>
					     	<span class="ratings"></span>
					     </c:otherwise>
					  </c:choose>
               	</article>
					<p id="grade">${vo.grade}점</p>
					<p id="rat">등급:${vo.rating}</p>
					
				</div>
				<div class="item-content">
					<h5>${vo.title}</h5>
					<p>
						<strong>${vo.synopsis}</strong>
					</p>
				</div>
			</form>
			</div>
		</li>
		
		</c:forEach>
		
		</c:if>
		<c:if test="${list==null}">
			<li class="item video">
				<div class="item-body">
					<div class="item-image">
						<p>검색된 결과가 없습니다.</p>
						<p><a href="home.do">홈으로</a></p>
					</div>
				</div>
			</li>
		</c:if>
	</ul>
	
   
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="js/list.js"></script>
	
	<c:if test="${chartTitle!=null}">
		<canvas id="bar-chart" width="200" height="200"></canvas>
	</c:if>
	
    <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.0/Chart.min.js'></script>
	<script type="text/javascript">
	var bar_ctx = document.getElementById('bar-chart').getContext('2d');

	var purple_orange_gradient = bar_ctx.createLinearGradient(0, 0, 0, 600);
	purple_orange_gradient.addColorStop(0, 'orange');
	purple_orange_gradient.addColorStop(1, 'purple');

	var bar_chart = new Chart(bar_ctx, {
	    type: 'bar',
	    data: {
	        labels: [<%=request.getAttribute("chartTitle")%>],
	        
	        datasets: [{
	            label: '<%=request.getAttribute("chartFeel")%>',
	            data: [<%=request.getAttribute("chartCount")%>],
							backgroundColor: purple_orange_gradient,
							hoverBackgroundColor: purple_orange_gradient,
							hoverBorderWidth: 2,
							hoverBorderColor: 'purple'
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true
	                }
	            }]
	        }
	    }
	});
    </script>
<c:if test="${pieChart!=null}">
	<div id="chartdiv"></div>
	   <div class="container-fluid">
		  <div class="row text-center" style="overflow:hidden;">
			<div class="col-sm-3" style="float: none !important;display: inline-block;">
				<label class="text-left">Angle:</label>
				<input class="chart-input" data-property="angle" type="range" min="0" max="60" value="30" step="1"/>	
			</div>
	
			<div class="col-sm-3" style="float: none !important;display: inline-block;">
				<label class="text-left">Depth:</label>
				<input class="chart-input" data-property="depth3D" type="range" min="1" max="25" value="10" step="1"/>
			</div>
			<div class="col-sm-3" style="float: none !important;display: inline-block;">
				<label class="text-left">Inner-Radius:</label>
				<input class="chart-input" data-property="innerRadius" type="range" min="0" max="80" value="0" step="1"/>
			</div>
		</div>
	</div>
</c:if>
<script src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="http://www.amcharts.com/lib/3/pie.js"></script>
<script src="http://www.amcharts.com/lib/3/themes/light.js"></script>
<script type="text/javascript">
var chart = AmCharts.makeChart( "chartdiv", {
	  "type": "pie",
	  "theme": "light",
	  "dataProvider": 
		<%=request.getAttribute("pieChart")%>
	  "valueField": "value",
	  "titleField": "country",
	  "outlineAlpha": 0.4,
	  "depth3D": 15,
	  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
	  "colorField": "color",
	  "angle": 30,
	  "export": {
	    "enabled": true
	  }
	} );
	jQuery( '.chart-input' ).off().on( 'input change', function() {
	  var property = jQuery( this ).data( 'property' );
	  var target = chart;
	  var value = Number( this.value );
	  chart.startDuration = 0;

	  if ( property == 'innerRadius' ) {
	    value += "%";
	  }

	  target[ property ] = value;
	  chart.validateNow();
	} );
</script>

</body>
</html>