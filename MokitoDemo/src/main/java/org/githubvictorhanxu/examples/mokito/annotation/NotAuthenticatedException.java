package org.githubvictorhanxu.examples.mokito.annotation;

public class NotAuthenticatedException extends Exception {
    public NotAuthenticatedException() {
        super("Could not authenticate!");
    } }