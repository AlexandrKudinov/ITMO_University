package L15_LambdaAndStreams;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;


interface Executors {
    void execute();
}

class Runner {
    public void run(Executors executors) {
        executors.execute();
    }
}

class ExecutorsImplementation implements Executors{
    @Override
    public void execute() {
        System.out.println("hello");
    }
}


public class Task4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asdfasd");
        list.add("sdfasdfasdf");
        list.add("aa");
        list.add("adsasdasdasd");
        Runner runner = new Runner();
        runner.run(new ExecutorsImplementation());
        runner.run(new Executors() {
            @Override
            public void execute() {
                System.out.println("gggg");
            }
        });
        runner.run(()-> {
            System.out.println("sssss");
        });


    }





}
