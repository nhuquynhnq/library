package org.o7planning.sbjdbc.Repository;

import java.util.List;
import java.util.Optional;

import org.o7planning.sbjdbc.model.books;
import org.o7planning.sbjdbc.model.users;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository 
public interface SachRepository extends CrudRepository<books,Integer>{
	@Query("SELECT * FROM books  WHERE books.bookname like :bookname")
	books findBybooknameLike(@Param("bookname") String book);
	@Query("SELECT * FROM books  WHERE books.type = :type")
	List<books> findBybooktypeLike(@Param("type") String type);
	@Query("SELECT * FROM books  WHERE books.bookname like :bookname and books.type=:type")
	books findbookByNameType(@Param("bookname") String book,@Param("type") String type);
	Optional<books> findById(Integer q);
	void deleteById(Integer q);
	
	public books findById(int Id);
	@Modifying
	@Query("UPDATE books t SET t.numberborrow =:number WHERE  t.id= :Id")
	void updateBook(@Param("Id")Integer id,@Param("number")int number);
	
}
