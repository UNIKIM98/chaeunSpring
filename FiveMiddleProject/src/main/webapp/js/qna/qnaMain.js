/**
 * 
 */


/*
  --- Copy from here
*/

if ($('.custom_page_123').length > 0) {
	$('<div class="qna"></div>').appendTo("#col2");
	$('.box.text:not(:first-of-type)').each(function() {
		$(this).appendTo('.qna');
		$(this).children('.box_content').slideUp();
	});

	$('.qna .box.text').click(function() {
		if ($(this).hasClass('qna_show')) {
			$('.qna_show').children('.box_content').slideUp();
			$('.qna_show').removeClass('qna_show');
		} else {
			$('.qna_show').children('.box_content').slideUp();
			$('.qna_show').removeClass('qna_show');
			$(this).addClass('qna_show');
			$(this).children('.box_content').slideDown();
		}
	});
}