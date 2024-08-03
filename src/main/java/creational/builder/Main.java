package creational.builder;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        IHttpRequestBuilder builder = new ConcreteHttpRequestBuilder();
        IHttpRequest req = builder
                .buildMethod("GET")
                .buildHost("www.stackoverflow.com")
                .build();

        String reqAsText = req.generatePlainTextRequest();
        System.out.println(reqAsText);

        try (Socket socket = new Socket(req.getHost(), 80)) {

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            writer.println(reqAsText);

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
