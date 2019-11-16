package Lesson9;

/*
Дан массив строк. Отсортируйте их все разными способами:
По алфавиту
По возрастанию длины
По количеству вхождений цифр в строку
Для сортировки можно использовать Arrays.sort() с параметром Comparator .
Для вывода строк из массива можно использовать Arrays.toString() .
 */


import java.util.Arrays;
import java.util.Comparator;

public class Task3 {
    public static void main(String[] args) {
        String[] strings = new String[]{"ad", "SDFAS", "asfaf", "afaf", "WEFASFASG", "ASFASFA"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Double.compare(o1.length(), o2.length());
            }
        });
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(CharContain(o1), CharContain(o2));
            }

            public int CharContain(String o1) {
                char a = 'a';
                int contain1 = 0;
                char[] o1arr = o1.toCharArray();

                for (int i = 0; i < o1arr.length; i++) {
                    if (o1arr[i] == a) {
                        contain1++;
                    }
                }
                return contain1;
            }
        });
        System.out.println(Arrays.toString(strings));
    }

}