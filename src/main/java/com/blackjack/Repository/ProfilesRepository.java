package com.blackjack.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.blackjack.Model.UserProfile;


public interface ProfilesRepository extends MongoRepository<UserProfile, String>{

	@Query("{ '_id' : ?0 }")
	public UserProfile findById(String email);
}
