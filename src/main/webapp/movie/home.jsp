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

<link rel='stylesheet prefetch' href='https://cdn.jsdelivr.net/bootstrap.material-design/0.5.8/css/bootstrap-material-design.min.css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/wrapper.css">
<link rel="stylesheet" href="css/radio.css">
<link rel="stylesheet" href="css/search.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdn.jsdelivr.net/bootstrap.material-design/0.5.8/js/material.min.js'></script>
</head>
<body>
	
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

						<div calss="container">
							<div class="centrado">
								<h2 class="genre">장르별</h2>
								<!-- Radio button por defecto ********-->
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios1"
										value="option1"  type="radio"> 드라마
									</label>
								</div>
								<!-- Radio button de color ***********-->
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios2"
										value="option2" type="radio"> 공포
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios3"
										value="option3" type="radio"> 가족
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios4"
										value="option4" type="radio"> 액션
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios5"
										value="option5" type="radio"> 로맨스
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios6"
										value="option6" type="radio"> 판타지
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios7"
										value="option7" type="radio"> 스릴러
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios8"
										value="option8" type="radio"> 코믹
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios" id="optionsRadios9"
										value="option9" type="radio"> 미스테리
									</label>
								</div>
							</div>
							
							<div class="centrado1">
								<h2 class="genre">감성별</h2>
								<!-- Radio button por defecto ********-->
								<div class="radio radio-primary">
									<label> <input name="optionsRadios1" id="optionsRadios11"
										value="option11" type="radio"> 로맨스
									</label>
								</div>
								<!-- Radio button de color ***********-->
								<div class="radio radio-primary">
									<label> <input name="optionsRadios1" id="optionsRadios12"
										value="option12" type="radio"> 슬픔
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios1" id="optionsRadios13"
										value="option13" type="radio"> 재미
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios1" id="optionsRadios14"
										value="option14" type="radio"> 공포
									</label>
								</div>
								<div class="radio radio-primary">
									<label> <input name="optionsRadios1" id="optionsRadios15"
										value="option15" type="radio"> 액션
									</label>
								</div>
							
							</div>
							
							
							<div class="centrado2" style="display: none">
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-21"
											value="option21" checked="" type="radio"> 사랑
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-22"
											value="option22" checked="" type="radio"> 행복
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-23"
											value="option23" checked="" type="radio"> 감동
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-24"
											value="option24" checked="" type="radio"> 순수
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-25"
											value="option25" checked="" type="radio"> 힐링
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-26"
											value="option26" checked="" type="radio"> 애정
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-27"
											value="option27" checked="" type="radio"> 로맨틱
										</label>
								</div>
							</div>
							
							
							
							<div class="centrado3" style="display: none">
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-31"
											value="option31" checked="" type="radio"> 감성
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-32"
											value="option32" checked="" type="radio"> 우울
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-33"
											value="option33" checked="" type="radio"> 절망
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-34"
											value="option34" checked="" type="radio"> 애잔
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-35"
											value="option35" checked="" type="radio"> 아픔
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-36"
											value="option36" checked="" type="radio"> 연민
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-37"
											value="option37" checked="" type="radio"> 비극
										</label>
								</div>
							</div>
							
							
							<div class="centrado4" style="display: none">
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-41"
											value="option41" checked="" type="radio"> 즐거움
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-42"
											value="option42" checked="" type="radio"> 웃음
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-43"
											value="option43" checked="" type="radio"> 유머
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-44"
											value="option44" checked="" type="radio"> 개그
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-45"
											value="option45" checked="" type="radio"> 코미디
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-46"
											value="option46" checked="" type="radio"> 코믹
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-47"
											value="option47" checked="" type="radio"> 일상
										</label>
								</div>
							</div>
							
							
							
							<div class="centrado5" style="display: none">
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-51"
											value="option51" checked="" type="radio"> 스릴
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-52"
											value="option52" checked="" type="radio"> 소름
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-53"
											value="option53" checked="" type="radio"> 긴장
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-54"
											value="option54" checked="" type="radio"> 반전
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-55"
											value="option55" checked="" type="radio"> 호러
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-56"
											value="option56" checked="" type="radio"> 충격
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-57"
											value="option57" checked="" type="radio"> 귀신
										</label>
								</div>
							</div>
							
							
							
							<div class="centrado6" style="display: none">
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-61"
											value="option61" checked="" type="radio"> 할리우드
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-62"
											value="option62" checked="" type="radio"> 대박
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-63"
											value="option63" checked="" type="radio"> 감탄
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-64"
											value="option64" checked="" type="radio"> 연기력
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-65"
											value="option65" checked="" type="radio"> 모험
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-66"
											value="option66" checked="" type="radio"> 범죄
										</label>
								</div>
								<div class="radio radio-primary2">
										<label> <input name="optionsRadios2" id="detailradio-67"
											value="option67" checked="" type="radio"> 스펙타클
										</label>
								</div>
							</div>
						</div>
								<div class="btn-total">
									<input type="button" value="검색" id="btn-keep">	
								</div>
							</section> </section>
						
					</div>
		
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
<script src="js/wrapper.js"></script>
<script src="js/radio.js"></script>
<script src="js/search.js"></script>
<script src="js/index.js"></script>

</body>

</html>