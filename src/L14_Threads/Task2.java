package L14_Threads;

import java.util.*;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        new Worker().main();
    }
}

class Worker {

    Object lock1 = new Object();
    Object lock2 = new Object();

    Random random = new Random();
    List<Number> list1 = new LinkedList<>();
    List<Number> list2 = new LinkedList<>();

    public void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    public void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }


    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Long stop = System.currentTimeMillis();
        System.out.println("Process take: " + (stop - start) + " mills");
        System.out.println("list1= " + list1.size());
        System.out.println("list2= " + list2.size());
    }

}

