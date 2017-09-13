<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
article {
	padding: 4%;
}
</style>
<script type="text/javascript">
var checkForm_id = 0;
var checkForm_pw = 0;
var checkForm_rePw = 0;
var checkForm_email = 0;
function checkId() {
	var id = $("#id").val();
	var reg_uid = /^[a-z0-9_]{5,12}$/; //5~12자 영문소문자, 숫자, 특수문자 _ 사용가능
	console.log(id);
	$.ajax({
	    method: 'post',
	    url: "/myfolio/checkId",
	    headers: {
	    	"Content-Type": "application/text",
			"X-HTTP-Mathod-Override": "POST"
	    },
	    data: id,
	    success: function(data){
	    	console.log(data);
	    	if (data == '0' && id.match(reg_uid)) {
				$("#id").css("background-color", "#B0F6AC");
				$("#idChecking").html("");
				checkForm_id = 1;
				checkForms();
			} else {
				$("#id").css("background-color", "#FFCECE");
				$("#idChecking").html("<p>사용이 불가능합니다</p>");
				checkForm_id = 0;
				checkForms();
			}
		},
		error: function(){
	    }
	});
};
function checkPw() {
	var pw = $("#pw").val();
	var reg_upw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-]|.*[0-9]).{6,24}$/;
	if (pw.match(reg_upw)) {
		$("#pw").css("background-color", "#B0F6AC");
        $("#pwChecking").html("");
        checkForm_pw = 1;
        checkForms();
	} else {
		$("#repw").css("background-color", "#FFCECE");
		$("#pwChecking").html("<p>6~16자 영문대소문자, 숫자, 특수문자 혼합하여 사용</p>");
		checkForm_pw = 0;
		checkForms();
	}
}
function checkRePw() {
	var pw = $("#pw").val();
	var repw = $("#repw").val();
	if (pw == repw) {
        $("#repw").css("background-color", "#B0F6AC");
        $("#rePwChecking").html("");
        checkForm_rePw = 1;
        checkForms();
    } else {
        $("#repw").css("background-color", "#FFCECE");
        $("#rePwChecking").html("<p>패스워드가 다릅니다</p>");
        checkForm_rePw = 0;
        checkForms();
    }
};
function checkEmail() {
	var email = $("#email").val();
	var reg_email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	if (email.match(reg_email)) {
		$("#email").css("background-color", "#B0F6AC");
        $("#emailChecking").html("");
        checkForm_email = 1;
        checkForms();
	} else {
		$("#email").css("background-color", "#FFCECE");
        $("#emailChecking").html("<p>이메일을 입력해주세요</p>");
        checkForm_email = 0;
        checkForms();
	}
}
function checkForms() {
	if (checkForm_id + checkForm_pw + checkForm_rePw + checkForm_email == 4) {
		console.log(checkForm_id + checkForm_pw + checkForm_rePw + checkForm_email);
		$("#join").prop("disabled", false);
	} else {
		console.log(checkForm_id + checkForm_pw + checkForm_rePw + checkForm_email);
		$("#join").prop("disabled", true);
	}
}
$(document).ready(function() {
	$("#join").on("click", function(){
		var fm = $("form[role='form']");
		fm.submit();
	});
	$("#cancel").on("click", function(){
		location.href = "/myfolio/main";
	});
})
</script>
</head>
<body>
	<article class="container">

		<div class="col-md-6 col-md-offset-3">

			<div class="page-header">
				<h1>
					회원가입 <small>Sign up</small>
				</h1>
			</div>
			<form action="join" method="post" role="form">
				<div class="form-group">
					<label for="InputId">아이디</label>
					<label id="idChecking"></label>
					<input type="text" class="form-control" name="mid" id="id" 
							required="required" oninput="checkId()" placeholder="아이디  5~12자 영문소문자, 숫자, 특수문자 _ 사용가능">
				</div>
				<div class="form-group">
					<label for="InputPassword1">비밀번호</label>
					<label id="pwChecking"></label>
					<input type="password" class="form-control" name="mpw" id="pw" 
						required="required" oninput="checkPw()" placeholder="비밀번호">
				</div>
				<div class="form-group">
					<label for="InputPassword2">비밀번호 확인</label>
					<label id="rePwChecking"></label>
					<input type="password" class="form-control" id="repw" 
						required="required" oninput="checkRePw()" placeholder="비밀번호 확인">
					<p class="help-block">비밀번호 확인을 위해 다시 한번 입력 해 주세요</p>
				</div>
				<div class="form-group">
					<label for="InputEmail">이메일 주소</label>
					<label id="emailChecking"></label>
					<input type="email" class="form-control" name="email" id="email" 
						required="required" oninput="checkEmail()" placeholder="이메일 주소를 입력해 주세요">
				</div>
				<div class="form-group">
					<label for="InputEmail">소개</label> <input type="text"
						class="form-control" name="about" id="about" placeholder="본인에 대한 소개를 입력해주세요">
				</div>
			</form>
				<div class="form-group text-center">
					<button type="submit" id="join" disabled="disabled" class="btn btn-info">
						회원가입
					</button>
					<button type="button" id="cancel" class="btn btn-warning">
						가입취소
					</button>
				</div>
		</div>

	</article>
</body>
</html>