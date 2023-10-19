import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException, TelegramApiException {

        new MyTelegramBot("My_Nasa_Java_bot","6312948799:AAGN7f_UwuLPs77zbrfRmbDAV16FUJena_c");

        //Настраиваем наш HTTP клиент, который будет отправлять запросы
        //Наша ссылка, на которую будем отправлять запрос
        String url = "https://api.nasa.gov/planetary/apod?api_key=pSL3XZoHLxMvKM72ua5apboEeWRmBpWVJQXwbEdv";
       // CloseableHttpClient httpClient = HttpClients.createDefault();


       // ObjectMapper mapper = new ObjectMapper();

       // httpClient.execute(new HttpGet(url));

        //Отправляем запрос и получаем ответ

       // CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
       // Scanner sc = new Scanner(response.getEntity().getContent());
        //System.out.println(sc.nextLine());

        //Преобразуем ответ в Java-объект NasaObject
      //  Nasa answer = mapper.readValue(response.getEntity().getContent(), Nasa.class);


        //Формируем автоматически название для файла
     //   String[] answerSplit= answer.getUrl().split("/");
     //   String fileName = answerSplit[answerSplit.length - 1];

      //    Отправляем запрос и получаем ответ с нашей картинкой
      //  CloseableHttpResponse image = httpClient.execute(new HttpGet(answer.getUrl()));
      //  FileOutputStream fileOutputStream = new FileOutputStream("Image.jpg");
      //  image.getEntity().writeTo(fileOutputStream);

    }
}

