package L14_Threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProduserioCostumerio {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PC.costumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PC.producer();
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

class PC {
    private static Queue<Integer> queue = new LinkedList<>();
    private static int count;
    private static int MAX = 10;
    private static Object lock = new Object();
    Lock lock1 = new ReentrantLock();

    public static void producer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == MAX) {
                    lock.wait();
                }
                Thread.sleep(500);
                queue.offer(count);
                System.out.println("add: " + count + ", size is: " + queue.size());
                count++;
                lock.notify();
            }
        }
    }

    public static void costumer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }
                Thread.sleep(500);
                System.out.println("get: " + queue.poll() + ", size is: " + queue.size());
                lock.notify();
            }
        }
    }
}
