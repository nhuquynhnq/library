// Định nghĩa một mảng các phần tử sẽ bỏ vào giỏ hàng
var shoppingCartItems = [];

var del = $(document).find('.sucess');
    $(document).ready(function () {
// Kiểm tra nếu đã có sessionStorage["shopping­cart­items"] hay chưa?
        if (sessionStorage["shopping­cart­items"] != null) {
shoppingCartItems = JSON.parse(sessionStorage["shopping­cart­items"].toString());
        }
// Hiển thị thông tin từ giỏ hàng
        displayShoppingCartItems();
    });
// Sự kiện click các button có class=".add­to­cart"
    $("#mybtn").click(function () {
var button = $(this); // Lấy đối tượng button mà người dùng click
var id = button.attr("data-columns"); 
console.log(id);
var name = button.attr("data­name"); // name của sản phẩm là thuộc tính dataname của button
var image = button.attr("data-infor");
var quantity = 1; // Số lượng
        var item = {
            id: id,
            name: name,
            image:image,
            quantity: quantity
        };
      var exists=false;
        if (shoppingCartItems.length > 0) {
            $.each(shoppingCartItems, function (index, value) {
// Nếu mặt hàng đã tồn tại trong giỏ hàng thì chỉ cần tăng số lượng

                if (value.id == item.id) {
                    value.quantity++;
                    exists = true;
                    return false;
                }
            });
        }
// Nếu mặt hàng chưa tồn tại trong giỏ hàng thì bổ sung vào mảng
        if(!exists) {
            shoppingCartItems.push(item);
        }
// Lưu thông tin vào sessionStorage
sessionStorage["shopping­cart­items"] = JSON.stringify(shoppingCartItems); 
// Gọi hàm hiển thị giỏ hàng
        displayShoppingCartItems();
    });
    //Số lượng tăng giảm
    $('.btn-number').click(function(e){        
    	e.preventDefault();     
    	var shopp = $(document).find('.btn-number');
 	     var input=shopp.find('#number');
    	var fieldName = $(this).attr('data-field');        
    	var type      = $(this).attr('data-type');        
    	console.log(type);
    	var currentVal = parseInt(input.val());        
    	if (!isNaN(currentVal)) {            
    	if(type == 'minus') {                
    	var minValue = parseInt(input.attr('min'));                 
    	if(!minValue) minValue = 1;                
    	if(currentVal > minValue) {                    
    	input.val(currentVal - 1).change();                
    	}                 
    	if(parseInt(input.val()) == minValue) {                    
    	$(this).attr('disabled', true);                
    	}                
   } else if(type == 'plus') {                
	   var maxValue = parseInt(input.attr('max'));                
	   if(!maxValue) maxValue = 9999999999999;                
	   if(currentVal < maxValue) {                    
	   input.val(currentVal + 1).change();                
	   }                
	   if(parseInt(input.val()) == maxValue) {                    
	   $(this).attr('disabled', true);                
	   }                
	   }        
	   } 
	   else {            
	   input.val(0);        
	   }    
	   });  

// Xóa hết giỏ hàng shoppingCartItems
   
    function removeitem(){
    	var  idtem = $(this).attr('data-columns');
    	  console.log(idtem);
           $.each(shoppingCartItems, function (index, item) {
              if(item.id==idtem){
              	$.ajax({
                	  type: 'POST',
                	  url: '/remove/'+item.id,
                    contentType: "application/json; charset=utf-8",
                	  success: function(){
                		  alert("Xóa thành công!!");
                	  }
              	});
              	var removeItem = item.id;
              	item.quantity-=1;
              	shoppingCartItems.splice( $.inArray(removeItem, shoppingCartItems), 1 );
           }
     });
           displayShoppingCartItems();
    }
  /*  $('#logout').click(function () {
   	 $.ajax({
        	  type: 'GET',
        	  url:  '/logout.html'
            contentType: "application/json; charset=utf-8",
          
        	  success: function(){
        	  //do whatever you want
        		shoppingCartItems.clear();
        		console.log("Chuyển trang thành công!");
         
        	  }
        	});
   	 displayShoppingCartItems();
      	
       });*/
// Hiển thị giỏ hàng ra thẻ ul
    function displayShoppingCartItems() {
    	
       if (sessionStorage["shopping­cart­items"] != null) {
            //shoppingCartItems = JSON.parse(sessionStorage["shopping­cart-items"].toString()); // Chuyển thông tin từ JSON trong sessionStoragesang mảng shoppingCartItems.
        	//shoppingCartItems = json_decode(sessionStorage["shopping­cart-items"].toString(),TRUE);
    	   var shop = $(document).find('.items');
    	   var span=shop.find('#specify');
   		span.html("");
            $.each(shoppingCartItems, function (index, item) {
            	
            	$.ajax({
              	  type: 'POST',
              	  url: '/add/'+item.id,
                  contentType: "application/json; charset=utf-8",
                
              	  success: function(){
              	  //do whatever you want
              
              		var htmlString = "";
                	htmlString += "<div>";
                	htmlString += "<img width='50px' height='50px' src=" + item.image + "/>";
                	 htmlString += "</div>";
                    htmlString += "<div>" + item.name + "</div>";
                   htmlString += "<div style='text­align: right'>" + item.quantity + "</div>";
                   span.append(htmlString);
                 
                   var link =$('<button class="success" type="button" data-columns='+item.id+ '>Clear</button>');
                   span.append(link);
                   link.click(removeitem);
                   var number =  $(document).find("#numberhas").html();
                   console.log(number);
                  $(document).find("#numberhas").html(number-1);
                   
                
                 
               
              	  }
              	});
            	
               ////  var  idtem = bun.attr("data-name");
           	   // console.log(idtem);
                
            });
           
         
       }
       
            
           
        
    }
        
    $('.success').click(function () {
    	removeitem();
    });
