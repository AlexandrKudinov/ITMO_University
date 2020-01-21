package L14_Threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTask {
    private static ExecutorService service = Executors.newFixedThreadPool(3);
    private static CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            service.submit(new Person(i, latch));
            Thread.sleep(1000);
        }
        service.shutdown();
        latch.await();
        System.out.println("Main tread is running");
    }
}

class Person implements Runnable {
    int id;
    CountDownLatch latch;

    public Person(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        latch.countDown();
        System.out.println("Tread id " + id + " is running, latch value is: "+latch.getCount());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}