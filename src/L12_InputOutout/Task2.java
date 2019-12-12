package L12_InputOutout;


import java.io.*;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        File file1 = new File("..\\Text.txt");
        hashOfFile(file1);
    }

    public static void hashOfFile(File file) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file.getPath());
            int fileSize = 0;
            byte[] bytes = new byte[128];
            int bytesInFile;
            while ((bytesInFile = inputStream.read(bytes, 0, bytes.length)) != -1) {
                System.out.println(Arrays.toString(bytes));
                fileSize = (fileSize + bytesInFile) % 255;
                System.out.println(fileSize);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                if(inputStream != null){
                    try {
                        inputStream.close();
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
            }
        }

    }
}
