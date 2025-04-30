package com.raffi_estoque.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class EventCreateDto {

    @NotBlank
    @Size(min = 3, max = 50)
    private String eventName;
    @FutureOrPresent
    private LocalDateTime dateTime;
    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;
    @Min(value = 1)
    @NotNull
    private Double floorPriceBRL;
    @Min(value = 1)
    @NotNull
    private Double vipAreaPriceBRL;

    public EventCreateDto() {
    }

    public EventCreateDto(String eventName, LocalDateTime dateTime, String cep, Double floorPriceBRL, Double vipAreaPriceBRL) {
        this.eventName = eventName;
        this.dateTime = dateTime;
        this.cep = cep;
        this.floorPriceBRL = floorPriceBRL;
        this.vipAreaPriceBRL = vipAreaPriceBRL;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Double getFloorPriceBRL() {
        return floorPriceBRL;
    }

    public void setFloorPriceBRL(Double floorPriceBRL) {
        this.floorPriceBRL = floorPriceBRL;
    }

    public Double getVipAreaPriceBRL() {
        return vipAreaPriceBRL;
    }

    public void setVipAreaPriceBRL(Double vipAreaPriceBRL) {
        this.vipAreaPriceBRL = vipAreaPriceBRL;
    }
}