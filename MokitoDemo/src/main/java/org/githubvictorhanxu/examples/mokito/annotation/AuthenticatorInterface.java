package org.githubvictorhanxu.examples.mokito.annotation;

public interface AuthenticatorInterface {
    public boolean authenticateUser(String username, String password) throws EmptyCredentialsException;
}
