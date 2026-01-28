package com.alura.conversormoneda;

import com.alura.calculadoraconversion.CalculadoraConversion;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Conversor {

    public static void exibirMenu() {

        Scanner lectura = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {

            System.out.println("**************************************");
            System.out.println("Sea bienvenid@ al Conversor de Moneda =]");
            System.out.println();
            System.out.println("1) Dólar a Peso argentino");
            System.out.println("2) Peso argentino a Dólar");
            System.out.println("3) Dólar a Real brasileño");
            System.out.println("4) Real brasileño a Dólar");
            System.out.println("5) Dólar a Peso colombiano");
            System.out.println("6) Peso colombiano a Dólar");
            System.out.println("7) Salir");
            System.out.println();
            System.out.println("Elija una opcion valida:");
            System.out.println("**************************************");

            opcion = lectura.nextInt();

            if (opcion == 7) {
                System.out.println("Haz dejado de interactuar con nosotros.");
                break;
            }

            System.out.println("Ingrese el valor que desea convertir:");
            double valor = lectura.nextDouble();

            Moneda origen = null;
            Moneda destino = null;

            switch (opcion) {
                case 1 -> {
                    origen = Moneda.USD;
                    destino = Moneda.ARS;
                }
                case 2 -> {
                    origen = Moneda.ARS;
                    destino = Moneda.USD;
                }
                case 3 -> {
                    origen = Moneda.USD;
                    destino = Moneda.BRL;
                }
                case 4 -> {
                    origen = Moneda.BRL;
                    destino = Moneda.USD;
                }
                case 5 -> {
                    origen = Moneda.USD;
                    destino = Moneda.COP;
                }
                case 6 -> {
                    origen = Moneda.COP;
                    destino = Moneda.USD;
                }
                default -> {
                    System.out.println("Opcion no valida.");
                    continue;
                }
            }

            String url = construirUrl(origen, destino);
            double tasa = obtenerTasa(url);
            double resultado = CalculadoraConversion.convertir(valor, tasa);

            System.out.println("El valor " + valor + " " + origen.getCodigo() +
                    " corresponde al valor final de " +
                    resultado + " " + destino.getCodigo() + " ");
            System.out.println();
        }

        lectura.close();
    }

    public static double obtenerTasa(String urlFinal) {

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(urlFinal))
                .GET()
                .build();

        try {
            HttpResponse<String> respuesta =
                    cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            JsonElement elemento = JsonParser.parseString(respuesta.body());
            JsonObject objetoJson = elemento.getAsJsonObject();

            return objetoJson.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa.");
            return 0;
        }
    }

    public static String construirUrl(Moneda origen, Moneda destino) {
        String apiKey = "bbac7527ed9064b757c2072f";
        return "https://v6.exchangerate-api.com/v6/"
                + apiKey
                + "/pair/"
                + origen.getCodigo()
                + "/"
                + destino.getCodigo();
    }
}
