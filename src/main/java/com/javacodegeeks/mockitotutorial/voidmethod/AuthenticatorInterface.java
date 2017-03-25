package com.javacodegeeks.mockitotutorial.voidmethod;

/**
 * Created by Fisher on 3/25/2017.
 */
// this is the interface we are gong to mock
public interface AuthenticatorInterface {

    // return void, when authenticaion failed throw error
    void authenticateUser(String username, String password) throws NotAuthenticatedException;

}
