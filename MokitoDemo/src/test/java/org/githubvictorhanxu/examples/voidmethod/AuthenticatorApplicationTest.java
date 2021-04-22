package org.githubvictorhanxu.examples.voidmethod;

import org.githubvictorhanxu.examples.mokito.voidmethod.AuthenticatorApplication;
import org.githubvictorhanxu.examples.mokito.voidmethod.AuthenticatorInterface;
import org.githubvictorhanxu.examples.mokito.voidmethod.NotAuthenticatedException;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doThrow;

public class AuthenticatorApplicationTest {

    @Test(expected = NotAuthenticatedException.class)
    public void testAuthenticate() throws NotAuthenticatedException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;

        String username = "JavaCodeGeeks";
        String password = "wrong password";

        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);

        authenticator = new AuthenticatorApplication(authenticatorMock);

        doThrow(new NotAuthenticatedException())
                .when(authenticatorMock) .authenticateUser(username, password);
        authenticator.authenticate(username, password);
    }
}
