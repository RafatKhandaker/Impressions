package com.blackjack.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.blackjack.Model.Question;


@Repository
public interface QuestionsRepository extends MongoRepository<Question<Object>, String>{

	@Query("{ 'email' : ?0 }")
	public Question<Object> findByEmail(String email);
}
