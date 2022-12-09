package com.auth.user.domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptFactory {

    private static final String ENCRYPT_ALGORITHM = "SHA-256";
    private static final String TO_TWO_HEX_LENGTH = "%02x";
    private static final int DEFAULT_LENGTH_OF_SALT = 10;
    private static final SecureRandom randomNumber = new SecureRandom();

    public static EncryptResult encrypt(String password) {
        EncryptResult encryptResult = new EncryptResult();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            MessageDigest algorithm = MessageDigest.getInstance(ENCRYPT_ALGORITHM);

            String salt = salt();
            algorithm.update((salt + password).getBytes());
            byte[] passwordWithSalt = algorithm.digest();

            encryptResult = EncryptResult.of(makePassword(stringBuilder, passwordWithSalt), salt);
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        return encryptResult;
    }

    private static String makePassword(StringBuilder stringBuilder, byte[] passwordWithSalt) {
        for (byte number : passwordWithSalt) {
            stringBuilder.append(String.format(TO_TWO_HEX_LENGTH, number));
        }
        return stringBuilder.toString();
    }

    private static String salt() {
        byte[] bytes = new byte[DEFAULT_LENGTH_OF_SALT];
        randomNumber.nextBytes(bytes);
        return new String(Base64.getEncoder().encode(bytes));
    }
}
