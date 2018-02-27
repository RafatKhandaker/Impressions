package com.blackjack.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.blackjack.Model.Question;


@Repository
public interface QuestionsRepository extends MongoRepository<Question<Object>, String>{
	
}
