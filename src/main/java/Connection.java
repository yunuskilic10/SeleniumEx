import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {
    public static void main(String[] args) {
        String urlString ="https://www.facebook.com/";  // Kontrol edilecek URL
        HttpURLConnection connection = null;

        try {
            URL url = new URL(urlString);
            try {
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
             connection.setRequestMethod("HEAD");

            connection.connect();

            int responseCode = connection.getResponseCode();  // Yanıt kodunu al
            System.out.println("Response Code: " + responseCode);

            // Başlık bilgilerini alma
            String contentType = connection.getHeaderField("Content-Type");
            String lastModified = connection.getHeaderField("Last-Modified");
            int contentLength = connection.getContentLength();

            System.out.println("Content-Type: " + contentType);
            System.out.println("Last-Modified: " + lastModified);
            System.out.println("Content-Length: " + contentLength);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();  // Bağlantıyı kapat
            }
        }
    }
}

