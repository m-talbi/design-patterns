package creational.prototype;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<AbstractHttpRequest> list = new ArrayList<>();
        var req = new GetRequest("https://www.google.com/", null);
        var req2 = req.clone();
        req2.url = "https://www.bing.com/";
        var req3 = new PostRequest("http://localhost:3000",
                "{\"name\":\"John\",\"age\":30}",
                Map.of("Content-Type", "application/json"));

        list.add(req);
        list.add(req2);
        list.add(req3);

        list.getLast().send();
    }
}
