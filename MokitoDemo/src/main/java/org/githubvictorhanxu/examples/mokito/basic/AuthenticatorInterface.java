package org.githubvictorhanxu.examples.mokito.basic;

public interface AuthenticatorInterface {
    public boolean authenticateUser(String username, String password) throws EmptyCredentialsException;
}
