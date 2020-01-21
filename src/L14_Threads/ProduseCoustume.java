package L14_Threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProduseCoustume {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    costumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });


        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }

    public static void producer() {
        Random random = new Random();
        while (true) {
            int rnd = random.nextInt(100);
            try {
                queue.put(rnd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Element " + rnd+" added, size is:" + queue.size());
        }
    }

    public static void costumer() throws InterruptedException {
        while (true) {
            Thread.sleep(100);
            System.out.println("Element "+ queue.take()+ " taken, size is:"+ queue.size());
        }

    }


}
