package L12_InputOutout;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        File file1 = new File("..\\Text.txt");
        String[] strings = textFileReader(file1);
        System.out.println(Arrays.toString(strings));
    }

    public static String[] textFileReader(File file) {
        String[] strings = new String[10];
        int i = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((strings[i] = bufferedReader.readLine()) != null) {
                System.out.println(strings[i]);
                i++;
                if (i == strings.length) {
                    strings = Arrays.copyOf(strings, strings.length * 2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        strings = Arrays.copyOf(strings, i);
        return strings;
    }
}
