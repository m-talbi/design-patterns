package creational.builder;

import java.util.HashMap;
import java.util.Map;

interface IHttpRequestBuilder {
    ConcreteHttpRequestBuilder buildMethod(String method);
    ConcreteHttpRequestBuilder buildPath(String path);
    ConcreteHttpRequestBuilder buildVersion(String version);
    ConcreteHttpRequestBuilder buildHost(String host);
    ConcreteHttpRequestBuilder buildHeaders(Map<String, String> headers);
    ConcreteHttpRequestBuilder buildBody(String body);
    IHttpRequest build();
}

public class ConcreteHttpRequestBuilder implements IHttpRequestBuilder {
    private String method;
    private String path;
    private String version;
    private String host;
    private final Map<String, String> headers = new HashMap<>();
    private String body;

    public ConcreteHttpRequestBuilder buildMethod(String method) {
        this.method = method;
        return this;
    }

    public ConcreteHttpRequestBuilder buildPath(String path) {
        this.path = path;
        return this;
    }

    public ConcreteHttpRequestBuilder buildVersion(String version) {
        this.version = String.format("HTTP/%s", version);
        return this;
    }

    public ConcreteHttpRequestBuilder buildHost(String host) {
        this.host = host;
        return this;
    }

    public ConcreteHttpRequestBuilder buildHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }

    public ConcreteHttpRequestBuilder buildBody(String body) {
        this.body = body;
        return this;
    }

    public IHttpRequest build() {
        return new HttpRequest(method, path, version, host, headers, body);
    }
}

