$(document).ready (function(){
    var carouselHeight = $(window).height() - $('.navbar').outerHeight();
    $('.carousel, .carousel .item, .carousel .carousel-inner, .carousel-item .img-fluid').css('height', carouselHeight);
});



