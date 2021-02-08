package com.restapi.locationfinder.exception;

public class GeoPointException extends  RuntimeException {

    public static final class Messages {
        public static final String LATITUDE_RANGE_DECIMAL = "Latitude must be in a range of -90 to 90",
                LONGITUDE_RANGE_DECIMAL = "Longitude must be in a range of -180 to 180";
    }

    public GeoPointException() {
    }

    public GeoPointException(String message) {
        super(message);
    }

    public GeoPointException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeoPointException(Throwable cause) {
        super(cause);
    }

    public GeoPointException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
