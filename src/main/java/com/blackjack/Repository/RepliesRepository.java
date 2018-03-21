package com.blackjack.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.blackjack.Model.Reply;

public interface RepliesRepository extends MongoRepository<Reply, String> {

	@Query("{ 'email' : ?0 }")
	public Reply findByEmail(String email);
}
