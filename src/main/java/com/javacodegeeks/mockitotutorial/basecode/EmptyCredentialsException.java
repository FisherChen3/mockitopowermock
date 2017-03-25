package com.javacodegeeks.mockitotutorial.basecode;

/**
 * Created by Fisher on 3/25/2017.
 */
public class EmptyCredentialsException extends RuntimeException {

    public EmptyCredentialsException() {
        super("Empty credentials!");
    }
}
