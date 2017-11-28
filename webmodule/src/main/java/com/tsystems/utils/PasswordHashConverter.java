package com.tsystems.utils;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * class to hash password
 */
@Component
public class PasswordHashConverter {
    /**
     * Calculating distance between stations
     * @param password - our password
     * @return string object, hashed password
     */
    public String hashPassword(String password) {

        MessageDigest digest = null;

        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (digest != null) {
            digest.update(password.getBytes(), 0, password.length());
        }

        return new BigInteger(1, digest != null ? digest.digest() : new byte[0]).toString(16);
    }

}
