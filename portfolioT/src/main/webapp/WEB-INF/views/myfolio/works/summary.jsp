<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.content {
		position: relative;
		text-align: center;
		top: 4em;
	}
	textarea {
		margin-bottom: 10px;
		padding: 20px;
		color: #999;
		border: 1px solid #ebebeb;
		border-bottom-color: #e2e2e2;
		border-radius: .25em;
		overflow: auto;
	}
	#sumBtn {
		width: 120px;
		height: 40px;
		color: white;
		font-size: large;
		background-color: rgba(0,0,0,0.2);
		border: 1.5px solid white;
		border-bottom-color: white;
		border-radius: .25em;
	}
	#sumBtn:hover {
		cursor: pointer;
		background-color: rgba(0,0,0,0.4);
		border: 1px solid rgba(0,0,0,0.4);
	}
	#summary {
		width: 40%;
		height: 15em;
		margin-left: auto;
		margin-right: auto;
		margin-top: 10px;
		padding: 20px;
		color: black;
		border: 1px solid #ebebeb;
		border-bottom-color: #e2e2e2;
		border-radius: .25em;
		background-color: white;
		text-align: left;
		font-size: 13px;
		overflow: auto;
	}
	#loading {
		position: absolute;		
		display: table;
		text-align: center;
		width: 100%;
		top: 20%;
	}
	#layer {
		background-color: rgba(0,0,0,0.4);
		color: white;
		font-size: 30px;
		/* display: table-cell;
		vertical-align: middle; */
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#sumBtn").click(function(){
			$("#layer").prop("hidden", false);
			var article = $("#article").val();
			article = article.replace(/\n/g, " ");
			$.ajax({
			    method: 'post',
			    url: "/myfolio/summary",
			    headers: {
			    	"Content-Type": "application/json",
					"X-HTTP-Mathod-Override": "POST"
			    },
			    dataType: "json", // 응답 데이터 타입
			    data: JSON.stringify(article),
			    success: function(result){
			    	var sentence = "";
			    	$.each(result, function(index, item){
			    		sentence +=
							"<p class='text'>"
								+this
							+"</p>"
					});
					$("#summary").html(sentence);
					$("#layer").prop("hidden", true);
			    },
			    error: function(){
					$("#layer").prop("hidden", true);
			        //alert("요약할 글을 입력해주세요.");
			    } 
			});
		});
	})

</script>
</head>
<body>
<div class="content">
	<form id="fm" >
		<textarea id="article" name="article" cols="90" rows="20" placeholder="이곳에 글을 입력해주세요.."></textarea>
	</form>
		<div>
			<Button id="sumBtn" >SUMMARY</button>
		</div>
	<div id="summary" >
	</div>
</div>
	<div id="loading"><p id="layer" hidden="true">진행중입니다...</p></div>
</body>
</html>