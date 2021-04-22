package org.githubvictorhanxu.examples.mokito.voidmethod;

public interface AuthenticatorInterface {
    public void authenticateUser(String username, String password) throws NotAuthenticatedException;
}
