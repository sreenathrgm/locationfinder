package com.restapi.locationfinder;

import com.restapi.locationfinder.exception.GeoPointException;
import com.restapi.locationfinder.model.User;
import com.restapi.locationfinder.model.UserPair;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    private static final double EARTH_RADIUS_KILOMETERS = 6371.008;

    public enum Unit {

        KILOMETERS(1),

        MILES(1.0d / 1.609344d),

        NAUTICAL_MILES(1.0d / 1.852d);

        private double perKilometer;

        private Unit(final double perKilometer) {
            this.perKilometer = perKilometer;
        }
    }


    public static List<UserPair> distanceBetween2PointsLatLong(final Unit unit, User... users) {
        List<UserPair> list = new ArrayList<>();
        double distance = 0;
        User previous = users[0];

        for (int i = 1; i < users.length; i++) {
            UserPair userPair = new UserPair();
            final User current = users[i];
            if( previous == null ) throw new GeoPointException( "previous user " + (i - 1) + " is null" );
            if( current == null ) throw new GeoPointException( "current user " + i + " is null" );

            final Double latitude1 = previous.getLatitude(), latitude2 = current.getLatitude();
            final Double longitude1 = previous.getLongitude(), longitude2 = current.getLongitude();

            final double lat1 = Math.toRadians(latitude1),lat2 = Math.toRadians(latitude2),
                    lon1 = Math.toRadians(longitude1),lon2 = Math.toRadians(longitude2),
                    deltaLat = lat2 - lat1,deltaLon = lon2 - lon1;

            final double d = (2.0d * EARTH_RADIUS_KILOMETERS) * Math.asin(Math.sqrt(Math.pow(Math.sin(deltaLat / 2.0d), 2.0d)
                    + (Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(deltaLon / 2.0d), 2.0d))));

            distance += d * unit.perKilometer;
            String usersName = previous.getFirstName()+", "+current.getFirstName();
            userPair.setUserNames(usersName);
            userPair.setDistance(distance);
            list.add(userPair);
            previous = current;
        }
        return list;
    }
}
