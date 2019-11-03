package org.o7planning.sbjdbc.model;

import javax.persistence.Id;

public class cardbook {
	@Id
	@org.springframework.data.annotation.Id
   private Integer id;
   private Integer iduser;
   private Integer idbook;
   private String bookname;
   private String rent_date;
   private int rent_number;
   private String return_date;
   private int status;

public cardbook( Integer iduser, Integer idbook, String bookname,String rent_date, int rent_number,
		 int status) {
	super();
	
	this.iduser = iduser;
	this.idbook = idbook;
	this.bookname = bookname;
	this.rent_date = rent_date;
	this.rent_number = rent_number;
	this.status = status;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getIduser() {
	return iduser;
}
public void setIduser(Integer iduser) {
	this.iduser = iduser;
}
public Integer getIdbook() {
	return idbook;
}
public void setIdbook(Integer idbook) {
	this.idbook = idbook;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getRent_date() {
	return rent_date;
}
public void setRent_date(String rent_date) {
	this.rent_date = rent_date;
}
public int getRent_number() {
	return rent_number;
}
public void setRent_number(int rent_number) {
	this.rent_number = rent_number;
}
public String getReturn_date() {
	return return_date;
}
public void setReturn_date(String return_date) {
	this.return_date = return_date;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String themPMS() {
	//Viet chuong trinh them PMS
	return "Chua xong";
}
public String xoaPMS() {
	//Viet chuong trinh them PMS
	return "Chua xong";
}
public String muonSach() {
	//Viet chuong trinh muon sach
	//Kiem tra dk mượn sách là đã trả sách rồi hoặc chưa mượn sách cho mượn tối đa 5 cuốn ko quá 20 ngày
	
	return "Chua xong";
}
public String traSach() {
	//Viet chuong trinh them PMS
	//Kiểm tra ngày mượn nếu đúng ngày trả thì thông báo thành công không thì ra thông báo "trả trễ"
	return "Chua xong";
}

}
