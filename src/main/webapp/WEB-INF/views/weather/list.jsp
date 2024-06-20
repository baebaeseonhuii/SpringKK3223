<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">

</head>
<body>
	<h1 class="h1">Weather List</h1>
	<table class="tbl">
		<thead>
			<tr>
				<th>Num</th>
				<th>City</th>
				<th>Temperature</th>
				<th>Status</th>
				<th>Humidity</th>
			</tr>
		</thead>

		<c:forEach items="${requestScope.weatherList}" var="w">
			<!-- requestScope.weatherList에서 하나 꺼내오는게 w -->
			<tr>
				<td>${pageScope.w.num}</td>
				<!-- w는 for each 안에서만 쓰이는 지역변수라서 pageScope를 씀 -->
				<td><a href="./detail?num=${pageScope.w.num}">${pageScope.w.city}</a></td>
				<td>${pageScope.w.gion}</td>
				<td>${pageScope.w.status}</td>
				<td>${pageScope.w.humidity}</td>
			</tr>
		</c:forEach>


	</table>
	<div class="addButton">
		<a href="./add">ADD WEATHER</a>
	</div>

</body>
</html>