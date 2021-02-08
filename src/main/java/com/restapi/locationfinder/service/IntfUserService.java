package com.restapi.locationfinder.service;

import com.restapi.locationfinder.model.User;
import com.restapi.locationfinder.model.UserPair;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IntfUserService {

    User getUserbyId(String userId);
    void saveUser(User user);
    void updateuser(User user);
    void deleteUser(String userId);
    List<User> getAllUsers();
    List<UserPair> getDistances();

}
