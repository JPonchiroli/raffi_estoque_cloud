package com.raffi_estoque.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class EventUpdateDto {

    @NotBlank
    @Size(min = 3, max = 50)
    private String eventName;
    @FutureOrPresent
    private LocalDateTime dateTime;

    public EventUpdateDto(){}

    public EventUpdateDto(String eventName, LocalDateTime dateTime) {
        this.eventName = eventName;
        this.dateTime = dateTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
