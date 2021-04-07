package org.githubvictorhanxu.examples;

public class EmptyCredentialsException extends Exception {
    public EmptyCredentialsException() {
        super("Empty credentials!");
    }
}