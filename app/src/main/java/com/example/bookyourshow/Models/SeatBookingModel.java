package com.example.bookyourshow.Models;

public class SeatBookingModel {

    private String seatNumber;

    public SeatBookingModel(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}