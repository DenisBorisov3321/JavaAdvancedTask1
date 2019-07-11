package hotel;

public class Hotel {

    private String hotelCountry;
    private String hotelName;
    private int maxCapacity;

    public Hotel(String hotelCountry, String hotelName, int maxCapacity) {
        this.hotelCountry = hotelCountry;
        this.hotelName = hotelName;
        this.maxCapacity = maxCapacity;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
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
                "HotelName is '" + hotelName +
                "', Country of " + hotelCountry +
                ", Capacity: " + maxCapacity +
                " rooms";
    }
}
