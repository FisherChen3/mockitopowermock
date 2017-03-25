package com.javacodegeeks.mockitotutorial.basecode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

/**
 * Created by Fisher on 3/25/2017.
 */
// shorthand mock creation with annotation

@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorApplicationTest2 {

    @Mock
    private AuthenticatorInterface authenticatorMock;

    // created an instance for AuthenticatorApplication with the injected mock.
    @InjectMocks
    private AuthenticatorApplication authenticator;

    @Test
    public void testAuthenticate() {

        String username = "fisher";
        String password = "123";

        // condition
        when(authenticatorMock.authenticateUser(username, password))
                .thenReturn(false);

        // call the method to be tested
        boolean actual = authenticator.authenticate(username, password);

        //test result

        // verify if the method has been called with expected params
        verify(authenticatorMock).authenticateUser(username, password);
        // method being called times
        verify(authenticatorMock, times(1)).authenticateUser(username, password);
        verify(authenticatorMock, atLeastOnce()).authenticateUser(username, password);
        verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
        verify(authenticatorMock, atMost(1)).authenticateUser(username, password);
        // user never() - more declarative
//        verify(authenticatorMock,never()).authenticateUser(username,password);

        // verify method call order
        // first create an InOrder instance for the mock object
        InOrder inOrder = inOrder(authenticatorMock);
        inOrder.verify(authenticatorMock).foo();
        inOrder.verify(authenticatorMock).authenticateUser(username, password);

        // verification with timeout -- method level
        verify(authenticatorMock, timeout(100)).authenticateUser(username, password);
        // combine method called times and timeout
        verify(authenticatorMock, timeout(100).times(1)).authenticateUser(username, password);

        // verify result
        assertFalse(actual);
    }

    @Test(expected = EmptyCredentialsException.class)
    public void testAuthenticateEmtpyCredentialException() {


        when(authenticatorMock.authenticateUser("", ""))
                .thenThrow(new EmptyCredentialsException());
        // when won't work for methods that return void -- won't compile
//        when(authenticatorMock.foo());
//        when(authenticatorMock.authenticateUser("",""))

        authenticator.authenticate("", "");

    }

}
