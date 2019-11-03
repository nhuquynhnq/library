package org.o7planning.sbjdbc.Repository;


import java.util.List;
import java.util.Optional;


import org.o7planning.sbjdbc.model.users;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository 

public interface UserRepository extends CrudRepository<users,Integer> {
	public List<users> findByidLike(Integer email);
	Optional<users> findById(Integer q);
	@Query("SELECT * FROM users t WHERE t.email = :email")
	Optional<users> findByEmailContaining(@Param("email") String email);
	@Query("SELECT * FROM users t WHERE t.email = :email")
	users findByEmail(@Param("email") String email);
	@Query("SELECT * FROM users t WHERE t.email = :email and t.password=:password")
	users findByEmailandPassword(@Param("email") String email,@Param("password") String password);
	void deleteById(Integer q);
}
