<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var trigger = $("#trigger");
	var menu = $("nav ul");
	$(trigger).on("click", function(e){
		e.preventDefault();
		$(menu).slideToggle();
	});
	$(window).resize(function(){
		var w = $(window).width();
		if(w>930 && menu.is(":hidden")) {
			menu.removeAttr("style");
		}
	});
});
</script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
body {
	background: url('../resources/image/minimal2.jpg') no-repeat center center fixed;
	background-position: bottom;
	background-size: cover;
	/* height: inherit; */
}
/* #typo {
	z-index: -1;
	width: 100%;
	height: 100%;
	background-color: rgba(0,0,0,0.3);
	position: fixed;
	display: table;
} */
.clearfix:before,
.clearfix:after {
	content: "";
	display: table;
}
.clearfix:after {
	clear:both;
}
.clearfix {
	zoom: 1;
}
nav {
	top: 0px;
	z-index: 999;
	height: 40px;
	width: 100%;
	background-color: /* #34495e; */ /* rgba(40,55,80,0.9) */ /* #083777 */ black;
	font-size: 1em;
	font-family: sans-serif;
	position: fixed;
}
nav ul {
	padding: 0;
	margin: 0 auto;
	/* width: 100%; */
	width: 1120px;
	height: 40px;
}
nav li {
	display: inline-block;
	text-align: center;
}
nav a {
	color: #fff;
	display: inline-block;
	width: 150px;
	text-decoration: none;
	text-align: center;
	line-height: 40px;
}
nav a:hover, nav a:active {
	text-decoration: none;
	background-color: #2c3e50;
}
nav a#trigger {
	display: none;
}
@media screen and (max-width: 930px) {	/* 태블릿 ver */
	nav {
		height: auto;
	}
	nav ul {
		width: 100%;
		display: none;
		height: auto;
	}
	nav li {
		z-index: 1;
		width: 50%;
		float: left;
		position: relative;
	}
	nav li a {
		border-bottom: 1px solid #576979;
		border-right: 1px solid #576979;
	}
	nav a {
		text-align: left;
		width: 100%;
		text-indent: 25px;
	}
	nav a#trigger {
		border-bottom: 1px solid #576979;
		display: block;
		background-color: #283744;
		width: 100%;
		position: relative;
	}
	nav a#trigger:after {
		content:"";
		background: url("../resources/image/nav.png") no-repeat;
		width: 30px;
		height: 30px;
		display: inline-block;
		position: absolute;
		right: 15px;
		top: 10px;
	}
}
@media only screen and (max-width: 365px) {	/* 스마트폰 ver */
	nav {
		border-bottom: 0;
	}
	nav ul {
		display: none;
		height: auto;
	}
	nav li {
		z-index: 1;	
		display: block;
		float: none;
		width: 100%;
	}
	nav li a {
		border-bottom: 1px solid #576979;
	}
	nav a#trigger {
		border-bottom: 1px solid #576979;
		display: block;
		background-color: #283744;
		width: 100%;
		position: relative;
	}
	nav a#trigger:after {
		content:"";
		background: url("../resources/image/nav.png") no-repeat;
		width: 30px;
		height: 30px;
		display: inline-block;
		position: absolute;
		right: 15px;
		top: 10px;
	}
}
</style>

</head>
<body>

<header>
<nav class="clearfix">
	<a href="#" id="trigger">MENU</a>
	<ul class="clearfix">
		<li><a href="/myfolio/main">HOME</a></li>
		<li><a href="#">PROFILE</a></li>
		<li><a href="/works/worksPage">WORKS</a></li>
		<li><a href="/works/news">NEWS</a></li>
		<li><a href="#">SNS</a></li>
		<li><a href="/board/chatBoard">BOARD</a></li>
		<!-- <li hidden="true"><a href="#"></a></li> -->
	</ul>
</nav>
</header>
</body>
</html>