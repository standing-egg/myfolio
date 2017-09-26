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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resources/board/css/board.css" >
<style type="text/css">
/* .content {
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
<script src="../resources/board/js/board.js" defer="defer">
/* $(document).ready(function(){
	$("#writeBtn").click(function(){
		$("#writing-box").load("writePage");
		$('html, body').stop().animate({ scrollTop : 0 });
	});
})
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
	<div class="container">
	
		<div class="tab-box">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">잡담 게시판</a></li>
				<li role="presentation"><a href="#">질문 게시판</a></li>
				<li role="presentation"><a href="#">문제 게시판</a></li>
			</ul>
		</div>
		<div id="writing-box" class="box">
		</div>
		
		<div class='box'>
			<div class="box-header with-border">
			</div>
			
			<div class='box'>
				<span style="font-size: 1.5em">Search Board</span>
				<select name="searchType" class="searchType">
					<option value="n"
						<c:out value="${cri.searchType == null ? 'selected' : '' }"/>>
					---</option>
					<option value="t"
						<c:out value="${cri.searchType eq 't' ? 'selected' : '' }"/>>
					Title</option>
					<option value="c"
						<c:out value="${cri.searchType eq 'c' ? 'selected' : '' }"/>>
					Content</option>
					<option value="w"
						<c:out value="${cri.searchType eq 'w' ? 'selected' : '' }"/>>
					Writer</option>
					<option value="tc"
						<c:out value="${cri.searchType eq 'tc' ? 'selected' : '' }"/>>
					Title OR Content</option>
					<option value="cw"
						<c:out value="${cri.searchType eq 'cw' ? 'selected' : '' }"/>>
					Content OR Writer</option>
					<option value="tcw"
						<c:out value="${cri.searchType eq 'tcw' ? 'selected' : '' }"/>>
					Title OR Content OR Writer</option>
				</select>
				<input type="text" name="keyword" class="searchType" id="keywordInput" value="${cri.keyword }" />
				<button id="searchBtn" class="searchType">Search</button>
			</div>
		</div>
		
		<div class="box" id="list">
			<div class="box-header with-border">
				<h3 class="box-title">LIST PAGE</h3>
			</div>
			<div class="box-body">
				<table class="table table-hover">
					<tr>
						<th style="width: 5%">NO</th>
						<th style="width: 20%">TITLE</th>
						<th style="width: 35%">CONTENT</th>
						<th style="width: 10%">WRITER</th>
						<th>REGDATE</th>
						<th style="width: 5%">HITS</th>
						<th style="width: 5%">good</th>
					</tr>
					<c:forEach items="${list}" var="boardVO">
						<tr>
							<td>${boardVO.bno}</td>
							<td>
								<a value="/board/readPage&bno=${boardVO.bno} #content" class="reading"
									style="text-decoration: none;">
									<c:choose>
										<c:when test="${fn:length(boardVO.title)>13 }">
											${fn:substring(boardVO.title, 0, 12)}
										</c:when>
										<c:otherwise>
											${boardVO.title}
										</c:otherwise>
									</c:choose>
								</a>
							</td>
							<td>
								<a value="/board/readPage&bno=${boardVO.bno} #content" class="reading"
									style="text-decoration: none;">
									<c:choose>
										<c:when test="${fn:length(boardVO.content)>21 }">
											${fn:substring(boardVO.content, 0, 20)}...
										</c:when>
										<c:otherwise>
											${boardVO.content}
										</c:otherwise>
									</c:choose>
								</a>
							</td>
							<td>${boardVO.writer }</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${boardVO.regdate}" /></td>
							<td><span class="badge bg-red">${boardVO.hits }</span></td>
							<td><span class="badge bg-red">${boardVO.up }</span></td>
						</tr>

					</c:forEach>
				</table>
			</div>
			<!-- /.box-body -->

			<div class="box-footer">
			
				<div class="text-center">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
				            <li>
				                <a href="chatBoard?page=${pageMaker.startPage - 1 }">
				                    &laquo;
				                </a>
				            </li>
				        </c:if>
				 
				        <c:forEach begin="${pageMaker.startPage }"
				        end="${pageMaker.endPage }" var="idx">
				            <li
				                <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
				                <a href="chatBoard?page=${idx}">${idx}</a>
				            </li>
				        </c:forEach>
				 
				        <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				            <li>
				                <a href="chatBoard?page=${pageMaker.endPage +1 }">
				                    &raquo;
				                </a>
				            </li>
				        </c:if>
					</ul>
					<button id="writeBtn" class="btn btn-primary pull-right">Writing</button>
				</div>					
				
			</div>
			<!-- /.box-footer-->
		</div>
	</div>
</div>
<!-- /.content -->

</body>
</html>