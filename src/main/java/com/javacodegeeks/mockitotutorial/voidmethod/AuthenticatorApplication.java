package com.javacodegeeks.mockitotutorial.voidmethod;

/**
 * Created by Fisher on 3/25/2017.
 */
public class AuthenticatorApplication {

    private AuthenticatorInterface authenticator;

    public AuthenticatorApplication(AuthenticatorInterface authenticator) {
        this.authenticator = authenticator;
    }

    public void authenticate(String username, String password){
        this.authenticator.authenticateUser(username,password);
    }
}
