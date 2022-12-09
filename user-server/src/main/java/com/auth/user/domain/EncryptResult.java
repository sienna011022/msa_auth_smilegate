package com.auth.user.domain;

public class EncryptResult {
    private String encryptPassword;
    private String salt;

    public static EncryptResult of(String password, String salt) {
        return new EncryptResult(password, salt);
    }

    public EncryptResult() {
        this(null, null);
    }

    private EncryptResult(String encryptPassword, String salt) {
        this.encryptPassword = encryptPassword;
        this.salt = salt;
    }

    public String encryptPassword() {
        return encryptPassword;
    }

    public String salt() {
        return salt;
    }
}
