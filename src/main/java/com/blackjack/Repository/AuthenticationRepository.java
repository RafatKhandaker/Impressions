package com.blackjack.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.blackjack.Model.Authentication;

@Repository
public interface AuthenticationRepository extends MongoRepository<Authentication, String>{

	@Query("{ 'email' : ?0 }")
	public Authentication findByEmail(String email);
}
