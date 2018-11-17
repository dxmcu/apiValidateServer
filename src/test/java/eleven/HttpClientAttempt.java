package eleven;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class HttpClientAttempt {
    public static void main(String[] args) {
        HttpClient cli = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.baidu.com"))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = cli.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.statusCode());
        System.out.println(response.body());

        cli.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
