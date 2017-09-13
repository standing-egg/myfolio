<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}
	html {
		height: 100%;
		background: url('../resources/image/bg.png') no-repeat center center fixed;
		background-size: cover;
	}
	body {
		height: inherit;
	}
	
	#typo {
		/* z-index: -1; */
		width: 100%;
		height: 100%;
		background-color: rgba(0,0,0,0.2);
		position: /* absolute */ fixed;
		display: table;
	}
	#sentence {
		display:table-cell;
		vertical-align: middle;
		position: absolute;
		top: 30%;
		left: 25%;
		color: #fff;
		text-align: right;
	}
	#text1 {
		font-weight: bold;
		font-size: 3.7em;
		font-family: sans-serif;
		/* line-height: 2em; */
	}
	#text2 {
		font-size: 20px;
	}
	
	.ghost {
		width: 100%;
		bottom: 25%;
		position: absolute;
		text-align: center;
	}
	.ghost-btn {
		display: inline-block;
		position: relative;
		margin-right: 15px;
		margin-left: 15px;
		width: 200px;
		height: 50px;
		border: 2px solid #fff;
		border-style: ridge;
		color: #fff;
		text-align: center;
		text-decoration: none;
		font-size: 38px;
		/* font-weight: bolder; */
	}
	.ghost-btn:hover {
		background-color: #083777;
		border: 2px solid #083777;
	}
	#mask {
		position: absolute;
		z-index: 9999;
		background-color: #000;
		display: none;
		left: 0;
		top: 3em;
	}
	@MEDIA screen and (max-width: 930px) {
		#sentence {
			top: 20%;
			right: 10%;
		}
		#text1 {
			font-size: 3em;
		}
		#text2 {
			font-size: 17px;
		}
	}
	@MEDIA screen and (max-width: 365px) {
		#sentence {
			top: 10%;
			right: 10%;
		}
		#ghost {
			bottom: 100px;
		}
		/* #text1 {
		font-size: 3em;
		}
		#text2 {
			font-size: 15px;
		} */
	}
</style>
<script type="text/javascript">
/* $(document).ready(function(){
	$("#join").click(function(){
		$.ajax({
		    method: 'post',
		    url: "/myfolio/join",
		    headers: {
		    	"Content-Type": "application/html",
				"X-HTTP-Mathod-Override": "POST"
		    },
		    dataType: "html", // 응답 데이터 타입
		    success: function(result){
				$("#overlay").html(result);
		    },
		    error: function(){
		    } 
		});
	});
}) */
</script>
</head>
<body>

<div id="typo">
<div id="sentence">
	<p id="text1">YOU CAN FIND <br /> A BLUE CHIP</p>
	<p id="text2">“When asked, ‘How do you write?’ I invariably answer, ‘One word at a time.’”
		<br /> -Stephen King</p>
</div>
<span style="width: 80px; float: left;"></span>
</div>

<div class="ghost">
	<a href="join" id="join" class="ghost-btn">JOIN US</a>
	<a href="#" class="ghost-btn">LOGIN</a>
</div>

<div id="overlay"></div>
</body>
</html>