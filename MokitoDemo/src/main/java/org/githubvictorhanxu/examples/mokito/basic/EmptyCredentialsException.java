package org.githubvictorhanxu.examples.mokito.basic;

public class EmptyCredentialsException extends Exception {
    public EmptyCredentialsException() {
        super("Empty credentials!");
    }
}