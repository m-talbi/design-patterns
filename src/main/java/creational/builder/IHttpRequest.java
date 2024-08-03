package creational.builder;

import java.util.Map;

public interface IHttpRequest {
    String generatePlainTextRequest();
    String getMethod();
    String getPath();
    String getVersion();
    String getHost();
    Map<String, String> getHeaders();
    String getBody();
}
