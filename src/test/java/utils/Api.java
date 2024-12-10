package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Api {
    public static String gerarToken() {
        String endpoint = "https://homologendpoint.nhgtech.com.br/api/token";
        String username = "02971008312";
        String password = "Fale1234@";

        try {
            HttpURLConnection con = getHttpURLConnection(endpoint, username, password);

            int responseCode = con.getResponseCode();
            System.out.println("Gerador do token, Código de resposta: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuilder response = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }

                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
                return jsonObject.get("access_token").getAsString();
            } else {
                System.out.println("Falha na autenticação. Verifique suas credenciais.");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static @NotNull HttpURLConnection getHttpURLConnection(String endpoint, String username, String password) throws IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(endpoint).openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String dadosAutenticacao = "username=" + username + "&password=" + password + "&grant_type=password";
        byte[] postData = dadosAutenticacao.getBytes(StandardCharsets.UTF_8);
        con.setRequestProperty("Content-Length", String.valueOf(postData.length));
        con.setDoOutput(true);

        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(postData);
        }
        return con;
    }

    public void LoginTela(String cpf, String entidade) {
        try {
            String url = "https://homologendpoint.nhgtech.com.br/api/acesso/CentralPrivacidade/DeleteAceites/" + cpf + "/99/" + entidade;
            String url2 = "https://homologendpoint.nhgtech.com.br/api/acesso/vida/DeletePrimeiroAcesso/" + cpf + "/99/" + entidade;

            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            HttpURLConnection con2 = (HttpURLConnection) new URL(url2).openConnection();

            con.setRequestMethod("DELETE");
            con2.setRequestMethod("DELETE");

            String token = gerarToken();
            con.setRequestProperty("Authorization", "bearer " + token);
            con2.setRequestProperty("Authorization", "bearer " + token);

            String responseBody = getResponse(con);
            String responseBody2 = getResponse(con2);

            System.out.println("Primeiro acesso, Código de resposta: " + con.getResponseCode() + "\nBody: " + responseBody);
            System.out.println("Documento de privacidade, Código de resposta: " + con2.getResponseCode() + "\nBody: " + responseBody2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getResponse(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder responseBody = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            responseBody.append(inputLine);
        }
        in.close();
        return responseBody.toString();
    }
}