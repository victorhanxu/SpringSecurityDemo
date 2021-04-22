package org.githubvictorhanxu.examples.annotation;

import org.githubvictorhanxu.examples.mokito.annotation.AuthenticatorApplication;
import org.githubvictorhanxu.examples.mokito.annotation.AuthenticatorInterface;
import org.githubvictorhanxu.examples.mokito.annotation.EmptyCredentialsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/***
 * Mockito provides a shorthand notation, which is really expressive, to inject the mock dependencies.
 * If we want to inject dependencies with Mockito, we have to take the two things into account:
 * • Only works for class scope, not for function scope.
 * • We must run the test class with MockitoJUnitRunner.class
 * To perform the injection, Mockito tries the following ways, in order:
 * • By constructor (as we have).
 * • By setter.
 * • By class field.
 * If Mockito is unable to do the injection, the result will be a null reference to the object to be injected,
 */

@RunWith(MockitoJUnitRunner.class) // or use MockitoAnnotations.initMocks(this); in before()
public class AuthenticatorApplicationTestAnnotation {
    @Mock //mocked object, proxy by Mockito
    private AuthenticatorInterface authenticatorMock;
    @InjectMocks //create a concrete object where a mocked injection class to be injected into it
    private AuthenticatorApplication authenticator;


    @Test
    public void testAuthenticateMockInjection() throws EmptyCredentialsException {
        //MockitoAnnotations.initMocks(this); //same as @RunWith(MockitoJUnitRunner.class)
        String username = "javacodegeeks";
        String password = "s4f3 p4ssw0rd";
        when(this.authenticatorMock.authenticateUser(username, password))
                .thenReturn(true);
        boolean actual = this.authenticator.authenticate("javacodegeeks", "s4f3 p4ssw0rd");
        assertTrue(actual);
    }
}
