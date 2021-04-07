package org.githubvictorhanxu.examples;

public interface AuthenticatorInterface {
    public boolean authenticateUser(String username, String password) throws EmptyCredentialsException;
}
