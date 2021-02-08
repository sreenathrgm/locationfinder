package com.restapi.locationfinder.service;

import com.restapi.locationfinder.Utility;
import com.restapi.locationfinder.exception.GeoPointException;
import com.restapi.locationfinder.model.User;
import com.restapi.locationfinder.model.UserPair;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private User user1, user2;

    @Mock
    private User mockUser;


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeEach
    void setUp() {
        user1 = new User("Sreenath","P",17.385044,78.486671);
        user2 = new User("Ishan","P",19.075983,72.877655);

        MockitoAnnotations.initMocks( this );
        Mockito.when( mockUser.getLatitude() ).thenReturn( user1.getLatitude() );
        Mockito.when( mockUser.getLongitude() ).thenReturn( user2.getLongitude() );

    }

    @Test
    void distance_kilometers()  {

        final List<UserPair> distance = Utility.distanceBetween2PointsLatLong(Utility.Unit.KILOMETERS, user1, user2);
        assertEquals( 621.463146690673, distance.get(0).getDistance());
    }


    @Test
    public void distance_notequals(){

        final List<UserPair> distance = Utility.distanceBetween2PointsLatLong(Utility.Unit.KILOMETERS, user1, user2);
        assertNotEquals( 321.463146690673, distance.get(0).getDistance());
    }


}