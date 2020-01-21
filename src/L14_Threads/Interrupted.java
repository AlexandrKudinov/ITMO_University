package L14_Threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    if(Thread.currentThread().isInterrupted()){
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });

        thread.start();


        Thread.sleep(3000);
        thread.interrupt();

        thread.join();
    }
}
