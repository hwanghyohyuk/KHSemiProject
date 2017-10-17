/**
 * 
 */
var width = 400;
	/* 
	0일때 더이상 넘어가지않도록하는 코드...
	var slide = document.getElementsByTagName("group-slides");
	
	if(slide.style.marginLeft != "0px"){ 나중에쓰기  */

	$(document).ready(function() {
		$("#group-slider-left").click(function() {
			$('.group-slides').animate({
				'margin-left' : '+=' + width
			}, 800);
		});
	});

	$(document).ready(function() {
		$("#group-slider-right").click(function() {
			$('.group-slides').animate({
				'margin-left' : '-=' + width
			}, 800);
		});
	});

	$(document).ready(function() {
		$("#slider-right").click(function() {
			$('.slides').animate({
				'margin-left' : '-=' + width
			}, 1000);
		});
	});

	$(document).ready(function() {
		$("#slider-left").click(function() {
			$('.slides').animate({
				'margin-left' : '+=' + width
			}, 1000);
		});
	});