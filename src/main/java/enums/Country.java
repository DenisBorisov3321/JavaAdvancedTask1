package enums;

import java.util.Random;

public enum  Country {
    CANADA("Canada"),
    RUSSIA("Russia"),
    USA("United States of America"),
    CHECKIA("Chech Republic"),
    SWDEN("Sweden");

    private String countryName;
    Random random = new Random();

    Country(String countryName){
        this.countryName = countryName;
    }

    public String getCountryName(){
        return countryName;
    }

    public Country getRandomCountryName(){
        return values()[random.nextInt(values().length)];
    }
}
