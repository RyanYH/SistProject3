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
	  <c:forEach var="vo" items="${list}">
		<li class="item video">
			<div class="item-body">
			<form action="detail.do?no=${vo.no}" method="post" class="listFrm">
				<div class="item-image">
					<img
						src="${vo.poster}"
						alt="veteran memories project documentary screenshot" />
					<p id="title">${vo.title}</p>
					<p id="actor">출연:${vo.actor}</p>
					<p id="grade">평점:${vo.grade}점</p>
					<p id="rat">등급:${vo.rating}</p>
					<article class="review review-1">
                  <c:if test="${vo.grade<=2}">
                  <span class="ratings one"></span>
                  </c:if>
                  <c:if test="${vo.grade==3}">
                  <span class="ratings onehalf"></span>
                  </c:if>
                  <c:if test="${vo.grade==4}">
                  <span class="ratings two"></span>
                  </c:if>
                  <c:if test="${vo.grade==5}">
                  <span class="ratings twohalf"></span>
                  </c:if>
                  <c:if test="${vo.grade==6}">
                  <span class="ratings three"></span>
                  </c:if>
                  <c:if test="${vo.grade==7}">
                  <span class="ratings threehalf"></span>
                  </c:if>
                  <c:if test="${vo.grade==8}">
                  <span class="ratings four"></span>
                  </c:if>
                  <c:if test="${vo.grade==9}">
                  <span class="ratings fourhalf"></span>
                  </c:if>
                  <c:if test="${vo.grade==10}">
                  <span class="ratings"></span>
                  </c:if>
                  
               	</article>
					
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
	</ul>

	
	

	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="js/list.js"></script>

</body>
</html>