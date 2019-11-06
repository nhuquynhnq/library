package org.o7planning.sbjdbc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="books")
public class books implements Serializable{
	@Id
	@org.springframework.data.annotation.Id
	private Integer id;
	private int idauthor;
	private int idpublisher;
	private String bookname;
	private String publish_year;
	private String description;
	private int page_number;
	private String type;
	private int number;
	private String image;
	private int numberborrow;
	
	public books(Integer id, int idauthor, int id_publisher, String bookname,  String type, int number,
			String image) {
		super();
		this.id = id;
		this.idauthor = idauthor;
		this.idpublisher = id_publisher;
		this.bookname = bookname;
		
		this.type = type;
		this.number = number;
		this.image = image;
	}
	public books() {
		super();
		
	}
	public books(String name,String type) {
      this.bookname = name;
		
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdauthor() {
		return idauthor;
	}
	
	public int getIdpublisher() {
		return idpublisher;
	}
	public void setIdauthor(int id) {
		this.idauthor = id;
	}
	public void setIdpublisher(int id) {
		this.idpublisher = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String book_name) {
		this.bookname = book_name;
	}
	public String getPublish_year() {
		return publish_year;
	}
	public void setPublish_year(String publish_year) {
		this.publish_year = publish_year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPage_number() {
		return page_number;
	}
	public void setPage_number(int page_number) {
		this.page_number = page_number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int status) {
		this.number = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getType() {
		return type;
	}
	public void setType(String image) {
		this.type = image;
	}
	public int getNumberborrow() {
		return numberborrow;
	}
	public void setNumberborrow(int numberborrow) {
		this.numberborrow = numberborrow;
	}
	

}
