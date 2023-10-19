import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class Utils {
    public static String getURL(String nasaUrl) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        ObjectMapper mapper = new ObjectMapper();

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(new HttpGet(nasaUrl));
            Nasa answer = mapper.readValue(response.getEntity().getContent(), Nasa.class);
            //answer.getUrl()- ссылка на картинку
            return answer.getUrl();
        } catch (IOException e) {
            System.out.println("ошибка");
        }

        return "";
    }
    public static String getDATE(String nasaUrl) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        ObjectMapper mapper = new ObjectMapper();

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(new HttpGet(nasaUrl));
            Nasa answer = mapper.readValue(response.getEntity().getContent(), Nasa.class);
            //answer.getUrl()- ссылка на картинку
            return answer.getDate();
        } catch (IOException e) {
            System.out.println("ошибка");
        }

        return "";
    }
}
