import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIeCalculo {
    public static void sendHttpGETRequest(Scanner scanner, String moedaOrigem, String moedaDestino) throws IOException {
        try {
            String endereco = "https://v6.exchangerate-api.com/v6/c96df12bd695db8fbbffd4ba/latest/" + moedaOrigem;
            URL url = new URL(endereco);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) conn.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            JsonObject taxaConversao = jsonobj.getAsJsonObject("conversion_rates");

            double CambioDaMoeda = taxaConversao.get(moedaDestino).getAsDouble();

            System.out.println("Digite o valor que deseja converter: ");
            double calculo = scanner.nextDouble();

            double valorTransformado = calculo * CambioDaMoeda;

            System.out.printf("\n");
            System.out.printf("O resultado desta conversão foi: ");
            System.out.printf("%.3f", valorTransformado);
            System.out.printf("\n");

        } catch (Exception e){
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        }

    }
}

