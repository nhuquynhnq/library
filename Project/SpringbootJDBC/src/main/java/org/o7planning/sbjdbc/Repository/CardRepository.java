package org.o7planning.sbjdbc.Repository;


import java.util.List;
import java.util.Optional;

import org.o7planning.sbjdbc.model.books;
import org.o7planning.sbjdbc.model.cardbook;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CardRepository extends CrudRepository<cardbook,Integer>{
	List<cardbook> findBybooknameLike(String book);
	void deleteById(Integer q);
	@Query("SELECT * FROM cardbook t WHERE t.iduser=:Id and t.status=:Status")//Trường hợp mượn và trả rồi
	public cardbook findByIdUser(@Param("Id")Integer Id,@Param("Status") int Status);
	@Query("SELECT * FROM cardbook t WHERE t.iduser=:Id")
	public cardbook findId(@Param("Id")Integer Id);//Trường hợp chưa mượn
	@Query("SELECT * FROM cardbook t WHERE t.id=:Id")
	public cardbook findCard(@Param("Id")Integer Id);//Trường hợp chưa mượn
	@Modifying
	@Query("UPDATE cardbook t SET t.status =:number WHERE  t.id= :Id")
	void updateCard(@Param("Id")Integer id,@Param("number")int number);
	
}
