package com.restapi.locationfinder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LatLong")
public class UserTest {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Double latitude;
    private Double longitude;

    
}
