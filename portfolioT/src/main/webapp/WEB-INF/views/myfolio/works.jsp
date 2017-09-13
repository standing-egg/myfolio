<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#works-box {
	padding-top: 7em;
	height: 100%;
	width: 100%;
}
#card-container {
	height: 100%;
	margin: 0 auto;
    width: 1120px;
}
.card {
	font-size: 1rem;
    width: 28em;
    background: #fff;
    text-align: left;
    /* border: 1px solid black;
	border-bottom-color: black; */
	border-radius: .25em;
    margin: 0 1.6% 4em;
    box-shadow: 0 0 0 0 rgba(0,0,0,.1);
    float: left;
}
.footer {
	text-align: center;
	padding: 1em;
	background-color: whitesmoke;
	border-radius: .25em;
}
img {
	width: 28em;
	display: block;
}
a {
	color: #010101;
	text-decoration: none;
}
</style>
</head>
<body>
<div id="works-box">
<div id="card-container">
	<div class="card">
		<a href="/myfolio/summary">
			<div class="content">
				<img src="../resources/image/works-summary.JPG" alt="" />
			</div>
			<div class="footer">
				<p>텍스트 세줄 요약</p>
				<p>오리백숙</p>
			</div>
		</a>
	</div>
	<div class="card">
		<a href="/myfolio/news">
			<div class="content">
				<img src="../resources/image/works-news.JPG" alt="" />
			</div>
			<div class="footer">
				<p>세 줄 요약 뉴스</p>
				<p>오리백숙</p>
			</div>
		</a>
	</div>
	<div class="card">
		<a href="/myfolio/tetris">
			<div class="content">
				<img src="../resources/image/works-tetris.JPG" alt="" />
			</div>
			<div class="footer">
				<p>테트리스</p>
				<p>오리백숙</p>
			</div>
		</a>
	</div>
</div>
</div>
</body>
</html>