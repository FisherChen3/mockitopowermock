package com.javacodegeeks.mockitotutorial.basecode;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

/**
 * Created by Fisher on 3/25/2017.
 */
// Mockito.mock
public class AuthenticatorApplicationTest1 {

    @Test
    public void testAuthenticate(){
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;

        String username = "fisher";
        String password = "123";

        // mock the object
        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);

        // condition
        when(authenticatorMock.authenticateUser(username,password))
                .thenReturn(false);

        // call the method to be tested
        boolean actual = authenticator.authenticate(username, password);

        //test result

        // verify if the method has been called with expected params
        verify(authenticatorMock).authenticateUser(username,password);
        // method being called times
        verify(authenticatorMock,times(1)).authenticateUser(username,password);
        verify(authenticatorMock,atLeastOnce()).authenticateUser(username,password);
        verify(authenticatorMock,atLeast(1)).authenticateUser(username,password);
        verify(authenticatorMock,atMost(1)).authenticateUser(username,password);
        // user never() - more declarative
//        verify(authenticatorMock,never()).authenticateUser(username,password);

        // verify method call order
        // first create an InOrder instance for the mock object
        InOrder inOrder = inOrder(authenticatorMock);
        inOrder.verify(authenticatorMock).foo();
        inOrder.verify(authenticatorMock).authenticateUser(username,password);

        // verification with timeout -- method level
        verify(authenticatorMock,timeout(100)).authenticateUser(username,password);
        // combine method called times and timeout
        verify(authenticatorMock,timeout(100).times(1)).authenticateUser(username,password);

        // verify result
        assertFalse(actual);
    }

    @Test(expected = EmptyCredentialsException.class)
    public void testAuthenticateEmtpyCredentialException(){

        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;

        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);

        when(authenticatorMock.authenticateUser("",""))
                .thenThrow(new EmptyCredentialsException());

        authenticator.authenticate("","");

    }

}
