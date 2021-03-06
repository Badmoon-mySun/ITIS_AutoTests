package ru.kpfu.itis.model;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class AccountData {
    private final String email;
    private final String password;

    public AccountData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
