$('#mybtn').click(function(e) {
	 e.preventDefault();
     if($(this).hasClass('disable')){
     	return false;
     }
     $(this).addClass('disable');
     var self=$(this);
   var cart = $('.site-navigation');
   var shop = $(document).find('#cart');
   var span=shop.find('.badge');
   var imgtofly = $(this).parents('tr.cart_items').find('a.product-image img').eq(0);
    if (imgtofly) {
      
        var imgclone = imgtofly.clone()
           .offset({ top:imgtofly.offset().top, left:imgtofly.offset().left })
           .css({'opacity':'0.7', 'position':'absolute', 'height':'50px', 'width':'50px', 'z-index':'99999999','object-fit':'cover','border-radius':'100%','border':'2px solid red'})
           .appendTo($('body'))
           .animate({
               'top':cart.offset().top,
                'left':cart.offset().left+400,
                'width':55,
                'height':55
            },1000,'easeInElastic')
            


        imgclone.animate({'width':0, 'height':0}, function(){ $(this).detach(); 
    	});
        
       
       
    }
    return false;
});