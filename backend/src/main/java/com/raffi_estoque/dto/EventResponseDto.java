package com.raffi_estoque.dto;

import java.time.LocalDateTime;

public class EventResponseDto {

    private String eventId;
    private String eventName;
    private LocalDateTime dateTime;
    private String cep;
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private Double floorPriceBRL;
    private Double vipAreaPriceBRL;
    private Double floorPriceUSD;
    private Double vipAreaPriceUSD;

    public EventResponseDto() {
    }

    public EventResponseDto(String eventId, String eventName, LocalDateTime dateTime, String cep, String street, String neighborhood, String city, String state, Double floorPriceBRL, Double vipAreaPriceBRL, Double floorPriceUSD, Double vipAreaPriceUSD) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.dateTime = dateTime;
        this.cep = cep;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.floorPriceBRL = floorPriceBRL;
        this.vipAreaPriceBRL = vipAreaPriceBRL;
        this.floorPriceUSD = floorPriceUSD;
        this.vipAreaPriceUSD = vipAreaPriceUSD;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Double getFloorPriceUSD() {
        return floorPriceUSD;
    }

    public void setFloorPriceUSD(Double floorPriceUSD) {
        this.floorPriceUSD = floorPriceUSD;
    }

    public Double getVipAreaPriceUSD() {
        return vipAreaPriceUSD;
    }

    public void setVipAreaPriceUSD(Double vipAreaPriceUSD) {
        this.vipAreaPriceUSD = vipAreaPriceUSD;
    }

    @Override
    public String toString() {
        return "EventResponseDto{" +
                "eventId='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                ", dateTime=" + dateTime +
                ", cep='" + cep + '\'' +
                ", street='" + street + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", floorPriceBRL=" + floorPriceBRL +
                ", vipAreaPriceBRL=" + vipAreaPriceBRL +
                ", floorPriceUSD=" + floorPriceUSD +
                ", vipAreaPriceUSD=" + vipAreaPriceUSD +
                '}';
    }
}