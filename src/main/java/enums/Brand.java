package enums;

import java.util.Random;

public enum  Brand {
    HAYATT("Hyatt"),
    HILTON("Hilton Hotels & Resorts"),
    INTURIST("Inturist"),
    PARKINN("Park Inn by Radisson"),
    NOVOTEL("Novotel");

    private String hotelBrand;
    Random random = new Random();

    Brand(String hotelBrand){
        this.hotelBrand = hotelBrand;
    }

    public String getHotelBrand(){
        return hotelBrand;
    }

    public Brand getRandomHotelName(){
        return values()[random.nextInt(values().length)];
    }
}
