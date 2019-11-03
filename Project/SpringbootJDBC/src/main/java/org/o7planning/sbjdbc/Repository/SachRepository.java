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
	@Query("Select * from books t Where t.bookname := book")
	List<books> findBybooknameLike(@Param("book") String book);
	Optional<books> findById(Integer q);
	void deleteById(Integer q);
	public books findById(int Id);
	@Modifying
	@Query("UPDATE books t SET t.numberborrow =:number WHERE  t.id= :Id")
	void updateBook(@Param("Id")Integer id,@Param("number")int number);
	
}
