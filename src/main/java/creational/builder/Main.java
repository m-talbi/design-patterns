package creational.builder;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        ConcreteHttpRequestBuilder builder = new ConcreteHttpRequestBuilder();
        HttpRequest req = (HttpRequest) builder
                .buildMethod("GET")
                .buildHost("www.stackoverflow.com")
                .build();

        String reqAsText = req.generatePlainTextRequest();
        System.out.println(reqAsText);

        try (Socket socket = new Socket(req.getHost(), 80)) {

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output);

            writer.print(reqAsText);
            writer.flush();

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
