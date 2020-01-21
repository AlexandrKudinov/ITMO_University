package L14_Threads;

import java.util.Random;
import java.util.concurrent.*;

public class RunnableAndCollable {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> future = service.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random random = new Random();

            int rnd = random.nextInt(100);

            if(rnd>90){
                throw  new Exception("SOMETHING WRONG");
            }
            return rnd;
        });

        service.shutdown();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable throwable = e.getCause();
            System.out.println(throwable.getMessage());
        }
    }
}
