package L15_LambdaAndStreams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MyAnnatation {
    String author() default "asdasd";
    int date() default 121;
    String purpose() default "asdfasdf";
}
