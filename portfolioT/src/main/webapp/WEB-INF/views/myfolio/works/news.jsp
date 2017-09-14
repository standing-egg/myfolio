<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
#content {
	padding-top: 5.5em;
	margin: 0 auto;
	width: 80%;
}
#selectJournal {
	position: fixed;
	width: 80%;
	height: 3em;
	padding: 0 10%;
	top: 2em;
	background-color: rgba(0,0,0,.3);
}

.box-left {
	float: left;
	margin: 0 auto;
}

.news {
	float: left;
	width: 300px;
	height: 100%;
	margin: 0 0 2em 2em;
	padding-right: 20px;
	padding-left: 20px;
	padding-bottom: 20px;
	color: black;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
	background-color: white;
	text-align: left;
	font-size: 13px;
}

.box-right {
	position: fixed;
    padding-left: 25%;
    padding-top: 10%;
    width: 100%;
    height: 100%;
    top:0;
    background-color: rgba(0,0,0,.3);
}

iframe {
	position: relative;
	margin: 0 auto;
	min-height: 65%;
	width: 50%;
	border: 0 solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
	background-color: white;
}

.title {
	text-align: center;
	font-weight: bolder;
}

a {
	color: #010101;
	text-decoration: none;
}

.linkBtn {
	float: right;
	border: 1px solid #74c9bb;
	border-bottom-color: #74c9bb;
	border-radius: .20em;
	background-color: #74c9bb;
	color: white;
	font-weight: bold;
	text-align: center;
	width: 80px;
	height: 20px;
	cursor: pointer;
}
.journal>a {
	font-weight: bold;
	color: #74c9bb
}
hr, .journal {
	margin: 1em;
}
#journalName {
	margin-top: 1em;
	padding:.3em .7em;
}
/* .linkBtn{
		margin-top:2em;
	} */
/* .news h3{
		padding:1em 0;
		border-bottom:solid 1px black;
	} */
/* .news .text{
		padding-top:.7em;
	} */
/* #summaryNews {
	width: 100%;
} */
</style>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#journalName").change(function(){
			$("#journalName option:selected").each(function(){
				var journalName = $(this).val();
				/* console.log(journalName);
				if (journalName=="1"){
					link = "http://newspeppermint.com/"
					$("iframe").attr("src", link);
				} else if(journalName=="2") {
					link = "http://h21.hani.co.kr/"
					$("iframe").attr("src", link);
				} else {
					link = "http://www.khan.co.kr/"
					$("iframe").attr("src", link);					
				} */
				$.ajax({
				    method: 'post',
				    url: "/works/news",
				    headers: {
				    	"Content-Type": "application/json; charset=UTF-8",
						"X-HTTP-Mathod-Override": "post"
				    },
				    dataType: "json", // 응답 데이터 타입
				    data: JSON.stringify(journalName),
				    success: function(result){
							var news = "";
							$.each(result, function(index, item){
								//console.log(item);
								news += 
									"<li class='news'>"
										+"<p class='journal'>"
											+"<a href='"+this.journalLink+"'>"
												+this.journal
											+"</a>"
										+"</p>"
									+"<h3 class='title'>"
									+"<a href='"+this.href+"' class='link'>"
										+this.title
									+"</a>"
									+"</h3>"
									+"<hr />"
									+$.each(this.sumArticle, function(index, item){
										+"<p class='text'>"
											+this
										+"</p>"
									})
									+"<div class='linkBtn' value='"+this.href+"'>"
										+"원문 보기"
									+"</div>"
									+"</li>"
							});
							$(".news").remove();
							$("#summaryNews").html(news);
				    },
				    error: function(){
						
				    } 
				});
			});
		});
		$(".box-right").on("click",function(){
			$(".box-right").prop("hidden", true);
		});
		console.log(journalName);			
		$(document).on("click", ".linkBtn", function() {
			var link = $(this).attr("value");
			console.log(link);
			$("iframe").attr("src", link);
			$(".box-right").prop("hidden", false);
		});
		
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="selectJournal">
		<select name="journalName" id="journalName">
			<option id="Peppermint" value="1">뉴스페퍼민트</option>
			<option id="hani21" value="2">한겨레21</option>
			<option id="khan" value="3">경향신문</option>
		</select>
	</div>
	<div class="box-right" hidden="true">
		<iframe id="inner" src=""></iframe>
	</div>
	<div id="content">
		<div class="box-left">
			<ul id="summaryNews" style="list-style: none;">
				<c:forEach items="${articles }" var="articles">
					<li class="news">
						<p class="journal">
							<a href="${articles.journalLink }">${articles.journal }</a>
						</p>
						<h3 class="title">
							<a href="${articles.href }" class="link">${articles.title}</a>
						</h3>
						<hr />
						<c:forEach items="${articles.sumArticle }"
							var="articles.sumAtricle" varStatus="status">
							<p class="text">${articles.sumArticle[status.index] }</p>
						</c:forEach>
						<div class="linkBtn" value="${articles.href }">
							원문 보기
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>