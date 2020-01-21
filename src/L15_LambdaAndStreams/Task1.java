package L15_LambdaAndStreams;

import java.util.ArrayList;
import java.util.Arrays;
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
        list.sort((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else return 0;
        });
        System.out.println(list);
        Stream stream = list.stream();
       // System.out.println(stream.max(Comparator.comparing(o -> o.toString().length())).get().toString());
        String s = "ONE"+3+2+"TWO"+"THREE"+5+4+"FOUR"+"FIVE"+5;
        System.out.println(s);

        //System.out.println(stream.findFirst().toString());
        //
        //
        // forEach(System.out::println);


    }
}
