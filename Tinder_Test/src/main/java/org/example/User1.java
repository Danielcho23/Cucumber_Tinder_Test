package org.example;
import lombok.Getter;

import java.util.*;

public class User1 {
    @Getter
    private List<Match1> matches;
    private boolean hasNotification;

    public User1() {
        this.matches = new ArrayList<>();
        this.hasNotification = false;
    }

    public void addMatch(Match1 match) {
        matches.add(match);
    }

    public boolean hasNotification() {
        return hasNotification;
    }

    public void setNotification(boolean hasNotification) {
        this.hasNotification = hasNotification;
    }


    public void updateNotification(boolean notification) {
        hasNotification = notification;
    }
}

