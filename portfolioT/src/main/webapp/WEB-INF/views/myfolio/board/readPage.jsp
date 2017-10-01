<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/board/css/board.css" >
<style type="text/css">
/* .form-control {
	background-color: white;
}
.content-info {
	margin-right: 2em;
}
#text {
	padding: 1em;
}
.content {
	width: 80%;
	margin: 0 auto;
	padding: 3%;
	padding-bottom: 0;
}
.box-body {
	background-color: white;
}
.tab-box {
	margin: 1em 0 1em 0;
}
.searchType {
	height: 2em;
}
th, tr>td {
	text-align: center;
	font-weight: bold;
}
a {
	color: black;
}
#writing-box {
	margin: 1em auto;
}
.reading {
	cursor: pointer;
} */
</style>
<script src="../resources/board/js/board.js"  defer="defer"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#list").load("chatBoard #list");
});
/* $(document).on("click", "#writeBtn", function(){
	$("#content").remove();
	$("#writing-box").load("writePage");
	href = href.replace(/\#content/ig, "");
	history.pushState(null, null, "/board/chatBoard");
	$('html, body').stop().animate({ scrollTop : 0 });
});
$(document).on("click", "#write", function(){
	var fm = $("form[role='form']");
	fm.submit();
	$("form[role='form']")[0].reset();
});
$(document).on("click", "#cancel", function(){
	location.href = "/board/chatBoard";
});
$(document).on("click", ".reading", function(){
	var href = $(this).attr("value");
	$("#content").remove();
	$("#writing-box").load(href);
	//href = href.replace(/\#content/ig, "");
	history.pushState(href, null, href.replace(/\#content/ig, ""));
	$('html, body').stop().animate({ scrollTop : 0 });
});
$(window).on('popstate', function(event) {
	$("#content").remove();
	var data = event.originalEvent.state;
    $("#writing-box").load(data);
	$('html, body').stop().animate({ scrollTop : 0 });
}); */
</script>
</head>
<body>
<div class="content">

	<div id="container">
	
		<div class="tab-box">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">잡담 게시판</a></li>
				<li role="presentation"><a href="#">질문 게시판</a></li>
				<li role="presentation"><a href="#">문제 게시판</a></li>
			</ul>
		</div>
			
		<div id="writing-box" class="box">
		</div>
		<div class="box box-primary" id="content">
			<div class="box-header">
				<h3 class="box-title">${boardVO.title}</h3>
			</div>
			<p>
				<span class="content-info">
					작성자 <strong>${boardVO.writer}</strong>
				</span>
				<span class="content-info">
					<strong><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}" /></strong>
				</span>
				<span class="content-info">
					조회수 <strong>${boardVO.hits }</strong>
				</span>
				<span class="content-info" id="up">
					추천 <strong>${boardVO.up }</strong>
				</span>
				<span class="content-info">
					주소 <strong>/board/readPage&bno=${boardVO.bno}</strong>
				</span>
				<span id="toList">목록</button>
			</p>
			<!-- /.box-header -->
	
			<form role="form" method="post">
	
				<input type='hidden' name="page" value="${cri.page }" />
				<input type='hidden' name='bno' value="${boardVO.bno}">
				<%-- <input type="hidden" name="perPageNum" value="${cri.perPageNum }" />
				<input type="hidden" name="searchType" value="${cri.searchType}">
				<input type="hidden" name="keyword" value="${cri.keyword }"> --%>
	
			</form>
	
			<label for="exampleInputPassword1">Content</label>
			<div class="box-body">
				<div id="text" class="form-group">
					<p style="white-space: pre-line;">
						${boardVO.content}
					</p>
				</div>
			</div>
			<!-- /.box-body -->
	
			<div class="box-footer">
				<button type="submit" class="btn btn-warning" id="modify">수정</button>
				<button type="submit" class="btn btn-danger" id="remove">삭제</button>
				<button type="submit" class="btn btn-primary" id="upBtn">
					추천 <span class="glyphicon glyphicon-thumbs-up"></span>
				</button>				
			</div>
	
		</div>
		<!-- /.box -->
		<div class='box' id="list"></div>
	</div>

</div>
</body>
</html>