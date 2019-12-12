package L11_Generics;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        String[] strings = new String[]{"OIUO", "KJHGKJHG", "KJKKB"};
        String[] strings1 = filter(strings, new Filter1<String>() {
            @Override
            public boolean apply(String object) {
                return object.contains("O");
            }
        });
        for (String string : strings1) {
            System.out.println(string);
        }

    }

    public static <T> T[] filter(T[] array, Filter1<T> filter1) {
        for (int i = 0; i < array.length; i++) {
            if (filter1.apply(array[i])) {
                if (i == 0) {
                    array = Arrays.copyOf(array, array.length - 1);
                    break;
                }
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array = Arrays.copyOf(array, array.length - 1);
                i--;
            }
        }
        return array;
    }

}

interface Filter1<T> {
    boolean apply(T object);
}


