package hw13;

import java.util.Queue;

public class Consumer implements Runnable {
    private final Queue<Double> sharedQueue;

    public Consumer(Queue<Double> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Потребитель: " + consume());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                break;
            }
        }
    }

    private Double consume() throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.isEmpty()) {
                System.out.println("Потребитель ждёт...");
                sharedQueue.wait();
            }

            sharedQueue.notifyAll();
            return sharedQueue.poll();
        }
    }
}