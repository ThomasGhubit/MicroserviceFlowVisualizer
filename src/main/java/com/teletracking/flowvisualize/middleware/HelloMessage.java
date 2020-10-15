package com.teletracking.flowvisualize.example;

import java.time.LocalDateTime;

public final class HelloMessage {
    
    private final String message;
    private final LocalDateTime time;
    
    public HelloMessage(String message) {
        this.message = message;
        time = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
    
}
