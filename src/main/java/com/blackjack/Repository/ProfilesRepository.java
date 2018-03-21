package com.blackjack.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.blackjack.Contracts.IProfile;


public interface ProfilesRepository extends MongoRepository<IProfile, String>{

	@Query("{ 'email' : ?0 }")
	public IProfile findByEmail(String email);
}
