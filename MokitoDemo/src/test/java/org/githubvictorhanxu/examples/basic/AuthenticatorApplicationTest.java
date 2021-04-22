package org.githubvictorhanxu.examples.basic;

import org.githubvictorhanxu.examples.mokito.basic.AuthenticatorApplication;
import org.githubvictorhanxu.examples.mokito.basic.AuthenticatorInterface;
import org.githubvictorhanxu.examples.mokito.basic.EmptyCredentialsException;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class AuthenticatorApplicationTest {

        @Test (expected = EmptyCredentialsException.class)
        public void testAuthenticate()  throws EmptyCredentialsException{
            AuthenticatorInterface authenticatorMock;
            AuthenticatorApplication authenticator;
            String username = "JavaCodeGeeks";
            String password = "unsafePassword";

            //mocked object, proxy by Mockito
            authenticatorMock = Mockito.mock(AuthenticatorInterface.class);

            //concrete object
            authenticator = new AuthenticatorApplication(authenticatorMock);

            when(authenticatorMock.authenticateUser(username, password))
                    .thenReturn(false);

            boolean actual = authenticator.authenticate(username, password);
            assertFalse(actual);

            verify(authenticatorMock).authenticateUser(username, password);
//            verify(authenticatorMock).authenticateUser(username, "bad password");

            verify(authenticatorMock, times(1)).authenticateUser(username, password);
            verify(authenticatorMock, atLeastOnce()).authenticateUser(username, password);
            verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
            verify(authenticatorMock, atMost(1)).authenticateUser(username, password);
            //verify(authenticatorMock, never()).authenticateUser(username, password);

            //authenticatorMock is mocked, so it has to be set mock value by when() for any method execution
            when(authenticatorMock.authenticateUser("aa", "aa")).thenThrow(new EmptyCredentialsException());
            authenticator.authenticate("aa", "aa");
        }
}
