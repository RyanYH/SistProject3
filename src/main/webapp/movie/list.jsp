<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/list.css">
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
	<ul id="portfolio-list">
		<c:forEach var="vo" items="${list}">
		
		<li class="item video">
			<div class="item-body">
			<form action="detail.do" method="post" class="listFrm">
				<div class="item-image">
					<img
						src="${vo.poster}"
						alt="veteran memories project documentary screenshot" />
					<p id="title">${vo.title}</p>
					<p id="actor">출연:${vo.actor}</p>
					<p id="total">감독:${vo.director}</p>
					<p id="grade">등급:${vo.rating}</p>
					<input type="hidden" value="${vo.no}" name="no"/>
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