import hotel.Hotel;
import request.HotelRequest;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Canada", "Marriot", 999);
        System.out.println(hotel);
        HotelRequest hotelRequest = new HotelRequest(hotel, LocalDate.now(), 9, 21);
        System.out.println(hotelRequest);
    }
}
