package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * // https://find-sec-bugs.github.io/bugs_ja.htm#WEAK_MESSAGE_DIGEST_MD5
 */
public class FindSecurityBugsError {

    public static void main(String[] args) {
        String password = "password123";
        String hash = md5(password);
        System.out.println("MD5: " + hash);
    }

    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
