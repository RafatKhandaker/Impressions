package com.blackjack.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.blackjack.Model.ErrorLog;

@Component
@Repository
public interface ErrorLogRepository extends MongoRepository<ErrorLog, String>{

}
