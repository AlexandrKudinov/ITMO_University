package L14_Threads;

public class Task1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Thread.State a = Thread.currentThread().getState();
                System.out.println(a);
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            Thread.State state = thread.getState();
            System.out.println(i+" thread (before start)"+state);
            thread.start();
            System.out.println(i+ " thread (after start)"+state);
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i+ " thread (after start)"+state);

        }

    }

}
