<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
</head>
<body>
	<nav role="navigation" class="nav_bar">
	<div class="nav_logo">
		<span>Site Logo</span>
		<svg xmlns="http://www.w3.org/2000/svg"
			xmlns:xlink="http://www.w3.org/1999/xlink" width="87" height="42"
			viewbox="0 0 87 42"> <defs> <path id="a"
			d="M-577-60H663v2000H-577z"></path> </defs> <clippath id="b"> <use
			xlink:href="#a" overflow="visible"></use> </clippath> <g clip-path="url(#b)">
		<defs> <path id="c"
			d="M41.004 0C29.404 0 20 9.4 20 21c0 11.598 9.4 21 21.004 21h10.992C63.596 42 73 32.6 73 21 73 9.402 63.6 0 51.996 0H41.004z"></path>
		</defs> <clippath id="d"> <use xlink:href="#c" overflow="visible"></use>
		</clippath> <path clip-path="url(#d)" fill="none" stroke="#B0B3C4"
			stroke-width="10" stroke-miterlimit="10"
			d="M41.004 0C29.404 0 20 9.4 20 21c0 11.598 9.4 21 21.004 21h10.992C63.596 42 73 32.6 73 21 73 9.402 63.6 0 51.996 0H41.004z"></path>
		</g> <g id="knife"> <defs> <path id="e"
			d="M-577-60H663v2000H-577z"></path> </defs> <clippath id="f"> <use
			xlink:href="#e" overflow="visible"></use> </clippath> <g clip-path="url(#f)">
		<defs> <path id="g"
			d="M85.323 5.945l-6.323 15 5.01 2.377s.762 9.735 1.012 12.623c.62 1.764 2.003.752 2.003 0v-30s-.78-1.957-1.702 0z"></path>
		</defs> <clippath id="h"> <use xlink:href="#g" overflow="visible"></use>
		</clippath> <path clip-path="url(#h)" fill-rule="evenodd" clip-rule="evenodd"
			fill="#B0B3C4" d="M74 .075h18.025v41.85H74z"></path> </g> </g> <g id="fork">
		<defs> <path id="i" d="M-577-60H663v2000H-577z"></path> </defs> <clippath
			id="j"> <use xlink:href="#i" overflow="visible"></use> </clippath> <g
			clip-path="url(#j)"> <defs> <path id="k"
			d="M9.928 7h1.355l2.272 15-5.628 1.674V37c-.982 2.084-2 0-2 0V23.674L.3 22 2.572 7h1.355v13c1 1.45 2 0 2 0V7h2v13c.974 1.33 2 0 2 0V7z"></path>
		</defs> <clippath id="l"> <use xlink:href="#k" overflow="visible"></use>
		</clippath> <path clip-path="url(#l)" fill-rule="evenodd" clip-rule="evenodd"
			fill="#B0B3C4" d="M-4.7 2h23.256v40.926H-4.7z"></path> </g> </g> </svg>
	</div>
	<div class="nav_toggle">
		<span class="hamb_toggle"><span class="line line-1"></span><span
			class="line line-2"></span><span class="line line-3"></span></span><span
			class="toggle_name">MENU</span>
	</div>
	</nav>
	<div role="main" class="blocks_container">
		<div class="nav_overlay">
			<div class="fix_top">
				<svg xmlns="http://www.w3.org/2000/svg" width="349.629"
					height="349.629" viewbox="0 0 349.629 349.629"> <path
					d="M174.827 73.433L0 253.42l23.434 22.77 151.393-155.872 151.39 155.878 23.412-22.776"></path>
				</svg>
			</div>
			<nav class="overlay_menu">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">Work</a></li>
				<li><a href="#">Blog</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			</nav>
		</div>
		<div
			style="background-image: url('https://images.unsplash.com/photo-1458053688450-eef5d21d43b3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&s=8d815ef30a5abbb17a9f634bc58c5e6e')"
			class="big_block">
			<div class="block_content">
				<h2>A Modern Twist on a Classic</h2>
				<h4>Eggs with avocado and salsa in a soft corn tortilla</h4>
				<form class="search" action="">
					<input type="search" placeholder="Search here..." required>
					<button type="submit">Search</button>
				</form>


			</div>
		</div>
		<div class="middle_block_container">
			<div class="b_half">
				<div
					style="background-image: url('https://images.unsplash.com/photo-1452745943986-be0a25cd68b4?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&s=3856bbca23bf680d6f79f40a0dc12de5')"
					class="medium_block medium_tall">
					<div class="block_content">
						<section class="wrapper"> <section
							class="material-design-hamburger">
						<button class="material-design-hamburger__icon">
							<span class="material-design-hamburger__layer"></span>
						</button>
						</section> <section class="menu menu--off">

						<div class="container">
							<div class="centrado">
								<h2 class="genre">장르별</h2>
								<!-- Radio button por defecto ********-->
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios1"
										value="option1" checked="" type="radio"> 드라마
									</label>
								</div>
								<!-- Radio button de color ***********-->
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios2"
										value="option2" type="radio"> 공포
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios2"
										value="option3" type="radio"> 가족
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios2"
										value="option4" type="radio"> 액션
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios2"
										value="option5" type="radio"> 로맨스
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios2"
										value="option6" type="radio"> 판타지
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios2"
										value="option7" type="radio"> 스릴러
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios2"
										value="option8" type="radio"> 코믹
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios2"
										value="option9" type="radio"> 미스테리
									</label>
								</div>
							</div>
						</div>
						</section> </section>
					</div>
					<nav>
					<h3 class="genre1">감독,배우검색</h3>
					<div class="nav-search-container">
					
						<input type="search" name="q"
							class="search-input ui-autocomplete-input" value="" accesskey="4"
							autocomplete="off" placeholder="Search Site...">
						<div class="search-select">
							<select id="type">
								<option value="">All Types</option>
								<option value="director">감독</option>
								<option value="actor">배우</option>
							</select>
						</div>
						<div class="submit-container">
							<input class="submit" type="submit" value="Submit">
						</div>
					</div>
					</nav>
				</div>
			</div>
			<div class="b_half">
				<div
					style="background-image: url('https://images.unsplash.com/uploads/1413349410189e2a95d2e/39982a21?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&s=d4bd480137c8dd10d87051f6c33edbfc')"
					class="medium_block peas">
					<div class="block_content">
						<h2 class="genre">통계 그래프</h2>

						<button class="food_cta" style="margin-top: 180px;">Read
							More</button>
					</div>
				</div>
				<div class="small_block recipe" style="width: 620px;">

					<div class="recipe_container">
						<h2> 신성규의 오늘의 영화 추천</h2>
						<p id="ssgRecommand">${todayRec}</p>
						<!-- <input type="text" placeholder="http://www.cgv.co.kr/"
							class="food_input" />
						<div class="check_container">
							<input id="evidence" type="checkbox" checked="checked"
								class="check_box" />
						</div> -->
						<button class="food_cta">상세보기</button>
					</div>
				</div>
				<!-- <div class="small_block">
               <div class="small_block_container">
                  
               </div>
            </div> -->
			</div>
		</div>
		<div class="last_blocks_container">
			<div class="last_half" style="background-image: url('https://images.unsplash.com/photo-1416163026265-0bc340a710e4?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&s=0f7fc2012b23b81301ef98d179fbb603')">
			<h3 id="boxoffice">Box Office</h3>
			<c:forEach var="box" items="${boxOffice}">
				<div class="boxDiv">
					<img src="${box.image}" width=100 height=150 border=0>
					<p>${box.title}</p>
					<font color="red"> 예매율 &nbsp;</font>${box.percent}
					<p>♥${box.like }</p>
					
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
	<footer role="contentinfo" class="footer">&copy; 2016 Movie Magazine</footer>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
<script src='https://cdn.jsdelivr.net/bootstrap.material-design/0.5.8/js/material.min.js'></script>
<script src="js/radio.js"></script>
<script src="js/wrapper.js"></script>
<script src="js/search.js"></script>
<script src="js/index.js"></script>

</body>

</html>