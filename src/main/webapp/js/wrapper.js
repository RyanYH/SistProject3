(function() {

  'use strict';

  document.querySelector('.material-design-hamburger__icon').addEventListener(
    'click',
    function() {      
      var child;
      
      document.body.classList.toggle('background--blur');
      this.parentNode.nextElementSibling.classList.toggle('menu--on');

      child = this.childNodes[1].classList;

      if (child.contains('material-design-hamburger__icon--to-arrow')) {
        child.remove('material-design-hamburger__icon--to-arrow');
        child.add('material-design-hamburger__icon--from-arrow');
      } else {
        child.remove('material-design-hamburger__icon--from-arrow');
        child.add('material-design-hamburger__icon--to-arrow');
      }

    });

})();

$(function(){
	$('#optionsRadios11').click(function(){
	    $('.centrado2').slideToggle("slow");
	    $(".centrado3").slideUp( 0, '');
	    $(".centrado4").slideUp( 0, '');
	    $(".centrado5").slideUp( 0, '');
	    $(".centrado6").slideUp( 0, '');
	    $(this).toggleClass("active");
	});
});
$(function(){
	$('#optionsRadios12').click(function(){
	    $('.centrado3').slideToggle("slow");
	    $(".centrado2").slideUp( 0, '');
	    $(".centrado4").slideUp( 0, '');
	    $(".centrado5").slideUp( 0, '');
	    $(".centrado6").slideUp( 0, '');
	    $(this).toggleClass("active");
	});
});
$(function(){
	$('#optionsRadios13').click(function(){
	    $('.centrado4').slideToggle("slow");
	    $(".centrado2").slideUp( 0, '');
	    $(".centrado3").slideUp( 0, '');
	    $(".centrado5").slideUp( 0, '');
	    $(".centrado6").slideUp( 0, '');
	    $(this).toggleClass("active");
	});
});
$(function(){
	$('#optionsRadios14').click(function(){
	    $('.centrado5').slideToggle("slow");
	    $(".centrado2").slideUp( 0, '');
	    $(".centrado3").slideUp( 0, '');
	    $(".centrado4").slideUp( 0, '');
	    $(".centrado6").slideUp( 0, '');
	    $(this).toggleClass("active");
	});
});
$(function(){
	$('#optionsRadios15').click(function(){
	    $('.centrado6').slideToggle("slow");
	    $(".centrado2").slideUp( 0, '');
	    $(".centrado3").slideUp( 0, '');
	    $(".centrado4").slideUp( 0, '');
	    $(".centrado5").slideUp( 0, '');
	    $(this).toggleClass("active");
	});
});