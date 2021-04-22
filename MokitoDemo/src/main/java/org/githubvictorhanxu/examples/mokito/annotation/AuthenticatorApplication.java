package org.githubvictorhanxu.examples.mokito.annotation;

public class AuthenticatorApplication {
    private AuthenticatorInterface authenticator;

    /*** AuthenticatorApplication constructor. ** @param authenticator Authenticator interface implementation. */
    public AuthenticatorApplication(AuthenticatorInterface authenticator) {
        this.authenticator = authenticator;
    }

    public boolean authenticate(String username, String password) throws EmptyCredentialsException {
        boolean authenticated;
        authenticated = this.authenticator.authenticateUser(username, password);
        return authenticated;
    }
}

