import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorJson {

    public void salvaJson(ConsultaCEP cep) throws IOException {
        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("cep"+cep.cep() + ".json");
        writer.write(gson.toJson(cep));
        writer.close();
    }
}
