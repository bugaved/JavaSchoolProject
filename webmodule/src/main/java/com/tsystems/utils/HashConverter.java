package com.tsystems.utils;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by bugav on 15.10.2017.
 */
@Component
public class HashConverter {

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
