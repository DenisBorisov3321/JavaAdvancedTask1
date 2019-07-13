import queue.Queue;
import threads.Booker;
import threads.Producer;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue();

        final int MAX_PRODUCERS = 3;
        final int MAX_BOOKERS = 6;

        IntStream.range(0, MAX_PRODUCERS).forEach(producerThread -> new Producer(queue).start());
        IntStream.range(0, MAX_BOOKERS).forEach(bookerThread -> new Booker(queue).start());
    }
}
