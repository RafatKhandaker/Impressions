package com.blackjack.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.blackjack.Model.Reply;

public interface RepliesRepository extends MongoRepository<Reply, String> {

}
