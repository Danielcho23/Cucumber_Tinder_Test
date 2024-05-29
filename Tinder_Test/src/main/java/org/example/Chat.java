package org.example;
import java.util.*;

public class Chat {
    private Match1 match;
    private List<String> messages;

    public Chat(Match1 match) {
        this.match = match;
        this.messages = new ArrayList<>();
    }

    public boolean sendMessage(String message) {
        messages.add(message);
        return true;
    }

    public void receiveMessage(String message) {
        messages.add(message);
    }

    public boolean hasMessage(String message) {
        return messages.contains(message);
    }

    public void deleteMessage(String message) {
        messages.remove(message);
    }
}

