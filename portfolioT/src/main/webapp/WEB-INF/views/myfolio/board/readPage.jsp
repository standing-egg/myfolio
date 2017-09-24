<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<style type="text/css">
.form-control {
	background-color: /* #b3b3b3 */white;
}
.content-info {
	margin-right: 2em;
}
#content {
	padding: 1em;
}
</style>
<script type="text/javascript">
/* $(document).ready("#content", function(){
	$(this).css('height', 'auto' );
	$(this).height( this.scrollHeight );	
}) */
</script>
</head>
<body>
<div id="container">
	<div class="box box-primary">
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
			<span class="content-info">
				추천 <strong>${boardVO.up }</strong>
			</span>
			<span class="content-info">
				주소 <strong>/board/readPage&bno=${boardVO.bno}</strong>
			</span>
		</p>
		<!-- /.box-header -->

		<form role="form" method="post">

			<input type='hidden' name='bno' value="${boardVO.bno}">
			<input type='hidden' name="page" value="${cri.page }" />
			<input type="hidden" name="perPageNum" value="${cri.perPageNum }" />
			<input type="hidden" name="searchType" value="${cri.searchType}">
			<input type="hidden" name="keyword" value="${cri.keyword }">

		</form>

		<label for="exampleInputPassword1">Content</label>
		<div class="box-body">
			<div id="content" class="form-group">
				<p style="white-space: pre-line;">
					${boardVO.content}
				</p>
			</div>
		</div>
		<!-- /.box-body -->

		<div class="box-footer">
			<button type="submit" class="btn btn-warning">Modify</button>
			<button type="submit" class="btn btn-danger">REMOVE</button>
			<button type="submit" class="btn btn-primary">LIST PAGE</button>
		</div>

	</div>
	<!-- /.box -->
</div>
</body>
</html>