package org.example;

import lombok.Getter;

public class User {
    @Getter
    private String username;
    private boolean hasNotification = false;

    public User(String username) {
        this.username = username;
    }

    public void setNotification() {
        this.hasNotification = true;
    }

    public boolean hasNotification() {
        return hasNotification;
    }
}
