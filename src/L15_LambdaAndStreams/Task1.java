package L15_LambdaAndStreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("qwerrr");
        list.add("wfsdfsdfa");
        list.add("afdasdfsdfafa");
        list.add("a");
        list.add("aaaa");
        list.add("ssssssssssssssssssssssssssssssss");


        Stream stream = list.stream();
        System.out.println(stream.max(Comparator.comparing(o -> o.toString().length())).get().toString());

        //System.out.println(stream.findFirst().toString());
        //
        //
        // forEach(System.out::println);


    }
}
