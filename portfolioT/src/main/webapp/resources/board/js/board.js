/**
 * 
 */

$(document).on("click", "#upBtn", function(){
	var bno = $("input[name='bno']").val();
	$.ajax({
		method: "post",
		url: "/board/upCnt",
		headers: {
			"Content-Type": "application/json; charset=UTF-8",
			"X-HTTP-Method-Override": "post"
		},
		data: JSON.stringify(bno),
		success: function(result){
			var upCnt = "추천 <strong>"+ result +"</strong>"
			$("#up").empty();
			$("#up").html(upCnt);
		}
	});
});
$(document).on("click", "#writeBtn", function(){
	$("#content").remove();
	$("#writing-box").load("writePage");
	//href = href.replace(/\#content/ig, "");
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
});