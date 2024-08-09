package creational.builder;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest implements IHttpRequest {
    private final String method;
    private final String path;
    private final String version;
    private final String host;
    private final Map<String, String> headers;
    private final String body;

    HttpRequest(String method, String path, String version, String host, Map<String, String> headers, String body) {
        this.method = method == null ? "GET" : method;
        this.path = path == null ? "/" : path;
        this.version = version == null ? "HTTP/1.1" : version;
        this.host = host;
        this.headers = new HashMap<>(headers);
        this.body = body;
    }

    public String generatePlainTextRequest() {
        StringBuilder request = new StringBuilder();

        // First line
        // <http method> <path> <http version> - GET / HTTP/1.1
        request.append(method).append(" ")
                .append(path).append(" ")
                .append(version).append("\r\n");

        // Second line
        // Host: <domain/ip> - Host: www.example.com
        request.append("Host: ").append(host).append("\r\n");

        // Append headers
        for (var header : headers.entrySet()) {
            request.append(header.getKey()).append(": ")
                    .append(header.getValue()).append("\r\n");
        }

        // Append an empty line to indicate end of headers
        request.append("\r\n");

        // Append body if it exists
        if (body != null && !body.isEmpty()) {
            request.append(body);
        }

        return request.toString();
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public String getVersion() {
        return this.version;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public String getBody() {
        return this.body;
    }
}
