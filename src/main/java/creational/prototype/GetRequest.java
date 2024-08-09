package creational.prototype;

import java.util.Map;

public class GetRequest extends AbstractHttpRequest {

    public GetRequest(String url, Map<String, String> headers) {
        super("GET", url, null, headers);
    }

    private GetRequest(GetRequest request) {
        super(request.method, request.url, request.body, request.headers);
    }

    @Override
    public AbstractHttpRequest clone() {
        return new GetRequest(this);
    }
}

