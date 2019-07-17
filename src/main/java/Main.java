import queue.Queue;
import threads.Booker;
import threads.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue();

        final int MAX_PRODUCERS = 3;
        final int MAX_BOOKERS = 6;

        ExecutorService producerExecutorService = Executors.newFixedThreadPool(MAX_PRODUCERS);
        ExecutorService bookerExecutorService = Executors.newFixedThreadPool(MAX_BOOKERS);

        IntStream.range(0, MAX_PRODUCERS).forEach(producerThread ->
                producerExecutorService.submit(new Producer(queue)));
        IntStream.range(0, MAX_BOOKERS).forEach(bookerThread ->
                bookerExecutorService.submit(new Booker(queue)));

        producerExecutorService.shutdown();
        bookerExecutorService.shutdown();
    }
}
