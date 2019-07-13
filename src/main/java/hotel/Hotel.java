package hotel;

import enums.Brand;
import enums.Country;

public class Hotel {

    private Country hotelCountry;
    private Brand hotelName;
    private int maxCapacity;

    public Hotel(Country hotelCountry, Brand hotelName, int maxCapacity) {
        this.hotelCountry = hotelCountry;
        this.hotelName = hotelName;
        this.maxCapacity = maxCapacity;
    }

    public Country getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(Country hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public Brand getHotelName() {
        return hotelName;
    }

    public void setHotelName(Brand hotelName) {
        this.hotelName = hotelName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Hotel: " +
                hotelName.getHotelBrand() +
                ", Country of " + hotelCountry.getCountryName();
    }
}
