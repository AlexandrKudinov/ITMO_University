package L14_Threads;

import java.util.LinkedList;
import java.util.Queue;

public class MyProducerCostumer {
    public static void main(String[] args) throws InterruptedException {

        ProducerCostumer pc = new ProducerCostumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.costumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

class ProducerCostumer {
    public final Object lock = new Object();
    Queue<Integer> queue = new LinkedList<>();
    int queueLimit = 10;
    int currentValue = 0;

    public void producer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == queueLimit) {
                    lock.wait();
                }
                queue.offer(currentValue++);
                lock.notify();
            }
        }

    }

    public void costumer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }
                int value = queue.poll();
                System.out.println(queue.size() + "   ,    " + value);
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}


