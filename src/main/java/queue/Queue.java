package queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import request.HotelRequest;

import java.util.LinkedList;

public class Queue {

    private static final Logger logger = LogManager.getLogger(Queue.class.getName());

    private static final int REQUEST_MAX_QUANTITY = 15;
    private static final int QUEUE_MAX_VALUE = 5;

    private LinkedList<HotelRequest> hotelRequests = new LinkedList<>();
    private int addCount = 1;
    private int getCount = 1;

    public synchronized void addRequest(HotelRequest hotelRequest)throws InterruptedException{
        while (hotelRequests.size() == QUEUE_MAX_VALUE){
            logger.info("Очередь бронирования переполнена ... ожидание ... ");
            wait();
        }

        if(addCount <= REQUEST_MAX_QUANTITY){
            hotelRequests.add(hotelRequest);
            System.out.println("Предложение "+ addCount + " - " + hotelRequests.getLast() + " добавлено в очередь" +
                    " by Producer: " + Thread.currentThread().getName());
            addCount++;
            notifyAll();
        }
    }

    public synchronized void getRequest()throws InterruptedException{
        while (hotelRequests.isEmpty()){
            logger.info("Очередь бронирования пуста ... ожидание ... ");
            wait();
        }
        hotelRequests.removeFirst();
        System.out.println("Предложение " + getCount + " принято by Booker: " +
                Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("Предложение " + getCount + " забронировано by Booker: " +
                Thread.currentThread().getName());
        getCount++;
        notifyAll();
    }

    public LinkedList<HotelRequest> getHotelRequests(){
        return hotelRequests;
    }

    public int getAddCount(){
        return addCount;
    }

    public int getRequestMaxQuantity(){
        return REQUEST_MAX_QUANTITY;
    }

    @Override
    public String toString() {
        return "Очередь: " +
                "Запросы: " + hotelRequests +
                ", Добавлено запросов: " + addCount +
                ", Обработано запросов: " + getCount;
    }
}
