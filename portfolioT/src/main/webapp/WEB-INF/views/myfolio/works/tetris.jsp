<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../resources/tetris/css/tetris.css?ver=2" >
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src="../resources/tetris/js/types.js"></script>
	<script src="../resources/tetris/js/tetris.js?ver=2" defer="defer"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="box">
	<!-- <p class="test">test area</p> -->
	<div id="stage">
		<input type="text" id="score" value="0" readonly="readonly"/>
		<input type="text" id="time" value="0/100" readonly="readonly"/>
		<div id="handle"></div>
	</div>
</div>
</body>
</html>