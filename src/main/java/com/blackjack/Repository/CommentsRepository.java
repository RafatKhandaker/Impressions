package com.blackjack.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.blackjack.Model.Comments;

@Repository
public interface CommentsRepository extends MongoRepository<Comments, String>{

}
