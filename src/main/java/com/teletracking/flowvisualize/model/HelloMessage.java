package com.teletracking.flowvisualize.model;

import java.time.LocalDateTime;

public final class HelloMessage {
    
    private final String message;
    private final LocalDateTime time;
    
    @SuppressWarnings("unused")
    private HelloMessage(){
        this(null);
    }
    
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
