package hw13;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList<Double> sharedQueue = new LinkedList<>();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Производитель");
        Thread consThread = new Thread(new Consumer(sharedQueue), "Потребитель");
        prodThread.start();
        consThread.start();

        Thread.sleep(100);

        prodThread.interrupt();
        consThread.interrupt();
    }
}
