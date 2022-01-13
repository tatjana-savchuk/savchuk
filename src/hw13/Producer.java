package hw13;
import java.util.Queue;

public class Producer implements Runnable {
    private final Queue<Double> sharedQueue;
    private final int maxSize;

    public Producer(Queue<Double> sharedQueue, int maxSize) {
        this.sharedQueue = sharedQueue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("Производитель: " + produce());
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private double produce() throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.size() >= maxSize) {
                System.out.println("Производитель ждет...");
                sharedQueue.wait();
            }

            double newValue = Math.random();
            sharedQueue.add(newValue);
            sharedQueue.notifyAll();

            return newValue;
        }
    }
}
