import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.GsonBuilder;

public class App {
    public static void main(String[] args) throws Exception {

        //FAZ A CONEXÃO HTTP E PEGAR OS DADOS
        String url = "https://api.itau/open-banking/products-services/v1/personal-accounts";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        AllContent allContent = new GsonBuilder()
                .create()
                .fromJson(body, AllContent.class);



    }
}