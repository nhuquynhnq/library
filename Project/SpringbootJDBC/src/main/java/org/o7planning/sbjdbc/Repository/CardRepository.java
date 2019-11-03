package org.o7planning.sbjdbc.Repository;


import java.util.List;
import java.util.Optional;

import org.o7planning.sbjdbc.model.books;
import org.o7planning.sbjdbc.model.cardbook;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CardRepository extends CrudRepository<cardbook,Integer>{
	List<cardbook> findBybooknameLike(String book);
	void deleteById(Integer q);
	@Query("SELECT * FROM cardbook t WHERE t.iduser=:Id and t.status=:Status")
	public cardbook findByIdUser(@Param("Id")Integer Id,@Param("Status") int Status);
}
