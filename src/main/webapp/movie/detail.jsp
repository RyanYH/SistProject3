<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel='stylesheet prefetch'
	href='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/neoui-0.1.0.min.css'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>

<link rel="stylesheet" href="css/detail.css">


</head>
<body>
	<div id="rate" ng-app="demo.rate" ng-controller="rateController">
		<div class="movie center-block">
			<div class="cover">
				<div class="skew">
					<img
						src="//image.tianjimedia.com/uploadImages/2014/307/16/B64L7138TZN2.jpg">

					<div class="meta">
						<p class="subhead">Interstellar (2014)</p>
						<p>
							<span>PG-13</span> <span>169 min</span> <span>8.7</span>
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
							src="//www.moviesnet.nl/images/filmnieuws/2014/1410889036/interstellar.jpg">

					</div>
				</div>

				<div class="desc">
					<p>A team of explorers travel through a wormhole in space in an
						attempt to ensure humanity's survival.</p>
					<p class="director">
						<b>감독:</b> <a href="//www.imdb.com/name/nm0634240/?ref_=tt_ov_dr">Christopher
							Nolan</a>
					</p>
					<p class="writers">
						<b>극본:</b> <a href="//www.imdb.com/name/nm0634300/?ref_=tt_ov_wr">Jonathan
							Nolan</a>, <a href="//www.imdb.com/name/nm0634240/?ref_=tt_ov_wr">Christopher
							Nolan</a>
					</p>
					<p class="stars">
						<b>배우:</b> <a href="//www.imdb.com/name/nm0000190/?ref_=tt_ov_st">Matthew
							McConaughey</a>, <a
							href="//www.imdb.com/name/nm0004266/?ref_=tt_ov_st">Anne
							Hathaway</a>, <a href="//www.imdb.com/name/nm1567113/?ref_=tt_ov_st">Jessica
							Chastain</a> | <a
							href="//www.imdb.com/title/tt0816692/fullcredits?ref_=tt_ov_st_sm">See
							full cast and crew</a>
					<div class="action">
						<button class="md-btn md-btn-mint">
							<i class="md-icon-add"></i> Watchlist
						</button>

						<button class="md-btn md-btn-coral">Watch Trailer</button>
					</div>
				</div>
			</div>
		</div>
		<div class="content-back">
			<ul id="newsul">
					<li class="newsli">리뷰입니다</li>
			</ul>
		</div>
	</div>

	<div id="review">
		<p>123123</p>
	</div>
	<script
		src='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/vendor.min.js'></script>
	<script
		src='http://cdn.rawgit.com/trazyn/neoui-ng/master/dist/neoui-0.1.0+std.min.js'></script>

	<script src="js/detail.js"></script>
</body>
</html>