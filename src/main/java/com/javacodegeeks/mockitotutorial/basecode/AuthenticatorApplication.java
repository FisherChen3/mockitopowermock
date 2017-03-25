package com.javacodegeeks.mockitotutorial.basecode;

/**
 * Created by Fisher on 3/25/2017.
 */
public class AuthenticatorApplication {

    private AuthenticatorInterface authenticator;

    public AuthenticatorApplication(AuthenticatorInterface authenticator) {
        this.authenticator = authenticator;
    }

    public boolean authenticate(String username, String password){
        boolean authenticated;

        this.authenticator.foo();
        authenticated = this.authenticator.authenticateUser(username,password);

        return authenticated;
    }
}
