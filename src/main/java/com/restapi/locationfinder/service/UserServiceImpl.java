package com.restapi.locationfinder.service;

import com.restapi.locationfinder.Utility;
import com.restapi.locationfinder.dao.UserRepository;
import com.restapi.locationfinder.model.User;
import com.restapi.locationfinder.model.UserPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl  implements IntfUserService{

    @Autowired
    private UserRepository userRepo;


    @Override
    public User getUserbyId(String userId) {
        User user = userRepo.getUserById(userId);
        return user;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userRepo.save(user);

    }

    @Transactional
    @Override
    public void updateuser(User user) {
        userRepo.save(user);

    }

    @Transactional
    @Override
    public void deleteUser(String userId) {
        userRepo.deleteById(userId);

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }

    @Override
    public List<UserPair> getDistances() {
        User users[] = userRepo.findAll().toArray(new User[0]);
        List<UserPair> distance = Utility.distanceBetween2PointsLatLong(Utility.Unit.KILOMETERS, users);
        return distance;
    }
}
