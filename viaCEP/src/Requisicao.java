import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Requisicao {

    public ConsultaCEP BuscarCep(String cep){
        URI url = URI.create("https://viacep.com.br/ws/"+ cep +"/json/");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String>  response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConsultaCEP.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Houve um erro ao buscar o cep");
        }

    }
}
