<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/list.css">

</head>
<body>
	<ul id="portfolio-list">
	  <c:forEach var="vo" items="${list}">
		<li class="item video">
			<div class="item-body">
				<div class="item-image">
					<img
						src="${vo.poster}"
						alt="veteran memories project documentary screenshot" />
					<p id="title">${vo.title}</p>
					<p id="actor">출연:${vo.actor}</p>
					<p id="grade">등급:${vo.rating}</p>
					
				</div>
				<div class="item-content">
					<h5>곡성</h5>
					<p>
						<strong>${vo.synopsis}</strong>
					</p>
				</div>
			</div>
		</li>
		</c:forEach>
	</ul>


	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="js/list.js"></script>

</body>
</html>