/**
 * 
 */
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

	