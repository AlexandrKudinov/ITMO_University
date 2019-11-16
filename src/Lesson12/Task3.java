package Lesson12;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        File file1 = new File("..\\Text.txt");
        System.out.println(textFileContains(file1, "Hello world! -2"));
    }

    public static boolean textFileContains(File file, String string) {
        String string1;
        int i = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((string1 = bufferedReader.readLine()) != null) {
                if (string1.equals(string)) {
                    return true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
