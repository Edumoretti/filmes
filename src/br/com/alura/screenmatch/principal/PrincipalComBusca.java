package br.com.alura.screenmatch.principal;


import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoExeception;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equals("sair")) {
            System.out.println("Digite o nome do filme para busca: ");

            busca = leitura.nextLine();

            if (busca.equals("sair")) {
                break;
            }

            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=48b3fc4d";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                System.out.println(json);



                TituloOmdb meutituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println("TituloOmdb: " + meutituloOmdb);


                Titulo meutitulo = new Titulo(meutituloOmdb);
                System.out.println("Titulo já convertido: " + meutitulo);

                titulos.add(meutitulo);

            } catch (NumberFormatException e) {
                System.out.println("aconteceu um erro");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoExeception e) {
                System.out.println("Algo de errado aconteceu");
                System.out.println(e.getMessage());
            }

            System.out.println("                                ");
            System.out.println("Titulos: " + titulos);

            FileWriter fileWriter = new FileWriter("filmes.json");
            fileWriter.write(gson.toJson(titulos));
            fileWriter.close();

            System.out.println("O programa finalizou corretamente");
        }
    }
}
