package request;

import hotel.Hotel;

import java.time.LocalDate;

public class HotelRequest {

    private Hotel hotel;
    private LocalDate checkinDate;
    private int stayNights;
    private int roomNumber;

    public HotelRequest(Hotel hotel, LocalDate checkinDate, int stayNights, int roomNumber) {
        this.hotel = hotel;
        this.checkinDate = checkinDate;
        this.stayNights = stayNights;
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return hotel + ", Checkin Date: " + checkinDate +
                ", Nights: " + stayNights +
                ", Room Number: " + roomNumber;
    }
}
