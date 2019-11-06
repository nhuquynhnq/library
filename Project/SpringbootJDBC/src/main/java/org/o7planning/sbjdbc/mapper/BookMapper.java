package org.o7planning.sbjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.o7planning.sbjdbc.model.books;
import org.o7planning.sbjdbc.model.users;
import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<books> {
	public static final String BASE_SQL //
    = "Select ba.id, ba.idauthor,  ba.idpublisher,ba.bookname,ba.image,ba.number,ba.type From books ba ";
	

@Override
public books mapRow(ResultSet rs, int rowNum) throws SQLException {
Integer id=rs.getInt("id");
int id_au=rs.getInt("idauthor");
int id_pub=rs.getInt("idpublisher");
String bookname = rs.getString("bookname");

String image = rs.getString("image");
String type = rs.getString("type");
int number = rs.getInt("number");


return new books(id,id_au,id_pub,bookname,type,number,image);
}



}
