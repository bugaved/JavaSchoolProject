package com.javaschool.exception;

/**
 * Created by bugav on 12.10.2017.
 */
public class UsernameNotFoundException extends RuntimeException {

    private final String username;

    public UsernameNotFoundException(String username, Throwable ex) {
        super("User <" + username + "> not found", ex);
        this.username = username;
    }

    public UsernameNotFoundException() {
        super("User not set");
        this.username = null;
    }
}
