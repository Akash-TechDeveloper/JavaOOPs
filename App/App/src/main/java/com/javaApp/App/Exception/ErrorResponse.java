package com.javaApp.App.Exception;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime localDateTime, int status, String message) {

    public LocalDateTime getTimeStamp() {
        return localDateTime;
    }
}
