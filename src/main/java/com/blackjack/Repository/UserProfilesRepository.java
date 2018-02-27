package com.blackjack.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.blackjack.Model.UserProfile;

public interface UserProfilesRepository extends MongoRepository<UserProfile, String>{

}
