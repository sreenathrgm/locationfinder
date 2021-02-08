package com.restapi.locationfinder.dao;

import com.restapi.locationfinder.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User ,String> {

    User getUserById(String userId);

}
