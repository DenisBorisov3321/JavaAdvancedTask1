package threads;

import queue.Queue;

public class Booker extends Thread{

    private Queue queue;

    public Booker(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        while (queue.getAddCount() <= queue.getRequestMaxQuantity()){
            try {
                queue.getRequest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
