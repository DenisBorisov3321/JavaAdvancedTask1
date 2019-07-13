package threads;

import enums.Brand;
import enums.Country;
import hotel.Hotel;
import queue.Queue;
import request.HotelRequest;

import java.time.LocalDate;
import java.util.Random;

public class Producer extends Thread{

    private Random random = new Random();
    private Queue queue;
    private Country country = Country.CANADA;
    private Brand brand = Brand.HAYATT;

    public Producer(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        while (queue.getAddCount() < queue.getRequestMaxQuantity()){
            HotelRequest hotelRequest = new HotelRequest(getHotel(), getCheckinDate(),
                    random.nextInt(28), random.nextInt(getHotel().getMaxCapacity()));
            try {
                queue.addRequest(hotelRequest);
            }catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private Hotel getHotel(){
        return new Hotel(country.getRandomCountryName(), brand.getRandomHotelName(), random.nextInt(999));
    }

    private LocalDate getCheckinDate(){
        return LocalDate.now().plusDays(random.nextInt(14));
    }
}
