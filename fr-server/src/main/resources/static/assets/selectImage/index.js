// item selection
$('li').click(function () {
  $('li.selected').not($(this)).removeClass('selected');
  $(this).toggleClass('selected');
});
