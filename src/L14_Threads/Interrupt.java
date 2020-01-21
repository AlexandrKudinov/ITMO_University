package L14_Threads;

public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000_000; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("I was interrupted");
                        break;
                    }

                    System.out.println("Sin: "+Math.sin(i));
                }
            }
        });


        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        thread.join();
    }
}

