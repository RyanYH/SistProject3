<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet prefetch' href='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/neoui-0.1.0.min.css'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/detail.css">
</head>
<body>
<div id="top-bar">
		<div id="small-logo">상세 정보</div>
	</div>

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
					<li class="newsli">리뷰입니다</li>
			</ul>
		</div>
	</div>

<script src='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/vendor.min.js'></script>
<script src='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/neoui-0.1.0+std.min.js'></script>
<script src="js/detail.js"></script>
</body>

</html>