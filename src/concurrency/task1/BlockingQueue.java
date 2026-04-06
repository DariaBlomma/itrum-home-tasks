package concurrency.task1;

import java.util.ArrayDeque;
import java.util.Deque;

public class BlockingQueue<T> {
    private final Deque<T> deque;
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.deque = new ArrayDeque<>();
    }

    public synchronized void enqueue(T elem) throws InterruptedException{
        while (capacity == size()) {
            wait();
        }
        deque.addLast(elem);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (deque.isEmpty()) {
            wait();
        }
        T elem = deque.removeFirst();
        notifyAll();
        return elem;
    }

    public synchronized int size() {
        return deque.size();
    }
}
