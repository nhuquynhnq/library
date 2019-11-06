//Định nghĩa một mảng các phần tử sẽ bỏ vào giỏ hàng
var shoppingCartItems = [];


$(document)
.ready(
		function() {
			// Kiểm tra nếu đã có sessionStorage["shopping­cart­items"] hay chưa?
			if (sessionStorage["shopping­cart­items"] != null) {
				shoppingCartItems = JSON
				.parse(sessionStorage["shopping­cart­items"]
				.toString());
			}

			// Hiển thị thông tin từ giỏ hàng
			//displayShoppingCartItems();
			if (sessionStorage["shopping­cart­items"] != null) {
				//shoppingCartItems = JSON.parse(sessionStorage["shopping­cart-items"].toString()); // Chuyển thông tin từ JSON trong sessionStoragesang mảng shoppingCartItems.
				//shoppingCartItems = json_decode(sessionStorage["shopping­cart-items"].toString(),TRUE);
				var shop = $(document).find('.items');
				var span = shop.find('#specify');
				span.html("");
				$
				.each(
						shoppingCartItems,
						function(index, item) {

							var htmlString = "";
							htmlString += "<div>";
							htmlString += "<img width='50px' height='50px' src="
								+ item.image + "/>";
							htmlString += "</div>";
							htmlString += "<div>" + item.name
							+ "</div>";

							htmlString += "<input type='text' readonly value="
								+ item.quantity + ">";
							htmlString += '<div>';
							span.append(htmlString);
							
							var remo = $('<button  type="button" data-columns='
									+ item.id + '>Xóa</button>');
							span.append(remo);
							remo.click(removeitem);
						});

			}
		});
//Sự kiện click các button có class=".add­to­cart"
$("#mybtn").click(function() {

	var button = $(this); // Lấy đối tượng button mà người dùng click
	var id = button.attr("data-columns");
	console.log(id);
	var name = button.attr("data­name"); // name của sản phẩm là thuộc tính dataname của button
	var image = button.attr("data-infor");
	var quantity = 1; // Số lượng
	var item = {
			id : id,
			name : name,
			image : image,
			quantity : quantity
	};
var exists = 0;
if (shoppingCartItems!=null) {
	if (shoppingCartItems.length > 0) {
		$.each(shoppingCartItems, function(index, value) {
			// Nếu mặt hàng đã tồn tại trong giỏ hàng thì chỉ cần tăng số lượng

			if (value.id == item.id) {
				value.quantity++;
				exists = 1;
			}
		});
	}
}else{
	shoppingCartItems = [];
}
	// bổ sung vào mảng
if (exists == 0) {
	
	shoppingCartItems.push(item);
}
	

	//Cập nhật số lượng sách.
	var number = $(document).find("#numberhas").html();
	if (number > 0) {
		$(document).find("#numberhas").html(number - 1);
	} else {
		alert("Không thể mượn thêm");
	}
	
   
	//Nếu mặt hàng chưa tồn tại trong giỏ hàng thì 
	// Lưu thông tin vào sessionStorage
	sessionStorage["shopping­cart­items"] = JSON.stringify(shoppingCartItems);
	console.log(shoppingCartItems);
	// Gọi hàm hiển thị giỏ hàng
	displayShoppingCartItems();

});

//Xóa hết giỏ hàng shoppingCartItems

function removeitem() {
	var idtem = $(this).attr('data-columns');
	$.each(shoppingCartItems, function(index, item) {
		if (item.id == idtem) {
			$.ajax({
				type : 'POST',
				url : '/remove/' + item.id,
				contentType : "application/json; charset=utf-8",
				success : function() {
					
					shoppingCartItems.splice(item, 1 );
					//sessionStorage["shopping­cart­items"] = null;
					sessionStorage["shopping­cart­items"] = JSON.stringify(shoppingCartItems);
					if (sessionStorage["shopping­cart­items"] != null) {
						//shoppingCartItems = JSON.parse(sessionStorage["shopping­cart-items"].toString()); // Chuyển thông tin từ JSON trong sessionStoragesang mảng shoppingCartItems.
						//shoppingCartItems = json_decode(sessionStorage["shopping­cart-items"].toString(),TRUE);
						var shop = $(document).find('.items');
						var span = shop.find('#specify');
						span.html("");
						$.each(shoppingCartItems, function(index, item) {
							var htmlString = "";
							htmlString += "<div>";
							htmlString += "<img width='50px' height='50px' src=" + item.image
							+ "/>";
							htmlString += "</div>";
							htmlString += "<div>" + item.name + "</div>";
							htmlString += "<input type='text' readonly value=" + item.quantity
							+ ">";
							htmlString += '<div>';
							span.append(htmlString);
							var plus = $('<button  type="button" data-columns=' + item.id
									+ '>+</button>');
							var minus = $('<button type="button" data-columns=' + item.id
									+ '>-</button>');
							span.append(plus);
							span.append(minus);
							plus.click(plusitem);
							minus.click(minusitem);
							var remo = $('<button  type="button" data-columns=' + item.id
									+ '>Xóa</button>');
							span.append(remo);
							remo.click(removeitem);

						});

					}
				
					
				}
			});

		}
	});

}

function plusitem() {
	var idtem = $(this).attr('data-columns');
	console.log(idtem);
	var number = $(document).find("#numberhas").html();
	console.log(number);
	$.each(shoppingCartItems, function(index, item) {
		if (item.id == idtem) {
			if (item.quantity < number) {
				$.ajax({
					type : 'POST',
					url : '/add/' + item.id,
					contentType : "application/json; charset=utf-8",
					success : function() {
						item.quantity++;
						//alert("Thêm thành công!!");
						sessionStorage["shopping­cart­items"] = JSON.stringify(shoppingCartItems);
						if (sessionStorage["shopping­cart­items"] != null) {
							//shoppingCartItems = JSON.parse(sessionStorage["shopping­cart-items"].toString()); // Chuyển thông tin từ JSON trong sessionStoragesang mảng shoppingCartItems.
							//shoppingCartItems = json_decode(sessionStorage["shopping­cart-items"].toString(),TRUE);
							var shop = $(document).find('.items');
							var span = shop.find('#specify');
							span.html("");
							$.each(shoppingCartItems, function(index, item) {
								var htmlString = "";
								htmlString += "<div>";
								htmlString += "<img width='50px' height='50px' src=" + item.image
								+ "/>";
								htmlString += "</div>";
								htmlString += "<div>" + item.name + "</div>";
								htmlString += "<input type='text' readonly value=" + item.quantity
								+ ">";
								htmlString += '<div>';
								span.append(htmlString);
								var plus = $('<button  type="button" data-columns=' + item.id
										+ '>+</button>');
								var minus = $('<button type="button" data-columns=' + item.id
										+ '>-</button>');
								span.append(plus);
								span.append(minus);
								plus.click(plusitem);
								minus.click(minusitem);
								var remo = $('<button  type="button" data-columns=' + item.id
										+ '>Xóa</button>');
								span.append(remo);
								remo.click(removeitem);

							});

						}
					

					}
				});
			}
			//var removeItem = item.id;

			
		}
	});
	
}
function minusitem() {
	var idtem = $(this).attr('data-columns');
	console.log(idtem);
	$.each(shoppingCartItems, function(index, item) {
		if (item.id == idtem) {
			if (item.quantity > 0) {
				$.ajax({
					type : 'POST',
					url : '/minus/' + item.id,
					contentType : "application/json; charset=utf-8",
					success : function() {
						//console.log("Giảm thành công!!");
						item.quantity--;
						sessionStorage["shopping­cart­items"] = JSON.stringify(shoppingCartItems);
						if (sessionStorage["shopping­cart­items"] != null) {
							//shoppingCartItems = JSON.parse(sessionStorage["shopping­cart-items"].toString()); // Chuyển thông tin từ JSON trong sessionStoragesang mảng shoppingCartItems.
							//shoppingCartItems = json_decode(sessionStorage["shopping­cart-items"].toString(),TRUE);
							var shop = $(document).find('.items');
							var span = shop.find('#specify');
							span.html("");
							$.each(shoppingCartItems, function(index, item) {

								var htmlString = "";
								htmlString += "<div>";
								htmlString += "<img width='50px' height='50px' src=" + item.image
								+ "/>";
								htmlString += "</div>";
								htmlString += "<div>" + item.name + "</div>";

								htmlString += "<input type='text' readonly value=" + item.quantity
								+ ">";
								htmlString += '<div>';
								span.append(htmlString);
								var plus = $('<button  type="button" data-columns=' + item.id
										+ '>+</button>');
								var minus = $('<button type="button" data-columns=' + item.id
										+ '>-</button>');
								span.append(plus);
								span.append(minus);
								plus.click(plusitem);
								minus.click(minusitem);
								var remo = $('<button  type="button" data-columns=' + item.id
										+ '>Xóa</button>');
								span.append(remo);
								remo.click(removeitem);

							});

						}

					}
				});
			}
			
		}
	});

	
}

//Hiển thị giỏ hàng ra thẻ ul

function displayShoppingCartItems() {

	if (sessionStorage["shopping­cart­items"] != null) {
		//shoppingCartItems = JSON.parse(sessionStorage["shopping­cart-items"].toString()); // Chuyển thông tin từ JSON trong sessionStoragesang mảng shoppingCartItems.
		//shoppingCartItems = json_decode(sessionStorage["shopping­cart-items"].toString(),TRUE);
		var shop = $(document).find('.items');
		var span = shop.find('#specify');
		span.empty();
		$.each(shoppingCartItems, function(index, item) {

			$.ajax({
				type : 'POST',
				url : '/add/' + item.id,
				contentType : "application/json; charset=utf-8",

				success : function() {
					//do whatever you want

					var htmlString = "";
					htmlString += "<div>";
					htmlString += "<img width='50px' height='50px' src="
						+ item.image + "/>";
					htmlString += "</div>";
					htmlString += "<div>" + item.name + "</div>";

					htmlString += "<input type='text' readonly value="
						+ item.quantity + ">";
					htmlString += '<div>';
					span.append(htmlString);
					var plus = $('<button  type="button" data-columns='
							+ item.id + '>+</button>');
					var minus = $('<button type="button" data-columns='
							+ item.id + '>-</button>');
					span.append(plus);
					span.append(minus);
					plus.click(plusitem);
					minus.click(minusitem);
					var remo = $('<button  type="button" data-columns='
							+ item.id + '>Xóa</button>');
					span.append(remo);
					remo.click(removeitem);
//
				}
			});

		});

	}
}
	


