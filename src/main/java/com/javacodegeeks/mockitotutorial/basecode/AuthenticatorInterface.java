package com.javacodegeeks.mockitotutorial.basecode;

/**
 * Created by Fisher on 3/25/2017.
 */
// this is the interface we are gong to mock
public interface AuthenticatorInterface {

    boolean authenticateUser(String username, String password) throws EmptyCredentialsException;

    void foo();

}
