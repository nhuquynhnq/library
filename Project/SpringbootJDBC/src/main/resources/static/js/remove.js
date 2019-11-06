$('#search').click(function() {
	var parents = $(document).find('#find');
	var bookname = parents.find("#name").val();
	var type = parents.find("#type").val();
	console.log(bookname);
	console.log(type);
	if(type=="" && bookname==""){
		alert("Vui lòng nhập tên sách, thể loại!");
	}else{
		
		
	
	var room = {
		    "bookname": bookname,
		    "type":type
	         
		};
	$.ajax({
		type : 'POST',
		url : '/find' ,
		
		data:JSON.stringify(room),
		contentType : "application/json; charset=utf-8",
		success : function() {
			  console.log("Chuyển trang thành công!");
			  window.location="http://localhost:8080/findbook";
			  
		}
	});
	
	}
	
	
	
	
	
});
$('#searchPMS').click(function() {
	var parents = $(document).find('#TraSach');
	var idpms = parents.find("#PMS").val();
	console.log(idpms);
	var room = {
		    "id": idpms
		    
		};

	$.ajax({
		type : 'POST',
		url : '/findPMS' ,
		
		data:JSON.stringify(room),
		contentType : "application/json; charset=utf-8",
		success : function() {
			  console.log("Chuyển trang thành công!");
			  window.location="http://localhost:8080/PMS.html";
			  
		}
	});
	
	
	
	/*console.log(bookname);
	console.log(type);
	if(type=="" && bookname==""){
		alert("Vui lòng nhập tên sách, thể loại!");
	}else{
		
		
	
	var room = {
		    "bookname": bookname,
		    "type":type
	         
		};
	$.ajax({
		type : 'POST',
		url : '/find' ,
		
		data:JSON.stringify(room),
		contentType : "application/json; charset=utf-8",
		success : function() {
			  console.log("Chuyển trang thành công!");
			  window.location="http://localhost:8080/findbook";
			  
		}
	});
	
	}*/
	

});