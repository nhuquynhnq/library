$(".btn-search").click(function () {
	  var tensach = $('document').find('#namebook').val();
	  console.log(tensach);
	  $.ajax({
      	  type: 'POST',
      	  url: '/find/'+tensach,
          contentType: "application/json; charset=utf-8",
        
      	  success: function(){
      		  console.log("Chuyển trang thành công!!");
      		  
      	  }
	  });

});