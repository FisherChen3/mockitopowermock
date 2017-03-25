package com.javacodegeeks.mockitotutorial.voidmethod;

/**
 * Created by Fisher on 3/25/2017.
 */
public class NotAuthenticatedException extends RuntimeException {

    public NotAuthenticatedException() {
        super("Could not authenticate!");
    }
}
