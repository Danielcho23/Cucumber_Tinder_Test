package org.example;

import lombok.Getter;

@Getter
public class Profile {
    private String username;
    private User user;

    public Profile(String username) {
        this.username = username;
        this.user = new User(username); // инициализация на обекта user
    }

    public void likeProfile(User user) {
        this.user.setNotification();
    }
}
