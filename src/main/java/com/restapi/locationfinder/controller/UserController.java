package com.restapi.locationfinder.controller;

import com.restapi.locationfinder.model.User;
import com.restapi.locationfinder.model.UserPair;
import com.restapi.locationfinder.service.IntfUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jrt/api/v1.0")
@Api(description = "User end points")
public class UserController {

    @Autowired
    private IntfUserService userService;

    /**
     * This return a json stream defining a listing of the users
     *
     */

    @GetMapping("users")
    public ResponseEntity<Object> users(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    /**
     * This return a json object based on id listing of the user.
     *
     */
    @GetMapping("user/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.getUserbyId(userId), HttpStatus.OK);
    }

    /**
     * Should add a new user to the users collection, with validation
     *
     */
    @PostMapping("user")
    public ResponseEntity<Object> addUser(@Validated @RequestBody User input){
        userService.saveUser(input);
        return  new ResponseEntity<Object>("Done", HttpStatus.CREATED);

    }

    /**
     * Delete user specified with user ID and return updated user content.
     */
    @DeleteMapping("user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {

        userService.deleteUser(userId);
        return new ResponseEntity<>("Deleted user "+userId, HttpStatus.OK);
    }

    /**
     * this method determines the distance between each user pair,
     * and returns as a json response.
     *
     */
    @GetMapping("distances")
    public ResponseEntity<Object> distances() {
        List<UserPair> distances = userService.getDistances();
        return new ResponseEntity<>(distances, HttpStatus.OK);
    }
}
