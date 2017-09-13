<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#sendText").click(function(){
			var userAgent = navigator.userAgent.toLowerCase();
			var mobileDevice;
			var mobileOs = new Array("iphone", "android", "window");
			var phoneNo = $("#phoneNo").val();
			var text = $("#text").val();
			// href 값
			var sms;
			
			// 폰번호 체크
			var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
			if (!regExp.test(phoneNo)) {
				alert("잘못된 번호입니다.");
				phoneNo.val("");
			}
			// OS 확인
			for(var txt in mobileOs){
			    if(userAgent.match(mobileOs[txt]) != null){
			    	mobileDevice = mobileOs[txt];
			        break;
			    }
			}
			// os에 따라 href값 생성
			if(mobileDevice=="android") {
				sms = "sms:"+phoneNo+"?body="+text;
			} else {
				sms = "sms:"+phoneNo+"?body="+text;
			}
			$("#sendText").attr("href", sms);
			//버튼 방식
			//$(location).attr("href", sms);
		});
	})
</script>
</head>
<body>
	<input type="text" id="phoneNo">
	<input type="text" id="text">
	<a href="" id="sendText">문자 보내기</a>
</body>
</html>