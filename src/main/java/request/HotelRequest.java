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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public int getStayNights() {
        return stayNights;
    }

    public void setStayNights(int stayNights) {
        this.stayNights = stayNights;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "HotelRequest: " +
                "Hotel <<" + hotel +
                ">>, Checkin Date: " + checkinDate +
                ", Nights: " + stayNights +
                ", Room Number: " + roomNumber;
    }
}
