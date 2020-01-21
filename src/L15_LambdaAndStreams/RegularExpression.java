package L15_LambdaAndStreams;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

    public static void main(String[] args) {
        String string = "https://www.goolgle.com";

        System.out.println(string.matches("https://www\\..+\\.com"));


        String string1 = "Hello my name is Alex";
        String[] SS = string1.split(" ");
        System.out.println(Arrays.toString(SS));

        String string222 = "hELLO THIS IS A NEW BILL tim@gmail.com and for me it contain some goods bob@yandex.ru";

        Pattern pattern = Pattern.compile("\\w+@(gmail|yandex)\\.(com|ru)");
        Matcher matcher = pattern.matcher(string222);

        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
