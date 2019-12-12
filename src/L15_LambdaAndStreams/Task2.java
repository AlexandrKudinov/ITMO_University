package L15_LambdaAndStreams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(reverse("Hello world"));;
    }

    public static String reverse(String string) {

        return Arrays.stream(string.split(" "))
                .map(s->new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
