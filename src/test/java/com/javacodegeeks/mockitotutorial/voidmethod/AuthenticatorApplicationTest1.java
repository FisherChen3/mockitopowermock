package com.javacodegeeks.mockitotutorial.voidmethod;


import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doThrow;

/**
 * Created by Fisher on 3/25/2017.
 */
// Mockito.mock
public class AuthenticatorApplicationTest1 {

    @Test(expected = NotAuthenticatedException.class)
    public void testAuthenticate(){

        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;

        String username = "fisher";
        String password = "123";

        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);

        doThrow(new NotAuthenticatedException())
                .when(authenticatorMock)
                .authenticateUser(username,password);

        authenticator.authenticate(username,password);

    }

}
