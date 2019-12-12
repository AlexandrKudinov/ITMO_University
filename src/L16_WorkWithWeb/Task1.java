package L16_WorkWithWeb;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://ru.wikipedia.org/");
            URLConnection urlConnection = url.openConnection();
            System.out.println(urlConnection.getContentLength());
            System.out.println(urlConnection.getContentType());

            Map<String, List<String>> fields = urlConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> pair : fields.entrySet()) {
                System.out.println(pair.getKey() + "   " + pair.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
