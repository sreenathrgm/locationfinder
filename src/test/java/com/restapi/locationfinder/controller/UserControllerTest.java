package com.restapi.locationfinder.controller;

import com.restapi.locationfinder.model.User;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserControllerTest {

    private final static String url = "/jrt/api/v1.0";

    @Autowired
    private TestRestTemplate testRestTemplate;


    //@Test
    void users() {
        ResponseEntity responseEntity = testRestTemplate.getForEntity(url+ "/users",String.class );
        Assert.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    //@Test
    void getUser() {
        ResponseEntity responseEntity = testRestTemplate.getForEntity(url+ "/user/601fa887e3fae254bfa44def",String.class );
        Assert.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());

    }

   // @Test
    void addUser() {
        User user = new User("testFirstName","testLastName",17.385044,78.486671);
        ResponseEntity responseEntity = testRestTemplate.postForEntity(url+"/user", user, String.class);
        Assert.assertEquals(HttpStatus.NO_CONTENT,responseEntity.getStatusCode());
    }

}