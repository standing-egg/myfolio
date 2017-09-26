<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
<!-- 부가적인 테마 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
/* #container {
	margin: 3%;
} */
</style>
<!-- <script type="text/javascript">
$(document).ready(function() {
	$("#write").on("click", function(){
		var fm = $("form[role='form']");
		fm.submit();
		$("form[role='form']")[0].reset();
	});
	$("#cancel").on("click", function(){
		location.href = "/board/chatBoard";
	});
})
</script> -->
</head>
<body>
	<div id="container">
		<!-- <div class="col-md-6 col-md-offset-3"> -->		
			<div class="box box-primary">
			
				<div class="box-header">
					<h3 class="box-title">WRITE PAGE</h3>
				</div>
				
				<form role="form" method="post" action="writePage">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Title</label>
							<input type="text" name='title' class="form-control"
							 placeholder="Enter Title">
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail1">Writer</label>
							<input type="text" name="writer" class="form-control"
								placeholder="Enter Writer">
						</div>
						
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<textarea class="form-control" name="content" rows="16"
								style="resize: none;" placeholder="Enter ..."></textarea>
						</div>
					</div>
					<!-- /.box-body -->
					<!-- <div class="box-footer">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div> -->
				</form>
				<div class="form-group text-center">
					<button type="submit" id="write" class="btn btn-info">
						작성완료
					</button>
					<button type="button" id="cancel" class="btn btn-warning">
						취소
					</button>
				</div>
			</div>
		<!-- </div> -->
	</div>
</body>
</html>