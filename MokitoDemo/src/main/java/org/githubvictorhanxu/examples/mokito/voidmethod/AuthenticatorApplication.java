package org.githubvictorhanxu.examples.mokito.voidmethod;

public class AuthenticatorApplication {
    private AuthenticatorInterface authenticator;

    public AuthenticatorApplication(AuthenticatorInterface authenticator) {
        this.authenticator = authenticator;
    }

    public void authenticate(String username, String password) throws NotAuthenticatedException {
        this.authenticator.authenticateUser(username, password);
    }
}
