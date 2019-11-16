package Lesson13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task1 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Александр\\Desktop\\T.txt");
        for (Map.Entry entry : wordsCounter(file).entrySet()) {
            System.out.println(entry.getKey() + ":   " + entry.getValue());
        }
        List<String>stringList = new LinkedList<>();
        stringList.add("dfaagsg");
        stringList.add("dfaagsg");
        stringList.add("dfa");
        stringList.add("dfaagsg");
        stringList.add("dfaagsg");
        stringList.add("df");
        stringList.add("dfa");
        stringList.add("d");

        for(String s:nonRepeatCollection(stringList)){
            System.out.println(s);
        }




    }

    public static Map<String, Integer> wordsCounter(File file) throws IOException {

        Map<String, Integer> wordsCounter = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String string;
            while ((string = br.readLine()) != null) {
                String[] strings = string.toLowerCase().split("[^A-Za-zА-Яа-я]");
                for (String s : strings) {
                    Integer count;
                    if (wordsCounter.containsKey(s)) {
                        count = wordsCounter.get(s);
                    } else count = 0;
                    wordsCounter.put(s, count + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return wordsCounter;
    }

    public static HashSet<String> nonRepeatCollection(List<String> stringList) throws IOException {
        HashSet<String> set = new HashSet<>();
        for (String s : stringList) {
            set.add(s);
        }
        return set;
    }
}