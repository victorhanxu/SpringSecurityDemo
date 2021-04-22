package org.githubvictorhanxu.examples.mokito.annotation;

public class EmptyCredentialsException extends Exception {
    public EmptyCredentialsException() {
        super("Empty credentials!");
    }
}