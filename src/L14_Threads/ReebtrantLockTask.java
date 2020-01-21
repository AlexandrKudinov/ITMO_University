package L14_Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReebtrantLockTask {


    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        Runner runner = new Runner();

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                runner.counter();
                lock.unlock();
            }
        });


        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                runner.counter();
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(runner.count);


    }


}


class Runner {

    int count;

    public void counter() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

}