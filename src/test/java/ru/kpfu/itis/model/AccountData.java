package ru.kpfu.itis.model;

public class AccountData {
    private final String username;
    private final String password;

    public AccountData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}