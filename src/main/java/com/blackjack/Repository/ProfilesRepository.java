package com.blackjack.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blackjack.Contracts.IProfile;


public interface ProfilesRepository extends MongoRepository<IProfile, String>{

}
