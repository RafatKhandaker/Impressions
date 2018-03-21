package com.blackjack.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.blackjack.Model.Comments;

@Repository
public interface CommentsRepository extends MongoRepository<Comments, String>{

	@Query("{ 'email' : ?0 }")
	public Comments findByEmail(String email);
}
