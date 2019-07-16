package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import queue.Queue;

public class Booker extends Thread{

    private Queue queue;
    private static final Logger logger = LogManager.getLogger(Booker.class.getName());

    public Booker(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run(){

        while (queue.getAddCount() < queue.getRequestMaxQuantity()){
            try {
                queue.getRequest();
            } catch (InterruptedException e) {
                logger.error("Ошибка бронирования", e);
            }
        }
    }
}
