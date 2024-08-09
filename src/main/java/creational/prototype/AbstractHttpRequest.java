package creational.prototype;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractHttpRequest {
    public String method;
    public String url;
    public String body;
    public Map<String, String> headers;

    public AbstractHttpRequest(String method, String url, String body, Map<String, String> headers) {
        this.method = method;
        this.url = url;
        this.body = body == null ? "" : body;
        this.headers = headers == null ? new HashMap<>() : headers;
    }

    public void send() throws IOException, InterruptedException {
        var request = HttpRequest
                .newBuilder()
                .method(method, HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(url));

        for (var header : headers.entrySet()) {
            request.header(header.getKey(), header.getValue());
        }

        var client = HttpClient.newHttpClient();

        var response = client.send(request.build(), HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public abstract AbstractHttpRequest clone();

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AbstractHttpRequest req)) return false;
        if (!Objects.equals(method, req.method)) return false;
        if (!Objects.equals(url, req.url)) return false;
        if (!Objects.equals(body, req.body)) return false;
        return Objects.equals(headers, req.headers);
    }
}
