package com.blackjack.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.blackjack.Model.Survey;

@Repository
public interface SurveysRepository extends MongoRepository<Survey<Object>, String>{

}
