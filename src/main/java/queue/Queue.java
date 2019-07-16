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
            logger.info("Предложение "+ addCount + " <<" + hotelRequests.getLast() + ">> добавлено в очередь" +
                    " by Producer: " + Thread.currentThread().getName());
            addCount++;
            this.notifyAll();
        }else {
            logger.info("Все запросы исполнены");
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void getRequest()throws InterruptedException{

        while (!hotelRequests.isEmpty()){

            hotelRequests.removeFirst();
            logger.info("Предложение " + getCount + " принято by Booker: " +
                    Thread.currentThread().getName());
            Thread.sleep(1000);
            logger.info("Предложение " + getCount + " забронировано by Booker: " +
                    Thread.currentThread().getName());
            getCount++;
            this.notifyAll();

        }
    }

    public LinkedList<HotelRequest> getHotelRequests(){
        return hotelRequests;
    }

    public int getAddCount(){
        return addCount;
    }

    public int getGetCount(){
        return getCount;
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
